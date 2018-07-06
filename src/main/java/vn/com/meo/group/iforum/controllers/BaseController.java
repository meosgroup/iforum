/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.controllers;

import java.awt.Color;
import java.awt.Font;
import vn.com.meo.group.iforum.apps.base.ToolBase;
import vn.com.meo.group.iforum.controllers.Controller;
import vn.com.meo.group.iforum.models.Website;

/**
 *
 * @author buian
 */
public abstract class BaseController implements Controller{
    protected ToolBase toolRequest;
    protected Website website;
    
    public BaseController(ToolBase tb, Website website){
        this.toolRequest = tb;
        this.website = website;
    }
    
    public abstract void initActionEvent();
}
