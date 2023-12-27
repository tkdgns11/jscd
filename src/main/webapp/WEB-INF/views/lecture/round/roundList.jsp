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
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Noto+Serif+KR:wght@900&display=swap"
          rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" tyep="text/css" href="<c:url value="/css/admin/home.css"/>">
<%--    <link rel="stylesheet" tyep="text/css" href="<c:url value="/css/regist.css"/>">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfo.css"/>">
    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/white_mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/white_mainlogo.png"/>
    <title>정석코딩 관리자 | 강의 회차 목록</title>
    <%--폰트어썸 라이브러리 불러오기--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
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
        <div id="memberInfo">
            <div id="infoTitleBox">
                <h1><i class="fa-solid fa-repeat" style="color: #353739;"></i>
                    &nbsp;&nbsp;정석코딩 회차 목록</h1>
            </div>
            <div id="main_content_controll">
                <div id="lectureSearchBox">
                    <%--검색 부분--%>
                </div>
                <div id="lectureWriteBox">
                    <button id="writeBtn" class="registeBtn" onclick="location.href='<c:url value="/adminManage/registRound/addRound"/>'">등록하기</button>
                </div>

            </div>
            <div id="memberListBox">
                <table>
                    <tr>
                        <th>과목 번호</th>
                        <th>등록된 과목 이름</th>
                        <th>최초 등록일</th>
                        <th>최초 등록자 식별번호</th>
                    </tr>
                    <form id="roundList" method="post">
                        <c:forEach var="list" items="${list}">
                            <tr>
                                <td>
                                        ${list.roundCode}
                                </td>
                                <td>
                                    <a class="subject_name" href="<c:url value='/adminManage/registRound/roundDetail?roundCode=${list.roundCode}'/>">${list.roundName}</a>
                                </td>
                                <td>
                                        <%--                                    <fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd"></fmt:formatDate>--%>
                                        ${list.regDate}
                                </td>
                                <td>
                                        ${list.firstIdNo}
                                </td>
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
