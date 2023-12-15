<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


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


<div id="content">
    <div class="board_wrap">
        <div class="board_title">
        </div>

        <div id="top_container">
            <form id="searchBox" action="<c:url value="/board/qna/allqnaList"/>" method="get" name="searchForm">
                <select class="searchOption" name="option">
                    <option value="TC" ${ph.sc.option=='TC' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                    <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목</option>
                    <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
                    <%--                    <option value="I">아이디</option>--%>
                </select>
                <input type="text" name="keyword" class="searchInput" value="${ph.sc.keyword}" placeholder="원하는 키워드를 입력하세요">
                <button type="submit" class="backBtn" value="검색">검색</button>
                <%--                <input type="hidden" name="page" value="1">--%>
                <input type="hidden" name="pageSize" value="10">
            </form>
            <br><br><br>

        </div>
        <br><br><br>
        <div id="checkSumit">
        <div id="checkbox">
            <input type="checkbox" class="secret" name="secret" value="secret"> <span>비밀글 제외</span>&emsp;&emsp;&emsp;
            <input type="checkbox" name="myWriting" value=""> <span>내가 작성한 글 보기</span>
        </div>

            <button value="등록" class="registeBtn"><a href="<c:url value="/board/qna/allqnaWrite"/>">등록</a></button>
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
                        <div class="title2" id="title" data-openyn="${list.openYN}">
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
                        <div class="writer">${list.writer}</div>
                        <div class="regDate">${list.regDate}</div>
                        <div class="hit">${list.hit}</div>
                    </div>

                </c:forEach>
            </div>
        </div>


        <br>
        <div class="paging-container">
            <div class="paging">
                <c:if test="${totalCnt==null || totalCnt==0}">
                    <div id="empty"> 게시물이 없습니다.</div>
                </c:if>
                <c:if test="${totalCnt!=null && totalCnt!=0}">
                    <c:if test="${ph.showPrev}">
                        <a id="pageNbr" class="bt page"
                           href="<c:url value="/board/qna/allqnaList${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>
                    </c:if>
                    <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                        <a id="pageNbr" class="page ${i==ph.sc.page? "paging-active" : ""}"
                           href="<c:url value="/board/qna/allqnaList${ph.sc.getQueryString(i)}"/>">${i}</a>
                    </c:forEach>
                    <c:if test="${ph.showNext}">
                        <a id="pageNbr" class="bt page"
                           href="<c:url value="/board/qna/allqnaList${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
                    </c:if>
                </c:if>
            </div>



        </div>
    </div>
</div>
</div>


<footer>
    <jsp:include page="/WEB-INF/views/footer.jsp"/>
</footer>

<script>

    document.addEventListener('DOMContentLoaded', function () {
        const secretCheckboxes = document.querySelectorAll('.secret');

        secretCheckboxes.forEach(function (secretCheckbox) {
            secretCheckbox.addEventListener('change', function () {
                const isChecked = this.checked;
                const lists = document.querySelectorAll('.lists');

                lists.forEach(function (list) {
                    const title = list.querySelector('.title2');
                    const openYNValue = title.getAttribute('data-openyn');

                    if (isChecked && openYNValue === 'N') {
                        list.style.display = 'none';
                    } else {
                        list.style.display = 'block';
                    }
                });
            });
        });
    });

</script>


</body>
</html>




