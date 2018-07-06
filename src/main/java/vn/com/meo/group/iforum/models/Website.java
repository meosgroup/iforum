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
    private String name;
    private ArrayList<CategoryWeb> categoryWebs;
    private ArrayList<Account> accounts;
    private ArrayList<CommentReplyCategory> categoryCommentReplys;
    public Website(int id, String nameWeb) {
        this.id = id;
        this.name = nameWeb;
        categoryWebs = new ArrayList<>();
    }

    public Website(int id, String nameWeb, ArrayList<CategoryWeb> categoryWebs) {
        this.id = id;
        this.name = nameWeb;
        this.categoryWebs = categoryWebs;
    }

    public Website(int id, String nameWeb, ArrayList<CategoryWeb> categoryWebs, ArrayList<Account> accounts) {
        this.id = id;
        this.name = nameWeb;
        this.categoryWebs = categoryWebs;
        this.accounts = accounts;
    }

    public Website(int id, String nameWeb, ArrayList<CategoryWeb> categoryWebs, ArrayList<Account> accounts, ArrayList<CommentReplyCategory> categoryCommentReplys) {
        this.id = id;
        this.name = nameWeb;
        this.categoryWebs = categoryWebs;
        this.accounts = accounts;
        this.categoryCommentReplys = categoryCommentReplys;
    }

    public Website() {
    }
    

    public ArrayList<CategoryWeb> getCategoryWebs() {
        return categoryWebs;
    }

    public void setCategoryWebs(ArrayList<CategoryWeb> categoryWebs) {
        this.categoryWebs = categoryWebs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNameWeb(String nameWeb) {
        this.name = nameWeb;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<CommentReplyCategory> getCategoryCommentReplys() {
        return categoryCommentReplys;
    }

    public void setCategoryCommentReplys(ArrayList<CommentReplyCategory> categoryCommentReplys) {
        this.categoryCommentReplys = categoryCommentReplys;
    }
}
