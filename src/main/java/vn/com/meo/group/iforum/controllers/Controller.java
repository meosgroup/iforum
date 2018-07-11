/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.controllers;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author buian
 */
public interface Controller {
    static final Font fontSubTab = new Font("Tahoma", Font.PLAIN, 14);
    static final Color backGroundColor = new Color(255,255,255);
    public void initData();
    public void initComponent();
}
