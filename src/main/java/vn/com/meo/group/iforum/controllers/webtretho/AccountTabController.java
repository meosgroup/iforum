/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.controllers.webtretho;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import vn.com.meo.group.iforum.apps.webtretho.WebTreThoRequest;
import vn.com.meo.group.iforum.controllers.BaseController;
import vn.com.meo.group.iforum.models.Account;
import vn.com.meo.group.iforum.models.Website;
import vn.com.meo.group.iforum.views.tab.general.AccountTab;

/**
 *
 * @author buian
 */
public class AccountTabController extends BaseController {

    private AccountTab accountTab;
    //ui
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JTextField tfEmail;
    private JButton btnAdd;
    private JButton btnRegistry;
    private JCheckBox cbIsRegistry;
    private JTable tbUsers;
    private JButton btnNextPage;
    private JButton btnBackPage;
    private JLabel lbCurrentPage;
    
    public AccountTabController(WebTreThoRequest toolRequest, Website website, AccountTab accountTab) {
        super(toolRequest, website);
        this.accountTab = accountTab;
        initComponent();
        initData();
        initActionEvent();
    }

    @Override
    public void initData() {
    }

    @Override
    public void initActionEvent() {
        accountTab.getBtnAdd().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionAddUser();
            }
        });
        accountTab.getBtnRegistry().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionRegistry();
            }
        });
    }

    private void actionAddUser() {
        String email = tfEmail.getText();
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        boolean isRegister = cbIsRegistry.isSelected();
        if (!username.equals("") && !password.equals("")) {
            Account tmp = new Account(0, username, password, email);
            if (website.getAccounts().contains(tmp)) {
                JOptionPane.showMessageDialog(accountTab, "Tài khoản đã tồn tại");
            } else {
                if (isRegister) {
                    if (this.toolRequest.isRegister(username)) {
                        website.getAccounts().add(tmp);
                    } else {
                        JOptionPane.showMessageDialog(accountTab, "Tài khoản này chưa được đăng kí");
                    }
                }
                website.getAccounts().add(tmp);
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
        btnNextPage = accountTab.getBtnNextPage();
        btnBackPage = accountTab.getBtnBackPage();
        tbUsers = accountTab.getTbUsers();
        lbCurrentPage = accountTab.getLbCurrentPage();
    }
}
