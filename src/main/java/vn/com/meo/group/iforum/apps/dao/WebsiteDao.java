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
import vn.com.meo.group.iforum.models.Website;

/**
 *
 * @author buian
 */
public class WebsiteDao {
    private String
        TABLE_WEBSITE = "website",
           ID = "id",
           NAME = "name_web";
    private Connection con;
    public WebsiteDao(){
        con = DBConnection.getConnection();
    }
    
    public Website getWebsiteByName(String name) throws SQLException{
        String sql = String.format("SELECT * FROM %s WHERE %s = ?", TABLE_WEBSITE, NAME);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int id = rs.getInt(ID);
            name = rs.getString(NAME);
            return new Website(id, name);
        }
        return null;
    }
    
}
