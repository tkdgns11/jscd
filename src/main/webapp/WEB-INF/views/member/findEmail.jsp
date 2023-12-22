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
    <title>정석코딩 | 아이디 찾기</title>
</head>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>

<script>
    let msg = "${param.msg}";
    if (msg == "EMAIL_ERR") alert("입력하신 회원정보에 맞는 아이디가 없습니다.");

</script>
<div>
    <h1>아이디 찾기</h1>
    <div>
        이름 : <input type="text" name="name" id="name" style="margin-left: 20px;"><br>
        휴대전화 : <input type="text" name="phone" id="phone"><br>
        생년월일 : <input type="text" name="birth" id="birth" placeholder="생년월일 6자리(Ex.950324)"><br>
        <input type="submit" value="아이디 찾기" id="findEmail">
    </div>
</div>
<footer style="flex-shrink: 0;">
    <jsp:include page="../footer.jsp" flush="true"/>
</footer>

<script>
    $(document).ready(function () {

        let name = document.getElementById('name');
        let phone = document.getElementById('phone');
        let birth = document.getElementById('birth');

        $('#findEmail').on("click", function () {

            if (name.value == "" || phone.value == "" || birth.value == "") {
                alert("회원 정보를 입력 해주세요");
            } else {
                const form = document.createElement('form');
                form.setAttribute('method', 'post');
                form.setAttribute('action', '/member/findEmail');
                form.appendChild(name);
                form.appendChild(phone);
                form.appendChild(birth);

                document.body.appendChild(form);
                form.submit()
            }


        })


    })
</script>
</body>
</html>