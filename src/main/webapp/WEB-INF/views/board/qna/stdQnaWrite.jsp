<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | 질문&답변 작성</title>
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/allqnaWrite.css"/>">
    <script type="text/javascript" src="<c:url value="/js/stdQnaWrite.js"/>"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/40.2.0/classic/ckeditor.js"></script>
</head>
<body>
<div id="qnaLetterwrap"><span id="qnaLetter">Q&A</span></div>

<form id="stdQnaForm" action="/board/qna/stdQnaWrite" method="post">
    <div id="detailHd">
        <c:set var="id" value="${id}" />
            <input type="hidden" id="id" value="${id}" >

        <input type="hidden" id="allqnaNo" name="allqnaNo" value="stdqnaNo">
        <%--            <label>카테고리</label>--%>
        <select name="ctName" id="allqnaCategory">
            <option value="분류" disabled selected>분류</option>
            <option value="JAVA" ${stdQnaDto.name eq 'JAVA' ? 'selected' : ''}>JAVA</option>
            <option value="SQL" ${stdQnaDto.name eq 'SQL' ? 'selected' : ''}>SQL</option>
            <option value="HTML, CSS" ${stdQnaDto.name eq 'HTML, CSS' ? 'selected' : ''}>HTML, CSS</option>
            <option value="Java Script" ${stdQnaDto.name eq 'Java Script' ? 'selected' : ''}>Java Script</option>
            <option value="JSP, Servlet" ${stdQnaDto.name eq 'JSP, Servlet' ? 'selected' : ''}>JSP, Servlet</option>
            <option value="Spring" ${stdQnaDto.name eq 'Spring' ? 'selected' : ''}>Spring</option>
            <option value="프로젝트" ${stdQnaDto.name eq '프로젝트' ? 'selected' : ''}>프로젝트</option>
            <option value="기타" ${stdQnaDto.name eq '기타' ? 'selected' : ''}>기타</option>
        </select>
        <br><br>

        <input type="text" id="title" name="title" placeholder="제목에 핵심 내용을 요약해보세요."
               value="${stdQnaDto.title}" >
        <span>작성일<input type="text" id="regDate" name="regDate"
                        value="<fmt:formatDate pattern='yyyy-MM-dd' value='${stdQnaDto.regDate}'/>">.</span>

        <%--        <span>수정 ･<input type="text" id="modifyDatZe" name="modifyDate" value="${allqnaList.modifyDate} " readonly></span>--%>
            <span>조회수 <input type="text" id="viewCnt" name="viewCnt" value="${stdQnaDto.hit}"></span><br>
        <span>작성자 <input type="text" name="writer" id="writer" value="${stdQnaDto.writer}"></span><br>

        <div id="wrapCon">
            <textarea id="content"
                      name="content" style=" padding:10px; width:672px; height:519px;">${stdQnaDto.content}</textarea>

        </div>

        <div id="wrapAtc">
            <%--                id = file -> upload 바꿈--%>
            <input type="file" id="upload" name="file" class="attachBtn">
        </div>
        <%--       id 바꿈 btnBox -> buttonBox--%>
        <div id="bottomBox">

            <div id="buttonBox">
                <input type="button" id="writeBtn" class="registeBtn" value="등록">
                <input type="button" id="modifyBtn" class="modifyBtn" value="수정">
                <input type="button" id="removeBtn" class="deleteBtn" value="삭제">
                <input type="button" id="listBtn" class="backBtn" value="목록">
            </div>


        </div>

</form>

<%--<section id="cmmtBox" style="${mode == 'new' ? 'display: none;' : ''}">--%>
<%--    <div id="cmmtLetter"><i class="fa-solid fa-comment"></i> 답변</div>--%>
<%--    <div id="cmmtContent">--%>
<%--        <textarea id="cmtContentRegi" name="cmtContent" style="resize: vertical; " placeholder="${allqnaList.writer}님,답변을 작성해보세요."></textarea><br/>--%>
<%--    </div>--%>
<%--    <div id="cmmtBtn">--%>
<%--        &lt;%&ndash; 취소버튼 만들었음 &ndash;%&gt;--%>
<%--        <input type="button" id="cmmtCancel" onclick="cmtCancel()" value="취소">--%>
<%--        <input type="button" id="cmmtRegist" onclick="cmtWrite()" value="등록">--%>
<%--    </div>--%>
<%--    <section id="cmmtCommunity" >--%>
<%--        <div id="main_content_info" ${commentCount == 0 ? 'display: none;' : ''}>--%>
<%--            <div id="info_top" >--%>
<%--                <div id="cmmtUserinfo">--%>

