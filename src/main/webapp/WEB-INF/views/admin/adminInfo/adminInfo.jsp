<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>개인 정보 수정</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfo.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">


</head>
<body>
<script>
    let msg = "${param.msg}";

    if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");
    if (msg == "READ_ERR") alert("정보를 가져오는데 실패했습니다. 다시 시도해 주세요.");</script>


<header>
    <jsp:include page="../adminHeader.jsp"/>
    <jsp:include page="../adminSidebar.jsp"/>
</header>


<div id="infoDetailBox" style="margin-top: 100px;margin-left: 900px;">
    <h2 id="infoTitle">개인 정보 읽기</h2>
    <label style="margin-right: 15px;">아이디</label>
    <input type="text" class="infoInputBox" readonly value="${adminDto.id}"><br>
    <label style="margin-right: 25px;">이름</label>
    <input type="text" class="infoInputBox" readonly value="${adminDto.name}"><br>
    <label style="margin-right: 15px;">닉네임</label>
    <input type="text" name="nickname" class="infoInputBox" name="nickname" id="nickname" readonly
           value="${adminDto.nickname}"><br>
    <label>생년월일</label>
    <input type="text" class="infoInputBox" readonly
           value="<fmt:formatDate value="${adminDto.birth}" pattern="yyyy-MM-dd" type="date"/>"><br>
    <label>휴대전화</label>
    <input type="text" class="infoInputBox" readonly value="${adminDto.phone}"><br>
    <br>
    <input type="button" value="수정" class="modifyBtn">
    <input type="button" value="취소" class="deleteBtn" onclick="location.href='/admin/home'">

</div>

<script>

    $(document).ready(function () {


        $(".modifyBtn").on("click", function () {

            let isReadonly = $("input[name=nickname]").attr('readonly');
            if (isReadonly == 'readonly') {

                $("#infoTitle").html("개인 정보 수정");
                $("input[name=nickname]").attr('readonly', false);
                $("input[name=nickname]").focus();
                $("input[name=nickname]").css("border-bottom", "1px solid red");

            } else {
                const form = document.createElement('form');
                form.setAttribute('method', 'post');
                form.setAttribute('action', '/admin/modify');

                var nickname = document.getElementById('nickname');
                form.appendChild(nickname);
                document.body.appendChild(form);
                form.submit();


            }


        })
    })


</script>

</body>
</html>

