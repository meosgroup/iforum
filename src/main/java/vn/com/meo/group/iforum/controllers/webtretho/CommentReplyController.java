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
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import vn.com.meo.group.iforum.apps.base.ToolBase;
import vn.com.meo.group.iforum.controllers.BaseController;
import vn.com.meo.group.iforum.models.CommentReply;
import vn.com.meo.group.iforum.models.CommentReplyCategory;
import vn.com.meo.group.iforum.models.Website;
import vn.com.meo.group.iforum.views.dialog.JEditDialog;
import vn.com.meo.group.iforum.views.tab.general.CommentReplyTab;

/**
 *
 * @author buian
 */
public class CommentReplyController extends BaseController implements
        ActionListener, ItemListener {

    //Data

    private DefaultTableModel tableModel;
    public static DefaultComboBoxModel<CommentReplyCategory> comboBoxModel;
    //UI
    private CommentReplyTab commentReplyTab;
    private JTextArea tfComment;
    private JTextArea tfReply;
    private JComboBox<CommentReplyCategory> cbCategoryCommentReply;
    private JButton btnAdd;
    private JTable tbCommentReply;
    private JButton btnNextPage;
    private JButton btnBackPage;
    private JLabel lbCurrentPage;
    private JButton btnEdit;
    private JButton btnDelete;

    public CommentReplyController(ToolBase tb, Website website, CommentReplyTab commentReplyTab) {
        super(tb, website);
        this.commentReplyTab = commentReplyTab;

        initComponent();
        initData();
        initActionEvent();

    }

    @Override
    public void initActionEvent() {
        btnAdd.addActionListener(this);
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnNextPage.addActionListener(this);
        btnBackPage.addActionListener(this);
        cbCategoryCommentReply.addItemListener(this);
    }

    @Override
    public void initData() {
        
        for (CommentReplyCategory category : website.getCommentReplyCategorys()) {
            comboBoxModel.addElement(category);
        }
        
    }

    @Override
    public void initComponent() {
        tfComment = commentReplyTab.getTfComment();
        tfReply = commentReplyTab.getTfReply();
        btnAdd = commentReplyTab.getBtnAdd();
        btnEdit = commentReplyTab.getBtnEdit();
        btnDelete = commentReplyTab.getBtnDelete();
        btnNextPage = commentReplyTab.getBtnNextPage();
        btnBackPage = commentReplyTab.getBtnBackPage();
        lbCurrentPage = commentReplyTab.getLbCurrentPageUser();
        tbCommentReply = commentReplyTab.getTbCommentReply();
        tableModel = (DefaultTableModel) tbCommentReply.getModel();
        cbCategoryCommentReply = commentReplyTab.getCbCommentCategory();
        comboBoxModel = (DefaultComboBoxModel<CommentReplyCategory>) cbCategoryCommentReply.getModel(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            actionAddCommentReply();
            return;
        }
        if (e.getSource() == btnDelete) {
            actionDeleteCommentReply();
            return;
        }
        if(e.getSource() == btnEdit){
            actionEditCommentReply();
            return;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cbCategoryCommentReply) {
            CommentReplyCategory item = (CommentReplyCategory) cbCategoryCommentReply.getSelectedItem();
            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }
            if(item == null){
                return;
            }
            int i = 0;
            for (CommentReply commentReply : item.getCommentReplyList()) {
                Vector tmp = new Vector();
                tmp.add(i++);
                tmp.add(commentReply.getContentComment());
                tmp.add(commentReply.getContentReply());
                tmp.add(item.getName());
                tableModel.addRow(tmp);
            }

        }
    }

    private void actionAddCommentReply() {
        String comment = tfComment.getText();
        String reply = tfReply.getText();
        CommentReplyCategory item = (CommentReplyCategory) cbCategoryCommentReply.getSelectedItem();
        if (item != null) {
            if (comment.equals("") || reply.equals("")) {
                JOptionPane.showMessageDialog(commentReplyTab, "Bình luận hoặc trả lời không được bỏ trống");
            } else {
                CommentReply tmp = new CommentReply(
                        item.getCommentReplyList().size(), comment, reply);
                item.getCommentReplyList().add(tmp);
                Vector cmt = new Vector();
                cmt.add(tmp.getId());
                cmt.add(tmp.getContentComment());
                cmt.add(tmp.getContentReply());
                cmt.add(item.getName());
                tableModel.addRow(cmt);
                tfComment.setText("");
                tfReply.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(commentReplyTab, "Bạn chưa chọn loại comment");
        }
    }

    private void actionDeleteCommentReply() {
        CommentReplyCategory commentReplyCategory = (CommentReplyCategory) 
                cbCategoryCommentReply.getSelectedItem();
        int index = tbCommentReply.getSelectedRow();
        if(commentReplyCategory == null){
            JOptionPane.showMessageDialog(commentReplyTab, "Bạn chưa chọn loại comment");
            return;
        }
        if(index >= 0){
            tableModel.removeRow(index);
            commentReplyCategory.getCommentReplyList().remove(index);
            //delete in db
            JOptionPane.showMessageDialog(commentReplyTab, "Xóa thành công");
        }
    }

    private void actionEditCommentReply() {
        CommentReplyCategory commentReplyCategoryCurrent = (CommentReplyCategory) cbCategoryCommentReply.getSelectedItem();
        int row = tbCommentReply.getSelectedRow();
        CommentReply cmtCurrent = commentReplyCategoryCurrent.getCommentReplyList().get(row);
        JEditDialog.ResultEditCommentReply result = JEditDialog.showEditCommentReplyDialog(commentReplyTab, 
                commentReplyCategoryCurrent, website.getCommentReplyCategorys(), cmtCurrent);
        
        if(commentReplyCategoryCurrent.equals(result.getCommentReplyCategory())){
            tableModel.setValueAt(cmtCurrent.getContentComment(), row, 1);
            tableModel.setValueAt(cmtCurrent.getContentReply(), row, 2);
            tableModel.setValueAt(commentReplyCategoryCurrent.getName(), row, 3);
        }else{
            result.getCommentReplyCategory().getCommentReplyList().add(result.getCommentReply());
            commentReplyCategoryCurrent.getCommentReplyList().remove(row);
            tableModel.removeRow(row);
        }
        //update to db
    }

}
