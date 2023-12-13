


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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/header.css"/>">
    <script type="text/javascript" src="<c:url value="/js/header.js"/>"></script>
</head>
<div id="headerBox">
    <div id="headerTop">
        <div>
            <a href="#"><img class="logo" src="<c:url value="/img/logo1.png"/>"></a>
            <div>
                <img src="<c:url value="/img/search.png"/>">
                <input type="text" id="searchTxt" name="searchTxt" placeholder="듣고 싶은 강의를 입력해주세요.">
            </div>
        </div>
        <ul>
            <li><a href="<c:url value='${loginPath}'/>">${loginStatus}</a></li>
            <li>|</li>
            <li><a href="<c:url value='${memberPath}'/>">${memberStatus}</a></li>
        </ul>
    </div>
    <nav style="margin: 0 auto">
        <ul>
            <li class="all" id="all">
                <img src="<c:url value="/img/line3.png"/>">
                <div class="Menu">
                    <ul class="submenu">
                        <li><a href="#">원장님 소개</a></li>
                        <li><a href="#">정석코딩 소개</a></li>
                        <li><a href="#">찾아오시는 길</a></li>
                    </ul>
                    <ul class="submenu">
                        <li><a href="#">부트캠프 신청</a></li>
                        <li><a href="#">세미나 신청</a></li>
                    </ul>
                    <ul class="submenu">
                        <li><a href="<c:url value="/board/notice/list"/>">공지사항</a></li>
                        <li><a href="<c:url value="/board/qna/allqnaList"/>">Q&A</a></li>
                        <li><a href="<c:url value="board/faq.jsp"/>">FAQ</a></li>
                    </ul>
                    <ul class="submenu">
                        <li><a href="#">출결/좌석 관리</a></li>
                        <li><a href="#">질의응답</a></li>
                        <li><a href="<c:url value="/board/stdNotice/list"/>">학생 공지사항</a></li>
                    </ul>
                </div>
            </li>
            <!--각자 메뉴-->
            <li id="about">
                <p>ABOUT</p>
                <ul class="Menu gainMenu">
                    <li><a href="#">원장님 소개</a></li>
                    <li><a href="#">정석코딩 소개</a></li>
                    <li><a href="#">찾아오시는 길</a></li>
                </ul>
            </li>
            <li id="apply">
                <p>교육신청</p>
                <ul class="Menu gainMenu">
                    <li><a href="#">부트캠프 신청</a></li>
                    <li><a href="#">세미나 신청</a></li>
                </ul>
            </li>
            <li id="board">
                <p>게시판</p>
                <ul class="Menu gainMenu">
                    <li><a href="<c:url value="/board/notice/list"/>">공지사항</a></li>
                    <li><a href="${path}/board/qna/allqnaList">Q&A</a></li>
                    <li><a href="${path}/board/faq">FAQ</a></li>
                </ul>
            </li>
            <li id="manage">
                <p>학사관리</p>
                <ul class="Menu gainMenu">
                    <li><a href="#">출결/좌석 관리</a></li>
                    <li><a href="#">질의응답</a></li>
                    <li><a href="<c:url value="/board/stdNotice/list"/>">학생 공지사항</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</div>
</html>
