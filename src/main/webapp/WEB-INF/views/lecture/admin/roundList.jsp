<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12/2/23
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<ul>
    <form id="roundList" method="post">
        <c:forEach var="list" items="${list}">
            <li>${list.roundCode}</li>
            <%--            <li><a href="<c:url value='/onlyAdmin/regist/roundDetail?roundCode=${list.roundCode}'/>">${list.roundName}</a></li>--%>
            <li><a href="<c:url value='/regist/roundDetail?roundCode=${list.roundCode}'/>">${list.roundName}</a></li>
            <li>${list.regDate}</li>
            <li>${list.firstIdNo}</li>
        </c:forEach>
    </form>

    <%--    <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/onlyAdmin/regist/addRound"/>'">등록하기</button>--%>
    <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/regist/addRound"/>'">등록하기</button>
</ul>
</body>
</html>
