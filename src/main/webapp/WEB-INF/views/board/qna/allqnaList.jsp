<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Q&A</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/allqnaList.css"/>">

</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/header.jsp"/>
</header>
<main>
    <section class="board_header">
        <div id="board_header_txt">
            <div id="board_header_txt_title">묻고 답해요</div>
            <div id="board_header_txt_content">Q&A</div>
        </div>
    </section>
    <section class="board_main">
        <section id="boacrd_main_sub">
            <section id="board_aside">
                <div id="board_aside_title">커뮤니티</div>
                <div id="board_aside_contents">
                    <div><a id="board_aside_notice" href="<c:url value="/board/user/list"/>">공지사항</a></div>
                    <div><a id="board_aside_qna" href="${path}/board/qna/allqnaList">Q&A</a></div>
                    <div><a id="board_aside_faq" href="${path}/board/faq">FAQ</a></div>
                </div>
            </section>
            <section id="board_main_contents">
                <section id="main_header">
                    <h2>전체</h2>
                </section>

                <form action="<c:url value="/board/qna/allqnaList"/>" method="get" name="searchForm">
                <section id="main_search">
                    <div id="search_select">
                        <select name="option">
                            <option name="" value="TC" ${ph.sc.option=='TC' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                            <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목</option>
                            <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
                        </select>
                    </div>
                    <div id="search_contents">
                        <div id="searchbar">
                            <input type="search" name="keyword" placeholder="원하는 키워드를 입력하세요">
                        </div>
                        <div id="search_btn">
                            <input type="submit"  class="modifyBtn" value="검색">
                        </div>
                    </div>
                </section>
                </form>
                <hr/>

                <section id="main_submit">
                    <div id="except_secret">
                        <input type="checkbox" class="secret" name="secret" value="secret"> 비밀글 제외
                    </div>
                    <div id="my_contents">
                        <input type="checkbox" name="myWriting" value="">
                        <span>내가 작성한 글 보기</span>
                    </div>
                    <span id="submit_btn">
                        <input type="button" value="등록" id="registBtn" class="registeBtn" onclick="window.location.href='/board/qna/allqnaWrite'">

                    </span>
                </section>
                <hr/>

                <c:forEach var="list" items="${list}">
                <section id="main_contents">
                    <div id="main_content_per">
                        <div id="main_content_info">
                            <div id="info_header">
                                <div id="info_header_category">
                                    <p id="category_title">${list.ctName}</p>
                                </div>
                                <div id="info_header_title" data-openyn="${list.openYN}">
                                    <c:if test="${empty param.secret}">
                                        <c:choose>
                                            <c:when test="${list.openYN eq 'Y' || empty list.openYN || list.openYN eq null}">
                                                <a href="${path}/board/qna/allqnaDetail?allqnaNo=${list.allqnaNo}">${list.title}</a>
                                            </c:when>
                                            <c:when test="${list.openYN eq 'N'}">
                                                비밀글은 작성자와 관리자만 볼 수 있습니다.
                                            </c:when>
                                            <c:when test="${list.openYN eq 'N' && not empty param.secret}">

                                            </c:when>
                                        </c:choose>
                                    </c:if>
                                </div>
                            </div>

                            <div id="info_content">
                                <c:if test="${empty param.secret}">
                                    <c:choose>
                                        <c:when test="${list.openYN eq 'Y' || empty list.openYN || list.openYN eq null}">
                                            <p class="ellipsis">${list.content}</p>
                                        </c:when>
                                        <c:when test="${list.openYN eq 'N'}">
                                           비밀글입니다.
                                        </c:when>
                                        <c:when test="${list.openYN eq 'N' && not empty param.secret}">
                                        </c:when>
                                    </c:choose>
                                </c:if>
                            </div>
                            <div id="info_footer">
                                <div id="footer_user_info">
                                    <span id="user_info_name">${list.writer}</span>
                                    <span id="user_info_id">(${list.writer})</span>
                                    <span id="user_info_date">${list.regDate}</span>
                                </div>
                                <div id="content_info">
                                    <span id="board_num">${list.allqnaNo}</span>
                                    <span id="hit_num">list.hit</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

            </c:forEach>
                <section id="paging">
                    <div id="section_paging">
                        <div id="paging_group">
<%--                            게시물이 없습니다 가 두개입니다 뭘 지워야 할 지 몰라 안 지웠으니 지워주세요--%>
                            <c:if test="${totalCnt==null || totalCnt==0}">
                                <div id="empty"> 게시물이 없습니다.</div>
                            </c:if>

<%--                            <div id="paging_group_fst">--%>
<%--                                <input type="button" value="<<   처음">--%>
<%--                            </div>--%>

                            <div class="paging">
                                <c:if test="${totalCnt==null || totalCnt==0}">
                                    <div id="empty"> 게시물이 없습니다.</div>
                                </c:if>
                                <c:if test="${totalCnt!=null && totalCnt!=0}">
                                    <c:if test="${ph.showPrev}">
                                        <input type="button" id="pageNbr" class="bt page"
                                           href="<c:url value="/board/qna/allqnaList${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</input>
                                    </c:if>
                                    <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                                        <a id="pageNbr" class="page ${i==ph.sc.page? "paging-active" : ""}"
                                           href="<c:url value="/board/qna/allqnaList${ph.sc.getQueryString(i)}"/>">${i}</a>
                                    </c:forEach>
                                    <c:if test="${ph.showNext}">
                                        <input type="button" id="pageNbr" class="bt page"
                                           href="<c:url value="/board/qna/allqnaList${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</input>
                                    </c:if>
                                </c:if>
                            </div>

<%--                            <div id="paging_group_end">--%>
<%--                                <input type="button" value="마지막   >>">--%>
<%--                            </div>--%>
                        </div>
                    </div>
                </section>
            </section>
        </section>
    </section>
</main>
<footer>
    <jsp:include page="/WEB-INF/views/footer.jsp"/>
</footer>
</body>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        const secretCheckboxes = document.querySelectorAll('.secret');

        secretCheckboxes.forEach(function (secretCheckbox) {
            secretCheckbox.addEventListener('change', function () {
                const isChecked = this.checked;
                const sections = document.querySelectorAll('#main_contents');

                sections.forEach(function (section) {
                    const title = section.querySelector('#info_header_title');
                    const openYNValue = title.getAttribute('data-openyn');

                    if (isChecked && openYNValue === 'N') {
                        section.style.display = 'none';
                    } else {
                        section.style.display = 'block';
                    }
                });
            });
        });
    });




</script>



</html>




