/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.connection.DBConnection;
import com.entity.Introduction;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author LongXuyen
 */
public class IntroductionDAO {
    public Introduction getIntroduction() throws Exception {
        DBConnection dBConnection = new DBConnection();
        Connection conn = null; PreparedStatement ps = null; CallableStatement cs = null; ResultSet rs = null;
        String title = null, picture = null, shortDescription = null, detailDescription = null;
        try {
            String query = "select * from Intro";
            conn = dBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                title = rs.getString("title");
                picture = dBConnection.getImagePath() + rs.getString("picture");
                shortDescription = rs.getString("shortDescription");
                detailDescription = rs.getString("detailDescription");
            }
            dBConnection.closeConnection(conn, ps, cs, rs);
        } catch (Exception e) {
            dBConnection.closeConnection(conn, ps, cs, rs);
            throw e;
        }
        return new Introduction(title, picture, shortDescription, detailDescription);
    }
}
