<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12/9/23
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>seminarDetail</title>
</head>
<body>
<script>
    let msg = "${msg}";
    if(msg == "login required"){
        const confirmMsg = "로그인이 필요한 서비스입니다. \n로그인 하시겠습니까?";
        const confirmBoolean = confirm(confirmMsg);

        if(confirmBoolean){
            window.location.href='http://localhost:8080/member/login';
        }
    }

    if(msg == "duplicate application"){
        alert("이미 신청한 강의입니다.");
    }
</script>
    선택한 세미나 상세페이지 입니다.
    <li>${lstRegistDto.registCode}</li>
    <li>${lstRegistDto.title}</li>
    <li>${lstRegistDto.discription}</li>
    <li>${lstRegistDto.book}</li>
    <li>${lstRegistDto.material}</li>
    <li>${lstRegistDto.lastPrice}</li>
    <li>${lstRegistDto.location}</li>
    <a href="<c:url value='/smTraining/smApplication?registCode=${lstRegistDto.registCode}&title=${lstRegistDto.title}&lastPrice=${lstRegistDto.lastPrice}'/>"><button type="button">수강 신청 하기</button></a>
    <a href="<c:url value='/smTraining/list'/>"><button type="button">목록</button></a>
</body>
</html>
