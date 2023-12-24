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

        <input type="hidden" class="memberStatus" value="${memberStatus.memberCnt}">
        <input type="hidden" class="memberStatus" value="${memberStatus.studentCnt}">
        <input type="hidden" class="memberStatus" value="${memberStatus.teacherCnt}">
        <input type="hidden" class="memberStatus" value="${memberStatus.managerCnt}">
        <input type="hidden" class="memberStatus" value="${memberStatus.firstManagerCnt}">
        <input type="hidden" class="memberStatus" value="${memberStatus.memberTotalCnt}">

        <input type="hidden" class="salesStatus" value="${salesStatus.btPriceTotal}">
        <input type="hidden" class="salesStatus" value="${salesStatus.smPriceTotal}">

        <input type="hidden" class="lstRegistStatus" value="${lstRegistStatus.btProceedingCnt}">
        <input type="hidden" class="lstRegistStatus" value="${lstRegistStatus.btExpectedCnt}">
        <input type="hidden" class="lstRegistStatus" value="${lstRegistStatus.btEndCnt}">
        <input type="hidden" class="lstRegistStatus" value="${lstRegistStatus.btTotalCnt}">
        <input type="hidden" class="lstRegistStatus" value="${lstRegistStatus.smProceedingCnt}">
        <input type="hidden" class="lstRegistStatus" value="${lstRegistStatus.smExpectedCnt}">
        <input type="hidden" class="lstRegistStatus" value="${lstRegistStatus.smEndCnt}">
        <input type="hidden" class="lstRegistStatus" value="${lstRegistStatus.smTotalCnt}">

        <input type="hidden" class="qnaCategoryStatus" value="${qnaCategoryStatus.qnaBtCnt}">
        <input type="hidden" class="qnaCategoryStatus" value="${qnaCategoryStatus.qnaSmCnt}">
        <input type="hidden" class="qnaCategoryStatus" value="${qnaCategoryStatus.qnaPayRefCnt}">
        <input type="hidden" class="qnaCategoryStatus" value="${qnaCategoryStatus.qnaSiteUseCnt}">
        <input type="hidden" class="qnaCategoryStatus" value="${qnaCategoryStatus.qnaAcademyCnt}">
        <input type="hidden" class="qnaCategoryStatus" value="${qnaCategoryStatus.qnaEtcCnt}">
        <input type="hidden" class="qnaCategoryStatus" value="${qnaCategoryStatus.qnaTotalCnt}">


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
            <div class="Clock">
                <div id="Clockday">00/00/00</div>
                <div id="Clock">00:00</div>
            </div>
        </div>
    </main>
</div>
</body>
</html>
