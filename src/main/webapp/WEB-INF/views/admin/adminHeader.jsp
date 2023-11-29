<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
            <a href="/admin/home"><img src="<c:url value="/img/adminMainLogo.png"/>"
                                       style="width: 450px;height: 72px;margin-left: 300px"></a>
        </div>
        <ul>
            <li><a href="<c:url value='/admin/logout'/>">로그아웃</a></li>
            <li>|</li>
            <li><a href="<c:url value='/admin/read'/>">개인정보수정</a></li>
        </ul>
    </div>
    <nav style="margin: 0 auto">
        <ul>
            <li class="all" id="all">
                <img src="<c:url value="/img/line3.png"/>">
                <div class="Menu">
                    <ul class="submenu">
                        <li><a href="#">학생 출결</a></li>
                        <li><a href="/onlyAdmin/stdManage/list">학생 관리</a></li>
                        <li><a href="/onlyAdmin/instructor/list">강사 관리</a></li>
                        <li><a href="/onlyAdmin/memberManage/list">회원 관리</a></li>
                    </ul>
                    <ul class="submenu">
                        <li><a href="#">부트캠프 등록</a></li>
                        <li><a href="#">세미나 등록</a></li>
                    </ul>
                    <ul class="submenu">
                        <li><a href="#">전체 공지사항 등록</a></li>
                        <li><a href="#">학생 공지사항 등록</a></li>
                        <li><a href="#">FAQ 등록</a></li>
                    </ul>
                    <ul class="submenu">
                        <li><a href="#">학생 좌석 현황</a></li>
                        <li><a href="/locker/adminList">사물함 현황</a></li>
                    </ul>
                </div>
            </li>
            <!--각자 메뉴-->
            <li id="about">
                <p>학사관리</p>
                <ul class="Menu gainMenu">
                    <li><a href="#">학생 출결</a></li>
                    <li><a href="/onlyAdmin/stdManage/list">학생 관리</a></li>
                    <li><a href="/onlyAdmin/instructor/list">강사 관리</a></li>
                    <li><a href="/onlyAdmin/memberManage/list">회원 관리</a></li>
                </ul>
            </li>
            <li id="apply">
                <p>교육등록</p>
                <ul class="Menu gainMenu">
                    <li><a href="#">부트캠프 등록</a></li>
                    <li><a href="#">세미나 등록</a></li>
                </ul>
            </li>
            <li id="board">
                <p>커뮤니티 등록</p>
                <ul class="Menu gainMenu">
                    <li><a href="#">전체 공지사항 등록</a></li>
                    <li><a href="">학생 공지사항 등록</a></li>
                    <li><a href="#">FAQ 등록</a></li>
                </ul>
            </li>
            <li id="manage">
                <p>부대시설</p>
                <ul class="Menu gainMenu">
                    <li><a href="#">학생 좌석 현황</a></li>
                    <li><a href="#">사물함 현황</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</div>
</html>
