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
public class CategoryComment {

    private int id;
    private String name;
    private String contentComment;
    private String contentReply;

    public CategoryComment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryComment() {
    }

    public CategoryComment(int id, String name, String contentComment, String contentReply) {
        this.id = id;
        this.name = name;
        this.contentComment = contentComment;
        this.contentReply = contentReply;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
