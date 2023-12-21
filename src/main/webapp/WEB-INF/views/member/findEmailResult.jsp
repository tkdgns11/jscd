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
    <title>정석코딩 | 아이디 찾기</title>
</head>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>
<div>
    <div>

        <h1>회원님의 아이디를 확인해주세요</h1>
        ${id}

    </div>

    <input type="button" value="비밀번호 찾기" onclick="location.href='/member/findPwd'">
    <input type="button" value="로그인" onclick="location.href='/member/login'">


</div>
<footer style="flex-shrink: 0;" >
    <jsp:include page="../footer.jsp" flush="true"/>
</footer>

<script>
    
</script>
</body>
</html>