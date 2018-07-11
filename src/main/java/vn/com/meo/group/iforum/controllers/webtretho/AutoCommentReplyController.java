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
import vn.com.meo.group.iforum.apps.webtretho.WebTreThoRequest;
import vn.com.meo.group.iforum.controllers.AutoExecutable;
import vn.com.meo.group.iforum.controllers.BaseController;
import vn.com.meo.group.iforum.models.Account;
import vn.com.meo.group.iforum.models.CommentReplyCategory;
import vn.com.meo.group.iforum.models.WebCategory;
import vn.com.meo.group.iforum.models.Website;
import vn.com.meo.group.iforum.views.tab.general.AutoCommentReplyTab;

/**
 *
 * @author buian
 */
public class AutoCommentReplyController extends BaseController implements ActionListener,
        ItemListener {

    private ArrayList<AutoExecutable> jobs;
    //UI
    private DefaultTableModel tableModel;
    private DefaultComboBoxModel<WebCategory> modelWebCategory;
    public static DefaultComboBoxModel<CommentReplyCategory> modelCommentCategory;
    private DefaultComboBoxModel<Integer> modelCommentCount;
    public static DefaultComboBoxModel<Account> modelUser;

    private AutoCommentReplyTab autoCommentReplyTab;
    private JCheckBox cbLinkNews;
    private JTextField tfLink;
    private JComboBox<WebCategory> cbWebcategory;
    private JTextField tfHeaderPost;
    private JTextArea tfContentPost;
    private JComboBox<CommentReplyCategory> cbCommentCategory;
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
        jobs = new ArrayList<>();
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
    }

    @Override
    public void initData() {
        for (WebCategory webCategory : website.getWebCategorys()) {
            modelWebCategory.addElement(webCategory);
        }
        for (Account user : website.getAccounts()) {
            if (user.isIsRegister()) {
                modelUser.addElement(user);
            }
        }

        for (CommentReplyCategory cmt : website.getCommentReplyCategorys()) {
            modelCommentCategory.addElement(cmt);
        }

        actionChangeCommentCount((CommentReplyCategory) cbCommentCategory.getSelectedItem());
    }

    @Override
    public void initComponent() {
        cbLinkNews = autoCommentReplyTab.getCbLinkNews();

        cbCommentCategory = autoCommentReplyTab.getCbCommentCategory();
        modelCommentCategory = (DefaultComboBoxModel<CommentReplyCategory>) cbCommentCategory.getModel();

        cbCommentCount = autoCommentReplyTab.getCbCommentCount();
        modelCommentCount = (DefaultComboBoxModel<Integer>) cbCommentCount.getModel();

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
            actionChangeCommentCount((CommentReplyCategory) cbCommentCategory.getSelectedItem());
        }
    }

    private void actionChangeCommentCount(CommentReplyCategory commentReplyCategory) {
        int count = 0;
        if (commentReplyCategory != null) {
            count = Math.min(commentReplyCategory.getCommentReplyList().size(),
                    website.getAccounts().size() - 1);
        }
        modelCommentCount.removeAllElements();
        for (int i = 0; i <= count; i++) {
            modelCommentCount.addElement(i);
        }
    }

    private void actionAddAutoComment() {
        AutoExecutable job = new AutoExecutable(toolRequest);
        if (cbLinkNews.isSelected()) {
            if (tfLink.getText().equals("")) {
                JOptionPane.showMessageDialog(autoCommentReplyTab, "Không được bỏ trống link bài viết");
                return;
            }
            job.setUrlPost(tfLink.getText());
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
            job.setUrlWebCategory(webCategory.getUrl());
            job.setTitle(titlePost);
            job.setContentPost(contentPost);
        }
        Account userPost = (Account) cbUsers.getSelectedItem();
        if (userPost == null) {
            JOptionPane.showMessageDialog(autoCommentReplyTab, "Bạn chưa chọn tài khoản post bài");
            return;
        }
        CommentReplyCategory commentReplyCategory = (CommentReplyCategory) cbCommentCategory.getSelectedItem();
        if (commentReplyCategory == null) {
            JOptionPane.showMessageDialog(autoCommentReplyTab, "Bạn chưa chọn loại bình luận");
            return;
        }
        Integer commentCount = (int) cbCommentCount.getSelectedItem();
        if (commentCount == null) {
            JOptionPane.showMessageDialog(autoCommentReplyTab, "Bạn chưa chọn số lượng bình luận");
            return;
        }

        job.setUserPost(userPost);
        job.setCommentCount(commentCount);
        job.setCommentReplyCategory(commentReplyCategory);
        Vector users = new Vector();
        for(Account user: website.getAccounts()){
            if(user.isIsRegister()){
                users.add(user);
            }
        }
        job.setUsers(users);
        jobs.add(job);
        updateJobView(jobs.size() - 1);
    }
    public void updateJobView(int i){
        if(i >=0 && i < tableModel.getRowCount()){
            tableModel.setValueAt(jobs.get(i).getUrlPost(), i, 1);
            tableModel.setValueAt(jobs.get(i).getCommentReplyCategory().getName(), i, 2);
            tableModel.setValueAt("", i, 3);
            tableModel.setValueAt(jobs.get(i).getStatusAsString(), i, 4);
            return;
        }
        if(i == tableModel.getRowCount()){
            Vector tmp = new Vector();
            tmp.add(i);
            tmp.add(jobs.get(i).getUrlPost());
            tmp.add(jobs.get(i).getCommentReplyCategory().getName());
            tmp.add("");
            tmp.add(jobs.get(i).getStatusAsString());
            tableModel.addRow(tmp);
        }
    }

    private void actionRunAutoComment() {
        int index = tbJobs.getSelectedRow();
        System.out.println(index);
        if(index >= 0){
            if(jobs.get(index).getStatus() == AutoExecutable.INIT || 
                    jobs.get(index).getStatus() == AutoExecutable.STOP){
                jobs.get(index).start();
                System.out.println("start");
            }
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
