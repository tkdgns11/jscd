<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var = "path" value = "${pageContext.request.contextPath}"/>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 첫 페이지</title>
    <link rel="stylesheet" href="<c:url value='/css/noticeList.css'/>">
</head>
<body>
    <div id="headerNotice">
        <div id="ltone">/* Notice */</div>
        <div id="lttwo">공지사항;</div>
    </div>

    <div id="topnav">
        <a href="<c:url value='/board/user/list'/>">공지사항</a>|
        <a href="<c:url value='allqnaList'/>">QnA</a>|
        <a href="<c:url value="${path}/board/faq"/>">FAQ</a>
   </div>
    <div class="subtop">
        <div id="chkbox">
            <input type = "checkbox" id = "private">비공개 제외
            <input type = "checkbox" id = "myself">내가 작성한 글 보기
        </div>
        <div id="search">
            <form action="<c:url value="/board/user/list"/>" class="search-form" method="get">
                <select id="selectbox" name="option">
                    <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                    <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목</option>
                    <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
                </select>
                <input type="text" name="keyword" value="${ph.sc.keyword}" >
                <input type="submit" id="searchBtn" value="검색">
            </form>
        </div>
    </div>


    <div id = "container">
        <table id="notitbl">
            <thead>
                <tr>
                    <th scope="col"><span>No.</span></th>
                    <th scope="col"><span>제목</span></th>
                    <th scope="col"><span>작성자</span></th>
                    <th scope="col"><span>작성시간</span></th>
                    <th scope="col"><span>조회수</span></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="stdNoticeDto" items="${list}">
                <tr>
                    <td>${stdNoticeDto.bno}</td>
                    <td><a href="<c:url value="/board/userStd/read?bno=${stdNoticeDto.bno}&page=${ph.sc.page}&pageSize=${ph.sc.pageSize}"/>">${stdNoticeDto.title}</a></td>
                    <td>${stdNoticeDto.writer}</td>
                    <td>${stdNoticeDto.regDate}</td>
                    <td>${stdNoticeDto.viewCnt}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <br>
    <div id="btmbox" >
        <div style="background: yellow">
            <c:if test="${totalCnt==null || totalCnt==0}">
                <div> 게시물이 없습니다. </div>
            </c:if>
            <c:if test="${totalCnt!=null && totalCnt!=0}">
                <c:if test="${ph.showPrev}">
                    <a class="page" href="<c:url value="/board/userStd/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>
                </c:if>
                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                    <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/board/userStd/list${ph.sc.getQueryString(i)}"/>">${i}</a>
                </c:forEach>
                <c:if test="${ph.showNext}">
                    <a class="page" href="<c:url value="/board/userStd/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
                </c:if>
            </c:if>
        </div>







    </div>

</body>
</html>