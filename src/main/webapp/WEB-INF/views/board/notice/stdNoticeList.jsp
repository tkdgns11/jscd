<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var = "path" value = "${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 첫 페이지</title>
    <link rel="stylesheet" href="<c:url value='/css/noticeList.css'/>">
</head>
<body>


<div id="headerNotice">
    <div id="ltone">/* Student Notice */</div>
    <div id="lttwo">학생 공지사항;</div>
</div>


<div class="subtop">
    <div id="search">
        <form action="<c:url value="/board/stdNotice/list"/>" class="search-form" method="get">
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

<%--        <script>--%>
<%--            let msg = "${msg}" //get 방식이라 모델에 있는 값이 param으로 전달 - 메세지가 안먹음 왠지 모르겠음 --%>
<%--            if (msg=="wrt_ok") alert("등록 성공");--%>
<%--            if (msg=="del_fin") alert("삭제 완료");--%>
<%--            if (msg=="del_err") alert("삭제 실패");--%>
<%--        </script> --%>

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
                <td><a href="<c:url value="/board/stdNotice/read?bno=${stdNoticeDto.bno}&page=${ph.sc.page}&pageSize=${ph.sc.pageSize}"/>">${stdNoticeDto.title}</a></td>
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
                <a class="page" href="<c:url value="/board/stdNotice/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>
            </c:if>
            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/board/stdNotice/list${ph.sc.getQueryString(i)}"/>">${i}</a>
            </c:forEach>
            <c:if test="${ph.showNext}">
                <a class="page" href="<c:url value="/board/stdNotice/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
            </c:if>
        </c:if>
    </div>

    <div>
        <button type = "button" id="writeBtn" onclick="location.href='<c:url value ="/board/stdNotice/write"/>'">글쓰기</button>
    </div>

    <%--    //onclick에 function 매칭해줘야 하나, 짧아서 모두 생략후 한줄만 적어줌--%>
</div>


</body>
</html>