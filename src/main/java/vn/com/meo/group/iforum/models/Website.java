/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.models;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author nguye
 */
public class Website {
    private int id;
    private String name;
    private Vector<WebCategory> webCategorys;
    private Vector<Account> accounts;
    private Vector<CommentCategory> commentReplyCategorys;
    public Website(int id, String nameWeb) {
        this.id = id;
        this.name = nameWeb;
        webCategorys = new Vector<>();
        accounts = new Vector<>();
    }

    public Website(int id, String nameWeb, Vector<WebCategory> categoryWebs) {
        this.id = id;
        this.name = nameWeb;
        this.webCategorys = categoryWebs;
        accounts = new Vector<>();
    }

    public Website(int id, String nameWeb, Vector<WebCategory> categoryWebs, Vector<Account> accounts) {
        this.id = id;
        this.name = nameWeb;
        this.webCategorys = categoryWebs;
        this.accounts = accounts;
    }

    public Website(int id, String nameWeb, Vector<WebCategory> categoryWebs, 
            Vector<Account> accounts, Vector<CommentCategory> commentReplyCategorys) {
        this.id = id;
        this.name = nameWeb;
        this.webCategorys = categoryWebs;
        this.accounts = accounts;
        this.commentReplyCategorys = commentReplyCategorys;
    }

    public Website() {
    }
    

    public Vector<WebCategory> getWebCategorys() {
        return webCategorys;
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

    public Vector<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Vector<Account> accounts) {
        this.accounts = accounts;
    }

    public Vector<CommentCategory> getCommentReplyCategorys() {
        return commentReplyCategorys;
    }

    public void setCommentReplyCategorys(Vector<CommentCategory> commentReplyCategorys) {
        this.commentReplyCategorys = commentReplyCategorys;
    }

    public void setWebCategorys(Vector<WebCategory> webCategorys) {
        this.webCategorys = webCategorys;
    }
    
    public Vector<Account> getUsersIsRegister(){
        Vector users = new Vector();
        for(Account user: accounts){
            if(user.getStatus() == Account.IS_REGISTER){
                users.add(user);
            }
        }
        return users;
    }
}
