<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 11.11.19
  Time: 09:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Witaj</title>
    <style>
        a {
            margin-right: 100px;
            line-height: 250px;
        }
    </style>
</head>
<body>
<sec:authorize access="isAnonymous()">
    <center><h2>
        <a href="/login"> Zaloguj się</a>

        <a href="/register"> Zarejestruj się! </a>
    </h2></center>
</sec:authorize>

<%--==============================================--%>
<br>
<sec:authorize access="hasAnyRole('ADMIN', 'USER')">
    <h2>
        <center><strong><a href="/user">Wejdź do gry</a></strong></center>
    </h2>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <center><strong><a href="/admin">Przejdź do panelu admina</a></strong></center>
</sec:authorize>


</body>
</html>
