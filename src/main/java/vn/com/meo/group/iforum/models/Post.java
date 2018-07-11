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
public class Post {
    private int id;
    private String title;
    private String content;
    private Account account;
    private WebCategory category;

    public Post(int id, String title, String content, Account account) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.account = account;
    }

    public Post(int id, String title, String content, Account account, WebCategory category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.account = account;
        this.category = category;
    }

    public Post() {
    }

    public WebCategory getCategory() {
        return category;
    }

    public void setCategory(WebCategory category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    
}
