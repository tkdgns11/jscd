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
  <title>Title</title>
  <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<form id="CourseAddForm" method="post" action="">
  <c:choose>
    <c:when test="${mode eq 'new'}">
      <input type="text" name="courseName" placeholder="등록할 과정을 입력해주세요." value="${courseDto.courseName}">
      <input type="text" name="firstIdNo" placeholder="회원번호를 입력해주세요." value="${courseDto.firstIdNo}">
      <button type="button" id="registBt">등록하기</button>
    </c:when>
    <c:when test="${mode ne 'new'}">
      <input types="text" name="courseCode" value="${courseDto.courseCode}">
      <input types="text" name="courseName" value="${courseDto.courseName}">
      <input types="text" name="regDate" value="${courseDto.regDate}">
      <input types="text" name="firstIdNo" value="${courseDto.firstIdNo}">
      <button type="button" id="removeBtn">삭제하기</button>
      <button type="button" id="modifyBtn">수정하기</button>
    </c:when>
  </c:choose>
</form>
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
