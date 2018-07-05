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
    public abstract void login(String linkUrl, String username, String password);
    public abstract void register(String linkUrl, String username, String password, String email);
    public abstract void post(String username, String password, String linkUrl, String title, String content);
    public abstract void comment(String linkUrl, String comment); 
}
