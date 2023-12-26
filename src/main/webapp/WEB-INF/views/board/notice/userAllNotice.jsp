<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | 전체 공지사항</title>
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
    <span id="notice">공지사항</span>
</div>



<form action="" id="form" value="">
    <div id="detailHd">
        <input type="hidden" name="bno" value="${noticeDto.bno}"><br>
        <input id="title" placeholder="제목에 핵심 내용을 요약해보세요." name="title" value="${noticeDto.title}" ${mode=="new" ? '' : 'readonly="readonly"' }><br>
        <span>작성 <input type="text" id="regDate" name="regDate" value="${noticeDto.modifyDate} " readonly> ･</span>
        <span>조회수 <input type="text" id="viewCnt" name="viewCnt" value=" ${noticeDto.viewCnt}" readonly></span><br>
        <span>작성자 <input type="text" name="writer" id="writer" value=" ${noticeDto.writer}" readonly></span><br>
        <div id="wrapCon">
            <textarea name="content" id="content" ${mode=="new" ? '' : 'readonly="readonly"'}>${noticeDto.content}</textarea>
            <script>
                var editorContent = editorContent.getData()
                var convertContent = editorContent.replace(/(<([^>]+)>)/gi, '');
            </script>

        </div>
    </div>

    <div id="buttonBox">
        <input type="button" id="listBtn" class="backBtn" value="목록">

    </div>
</form>


<script>
    $(document).ready(function () { // the same as main() -- document는 html문서이고 그 문서가 실행되면 준비해라 펑션을
        $('#listBtn').on('click', function () {
            location.href = '<c:url value="/board/user/list?page=' + ${page} + '&pageSize=' + ${pageSize} + '"/>';
        });
    });
</script>
</div>
<footer>
    <jsp:include page="/WEB-INF/views/footer.jsp"/>
</footer>

</body>
</html>