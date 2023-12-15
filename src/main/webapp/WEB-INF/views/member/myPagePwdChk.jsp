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
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/myPage.css"/>">
  <script type="text/javascript" src="<c:url value="/js/myPage.js"/>"></script>
    <title>myPage</title>
</head>
<body>
<header>
  <jsp:include page="../header.jsp"/>
</header>
  <div id="myPagePwdChkBox">
    <nav>
      <ul>
        <li><a href="#">회원 정보 수정</a></li>
        <li><a href="#">강의 신청 현황</a></li>
      </ul>
    </nav>
    <div>
      <p>비밀번호 입력</p>
      <div id="myPagePwdChk">
        <input type="password" name="pwd" placeholder="&nbsp&nbsp&nbsp비밀번호 입력">
      </div>
      <input type="button" value="확인" class="modifyBtn">
    </div>
  </div>
<header>
  <jsp:include page="../footer.jsp"/>
</header>
</body>
</html>
