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

  <!-- 탭 아이콘 & 글자 지정 -->
  <link rel="icon" href="/img/mainlogo.png"/>
  <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
  <title>정석코딩 | myPage</title>

  <%--폰트어썸 라이브러리 불러오기--%>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
        integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"/>

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
  <nav class="myPageNav">
    <ul>
      <li><a href="/member/memberEdit">
        <i class="fa-solid fa-wrench" style="color: #7e8087;"></i>
        &nbsp;&nbsp;회원 정보 수정</a></li>
      <li><a href="/member/lectureApplyState">
        <i class="fa-solid fa-clock-rotate-left" style="color: #7e8087;"></i>
        &nbsp;&nbsp;강의 신청 현황</a></li>
      <li><a href="/order/orderList">
        <i class="fa-solid fa-comment-dollar" style="color: #7e8087;"></i>
        &nbsp;&nbsp;내 주문 내역</a></li>
      <c:if test="${memberDto.getGrade() eq '3'}">
        <li><a href="/member/instructorIntro">
          <i class="fa-solid fa-wand-sparkles" style="color: #7e8087;"></i>
          &nbsp;&nbsp;강사 소개말 등록</a></li>
      </c:if>
    </ul>
  </nav>
  <div>
    <p>비밀번호 입력</p>
    <div id="myPagePwdChk">
      <input type="password" name="pwd" placeholder="비밀번호를 입력해주세요" id="pwd"><br>
      <%--        <font id="checkPwd" size="2"></font><br>--%>
    </div>
    <input type="button" value="확인" class="modifyBtn">
  </div>
</div>
<header>
  <jsp:include page="../footer.jsp"/>
</header>

</body>
</html>
