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
    private CommentReply comment;
    private long date; //vi khong co kieu date trong db nen la khi su dung se ep ve date.
    private String type;

    public CommentReplyPost(int id, Post post, Account acc, CommentReply comment, long date, String type) {
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

    public CommentReply getComment() {
        return comment;
    }

    public void setComment(CommentReply comment) {
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
