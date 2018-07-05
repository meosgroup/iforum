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
    public abstract boolean isLogin();
    public abstract void logout();
    public abstract void register(String username, String password, String email);
    public abstract boolean isRegister(String username);
    public abstract void post(String linkUrl, String title, String content);
    public abstract void comment(String linkUrl, String comment);
    public abstract void replyComment(String linkUrl, String comment);
}