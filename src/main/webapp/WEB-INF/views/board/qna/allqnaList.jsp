<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
    <%--    <link rel="stylesheet" href="<c:url value='/resources/css/style.css/'>/">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">

</head>
<body>


<div id="content">
    <div class="board_wrap">
        <div class="board_title">
            <strong>Q&A</strong>
        </div>
        <div id="menu">
            <a href="#">공지사항</a>
            <p>|</p>
            <a href="${path}/board/qna/allqnaList">QnA</a>
            <p>|</p>
            <a href="${path}/board/qna/allqnaList">FAQ</a>
        </div>
        <p id="QnA">Q&A</p>
        <input type="checkbox" name="secret" value=""> <span>비밀글 제외</span>
        <input type="checkbox" name="myWriting" value=""> <span>내가 작성한 글 보기</span>

        <div id="top_container">
            <form id="searchBox" action="<c:url value="/board/qna/allqnaList"/>" method="get" name="searchForm">
                <select class="searchOption" name="option">
                    <option value="TC" ${ph.sc.option=='TC' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                    <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목</option>
                    <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
                    <%--                    <option value="I">아이디</option>--%>
                </select>
                <input type="text" name="keyword" class="serachInput" value="${ph.sc.keyword}" placeholder="검색어를 입력하세요">
                <button type="submit" class="searchButtom" value="검색">검색</button>
<%--                <input type="hidden" name="page" value="1">--%>
                <input type="hidden" name="pageSize" value="10">
            </form>
        </div>

        <div class="board_list_wrap">
            <div class="board_list">
                <div class="top">
                    <div class="allqnaNo">번호</div>
                    <div class="title">제목</div>
                    <div class="writer">글쓴이</div>
                    <div class="regDate">작성일</div>
                    <div class="hit">조회수</div>
                </div>
                <c:forEach var="list" items="${list}">
                    <div class="lists">
                        <div class="allqnaNo">${list.allqnaNo}</div>
                        <div class="title"><a href="${path}/board/qna/allqnaDetail?allqnaNo=${list.allqnaNo}&page=${paging.page}">${list.title}</a></div>
                        <div class="writer">${list.writer}</div>
                        <div class="regDate">${list.regDate}</div>
                        <div class="hit">${list.hit}</div>
                    </div>
                </c:forEach>
            </div>

            <br>
            <div class="paging-container">
                <div class="paging">
                    <c:if test="${totalCnt==null || totalCnt==0}">
                        <div id="empty"> 게시물이 없습니다.</div>
                    </c:if>
                    <c:if test="${totalCnt!=null && totalCnt!=0}">
                        <c:if test="${ph.showPrev}">
                            <a id="pageNbr" class="page"
                               href="<c:url value="/board/qna/allqnaList${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>
                        </c:if>
                        <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                            <a id="pageNbr" class="page ${i==ph.sc.page? "paging-active" : ""}"
                               href="<c:url value="/board/qna/allqnaList${ph.sc.getQueryString(i)}"/>">${i}</a>
                        </c:forEach>
                        <c:if test="${ph.showNext}">
                            <a id="pageNbr" class="page"
                               href="<c:url value="/board/qna/allqnaList${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
                        </c:if>
                    </c:if>
                </div>
                <div class="bt_wrap">
                    <a href="${path}/board/qna/allqnaWrite" class="on">등록</a>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>


<%--                <br>--%>
<%--                <div class="paging-container">--%>
<%--                    <div class="paging">--%>
<%--                        <c:if test="${totalCnt==null || totalCnt==0}">--%>
<%--                            &lt;%&ndash;                <div> 게시물이 없습니다. </div>&ndash;%&gt;--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${totalCnt!=null && totalCnt!=0}">--%>
<%--                            <c:if test="${ph.showPrev}">--%>
<%--                                <a class="page" href="<c:url value="/board/qna/allqnaList?page=${ph.beginPage-1}"/>">&lt;</a>--%>
<%--                            </c:if>--%>
<%--                            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">--%>
<%--                                <a class="page ${i==ph.page? "paging-active" : ""}"--%>
<%--                                   href="<c:url value="/board/qna/allqnaList?page=${i}"/>">${i}</a>--%>
<%--                            </c:forEach>--%>
<%--                            <c:if test="${ph.showNext}">--%>
<%--                                <a class="page"--%>
<%--                                   href="<c:url value="/board/qna/allqnaList?page=${ph.endPage+1}"/>">&gt;</a>--%>
<%--                            </c:if>--%>
<%--                        </c:if>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>


