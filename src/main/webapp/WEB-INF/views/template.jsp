<%--
  Created by IntelliJ IDEA.
  User: sanghoon
  Date: 2023/12/10
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="admin/adminSidebar.jsp"%>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
  <script src="https://d3js.org/d3.v7.min.js"></script>
  <style>
    html,
    body {
      height: 100%;
      width: 100%;
      margin: 0;
      padding: 0;
    }

    body {
      font-family: "Lato", sans-serif;
    }

    #headerTop {
      height: 100%;
      justify-items: center;
      align-items: center;
    }

    #headerTop ul {
      height: 100%;
      display: flex;
      flex-direction: row;
      flex-warp: nowrap;
      justify-content: flex-end;
      align-items: center;
    }

    #headerTop ul li {
      height: 100%;
    }

    #headerTop ul li a {
      height: 100%;
      display: flex;
      text-decoration: none;
      font-size: 25px;
      align-items: center;
    }

    .admin_group {
      color: #f1f1f1;
      text-decoration: none;
      font-size: 25px;
    }

    #admin_title {
      margin-left: 45%;
      float:left;
      color: #f1f1f1;
      padding: 1rem 1rem 1rem 1rem;
      text-decoration: none;
      font-size: 25px;
      align-items: center;
    }


    .box {
      border: 1px solid #182566;
      margin-bottom: 10px;
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

    .box-header {
      padding: 10px;
      cursor: pointer;
      position: relative;
    }

    .sidenav {
      height: 100%;
      width: 12%;
      position: fixed;
      z-index: 1;
      top: 0;
      left: 0;
      background-color: #182566;
      overflow-x: hidden;
      padding-top: 50px;
      float: left;
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

    .dropdown-content {
      display: none;
      position: absolute;
      background-color: #f1f1f1;
      min-width: 160px;
      overflow: auto;
      box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
      z-index: 1;
    }

    .dropdown-content a {
      color: black;
      padding: 1rem 1rem;
      text-decoration: none;
      display: block;
    }

    .dropdown a:hover {
      background-color: #ddd;
    }

    #whole {
      padding-top: 50px;
      width: 88%;
      height: 100%;
      float: right;
    }


  </style>
  <script src="https://kit.fontawesome.com/d47308ea25.js" crossorigin="anonymous"></script>
</head>

<body>
<div id="headerBox" style="height: 50px; position: fixed; top: 0; left: 0; width: 100%;  background-color: #182566;  color: #f1f1f1;
z-index: 1000; float: right;/">
  <div id="headerTop">
    <h1 id="admin_title">정석코딩 관리자 시스템</h1>
    <ul>
      <li><a class = "admin_group" href="<c:url value='/admin/logout'/>">로그아웃</a></li>
      <li><a>&nbsp;&nbsp;|&nbsp;&nbsp;</a></li>
      <li><a class = "admin_group" href="<c:url value='/admin/read'/>">개인정보수정</a></li>
    </ul>
  </div>
</div>
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
      <a href="#">학생관리</a>
      <a href="#">성적관리</a>
      <a href="#">출결관리</a>
      <a href="#">강사관리</a>
      <a href="#">회원관리</a>
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
<div id="whole">
</div>

</body>

</html>