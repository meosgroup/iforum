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
import vn.com.meo.group.iforum.models.WebCategory;

/**
 *
 * @author buian
 */
public class WebCategoryDao {
    private String 
        TABLE_WEB_CATEGORY = "category_web",
            ID = "id", 
            NAME = "category_name",
            URL = "url",
            ID_PARENT = "id_parent",
            ID_WEB = "id_web";
    
    private Connection con;
    
    public WebCategoryDao(){
        con = DBConnection.getConnection();
    }
    
    public Vector<WebCategory> getAllWebCategory(int idWeb) throws SQLException{
        String sql = String.format("SELECT * FROM %s WHERE %s = ?", TABLE_WEB_CATEGORY, ID_WEB);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idWeb);
        ResultSet rs = ps.executeQuery();
        Vector<WebCategory> webCategorys = new Vector<>();
        while(rs.next()){
            int id = rs.getInt(ID);
            String name = rs.getString(NAME);
            String url = rs.getString(URL);
            int idParent = rs.getInt(ID_PARENT);
            idWeb = rs.getInt(ID_WEB);
            webCategorys.add(new WebCategory(id, name, url, null));
        }
        return webCategorys;
    }
            
      
}
