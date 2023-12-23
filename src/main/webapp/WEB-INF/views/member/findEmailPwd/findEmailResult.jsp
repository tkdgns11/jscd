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


    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | 아이디 찾기</title>

    <style>
        #eamilValue{
            font-size: 30px;
            margin: 10px 0px 25px 0px;
        }
        #findEmailBox h1{
        line-height: 50px; font-size: 30px; margin-left: 10px;
         margin-top: 3px; color: #0185FE;letter-spacing: 12px;}
        .findEmailBtn{
            width: 250px;
            height: 40px;
            font-size: 19px;
            background-color: #0185FE;
            color: #fff;
            cursor: pointer;
            border-radius: 5px;
            letter-spacing: 10px;
            font-weight: 600;
            border: 0;
            margin-top: 30px;
            margin-left: 30px;
        }

    </style>
</head>
<body>
<header>
    <jsp:include page="../../header.jsp"/>
</header>
<div id="loginWrap">
        <div id="findEmailBox" style="border: none;">
            <h1>이메일확인</h1>
        </div>
        <p id="eamilValue">${id}</p>

    <div style="display: flex;flex-direction: row">
    <input type="button" value="로그인" onclick="location.href='/member/login'" class="findEmailBtn">
    <input type="button" value="비밀번호 찾기" onclick="location.href='/member/findPwd'" class="findEmailBtn">
    </div>


</div>
<footer style="flex-shrink: 0;" >
    <jsp:include page="../../footer.jsp" flush="true"/>
</footer>

<script>
    
</script>
</body>
</html>