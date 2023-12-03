<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>학생 정보 수정</title>
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
    if (msg == "MOD_ERR") alert("수정에 실패했습니다. 다시 시도해 주세요.");
</script>

<div id="content">

    <header>
        <jsp:include page="../adminHeader.jsp"/>
    </header>

    <div id="infoDetailBox">

        <h2 id="infoTitle">학생 정보 수정</h2>
        <form action="/onlyAdmin/stdManage/modify?page=${page}&mebrNo=${stdDto.mebrNo}" method="post">
            <h4>회원 번호</h4>
            <div class="infoValueBox">${stdDto.mebrNo}</div>
            <h4>아이디</h4>
            <div class="infoValueBox">${stdDto.id}</div>
            <h4>이름</h4>
            <div class="infoValueBox">${stdDto.name}</div>
            <h4>생년월일</h4>
            <div class="infoValueBox">${stdDto.birth}</div>
            <h4>폰번호</h4>
            <div class="infoValueBox">${stdDto.phone}</div>
            <h4>기수</h4>
            <input type="text" class="infoModifyBox" name="gisu" autofocus value="${stdDto.gisu}">
            <h4>상태</h4>
            <select name="status" style="padding: 4px 12px;margin-bottom: 15px">
                <option value="1">수강예정</option>
                <option value="2">수강중</option>
                <option value="3">수료</option>
            </select>
            <h4>계좌</h4>
            <div class="infoValueBox">${stdDto.acct}</div>
            <h4>가입일</h4>
            <div class="infoValueBox"><fmt:formatDate value="${stdDto.regDate}" pattern="yyyy-MM-dd" type="date"/></div>
            <h4>비고</h4>
            <input type="text" class="infoModifyBox" name="etc" value="${stdDto.etc}">
            <br>
            <button id="adminModifyBtn">수정</button>
        </form>
        <button id="adminCancelBtn" onclick="location.href='/onlyAdmin/stdManage/read?page=${page}&mebrNo=${stdDto.mebrNo}'">취소</button>
    </div>

    <footer>
        <jsp:include page="../../footer.jsp"/>
    </footer>

</div>


</body>
</html>
