<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? null : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginPath" value="${loginId == null  ?  '/member/login' : '/member/logout'}"/>
<c:set var="loginStatus" value="${loginId== null ? '로그인' : '로그아웃'}"/>
<c:set var="memberPath" value="${loginId == null  ?  '/member/signup' : '/member/memberEdit'}"/>
<c:set var="memberStatus" value="${loginId== null ? '회원가입' : '마이 페이지'}"/>
<c:set var = "path" value = "${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/header.css"/>">
    <script type="text/javascript" src="<c:url value="/js/header.js"/>"></script>
</head>
<body>
<div id="mainHeader">
    <nav>
        <div id="jscdNav">
            <div id="homeImg">
                <a href="<c:url value='/'/>"><img src="<c:url value="/img/logo.png"/>"></a>
                <p>정석코딩</p>
            </div>
            <ul>
                <li id="about">
                    <p>ABOUT</p>
                    <ul class="Menu">
                        <li><a href="/member/introTeacher">원장님 소개</a></li>
                        <li><a href="/member/jscdIntro">정석코딩 소개</a></li>
                        <li><a href="/member/jscdRoad">찾아오시는 길</a></li>
                    </ul>
                </li>
                <li id="apply">
                    <p>교육신청</p>
                    <ul class="Menu">
                        <li><a href="<c:url value="/btTraining/list"/>#">부트캠프 신청</a></li>
                        <li><a href="<c:url value="/smTraining/list"/>#">세미나 신청</a></li>
                    </ul>
                </li>
                <li id="community">
                    <p>커뮤니티</p>
                    <ul class="Menu">
                        <li><a href="<c:url value="/board/notice/list"/>">공지사항</a></li>
                        <li><a href="${path}/board/qna/allqnaList">질문&답변</a></li>
                        <li><a href="${path}/board/faq">FAQ</a></li>
                    </ul>
                </li>
                <li id="manage">
                    <p>학사관리</p>
                    <ul class="Menu">
                        <li><a href="#">공지사항</a></li>
                        <li><a href="#">질문&답변</a></li>
                    </ul>
                </li>
            </ul>
        </div>
<%--        <div id="searchBox">--%>
<%--            <img src="<c:url value="/img/readGlasses.png"/>">--%>
<%--            <input type="text" placeholder="검색어를 입력해주세요.">--%>
<%--        </div>--%>
        <div id="memberBox">
            <input type="button" value="${loginStatus}" class="deleteBtn" onClick="location.href='<c:url value='${loginPath}'/>'">
            <input type="button" value="${memberStatus}" class="registeBtn" onClick="location.href='<c:url value='${memberPath}'/>'">
        </div>
    </nav>
</div>
</body>
</html>
