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
  <script type="text/javascript" src="<c:url value="/js/myPagePwdChk.js"/>"></script>

  <title>myPage</title>
  <script>
    let msg = "${param.msg}";
    if (msg == "PWD_ERR") alert("비밀번호가 일치하지 않습니다.다시 시도해 주세요.");
  </script>
</head>
<body>
<header>
  <jsp:include page="../header.jsp"/>
</header>
  <div id="myPagePwdChkBox">
    <nav>
      <ul>
        <li><a href="/member/memberEdit">회원 정보 수정</a></li>
        <li><a href="/member/lectureApplyState">강의 신청 현황</a></li>
        <c:if test="${memberDto.getGrade() eq '3'}">
          <li><a href="/member/instructorIntro">강사 소개말 작성</a></li>
        </c:if>
      </ul>
    </nav>
    <div>
      <p>비밀번호 입력</p>
      <div id="myPagePwdChk">
        <input type="password" name="pwd" placeholder="&nbsp&nbsp&nbsp비밀번호 입력" id="pwd" style="padding-left: 15px;margin-bottom: 5px"><br>
        <font id="checkPwd" size="2"></font><br>
      </div>
      <input type="button" value="확인" class="modifyBtn">
    </div>
  </div>
<header>
  <jsp:include page="../footer.jsp"/>
</header>
<script>
  $(document).ready(function () {
    $(".modifyBtn").on("click", function () {
      const form = document.createElement('form');
      form.setAttribute('method', 'post');
      form.setAttribute('action', '/member/memberEdit');

      var pwd = document.getElementById('pwd');
      form.appendChild(pwd);
      document.body.appendChild(form);
      form.submit();

    })

    $("#pwd").on("propertychange change keyup paste input", function () {
      let pass1 = $("#pwd").val();
      let pass2 = "${memberDto.pwd}"

      if (pass1 != "") {
        if (pass1 === pass2) {
          $("#checkPwd").html("비밀번호 일치");
          $("#checkPwd").attr("color", "green");
          $("#myPagePwdChk").css("border", "1.5px solid green");
        } else {
          $("#checkPwd").html("비밀번호 불일치");
          $("#checkPwd").attr("color", "red");
          $("#myPagePwdChk").css("border", "1.5px solid red");

        }
      }

    })

  })
</script>
</body>
</html>
