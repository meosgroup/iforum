package vn.com.meo.group.iforum.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Resources {
    public static class strings{
        public static String get(String name){
            return name;
        }
    }
    
    public static class images{
        private static String PATH = "resources/images/";
        public static Image get(String filename){
            Image tmp = null;
            try {
                tmp = ImageIO.read(new File(PATH + filename));
            } catch (IOException ex) {
                Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tmp;
        }
    }
}
