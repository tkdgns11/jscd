<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>개인 정보 수정</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfoManage.css"/>">

</head>
<body>
<script>
    let msg = "${param.msg}";

    if(msg=="MOD_ERR")    alert("수정에 실패했습니다. 다시 시도해 주세요.");
</script>

<div id="content">

    <header>
        <jsp:include page="adminHeader.jsp"/>
    </header>




<div id="infoDetailBox">
    <h2 id="infoTitle">개인 정보 수정</h2>



    <form action="/admin/modify" method="post">
        <h4>아이디</h4>
        <div class="infoValueBox">${adminDto.id}</div>
        <h4>이름</h4>
        <div class="infoValueBox">${adminDto.name}</div>
        <h4>닉네임</h4>
        <input type="text" name="nickname" class="infoModifyBox" autofocus value="${adminDto.nickname}">
        <h4>생년월일</h4>
        <div class="infoValueBox">${adminDto.birth}</div>
        <h4>휴대전화</h4>
        <div class="infoValueBox">${adminDto.phone}</div>
        <br>
            <button id="adminModifyBtn">수정</button>
    </form>
    <button id="adminCancelBtn" onclick="location.href='/admin/read/'">취소</button>
</div>




</div>

<footer>
    <jsp:include page="../footer.jsp"/>
</footer>
</div>

</body>
</html>

