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
import vn.com.meo.group.iforum.models.Account;
import vn.com.meo.group.iforum.models.Comment;
import vn.com.meo.group.iforum.models.CommentCategory;

/**
 *
 * @author buian
 */
public class CommentCategoryDao {

    private String TABLE_COMMENT_CATEGORY = "category_comment",
            ID = "id",
            NAME = "name",
            ID_WEB = "id_web";
    private Connection con;
    private CommentDao commentDao;
    public CommentCategoryDao() {
        con = DBConnection.getConnection();
        commentDao = new CommentDao();
    }

    public CommentCategory addCommentCategory(CommentCategory c, int idWeb) throws SQLException {
        String sql = String.format("INSERT INTO %s(%s, %s) VALUES(?, ?)",
                TABLE_COMMENT_CATEGORY, NAME, ID_WEB);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getName());
        ps.setInt(2, idWeb);
        ps.executeUpdate();
        CommentCategory tmp = getCommentCategoryByName(c.getName(), idWeb);
        if (tmp == null) {
            return null;
        }
        c.setId(tmp.getId());
        return c;
    }

    public void deleteCommentCategory(CommentCategory c) throws SQLException {
        String sql = String.format("DELETE FROM %s WHERE %s = ?", TABLE_COMMENT_CATEGORY, ID);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, c.getId());
        ps.executeUpdate();
        //delete in comment table
        commentDao.deleteCommentByIdCategory(c.getId());
        
    }

    public void editCommentCategory(CommentCategory c) throws SQLException {
        String sql = String.format("UPDATE %s SET %s = ? WHERE %s = ?", TABLE_COMMENT_CATEGORY, NAME, ID);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getName());
        ps.setInt(2, c.getId());
        ps.executeUpdate();
    }

    public Vector<CommentCategory> getAllCommentCategory(int idWeb) throws SQLException {
        Vector<Account> accounts = new Vector<>();
        String sql = String.format("SELECT * FROM %s WHERE %s = ?", TABLE_COMMENT_CATEGORY, ID_WEB);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idWeb);
        ResultSet rs = ps.executeQuery();
        Vector<CommentCategory> commentCategorys = new Vector<>();
        while (rs.next()) {
            int id = rs.getInt(ID);
            String name = rs.getString(NAME);
            Vector<Comment> comments = commentDao.getAllCommentByCategoryId(id);
            commentCategorys.add(new CommentCategory(id, name, comments));
        }

        return commentCategorys;
    }

    public CommentCategory getCommentCategoryByName(String name, int idWeb) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?",
                TABLE_COMMENT_CATEGORY, NAME, ID_WEB);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, idWeb);
        ResultSet rs = ps.executeQuery();
        CommentCategory tmp = null;
        if (rs.next()) {
            tmp = new CommentCategory(rs.getInt(ID), rs.getString(NAME), null);
        }
        return tmp;
    }
}
