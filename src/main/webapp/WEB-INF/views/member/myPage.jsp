<%--
  Created by IntelliJ IDEA.
  User: jskang
  Date: 12/6/23
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <%--  <link rel="stylesheet" type="text/css" href="<c:url value="/css/myPage.css"/>">--%>
    <script type="text/javascript" src="<c:url value="/js/myPage.js"/>"></script>
    <title>myPage</title>
</head>
<body>
<div>
    <div>
        <ul>
            <li><a href="#">회원 정보 수정</a></li>
            <li><a href="#">강의 신청 현황</a></li>
        </ul>
    </div>
    <div>
        <ul>
            <li>아이디(이메일)</li>
            <input type="text" value="${memberDto.id}">
            <li>이름</li>
            <input type="text" value="${memberDto.name}">
            <li>비밀번호 변경</li>
            <input type="text">
            <li>비밀번호 변경 확인</li>
            <input type="text">
            <li>성별</li>
            <input type="text" value="${memberDto.gender== 0 ? '남' : '여'}">
            <li>생년월일</li>
            <input type="text" value="${memberDto.birth} " >
            <li>휴대 전화번호</li>
            <input type="text" value="${memberDto.phone}">
        </ul>
    </div>
    <div>
        <a href="<c:url value="/member/delete"/>">회원 탈퇴</a>
    </div>
</div>
</body>
</html>
