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
    <title>정석코딩 강의 등록</title>
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
    <jsp:include page="../../admin/adminHeader.jsp"/>
</header>
<div id="adminContent">
    <main>

        <div id="infoTitleBox">
            <h1>정석코딩 강의 목록</h1>
        </div>
        <div id="infoContentBox">

            <%--    검색    --%>
            <div id="lectureSearchBox">
                <form id="registHead" action="" method="get">
                    <select class="search-option" name="option">
                        <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                        <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
                        <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
                    </select>
                    <input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}" placeholder="검색어를 입력해주세요">
                    <input type="submit" class="deleteBtn" value="검색">
                </form>
            </div>

            <div id="lectureListBox">
                <%--    게시판    --%>
                <table>
                    <tr>
                        <th style="width: 80px;">No.</th>
                        <th style="width: 300px;">제목</th>
                        <th style="width: 250px;">등록시간</th>
                    </tr>
                    <c:forEach var="list" items="${list}">
                        <tr>
                            <td>${list.registCode}</td>
                            <td><a href="<c:url value='/adminManage/lstRegist/detailRegist${ph.sc.queryString}&registCode=${list.registCode}'/>">${list.title}</a></td>
                            <td>${list.regDate} </td>
                        </tr>
                    </c:forEach>
                </table>
                <%--    <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/onlyAdmin/lstRegist/addRegist"/>'">강의 추가하기</button>--%>
                <input type="button" class="modifyBtn" value="강의 추가" onclick="location.href='<c:url value="/adminManage/lstRegist/addRegist"/>'">
            </div>
        </div>

        <%--    내비게이션   --%>
        <div id="NaviBox">
            <c:if test="${totalCnt==null || totalCnt==0}">
                <p id="noContent"> 게시물이 없습니다. </p>
            </c:if>
            <c:if test="${totalCnt!=null && totalCnt!=0}">
                <c:if test="${ph.showPrev}">
                    <%--                <a class="page" href="<c:url value='/onlyAdmin/lstRegist/list${ph.sc.getQueryString(ph.beginPage-1)}'/>">&lt;</a>--%>
                    <a href="<c:url value='/adminManage/lstRegist/list${ph.sc.getQueryString(ph.beginPage-1)}'/>">&lt;</a>
                </c:if>
                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                    <%--                <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value='/onlyAdmin/lstRegist/list${ph.sc.getQueryString(i)}'/>">${i}</a>--%>
                    <a class="page${i==ph.sc.page? "-paging-active" : ""}" href="<c:url value='/adminManage/lstRegist/list${ph.sc.getQueryString(i)}'/>">${i}</a>
                </c:forEach>
                <c:if test="${ph.showNext}">
                    <%--                <a class="page" href="<c:url value='/onlyAdmin/lstRegist/list${ph.sc.getQueryString(ph.endPage+1)}'/>">&gt;</a>--%>
                    <a href="<c:url value='/adminManage/lstRegist/list${ph.sc.getQueryString(ph.endPage+1)}'/>">&gt;</a>
                </c:if>
            </c:if>
        </div>
    </main>
</div>
</body>
</html>
