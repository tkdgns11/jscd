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
<%--  <meta charset="UTF-8">--%>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
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

    /*여기부터 컨텐츠*/

    #btApplicationAll{
      width: 960px;
      margin: 0 auto;
    }
    #applicationText{
      padding: 30px 0px 15px 15px;
      font-size: 30px;
      font-weight: 500;
    }
    #detailsText{
      padding-left: 15px;
      color: red;
    }
    .redText{
      color: red;
    }
    .question{
      padding: 10px 0px 15px 15px;
      font-size: 20px;
    }

    .applicationTextarea{
      margin-left: 15px;
      width: 560px;
      height: 100px;
      border: 1px solid rgba(0,0,0,0.30);
      border-radius: 8px;
      resize: none;
    }
    #selAll{
      margin-left: 15px;
      padding: 10px 0px 10px 0px;
      border: 1px solid rgba(0,0,0,0.30);
      border-radius: 8px;
      width: 280px;
      font-size: 18px;
    }
    #selAll input {
      margin: 5px;
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
  <div id="btApplicationAll">
    <h1 id="applicationText">정석코딩 부트캠프 신청서</h1>
    <span id="detailsText">최대한 자세히 작성해주세요.</span>
    <hr>
    <form id="btApplicationForm" method="post">
      <input type="hidden" name="id" value="${id}">
      <input type="hidden" name="registCode" value="${lstRegistDto.registCode}">
      <input type="hidden" name="title" value="${lstRegistDto.title}">
      <input type="hidden" name="lastPrice" value="${lstRegistDto.lastPrice}">
      <div>
        <div class="question">Q. 본인의 프로그래밍 지식이나 경험 수준에 대해 선택해주세요. <span class="redText">(선택 1)</span></div>
        <div id="selAll">
          <label><input type="radio" name="level" value="낮음">낮음</label><hr>
          <label><input type="radio" name="level" value="중간">중간</label><hr>
          <label><input type="radio" name="level" value="높은">높은</label>
        </div>
      </div>
      <br>
      <div>
        <div class="question">Q. 본인의 코딩 경험이나 수준에 대해서 자세히 적어주세요. <span class="redText">(300자 내외)</span></div>
        <textarea class="applicationTextarea" name="levelDetail" maxlength="300"></textarea>
      </div>
      <br>
      <div>
        <div class="question">Q. 정석코딩 부트캠프에 참여하려는 목적을 선택해주세요. <span class="redText">(선택 1)</span></div>
        <div id="selAll">
          <label><input type="radio" name="attdPps" value="실무에서 필요">실무에서 필요</label><hr>
          <label><input type="radio" name="attdPps" value="취업 준비 or 이직 준비">취업 준비 or 이직 준비</label><hr>
          <label><input type="radio" name="attdPps" value="개인적인 관심">개인적인 관심</label><hr>
          <label><input type="radio" name="attdPps" value="기타">기타</label>
        </div>
      </div>
      <br>
      <div>
        <div class="question">Q. 정석코딩 부트캠프에 대한 정보를 얻으신 경로를 선택해주세요. <span class="redText">(선택 1)</span></div>
        <div id="selAll">
          <label><input type="radio" name="attdPath" value="페이스북, 인스타 등 SNS">페이스북, 인스타 등 SNS</label><hr>
          <label><input type="radio" name="attdPath" value="정석코딩 네이버 카페">정석코딩 네이버 카페</label><hr>
          <label><input type="radio" name="attdPath" value="지인 추천">지인 추천</label><hr>
          <label><input type="radio" name="attdPath" value="기타">기타</label>
        </div>
      </div>
      <br>
      <div>
        <div class="question">Q.간단한 자기소개를 해주세요. <span class="redText">(300자 내외)</span></div>
        <textarea class="applicationTextarea" name="intro" maxlength="300"></textarea>
      </div>
      <br>
      <div>
        <div class="question">Q.정석코딩 부트캠프에서 기대하는 것은 무엇입니까? <span class="redText">(300자 내외)</span></div>
        <textarea class="applicationTextarea" name="expect" maxlength="300"></textarea>
      </div>
      <br>
      <div>
        <div class="question">Q.학업에 전념 <span class="redText">(하루 14시간 이상)</span> 하지 않거나 타인에게 피해를 주는 경우<br>
          &emsp;퇴소 될 수 있습니다. 동의하십니까? <span class="redText">(선택 1)</span></div>
        <div id="selAll">
          <label><input type="radio" name="agreeYN" value="Y">예</label><hr>
          <label><input type="radio" name="agreeYN" value="N">아니오</label>
        </div>
      </div>
      <br>
      <hr>
      &emsp;<input type="button" id="writeBtn" class="registeBtn" value="제출">
      <br><br>
    </form>
  </div>

</div>

</body>

</html>