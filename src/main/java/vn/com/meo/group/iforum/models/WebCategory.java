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
public class WebCategory {
    private int id;
    private String name;
    private String url;
    private ArrayList<WebCategory> categoryChilds;
    

    public WebCategory(int id, String name, String url, ArrayList<WebCategory> categoryChilds) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.categoryChilds = categoryChilds;
    }

    public WebCategory(String name, String url) {
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

    public ArrayList<WebCategory> getCategoryChilds() {
        return categoryChilds;
    }

    public void setCategoryChilds(ArrayList<WebCategory> categoryChilds) {
        this.categoryChilds = categoryChilds;
    }
    
    public boolean equals(Object o){
        if(o== null){
            return false;
        }
        WebCategory tmp = (WebCategory) o;
        if(this.url.equals(tmp.getUrl()) || this.name.equals(tmp.getName())){
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return name;
    }
}