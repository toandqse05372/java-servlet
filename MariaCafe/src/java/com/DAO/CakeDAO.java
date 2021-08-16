/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.connection.DBConnection;
import com.entity.Cake;
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
public class CakeDAO {

    public List<Cake> getTop2() throws Exception {
        List<Cake> cakes = new ArrayList<>();
        DBConnection dBConnection = new DBConnection();
        Connection conn = null; PreparedStatement ps = null; CallableStatement cs = null; ResultSet rs = null;
        int id = 0; 
        String name = null, picture = null, shortDescription = null;
        try {
            String query = "select top 2* from Products order by DateCreated desc";
            conn = dBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                picture = dBConnection.getImagePath() + rs.getString("picture");
                shortDescription = rs.getString("shortDescription");
                cakes.add(new Cake(id, name, picture, shortDescription));
            }
            dBConnection.closeConnection(conn, ps, cs, rs);
        } catch (Exception e) {
            dBConnection.closeConnection(conn, ps, cs, rs);
            throw e;
        }
        return cakes;
    }
    
    public Cake getCakeDetail(int CakeID) throws Exception {
        DBConnection dBConnection = new DBConnection();
        Connection conn = null; PreparedStatement ps = null; CallableStatement cs = null; ResultSet rs = null;
        int id = 0; 
        String name = null, picture = null, detailDescription = null;
        double price = 0;
        try {
            String query = "select * from Products where ID = ?";
            conn = dBConnection.getConnection();
            cs = conn.prepareCall(query);
            cs.setInt(1, CakeID);
            rs = cs.executeQuery();
            while (rs.next()) {                
                id = rs.getInt("id");
                name = rs.getString("name");
                picture = dBConnection.getImagePath() + rs.getString("picture");
                detailDescription = rs.getString("detailDescription");
                price = rs.getDouble("price");
            }
        } catch (Exception e) {
            dBConnection.closeConnection(conn, ps, cs, rs);
            throw e;
        }
        return new Cake(id, name, picture, detailDescription, price);
    }
    
    public int getTotalProducts() throws Exception {
        DBConnection dBConnection = new DBConnection();
        Connection conn = null; PreparedStatement ps = null; CallableStatement cs = null; ResultSet rs = null;
        int rows = 0;
        try {
            String query = "select count(*) from Products";
            conn = dBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            rows = 0;
            if(rs.next()) rows = rs.getInt(1);
            dBConnection.closeConnection(conn, ps, cs, rs);
        } catch (Exception e) {
            dBConnection.closeConnection(conn, ps, cs, rs);
            throw e;
        }
        return rows;
    }
    
    public int getTotalPages(int pageSize) throws Exception {
        return 1 + getTotalProducts() / pageSize;
    }
    
    public List<Cake> getAllCakes(int page, int pageSize) throws Exception {
        List<Cake> cakes = new ArrayList<>();
        DBConnection dBConnection = new DBConnection();
        Connection conn = null; PreparedStatement ps = null; CallableStatement cs = null; ResultSet rs = null;
        int id = 0; 
        String name = null, picture = null, shortDescription = null;
        try {
            String query = "select p.* from (select p.*, ROW_NUMBER() over (order by ID) as RowNumber"
                + " from Products p) p"
                + " where RowNumber between ? and ?";
            if (page == 0) page = 1;
            if (pageSize == 0) pageSize = 3;
            int from = (page  - 1) * pageSize + 1;
            int to = page * pageSize;
            conn = dBConnection.getConnection();
            cs = conn.prepareCall(query);
            cs.setInt(1, from);
            cs.setInt(2, to);
            rs = cs.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                picture = dBConnection.getImagePath() + rs.getString("picture");
                shortDescription = rs.getString("shortDescription");
                cakes.add(new Cake(id, name, picture, shortDescription));
            }
            dBConnection.closeConnection(conn, ps, cs, rs);
        } catch (Exception e) {
            dBConnection.closeConnection(conn, ps, cs, rs);
            throw e;
        }
        return cakes;
    }
    
}
