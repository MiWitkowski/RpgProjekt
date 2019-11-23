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
</head>
<body>
<sec:authorize access="isAnonymous()">

<h3>
    Zaloguj się:
    <a href="/login"> Zaloguj się</a>

    Zarejestruj się:
    <a href="/register"> Zarejestruj się! </a>

    </sec:authorize>
</h3>

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
