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
    public static int IS_REGISTER = 1;
    public static int IS_NOT_REGISTER = 0;
    public static int CHECKING = 2;
    
    private int id;
    private String username;
    private String password;
    private String email;
    private int status;
    
    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Account(String username, String password, int  status) {
        this.username = username;
        this.password = password;
        this.status = status;
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
    
    public Account(int id, String username, String password, String email, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int isRegister) {
        this.status = isRegister;
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
    
    public String getStatusAsString(){
        if(status == IS_REGISTER){
            return "Đã đăng kí";
        }
        if(status == IS_NOT_REGISTER){
            return "Chưa đăng kí";
        }
        if(status == CHECKING){
            return "Đang kiểm tra";
        }
        return null;
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
