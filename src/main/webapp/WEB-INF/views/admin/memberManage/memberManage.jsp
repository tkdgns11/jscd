<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/white_mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/white_mainlogo.png"/>
    <title>정석코딩 관리자 | 회원 정보 상세보기</title>
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
    if (msg == "MOD_ERR") alert("수정이 실패하였습니다. 다시 시도해 주세요.");
</script>
<body>
<header>
    <jsp:include page="../adminHeader.jsp"/>
</header>


<div id="infoDetailBox">

    <h2 id="infoTitle">회원 상세보기</h2>

    <label style="margin-right: 3px;">회원번호</label>
    <input type="text" class="infoInputBox" name="mebrNo" id="mebrNo" readonly value="${memberDto.mebrNo}"><br>
    <label style="margin-right: 15px;">아이디</label>
    <input type="text" class="infoInputBox" readonly value="${memberDto.id}" id="id"><br>
    <label style="margin-right: 25px;">이름</label>
    <input type="text" class="infoInputBox" readonly value="${memberDto.name}" id="name"><br>
    <label style="margin-right: 15px;">닉네임</label>
    <input type="text" class="infoInputBox" readonly value="${memberDto.nickname}"><br>
    <label>생년월일</label>
    <input type="text" class="infoInputBox" readonly value="${memberDto.birth}"><br>
    <%--        <input type="text"  class="infoInputBox" value="<fmt:formatDate value="${memberDto.birth}" pattern="yyyy-MM-dd" type="date"/>"><br>--%>
    <label>휴대전화</label>
    <input type="text" class="infoInputBox" readonly value="${memberDto.phone}"><br>
    <input type="hidden" class="infoInputBox" readonly value="${memberDto.grade}" name="originGrade" id="originGrade"><br>
    <label style="margin-right: 25px;">등급</label>
    <input type="text" class="infoInputBox" readonly id="grade" value="${memberDto.grade}"><br>
    <label style="margin-right: 25px;">상태</label>
    <input type="text" class="infoInputBox" readonly id="status" value="${memberDto.status}"><br>
    <label style="margin-right: 25px;">계좌</label>
    <input type="text" class="infoInputBox" readonly value="${memberDto.acct}"><br>
    <label style="margin-right: 15px;">가입일</label>
    <input type="text" class="infoInputBox" readonly
           value="<fmt:formatDate value="${memberDto.regDate}" pattern="yyyy-MM-dd" type="date"/>"><br>
    <label style="margin-right: 25px;">비고</label>
    <input type="text" class="infoModifyInputBox" id="etc" name="etc" readonly value="${memberDto.etc}"><br>

    <div id="adminBtnBox">
        <input type="button" value="수정" class="modifyBtn">
        <input type="button" value="목록" class="backBtn"
               onclick="location.href='/adminManage/memberManage/list?page=${page}'">
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
        4: '관리자'
    }

    let statusValue = "${memberDto.status}"; //상태
    const statusKeys = Object.keys(statusArr); //상태 번호 배열
    const statusKey = statusKeys.filter((key) => statusArr[key] == statusValue); //상태 번호

    let gradeValue = "${memberDto.grade}"; //등급
    const gradeKeys = Object.keys(gradeArr); //등급 번호 배열
    const gradeKey = gradeKeys.filter((key) => gradeArr[key] == gradeValue); //등급 번호


    $(document).ready(function () {

        $(".modifyBtn").on("click", function () {
            let isReadonly = $("input[name=etc]").attr('readonly');

            if (isReadonly == 'readonly') {

                $("input[name=etc]").attr('readonly', false);
                $("input[name=etc]").css("border-bottom", "1px solid red");

                let gradeInput = $("#grade");
                let $gradeSelect = $('<select id="grade" name="grade" class="modifySelect">');
                $gradeSelect.append($("<option></option>").attr("value", gradeKey).text(gradeValue));

                let statusInput = $("#status");
                let $statusSelect = $('<select id="status" name="status" class="modifySelect">');
                $statusSelect.append($("<option></option>").attr("value", statusKey).text(statusValue));


                $.each(gradeArr, function (key, value) {
                    if (gradeValue !== value) {
                        $gradeSelect.append($("<option></option>").attr("value", key).text(value))
                    }
                });

                $.each(statusArr, function (key, value) {
                    if (statusValue !== value) {
                        $statusSelect.append($("<option></option>").attr("value", key).text(value))
                    }
                });

                gradeInput.replaceWith($gradeSelect);
                statusInput.replaceWith($statusSelect);
                $('.modifySelect').css("margin-bottom","20px");


            } else {
                const form = document.createElement('form');
                form.setAttribute('method', 'post');
                form.setAttribute('action', '/adminManage/memberManage/modify?page=${page}&mebrNo=${memberDto.mebrNo}');

                var status = document.getElementById('status');
                var grade = document.getElementById('grade');
                var etc = document.getElementById('etc');
                var mebrNo = document.getElementById('mebrNo');
                var originGrade = document.getElementById('originGrade');

                form.appendChild(grade);
                form.appendChild(status);
                form.appendChild(etc);
                form.appendChild(mebrNo);
                form.appendChild(originGrade);

                console.log(form)
                document.body.appendChild(form);
                $('#infoDetailBox').css('display','none');

                form.submit();
            }


        })//수정


    })


</script>

</body>
</html>
