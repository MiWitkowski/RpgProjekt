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
    <link rel="stylesheet" href="/resources/css/bootstrap.css">

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
    <div style="text-align: center;">
        <h2>
            <a href="/login"> Zaloguj się</a>
            <a href="/register"> Zarejestruj się! </a>
        </h2>
    </div>
</sec:authorize>

<%--==============================================--%>
<br>
<sec:authorize access="hasAnyRole('ADMIN', 'USER')">
    <div style="text-align: center;">
        <h2>
            <strong><a href="/user">Wejdź do gry</a></strong>
        </h2>
    </div>

</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <div style="text-align: center;">
        <strong><a href="/admin">Przejdź do panelu admina</a></strong>
    </div>
</sec:authorize>

</body>
</html>
