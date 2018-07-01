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
    protected String url;
    
    public abstract void login(String username, String password);
    public abstract void register(String username, String password);
    public abstract void post(String linkUrl, String title, String content);
    public abstract void comment(String linkUrl, String comment);

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
