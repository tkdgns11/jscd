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
    <script type="text/javascript" src="<c:url value="/js/login.js"/>"></script>


    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | 비밀번호 찾기</title>
</head>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>
<div>
    <h1>비밀번호 찾기</h1>
    <div>
        아이디 : <input type="text" name="id" id="id">
        <input type="button" id="idChkBtn" value="아이디 확인" onclick="idCheck()">
        <input type="hidden" id="idChkYN" value="">

        <input type="button" id="emailChkValueBtn" value="인증번호 받기" class="signup_btn"><br>
        <input type="text" id="certification" name="인증번호" placeholder="인증번호를 입력해주세요." autocomplete="off">
        <font id="checkPwd" size="2"></font><br>
        <input type="hidden" id="emailChkYN" value="">

        <input type="button" value="비밀번호 찾기" id="findPwdBtn">
    </div>
</div>
<footer style="flex-shrink: 0;">
    <jsp:include page="../footer.jsp" flush="true"/>
</footer>

<script>

    //아이디 체크했나 확인
    function idChkYNValid() {

        let idChk = document.getElementById('idChkYN').value;


        if (idChk != 'Y') {
            alert("아이디 존재여부를 확인해주세요.");
            return false;
        }
        return true;
    }

    // 이메일 인증했나 확인
    function emailChkYNValid() {
        let emailChk = document.getElementById('emailChkYN').value;


        if (emailChk != 'Y') {
            alert("본인인증을 확인해주세요.")
            return false;
        }
        return true;
    }


    //존재하는 아이디인지 체크
    const idCheck = () => {
        const id = document.getElementById('id').value;

        $.ajax({
            type: 'get',
            url: '/member/idChk?id=' + id,
            success: (email) => {
                if (id == email) {
                    alert('존재하는 아이디 입니다.본인인증을 진행해주세요.');
                    alert(id)
                    document.getElementById("idChkYN").value = 'Y';
                    console.log("아이디 존재 여부 = " + document.getElementById('idChkYN').value);
                } else {
                    alert('존재하지않는 아이디 입니다');
                }
            },
            error: () => {
                alert("서버 요청 실패")
            }
        }); // end ajax
    }


    $(document).ready(function () {
        const idChkYN = document.getElementById("idChkYN").value;
        const emailChkYN = document.getElementById("emailChkYN").value;
        //빈값으로 비밀번호 찾기 누르면, 값을 입력하세요 alert


        $('#findPwdBtn').on("click", function () {
            const email = document.getElementById('id').value; //위에서 선언하면 값 찾지 못함

            //유효성 검사
            if (!idChkYNValid(idChkYN) || !emailChkYNValid(emailChkYN)) {
                return;
            } else {
                alert(email)
                location.href = "/member/pwdModify?id=" + email;
            }


        })


        //인증번호 받기를 누르면, 인증번호 메서드 실행
        $('#emailChkValueBtn').click(() => {

            const email = $('#id').val(); //이메일 주소값 가져오기
            console.log(email);

            $.ajax({
                type: 'get',
                url: '/member/findEmailChk?email=' + email, // get방식이라서 url 뒤에 email을 줄 수 있다.
                success: (data) => {
                    code = data;
                    // 인증번호가 전송됐습니다. alert가 너무 느리게 나오는 상황.
                    alert("인증번호가 전송됐습니다.");
                },
                error: () => {
                    alert("서버 요청 실패")
                }
            }); // end ajax
        });


        //
        $("#certification").on("propertychange change keyup paste input", function () {
            const certification = $('#certification').val();

            if (certification === code) {
                $("#checkPwd").html("인증번호 일치");
                $("#checkPwd").attr("color", "green");
                $("#certification").css("border", "1.5px solid green");
                document.getElementById("emailChkYN").value = 'Y';
                console.log("인증번호 일치 = " + document.getElementById('emailChkYN').value);
            } else {
                // alert('인증번호가 불일치합니다. 다시 확인해주세요.')
                $("#checkPwd").html("인증번호 불일치");
                $("#checkPwd").attr("color", "red");
                $("#certification").css("border", "1.5px solid red");
                console.log("인증번호 불일치 = " + document.getElementById('emailChkYN').value);
            }
        });


    })
</script>
</body>
</html>