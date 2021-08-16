<%-- 
    Document   : ShareBox
    Created on : Mar 1, 2018, 9:19:31 AM
    Author     : LongXuyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:useBean id="ShareBean" class="com.Bean.ShareBean" scope="request"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <div class="content-right">
            <div class="share-box">
                <div class="share-header">Share this page</div>
                <div class="share-content">
                    <c:forEach var="share" items="${ShareBean.share}">
                        <div>
                            <a href="${share.URL}">
                                <img src="${share.icon}"> 
                                Share on ${share.socialNetwork}
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
