<%--
  Created by IntelliJ IDEA.
  User: wjdtn
  Date: 2023-12-19
  Time: 오후 12:22
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
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/sidebar.css"/>">
  <title>Home</title>
</head>
<body>
<ul class="menu">
  <li>
    <a href="#">정석코딩</a>
    <ul class="submenu">
      <li><a href="/admin/home">대시보드</a></li>
      <li><a href="/">정석코딩 바로가기</a></li>
      <li><a href="#">submenu03</a></li>
      <li><a href="#">submenu04</a></li>
      <li><a href="#">submenu05</a></li>
    </ul>
  </li>
  <li>
    <a href="#">학사관리</a>
    <ul class="submenu">
      <li><a href="/adminManage/stdManage/list">학생정보</a></li>
      <li><a href="/adminManage/instructor/list">강사관리</a></li>
      <li><a href="/adminManage/memberManage/list">회원관리</a></li>
    </ul>
  </li>
  <li>
    <a href="#">교육등록</a>
    <ul class="submenu">
      <li><a href="#">부트캠프</a></li>
      <li><a href="#">세미나</a></li>
    </ul>
  </li>
  <li>
    <a href="#">커뮤니티</a>
    <ul class="submenu">
      <li><a href="#">전체공지</a></li>
      <li><a href="#">학생공지</a></li>
    </ul>
  </li>
  <li>
    <a href="#">시설물</a>
    <ul class="submenu">
      <li><a href="#">강의실</a></li>
      <li><a href="#">사물함</a></li>
    </ul>
  </li>
</ul>
</body>
</html>
