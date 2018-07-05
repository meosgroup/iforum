/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.apps.dao;

import java.sql.Connection;
import java.util.List;
import vn.com.meo.group.iforum.models.Account;

/**
 *
 * @author nguye
 */
public interface AccountDAO {
    public void addAccount(Account account, Connection con);
    public void updateAccount(Account account, Connection con);
    public void delAccount(Account account, Connection con);
    public List<Account> getListAccount(Connection con);
    public List<Account> getListAccountByUsername(String username, Connection con);
}
