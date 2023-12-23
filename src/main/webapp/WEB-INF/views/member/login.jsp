<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? null : pageContext.request.session.getAttribute('id')}"/>
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
    <title>정석코딩 | 로그인</title>
</head>
<script>
    let msg = "${param.msg}";
    if (msg == "PWD_UP_OK") alert("비밀번호가 재설정 되었습니다.");
</script>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>
<div id="loginWrap"> 
    <div id="loginHeader" style="border: none;">
        <img src="<c:url value="/img/mainlogo.png"/>">
        <p class="typing-txt">정석코딩</p>
        <h1 id="receipt-text-01"></h1>
    </div>
    <div id="otherLogin">
        <a href="${urlKakao}"><img src="/img/kakaoLogin.png"></a>
        <a href="${urlNaver}"><img src="/img/naverLogin.png"></a>
    </div>
    <hr/>
    <form>
        <div id="loginBox">
            <div id="loginInput">
                <div>
                    <img src="<c:url value="/img/signup_user.png"/>">
                    <input type="text" id="id" name="id" placeholder="이메일을 입력해주세요." value="${cookie.id.value}">
                </div>
                <div>
                    <img src="<c:url value="/img/signup_pwd.png"/>">
                    <input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력해주세요." autocomplete="off">
                </div>
            </div>
            <input type="hidden" name="toURL" value="${param.toURL}">
            <div id="msgBox">
                ${param.msg}
            </div>
        </div>
        <div id="loginMenu">
            <div id="rememberId_section">
                <input type="checkbox"  id="rememberId" name="rememberId" ${empty cookie.id.value ? "":"checked"}>
                <p>아이디 저장</p>
            </div>
            <div id="loginBtn">
                <h1>로그인</h1>
            </div>
            <div>
                <ul>
                    <li><a href="/member/findEmail">아이디 찾기</a></li>
                    <li>|</li>
                    <li><a href="/member/findPwd">비밀번호 찾기</a></li>
                    <li>|</li>
                    <li><a href="/member/signup">회원가입</a></li>
                </ul>
            </div>
        </div>
    </form>
</div>
<footer style="flex-shrink: 0;" >
    <jsp:include page="../footer.jsp" flush="true"/>
</footer>
</body>
</html>