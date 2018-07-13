/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.apps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import vn.com.meo.group.iforum.models.Comment;

/**
 *
 * @author buian
 */
public class CommentDao {
    private String
        TABLE_COMMENT = "comment",
            ID = "id",
            CONTENT_COMMENT = "conetent_comment",
            CONTENT_REPLY = "content_reply",
            ID_CATEGORY = "id_category";
    private Connection con;
    public CommentDao(){
        con = DBConnection.getConnection();
    }
    
    public Comment addComment(Comment c, int idCategory) throws SQLException{
        String sql = String.format("INSERT INTO %s(%s, %s, %s) VALUES(?, ?, ?)",
                TABLE_COMMENT, CONTENT_COMMENT, CONTENT_REPLY, ID_CATEGORY);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getContentComment());
        ps.setString(2, c.getContentReply());
        ps.setInt(3, idCategory);
        ps.executeUpdate();
        Comment tmp = getCommentByContent(c.getContentComment(), c.getContentReply());
        if (tmp == null) {
            return null;
        }
        c.setId(tmp.getId());
        return c;
    }
    public void deleteComment(Comment c) throws SQLException{
        String sql = String.format("DELETE FROM %s WHERE %s = ? ", TABLE_COMMENT, ID);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, c.getId());
        ps.executeUpdate();
    }
    
    public void deleteCommentByIdCategory(int idCategory) throws SQLException{
        String sql = String.format("DELETE FROM %s WHERE %s = ? ", TABLE_COMMENT, ID_CATEGORY);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCategory);
        ps.executeUpdate();
    }
    public void editComment(Comment c, int idCategory) throws SQLException{
        String sql = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ? WHERE %s = ?", 
                TABLE_COMMENT, CONTENT_COMMENT, CONTENT_REPLY, ID_CATEGORY, ID);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getContentComment());
        ps.setString(2, c.getContentReply());
        ps.setInt(3, idCategory);
        ps.setInt(4, c.getId());
        ps.executeUpdate();
    }
    public Comment getCommentByContent(String connentComment, String contentReply) throws SQLException{
        String sql = String.format("SELECT * FROM %s WHERE %s LIKE ? AND %s LIKE ? LIMIT 1",
                TABLE_COMMENT, CONTENT_COMMENT, CONTENT_REPLY);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, connentComment);
        ps.setString(2, contentReply);
        ResultSet rs = ps.executeQuery();
        Comment tmp = null;
        if(rs.next()){
            int id = rs.getInt(ID);
            connentComment = rs.getString(CONTENT_COMMENT);
            contentReply = rs.getString(CONTENT_REPLY);
            int idCategory = rs.getInt(ID_CATEGORY);
            tmp = new Comment(id, connentComment, contentReply);
        }
        return tmp;
    }
    
    public Vector<Comment> getAllCommentByCategoryId(int idCategory) throws SQLException{
        String sql = String.format("SELECT * FROM %s WHERE %s = ?",
                TABLE_COMMENT, ID_CATEGORY);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCategory);
        ResultSet rs = ps.executeQuery();
        Vector<Comment> comments = new Vector<Comment>();
        while(rs.next()){
            int id = rs.getInt(ID);
            String contentComment = rs.getString(CONTENT_COMMENT);
            String contentReply = rs.getString(CONTENT_REPLY);
            Comment tmp = new Comment(id, contentComment, contentReply);
            comments.add(tmp);
        }
        return comments;
    }
}
