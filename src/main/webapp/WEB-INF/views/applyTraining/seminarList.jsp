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
    <title>seminarList</title>
</head>
<body>
    세미나 목록페이지 입니다.
    <c:forEach var="list" items="${list}">
        <li>${list.registCode}</li>
        <li>${list.title}</li>
        <li>${list.startDate}</li>
        <li>${list.lastPrice}</li>
        <li>${list.location}</li>
        <a href="<c:url value='/smTraining/read?registCode=${list.registCode}'/>"><button type="button">수강 신청 하기</button></a>
    </c:forEach>
</body>
</html>
