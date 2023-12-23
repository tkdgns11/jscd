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
    <style>
        body {
            overflow: hidden;
            height: 100%
        }
    </style>

</head>
<body>
<script>
    let msg = "${param.msg}";
    if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");
    if (msg == "READ_ERR") alert("정보를 가져오는데 실패했습니다. 다시 시도해 주세요.");
</script>


<header>
    <jsp:include page="../adminHeader.jsp"/>
</header>


<div id="infoDetailBox">
    <h2 id="infoTitle" style="margin-bottom: 50px">개인 정보 수정</h2>
    <label style="margin-right: 40px;">아이디</label>
    <input type="text" class="infoInputBox" readonly value="${adminDto.id}"><br>
    <label style="margin-right: 55px;">이름</label>
    <input type="text" class="infoInputBox" readonly value="${adminDto.name}"><br>
    <label style="margin-right: 40px;">닉네임</label>
    <input type="text" name="nickname" class="infoModifyInputBox" id="nickname"
           value="${adminDto.nickname}"><br>
    <label style="margin-right: 30px;">비밀번호</label>
    <input type="password" id="pwd1" class="password"><br>
    <label>비밀번호 확인</label>
    <input type="password" class="password" id="pwd2" name="pwd">
    <font id="checkPwd" size="2"></font><br>
    <input type="hidden" id="pwdChkYN" value="">
    <label style="margin-right: 30px;">생년월일</label>
    <input class="infoModifyInputBox" name="birth" id="birth" type="date"
           value="<fmt:formatDate value="${adminDto.birth}" pattern="yyyy-MM-dd" type="date"/>"><br>
    <label style="margin-right: 30px;">휴대전화</label>
    <input type="text" class="infoModifyInputBox" name="phone" id="phone" value="${adminDto.phone}"
           oninput="autoHyphen(this)"><br>
    <br>
    <div id="adminBtnBox">
        <input type="button" value="수정" class="modifyBtn">
        <input type="button" value="취소" class="deleteBtn" onclick="location.href='/admin/home'">
    </div>

</div>

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

    const autoHyphen = (target) => {
        target.value = target.value
            .replace(/[^0-9]/g, '')
            .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
    }

    $(document).ready(function () {
        const pwdChk = document.getElementById("pwd2");
        const pwdChkYN = document.getElementById("pwdChkYN").value;
        //정규식
        const pwdReg = /^[A-Za-z0-9`~!@#\$%\^&\*\(\)\{\}\[\]\-_=+\\|;:'"<>,./?]{8,20}$/

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

        var len = $('#nickname').val().length;
        $('#nickname').focus();
        $('#nickname')[0].setSelectionRange(len, len);

        $(".modifyBtn").on("click", function () {

            if (!pwdValid(pwdChk, pwdReg) || !pwdChkYNValid(pwdChkYN)) {
                return;
            } else {
                const form = document.createElement('form');
                form.setAttribute('method', 'post');
                form.setAttribute('action', '/admin/modify');
                form.setAttribute('id', 'form');

                var nickname = document.getElementById('nickname');
                var phone = document.getElementById('phone');
                var birth = document.getElementById('birth');
                var pwd = document.getElementById('pwd2');
                form.appendChild(nickname);
                form.appendChild(phone);
                form.appendChild(birth);
                form.appendChild(pwd);
                document.body.appendChild(form);
                $('#infoDetailBox').css('display', 'none');
                $('#pwd2').css('display', 'none');

                console.log(form)
                form.submit();
            }


        })


    })


</script>

</body>
</html>

