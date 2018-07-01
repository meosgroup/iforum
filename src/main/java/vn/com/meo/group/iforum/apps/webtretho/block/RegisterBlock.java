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
public class RegisterBlock extends Block{
    
    public RegisterBlock(boolean headless) {
        super(headless);
    }
    
    public void setUsername(String username) {
        this.findElementByName("username").sendKeys(username);
    }
    
    public void setEmail(String email) {
        this.findElementByName("email").sendKeys(email);
    }
    
    public void setPassword(String password) {
        this.findElementByName("password").sendKeys(password);
    }
    
    public void clickSubmit() {
        this.findElementByClass("btnSend").click();
    }
}
