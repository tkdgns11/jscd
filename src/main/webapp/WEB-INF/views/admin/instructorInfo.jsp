<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>강사 상세보기</title>
  <style>
    *{
      text-decoration: none;
      font-family: IBM Plex Sans KR;

    }
    #infoDetailBox{
      width: 45%;
      height: max-content;
      margin: auto;
    }
    .infoModifyBox{
      width: 100%;
      height:40px;
      border: 1px solid gray;
      border-radius: 8px;
      margin-top: -15px;
    }
    .infoValueBox{
      width: 100%;
      height:40px;
      border: 1px solid gray;
      border-radius: 8px;
      margin-top: -15px;
    }
    .infoDetailBtn{
      width: 100px;
      height: 35px;
      border-radius: 20px;
      border: 0;
      color: white;
      background-color: #18214F;
    }
    .infoDetailBtn:hover{
      background-color: #bebebe;
    }
  </style>
  <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Noto+Serif+KR:wght@900&display=swap" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<script>
  let msg = "${param.msg}";
  if(msg=="READ_ERR")  alert("강사 정보를 가져오는데 실패했습니다. 다시 시도해 주세요.");
</script>

<div>

  <div id="infoDetailBox">

    <h2 style="text-align: center;">강사 상세보기</h2>

  <h4>강사번호</h4>
  <div class="infoValueBox">${infoDto.iscrNo}</div>
  <h4>아이디</h4>
  <div class="infoValueBox">${infoDto.id}</div>
  <h4>이름</h4>
  <div class="infoValueBox">${infoDto.name}</div>
  <h4>생년월일</h4>
  <div class="infoValueBox">${infoDto.iscrNo}</div>
  <h4>폰번호</h4>
  <div class="infoValueBox">${infoDto.phone}</div>
  <h4>소개</h4>
  <input type="text" class="infoModifyBox" readonly value="${infoDto.intro}">
  <h4>상태</h4>
  <input type="text" class="infoModifyBox" readonly value="${infoDto.status}">
  <h4>급여</h4>
  <input type="text" class="infoModifyBox" readonly value="${infoDtos.hourPmt}">
  <h4>계좌</h4>
  <div class="infoValueBox">${infoDto.acct}</div>
  <h4>강사 등록일</h4>
  <div class="infoValueBox"><fmt:formatDate value="${infoDto.regDate}" pattern="yyyy-MM-dd" type="date"/></div>
  <h4>비고</h4>
  <input type="text" class="infoModifyBox" readonly value="${infoDto.etc}">

    <div style="margin-left: 300px;margin-top: 20px;">
    <button class="infoDetailBtn"  onclick="location.href='/instructor/modify?page=${page}&iscrNo=${infoDto.iscrNo}'">수정</button>
    <button class="infoDetailBtn" onclick="location.href='/instructor/list?page=${page}'">목록</button>
  </div>
</div>







</body>
</html>
