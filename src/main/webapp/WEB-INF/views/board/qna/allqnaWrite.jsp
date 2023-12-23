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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/allqnaWrite.css"/>">
    <script type="text/javascript" src="<c:url value="/js/allqnaWrite.js"/>"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/40.2.0/classic/ckeditor.js"></script>
</head>
<body>
<%--<div id="background">--%>

<div id="qnaLetterwrap"><span id="qnaLetter">Q&A</span></div>


<form id="form">
    <div id="detailHd">
        <input type="hidden" id="allqnaNo" name="allqnaNo" value="${allqnaList.allqnaNo}">
        <%--            <label>카테고리</label>--%>
        <select name="ctName" id="allqnaCategory">
            <option value="분류" disabled selected>분류</option>
            <option value="부트캠프">부트캠프</option>
            <option value="세미나">세미나</option>
            <option value="결제 및 환불">결제 및 환불</option>
            <option value="사이트 이용">사이트 이용</option>
            <option value="학원관련">학원관련</option>
            <option value="기타">기타</option>
        </select>
        <br><br>

        <input type="text" id="title" name="title" placeholder="제목에 핵심 내용을 요약해보세요." value="${allqnaList.title}">
        <span>작성 <input type="text" id="regDate" name="regDate" value="${allqnaList.regDate} " readonly> ･</span>
        <%--        <span>수정 ･<input type="text" id="modifyDatZe" name="modifyDate" value="${allqnaList.modifyDate} " readonly></span>--%>
        <span>조회수 <input type="text" id="viewCnt" name="viewCnt" value=" ${allqnaList.hit}" readonly></span><br>
        <span>작성자 <input type="text" name="writer" id="writer" value=" ${allqnaList.writer}" readonly></span><br>

        <div id="wrapCon">
            <textarea id="content" name="content">${allqnaList.content}</textarea>
<%--            위지윅 적용--%>
                            <script>
                                document.addEventListener("DOMContentLoaded", function() {
                                    ClassicEditor
                                        .create(document.querySelector('#content'))
                                        .then(newEditor => {
                                            editor = newEditor;
                                        })
                                        .catch(error => {
                                            console.error(error);
                                        });
                                });

                            </script>
        </div>

        <div id="wrapAtc">
            <%--                id = file -> upload 바꿈--%>
            <input type="file" id="upload" name="file" class="attachBtn">
        </div>
    </div>
    <%--       id 바꿈 btnBox -> buttonBox--%>
    <div id="buttonBox">
        <input type="button" id="writeBtn" class="registeBtn" onclick="allqnaWrite();" value="등록">
        <input type="button" id="removeBtn" class="deleteBtn" onclick="allqnaDelete()" value="삭제">
        <input type="button" id="listBtn" class="backBtn" onclick="" value="목록">
    </div>

    <div class="openYN">
        <input type="radio" name="openYN" id="open" value="Y" class="radio"
               <c:if test="${allqnaList.openYN == 'Y'}">checked</c:if>/><span class="ml_10">공개</span>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" name="openYN" id="close" value="N" class="radio"
               <c:if test="${allqnaList.openYN == 'N'}">checked</c:if>/><span class="ml_10">비공개</span>&nbsp;
    </div>

</form>

<section id="cmmtBox" style=" ">
    <div id="cmmtHd" background-color: grey>
        <p id="hdLetter">답변
            <span id="cmmtTcnt">totalcount of comments</span>
        </p>
    </div>
    <br>
    <div id="cmmtContent">
        <input type="text" id="cmtWriterRegi" name="cmtWriter" value=""> 님,<br/><br/>
        <textarea id="cmtContentRegi" name="cmtContent" rows="1"></textarea><br/>
    </div>
    <div id="cmmtBtn">
        <%--            취소버튼 만들었음--%>
        <input type="button" id="cmmtCancel" onclick="cmtCancel()" value="취소">
        <input type="button" id="cmmtRegist" onclick="cmtWrite()" value="등록">
    </div>
</section>
<br/>
<div>
    <div>
        <c:forEach var="commentList" items="${comment}" varStatus="loop">
            <div>
                    <%--                    원댓글 --%>
                <input type="hidden" id="allqnaCmtNo${loop.index}" name="allqnaCmtNo"
                       value="${commentList.allqnaCmtNo}">
                <input type="hidden" id="allqnaCmtReplyNo${loop.index}" name="allqnaCmtReplyNo"
                       value="${commentList.allqnaCmtReplyNo}">

                작성자 : <br/> <input type="text" id="cmtWriter${loop.index}" name="cmtWriter"
                                   value="${commentList.cmtWriter}" readonly><br/>
                내용 : <br/><textarea id="cmtContent${loop.index}" name="cmtContent" rows="4" readonly
                                    style="height:70px">${commentList.cmtContent}</textarea><br/>
                <input type="button" id="cmtEditBtn${loop.index}" onclick="cmtEdit(${loop.index})" value="수정">
                <input type="button" onclick="cmtDelete(${loop.index})" value="삭제"><br/>
                <input type="button" id="replyBoxWrite${loop.index}" onclick="replyBlock(${loop.index})"
                       value="답변">

                    <%--대댓글--%>
                <div id="replyContainer${loop.index}" style="display: none;">
                        <%--    대댓글 목록 담는 박스 --%>
                    <div id="replyListBox${commentList.allqnaCmtNo}" style="margin-left: 70px">
                    </div>
                    <br>
                        <%--    대댓글 작성 폼 --%>
                    <div id="replyBox${loop.index}" style="margin-left: 50px">
                        <input type="hidden" id="allqnaCmtReplyNo${loop.index}" name="allqnaCmtReplyNO"
                               value="${commentList.allqnaCmtReplyNo}">
                        답변 작성자 :<br> <input type="text" id="cmtReplyWriter${loop.index}" name="cmtWriter"><br/>
                        답변 내용 :<br/><textarea id="cmtReplyContent${loop.index}" name="cmtContent" rows="4"></textarea><br/>
                        <input type="button" onclick="replyCmtWrite(${loop.index})" value="답변등록">
                        <input type="button" onclick="replyCmtCancel(${loop.index})" value="답변닫기">
                    </div>
                </div>
                <br><br><br>
            </div>
        </c:forEach>

    </div>
</div>


</body>
</html>
