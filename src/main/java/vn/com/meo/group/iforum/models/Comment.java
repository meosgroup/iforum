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
public class Comment {
    private int id;
    private String contentComment;
    private String contentReply;

    public Comment(int id, String contentComment, String contentReply) {
        this.id = id;
        this.contentComment = contentComment;
        this.contentReply = contentReply;
    }
    public Comment(String contentComment, String contentReply) {
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
    
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        Comment tmp = (Comment) o;
        if(tmp.getContentComment().equals(contentComment) && tmp.getContentReply().equals(contentReply)){
            return true;
        }
        return false;
    }
}
