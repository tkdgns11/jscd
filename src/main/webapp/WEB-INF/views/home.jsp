<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/>">
</head>
<body>
<div id="content">
	<header>
		<jsp:include page="header.jsp"/>
	</header>
	<main style="background-color: pink; height: 900px" >
		<h1>홈입니다.</h1>
	</main>
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>
</div>
</body>
</html>
