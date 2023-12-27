<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | 학사 공지사항</title>
<%--    <link rel="stylesheet" href="<c:url value='/css/noticeList.css'/>">--%>
    <link rel="stylesheet" href="<c:url value='/css/userNoticeReading.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/jscdReset.css'/>">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/header.jsp"/>
</header>
<div id="body">
<div id="topLetter">
    <span id="notice">학생 공지사항</span>
</div>



<form action="" id="form" value="">
    <div id="detailHd">
        <input type="hidden" name="bno" value="${stdNoticeDto.bno}"><br>
        <input id="title" placeholder="제목에 핵심 내용을 요약해보세요." name="title" value="${stdNoticeDto.title}" ${mode=="new" ? '' : 'readonly="readonly"' }><br>
        <span>작성 <input type="text" id="regDate" name="regDate" value="${stdNoticeDto.regDate} " readonly> ･</span>
        <span>수정 <input type="text" id="modifyDate" name="modifyDate" value="${stdNoticeDto.modifyDate} " readonly>･</span>
        <span>조회수 <input type="text" id="viewCnt" name="viewCnt" value=" ${stdNoticeDto.viewCnt}" readonly></span><br>
        <span>작성자 <input type="text" name="writer" id="writer" value=" ${stdNoticeDto.writer}" readonly></span><br>
        <div id="wrapCon">
            <textarea name="content" id="content" ${mode=="new" ? '' : 'readonly="readonly"'}>${stdNoticeDto.content}</textarea>
        </div>
    </div>

    <div id="buttonBox">
        <input type="button" id="listBtn" class="backBtn" value="목록">

    </div>
</form>


<script>
    $(document).ready(function () { // the same as main() -- document는 html문서이고 그 문서가 실행되면 준비해라 펑션을
        $('#listBtn').on('click', function () {
            location.href = '<c:url value="/board/userStd/list?page=' + ${page} + '&pageSize=' + ${pageSize} + '"/>';
        });
    });
</script>
</div>
<footer>
    <jsp:include page="/WEB-INF/views/footer.jsp"/>
</footer>
</body>
</html>