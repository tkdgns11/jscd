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
        <div class="infoValueBox">${memberDto.alias}</div>
        <h4>생년월일</h4>
        <div class="infoValueBox">${memberDto.birth}</div>
        <h4>폰번호</h4>
        <div class="infoValueBox">${memberDto.phone}</div>
        <h4>등급</h4>
        <input type="text" class="infoModifyBox" name="grade" autofocus value="${memberDto.grade}">
        <h4>상태</h4>
        <input type="text" class="infoModifyBox" name="status" value="${memberDto.status}">
        <h4>환불 계좌</h4>
        <div class="infoValueBox">${memberDto.acct}</div>
        <h4>가입일</h4>
        <div class="infoValueBox"><fmt:formatDate value="${memberDto.regDate}" pattern="yyyy-MM-dd" type="date"/></div>
        <h4>비고</h4>
        <input type="text" class="infoModifyBox" name="etc" value="${memberDto.etc}">
        <button class="infoDetailBtn" style="background-color: red;">수정</button>
    </form>
</div>

</div>
<footer>
    <jsp:include page="../../footer.jsp"/>
</footer>

</div>

</body>
</html>
