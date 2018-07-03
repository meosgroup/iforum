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
}
