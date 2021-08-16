<%-- 
    Document   : Home
    Created on : Mar 1, 2018, 9:46:47 AM
    Author     : LongXuyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:useBean id="CakeBean" class="com.Bean.CakeBean" scope="request"/>
    <jsp:useBean id="IntroductionBean" class="com.Bean.IntroductionBean" scope="request"/>
    <jsp:useBean id="InformationBean" class="com.Bean.InformationBean" scope="request"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <div class="site-wrapper">
            <jsp:include page="Header.jsp"/>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <div class="section intro">
                            <div class="content">
                                <div class="img">
                                    <a href="Introduction.jsp"><img src="${IntroductionBean.introduction.picture}"/></a>
                                </div>
                                    <p class="content-title"><a href="Introduction.jsp">${IntroductionBean.introduction.title}</a></p>
                                ${IntroductionBean.introduction.shortDescription}
                            </div>
                        </div>
                        <div class="section">
                            <div class="content">
                                <ul>
                                    <c:forEach var="top2" items="${CakeBean.top2}">
                                        <c:url var="detail" value="CakeDetail.jsp">
                                            <c:param name="id" value="${top2.id}"/>
                                        </c:url>
                                        <li class="product">
                                            <div class="img"><a href="${detail}"><img src="${top2.picture}"></a></div>
                                            <div class="product-tittle"><a href="${detail}">${top2.name}</a></div>
                                            <p>${top2.shortDescription}</p>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="section intro">
                            <div class="content">
                                <div class="content-title">Visit my cafe</div>
                                <br/>
                                <p>${InformationBean.infomation.shortDescription}</p>
                                <p>${InformationBean.infomation.address}</p>
                                <p>Phone: ${InformationBean.infomation.tel}</p>
                            </div>
                        </div>
                        <div class="section intro">
                            <div class="content">
                                Kind regards<br/>
                                <div class="signature">${InformationBean.infomation.signature}</div>
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
