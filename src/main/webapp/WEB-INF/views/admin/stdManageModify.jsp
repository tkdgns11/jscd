<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>학생 정보 수정 </title>
    <style>
        * {
            text-decoration: none;
            font-family: IBM Plex Sans KR;
        }

        #infoDetailBox {
            width: 45%;
            height: max-content;
            margin: auto;
        }

        .infoModifyBox {
            width: 100%;
            height: 40px;
            border: 1px solid blue;
            border-radius: 8px;
            margin-top: -15px;

        }

        .infoValueBox {
            width: 100%;
            height: 40px;
            border: 1px solid gray;
            border-radius: 8px;
            margin-top: -15px;
        }

        .infoDetailBtn {
            width: 100px;
            height: 35px;
            border-radius: 20px;
            border: 0;
            color: white;
            background-color: #18214F;
        }

        .infoDetailBtn:hover {
            background-color: #bebebe;
        }
    </style>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<script>
    let msg = "${param.msg}";

    if (msg == "MOD_ERR") alert("수정에 실패했습니다. 다시 시도해 주세요.");
</script>

<div id="infoDetailBox">
    <h2 style="text-align: center;">학생 정보 수정</h2>


    <button style="background-color: #18214F;" onclick="location.href='/stdManage/list?page=${page}'"
            class="infoDetailBtn">목록
    </button>
    <form action="/stdManage/modify?page=${page}&mebrNo=${stdDto.mebrNo}" method="post">
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
        <input type="text" class="infoModifyBox" name="status" value="${stdDto.status}">
        <h4>계좌</h4>
        <div class="infoValueBox">${stdDto.acct}</div>
        <h4>가입일</h4>
        <div class="infoValueBox"><fmt:formatDate value="${stdDto.regDate}" pattern="yyyy-MM-dd" type="date"/></div>
        <h4>비고</h4>
        <input type="text" class="infoModifyBox" name="etc" value="${stdDto.etc}">
        <button class="infoDetailBtn" style="background-color: red;">수정</button>
    </form>
</div>

</div>

</body>
</html>
