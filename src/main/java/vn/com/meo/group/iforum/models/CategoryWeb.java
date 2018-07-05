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
    private String categoryName;
    private String url;
    private int idParent;
    private ArrayList<CategoryWeb> listCategoryChild;

    public CategoryWeb(int id, String categoryName, String url, int idParent, ArrayList<CategoryWeb> listCategoryChild) {
        this.id = id;
        this.categoryName = categoryName;
        this.url = url;
        this.idParent = idParent;
        this.listCategoryChild = listCategoryChild;
    }

    public CategoryWeb() {
        listCategoryChild = new ArrayList<>();
    }

    public CategoryWeb(int id, String categoryName, String url, int idParent) {
        this.id = id;
        this.categoryName = categoryName;
        this.url = url;
        this.idParent = idParent;
        listCategoryChild = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public ArrayList<CategoryWeb> getListCategoryChild() {
        return listCategoryChild;
    }

    public void setListCategoryChild(ArrayList<CategoryWeb> listCategoryChild) {
        this.listCategoryChild = listCategoryChild;
    }
    
    
}
