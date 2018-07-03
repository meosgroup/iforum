/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.models;

/**
 *
 * @author nguye
 */
public class Website {
    private int id;
    private String nameWeb;

    public Website(int id, String nameWeb) {
        this.id = id;
        this.nameWeb = nameWeb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameWeb() {
        return nameWeb;
    }

    public void setNameWeb(String nameWeb) {
        this.nameWeb = nameWeb;
    }
    
}
