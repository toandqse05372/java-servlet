/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quiz.DatabaseConnectionFactory;

/**
 *
 * @author Trung's PC
 */
@WebServlet("/checkRegister")
public class RegistrationController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public RegistrationController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection con = DatabaseConnectionFactory.createConnection();
        try {
            Statement stmt = con.createStatement();
            String query = "INSERT INTO users VALUES ('" + username + "','" + email + "','" + password + "')";
            System.out.println(query);
            stmt.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Error: while inserting record in database");
        }
        try {
            con.close();
        } catch (SQLException ex) {
            System.err.println("Error: While closing Connection");
        }
        request.setAttribute("newUser", username);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/regSuccess.jsp");
        dispatcher.forward(request, response);
    }

}
