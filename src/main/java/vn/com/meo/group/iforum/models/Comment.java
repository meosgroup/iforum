/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.models;

import java.sql.Date;

/**
 *
 * @author nguye
 */
public class Comment {
    private int id;
    private Post post;
    private String content;
    private CategoryComment category;
    private Account account;
    private Date timeComment;
    private String type;
    private Comment comment;

    public Comment(int id, Post post, String content, CategoryComment category, Account account, Date timeComment, String type, Comment comment) {
        this.id = id;
        this.post = post;
        this.content = content;
        this.category = category;
        this.account = account;
        this.timeComment = timeComment;
        this.type = type;
        this.comment = comment;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryComment getCategory() {
        return category;
    }

    public void setCategory(CategoryComment category) {
        this.category = category;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getTimeComment() {
        return timeComment;
    }

    public void setTimeComment(Date timeComment) {
        this.timeComment = timeComment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
    
}