<%--                </div>--%>
<%--            </div>--%>
<%--            <div id="bottomContent" >--%>
<%--                <p class="pastContent">${commentList.content} </p>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </section>--%>
<%--</section>--%>

<%--<br/>--%>
<%--<div>--%>
<%--    <div style="border-radius: 10px; padding:20px;">--%>
<%--        <c:forEach var="commentList" items="${comment}" varStatus="loop">--%>
<%--            <div>--%>
<%--                    &lt;%&ndash;                    원댓글 &ndash;%&gt;--%>
<%--                <input type="hidden" id="allqnaCmtNo${loop.index}" name="allqnaCmtNo"--%>
<%--                       value="${commentList.allqnaCmtNo}">--%>
<%--                <input type="hidden" id="allqnaCmtReplyNo${loop.index}" name="allqnaCmtReplyNo"--%>
<%--                       value="${commentList.allqnaCmtReplyNo}">--%>

<%--                        <span id="userInfoId">${commentList.cmtWriter}</span>--%>
<%--&lt;%&ndash;                        <span id="userInfoWriter1">${allqnaList.writer == id ? '작성자' : 'hidden'}></span>&ndash;%&gt;--%>
<%--                        <span id="userInfoWriter2">${allqnaList.writer == commentList.cmtWriter ? '작성자' : '지식공유자'}</span>--%>
<%--                        <span id="userInfoRegDate">작성일</span><span id="userInfoDate">･ <fmt:formatDate pattern="yyyy-MM-dd" value="${commentList.regDate}" /></span>--%>

<%--                <br/><textarea class="cmtContent" id="cmtContent${loop.index}" name="cmtContent" rows="4" readonly--%>
<%--                                    style="height:70px">${commentList.cmtContent}</textarea><br/>--%>
<%--                       <div id="cmtWriteContainer">--%>
<%--                           <hr>--%>

<%--                <input type="button" class="cmtEditBtn" id="cmtEditBtn${loop.index}" onclick="cmtEdit(${loop.index})" value="수정">--%>
<%--                <input type="button" class="cmtDelete" onclick="cmtDelete(${loop.index})" value="삭제">--%>
<%--                <input type="button" class="replyBoxWrite"  id="replyBoxWrite${loop.index}" onclick="replyBlock(${loop.index})"--%>
<%--                       value="답변">--%>
<%--                       </div>--%>

<%--                    &lt;%&ndash;대댓글&ndash;%&gt;--%>
<%--                <div class="replyContainer" id="replyContainer${loop.index}" style="display: none;">--%>
<%--                        &lt;%&ndash;    대댓글 목록 담는 박스 &ndash;%&gt;--%>
<%--                    <div id="replyListBox${commentList.allqnaCmtNo}" style="margin-left: 70px">--%>
<%--                    </div>--%>
<%--                    <br>--%>
<%--                        &lt;%&ndash;    대댓글 작성 폼 &ndash;%&gt;--%>
<%--                    <div id="replyBox${loop.index}" >--%>
<%--                        <input type="hidden" id="allqnaCmtReplyNo${loop.index}" name="allqnaCmtReplyNO"--%>
<%--                               value="${commentList.allqnaCmtReplyNo}">--%>
<%--&lt;%&ndash;                        답변 작성자 :<br> <input type="text" id="cmtReplyWriter${loop.index}" name="cmtWriter"><br/>&ndash;%&gt;--%>
<%--                       <br/><textarea id="cmtReplyContent${loop.index}" name="cmtContent" rows="4" style="width:600px; border-radius: 10px; border:1px solid #888888"></textarea><br/>--%>
<%--                        <input type="button" onclick="replyCmtWrite(${loop.index})" value="답변등록">--%>
<%--                        <input type="button" onclick="replyCmtCancel(${loop.index})" value="답변닫기">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <br><br><br>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>

<%--    </div>--%>
<%--</div>--%>
</body>
</html>
