<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>회원 정보 수정 </title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfoManage.css"/>">
</head>
<body>
<script>
    let msg = "${param.msg}";

    if (msg == "MOD_ERR") alert("수정에 실패했습니다. 다시 시도해 주세요.");
</script>

<div id="content">

    <header>
        <jsp:include page="../adminHeader.jsp"/>
    </header>


<div id="infoDetailBox">
    <h2 id="infoTitle">회원 정보 수정</h2>

    <form action="/onlyAdmin/memberManage/modify?page=${page}&mebrNo=${memberDto.mebrNo}" method="post">
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
        <h4>폰번호</h4>
        <div class="infoValueBox">${memberDto.phone}</div>
        <h4>등급</h4>
        <select name="grade" style="padding: 4px 12px;margin-bottom: 15px">
            <option value="1">일반</option>
            <option value="2">학생</option>
            <option value="3">수료생</option>
            <option value="4">강사</option>
            <option value="5">관리자(조교)</option>
            <option value="6">최고관리자</option>
        </select>
        <h4>상태</h4>
        <select name="status" style="padding: 4px 12px;margin-bottom: 15px">
            <option value="1">정상</option>
            <option value="2">블랙</option>
            <option value="3">탈퇴</option>
            <option value="4">휴면</option>
        </select>
        <h4>환불 계좌</h4>
        <div class="infoValueBox">${memberDto.acct}</div>
        <h4>가입일</h4>
        <div class="infoValueBox"><fmt:formatDate value="${memberDto.regDate}" pattern="yyyy-MM-dd" type="date"/></div>
        <h4>비고</h4>
        <input type="text" class="infoModifyBox" name="etc" value="${memberDto.etc}">
        <%--회원 정보 수정에서, 관리자로 등급변경 시 관리자 테이블로 보내줄 데이터 hidden 처리%>
        <input type="hidden" class="infoModifyBox" name="id" value="${memberDto.id}">
        <input type="hidden" class="infoModifyBox" name="name" value="${memberDto.name}">
        <input type="hidden" class="infoModifyBox" name="pwd" value="${memberDto.pwd}">
        <br>
        <button id="adminModifyBtn">수정</button>
    </form>
    <button id="adminCancelBtn" onclick="location.href='/onlyAdmin/memberManage/read?page=${page}&mebrNo=${memberDto.mebrNo}'">취소</button>
</div>

</div>
<footer>
    <jsp:include page="../../footer.jsp"/>
</footer>

</div>

</body>
</html>
