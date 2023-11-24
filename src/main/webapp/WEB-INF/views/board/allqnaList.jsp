<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var = "path" value = "${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
<%--    <link rel="stylesheet" href="<c:url value='/resources/css/style.css/'>/">--%>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>

<div id="menu">
    <ul>
        <li id="logo">게시판</li>
        <li><a href="/">Home</a></li>
        <li><a href="${path}/board/qna/allqnaList">게시판</a></li>
        <!--   <li><a href=""><i class="fas fa-search small"></i></a></li> -->
    </ul>
</div>
<div style="text-align:center">
    <h1>게시판인데요?</h1>
    <button onclick="location.href='${path}/board/qna/qnaForm'">글쓰기</button>



        <div class="board_list_wrap">
            <div class="board_list">
                <div class="top">
                    <div class="allqnaNo">번호</div>
                    <div class="title">제목</div>
                    <div class="writer">글쓴이</div>
                    <div class="regDate">작성일</div>
                    <div class="hit">조회수</div>
                </div>
                <c:forEach var="list"  items="${list}">
                <div>
                    <div class="allqnaNo">${list.allqnaNo}</div>
                    <div class="title"><a href="${path}/board/qna/allqnaDetail?allqnaNo=${list.allqnaNo}">${list.title}</a></div>
                    <div class="writer">${list.writer}</div>
                    <div class="regDate">${list.regDate}</div>
                    <div class="hit">${list.hit}</div>
                </div>
                </c:forEach>
            </div>
            <br>
            <div class="board_page">
                <a href="#" class="bt first">&lt;&lt;</a>
                <a href="#" class="bt prev">&lt;</a>
                <a href="#" class="num on">1</a>
                <a href="#" class="num">2</a>
                <a href="#" class="num">3</a>
                <a href="#" class="num">4</a>
                <a href="#" class="num">5</a>
                <a href="#" class="bt next">&gt;</a>
                <a href="#" class="bt last">&gt;&gt;</a>
            </div>
                <a href="#" class="on">등록</a>

<%--            </div>--%>
        </div>
    <br>




<%--    페이징처리 --%>
    <br>
    <div class="paging-container">
        <div class="paging">
            <c:if test="${totalCnt==null || totalCnt==0}">
                <div> 게시물이 없습니다. </div>
            </c:if>
            <c:if test="${totalCnt!=null && totalCnt!=0}">
                <c:if test="${ph.showPrev}">
                    <a class="page" href="<c:url value="/board/qna/allqnaList?page=${ph.beginPage-1}"/>">&lt;</a>
                </c:if>
                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                    <a class="page ${i==ph.page? "paging-active" : ""}" href="<c:url value="/board/qna/allqnaList?page=${i}"/>">${i}</a>
                </c:forEach>
                <c:if test="${ph.showNext}">
                    <a class="page" href="<c:url value="/board/qna/allqnaList?page=${ph.endPage+1}"/>">&gt;</a>
                </c:if>
            </c:if>
        </div>
    </div>


</body>
</html>