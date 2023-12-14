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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfo.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<script>
    let msg = "${param.msg}";
    if (msg == "READ_ERR") alert("회원 정보를 가져오는데 실패했습니다. 다시 시도해 주세요.");
    if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");

</script>
<body>
<header>
    <jsp:include page="../adminSidebar.jsp"/>
    <jsp:include page="../adminHeader.jsp"/>
</header>


<div id="infoDetailBox">

    <h2 id="infoTitle">회원 정보 상세보기</h2>

    <label style="margin-right: 3px;">회원번호</label>
    <input type="text" class="infoInputBox" name="mebrNo" id="mebrNo" readonly value="${memberDto.mebrNo}"><br>
    <label style="margin-right: 15px;">아이디</label>
    <input type="text" class="infoInputBox" readonly value="${memberDto.id}"><br>
    <label style="margin-right: 25px;">이름</label>
    <input type="text" class="infoInputBox" readonly value="${memberDto.name}"><br>
    <label style="margin-right: 15px;">닉네임</label>
    <input type="text" class="infoInputBox" readonly value="${memberDto.nickname}"><br>
    <label>생년월일</label>
    <input type="text" class="infoInputBox" readonly value="${memberDto.birth}"><br>
    <%--        <input type="text"  class="infoInputBox" value="<fmt:formatDate value="${memberDto.birth}" pattern="yyyy-MM-dd" type="date"/>"><br>--%>
    <label>휴대전화</label>
    <input type="text" class="infoInputBox" readonly value="${memberDto.phone}"><br>
    <label style="margin-right: 25px;">등급</label>
    <select name="grade" id="grade" class="modifySelect">
        <option value="">${memberDto.grade}</option>
    </select><br><br>
    <%--        <input type="text" class="infoInputBox" readonly value="${memberDto.grade}"><br>--%>
    <label style="margin-right: 25px;">상태</label>
    <select name="status" id="status" class="modifySelect">
        <option value="">${memberDto.status}</option>
    </select><br>
    <label style="margin-right: 25px;">계좌</label>
    <input type="text" class="infoInputBox" readonly value="${memberDto.acct}"><br>
    <label style="margin-right: 15px;">가입일</label>
    <input type="text" class="infoInputBox" readonly
           value="<fmt:formatDate value="${memberDto.regDate}" pattern="yyyy-MM-dd" type="date"/>"><br>
    <label style="margin-right: 25px;">비고</label>
    <input type="text" class="infoInputBox" id="etc" name="etc" readonly value="${memberDto.etc}"><br>
    <%--회원 정보 수정에서, 관리자로 등급변경 시 관리자 테이블로 보내줄 데이터 hidden 처리--%>
    <input type="hidden" class="infoModifyBox" name="id" id="id" value="${memberDto.id}">
    <input type="hidden" class="infoModifyBox" name="name" id="name" value="${memberDto.name}">
    <input type="hidden" class="infoModifyBox" name="pwd" id="pwd" value="${memberDto.pwd}">


    <div id="adminBtnBox">
        <input type="button" value="수정" class="modifyBtn">
        <input type="button" value="목록" class="backBtn"
               onclick="location.href='/onlyAdmin/memberManage/list?page=${page}'">
    </div>

</div>

<script>
    const statusArr = {
        1: '정상',
        2: '블랙',
        3: '탈퇴',
        4: '휴면'
    }

    const gradeArr = {
        1: '일반',
        2: '학생',
        3: '강사',
        4: '관리자(조교)'
    }

    $(document).ready(function () {

        $(".modifyBtn").on("click", function () {
            let isReadonly = $("input[name=etc]").attr('readonly');

            if (isReadonly == 'readonly') {
                $("input[name=etc]").attr('readonly', false);
                $("input[name=etc]").css("border-bottom", "1px solid red");
                $("input[name=etc]").focus();

                $("#grade option").remove();
                $.each(gradeArr, function (key, value) {
                    $('#grade').append($("<option></option>").attr("value", key).text(value))
                });

                $("#status option").remove();
                $.each(statusArr, function (key, value) {
                    $('#status').append($("<option></option>").attr("value", key).text(value))
                });
            } else {
                const form = document.createElement('form');
                form.setAttribute('method', 'post');
                form.setAttribute('action', '/onlyAdmin/memberManage/modify?page=${page}&mebrNo=${memberDto.mebrNo}');

                var status = document.getElementById('status');
                var grade = document.getElementById('grade');
                var etc = document.getElementById('etc');
                var mebrNo = document.getElementById('mebrNo');
                var id = document.getElementById('id');
                var name = document.getElementById('name');
                var pwd = document.getElementById('pwd');

                form.appendChild(grade);
                form.appendChild(status);
                form.appendChild(id);
                form.appendChild(etc);
                form.appendChild(mebrNo);
                form.appendChild(name);
                form.appendChild(pwd);

                console.log(form)
                document.body.appendChild(form);
                form.submit();
            }


        })//수정


    })


</script>

</body>
</html>
