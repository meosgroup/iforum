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
public class CommentReply {
    private int id;
    private String contentComment;
    private String contentReply;

    public CommentReply(int id, String contentComment, String contentReply) {
        this.id = id;
        this.contentComment = contentComment;
        this.contentReply = contentReply;
    }
    public CommentReply(String contentComment, String contentReply) {
        this.contentComment = contentComment;
        this.contentReply = contentReply;
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
}
