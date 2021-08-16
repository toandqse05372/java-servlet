<%-- 
    Document   : examReview
    Created on : Mar 28, 2018, 11:07:23 AM
    Author     : Trung's PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Review Exam</title>
        <style type="text/css">
            body {
                background: url("${pageContext.request.contextPath}/images/background.jpg");
            }
        </style>
    </head>
    <body>
        <h1 align="center">Quiz Review</h1>

        <c:forEach var="q" items="${requestScope.reviewQuestions}" varStatus="counter">
            <br/>
            ${counter.count}. ${q.question} <br/><br/>

            <c:forEach var="option" items="${q.questionOptions}" varStatus="counter">
                ${counter.count}.   ${option}<br/><br/>
            </c:forEach>

            <font color="green">Correct Answer: ${q.correctOptionIndex + 1}></font><br/>
            <br/>

            <c:if test='${q.userSelected == -1}'>
                <font color="#1334F1">Unanswered</font><br/>
            </c:if>
            <c:if test='${q.userSelected != -1}'>
                <font color="#1334F1">You Choosed: ${q.userSelected}></font><br/>
            </c:if>
            <c:if test='${q.userSelected == q.correctOptionIndex + 1}'>
                <img height="30" width="30" src="${pageContext.request.contextPath}/images/correct.png"/>
            </c:if>

            <c:if test='${q.userSelected != q.correctOptionIndex + 1}'>
                <img height="30" width="30" src="${pageContext.request.contextPath}/images/redcross.png"/>
            </c:if>
            <br/><br/>
        </c:forEach>
        <br/><br/>
        <div align="center">
            <a href="${pageContext.request.contextPath}"><img height="50" width="50" src="${pageContext.request.contextPath}/images/home.jpg"></img></a>
        </div>
    </body>
</html>
