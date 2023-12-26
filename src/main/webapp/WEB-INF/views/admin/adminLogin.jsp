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
  <!-- 탭 아이콘 & 글자 지정 -->
  <link rel="icon" href="/img/white_mainlogo.png"/>
  <link rel="apple-touch-icon" href="/img/white_mainlogo.png"/>
  <title>정석코딩 관리자 | 관리자 로그인</title>
  <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Noto+Serif+KR:wght@900&display=swap" rel="stylesheet">
  <style>
    body{height: 100%;overflow: hidden}

    #adminLogoBox{position: absolute;font-weight: 80; color: #AFA95E; justify-content: center; display: flex;}
    #adminLogoBox span{ color: #0185FE; letter-spacing: 10px; font-weight: 550; font-size: 20px; margin-top: 10px; margin-left: 13px;}

    #adminContent{width: 960px; height: 700px; margin: 0 auto;position: relative;}
    #adminLogoBox{position: absolute;margin: 30px 350px;width: 300px;}
    #adminImg{position: absolute;margin: 110px 310px;}
    #adminLogin{position: absolute;margin: 400px 290px;}
    #adminBtn{width: 100%;height: 50px;border: 0;color: white;background-color: #0185FE;font-size: 20px;border-radius: 10px; letter-spacing: 5px; cursor: pointer;}
    #adminBtn:hover{opacity: 0.5;}
    .adminInput{width: 400px;height: 50px;background-color: #FFFFFF;border: solid 1px #cdcdce;margin-bottom: 10px;border-radius: 10px; padding: 0 15px;}
    /*#adminIdCheck{width: 15px;height: 15px;color:#D9D9D9;position: relative;bottom: 10px;}*/
    /*#adminIdCheckLabel{position: relative;top: -14px; color: #7c838b; font-size: 15px;}*/
    #adminIdCheck{width: 15px;height: 15px;color:#D9D9D9;}
    #adminIdCheckLabel{color: #7c838b; font-size: 13px; margin-top: 3px; margin-left: 4px;}
    #adminMsg{ position: absolute;margin: 350px 380px;width: 300px}
    .adminInput:focus {outline: none;}
    #adminId_save {display: flex;}
    #adminId_save {margin-bottom: 15px;}


  </style>
</head>

<body>

<div id="adminContent">
  <div id="adminLogoBox" onclick="location.href='/'">
    <img src="/img/white_mainlogo.png" style="width: 40px; height: 40px;margin-bottom: -15px; border-radius: 8px; border: solid 1px #dadada">
    <span>정석코딩</span>
  </div>

  <div id="adminImg">
    <img src="/img/admin.png" style="width: 400px; height: auto;">
  </div>

  <div id="adminMsg">
    <c:if test="${not empty param.msg}">
      <p style="color: red;font-weight: 600">${URLDecoder.decode(param.msg)}</p>
    </c:if>
  </div>


  <div id="adminLogin">
    <form action="/admin/login" method="post">
      <input type="text" name="id" placeholder="관리자 아이디를 입력해주세요" class="adminInput" value="<%=value%>" autofocus><br>
      <input type="password" name="pwd" placeholder="관리자 비밀번호를 입력해주세요" class="adminInput"><br>
        <div id="adminId_save">
      <input type="checkbox" id="adminIdCheck" name="adminIdCheck" value="check" <%=check%>>
      <label for="adminIdCheck" id="adminIdCheckLabel">아이디 저장</label>
        </div>
        <button id="adminBtn">로그인</button>
        <input type="hidden" name="manageURL" value="${param.manageURL}">
    </form>
  </div>
</div>

</body>
</html>