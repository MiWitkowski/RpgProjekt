<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 09.11.19
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@ page isELIgnored="false"%>--%>

<html>
<head>
    <title>Panel Administratora</title>
<style>table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}
</style>

    <%--
    <link rel="stylesheet" type="text/css" href="css/styles.css" >
--%>

    <%--<link rel="stylesheet" type="text/css" href="resources/css/styles.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styles.css"/>--%>
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}css/styles.css"/>--%>
    <%--<style>
        @import url('/css/styles.css');
    </style>--%>
</head>
<body>

<h1>Panel administratora</h1>
<table>
    <tr>
        <th>
            <p><a href="admin/showUsers">Wyświetl użytkowników</a></p>
        </th>
        <th>
            <p><a href="admin/addMonster">Dodaj potworka</a></p>
        </th>

    </tr>
</table>

<h2><a href="/logout">Wyloguj się</a></h2>

</body>
</html>
