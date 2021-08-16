<%-- 
    Document   : CakeDetail
    Created on : Mar 1, 2018, 11:06:08 AM
    Author     : LongXuyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:useBean id="CakeBean" class="com.Bean.CakeBean" scope="request"/>
    <jsp:setProperty name="CakeBean" property="cakeID" param="id"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${CakeBean.cakeDetail.name}</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <div class="site-wrapper">
            <jsp:include page="Header.jsp"/>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <div class="section cake">
                            <p class="product-name">${CakeBean.cakeDetail.name}</p>
                            <div class="content">
                                <div class="cake-img">
                                    <img src="${CakeBean.cakeDetail.picture}">
                                </div>
                                ${CakeBean.cakeDetail.detailDescription}
                                <p><div class="span">Price: <span style="color: red">${CakeBean.cakeDetail.price}$</span></div></p>
                            </div>
                        </div>
                    </div>
                    <jsp:include page="ShareBox.jsp"/>
                </div>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
