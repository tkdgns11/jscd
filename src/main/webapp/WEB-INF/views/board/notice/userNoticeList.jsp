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
    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | 전체 공지사항</title>
    <link rel="stylesheet" href="<c:url value='/css/noticeList.css'/>">
    <script type="text/javascript" src="<c:url value="/js/noticeList.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/board_nav.js"/>"></script>
    <%--폰트어썸 라이브러리 불러오기--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/header.jsp"/>
</header>
<main>
    <section id="boardList_header">
        <div>
            <h1>공지사항</h1>
            <h3>정석코딩의 최신 소식을 접해보세요</h3>
        </div>
    </section>
    <section id="boardList_content">
        <div id="boardList_nav">
            <ul>
                <li><a href="<c:url value="/board/user/list"/>">
                    <i class="fa-solid fa-bullhorn" style="color: #73b4f0;"></i>
                    &nbsp;&nbsp;공지사항</a></li>
                <li><a href="<c:url value="/board/qna/allqnaList"/>">
                    <i class="fa-solid fa-comment-dots" style="color: #73b4f0;"></i>
                    &nbsp;&nbsp;질문&답변</a></li>
                <li><a href="<c:url value="/board/faq"/>">
                    <i class="fa-solid fa-circle-question" style="color: #73b4f0;"></i>
                    &nbsp;&nbsp;Faq</a></li>
            </ul>
        </div>
        <div id="boardList_main">
            <div id="boardList_main_header">
                <p>&nbsp;</p>
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
                                <input type="text" name="keyword" value="${ph.sc.keyword}" placeholder="&nbsp;&nbsp;&nbsp;키워드를 입력하세요">
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
                        <div id="board_content_per">
                            <a href="<c:url value="/board/user/read?bno=${noticeDto.bno}&page=${ph.sc.page}&pageSize=${ph.sc.pageSize}"/>">${noticeDto.title}</a>
<%--                            <p class="ellipsis">${noticeDto.content}</p>--%>
                            <div id="board_content_footer">
                                <div>
                                    <span id="user_info_date">${noticeDto.regDate}</span>
                                    <span id="user_info_id">&nbsp;&nbsp;
                                        <i class="fa-solid fa-user-pen fa-xs" style="color: #afb1b6;"></i>
                                            ${noticeDto.writer}</span>
                                </div>
                                <span id="hit_num"><i class="fa-regular fa-eye" style="color: #afb1b6;"></i> ${noticeDto.viewCnt}</span>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div id="board_paging">
                    <c:if test="${totalCnt==null || totalCnt==0}">
                        <p>게시물이 없습니다.</p>
                    </c:if>
                    <c:if test="${totalCnt!=null && totalCnt!=0}">
                        <c:if test="${ph.showPrev}">
                            <a class="page" href="<c:url value="/board/user/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">
                                <i class="fa-solid fa-backward-step"></i></a>
                        </c:if>
                        <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                            <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/board/user/list${ph.sc.getQueryString(i)}"/>">${i}</a>
                        </c:forEach>
                        <c:if test="${ph.showNext}">
                            <a class="page" href="<c:url value="/board/user/list${ph.sc.getQueryString(ph.endPage+1)}"/>">
                                <i class="fa-solid fa-forward-step"></i></a>
                        </c:if>
                    </c:if>
                </div>
            </div>
            <div id="empty_space"></div>
        </div>
        
    </section>
</main>
<footer>
    <jsp:include page="/WEB-INF/views/footer.jsp"/>
</footer>
</body>
</html>