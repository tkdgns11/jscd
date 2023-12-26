<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12/2/23
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Noto+Serif+KR:wght@900&display=swap"
          rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" tyep="text/css" href="<c:url value="/css/admin/home.css"/>">
    <link rel="stylesheet" tyep="text/css" href="<c:url value="/css/regist.css"/>">
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 과정 등록</title>
</head>
<body>
<header>
    <jsp:include page="../../admin/header.jsp"/>
</header>
<div id="adminContent">
    <nav>
        <jsp:include page="../../admin/sidebar.jsp"/>
    </nav>
    <main>
        <div id="lectureInfo">
            <div id="infoTitleBox">
                <h1>정석코딩 과정 목록</h1>
            </div>
            <div id="main_content_controll">
                <div id="lectureSearchBox">
                    <%--검색 부분--%>
                </div>
                <div id="lectureWriteBox">
                    <button id="writeBtn" class="modifyBtn" onclick="location.href='<c:url value="/adminManage/registCourse/addCourse"/>'">등록하기</button>
                </div>
            </div>
            <div id="lectureListBox">
                <table>
                    <tr>
                        <th>과목 번호</th>
                        <th>등록된 과목 이름</th>
                        <th>최초 등록일</th>
                        <th>최초 등록자 식별번호</th>
                    </tr>

                    <form id="courseList" method="post">
                        <c:forEach var="list" items="${list}">
                            <tr>
                                <td>${list.courseCode}</td>
                                <td><a href="<c:url value='/adminManage/registCourse/courseDetail?courseCode=${list.courseCode}'/>">${list.courseName}</a></td>
                                <td>${list.regDate}</td>
                                <td>${list.firstIdNo}</td>
                            </tr>
                        </c:forEach>
                    </form>

                </table>
            </div>
            <div id="NaviBox">
                <%--내비게이션 부분--%>
            </div>
        </div>
    </main>
</div>

</body>
</html>