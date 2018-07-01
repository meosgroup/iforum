package vn.com.meo.group.iforum.utils;

import java.net.URL;

public class Resources {
    public static URL get(String filename){
        return Resources.class.getClassLoader().getResource(filename);
    }
}
