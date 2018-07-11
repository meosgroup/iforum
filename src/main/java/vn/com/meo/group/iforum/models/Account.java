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
    private String email;
    private boolean isRegister;
    
    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Account(String username, String password, boolean  isRegister) {
        this.username = username;
        this.password = password;
        this.isRegister = isRegister;
    }

    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Account(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public Account(int id, String username, String password, String email, boolean registry) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isRegister = registry;
    }

    public boolean isIsRegister() {
        return isRegister;
    }

    public void setIsRegister(boolean isRegister) {
        this.isRegister = isRegister;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        Account account = (Account) o;
        if(this.username.equals(account.getUsername())){
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return username;
    }
}
