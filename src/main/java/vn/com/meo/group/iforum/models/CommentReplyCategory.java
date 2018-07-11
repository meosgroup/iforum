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
public class CommentReplyCategory {

    private int id;
    private String name;
    private ArrayList<CommentReply> commentReplyList;

    public CommentReplyCategory(int id, String name) {
        this.id = id;
        this.name = name;
        commentReplyList = new ArrayList<>();
    }
    
    public CommentReplyCategory(int id, String name, ArrayList<CommentReply> commentReplyList) {
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

    public ArrayList<CommentReply> getCommentReplyList() {
        return commentReplyList;
    }

    public void setCommentReplyList(ArrayList<CommentReply> commentReplyList) {
        this.commentReplyList = commentReplyList;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        CommentReplyCategory tmp = (CommentReplyCategory)o;
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
