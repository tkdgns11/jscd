<%--
  Created by IntelliJ IDEA.
  User: wjdtn
  Date: 2023-12-19
  Time: 오전 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/home.css"/>">
    <title>Home</title>
</head>
<body>
<header>
    <header>
        <jsp:include page="header.jsp"/>
    </header>
</header>
<div id="adminContent">
    <nav>
        <jsp:include page="sidebar.jsp"/>
    </nav>
    <main>
        <h1>dashBoard</h1>
    </main>
</div>
</body>
</html>
