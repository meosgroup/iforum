/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.views.dialog;

import java.awt.Component;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import vn.com.meo.group.iforum.models.CommentReply;
import vn.com.meo.group.iforum.models.CommentReplyCategory;

/**
 *
 * @author buian
 */
public class JEditDialog {

    
    public static CommentReplyCategory showEditCommentReplyCategoryDialog(Component parent) {
        EditCommentReplyCategoryDialog edit = new EditCommentReplyCategoryDialog();
        final JComponent[] inputs = new JComponent[]{edit};
        CommentReplyCategory tmp = null;
        int result = JOptionPane.showConfirmDialog(parent, inputs, "Sửa loại bình luận", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            tmp = new CommentReplyCategory(0, edit.getTfCommentCategory().getText());
        }
        return tmp;
    }
    
    public static CommentReply showEditCommentReplyDialog(Component parent, 
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
        int result = JOptionPane.showConfirmDialog(parent, inputs, "Sửa bình luận", JOptionPane.OK_CANCEL_OPTION);
        
        CommentReplyCategory cmtReplyC = (CommentReplyCategory) cbCommentReplyCategory.getSelectedItem();
        if(cmtReplyC.equals(cmtRCurrent)){
            
        }else{
            
        }
        return null;
    }
}
