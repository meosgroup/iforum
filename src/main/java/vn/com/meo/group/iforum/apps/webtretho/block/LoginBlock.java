/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.apps.webtretho.block;

import vn.com.meo.group.iforum.apps.base.Block;

/**
 *
 * @author ducvu
 */
public class LoginBlock extends Block{
    
    public LoginBlock(boolean headless) {
        super(headless);
    }
    
    public void setUsername(String username) {
        this.findElementById("vb_login_username").sendKeys(username);
    }
    
    public void setPassword(String password) {
        this.findElementById("vb_login_password").sendKeys(password);
    }
    
    public void clickSubmit() {
        this.findElementById("popup_login_button").click();
    }
}
