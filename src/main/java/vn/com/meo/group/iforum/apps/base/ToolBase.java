
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.apps.base;

/**
 *
 * @author loda
 */
public abstract class ToolBase {
    public abstract void login(String username, String password);
    public abstract String isLogin();
    public abstract void logout();
    public abstract void register(String username, String password, String email);
    public abstract boolean isRegister(String username);
    public abstract String post(String linkUrl, String title, String content);
    public abstract String comment(String linkUrl, String comment);
    public abstract String replyComment(String linkUrl, String comment);
    public void log(String s){
        System.out.println("Log: " + s);
    }
}