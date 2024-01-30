<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/white_mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/white_mainlogo.png"/>
    <title>정석코딩 관리자 | 힉셍 상세보기</title>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Noto+Serif+KR:wght@900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/home.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfo.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script>
        let msg = "${param.msg}";
        if (msg == "READ_ERR") alert("정보를 가져오는데 실패했습니다. 다시 시도해 주세요.");
        if (msg == "DEL_ERR") alert("삭제에 실패했습니다. 다시 시도해 주세요.");
        if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");
        if (msg == "MOD_ERR") alert("수정에 실패했습니다.다시 시도해 주세요.");

    </script>
</head>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>
<div id="adminContent">
    <nav>
        <jsp:include page="../sidebar.jsp"/>
    </nav>
    <main>

        <div id="infoDetailBox">

            <h2 id="infoTitle">학생 상세보기</h2>


            <label style="margin-right: 3px;">회원 번호</label>
            <input type="text" class="infoInputBox" readonly name="mebrNO" id="mebrNO" value="${stdDto.mebrNO}"><br>
            <label style="margin-right: 15px;">아이디</label>
            <input type="text" class="infoInputBox" readonly value="${stdDto.id}"><br>
            <label style="margin-right: 25px;">이름</label>
            <input type="text" class="infoInputBox" readonly value="${stdDto.name}"><br>
            <label>생년월일</label>
            <input type="text" class="infoInputBox" readonly value="${stdDto.birth}"><br>
            <%--    <input type="text" class="infoInputBox" readonly--%>
            <%--           value="<fmt:formatDate value="${stdDto.birth}" pattern="yyyy-MM-dd" type="date"/>"><br>--%>


            <label>휴대전화</label>
            <input type="text" class="infoInputBox" readonly value="${stdDto.phone}"><br>
            <label style="margin-right: 25px;">기수</label>
            <input type="text" class="infoModifyInputBox" name="gisu" id="gisu" readonly value="${stdDto.gisu}"><br>
            <label style="margin-right: 25px;">상태</label>
            <input type="text" class="infoModifyInputBox" name="status" id="status" readonly value="${stdDto.status}"><br>
            <label style="margin-right: 25px;">계좌</label>
            <input type="text" class="infoInputBox" readonly value="${stdDto.acct}"><br>
            <label style="margin-right: 15px;">가입일</label>
            <input type="text" class="infoInputBox" readonly
                   value="<fmt:formatDate value="${stdDto.regDate}" pattern="yyyy-MM-dd" type="date"/>"><br>
            <label style="margin-right: 25px;">비고</label>
            <input type="text" class="infoModifyInputBox" name="etc" id="etc" readonly value="${stdDto.etc}"><br>

            <div id="stdBtnBox">
                <input type="submit" value="수정" class="modifyBtn">
                <input type="button" value="삭제" class="deleteBtn">
                <input type="button" value="목록" class="backBtn"
                       onclick="location.href='/adminManage/stdManage/list?page=${page}'">
            </div>

        </div>
    </main>
</div>



</body>

<script>

    const statusArr = {
        1: '수강예정',
        2: '수강중',
        3: '수료'
    }

    let statusValue = "${stdDto.status}"; //상태
    const keyArr = Object.keys(statusArr); //상태 번호 배열
    const statusKey = keyArr.filter((key) => statusArr[key] == statusValue); //상태 번호

    $(document).ready(function () {

        $(".deleteBtn").on("click", function () {
            if (!confirm("정말로 삭제하시겠습니까?")) return;

            const form = document.createElement('form');
            form.setAttribute('method', 'post');
            form.setAttribute('action', '/adminManage/stdManage/delete?mebrNO=${stdDto.mebrNO}&page=${page}');
            document.body.appendChild(form);
            form.submit();

        });

        $(".modifyBtn").on("click", function () {

            let isReadonly = $("input[name=gisu]").attr('readonly');

            if (isReadonly == 'readonly') {
                $("#infoTitle").html("학생 정보 수정");
                $("input[name=gisu]").attr('readonly', false);
                $("input[name=gisu]").focus();
                $("input[name=etc]").attr('readonly', false);
                $("input[name=gisu]").css("border-bottom", "1px solid red");
                $("input[name=etc]").css("border-bottom", "1px solid red");


                let statusInput = $("#status");
                let $statusSelect = $('<select id="status" name="status" class="modifySelect">');
                $statusSelect.append($("<option></option>").attr("value", statusKey).text(statusValue));

                $.each(statusArr, function (key, value) {
                    //상태와 value가 같지 않다면 옵션 추가
                    if (statusValue !== value) {
                        $statusSelect.append($("<option></option>").attr("value", key).text(value))
                    }
                });

                statusInput.replaceWith($statusSelect);


            } else {
                const form = document.createElement('form');
                form.setAttribute('method', 'post');
                form.setAttribute('action', '/adminManage/stdManage/modify?page=${page}&mebrNO=${stdDto.mebrNO}');

                var gisu = document.getElementById('gisu');
                var status = document.getElementById('status');
                var etc = document.getElementById('etc');
                var mebrNO = document.getElementById('mebrNO');

                form.appendChild(gisu);
                form.appendChild(status);
                form.appendChild(etc);
                form.appendChild(mebrNO);
                console.log(form)
                document.body.appendChild(form);
                $('#infoDetailBox').css('display','none');
                form.submit();
            }


        })//수정


    })

</script>
</html>
