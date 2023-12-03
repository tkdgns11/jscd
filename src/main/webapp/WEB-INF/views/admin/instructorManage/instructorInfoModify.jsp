<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>강사 정보 수정</title>

    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Noto+Serif+KR:wght@900&display=swap" rel="stylesheet">
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

        <h2 id="infoTitle">강사 정보 수정</h2>
        <form action="/onlyAdmin/instructor/modify?page=${page}&iscrNo=${infoDto.iscrNo}" method="post">
        <h4>강사번호</h4>
        <div class="infoValueBox">${infoDto.iscrNo}</div>
        <h4>아이디</h4>
        <div class="infoValueBox">${infoDto.id}</div>
        <h4>이름</h4>
        <div class="infoValueBox">${infoDto.name}</div>
        <h4>생년월일</h4>
        <div class="infoValueBox">${infoDto.iscrNo}</div>
        <h4>폰번호</h4>
        <div class="infoValueBox">${infoDto.phone}</div>
        <h4>소개</h4>
        <input type="text" class="infoModifyBox" name="intro" autofocus value="${infoDto.intro}">
        <h4>상태</h4>
            <select name="status" style="padding: 4px 12px;margin-bottom: 15px">
                <option value="1">이직</option>
                <option value="2">재직</option>
                <option value="3">휴직</option>
                <option value="4">퇴직</option>
            </select>
        <h4>급여</h4>
        <input type="text" class="infoModifyBox" name="hourPmt" value="${infoDto.hourPmt}">
        <h4>계좌</h4>
        <div class="infoValueBox">${infoDto.acct}</div>
        <h4>강사 등록일</h4>
        <div class="infoValueBox"><fmt:formatDate value="${infoDto.regDate}" pattern="yyyy-MM-dd" type="date"/></div>
        <h4>비고</h4>
        <input type="text" class="infoModifyBox" name="etc" value="${infoDto.etc}">
        <br>
        <button id="adminModifyBtn">수정</button>
        </form>
        <button id="adminCancelBtn" onclick="location.href='/onlyAdmin/instructor/read?page=${page}&iscrNo=${infoDto.iscrNo}'">취소</button>
    </div>

    <footer>
        <jsp:include page="../../footer.jsp"/>
    </footer>

</div>





</body>
</html>
