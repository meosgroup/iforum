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
    private String contentComment;
    private String contentReply;
    private CategoryComment category;

    public Comment(int id, String contentComment, String contentReply, CategoryComment category) {
        this.id = id;
        this.contentComment = contentComment;
        this.contentReply = contentReply;
        this.category = category;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContentComment() {
        return contentComment;
    }

    public void setContentComment(String contentComment) {
        this.contentComment = contentComment;
    }

    public String getContentReply() {
        return contentReply;
    }

    public void setContentReply(String contentReply) {
        this.contentReply = contentReply;
    }

    public CategoryComment getCategory() {
        return category;
    }

    public void setCategory(CategoryComment category) {
        this.category = category;
    }
    
}
