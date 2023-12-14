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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">

</head>
<body>
    <header>
        <jsp:include page="../../header.jsp"/>
    </header>
    <main>
        <div id="qnaTitle">

        </div>
        <div>
            <nav>
                <ul>
                    <li><a href="#">공지사항</a></li>
                    <li><a href="#">질문&답변</a></li>
                    <li><a href="#">FAQ</a></li>
                </ul>
            </nav>
            <%--왼쪽 컨텐츠--%>
            <div>
                <input type="text" name="keyword" class="serachInput" value="${ph.sc.keyword}" placeholder="검색어를 입력하세요">
                <button type="submit" class="searchButtom" value="검색">검색</button>
            </div>
        </div>
    </main>
    <footer>
        <jsp:include page="../../footer.jsp"/>
    </footer>
</body>
</html>




