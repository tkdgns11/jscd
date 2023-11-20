<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var = "path" value = "${pageContext.request.contextPath}"/>
<%@ page import="java.net.URLDecoder" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <form action="/member/login" method="post">
        <label>Username:</label>
        <input type="text" id="id" name="id" required><br>
        <label>Password:</label>
        <input type="password" id="pwd" name="pwd" required><br>
        <button type="submit">Login</button>
    </form>
    <!-- 로그인 실패 시 에러 메시지 표시 -->
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
	<div>
	    <label><input type="checkbox" name="rememberId" value="on" ${empty cookie.id.value ? "":"checked"}> 아이디 기억</label> |
	    <a href="">비밀번호 찾기</a> |
	    <a href="${path}/member/signup">회원가입</a>
	</div>
</body>
</html>   
