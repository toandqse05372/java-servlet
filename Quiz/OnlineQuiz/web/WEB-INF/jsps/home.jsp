<%-- 
    Document   : home
    Created on : Mar 14, 2018, 11:12:16 AM
    Author     : Trung's PC
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
        <style type="text/css">
            body {
                background: url("${pageContext.request.contextPath}/images/background.jpg");
            }
            .button {
                padding: 10px 15px;
                font-size: 14px;
                line-height: 100%;
                text-shadow: 0 1px rgba(0, 0, 0, 0.4);
                color: #fff;

                vertical-align: middle;
                text-align: center;
                cursor: pointer;
                font-weight: bold;
                transition: background 0.1s ease-in-out;
                -webkit-transition: background 0.1s ease-in-out;
                -moz-transition: background 0.1s ease-in-out;
                -ms-transition: background 0.1s ease-in-out;
                -o-transition: background 0.1s ease-in-out;
                text-shadow: 0 1px rgba(0, 0, 0, 0.3);
                color: #fff;
                -webkit-border-radius: 40px;
                -moz-border-radius: 40px;
                border-radius: 40px;
                font-family: 'Helvetica Neue', Helvetica, sans-serif;
            }

            .button, .button:hover, .button:active {
                outline: 0 none;
                text-decoration: none;
                color: #fff;
            }

            .username {
                background-color: #2ecc71;
                box-shadow: 0px 3px 0px 0px #239a55;
            }

        </style>
        <title>Online Quiz Home</title>
    </head>
    <body>
        <div id="cssmenu">
            <ul>
                <li class=''><a href='${pageContext.request.contextPath}'><span>Home</span></a></li>
                <li><a href='${pageContext.request.contextPath}/login'><span>Login</span></a></li>
                <li><a href='${pageContext.request.contextPath}/register'><span>Register</span></a></li>
                <li class='#'><a href='#'><span>Submit a Question</span></a></li>
                <li class='#'><a href='#'><span>Feedback</span></a></li>
                <li><a href='#'><span>Contribute</span></a></li>
                <li><a href='#'><span>Contact us</span></a></li>
            </ul>
        </div>

        <c:if test="${not empty sessionScope.user}">
            <div style="position:absolute;top:70px;left:1100px">
                Logged as <a href="#" class="button username">${sessionScope.user}</a>
            </div>

            <div style="position: absolute; top:70px; left: 1300px">
                <a href="${pageContext.request.contextPath}/logout">Logout</a>
            </div>
        </c:if>

        <div style="position:absolute;left:120px;top:60px">
            <table cellpadding="0" cellspacing="50">

                <tr>
                    <td><a href="takeExam?test=java"><img height="200" width="200" src="${pageContext.request.contextPath}/images/java.png"/></a></td>
                    <td><a href="takeExam?test=javascript"><img height="200" width="200" src="${pageContext.request.contextPath}/images/javascript.png"/></a></td>
                    <td><a href="takeExam?test=sql"><img height="200" width="200" src="${pageContext.request.contextPath}/images/sql-logo.png"/></a></td>
                    <td><a href="takeExam?test=python"><img height="200" width="200" src="${pageContext.request.contextPath}/images/python.jpg"/></a></td>
                </tr>

                <tr>
                    <td><a href="takeExam?test=css"><img height="200" width="200" src="${pageContext.request.contextPath}/images/css.jpg"/></a></td>
                    <td><a href="takeExam?test=php"><img height="200" width="200" src="${pageContext.request.contextPath}/images/php-logo.jpg"/></a></td>
                    <td><a href="takeExam?test=linux"><img height="200" width="200" src="${pageContext.request.contextPath}/images/logo-linux.png"/></a></td>
                    <td><a href="takeExam?test=mongodb"><img height="200" width="200" src="${pageContext.request.contextPath}/images/mongodb_logo.png"/></a></td>
                </tr>

            </table>
        </div>
    </body>
</html>
