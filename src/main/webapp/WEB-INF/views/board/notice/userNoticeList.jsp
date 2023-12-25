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
    <title>게시판 첫 페이지</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<c:url value='/css/noticeList.css'/>">
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/header.jsp"/>
</header>
<main>
    <section id="boardList_header">
        <div>
            <h1>공지사항</h1>
        </div>
    </section>
    <section id="boardList_content">
        <div id="boardList_nav">
            <ul>
                <li><a href="<c:url value="/board/user/list"/>">공지사항</a></li>
                <li><a href="<c:url value="/board/qna/allqnaList"/>">질문&답변</a></li>
                <li><a href="<c:url value="/board/faq"/>">Faq</a></li>
            </ul>
        </div>
        <div id="boardList_main">
            <div id="boardList_main_header">
                <p>게시판 목록 헤더</p>
            </div>
            <div id=boardList_main_search>
                <form action="<c:url value="/board/user/list"/>" method="get">
                    <div>
                        <div id="boardList_search_option">
                            <select name="option">
                                <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                                <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목</option>
                                <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
                            </select>
                        </div>
                        <div id="boardList_search_input">
                            <div>
                                <input type="text" name="keyword" value="${ph.sc.keyword}" placeholder="키워드를 입력하세요.">
                            </div>
                            <div id="search_btn">
                                <input type="submit" id="searchBtn" class="modifyBtn" value="검색">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <hr/>
            <div id="boardList_main_content">
                <div>
                    <c:forEach var="noticeDto" items="${list}">
                        <a href="<c:url value="/board/user/read?bno=${noticeDto.bno}&page=${ph.sc.page}&pageSize=${ph.sc.pageSize}"/>">${noticeDto.title}</a>
                        <p class="ellipsis">${noticeDto.content}</p>
                        <span id="user_info_date">${noticeDto.regDate}</span>
                        <span id="user_info_id">글쓴이: ${noticeDto.writer}</span>
                        <span id="hit_num"><i class="fa-regular fa-eye"></i> ${noticeDto.viewCnt}</span>
                    </c:forEach>
                </div>
                <div>
                    <c:if test="${totalCnt==null || totalCnt==0}">
                        <p>게시물이 없습니다.</p>
                    </c:if>
                    <c:if test="${totalCnt!=null && totalCnt!=0}">
                        <c:if test="${ph.showPrev}">
                            <a class="page" href="<c:url value="/board/user/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">이전</a>
                        </c:if>
                        <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                            <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/board/user/list${ph.sc.getQueryString(i)}"/>">${i}</a>
                        </c:forEach>
                        <c:if test="${ph.showNext}">
                            <a class="page" href="<c:url value="/board/user/list${ph.sc.getQueryString(ph.endPage+1)}"/>">다음</a>
                        </c:if>
                    </c:if>
                </div>
            </div>
        </div>
    </section>
</main>
<footer>
    <jsp:include page="/WEB-INF/views/footer.jsp"/>
</footer>
</body>
</html>