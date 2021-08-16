/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quiz.DatabaseConnectionFactory;

/**
 *
 * @author Trung's PC
 */
@WebServlet("/checkLogin")
public class LoginController extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection con = DatabaseConnectionFactory.createConnection();
        ResultSet rs = null;
        int i = 0;
        
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM users WHERE username='"+ username +"' AND password='"+ password +"'";
            System.out.println(query);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                i = 1;
            }
            if (i != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/home.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Invalid username or password");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            System.err.println("Error: While fetching records from database");
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println("Error: While closing connection");
        }
    }
    
}
