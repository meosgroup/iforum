/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.util;

import java.awt.Image;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author buian
 */
public enum R {
    strings("strings"),
    images("images");
    
    private final ResourceBundle resourceBundle;
    private static final String DEFAULT_LOCATION = "resources.";
    private static final String IMAGE_PATH = "/resources/";
    private final static Logger LOGGER = Logger.getLogger(R.class.getName());
    R(String name){
        this.resourceBundle = ResourceBundle.getBundle(DEFAULT_LOCATION + name);
    }
    
    public String getString(String name){
        try{
            return resourceBundle.getString(name);
        }catch(MissingResourceException e){
            LOGGER.log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public Image getImage(String name){
        try{
            String path = resourceBundle.getString(name);
            try {
                System.out.println(IMAGE_PATH + path);
                Image tmp = ImageIO.read(getClass().getResourceAsStream(IMAGE_PATH + path));
                return tmp;
            } catch (IOException ex) {
                Logger.getLogger(R.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }catch(MissingResourceException e){
            LOGGER.log(Level.SEVERE, null, e);
            return null;
        }
    }
    
}
