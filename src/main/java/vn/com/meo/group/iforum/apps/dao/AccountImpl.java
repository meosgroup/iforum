/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.apps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.com.meo.group.iforum.models.Account;

/**
 *
 * @author nguye
 */
public class AccountImpl implements AccountDAO {

    @Override
    public void addAccount(Account account, Connection con) {
        try {
            Statement s = con.createStatement();
            String sql = "INSERT INTO account(username, password) VALUES ("
                    + account.getUsername() + ", " + account.getPassword() + " );";
            s.executeUpdate(sql);
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateAccount(Account account, Connection con) {
        try {
            Statement s = con.createStatement();
            String sql = "UPDATE account SET username = "+account.getUsername()+" password = "+account.getPassword()+
                    "WHERE id = "+account.getId() +";";
            s.executeUpdate(sql);
            con.commit();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delAccount(Account account, Connection con) {
        try {
            Statement s = con.createStatement();
            String sql = "DELETE from account where id = "+account.getId()+";";
        } catch (SQLException ex) {
            Logger.getLogger(AccountImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Account> getListAccount(Connection con) {
        List<Account> result = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            String sql = "SELECT * FROM account;";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String user = rs.getString("username");
                String pass = rs.getString("password");
                Account a = new Account(id, user, pass);
                result.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Account> getListAccountByUsername(String username, Connection con) {
        List<Account> result = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            String sql = "SELECT * FROM account WHERE username = "+username+" ;";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String user = rs.getString("username");
                String pass = rs.getString("password");
                Account a = new Account(id, user, pass);
                result.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
