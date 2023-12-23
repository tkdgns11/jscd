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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    <script type="text/javascript" src="<c:url value="/js/admin/home.js"/>"></script>
    <title>Home</title>
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<div id="adminContent">
    <nav>
        <jsp:include page="sidebar.jsp"/>
    </nav>
    <main>
        <div id="dashboardBox">
            <div id="barChartBox">
                <canvas id="bar-chart" width="300" height="230"></canvas>
            </div>
            <div id="lineChartBox">
                <canvas id="line-chart" width="300" height="250"></canvas>
            </div>
            <div id="pieChartBox">
                <canvas id="pie-chart" width="250" height="250"></canvas>
            </div>
            <div id="barChartHorizontalBox">
                <canvas id="bar-chart-horizontal" width="600" height="250"></canvas>
            </div>
            <div id="todayBox">
                <h1>today</h1>
                <h1>전체 방문자 수 : </h1>
                <h1>일일 방문자 수 : </h1>
            </div>
        </div>
    </main>
</div>
</body>
</html>
