<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QnA</title>

    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/allqnaForm.css"/>">
</head>
<body>
<div id="background">
    <div class="board_title">
        <strong>Q&A</strong>
        <p class="qna">질의응답;</p>
    </div>

    <p id="QnA">Q&A</p>
    <hr>

    <form action="${path}/board/qna/allqnaWrite" method="post" enctype="multipart/form-data">
        <label>카테고리</label>
        <select name="languages" id="lang">
            <option value="" disabled selected>카테고리</option>
            <option value="bootCamp">부트캠프</option>
            <option value="seminar">세미나</option>
            <option value="payment">결제 및 환불</option>
            <option value="site">사이트 이용</option>
            <option value="academy">학원관련</option>
            <option value="else">기타</option>
        </select>
        <br><br>
        <input type="hidden" id="postId" name="postId" value="${post.id}">
        <label for="title">제목:</label>
        <input type="text" id="title" name="title">
        <br><br>
        <label for="writer">작성자:</label>
        <input type="text" id="writer" name="writer">
        <br><br>
        <label for="content">내용:</label>
        <textarea id="content" name="content" rows="4"></textarea>
        <br><br>

        <div id="fileDiv">
            <p>
                <input type="file" id="file" name="imgFile">
                <a href="#this" class="btn" id="delete" name="delete">삭제</a>
            </p>
        </div>
        <a href="#this" class="btn" id="addFile">파일 추가</a>
        <br><br>
        <hr>
        <button id="submit" type="submit">등록하기</button>
        <div id="cancel">
            <a href="${path}/board/qna/allqnaList">돌아가기</a>
        </div>
    </form>

    <%--        <button id="cancel"  onclick="goBack()" >돌아가기</button>--%>

    <%--        <script>--%>
    <%--                function goBack() {--%>
    <%--                window.history.back(); // 브라우저의 이전 페이지로 이동--%>
    <%--            }--%>
    <%--        </script>--%>


</div>
<script>
    $(document).ready(function () {
        $('#addFile').on("click", function (e) {
            e.preventDefault();
            fn_addFile();
        })

        $("a[name='delete']").on('click', function (e) {
            e.preventDefault();
            fn_deleteFile($(this))
        })

        function fn_addFile() {
            var str = "<p><input type='file' name='imgFile'><a href='#this' name='delete'>삭제</a></p>";
            $("#fileDiv").append(str);

            $("a[name='delete']").on('click', function (e) {
                e.preventDefault();
                fn_deleteFile($(this))
            })

        }

        function fn_deleteFile(obj) {
            obj.parent().remove();
        }


    })
</script>
</body>
</html>

