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
</head>
<body>
<div id="background">
    <div class="board_title">
        <strong>Q&A</strong>
    </div>
    <form action="${path}/board/qna/allqnaModified?${modify.allqnaNo}" method="POST">
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
        <button id="edited" type="submit">완료</button>
    </form>
</div>
</body>
</html>
