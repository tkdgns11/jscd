<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var = "path" value = "${pageContext.request.contextPath}"/>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<c:url value='/css/jscdReset.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/admin/home.css'/>">
<%--    <link rel="stylesheet" href="<c:url value='/css/regist.css'/>">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfo.css"/>">

    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/white_mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/white_mainlogo.png"/>
    <title>정석코딩 관리자 | 전체 공지사항</title>
    <%--폰트어썸 라이브러리 불러오기--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
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
                <h1>
                    <i class="fa-solid fa-file" style="color: #353739;"></i>
                    &nbsp;&nbsp;전체 공지사항 목록</h1>
            </div>
            <div id="main_content_controll">
                <div id="memberSearchBox">
                    <form id="registHead" action="" method="get">
                        <select class="search-option" name="option">
                            <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                            <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
                            <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
                        </select>
                        <input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}" placeholder="검색어를 입력해주세요">
                        <input type="submit" class="searchBtn" value="검색">
                    </form>
                </div>
                <div id="lectureWriteBox">
                    <%--    <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/onlyAdmin/lstRegist/addRegist"/>'">강의 추가하기</button>--%>
                    <input type="button" class="registeBtn" value="공지 등록" onclick="location.href='<c:url value="/board/notice/write"/>'">
                </div>

            </div>
            <div id="memberListBox">
                <%--    게시판    --%>
                <table>
                    <tr>
                        <th style="width: 50px;">No.</th>
                        <th style="width: 300px;">제목</th>
                        <th style="width: 250px;">등록시간</th>
                    </tr>
                    <c:forEach var="list" items="${list}">
                        <tr>
                            <td>${list.bno}</td>
                            <td>${list.title}</td>
<%--                            class="subject_name"--%>
                            <td>${list.regDate} </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="infoNaviBox">
                <c:if test="${totalCnt==null || totalCnt==0}">
                    <p id="noContent"> 게시물이 없습니다. </p>
                </c:if>
                <c:if test="${totalCnt!=null && totalCnt!=0}">
                    <c:if test="${ph.showPrev}">
                        <%--                <a class="page" href="<c:url value='/onlyAdmin/lstRegist/list${ph.sc.getQueryString(ph.beginPage-1)}'/>">&lt;</a>--%>
                        <a href="<c:url value='/adminManage/lstRegist/list${ph.sc.getQueryString(ph.beginPage-1)}'/>">
                            <i class="fa-solid fa-backward" style="color: #353739;"></i>
                        </a>
                    </c:if>
                    <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                        <%--                <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value='/onlyAdmin/lstRegist/list${ph.sc.getQueryString(i)}'/>">${i}</a>--%>
                        <a class="page${i==ph.sc.page? "-paging-active" : ""}" href="<c:url value='/adminManage/lstRegist/list${ph.sc.getQueryString(i)}'/>">${i}</a>
                    </c:forEach>
                    <c:if test="${ph.showNext}">
                        <%--                <a class="page" href="<c:url value='/onlyAdmin/lstRegist/list${ph.sc.getQueryString(ph.endPage+1)}'/>">&gt;</a>--%>
                        <a href="<c:url value='/adminManage/lstRegist/list${ph.sc.getQueryString(ph.endPage+1)}'/>">
                            <i class="fa-solid fa-forward" style="color: #353739;"></i>
                        </a>
                    </c:if>
                </c:if>
            </div>
        </div>
    </main>
</div>
</body>
</html>