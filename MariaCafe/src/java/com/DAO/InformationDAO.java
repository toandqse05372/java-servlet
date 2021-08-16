/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.connection.DBConnection;
import com.entity.Information;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author LongXuyen
 */
public class InformationDAO {
    public Information getInfomation() throws Exception {
        DBConnection dBConnection = new DBConnection();
        Connection conn = null; PreparedStatement ps = null; CallableStatement cs = null; ResultSet rs = null;
        String shortDescription = null, address = null, tel = null, email = null, openingHours = null, signature = null;
        try {
            String query = "select * from Information";
            conn = dBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                shortDescription = rs.getString("shortDescription");
                address = rs.getString("address");
                tel = rs.getString("tel");
                email = rs.getString("email");
                openingHours = rs.getString("openingHours");
                signature = rs.getString("signature");
            }
            dBConnection.closeConnection(conn, ps, cs, rs);
        } catch (Exception e) {
            dBConnection.closeConnection(conn, ps, cs, rs);
            throw e;
        }
        return new Information(shortDescription, address, tel, email, openingHours, signature);
    }
}
