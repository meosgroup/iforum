/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.apps.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
            TABLE_ACCOUNT = "account",
                USERNAME = "username",
                PASSWORD = "password";

    public DBConnection() {
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
                    + PASSWORD + " " + STRING + " );";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        DBConnection conn = new DBConnection();
        Connection con = DBConnection.getConnection();
        System.out.println("Opened");
    }

}
