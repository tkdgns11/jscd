<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jskang
  Date: 12/11/23
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div>
    <ul>
      <li><a href="#">회원 정보 수정</a></li>
      <li><a href="#">강의 신청 현황</a></li>
    </ul>
  </div>
  <div>
    <div>
      <p></p>
    </div>
    <c:forEach var="list" items="${list}">
    <div>
        <ul>
          <li>${list.id}</li>
          <li>${list.registCode}</li>
          <li>${list.title}</li>
          <li>${list.status}</li>
          <li>${list.lastPrice}</li>
        </ul>
    </div>
    <div>
      <input type="button" value="대기중">
      <input type="button" value="결제하기">
    </div>
    </c:forEach>

  </div>
</body>
</html>
