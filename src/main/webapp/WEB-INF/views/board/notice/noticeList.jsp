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
    <link rel="stylesheet" href="<c:url value='/css/regist.css'/>">
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
        <div id="lectureInfo">
            <div id="infoTitleBox">
                <h1>정석코딩 공지사항(전체) 목록</h1>
            </div>
            <div id="main_content_controll">
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
                <div id="lectureWriteBox">
                    <%--    <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/onlyAdmin/lstRegist/addRegist"/>'">강의 추가하기</button>--%>
                    <input type="button" class="modifyBtn" value="공지 등록" onclick="location.href='<c:url value="/adminManage/lstRegist/addRegist"/>'">
                </div>

            </div>
            <div id="lectureListBox">
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
                            <td>${list.regDate} </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
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
        </div>
    </main>
</div>
</body>
</html>