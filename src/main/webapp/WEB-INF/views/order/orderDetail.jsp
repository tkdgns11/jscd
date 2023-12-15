<%--
주문 상세 내역 페이지
http://localhost:8080/order/orderDetail?odNo=jscd20231212025948340
  Created by IntelliJ IDEA.
  User: soheepark
  Date: 2023/12/12
  Time: 01:02 PM
  To change this template use File | Settings | File Templates.
--%>
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
<!-- 전체 페이지 -->
<div id="orderDetail">
    <div>
        <p>주문 상세 내역 페이지</p>
    </div>
    <!-- 주문 상세 내역 표시 -->
    <div id="orderDetailContent">
        <h2>주문 상세 내역</h2>
        <p>ID: ${id}</p>
        <p>이름: ${name}</p>
        <p>주문번호: ${odNo}</p>
        <p>결제 상태: ${status}</p>
        <p>결제일: ${payDate}</p>
        <p>결제 시각: ${payTime}</p>
        <p>상품 코드: ${registCode}</p>
        <p>구매 상품: ${title}</p>
        <p>상품 가격: ${lastPrice}</p>
        <p>결제 고유 번호: ${htyNo}</p>
        <p>결제 종류: ${payType}</p>
        <p>카드 종류: ${cardType}</p>
        <p>카드 번호: ${creditNum}</p>
        <p>할부개월: ${instlFees}</p>
        <p>현금영수증 번호: ${csrcNum}</p>
        <p>사용자 지불 계좌번호: ${userActNum}</p>
        <p>최종 결제 금액: ${lastPrice}</p>
    </div>
    <div id="companyinfo">
        <h2>공급자</h2>
        <table>
            <tr>
                <th>공급자 고유 번호</th>
                <th>상업자등록번호</th>
                <th>상호명</th>
                <th>공급자명</th>
                <th>연락처</th>
                <th>주소</th>
                <th>업태</th>
                <th>종목</th>
            </tr>
            <tr>
                <td>${slrNo}</td>
                <td>${slrNum}</td>
                <td>${companyName}</td>
                <td>${slrName}</td>
                <td>${slrPhone}</td>
                <td>${slrAddr}</td>
                <td>${indst}</td>
                <td>${kind}</td>
            </tr>
        </table>
    </div>
</div>
<footer>
    <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</body>
</html>

