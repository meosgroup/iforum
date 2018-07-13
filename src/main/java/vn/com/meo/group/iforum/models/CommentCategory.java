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
public class CommentCategory {

    private int id;
    private String name;
    private Vector<Comment> commentReplyList;

    public CommentCategory(int id, String name) {
        this.id = id;
        this.name = name;
        commentReplyList = new Vector<>();
    }
    
    public CommentCategory(int id, String name, Vector<Comment> commentReplyList) {
        this.id = id;
        this.name = name;
        this.commentReplyList = commentReplyList;
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

    public Vector<Comment> getCommentReplyList() {
        return commentReplyList;
    }

    public void setCommentReplyList(Vector<Comment> commentReplyList) {
        this.commentReplyList = commentReplyList;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        CommentCategory tmp = (CommentCategory)o;
        if(name.equals(tmp.getName())){
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return name;
    }
}
