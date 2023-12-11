<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>회원 정보 상세보기</title>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Noto+Serif+KR:wght@900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfoManage.css"/>">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<script>
    let msg = "${param.msg}";
    if (msg == "READ_ERR") alert("강사 정보를 가져오는데 실패했습니다. 다시 시도해 주세요.");
</script>

<div id="content">

    <header>
        <jsp:include page="../adminHeader.jsp"/>
    </header>


    <div id="infoDetailBox">

        <h2 id="infoTitle">회원 정보 상세보기</h2>

        <h4>회원 번호</h4>
        <div class="infoValueBox">${memberDto.mebrNo}</div>
        <h4>아이디</h4>
        <div class="infoValueBox">${memberDto.id}</div>
        <h4>이름</h4>
        <div class="infoValueBox">${memberDto.name}</div>
        <h4>닉네임</h4>
        <div class="infoValueBox">${memberDto.nickname}</div>
        <h4>생년월일</h4>
      <div class="infoValueBox">${memberDto.birth}</div>
        <h4>휴대전화</h4>
        <div class="infoValueBox">${memberDto.phone}</div>
        <h4>등급</h4>
        <input type="text" class="infoInputBox" readonly value="${memberDto.grade}">
        <h4>상태</h4>
        <input type="text" class="infoInputBox" readonly value="${memberDto.status}">
        <h4>환불 계좌</h4>
        <input type="text" class="infoInputBox" readonly value="${memberDto.acct}">
        <h4>가입일</h4>
        <div class="infoValueBox"><fmt:formatDate value="${memberDto.regDate}" pattern="yyyy-MM-dd" type="date"/></div>
        <h4>비고</h4>
        <input type="text" class="infoInputBox" readonly value="${memberDto.etc}">
        <br>

        <button id="adminModifyBtn"
                onclick="location.href='/onlyAdmin/memberManage/modify?page=${page}&mebrNo=${memberDto.mebrNo}'"
                style="margin-left: 100px; margin-top: 15px">수정
        </button>
        <button id="adminListBtn" onclick="location.href='/onlyAdmin/memberManage/list?page=${page}'">목록</button>
    </div>

    <footer>
        <jsp:include page="../../footer.jsp"/>
    </footer>

</div>


</body>
</html>
