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
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/allqnaForm.css"/>">
    <script type="text/javascript" src="<c:url value="/js/allqnaWrite.js"/>"></script>
</head>
<body>
<div id="background">
    <div class="board_title">
        <strong>Q&A</strong>
        <p class="qna">질의응답;</p>
    </div>

    <p id="QnA">Q&A</p>
    <hr>

    <form>
        <label>카테고리</label>
        <select name="languages" id="lang">
            <option value="0" disabled selected>카테고리</option>
            <option value="1">부트캠프</option>
            <option value="2">세미나</option>
            <option value="3">결제 및 환불</option>
            <option value="4">사이트 이용</option>
            <option value="5">학원관련</option>
            <option value="6">기타</option>
        </select>
        <br><br>
        <input type="hidden" id="allqnaNo" name="allqnaNo" value="${allqnaList.allqnaNo}">
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" value="${allqnaList.title}">
        <br><br>
        <label for="writer">작성자:</label>
        <input type="text" id="writer" name="writer" value="${allqnaList.writer}">
        <br><br>
        <label for="content">내용:</label>
        <textarea id="content" name="content" rows="4" >${allqnaList.content}</textarea>
        <br><br>
        <label for="file">파일 첨부:</label>
        <input type="file" id="file" name="file">
        <br><br>
        <div class="openYN">
            <input type="radio" name="openYN" id="open" value="Y" class="radio" <c:if test="${allqnaList.openYN == 'Y'}">checked</c:if>/><span class="ml_10">공개</span>&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="openYN" id="close" value="N" class="radio" <c:if test="${allqnaList.openYN == 'N'}">checked</c:if>/><span class="ml_10">비공개</span>&nbsp;
        </div>
        <hr>
        <div id="btnBox">
            <input type="button" onclick="allqnaWrite();" value="등록하기"/>
            <input type="button" onclick="" value="돌아가기">
            <input type="button" onclick="allqnaDelete()" value="삭제하기">
        </div>
    </form>
    <div style="background-color: grey">
        작성자 : <input type="text" id="cmtWriterRegi" name="cmtWriter" ><br/>
        내용 : <br/><textarea id="cmtContentRegi" name="cmtContent" rows="4" ></textarea><br/>
        <input type="button" onclick="cmtWrite()" value="등록하기">
    </div>
    <br/>
    <div>
        <div>
            <c:forEach var="commentList" items="${comment}" varStatus="loop">
                <div>
                    <input type="hidden" id="allqnaCmtNo${loop.index}" name="allqnaCmtNo" value="${commentList.allqnaCmtNo}">
                        작성자 : <br/> <input type="text" id="cmtWriter${loop.index}" name="cmtWriter" value="${commentList.cmtWriter}" readonly><br/>
                        내용 : <br/><textarea id="cmtContent${loop.index}" name="cmtContent" rows="4" readonly style="heigh=70px">${commentList.cmtContent}</textarea><br/>
                        <input type="button" id="cmtEditBtn${loop.index}" onclick="cmtEdit(${loop.index})" value="수정하기">
                        <input type="button" onclick="cmtDelete(${loop.index})" value="삭제하기"><br/>
                        <input type="button" id="replyBoxWrite${loop.index}" onclick="replyBlock(${loop.index})" value="대댓글 등록">

                    <div id="replyBox" style="display: none; background-color: #666666">
                        댓글 작성자 : <input type="text" id="cmtReplyWriter${loop.index}" name="cmtWriter" ><br/>
                        댓글 내용 : <br/><textarea id="cmtReplyContent${loop.index}" name="cmtContent" rows="4" style="height: 50px"></textarea><br/>
                        <input type="button" onclick="replyCmtWrite(${loop.index})" value="등록하기">
                        <div id="replyListBox">
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>


    </div>

</div>
</body>
</html>
