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
    <link rel="stylesheet" href="<c:url value='/css/jscdReset.css'/>">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/header.jsp"/>
</header>

<main>
    <section class="board_header">
        <div id="board_header_txt">
            <div id="board_header_txt_title">공지사항_관리자</div>
            <div id="board_header_txt_content">Notice_admin</div>
        </div>
    </section>
    <section class="board_main">
        <section id="boacrd_main_sub">
            <section id="board_aside">
                <div id="board_aside_title"></div>
                <div id="board_aside_contents">
                    <div><a id="board_aside_notice" href="<c:url value="/board/notice/list"/>">공지사항</a></div>
                    <div><a id="board_aside_qna" href="${path}/board/qna/allqnaList">Q&A</a></div>
                    <div><a id="board_aside_faq" href="${path}/board/faq">FAQ</a></div>
                </div>
            </section>
            <section id="board_main_contents">
                <section id="main_header">
                    <h2>관리자_전체</h2>
                </section>

                <form action="<c:url value="/board/notice/list"/>" class="search-form" method="get">
                <section id="mainSearch">
                    <div id="search_select">
                        <select id="selectbox" name="option">
                            <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                            <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목</option>
                            <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
                        </select>
                    </div>
                    <div id="search_contents">
                        <div id="searchbar">
                            <input type="text" name="keyword" value="${ph.sc.keyword}" >
                        </div>
                        <div id="search_btn">
                            <input type="submit" id="searchBtn" class="modifyBtn" value="검색">
                        </div>
                    </div>
                </section>
                </form>
                <hr/>

                <section id="main_submit">
                <span id="submit_btn">
                    <button type = "button" id="writeBtn" CLASS="registeBtn" onclick="location.href='<c:url value ="/board/notice/write"/>'">등록</button>
                </span>
                </section>
                <hr/>

                <c:forEach var="noticeDto" items="${list}">
                <section id="main_contents">
                    <div id="main_content_per">
                        <div id="main_content_info">
                            <div id="info_header">
                                <div id="info_header_category">
                                    <p id="category_title">N.</p>
                                </div>
                                <div id="info_header_title">
                                    <a href="<c:url value="/board/notice/read?bno=${noticeDto.bno}&page=${ph.sc.page}&pageSize=${ph.sc.pageSize}"/>">${noticeDto.title}</a>
                                </div>
                            </div>

                            <div id="info_content">
                                <p class="ellipsis">${noticeDto.content}</p>
                            </div>
                            <div id="info_footer">
                                    <div id="footer_user_info">
                                        <span id="user_info_date">${noticeDto.regDate}</span>
                                        <span id="user_info_id">글쓴이: ${noticeDto.writer}</span>
                                    </div>
                                    <div id="content_info">
                                        <span id="hit_num"><i class="fa-regular fa-eye"></i> ${noticeDto.viewCnt}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </c:forEach>


                <section id="paging">
                    <div id="section_paging">
                        <div id="paging_group">
                            <div class="paging">
                                <c:if test="${totalCnt==null || totalCnt==0}">
                                    <div> 게시물이 없습니다. </div>
                                </c:if>
                                <c:if test="${totalCnt!=null && totalCnt!=0}">
                                    <c:if test="${ph.showPrev}">
                                        <a class="page" href="<c:url value="/board/notice/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">이전</a>
                                    </c:if>
                                    <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                                        <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/board/notice/list${ph.sc.getQueryString(i)}"/>">${i}</a>
                                    </c:forEach>
                                    <c:if test="${ph.showNext}">
                                        <a class="page" href="<c:url value="/board/notice/list${ph.sc.getQueryString(ph.endPage+1)}"/>">다음</a>
                                    </c:if>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </section>

<footer>
    <jsp:include page="/WEB-INF/views/footer.jsp"/>
</footer>

</body>
</html>