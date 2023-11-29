<%@ page contentType="text/html;charset=utf-8" %>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.net.URLDecoder"%>
<%
  String check = "";
  String value = "";
  Cookie[] cookies = request.getCookies();
  for(Cookie cookie : cookies){
    String name = cookie.getName();
    //이름이 id인 쿠키가 존재한다면,
    if(name.equals("adminId")){
      check = "checked";
      value = cookie.getValue();
    }
  }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>관리자 로그인</title>
  <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Noto+Serif+KR:wght@900&display=swap" rel="stylesheet">
  <style>
    #adminLogoBox{position: absolute;font-weight: 80; color: #AFA95E;}
    #adminContent{width: 960px; height: 700px; margin: 0 auto;position: relative;}
    #adminLogoBox{position: absolute;margin: 50px 380px;width: 300px;}
    #adminImg{position: absolute;margin: 130px 280px;}
    #adminLogin{position: absolute;margin: 450px 230px;}
    #adminBtn{width: 500px;height: 50px;border: 0;color: white;background-color: #18214F;font-size: 24px;}
    #adminBtn:hover{background-color: #D9D9D9;}
    .adminInput{width: 495px;height: 50px;background-color: #D9D9D9;border: 0;margin-bottom: 15px;}
    #adminIdCheck{width: 20px;height: 20px;color:#D9D9D9;position: relative;bottom: 10px;}
    #adminIdCheckLabel{position: relative;top: -14px;}
    #adminMsg{ position: absolute;margin: 400px 360px;}

  </style>
</head>

<body>

<div id="adminContent">
  <div id="adminLogoBox" onclick="location.href='/'">
    <img src="/img/logo.png" style="width: 40px; height: auto;margin-bottom: -10px;">
    <span style="font-size: 40px; font-family: 'Noto Serif KR';">정석코딩</span>
  </div>

  <div id="adminImg">
    <img src="/img/admin.png" style="width: 400px; height: auto;">
  </div>

  <div id="adminMsg">
    <c:if test="${not empty param.msg}">
      <i style="color: red">${URLDecoder.decode(param.msg)}</i>
    </c:if>
  </div>


  <div id="adminLogin" style="position: absolute;">
    <form action="/admin/login" method="post">
      <input type="text" name="id" placeholder="관리자 ID" class="adminInput" value="<%=value%>"><br>
      <input type="password" name="pwd" placeholder="관리자 PWD" class="adminInput"><br>
      <input type="checkbox" id="adminIdCheck" name="adminIdCheck" value="check" <%=check%>>
      <label for="adminIdCheck" id="adminIdCheckLabel">아이디 저장</label>
      <button id="adminBtn">로그인</button>
      <input type="hidden" name="manageURL" value="${param.manageURL}">
    </form>
  </div>
</div>

</body>
</html>