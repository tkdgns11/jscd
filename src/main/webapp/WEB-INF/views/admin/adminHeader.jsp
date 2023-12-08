<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/header.css"/>">
    <script type="text/javascript" src="<c:url value="/js/header.js"/>"></script>
</head>
<div id="headerBox">
    <div id="headerTop">
        <div>
            <a href="/admin/home"><img src="<c:url value="/img/adminMainLogo.png"/>"
                                       style="width: 450px;height: 72px;margin-left: 300px"></a>
        </div>
        <ul>
            <li><a href="<c:url value='/admin/logout'/>">로그아웃</a></li>
            <li>|</li>
            <li><a href="<c:url value='/admin/read'/>">개인정보수정</a></li>
        </ul>
    </div>
</div>
</html>
