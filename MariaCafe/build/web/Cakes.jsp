<%-- 
    Document   : Cakes
    Created on : Mar 1, 2018, 11:04:40 AM
    Author     : LongXuyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="CakeBean" class="com.Bean.CakeBean" scope="request"/>
    <jsp:setProperty name="CakeBean" property="page" param="page"/>
    <jsp:setProperty name="CakeBean" property="pageSize" param="pageSize"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About Cakes</title>
        <link rel="stylesheet" href="css/style.css"/>
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        <div class="site-wrapper">
            <jsp:include page="Header.jsp"/>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <ul class="container-list">
                            <c:forEach var="cakes" items="${CakeBean.allCakes}">
                                <c:url var="cake" value="CakeDetail.jsp">
                                    <c:param name="id" value="${cakes.id}"/>
                                </c:url>
                                <li class="each-product">
                                    <div class="content">
                                        <div class="image">
                                            <a href="${cake}"><img src="${cakes.picture}"></a>
                                        </div>
                                        <p class="product-tittle"><a href="${cake}">${cakes.name}</a></p>
                                            ${cakes.shortDescription}
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                        <div class="page" id="page">
                            <p><c:forEach var="i" begin="1" end="${CakeBean.totalPages}">
                                    <c:url var="u" value="Cakes.jsp">
                                        <c:param name="page" value="${i}"/>
                                    </c:url>
                                    <a href="${u}">${i}</a>
                                </c:forEach></p>
                        </div>
                    </div>
                    <jsp:include page="ShareBox.jsp"/>
                </div>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
    <script>
        DisabledLink();
    </script>
</html>
