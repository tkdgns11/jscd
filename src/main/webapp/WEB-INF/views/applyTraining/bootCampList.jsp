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
    <title>bootCampList</title>
</head>
<body>
    부트캠프리스트 화면입니다.
    <c:forEach var="list" items="${list}">
        <li>${list.registCode}</li>
        <li>${list.title}</li>
        <li>${list.startDate}</li>
        <li>${list.lastPrice}</li>
        <li>${list.location}</li>
        <a href="<c:url value='/btTraining/read?registCode=${list.registCode}'/>"><button type="button">수강 신청 하기</button></a>
    </c:forEach>
</body>
</html>
