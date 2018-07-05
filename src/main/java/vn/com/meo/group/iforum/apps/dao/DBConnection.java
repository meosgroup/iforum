/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.apps.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class DBConnection {
//    private static final DBConnection con = new DBConnection();

    private static Connection con;
    
    private String DBNAME = "iforum.db",
            ID = "id",
            PRIMARY_KEY = "PRIMARY KEY",
            AUTOINCREMENT = "AUTOINCREMENT",
            STRING = "string",
            INTEGER = "integer",
            DATE = "date",
            TABLE_ACCOUNT = "account",
                USERNAME = "username",
                PASSWORD = "password",
                ID_WEB = "id_web",
                REGISTER = "register",
            TABLE_WEBSITE = "website",
                NAME_WEB = "name_web",
            TABLE_CATEGORY_WEB = "category_web",
                CATEGORY_NAME = "category_name",
                URL_CATEGORY_WEB = "url",
                ID_PARENT = "id_parent",
                ID_WEB_CATEGORY_WEB = "id_web",
            TABLE_POST = "post",
                TITLE = "title",
                CONTENT = "content",
                ID_ACCOUNT = "id_account",
                ID_CATEGORY_WEB = "id_category_web",
            TABLE_COMMENT = "comment",
                CONTENT_COMMENT = "conetent_comment",
                CONTENT_REPLY = "content_reply",
                ID_CATEGORY_COMMENT = "id_category",
            TABLE_CATEGORY_COMMENT = "category_comment",
                NAME_CATEGORY_COMMENT = "name",
            TABLE_COMMENT_REPLY_POST = "comment_reply_post",
                ID_POST = "id_post",
//                ID_ACCOUNT = "id_account",
                ID_COMMENT = "id_comment",
                DATE_COMMENT = "date",
                TYPE = "type";

    public DBConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:iforum.db");
            createTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:iforum.db");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return con;
        }
        return con;
    }
    
    public void init(){
        createTable();
    }

    private void createTable() {
        try {
            Statement statement = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_ACCOUNT + " ( "
                    + ID + " " + INTEGER + " " + PRIMARY_KEY + " " + AUTOINCREMENT + " , "
                    + USERNAME + " " + STRING + " , "
                    + PASSWORD + " " + STRING + " , "
                    + ID_WEB + " " + INTEGER + " , "
                    + REGISTER + " " + INTEGER + " );";
            statement.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS " + TABLE_WEBSITE + " ( "
                    + ID + " " + INTEGER + " " + PRIMARY_KEY + " " + AUTOINCREMENT + " , "
                    + NAME_WEB + " " + STRING + " );";
            statement.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS " + TABLE_CATEGORY_WEB + " ( "
                    + ID + " " + INTEGER + " " + PRIMARY_KEY + " " + AUTOINCREMENT + " , "
                    + CATEGORY_NAME + " " + STRING + " , "
                    + URL_CATEGORY_WEB + " " + STRING + " , "
                    + ID_PARENT + " " + INTEGER + " , "
                    + ID_WEB_CATEGORY_WEB + " " + INTEGER + " );";
            statement.executeUpdate(sql);
            sql =  "CREATE TABLE IF NOT EXISTS " + TABLE_POST + " ( "
                    + ID + " " + INTEGER + " " + PRIMARY_KEY + " " + AUTOINCREMENT + " , "
                    + TITLE + " " + STRING + " , "
                    + CONTENT + " " + STRING + " , "
                    + ID_ACCOUNT + " " + INTEGER + " , "
                    + ID_CATEGORY_WEB + " " + INTEGER + " );";
            statement.executeUpdate(sql);
            sql =  "CREATE TABLE IF NOT EXISTS " + TABLE_COMMENT + " ( "
                    + ID + " " + INTEGER + " " + PRIMARY_KEY + " " + AUTOINCREMENT + " , "
                    + CONTENT_COMMENT + " " + STRING + " , "
                    + CONTENT_REPLY + " " + STRING + " , "
                    + ID_CATEGORY_COMMENT + " " + INTEGER + " );";
            statement.executeUpdate(sql);
            sql =  "CREATE TABLE IF NOT EXISTS " + TABLE_CATEGORY_COMMENT + " ( "
                    + ID + " " + INTEGER + " " + PRIMARY_KEY + " " + AUTOINCREMENT + " , "
                    + NAME_CATEGORY_COMMENT + " " + STRING + " );";
            statement.executeUpdate(sql);
            sql =  "CREATE TABLE IF NOT EXISTS " + TABLE_COMMENT_REPLY_POST + " ( "
                    + ID + " " + INTEGER + " " + PRIMARY_KEY + " " + AUTOINCREMENT + " , "
                    + ID_POST + " " + INTEGER + " , "
                    + ID_ACCOUNT + " " + INTEGER + " , "
                    + ID_COMMENT + " " + INTEGER + " , "
                    + DATE_COMMENT + " " + INTEGER + " , "
                    + TYPE + " " + STRING + " );";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void main(String[] args) {
//        try {
//            DBConnection conn = new DBConnection();
//            Connection con = DBConnection.getConnection();
//            System.out.println("Opened");
//            DatabaseMetaData m = con.getMetaData();
//            ResultSet tables = m.getTables(null, null, "%", null);
//            while(tables.next()){
//                System.out.println(tables.getString(3));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//    }

}
