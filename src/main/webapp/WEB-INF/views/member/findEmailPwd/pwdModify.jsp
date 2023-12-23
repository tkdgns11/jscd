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

    <style>

        #findPwdBox input[type=password] {
            width: 350px;
            height: 40px;
            background-color: rgba(0, 0, 0, 0.1);
            border: 0;
            border-radius: 5px;

        }

        #findPwdBox input[type=password]:focus {
            outline: none;
        }

        #findPwdBtn {
            width: 357px;
            height: 40px;
            font-size: 19px;
            background-color: #0185FE;
            color: #fff;
            cursor: pointer;
            border-radius: 5px;
            letter-spacing: 10px;
            font-weight: 600;
            border: 0;
            margin-top: 15px;
            margin-left: 0;
            margin-bottom: 30px;
        }

    </style>
</head>
<script>
    let msg = "${param.msg}";
    if (msg == "PWD_UP_ERR") alert("재설정에 실패했습니다.다시 시도해주세요.");
</script>
<body>
<header>
    <jsp:include page="../../header.jsp"/>
</header>
<div id="loginWrap">
    <div id="loginHeader" style="border: none;">
        <h1>비밀번호재설정</h1>
    </div>
    <div id="findPwdBox">
        <input type="password" id="pwd1" placeholder="비밀번호 입력"><br><br>
        <input type="password" id="pwd2" name="pwd" class="password" placeholder="비밀번호 확인"><br>
        <font id="checkPwd" size="2"></font><br>
        <input type="hidden" id="pwdChkYN" value="">
        <input type="hidden" name="id" value="${id}" id="id">
    </div>
    <input type="button" value="비밀번호 등록" id="findPwdBtn" onclick="infoModify()">
</div>

<footer style="flex-shrink: 0;">
    <jsp:include page="../../footer.jsp" flush="true"/>
</footer>

<script>

    function pwdChkYNValid() {
        let pwdChkYN = document.getElementById('pwdChkYN').value;


        if (pwdChkYN != 'Y') {
            alert("패스워드가 일치하지 않습니다. 다시 입력해주세요.")
            return false;
        }
        return true;
    }

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
        const pwdChkYN = document.getElementById("pwdChkYN").value;

        //정규식
        var pwdReg = /^[A-Za-z0-9`~!@#\$%\^&\*\(\)\{\}\[\]\-_=+\\|;:'"<>,./?]{8,20}$/

        if (!pwdValid(pwdChk, pwdReg) || !pwdChkYNValid(pwdChkYN)) {
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
            $('#loginWrap').css('display', 'none');


            form.submit();

        }


    }

    $(document).ready(function () {

        //비밀번호 일치 여부 효과
        $(".password").on("propertychange change keyup paste input", function () {

            let pass1 = $("#pwd1").val();
            let pass2 = $("#pwd2").val();

            if (pass1 != "" || pass2 != "") {
                if (pass1 == pass2) {
                    $("#checkPwd").html("비밀번호 일치");
                    $("#checkPwd").attr("color", "green");
                    $("#pwd2").css("border", "1.5px solid green");
                    document.getElementById("pwdChkYN").value = 'Y';
                    console.log("비밀번호 두개가 일치하냐 = " + document.getElementById("pwdChkYN").value)
                } else {
                    $("#checkPwd").html("비밀번호 불일치");
                    $("#checkPwd").attr("color", "red");
                    $("#pwd2").css("border", "1.5px solid red");
                    document.getElementById("pwdChkYN").value = 'N';
                    console.log("비밀번호 두개가 일치하냐 = " + document.getElementById("pwdChkYN").value)
                }
            }

        })

    })
</script>


</body>
</html>