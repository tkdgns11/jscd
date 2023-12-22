<%--
    에러 발생 페이지
  Created by IntelliJ IDEA.
  User: soheepark
  Date: 2023/12/13
  Time: 2:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | ERROR Page</title>
</head>
<body>
<h1>에러가 발생하였습니다. 다시 시도해주십시오.</h1>
<p>에러 메세지: ${errorMessage}</p>
</body>
</html>