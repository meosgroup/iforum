/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import vn.com.meo.group.iforum.models.AutoPost;

/**
 *
 * @author buian
 */
public class AutoPostDao {
    private final String
            TABLE_AUTO_POST = "autopost",
                ID = "id",
                ID_WEB = "id_web",
                ID_WEB_CATEGORY = "id_web_category",
                URL = "url",
                TITLE = "title",
                CONTENT = "post_content",
                ID_COMMENT_CATEGORY = "id_comment_category",
                ID_USER_POST = "id_user_post",
                ID_LAST_USER_COMMENT = "id_last_user_comment",
                ID_LAST_COMMENT = "id_last_comment",
                STATUS = "status",
                LAST_TIME_COMMENT = "last_time_comment",
                TIME_CREATE = "time_create";
    
    private Connection con;
    
    public AutoPostDao(){
        con = DBConnection.getConnection();
    }
    
    public AutoPost addAutoPost(AutoPost post, int idWeb) throws SQLException{
        String sql = String.format("INSERT INTO %s(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", TABLE_AUTO_POST, ID_WEB,ID_WEB_CATEGORY, URL, TITLE, CONTENT,
                ID_COMMENT_CATEGORY, ID_USER_POST, ID_LAST_USER_COMMENT, ID_LAST_COMMENT, STATUS, LAST_TIME_COMMENT, TIME_CREATE);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idWeb);
        if(post.getWebCategory()!=null){
            ps.setInt(2, post.getWebCategory().getId());
        }else{
            ps.setInt(2, 0);
        }
        
        ps.setString(3, post.getUrl());
        ps.setString(4, post.getTitle());
        ps.setString(5, post.getContent());
        ps.setInt(6, post.getCommentCategory().getId());
        ps.setInt(7, post.getUserPost().getId());
        if(post.getLastUserComment()!=null){
            ps.setInt(8, post.getLastUserComment().getId());
        }else{
            ps.setInt(8, 0);
        }
        if(post.getLastComment()!=null){
            ps.setInt(9, post.getLastComment().getId());
        }else{
            ps.setInt(9, 0);
        }
        ps.setString(10, post.getStatus());
        ps.setLong(11, post.getLastTimeComment());
        ps.setLong(12, post.getTimeCreate());
        ps.executeUpdate();
        AutoPost tmp = getAutoPostByTimeCreate(idWeb, post.getTimeCreate());
        post.setId(tmp.getId());
        return post;
    }
    public Vector<AutoPost> getAllAutoPost(int idWeb){
        return null;
    }
    public AutoPost getAutoPostByTimeCreate(int idWeb, long timeCreate) throws SQLException{
        String sql = String.format("SELECT %s, %s, %s ,%s, %s, %s, %s, %s, %s, %s, %s, %s, %s FROM %s WHERE %s = ? AND %s = ?", 
                ID, ID_WEB, ID_WEB_CATEGORY, URL, TITLE, CONTENT, ID_COMMENT_CATEGORY, ID_USER_POST, ID_LAST_USER_COMMENT,
                ID_LAST_COMMENT, STATUS, LAST_TIME_COMMENT, TIME_CREATE, ID_WEB, TIME_CREATE);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idWeb);
        ps.setLong(2, timeCreate);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int id = rs.getInt(ID);
            int id_web = rs.getInt(ID_WEB);
            int id_web_category = rs.getInt(ID_WEB_CATEGORY);
            String url = rs.getString(URL);
            String title = rs.getString(TITLE);
            String content = rs.getString(CONTENT);
            int id_comment_category = rs.getInt(ID_COMMENT_CATEGORY);
            int id_user_post = rs.getInt(ID_USER_POST);
            int id_last_user_comment = rs.getInt(ID_LAST_USER_COMMENT);
            int id_last_comment = rs.getInt(ID_LAST_COMMENT);
            String status = rs.getString(STATUS);
            long last_time_comment = rs.getLong(LAST_TIME_COMMENT);
            long time_create = rs.getLong(TIME_CREATE);
            AutoPost r = new AutoPost();
            r.setId(id);
            r.setUrl(url);
            r.setTitle(title);
            r.setContent(content);
            r.setStatus(status);
            r.setLastTimeComment(last_time_comment);
            r.setTimeCreate(timeCreate);
            return r;
        }
        return null;
    }
    
}
