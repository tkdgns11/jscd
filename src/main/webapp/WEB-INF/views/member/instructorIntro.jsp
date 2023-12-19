<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/myPage.css"/>">
    <title>myPage</title>

    <style>
        #introTitle{
            font-size: 24px;
            margin-bottom: 30px;
        }


    </style>
    <script>
        let msg = "${param.msg}";
        if (msg == "READ_ERR") alert("정보를 가져오는데 실패했습니다. 다시 시도해 주세요.");
        if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");
        if (msg == "MOD_ERR") alert("수정에 실패하였습니다. 다시 시도해 주세요.");

    </script>
</head>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>
<div id="myPagePwdChkBox">
    <nav>
        <ul>
            <li><a href="/member/memberEdit">회원 정보 수정</a></li>
            <li><a href="#">강의 신청 현황</a></li>
            <c:if test="${memberDto.getGrade() eq '3'}">
                <li><a href="/member/instructorIntro">강사 소개말 작성</a></li>
            </c:if>
        </ul>
    </nav>
    <div id="instructorInfoBox" style="margin-top: 100px;margin-left: 50px">
        <h1 id="introTitle">강사 소개말</h1>
        <textarea rows="20" cols="80" name="intro" readonly id="intro" id="intro">${infoDto.getIntro()}</textarea>
        <input type="button" value="수정" class="modifyBtn" style="margin-top: 150px;left: 3.5%">
        <input type="hidden" name="mebrNo" value="${memberDto.getMebrNo()}" id="mebrNo">
    </div>
</div>
<footer>
    <jsp:include page="../footer.jsp"/>
</footer>


<script>
    $(document).ready(function () {





        $('.modifyBtn').on("click", function () {
            let isReadonly = $("textarea[name=intro]").attr('readonly');

            if (isReadonly == 'readonly') {
                $("#introTitle").html("강사 소개말 수정");
                $("textarea[name=intro]").attr('readonly', false);

                var len = $('#intro').val().length;
                $('#intro').focus();
                $('#intro')[0].setSelectionRange(len, len);

                $(".modifyBtn").val("등록");


            } else {
                //post메서드로 저장
                const form = document.createElement('form');
                form.setAttribute('method', 'post');
                form.setAttribute('action', '/member/instructorIntro');

                var intro = document.getElementById('intro');
                var mebrNo = document.getElementById('mebrNo');

                form.appendChild(intro);
                form.appendChild(mebrNo);
                document.body.appendChild(form);
                form.submit();
            }

        })


    })
</script>

</body>
</html>
