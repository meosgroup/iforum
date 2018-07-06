/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.controllers.webtretho;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vn.com.meo.group.iforum.apps.base.ToolBase;
import vn.com.meo.group.iforum.controllers.BaseController;
import vn.com.meo.group.iforum.models.CommentReplyCategory;
import vn.com.meo.group.iforum.models.Website;
import vn.com.meo.group.iforum.views.dialog.JEditDialog;
import vn.com.meo.group.iforum.views.tab.general.CommentReplyCategoryTab;

/**
 *
 * @author buian
 */
public class CommentReplyCategoryController extends BaseController implements ActionListener{
    //DATA
    public static Vector<CommentReplyCategory> commentReplyCategorys;
    private DefaultTableModel tableModel;
    //UI
    private CommentReplyCategoryTab commentReplyCategoryTab;
    private JTextField tfCategoryName;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnNextPage;
    private JButton btnBackPage;
    private JTable tbCommentCategory;
    public CommentReplyCategoryController(ToolBase tb, Website website, 
            CommentReplyCategoryTab commentReplyCategoryTab) {
        super(tb, website);
        this.commentReplyCategoryTab = commentReplyCategoryTab;
        initComponent();
        initActionEvent();
        initData();
    }
    

    @Override
    public void initActionEvent() {
        btnAdd.addActionListener(this);
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnNextPage.addActionListener(this);
        btnBackPage.addActionListener(this);
    }

    @Override
    public void initData() {
        //
        commentReplyCategorys = getFromDB();
        tableModel = (DefaultTableModel) tbCommentCategory.getModel();
        int i=0;
        for(CommentReplyCategory category: commentReplyCategorys){
            Vector tmp = new Vector();
            tmp.add(i++);
            tmp.add(category.getName());
            tableModel.addRow(tmp);
        }
    }

    @Override
    public void initComponent() {
        tfCategoryName = commentReplyCategoryTab.getTfName();
        btnAdd  = commentReplyCategoryTab.getBtnAdd();
        btnEdit = commentReplyCategoryTab.getBtnEdit();
        btnDelete = commentReplyCategoryTab.getBtnDelete();
        btnBackPage = commentReplyCategoryTab.getBtnBackPage();
        btnNextPage = commentReplyCategoryTab.getBtnNextPage();
        tbCommentCategory = commentReplyCategoryTab.getTbCommentCategory();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAdd){
            actionAddCommentCategory();
            return;
        }
        if(e.getSource() == btnDelete){
            actionDeleteCategory();
            return;
        }
        if(e.getSource() == btnEdit){
            actionEditCategory();
            return;
        }
    }
    private Vector<CommentReplyCategory> getFromDB() {
        commentReplyCategorys = new Vector<>();
        commentReplyCategorys.add(new CommentReplyCategory(1, "Mua bán"));
        return commentReplyCategorys;
    }
    private void actionAddCommentCategory(){
        String category = tfCategoryName.getText();
        CommentReplyCategory tmp = new CommentReplyCategory(tableModel.getRowCount(), category);
        if(commentReplyCategorys.contains(tmp)){
            JOptionPane.showMessageDialog(commentReplyCategoryTab, "Đã tồn tại");
        }else{
            commentReplyCategorys.add(tmp);
            Vector row = new Vector();
            row.add(tmp.getId());
            row.add(tmp.getName());
            tableModel.addRow(row);
            tfCategoryName.setText("");
            CommentReplyController.comboBoxModel.addElement(tmp);
            //add to db
            JOptionPane.showMessageDialog(commentReplyCategoryTab, "Thêm thành công");
        }
    }
    private void actionDeleteCategory() {
        int index = tbCommentCategory.getSelectedRow();
        if(index >= 0){
            tableModel.removeRow(index);
            commentReplyCategorys.remove(index);
            if(index == 0){
                CommentReplyController.comboBoxModel.removeAllElements();
            }else{
                CommentReplyController.comboBoxModel.removeElementAt(index);
            }
            
            //delete from db
            JOptionPane.showMessageDialog(commentReplyCategoryTab, "Xóa thành công");
        }
    }

    private void actionEditCategory() {
        int index = tbCommentCategory.getSelectedRow();
        if(index >= 0){
            CommentReplyCategory tmp = JEditDialog.showEditCommentReplyCategoryDialog(commentReplyCategoryTab);
            if(tmp != null){
                //change db
                //change table
                tableModel.setValueAt(tmp.getName(), index, 1);
                commentReplyCategorys.get(index).setName(tmp.getName());
            }
        }
    }
}
