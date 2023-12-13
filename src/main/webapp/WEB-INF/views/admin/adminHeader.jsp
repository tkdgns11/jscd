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
    <script type="text/javascript" src="<c:url value="/js/header.js"/>"></script>
    <style>
        html,
        body {
            height: 100%;
            width: 100%;
            margin: 0;
            padding: 0;
        }

        .admin_group {
            color: #f1f1f1;
            padding: 1rem 1rem 1rem 1rem;
            text-decoration: none;
            font-size: 25px;
            margin-top: 1rem;
        }

        #admin_title {
            margin-left: 45%;
            float:left;
            color: #f1f1f1;
            padding: 1rem 1rem 1rem 1rem;
            text-decoration: none;
            font-size: 25px;
        }

    </style>
</head>
<body>

<div id="headerBox" style="height: 50px; position: fixed; top: 0; left: 0; width: 100%;  background-color: #182566;  color: #f1f1f1;
z-index: 1000; float: right;/">
    <div id="headerTop">
        <h1 id="admin_title">정석코딩 관리자 시스템</h1>
        <ul style="display: flex; flex-direction: row; flex-warp:nowrap; justify-content: flex-end; align-items: center">
            <li><a class = "admin_group" href="<c:url value='/admin/logout'/>">로그아웃</a></li>
            <li>|</li>
            <li><a class = "admin_group" href="<c:url value='/admin/read'/>">개인정보수정</a></li>
        </ul>
    </div>
</div>
</body>
</html>
