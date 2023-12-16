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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/seminar.css"/>">
    <title>seminarList</title>
</head>
<body>

<header>
    <jsp:include page="../header.jsp"/>
</header>
<div>
    <div id="seminarBox">
        <header>
            <p>당신이 정석코딩 오프라인 세미나를 들어야 하는 이유!</p>
            <ul id="seminarList">
                <li>
                    <h1>1</h1>
                    <p>퀄리티 높은 강의</p>
                </li>
                <li>
                    <h1>2</h1>
                    <p>일타 강사의 1:1 리뷰</p>
                </li>
                <li>
                    <h1>3</h1>
                    <p>몰입감 넘치는 학습 분위기</p>
                </li>
            </ul>
        </header>
        <div id="seminarNav">
            <ul>
                <li><a href="#">전체 세미나</a></li>
                <li>|</li>
                <li><a href="#">진행 예정 세미나</a></li>
                <li>|</li>
                <li><a href="#">진행 중인 세미나</a></li>
            </ul>
        </div>
    </div>
    <%--231216 정수 컨트롤러로 보내는 경로 필요함 --%>
    <div id="smApplyList">
        <c:forEach var="list" items="${list}">
        <div id="smApplyBox">

            <a href="#">
            <div>
                <div>
                    <div>상태</div>
                    <h1>${list.title}</h1>
                </div>
                <span></span>
                <img src="#">
            </div>
            </a>
            <p>${list.title}</p>
        </div>
        </c:forEach>
    </div>
</div>
<footer>
    <jsp:include page="../footer.jsp"/>
</footer>


</body>
</html>
