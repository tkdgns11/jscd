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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/allqnaForm.css"/>">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<div id="background">
    <div class="board_title">
        <strong>Q&A</strong>
    </div>
    <form action="${path}/board/qna/allqnaModified?${modify.allqnaNo}" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="allqnaNo" value="${modify.allqnaNo}">
        <%--@declare id="content"--%>
        <label>제목</label>
        <input type="text" id="title" name="title" value="${modify.title}"/>
        <br><br>
        <label for="writer">작성자:</label>
        <input type="text" id="writer" name="writer" value="${modify.writer}"/>
        <br><br>
        <label for="content">내용:</label>
        <textarea id="contents" name="content" rows="4">${modify.content}</textarea>
        <br>
        <div id="fileDiv">
            <p>
                <input type="file" id="file" name="imgFile">
                <a href="#this" class="btn" id="delete" name="delete">삭제</a>
            </p>
        </div>
        <a href="#this" class="btn" id="addFile">파일 추가</a>
        <br><br>
        <hr>
        <button id="edited" type="submit">완료</button>
    </form>
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
