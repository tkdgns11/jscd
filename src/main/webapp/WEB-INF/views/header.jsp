<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
            <li><a href="#">로그인</a></li>
            <li>|</li>
            <li><a href="#">회원가입</a></li>
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
                        <li><a href="#">공지사항</a></li>
                        <li><a href="#">Q&A</a></li>
                        <li><a href="#">FAQ</a></li>
                    </ul>
                    <ul class="submenu">
                        <li><a href="#">출결/좌석 관리</a></li>
                        <li><a href="#">질의응답</a></li>
                        <li><a href="#">학생 공지사항</a></li>
                    </ul>
                </div>
            </li>
            <!--각자 메뉴-->
            <li id="about">
                <p>ABOUT</p>
                <ul class="Menu">
                    <li><a href="#">원장님 소개</a></li>
                    <li><a href="#">정석코딩 소개</a></li>
                    <li><a href="#">찾아오시는 길</a></li>
                </ul>
            </li>
            <li id="apply">
                <p>교육신청</p>
                <ul class="Menu">
                    <li><a href="#">부트캠프 신청</a></li>
                    <li><a href="#">세미나 신청</a></li>
                </ul>
            </li>
            <li id="board">
                <p>게시판</p>
                <ul class="Menu">
                    <li><a href="#">공지사항</a></li>
                    <li><a href="#">Q&A</a></li>
                    <li><a href="#">FAQ</a></li>
                </ul>
            </li>
            <li id="manage">
                <p>학사관리</p>
                <ul class="Menu">
                    <li><a href="#">출결/좌석 관리</a></li>
                    <li><a href="#">질의응답</a></li>
                    <li><a href="#">학생 공지사항</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</div>
</html>
