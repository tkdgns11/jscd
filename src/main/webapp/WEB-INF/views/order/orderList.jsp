<%--
주문내역 확인 페이지
http://localhost:8080/order/orderList
  Created by IntelliJ IDEA.
  User: soheepark
  Date: 2023/12/12
  Time: 16:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%--<%@ page import="com.jscd.app.order.dto.OrderDTO" %>--%>
<%--<% OrderDTO orderDto = (OrderDTO) request.getAttribute("orderDto"); %>--%>

<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jscd.app.order.dto.StodDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/logo.png"/>
    <link rel="apple-touch-icon" href="/img/logo.png"/>
    <title>정석코딩 | 주문내역</title>

    <!-- css 파일 불러오기 -->
    <link rel="stylesheet" href="/css/reset.css" type="text/css"/>

</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
</header>
<%--<form id="orderData">--%>
<%--  <input type="text" id="odNo" name="odNo">--%>
<%--  <input type="text" id="id" name="id" value="${memberDto.id}">--%>
<%--  <input type="text" id="name" name="name" value="${memberDto.name}">--%>
<%--  <input type="text" id="phone" name="phone" value="${memberDto.phone}">--%>

<%--  <input type="text" id="registCode" name="registCode" value="${orderDto.registCode}">--%>
<%--  <input type="text" id="title" name="title" value="${orderDto.title}">--%>
<%--  <input type="text" id="lastPrice" name="lastPrice" value="${orderDto.lastPrice}">--%>

<%--  <input type="text" id="slrNo" name="slrNo" value="${companyInfoDto.slrNo}">--%>
<%--  <input type="text" id="slrName" name="slrName" value="${companyInfoDto.slrName}">--%>
<%--  <input type="text" id="slrNum" name="slrNum" value="${companyInfoDto.slrNum}">--%>
<%--  <input type="text" id="actName" name="actName" value="${companyInfoDto.actName}">--%>
<%--  <input type="text" id="actNum" name="actNum" value="${companyInfoDto.actNum}">--%>
<%--  <input type="text" id="slrAddr" name="slrAddr" value="${companyInfoDto.slrAddr}">--%>
<%--  <input type="text" id="companyName" name="companyName" value="${companyInfoDto.companyName}">--%>
<%--  <input type="text" id="indst" name="indst" value="${companyInfoDto.indst}">--%>
<%--  <input type="text" id="kind" name="kind" value="${companyInfoDto.kind}">--%>
<%--  <input type="text" id="slrPhone" name="slrPhone" value="${companyInfoDto.slrPhone}">--%>

<%--&lt;%&ndash;  추가&ndash;%&gt;--%>
<%--  <input type="text" id="creditNum" name="creditNum">--%>
<%--  <input type="text" id="cardType" name="cardType">--%>
<%--  <input type="text" id="payType" name="payType">--%>
<%--  <input type="text" id="payDay" name="payDay">--%>
<%--  <input type="text" id="payTime" name="payTime">--%>
<%--  <input type="text" id="status" name="status">--%>
<%--  <input type="text" id="instlFees" name="instlFees">--%>
<%--</form>--%>
<!-- 전체 페이지 -->
<div id="orderList">
    <div>
        <p>주문내역 페이지</p>
    </div>
    <!-- 주문 내역 표시 -->
    <div>
        <h2>주문 내역</h2>
        <table>
            <thead>
            <tr>
                <th>주문 번호</th>
                <th>주문 일시</th>
                <th>주문 상태</th>
                <th>상품 제목</th>
                <th>가격</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orderList}" var="order">
                <tr>
                    <td>${order.odNo}</td>
                    <td>${order.regDate}</td>
                    <td>
                        <%--            JSTL의 <c:choose> 이용 : switch-case문과 동작 비슷함--%>
                        <%--            '주문 상태' 데이터값에 따라 텍스트 보여주기--%>
                        <c:choose>
<%--                          1. ${order.status} == 'paid' : 결제 완료--%>
                            <c:when test="${order.status eq 'paid'}">결제 완료</c:when>
<%--                          2.  ${order.status} == 'notPaid' : 결제 대기중--%>
                            <c:when test="${order.status eq 'notPaid'}">결제 대기중</c:when>
<%--                          3.  ${order.status} == 'cancel' : 결제 취소--%>
                            <c:when test="${order.status eq 'cancel'}">결제 취소</c:when>
<%--                          3.  나머지 값 : 해당 값 그대로 표시--%>
                            <c:otherwise>${order.status}</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${order.title}</td>
                    <td>${order.lastPrice}</td>
                    <td><a href="/order/orderDetail?odNo=${order.odNo}">주문 상세 내역</a></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>
<footer>
    <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</body>


</html>
