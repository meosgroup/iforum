/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.apps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.com.meo.group.iforum.models.Account;

/**
 *
 * @author nguye
 */
public class AccountDao {

    private String TABLE_ACCOUNT = "account",
            ID = "id",
            USERNAME = "username",
            PASSWORD = "password",
            EMAIL = "email",
            ID_WEB = "id_web",
            REGISTER = "register";

    private Connection con;

    public AccountDao() {
        con = DBConnection.getConnection();
    }

    public Account addAccount(Account account, int idWeb) throws SQLException {
        String sql = String.format("INSERT INTO %s(%s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?)",
                TABLE_ACCOUNT, USERNAME, PASSWORD, EMAIL, ID_WEB, REGISTER);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, account.getUsername());
        ps.setString(2, account.getPassword());
        ps.setString(3, account.getEmail());
        ps.setInt(4, idWeb);
        int register = 0;
        if (account.isIsRegister()) {
            register = 1;
        }
        ps.setInt(5, register);
        ps.executeUpdate();
        Account tmp = getAccountByName(account.getUsername());
        if (tmp == null) {
            return null;
        }
        account.setId(tmp.getId());
        return account;
    }

    public void editAccount(Account account) throws SQLException {
        String sql = String.format("UPDATE %s SET %s = ?, %s = ?, %s= ?, %s = ? WHERE %s = ?",
                TABLE_ACCOUNT, USERNAME, PASSWORD, EMAIL, REGISTER, ID);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, account.getUsername());
        ps.setString(2, account.getPassword());
        ps.setString(3, account.getEmail());
        int register = 0;
        if (account.isIsRegister()) {
            register = 1;
        }
        ps.setInt(4, register);
        ps.setInt(5, account.getId());
        ps.executeUpdate();

    }

    public void deleteAccount(Account account) throws SQLException {

        Statement s = con.createStatement();
        String sql = "DELETE from account where id = " + account.getId();
        s.executeUpdate(sql);

    }

    public Vector<Account> getAllAccount(int idWeb) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE %s = ?", TABLE_ACCOUNT, ID_WEB);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idWeb);
        ResultSet rs = ps.executeQuery();
        Vector<Account> result = new Vector<>();
        while (rs.next()) {
            int id = rs.getInt(ID);
            String username = rs.getString(USERNAME);
            String password = rs.getString(PASSWORD);
            String email = rs.getString(EMAIL);
            idWeb = rs.getInt(ID_WEB);
            int register = rs.getInt(REGISTER);
            boolean isRegister = false;
            if (register == 1) {
                isRegister = true;
            }
            result.add(new Account(id, username, password, email, isRegister));
        }
        return result;
    }

    public Account getAccountByName(String name) {
        try {
            String sql = String.format("SELECT * from %s where %s = ?",
                    TABLE_ACCOUNT, USERNAME);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(ID);
                String user = rs.getString(USERNAME);
                String pass = rs.getString(PASSWORD);
                String email = rs.getString(EMAIL);
                int register = rs.getInt(REGISTER);
                boolean isRegister = false;
                if (register == 1) {
                    isRegister = true;
                }
                return new Account(id, user, pass, email, isRegister);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
