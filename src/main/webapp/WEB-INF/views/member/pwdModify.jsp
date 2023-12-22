<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="loginId"
       value="${pageContext.request.getSession(false)==null ? null : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginPath" value="${loginId=='' ? '/member/login' : '/member/logout'}"/>
<c:set var="loginStatus" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>">


    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | 비밀번호 재설정</title>
</head>
<script>
    let msg = "${param.msg}";
    if (msg == "PWD_UP_ERR") alert("재설정에 실패했습니다.다시 시도해주세요.");
</script>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>
<div>
    <h1>비밀번호 재설정 </h1>
    비밀번호 재설정
    비밀번호 :<input type="password" class="password" id="pwd1"><br>
    비밀번호 확인 : <input type="password" name="pwd" class="password" id="pwd2">
    <font id="checkPwd" size="2"></font><br>
    <input type="hidden" name="id" value="${id}" id="id">
    <input type="button" value="등록" onclick="infoModify()">


</div>
<footer style="flex-shrink: 0;">
    <jsp:include page="../footer.jsp" flush="true"/>
</footer>

<script>

    function pwdValid(pwdChk, pwdReg) {

        //패스워드 공백 확인
        if (pwdChk.value == "") {
            alert("패스워드를 입력해주세요.");
            return false;
        }

        //패스워드 확인 칸 공백 확인
        if (pwdChk.value == "") {
            alert("패스워드 확인을 위해 한번 더 입력해주세요.");
            return false;
        }

        //패스워드 정규식 유효성 검사
        if (!pwdReg.test(pwdChk.value)) {
            alert("8~20자 영문 대소문자, 숫자, 특수문자를 사용하세요.");
            return false;
        }

        return true;
    }

    function infoModify() {
        const pwdChk = document.getElementById("pwd2");

        //정규식
        var pwdReg = /^[A-Za-z0-9`~!@#\$%\^&\*\(\)\{\}\[\]\-_=+\\|;:'"<>,./?]{8,20}$/

        if (!pwdValid(pwdChk, pwdReg)) {
            return;
        } else {
            //회원 정보 수정 진행
            const form = document.createElement('form');
            form.setAttribute('method', 'post');
            form.setAttribute('action', '/member/pwdModify');

            //닉네임,비밀번호,생일,휴대전화
            var id = document.getElementById('id');
            var pwd = document.getElementById('pwd2');

            form.appendChild(id);
            form.appendChild(pwd);
            document.body.appendChild(form);
            form.submit();

        }


    }

    $(document).ready(function () {

        //비밀번호 일치 여부 효과
        $(".password").on("propertychange change keyup paste input", function() {

            let pass1 = $("#pwd1").val();
            let pass2 = $("#pwd2").val();

            if (pass1 != "" || pass2 != "") {
                if (pass1 == pass2) {
                    $("#checkPwd").html("비밀번호 일치");
                    $("#checkPwd").attr("color", "green");
                    $("#pwd2").css("border", "1.5px solid green");
                } else {
                    $("#checkPwd").html("비밀번호 불일치");
                    $("#checkPwd").attr("color", "red");
                    $("#pwd2").css("border", "1.5px solid red");

                }
            }

        })

    })
</script>


</body>
</html>