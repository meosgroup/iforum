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
import vn.com.meo.group.iforum.dao.AccountDao;
import vn.com.meo.group.iforum.apps.requests.webtretho.WebTreThoRequest;
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

    private Vector<Account> accountRegister;
    private Account accountCurrent;

    public AccountTabController(WebTreThoRequest toolRequest, Website website,
            AccountTab accountTab, AccountDao accountDao) {
        super(toolRequest, website);
        accountRegister = new Vector<>();
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
            if (account.getStatus() == Account.IS_REGISTER) {
                accountRegister.add(account);
            }
            Vector tmp = new Vector();
            tmp.add(i++);
            tmp.add(account.getUsername());
            tmp.add(account.getPassword());
            tmp.add(account.getStatusAsString());
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
        int status = Account.IS_NOT_REGISTER;
        if (isRegister) {
            status = Account.IS_REGISTER;
        }
        if (!username.equals("") && !password.equals("")) {
            accountCurrent = new Account(0, username, password, email, status);
            if (website.getAccounts().contains(accountCurrent)) {
                JOptionPane.showMessageDialog(accountTab, "Tài khoản đã tồn tại");
            } else {
                Vector v = null;
                if (isRegister) {
                    accountCurrent.setStatus(Account.CHECKING);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            synchronized (accountCurrent) {
                                synchronized (toolRequest) {
                                    toolRequest.logout();
                                    toolRequest.login(accountCurrent.getUsername(), accountCurrent.getPassword());
                                    try {
                                        if (accountCurrent.getUsername().equals(toolRequest.isLogin())) {
                                            accountRegister.add(accountCurrent);
                                            accountCurrent.setStatus(Account.IS_REGISTER);
                                            accountCurrent = accountDao.addAccount(accountCurrent, website.getId());
                                            AutoCommentReplyController.modelUser.addElement(accountCurrent);
                                        } else {
                                            accountCurrent.setStatus(Account.IS_NOT_REGISTER);
                                            accountCurrent = accountDao.addAccount(accountCurrent, website.getId());
                                        }
                                        int index = website.getAccounts().indexOf(accountCurrent);
                                        if (index >= 0) {
                                            website.getAccounts().get(index).setStatus(accountCurrent.getStatus());
                                            tableModel.setValueAt(accountCurrent.getStatusAsString(), index, 3);
                                        }
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(accountTab, "add database error");
                                        Logger.getLogger(AccountTabController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }
                    }).start();

                } else {
                    if (email.equals("")) {
                        JOptionPane.showMessageDialog(accountTab, "Email không được bỏ trống");
                        return;
                    }
                    try {
                        accountCurrent = accountDao.addAccount(accountCurrent, website.getId());
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(accountTab, "add database error");
                        Logger.getLogger(AccountTabController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                v = new Vector();
                v.add(tableModel.getRowCount());
                v.add(accountCurrent.getUsername());
                v.add(accountCurrent.getPassword());
                v.add(accountCurrent.getStatusAsString());
                website.getAccounts().add(accountCurrent);
                tfUsername.setText("");
                tfEmail.setText("");
                tfPassword.setText("");
                tableModel.addRow(v);
                JOptionPane.showMessageDialog(accountTab, "Thêm thành công");
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
            if(website.getAccounts().get(index).getStatus() == Account.CHECKING){
                JOptionPane.showMessageDialog(accountTab, "Tài khoản này đang được kiểm tra, chưa thể xóa");
                return;
            }
            try {
                //delete from db
                accountDao.deleteAccount(website.getAccounts().get(index));
                if (website.getAccounts().get(index).getStatus() == Account.IS_REGISTER) {
                    AutoCommentReplyController.modelUser.removeElement(website.getAccounts().get(index));
                }
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
            accountCurrent = website.getAccounts().get(index);
            if(accountCurrent.getStatus() == Account.CHECKING){
                JOptionPane.showMessageDialog(accountTab, "Tài khoản này đang được kiểm tra, chưa thể sửa");
                return;
            }
            Account tmp = JEditDialog.showEditAccountDialog(accountTab, accountCurrent);
            if (tmp != null) {
                int indexOf = website.getAccounts().indexOf(tmp);
                if (indexOf < 0 || indexOf == index) {
                    accountCurrent.setEmail(tmp.getEmail());
                    accountCurrent.setUsername(tmp.getUsername());
                    accountCurrent.setPassword(tmp.getPassword());
                    accountCurrent.setStatus(Account.CHECKING);
                    tableModel.setValueAt(accountCurrent.getUsername(), index, 1);
                    tableModel.setValueAt(accountCurrent.getPassword(), index, 2);
                    tableModel.setValueAt(accountCurrent.getStatusAsString(), index, 3);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            synchronized (accountCurrent) {
                                synchronized (toolRequest) {
                                    toolRequest.logout();
                                    toolRequest.login(accountCurrent.getUsername(), accountCurrent.getPassword());
                                    try {
                                        if (accountCurrent.getUsername().equals(toolRequest.isLogin())) {
                                            accountCurrent.setStatus(Account.IS_REGISTER);
                                            if (!accountRegister.contains(accountRegister)) {
                                                accountRegister.add(accountCurrent);
                                                AutoCommentReplyController.modelUser.addElement(accountCurrent);
                                            }
                                        } else {
                                            accountCurrent.setStatus(Account.IS_NOT_REGISTER);
                                            if (accountRegister.contains(accountCurrent)) {
                                                accountRegister.remove(accountCurrent);
                                                AutoCommentReplyController.modelUser.removeElement(accountCurrent);
                                            }
                                        }
                                        int index = website.getAccounts().indexOf(accountCurrent);
                                        if (index >= 0) {
                                            website.getAccounts().get(index).setStatus(accountCurrent.getStatus());
                                            tableModel.setValueAt(accountCurrent.getStatusAsString(), index, 3);
                                        }
                                        accountDao.editAccount(accountCurrent);
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(accountTab, "add database error");
                                        Logger.getLogger(AccountTabController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }
                    }).start();
                    JOptionPane.showMessageDialog(accountTab, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(accountTab, "Tài khoản sửa đã tồn tại, không thể sửa");
                }
            }
        }
    }
}
