/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.apps.webtretho;

import javax.swing.JOptionPane;
import vn.com.meo.group.iforum.apps.base.ToolBase;
import vn.com.meo.group.iforum.apps.webtretho.block.LoginBlock;
import vn.com.meo.group.iforum.apps.webtretho.block.LoginPostBlock;
import vn.com.meo.group.iforum.apps.webtretho.block.RegisterBlock;

/**
 *
 * @author loda
 */
public class WebTreTho extends ToolBase{
    
    
    @Override
    public void login(String linkUrl, String username, String password) {
        LoginBlock login = new LoginBlock(false);
        // go to url
        login.gotoUrl(linkUrl);
        // set input
        login.setUsername(username);
        login.setPassword(password);
        login.clickSubmit();
        login.sleep(10);
        // reset cookie
        login.resetCookies();
        login.gotoUrl(linkUrl);
        login.sleep(20);
        login.closeDriver();
    }

    @Override
    public void register(String linkUrl, String username, String password, String email) {
        RegisterBlock register = new RegisterBlock(false);
        
        register.gotoUrl(linkUrl);
        
        register.setUsername(username);
        register.setEmail(email);
        register.setPassword(password);
        
        JOptionPane.showMessageDialog(null, "Đã xác thực capcha?");
        register.clickSubmit();
    }

    @Override
    public void post(String username, String password, String linkUrl, String title, String content) {
        LoginPostBlock post = new LoginPostBlock(true);
        post.gotoUrl(linkUrl);
//        login
        post.setUsername(username);
        post.setPassword(password);
        post.clickSubmit();
        
        post.sleep(50);
//        post
        post.setTitle(title);
        post.setContent(content);
        post.clickPost();
        
        post.sleep(50);
//        close drive
        post.closeDriver();
    }

    @Override
    public void comment(String linkUrl, String comment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
