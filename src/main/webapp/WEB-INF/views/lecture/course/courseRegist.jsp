<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12/2/23
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>과정 등록</title>
  <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/home.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfo.css"/>">
</head>
<body>
<header>
  <jsp:include page="/WEB-INF/views/admin/header.jsp"/>
</header>
<div id="adminContent">
  <nav>
    <jsp:include page="/WEB-INF/views/admin/sidebar.jsp"/>
  </nav>
  <main>
    <form id="CourseAddForm" method="post" action="">
      <c:choose>
        <c:when test="${mode eq 'new'}">
          <div id="infoDetailBox" class="infoDetailClass">
            <h2 id="infoTitle">과정 등록</h2>
            <input type="text" name="courseName" placeholder="등록할 과정을 입력해주세요." value="${courseDto.courseName}">
            <input type="text" name="firstIdNO" placeholder="회원번호를 입력해주세요." value="${courseDto.firstIdNO}">
            <div id="infoDetailBtn">
              <button type="button" class="registeBtn">등록하기</button>
            </div>
          </div>
        </c:when>
        <c:when test="${mode ne 'new'}">
        <div id="infoDetailBox" class="infoDetailClass">
          <h2 id="infoTitle">과정 등록</h2>
          <label style="margin-right: 3px;">과정 번호</label>
          <input types="text" class="infoInputBox" name="courseCode" value="${courseDto.courseCode}">
          <label style="margin-right: 3px;">과정 이름</label>
          <input types="text" class="infoInputBox" name="courseName" value="${courseDto.courseName}">
          <label style="margin-right: 3px;">과정 등록일</label>
          <input types="text" class="infoInputBox" name="regDate" value="${courseDto.regDate}">
          <label style="margin-right: 3px;">과정 최초등록 식별자</label>
          <input types="text" class="infoInputBox" name="firstIdNO" value="${courseDto.firstIdNO}">
          <div id="infoDetailBtn">
            <button type="button" class="deleteBtn">삭제하기</button>
            <button type="button" class="modifyBtn">수정하기</button>
          </div>
        </div>
        </c:when>
      </c:choose>
    </form>
  </main>
</div>
</body>
<script>
  $(document).ready(function() {
    $("#registBt").on("click", function() {
      if(!confirm("해당 과정을 등록하시겠습니까?")) return;
      let form = $("#CourseAddForm");
      form.attr("action", "<c:url value='/adminManage/registCourse/addCourse'/>");
      form.attr("method", "post");
      form.submit();
    });

    $("#removeBtn").on("click", function() {
      let form = $("#CourseAddForm");
      form.attr("action", "<c:url value='/adminManage/registCourse/removeCourse?courseCode=${courseDto.courseCode}'/>");
      form.attr("method", "post");
      form.submit();
    });

    $("#modifyBtn").on("click", function() {
      let form = $("#CourseAddForm");
      form.attr("action", "<c:url value='/adminManage/registCourse/modifyCourse'/>");
      form.attr("method", "post");
      form.submit();
    })
  });
</script>
</html>
