<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12/3/23
  Time: 8:13 PM
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
    <title>정석코딩 과목 등록</title>
    <script>
        let msg = "${msg}";
        if(msg == "DEL_ERR") alert("삭제되었거나 없는 게시물입니다.");
        if(msg == "DEL_OK") alert("성공적으로 삭제되었습니다.");
        if(msg == "WRT_OK") alert("성공적으로 등록되었습니다.");
        if(msg == "MOD_OK") alert("해당 게시물을 정상적으로 수정하였습니다.");
    </script>
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
                <h1>정석코딩 과목 목록</h1>
            </div>
            <div id="main_content_controll">
                <div id="lectureSearchBox">
                    <%--검색 부분--%>
                </div>
                <div id="lectureWriteBox">
                    <input type="button" class="modifyBtn" value="강의 추가" onclick="location.href='<c:url value="/adminManage/lstRegist/addRegist"/>'">
                </div>

            </div>
            <div id="lectureListBox">
                <table>
                    <tr>
                        <th>과목 번호</th>
                        <th>등록된 과목 이름</th>
                        <th>최초 등록일</th>
                        <th>최종 수정일</th>
                    </tr>
                    <c:forEach var="classEnrollDto" items="${classEnrollList}">
                        <tr>
                            <td>
                                    ${classEnrollDto.classCode}
                            </td>
                            <td>
                                <a href="<c:url value='/adminManage/classEnroll/read?classCode=${classEnrollDto.classCode}'/>">${classEnrollDto.className}</a>
                            </td>
                            <td>
                                <fmt:formatDate value="${classEnrollDto.regDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                            </td>
                            <td>
                                <fmt:formatDate value="${classEnrollDto.modifyDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                            </td>
                        </tr>
                    </c:forEach>
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
