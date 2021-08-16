/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author LongXuyen
 */
public class DBConnection {
    public Connection getConnection() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            InitialContext context = new InitialContext();
            Context xmlNode = (Context) context.lookup("java:comp/env");
            String myConnection = (String) xmlNode.lookup("myConnection");
            String dbUsername = (String) xmlNode.lookup("dbUsername");
            String dbPassword = (String) xmlNode.lookup("dbPassword");
            return DriverManager.getConnection(myConnection, dbUsername, dbPassword);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public String getImagePath() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            InitialContext context = new InitialContext();
            Context xmlNode = (Context) context.lookup("java:comp/env");
            String imagePath = (String) xmlNode.lookup("imagePath");
            return imagePath;
        } catch (Exception e) {
            throw e;
        }
    }

    public void closeConnection(Connection conn, PreparedStatement ps, CallableStatement cs, ResultSet rs) throws Exception {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (cs != null && !cs.isClosed()) {
                cs.close();
            }
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (Exception e) {
            throw e;
        }

    }
}
