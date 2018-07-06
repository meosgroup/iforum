/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.models;

import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class CategoryWeb {
    private int id;
    private String name;
    private String url;
    private ArrayList<CategoryWeb> categoryChilds;
    

    public CategoryWeb(int id, String name, String url, ArrayList<CategoryWeb> categoryChilds) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.categoryChilds = categoryChilds;
    }

    public CategoryWeb(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CategoryWeb> getCategoryChilds() {
        return categoryChilds;
    }

    public void setCategoryChilds(ArrayList<CategoryWeb> categoryChilds) {
        this.categoryChilds = categoryChilds;
    }
    
}