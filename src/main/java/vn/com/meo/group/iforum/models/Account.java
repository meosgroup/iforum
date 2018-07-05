/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.models;

/**
 *
 * @author loda
 */
public class Account {
    private int id;
    private String username;
    private String password;
    private Website web;
    private int register;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Account(int id, String username, String password, Website web) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.web = web;
    }

    public Account(int id, String username, String password, Website web, int register) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.web = web;
        this.register = register;
    }

    public int getRegister() {
        return register;
    }

    public void setRegister(int register) {
        this.register = register;
    }

    public Website getWeb() {
        return web;
    }

    public void setWeb(Website web) {
        this.web = web;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
