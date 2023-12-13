<%--
  Created by IntelliJ IDEA.
  User: sanghoon
  Date: 2023/12/05
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: "Lato", sans-serif;
        }

        .box {
            margin-bottom: 10px;
            color: #f1f1f1;
        }

        .box-header {
            padding: 10px;
            cursor: pointer;
            position: relative;
        }

        .box-content {
            display: none;
            padding: 10px;
        }

        .sidenav {
            float:left;
            height: 100%;
            width: 15%;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #0185FE;
            overflow-x: hidden;
            padding-top: 20px;
        }

        .sidenav a {
            padding: 6px 8px 6px 16px;
            text-decoration: none;
            font-size: 25px;
            color: #f1f1f1;
            display: block;
        }

        .sidenav a:hover {
            color: gold;
        }

        @media screen and (max-height: 450px) {
            .sidenav {
                padding-top: 15px;
            }

            .sidenav a {
                font-size: 18px;
            }
        }

        .arrow {
            position: absolute;
            top: 50%;
            right: 10px;
            transform: translateY(-50%);
            width: 0;
            height: 0;
            border-style: solid;
            border-width: 0 5px 5px 5px;
            border-color: transparent transparent #f1f1f1 transparent;
        }

        .arrow.up {
            transform: translateY(-50%) rotate(180deg);
        }
    </style>
    <script src="https://kit.fontawesome.com/d47308ea25.js" crossorigin="anonymous"></script>
    <title>sidebar</title>
</head>

<body>

<div class="sidenav">
    <div class="box">
        <div class="box-header" onclick="toggleBoxContent(this)">
            <a href="#contact"><i class="fa-solid fa-user-graduate"></i>사이트 통계</a>
        </div>
    </div>
    <div class="box">
        <div class="box-header" onclick="toggleBoxContent(this)">
            <a href="#about"><i class="fa-solid fa-user"></i> My page</a>
            <span class="arrow up"></span>
        </div>
        <div class="box-content">
            <a href="#"></a>
        </div>
    </div>
    <div class="box">
        <div class="box-header" onclick="toggleBoxContent(this)">
            <a href="#about"><i class="fa-solid fa-circle-user"></i> 학사관리</a>
            <span class="arrow up"></span>
        </div>
        <div class="box-content">
            <a href="/onlyAdmin/stdManage/list">학생정보</a>
            <a href="#">성적관리</a>
            <a href="#">출결관리</a>
            <a href="/onlyAdmin/instructor/list">강사관리</a>
            <a href="/onlyAdmin/memberManage/list">회원관리</a>
        </div>
    </div>
    <div class="box">
        <div class="box-header" onclick="toggleBoxContent(this)">
            <a href="#services"><i class="fa-solid fa-synagogue"></i> 교육등록</a>
            <span class="arrow up"></span>
        </div>
        <div class="box-content">
            <a href="#">부트캠프</a>
            <a href="#">세미나</a>
        </div>
    </div>
    <div class="box">
        <div class="box-header" onclick="toggleBoxContent(this)">
            <a href="#clients"><i class="fa-solid fa-users"></i> 커뮤니티</a>
            <span class="arrow up"></span>
        </div>
        <div class="box-content">
            <a href="#">전체공지</a>
            <a href="#">학생공지</a>
            <a href="#">FAQ</a>
        </div>
    </div>
    <div class="box">
        <div class="box-header" onclick="toggleBoxContent(this)">
            <a href="#contact"><i class="fa-solid fa-city"></i> 시설물</a>
            <span class="arrow up"></span>
        </div>
        <div class="box-content">
            <a href="#">강의실</a>
            <a href="#">사물함</a>
        </div>
    </div>
</div>

<script>
    function toggleBoxContent(element) {
        var boxContent = element.nextElementSibling;
        var arrow = element.querySelector('.arrow');
        if (window.getComputedStyle(boxContent).display === 'none' || window.getComputedStyle(boxContent).display === '') {
            boxContent.style.display = 'block';
            arrow.classList.remove('up');
        } else {
            boxContent.style.display = 'none';
            arrow.classList.add('up');
        }
    }
</script>

</body>

</html>