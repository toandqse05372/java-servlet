/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.connection.DBConnection;
import com.entity.Share;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LongXuyen
 */
public class ShareDAO {
    public List<Share> getShare() throws Exception {
        List<Share> shares = new ArrayList<>();
        DBConnection dBConnection = new DBConnection();
        Connection conn = null; PreparedStatement ps = null; CallableStatement cs = null; ResultSet rs = null;
        String icon = null, socialNetwork = null, URL = null;
        try {
            String query = "select * from Share";
            conn = dBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                icon = dBConnection.getImagePath() + rs.getString("icon");
                socialNetwork = rs.getString("socialNetwork");
                URL = rs.getString("URL");
                shares.add(new Share(icon, socialNetwork, URL));
            }
            dBConnection.closeConnection(conn, ps, cs, rs);
        } catch (Exception e) {
            dBConnection.closeConnection(conn, ps, cs, rs);
            throw e;
        }
        return shares;
    }
}
