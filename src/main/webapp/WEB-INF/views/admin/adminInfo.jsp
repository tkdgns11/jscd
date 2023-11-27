<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>개인 정보 수정</title>
    <style>
        * {text-decoration: none;}
        #infoDetailBox {width: fit-content;height: 60%;margin-left: 550px;padding: 50px 0 50px 0;}
        .infoInputBox {width: 400px;height: 36px;border: 1px solid gray;border-radius: 8px;margin: 8px 0 20px 0;padding-top: 4px;padding-left: 10px;}
        .infoValueBox {width: 390px;height: 24px;border: 1px solid gray;border-radius: 8px;margin: 8px 0 20px 0;padding-top: 10px;padding-left: 10px;}
        #infoTitle {text-align: center;margin-bottom: 20px;font-size: 20px;font-weight: 600;}
        #infoDetailBtn {width: 100px;height: 35px;border-radius: 20px;border: 0;color: white;background-color: #18214F;margin-left: 142px;margin-top: 15px;}
        #infoDetailBtn:hover {background-color: #bebebe;}
    </style>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/>">
</head>
<body>
<script>
    let msg = "${param.msg}";

    if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");
    if (msg == "READ_ERR") alert("관리자 정보를 가져오는데 실패했습니다. 다시 시도해 주세요.");</script>

<div id="content">

    <header>
        <jsp:include page="adminHeader.jsp"/>
    </header>


    <div id="infoDetailBox">
        <h2 id="infoTitle">개인 정보 읽기</h2>


        <h4>아이디</h4>
        <div class="infoValueBox">${adminDto.id}</div>
        <h4>이름</h4>
        <div class="infoValueBox">${adminDto.name}</div>
        <h4>닉네임</h4>
        <input type="text" name="alias" class="infoInputBox" readonly value="${adminDto.alias}">
        <h4>생년월일</h4>
        <div class="infoValueBox">${adminDto.birth}</div>
        <h4>폰번호</h4>
        <div class="infoValueBox">${adminDto.phone}</div>
        <br>
        <button id="infoDetailBtn" onclick="location.href='/admin/modify'">수정</button>
    </div>


</div>

<footer>
    <jsp:include page="../footer.jsp"/>
</footer>
</div>

</body>
</html>

