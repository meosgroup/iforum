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
public class CommentReplyPost {
    private int id;
    private Post post;
    private Account acc;
    private Comment comment;
    private long date;
    private String type;

    public CommentReplyPost(int id, Post post, Account acc, Comment comment, long date, String type) {
        this.id = id;
        this.post = post;
        this.acc = acc;
        this.comment = comment;
        this.date = date;
        this.type = type;
    }

    public CommentReplyPost() {
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

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
