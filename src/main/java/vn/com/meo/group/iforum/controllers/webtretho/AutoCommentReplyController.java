/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.controllers.webtretho;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vn.com.meo.group.iforum.apps.base.ToolBase;
import vn.com.meo.group.iforum.controllers.AutoPostExecutable;
import vn.com.meo.group.iforum.controllers.BaseController;
import vn.com.meo.group.iforum.models.Account;
import vn.com.meo.group.iforum.models.AutoPost;
import vn.com.meo.group.iforum.models.CommentCategory;
import vn.com.meo.group.iforum.models.WebCategory;
import vn.com.meo.group.iforum.models.Website;
import vn.com.meo.group.iforum.views.tab.general.AutoCommentReplyTab;

/**
 *
 * @author buian
 */
public class AutoCommentReplyController extends BaseController implements ActionListener,
        ItemListener {

    private static ArrayList<WebtrethoAutoPostExecutable> jobs;
    //UI
    private static DefaultTableModel tableModel;
    private DefaultComboBoxModel<WebCategory> modelWebCategory;
    public static DefaultComboBoxModel<CommentCategory> modelCommentCategory;
    public static DefaultComboBoxModel<Account> modelUser;

    private AutoCommentReplyTab autoCommentReplyTab;
    private JCheckBox cbLinkNews;
    private JTextField tfLink;
    private JComboBox<WebCategory> cbWebcategory;
    private JTextField tfHeaderPost;
    private JTextArea tfContentPost;
    private JComboBox<CommentCategory> cbCommentCategory;
    private JComboBox<Integer> cbCommentCount;
    private JComboBox<Account> cbUsers;
    private JTable tbJobs;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnRun;
    private JButton btnNextPage;
    private JButton btnBackPage;

    public AutoCommentReplyController(ToolBase tb, Website website, AutoCommentReplyTab tab) {
        super(tb, website);
        this.autoCommentReplyTab = tab;
        jobs = new ArrayList<WebtrethoAutoPostExecutable>();
        initComponent();
        initData();
        initActionEvent();
    }

    @Override
    public void initActionEvent() {
        cbCommentCategory.addItemListener(this);
        cbUsers.addItemListener(this);
        btnAdd.addActionListener(this);
//        btnRun.addActionListener(this);
        btnDelete.addActionListener(this);
        btnEdit.addActionListener(this);
    }

    @Override
    public void initData() {
        for (WebCategory webCategory : website.getWebCategorys()) {
            modelWebCategory.addElement(webCategory);
        }
        for (Account user : website.getAccounts()) {
            if (user.getStatus() == Account.IS_REGISTER) {
                modelUser.addElement(user);
            }
        }

        for (CommentCategory cmt : website.getCommentReplyCategorys()) {
            modelCommentCategory.addElement(cmt);
        }

        actionChangeCommentCount((CommentCategory) cbCommentCategory.getSelectedItem());
    }

    @Override
    public void initComponent() {
        cbLinkNews = autoCommentReplyTab.getCbLinkNews();

        cbCommentCategory = autoCommentReplyTab.getCbCommentCategory();
        modelCommentCategory = (DefaultComboBoxModel<CommentCategory>) cbCommentCategory.getModel();
        cbUsers = autoCommentReplyTab.getCbUsers();
        modelUser = (DefaultComboBoxModel<Account>) cbUsers.getModel();

        cbWebcategory = autoCommentReplyTab.getCbWebCategory();
        modelWebCategory = (DefaultComboBoxModel<WebCategory>) cbWebcategory.getModel();

        tbJobs = autoCommentReplyTab.getTbJobs();
        tableModel = (DefaultTableModel) tbJobs.getModel();
        tfContentPost = autoCommentReplyTab.getTfContentPost();
        tfHeaderPost = autoCommentReplyTab.getTfHeaderPost();
        tfLink = autoCommentReplyTab.getTfLink();
        btnAdd = autoCommentReplyTab.getBtnAdd();
        btnDelete = autoCommentReplyTab.getBtnDelete();
        btnEdit = autoCommentReplyTab.getBtnEdit();
        btnRun = autoCommentReplyTab.getBtnRun();
        btnRun.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionRunAutoComment();
            }
        });
        btnNextPage = autoCommentReplyTab.getBtnNextPage();
        btnBackPage = autoCommentReplyTab.getBtnBackPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            actionAddAutoComment();
            return;
        }
        if(e.getSource() == btnDelete){
            actionDeleteAutoComment();
            return;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cbCommentCategory || e.getSource() == cbUsers) {
            actionChangeCommentCount((CommentCategory) cbCommentCategory.getSelectedItem());
        }
    }

    private void actionChangeCommentCount(CommentCategory commentReplyCategory) {
        int count = 0;
        if (commentReplyCategory != null) {
            count = Math.min(commentReplyCategory.getCommentReplyList().size(),
                    website.getAccounts().size() - 1);
        }
    }

    private void actionAddAutoComment() {
        WebtrethoAutoPostExecutable job = new WebtrethoAutoPostExecutable(toolRequest, website.getUsersIsRegister());
        if (cbLinkNews.isSelected()) {
            if (tfLink.getText().equals("")) {
                JOptionPane.showMessageDialog(autoCommentReplyTab, "Không được bỏ trống link bài viết");
                return;
            }
            job.setUrl(tfLink.getText());
        } else {
            WebCategory webCategory = (WebCategory) cbWebcategory.getSelectedItem();
            if(webCategory == null){
                JOptionPane.showMessageDialog(autoCommentReplyTab, "Bạn chưa chọn chuyên mục đăng bài");
                return;
            }
            String titlePost = tfHeaderPost.getText();
            if(titlePost.equals("")){
                JOptionPane.showMessageDialog(autoCommentReplyTab, "Tiều đề bài viết không được bỏ trống");
                return;
            }
            String contentPost = tfContentPost.getText();
            if(contentPost.equals("")){
                JOptionPane.showMessageDialog(autoCommentReplyTab, "Nội dung bài viết không được bỏ trống");
                return;
            }
//            job.setUrlWebCategory(webCategory.getUrl());
            job.getAutoPost().setWebCategory(webCategory);
            job.getAutoPost().setTitle(titlePost);
            job.getAutoPost().setContent(contentPost);
        }
        Account userPost = (Account) cbUsers.getSelectedItem();
        if (userPost == null) {
            JOptionPane.showMessageDialog(autoCommentReplyTab, "Bạn chưa chọn tài khoản post bài");
            return;
        }
        CommentCategory commentReplyCategory = (CommentCategory) cbCommentCategory.getSelectedItem();
        if (commentReplyCategory == null) {
            JOptionPane.showMessageDialog(autoCommentReplyTab, "Bạn chưa chọn loại bình luận");
            return;
        }

        job.getAutoPost().setUserPost(userPost);
        job.getAutoPost().setCommentCategory(commentReplyCategory);

        jobs.add(0, job);
        Vector rowJ = new Vector();
        rowJ.add(jobs.size());
        rowJ.add("");
        rowJ.add("");
        rowJ.add("");
        rowJ.add("");
        tableModel.insertRow(0, rowJ);
        updateUI(job);
    }
    public static void updateUI(WebtrethoAutoPostExecutable au){
        
        int i = jobs.indexOf(au);
        if(i >=0){
            AutoPost autoPost = au.getAutoPost();
            String url = String.format("<html><a href=\"%s\"><lable>%s<lable></a></html>", autoPost.getUrl(), autoPost.getUrl());
            tableModel.setValueAt(url, i, 1);
            tableModel.setValueAt("<html>" + autoPost.getCommentCategory().getName() + "</html>", i, 2);
            String tmp = "";
            if(autoPost.getLastComment() != null && autoPost.getLastUserComment()!= null){
                tmp = String.format("<html>%s: %s<br>%s: %s<br>Time: %s</html>", 
                        autoPost.getLastUserComment().getUsername(), autoPost.getLastComment().getContentComment(),
                        autoPost.getUserPost().getUsername(), autoPost.getLastComment().getContentReply(),
                        new Date(autoPost.getLastTimeComment()).toString());
            }
            tableModel.setValueAt(tmp, i, 3);
            tableModel.setValueAt("<html>" + autoPost.getStatus() + "</html>", i, 4);
            return;
        }
    }

    private void actionRunAutoComment() {
        int index = tbJobs.getSelectedRow();
        if(index >= 0){
            if(jobs.get(index).getAutoPost().getStatus().equals(AutoPost.INIT)|| 
                    jobs.get(index).getAutoPost().getStatus().equals(AutoPost.PAUSE)){
                jobs.get(index).start();
                System.out.println("start");
            }
        }else{
            JOptionPane.showMessageDialog(autoCommentReplyTab, "Bạn chưa chọn task");
        }
    }

    private void actionDeleteAutoComment() {
        int index = tbJobs.getSelectedRow();
        if(index >=0){
            tableModel.removeRow(index);
            jobs.remove(index);
            JOptionPane.showMessageDialog(autoCommentReplyTab, "Xóa thành công");
        }
    }
}
