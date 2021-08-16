<%-- 
    Document   : Introduction
    Created on : Mar 1, 2018, 10:17:53 AM
    Author     : LongXuyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="IntroductionBean" class="com.Bean.IntroductionBean" scope="request"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Introduction</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <div class="site-wrapper">
            <jsp:include page="Header.jsp"/>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <div class="section cake">
                            <p class="product-name">${IntroductionBean.introduction.title}</p>
                            <div class="content">
                                <div class="cake-img">
                                    <img src="${IntroductionBean.introduction.picture}">
                                </div>
                                    ${IntroductionBean.introduction.detailDescription}
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
