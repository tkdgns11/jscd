<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <a href="https://kauth.kakao.com/oauth/authorize?client_id=f9bba8ce6a0b56e27f28ef5f010fdb0c&redirect_uri=http://localhost:8080/kakao/login&response_type=code"><img class="logo" src="/img/kakaoLogin.png"></a>
    <form action="<c:url value="/member/login"/>" method="post">
        <label>Username:</label>
        <input type="text" id="id" name="id" required><br>
        <label>Password:</label>
        <input type="password" id="pwd" name="pwd" required><br>
        <button type="submit">Login</button>
        <input type="hidden" name="toURL" value="${param.toURL}">
    </form>
    <!-- 로그인 실패 시 에러 메시지 표시 -->
    <div id="msg">
        <c:if test="${not empty error}">
            <p style="color: red;">${error}</p>
        </c:if>
    </div>
	<div>
	    <label><input type="checkbox" name="rememberId" value="on" ${empty cookie.id.value ? "":"checked"}> 아이디 기억</label> |
	    <a href="">비밀번호 찾기</a> |
	    <a href="/member/signup">회원가입</a>
        <a href="/member/kakaoLogout">카카오 로그아웃</a>
	</div>
</body>
</html>   
