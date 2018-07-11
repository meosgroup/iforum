/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.views.dialog;

import java.awt.Component;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import vn.com.meo.group.iforum.models.Account;
import vn.com.meo.group.iforum.models.CommentReply;
import vn.com.meo.group.iforum.models.CommentReplyCategory;

/**
 *
 * @author buian
 */
public class JEditDialog {

    public static Account showEditAccountDialog(Component parent, Account account){
        EditAccountDialog edit = new EditAccountDialog();
        JTextField tfUsername = edit.getTfUsername();
        tfUsername.setText(account.getUsername());
        
        JTextField tfEmail = edit.getTfEmail();
        tfEmail.setText(account.getEmail());
        
        JTextField tfPassword = edit.getTfPassword();
        tfPassword.setText(account.getPassword());
        
        JCheckBox cbIsRegister = edit.getCbIsRegister();
        cbIsRegister.setSelected(account.isIsRegister());
        
        final JComponent[] inputs = new JComponent[]{edit};
        int result = JOptionPane.showConfirmDialog(parent, inputs, "Sửa loại tài khoản", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Account tmp = new Account(0, tfUsername.getText(), tfPassword.getText(),
                    tfEmail.getText(), cbIsRegister.isSelected());
            return tmp;
        }
        return null;
    }
    public static CommentReplyCategory showEditCommentReplyCategoryDialog(Component parent, 
            CommentReplyCategory commentReplyCategory) {
        EditCommentReplyCategoryDialog edit = new EditCommentReplyCategoryDialog();
        edit.getTfCommentCategory().setText(commentReplyCategory.getName());
        final JComponent[] inputs = new JComponent[]{edit};
        int result = JOptionPane.showConfirmDialog(parent, inputs, "Sửa loại bình luận", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return new CommentReplyCategory(0, edit.getTfCommentCategory().getText());
        }
        return null;
    }
    
    public static ResultEditCommentReply showEditCommentReplyDialog(Component parent, 
            CommentReplyCategory cmtRCurrent, Vector<CommentReplyCategory> commentReplyCategorys,
            CommentReply cmt){
        
        EditCommentReplyDialog edit = new EditCommentReplyDialog();
        final JComponent[] inputs = new JComponent[]{edit};
        JTextArea tfComment = edit.getTfComment();
        tfComment.setText(cmt.getContentComment());
        JTextArea tfReply = edit.getTfReply();
        tfReply.setText(cmt.getContentReply());
        JComboBox<CommentReplyCategory> cbCommentReplyCategory = edit.getCbCommentCategory();
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cbCommentReplyCategory.getModel();
        for(CommentReplyCategory category: commentReplyCategorys){
            comboBoxModel.addElement(category);
        }
        cbCommentReplyCategory.setSelectedItem(cmtRCurrent);
        int result = JOptionPane.showConfirmDialog(parent, inputs, "Sửa bình luận", JOptionPane.OK_CANCEL_OPTION);
        CommentReplyCategory cmtReplyC = (CommentReplyCategory) cbCommentReplyCategory.getSelectedItem();
        cmt.setContentComment(tfComment.getText());
        cmt.setContentReply(tfReply.getText());
        return new ResultEditCommentReply(cmt, (CommentReplyCategory) cbCommentReplyCategory.getSelectedItem());
    }
    
    public static class ResultEditCommentReply{
        private CommentReply commentReply;
        private CommentReplyCategory commentReplyCategory;

        public ResultEditCommentReply(CommentReply commentReply, CommentReplyCategory commentReplyCategory) {
            this.commentReply = commentReply;
            this.commentReplyCategory = commentReplyCategory;
        }

        public CommentReply getCommentReply() {
            return commentReply;
        }

        public CommentReplyCategory getCommentReplyCategory() {
            return commentReplyCategory;
        }
    }
}
