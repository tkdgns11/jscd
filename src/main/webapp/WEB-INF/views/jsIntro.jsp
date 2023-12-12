<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta charset="utf-8">

  <title>정석코딩 소개</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">


  <style>
    #academyTitleBox{
      margin-bottom: 30px;
    }
    #academyTitleBox > p{
      background-color: #D9D9D9;
      width: 150px;
      height: 40px;
      margin-right: 350px;
      font-weight: 700;
      text-align: center;
      line-height: 40px;
      margin-bottom: 30px;
      margin-bottom: 20px;
      margin-left: -50%;
    }
    #academyContentBox{
      display: flex;
      flex-direction: column;
      align-items: center;
      margin-top: 3%;
    }
    .itemTitle{
      background-color: #182566;
      width: 350px;
      height: 45px;
      font-size: 30px;
      color: white;
      border-radius: 20px;
      text-align: center;
      line-height: 45px;
      margin-bottom: 10px;
    }
    #className{
      width: 900px;
      height: 45px;
      text-align: center;
      margin-top: 10px;
    }
    .classItemBox{
      display: flex;
      flex-direction: row;
    }
    .itemBox{
      margin: 10px 10px 40px 10px;
    }
    .itemDesc{
      width: 410px;
      text-align: center;
      margin:5px 0;
      font-weight: 450;
    }
    .itemImg{
      object-fit: cover;
      border-radius: 20px;
    }
  </style>
</head>
<body>

<header>
  <jsp:include page="header.jsp"/>
</header>



<div id="academyContentBox">

  <div id="academyTitleBox">
    <p>학원 시설</p>
  </div>

  <div id="classBox">
    <p class="itemTitle">학습 공간</p>
    <img src="<c:url value="/img/class.jpg"/>" class="itemImg" style="width: 900px; height: 400px;"><br>
    <p id="className">423호,425호,518호</p>
  </div>

  <div class="classItemBox">
    <div class="itemBox">
      <img src="<c:url value="/img/desk.jpg"/>"  class="itemImg" style="width: 440px; height: 300px;">
      <p class="itemDesc">2인용 넓은 책상(180cm)</p>
    </div>
    <div class="itemBox">
      <img src="<c:url value="/img/chair.jpg"/>"  class="itemImg" style="width: 440px; height: 300px;"><br>
      <p class="itemDesc">오래 앉아도 피로가 적은 고급 의자</p>
    </div>
  </div>

  <div class="classItemBox">
    <div class="itemBox">
      <img src="<c:url value="/img/airPurifier.jpg"/>"  class="itemImg" style="width: 440px; height: 300px;">
      <p class="itemDesc">강의실마다 공기청정기 배치</p>
    </div>
    <div class="itemBox">
      <img src="<c:url value="/img/window.jpg"/>"  class="itemImg" style="width: 440px; height: 300px;"><br>
      <p class="itemDesc">외부 소음 완전 차단하는 이중창</p>
    </div>
  </div>

  <div class="classItemBox">
    <div class="itemBox">
      <p class="itemTitle">3개의 스터디룸&회의실</p>
      <img src="<c:url value="/img/stRoom.jpg"/>"  class="itemImg" style="width: 450px; height: 300px;">
      <p class="itemDesc">581호내의 위치</p>
    </div>
    <div class="itemBox">
      <p class="itemTitle">강의실마다 사물함 배치</p>
      <img src="<c:url value="/img/jsLocker.jpg"/>"  class="itemImg" style="width: 450px; height: 300px;">
    </div>
  </div>

  <div class="classItemBox">
    <div class="itemBox">
      <p class="itemTitle">휴게실</p>
      <img src="<c:url value="/img/restRoom.jpg"/>"  class="itemImg" style="width: 450px; height: 300px;">
      <p class="itemDesc">냉장고,전자렌지,정수기 배치</p>
    </div>
    <div class="itemBox" style="margin-top: 65px;">
      <img src="<c:url value="/img/restLocker.jpg"/>"  class="itemImg" style="width: 450px; height: 300px;object-fit: cover;">
      <p class="itemDesc">전자키 개인사물함</p>
    </div>
  </div>

</div>



<footer>
  <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
