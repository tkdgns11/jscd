<%--
결제 완료 페이지 (계좌이체)
http://localhost:8080/order/actPaySuccess
  Created by IntelliJ IDEA.
  User: soheepark
  Date: 2023/12/10
  Time: 15:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- 탭 아이콘 & 글자 지정 -->
  <link rel="icon" href="/img/logo.png" />
  <link rel="apple-touch-icon" href="/img/logo.png" />
  <title>정석코딩 | 결제완료</title>

  <!-- css 파일 불러오기 -->
  <link rel="stylesheet" href="/css/reset.css" type="text/css" />
</head>
<body>
<header>
  <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
</header>
<%--전체 페이지--%>
<div>
  <p>현금 결제 신청 완료</p>
</div>
<footer>
  <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</body>

</html>
