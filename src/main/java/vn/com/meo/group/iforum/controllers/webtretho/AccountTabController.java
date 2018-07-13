/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.controllers.webtretho;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vn.com.meo.group.iforum.apps.dao.AccountDao;
import vn.com.meo.group.iforum.apps.webtretho.WebTreThoRequest;
import vn.com.meo.group.iforum.controllers.BaseController;
import vn.com.meo.group.iforum.models.Account;
import vn.com.meo.group.iforum.models.Website;
import vn.com.meo.group.iforum.views.dialog.JEditDialog;
import vn.com.meo.group.iforum.views.tab.general.AccountTab;

/**
 *
 * @author buian
 */
public class AccountTabController extends BaseController implements ActionListener {

    //DAO
    private AccountDao accountDao;
    private DefaultTableModel tableModel;
    //ui
    private AccountTab accountTab;
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JTextField tfEmail;
    private JButton btnAdd;
    private JButton btnRegistry;
    private JButton btnEdit;
    private JButton btnDelete;
    private JCheckBox cbIsRegistry;
    private JTable tbUsers;
    private JButton btnNextPage;
    private JButton btnBackPage;
    private JLabel lbCurrentPage;

    public AccountTabController(WebTreThoRequest toolRequest, Website website,
            AccountTab accountTab, AccountDao accountDao) {
        super(toolRequest, website);
        this.accountTab = accountTab;
        this.accountDao = accountDao;
        initComponent();
        initData();
        initActionEvent();
    }

    @Override
    public void initData() {
        int i = 0;
        for (Account account : website.getAccounts()) {
            Vector tmp = new Vector();
            tmp.add(i++);
            tmp.add(account.getUsername());
            tmp.add(account.getPassword());
            tmp.add(account.isIsRegister());
            tableModel.addRow(tmp);
        }
    }

    @Override
    public void initActionEvent() {
        btnAdd.addActionListener(this);
        btnRegistry.addActionListener(this);
        btnDelete.addActionListener(this);
        btnEdit.addActionListener(this);
        btnBackPage.addActionListener(this);
        btnNextPage.addActionListener(this);
    }

    private void actionAddUser() {
        String email = tfEmail.getText();
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        boolean isRegister = cbIsRegistry.isSelected();
        if (!username.equals("") && !password.equals("")) {
            Account tmp = new Account(0, username, password, email, isRegister);
            if (website.getAccounts().contains(tmp)) {
                JOptionPane.showMessageDialog(accountTab, "Tài khoản đã tồn tại");
            } else {
                Vector v = null;
                if (isRegister) {
                    toolRequest.logout();
                    toolRequest.login(username, password);
                    if (username.equals(this.toolRequest.isLogin())) {
                        try {
                            tmp = accountDao.addAccount(tmp, website.getId());
                            v = new Vector();
                            v.add(tableModel.getRowCount());
                            v.add(tmp.getUsername());
                            v.add(tmp.getPassword());
                            v.add(tmp.isIsRegister());
                            website.getAccounts().add(tmp);
                            AutoCommentReplyController.modelUser.addElement(tmp);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(accountTab, "add database error");
                            Logger.getLogger(AccountTabController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(accountTab, "Tài khoản hoặc mật khẩu không đúng");
                    }
                } else {
                    if (email.equals("")) {
                        JOptionPane.showMessageDialog(accountTab, "Email không được bỏ trống");
                        return;
                    }
                    try {
                        tmp = accountDao.addAccount(tmp, website.getId());
                        v = new Vector();
                        v.add(tableModel.getRowCount());
                        v.add(tmp.getUsername());
                        v.add(tmp.getPassword());
                        v.add(tmp.isIsRegister());
                        website.getAccounts().add(tmp);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(accountTab, "add database error");
                        Logger.getLogger(AccountTabController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                if (v != null) {
                    tfUsername.setText("");
                    tfEmail.setText("");
                    tfPassword.setText("");
                    tableModel.addRow(v);
                    JOptionPane.showMessageDialog(accountTab, "Thêm thành công");
                }
            }
        } else {
            JOptionPane.showMessageDialog(accountTab, "Tài khoản và mật khẩu không được bỏ trống");
        }
    }

    private void actionRegistry() {

    }

    @Override
    public void initComponent() {
        tfUsername = accountTab.getTfUsername();
        tfPassword = accountTab.getTfPassword();
        tfEmail = accountTab.getTfEmail();
        btnAdd = accountTab.getBtnAdd();
        btnRegistry = accountTab.getBtnRegistry();
        btnEdit = accountTab.getBtnEdit();
        btnDelete = accountTab.getBtnDelete();
        btnNextPage = accountTab.getBtnNextPage();
        btnBackPage = accountTab.getBtnBackPage();
        tbUsers = accountTab.getTbUsers();
        tableModel = (DefaultTableModel) tbUsers.getModel();
        lbCurrentPage = accountTab.getLbCurrentPage();
        cbIsRegistry = accountTab.getCbUserIsRegister();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            actionAddUser();
            return;
        }

        if (e.getSource() == btnRegistry) {
            actionRegistry();
            return;
        }

        if (e.getSource() == btnDelete) {
            actionDeleteUser();
            return;
        }

        if (e.getSource() == btnEdit) {
            actionEditUser();
            return;
        }
    }

    private void actionDeleteUser() {
        int index = tbUsers.getSelectedRow();

        if (index >= 0) {
            try {
                //delete from db
                accountDao.deleteAccount(website.getAccounts().get(index));
                AutoCommentReplyController.modelUser.removeElementAt(index);
                website.getAccounts().remove(index);
                tableModel.removeRow(index);
                JOptionPane.showMessageDialog(accountTab, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(accountTab, "delete database error");
                Logger.getLogger(AccountTabController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void actionEditUser() {
        int index = tbUsers.getSelectedRow();
        if (index >= 0) {
            Account accountCurrent = website.getAccounts().get(index);
            Account tmp = JEditDialog.showEditAccountDialog(accountTab, accountCurrent);
            if (tmp != null) {
                int indexOf = website.getAccounts().indexOf(tmp);
                if (indexOf < 0 || indexOf == index) {
                    accountCurrent.setEmail(tmp.getEmail());
                    accountCurrent.setUsername(tmp.getUsername());
                    accountCurrent.setPassword(tmp.getPassword());
                    if (accountCurrent.isIsRegister() != tmp.isIsRegister()) {
                        if (tmp.isIsRegister()) {//add to account auto
                            accountCurrent.setIsRegister(tmp.isIsRegister());
                            AutoCommentReplyController.modelUser.addElement(accountCurrent);
                        } else {//remove account auto
                            accountCurrent.setIsRegister(tmp.isIsRegister());
                            AutoCommentReplyController.modelUser.removeElement(accountCurrent);
                        }
                    }
                    accountCurrent.setIsRegister(tmp.isIsRegister());
                    try {
                        accountDao.editAccount(accountCurrent);
                        tableModel.setValueAt(tmp.getUsername(), index, 1);
                        tableModel.setValueAt(tmp.getPassword(), index, 2);
                        tableModel.setValueAt(tmp.isIsRegister(), index, 3);
                        JOptionPane.showMessageDialog(accountTab, "Sửa thành công");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(accountTab, "edit database error");
                        Logger.getLogger(AccountTabController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(accountTab, "Tài khoản sửa đã tồn tại, không thể sửa");
                }
            }
        }
    }
}
