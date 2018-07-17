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
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import vn.com.meo.group.iforum.apps.base.ToolBase;
import vn.com.meo.group.iforum.dao.CommentDao;
import vn.com.meo.group.iforum.controllers.BaseController;
import vn.com.meo.group.iforum.models.Comment;
import vn.com.meo.group.iforum.models.CommentCategory;
import vn.com.meo.group.iforum.models.Website;
import vn.com.meo.group.iforum.views.dialog.JEditDialog;
import vn.com.meo.group.iforum.views.tab.general.CommentReplyTab;

/**
 *
 * @author buian
 */
public class CommentReplyController extends BaseController implements
        ActionListener, ItemListener {

    //DAO
    private CommentDao commentDao;
    //Data

    private DefaultTableModel tableModel;
    public static DefaultComboBoxModel<CommentCategory> comboBoxModel;
    //UI
    private CommentReplyTab commentReplyTab;
    private JTextArea tfComment;
    private JTextArea tfReply;
    private JComboBox<CommentCategory> cbCategoryCommentReply;
    private JButton btnAdd;
    private JTable tbCommentReply;
    private JButton btnNextPage;
    private JButton btnBackPage;
    private JLabel lbCurrentPage;
    private JButton btnEdit;
    private JButton btnDelete;

    public CommentReplyController(ToolBase tb, Website website, CommentReplyTab commentReplyTab,
            CommentDao commentDao) {
        super(tb, website);
        this.commentReplyTab = commentReplyTab;
        this.commentDao = commentDao;
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

        for (CommentCategory category : website.getCommentReplyCategorys()) {
            comboBoxModel.addElement(category);
        }
        showCommentToTable((CommentCategory) cbCategoryCommentReply.getSelectedItem());

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
        comboBoxModel = (DefaultComboBoxModel<CommentCategory>) cbCategoryCommentReply.getModel();
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
        if (e.getSource() == btnEdit) {
            actionEditCommentReply();
            return;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cbCategoryCommentReply) {
            CommentCategory item = (CommentCategory) cbCategoryCommentReply.getSelectedItem();
            showCommentToTable(item);
        }
    }

    private void showCommentToTable(CommentCategory item) {
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }
        if (item == null) {
            return;
        }
        int i = 0;
        for (Comment commentReply : item.getCommentReplyList()) {
            Vector tmp = new Vector();
            tmp.add(i++);
            tmp.add(commentReply.getContentComment());
            tmp.add(commentReply.getContentReply());
            tmp.add(item.getName());
            tableModel.addRow(tmp);
        }
    }

    private void actionAddCommentReply() {
        String comment = tfComment.getText();
        String reply = tfReply.getText();
        CommentCategory item = (CommentCategory) cbCategoryCommentReply.getSelectedItem();
        if (item != null) {
            if (comment.equals("") || reply.equals("")) {
                JOptionPane.showMessageDialog(commentReplyTab, "Bình luận hoặc trả lời không được bỏ trống");
            } else {
                Comment tmp = new Comment(
                        0, comment, reply);
                try {
                    tmp = commentDao.addComment(tmp, item.getId());
                    Vector cmt = new Vector();
                    cmt.add(item.getCommentReplyList().size());
                    cmt.add(tmp.getContentComment());
                    cmt.add(tmp.getContentReply());
                    cmt.add(item.getName());
                    tableModel.addRow(cmt);
                    tfComment.setText("");
                    tfReply.setText("");
                    item.getCommentReplyList().add(tmp);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(commentReplyTab, "Add database error");
                    Logger.getLogger(CommentReplyController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {
            JOptionPane.showMessageDialog(commentReplyTab, "Bạn chưa chọn loại comment");
        }
    }

    private void actionDeleteCommentReply() {
        CommentCategory commentReplyCategory = (CommentCategory) cbCategoryCommentReply.getSelectedItem();
        int index = tbCommentReply.getSelectedRow();
        if (commentReplyCategory == null) {
            JOptionPane.showMessageDialog(commentReplyTab, "Bạn chưa chọn loại comment");
            return;
        }
        if (index >= 0) {
            try {
                commentDao.deleteComment(commentReplyCategory.getCommentReplyList().get(index));
                tableModel.removeRow(index);
                commentReplyCategory.getCommentReplyList().remove(index);
                JOptionPane.showMessageDialog(commentReplyTab, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(commentReplyTab, "Delete database error");
                Logger.getLogger(CommentReplyController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void actionEditCommentReply() {
        CommentCategory commentReplyCategoryCurrent = (CommentCategory) cbCategoryCommentReply.getSelectedItem();
        int row = tbCommentReply.getSelectedRow();
        if (row < 0) {
            return;
        }
        Comment cmtCurrent = commentReplyCategoryCurrent.getCommentReplyList().get(row);
        JEditDialog.ResultEditCommentReply result = JEditDialog.showEditCommentReplyDialog(commentReplyTab,
                commentReplyCategoryCurrent, website.getCommentReplyCategorys(), cmtCurrent);

        if (commentReplyCategoryCurrent.equals(result.getCommentReplyCategory())) {
            try {
                commentDao.editComment(cmtCurrent, commentReplyCategoryCurrent.getId());
                tableModel.setValueAt(cmtCurrent.getContentComment(), row, 1);
                tableModel.setValueAt(cmtCurrent.getContentReply(), row, 2);
                tableModel.setValueAt(commentReplyCategoryCurrent.getName(), row, 3);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(commentReplyTab, "Update database error");
                Logger.getLogger(CommentReplyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                commentDao.editComment(cmtCurrent, result.getCommentReplyCategory().getId());
                result.getCommentReplyCategory().getCommentReplyList().add(result.getCommentReply());
                commentReplyCategoryCurrent.getCommentReplyList().remove(row);
                tableModel.removeRow(row);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(commentReplyTab, "Update database error");
                Logger.getLogger(CommentReplyController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //update to db
    }

}
