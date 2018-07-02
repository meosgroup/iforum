/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.apps.webtretho.block;

import org.openqa.selenium.WebDriver;
import vn.com.meo.group.iforum.apps.base.Block;

/**
 *
 * @author ducvu
 */
public class LoginPostBlock extends Block {
    
    public LoginPostBlock(WebDriver driver) {
        super(driver);
    }

    public LoginPostBlock(boolean headless) {
        super(headless);
    }
    
    public void setUsername(String username) {
        this.findElementById("vb_login_username").sendKeys(username);
    }
    
    public void setPassword(String password) {
        this.findElementById("vb_login_password").sendKeys(password);
    }
    
    public void clickSubmit() {
        this.findElementById("popup_login_button").submit();
    }
    
    public void setTitle(String title) {
        this.findElementById("subject").sendKeys(title);
    }
    
    public void setContent(String content) {
        this.actionInput(this.findElementById("cke_contents_vB_Editor_001_editor"), content);
    }
    
    public void clickPost() {
        this.findElementById("vB_Editor_001_save").submit();
    }
    
}
