/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class Website {
    private int id;
    private String nameWeb;
    private List<CategoryWeb> listCategoryWeb;

    public Website() {
        listCategoryWeb = new ArrayList<>();
    }

    public Website(int id, String nameWeb) {
        this.id = id;
        this.nameWeb = nameWeb;
        listCategoryWeb = new ArrayList<>();
    }

    public Website(int id, String nameWeb, List<CategoryWeb> listCategoryWeb) {
        this.id = id;
        this.nameWeb = nameWeb;
        this.listCategoryWeb = listCategoryWeb;
    }

    public List<CategoryWeb> getListCategoryWeb() {
        return listCategoryWeb;
    }

    public void setListCategoryWeb(List<CategoryWeb> listCategoryWeb) {
        this.listCategoryWeb = listCategoryWeb;
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
