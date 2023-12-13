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
    <title>Login Page</title>
</head>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>
<div id="loginWrap">
    <div id="loginHeader" style="border: none;">
        <img src="<c:url value="/img/logo.png"/>">
        <h1>정석코딩</h1>
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
                    <input type="text" id="id" name="id" placeholder="이메일을 입력해주세요.">
                </div>
                <div>
                    <img src="<c:url value="/img/signup_pwd.png"/>">
                    <input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력해주세요." autocomplete="off">
                </div>
            </div>
            <input type="hidden" name="toURL" value="${param.toURL}">

    </div>
    <div id="loginMenu">
        <div>
            <input type="checkbox"  id="rememberId" name="rememberId" ${empty cookie.id.value ? "":"checked"}>
            <p>아이디 저장</p>
        </div>
        <div id="loginBtn">
            <h1>로그인</h1>
        </div>
        <div>
            <ul>
                <li><a href="">아이디 찾기</a></li>
                <li>|</li>
                <li><a href="">비밀번호 찾기</a></li>
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