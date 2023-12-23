<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
        <select name="ctName" id="allqnaCategory" ${mode=="new" ? '' : 'disabled="disabled"' }>
            <option value="분류" disabled selected>분류</option>
            <option value="부트캠프" ${allqnaList.ctName eq '부트캠프' ? 'selected' : ''}>부트캠프</option>
            <option value="세미나" ${allqnaList.ctName eq '세미나' ? 'selected' : ''}>세미나</option>
            <option value="결제 및 환불" ${allqnaList.ctName eq '결제 및 환불' ? 'selected' : ''}>결제 및 환불</option>
            <option value="사이트 이용"  ${allqnaList.ctName eq '사이트 이용' ? 'selected' : ''}>사이트 이용</option>
            <option value="학원관련" ${allqnaList.ctName eq '학원관련' ? 'selected' : ''}>학원관련</option>
            <option value="기타" ${allqnaList.ctName eq '기타' ? 'selected' : ''}>기타</option>
        </select>
        <br><br>

        <input type="text" id="title" name="title" placeholder="제목에 핵심 내용을 요약해보세요."
               value="${allqnaList.title}"  ${mode eq 'new' ? '' : 'readonly=readonly'}>
        <span>작성일<input type="text" id="regDate" name="regDate"
                        value="<fmt:formatDate pattern='yyyy-MM-dd HH:mm' value='${allqnaList.regDate}' />" readonly>.</span>

        <%--        <span>수정 ･<input type="text" id="modifyDatZe" name="modifyDate" value="${allqnaList.modifyDate} " readonly></span>--%>
        <span>조회수 <input type="text" id="viewCnt" name="viewCnt" value=" ${allqnaList.hit}" readonly></span><br>
        <span>작성자 <input type="text" name="writer" id="writer" value=" ${allqnaList.writer}" readonly></span><br>

        <div id="wrapCon">
            <textarea id="content"
                      name="content" style=" padding:10px;"
                      ;  ${mode eq 'new' ? '' : 'readonly=readonly'}>${allqnaList.content}</textarea>

            <%--            위지윅 적용--%>
            <script>
                document.addEventListener("DOMContentLoaded", function () {
                    const contentTextarea = document.querySelector('#content');

                    // textarea가 읽기 전용이 아닐 때만 에디터 생성
                    if (!contentTextarea.hasAttribute('readonly')) {
                        ClassicEditor
                            .create(contentTextarea)
                            .then(newEditor => {
                                editor = newEditor;
                            })
                            .catch(error => {
                                console.error(error);
                            });
                    }
                });
            </script>
        </div>

        <div id="wrapAtc">
            <%--                id = file -> upload 바꿈--%>
            <input type="file" id="upload" name="file" class="attachBtn" ${mode eq 'new' ? '' : 'hidden'}>
        </div>
        <%--       id 바꿈 btnBox -> buttonBox--%>
        <div id="bottomBox">

            <div class="openYN">
                <input type="radio" name="openYN" id="open" value="Y"
                       class="radio" ${mode == "new" ? '' : 'disabled'} ${allqnaList.openYN == 'Y' ? 'checked' : ''}/>
                <label for="open" class="ml_10">공개</label>&nbsp;&nbsp;&nbsp;&nbsp;

                <input type="radio" name="openYN" id="close" value="N"
                       class="radio" ${mode == "new" ? '' : 'disabled'} ${allqnaList.openYN == 'N' ? 'checked' : ''}/>
                <label for="close" class="ml_10">비공개</label>&nbsp;
            </div>
            <div id="buttonBox">
                <input type="button" id="writeBtn" class="registeBtn"
                       onclick="allqnaWrite();" ${mode eq 'new' ? '' : 'hidden'} value="등록">
                <input type="button" id="modifyBtn" class="modifyBtn"
                       onclick="allqnaEdit();" ${mode eq 'new' ? 'hidden' : ''} value="수정">
                <input type="button" id="removeBtn" class="deleteBtn"
                       onclick="allqnaDelete()" ${mode eq 'new' ? 'hidden' : ''} value="삭제">
                <input type="button" id="listBtn" class="backBtn" onclick="" value="목록">
            </div>


        </div>

</form>

<section id="cmmtBox" style="${mode == 'new' ? 'display: none;' : ''}">
    <div id="cmmtHd">
        <p id="hdLetter">답변
            <span id="cmmtTcnt">total count of comments</span>
        </p>
    </div>
    <br>
    <div id="cmmtContent">
        <input type="text" id="cmtWriterRegi" name="cmtWriter" value=""> 님,<br/><br/>
        <textarea id="cmtContentRegi" name="cmtContent" rows="1" style="resize: none; height: 50px;"
                  placeholder="답변을 입력하세요."></textarea><br/>
    </div>
    <div id="cmmtBtn">
        <%-- 취소버튼 만들었음 --%>
        <input type="button" id="cmmtCancel" onclick="cmtCancel()" value="취소">
        <input type="button" id="cmmtRegist" onclick="cmtWrite()" value="등록">
    </div>
</section>

<br/>
<div>
    <div style="background-color: #f1f1f1; border-radius: 10px;">
        <c:forEach var="commentList" items="${comment}" varStatus="loop">
            <div>
                    <%--                    원댓글 --%>
                <input type="hidden" id="allqnaCmtNo${loop.index}" name="allqnaCmtNo"
                       value="${commentList.allqnaCmtNo}">
                <input type="hidden" id="allqnaCmtReplyNo${loop.index}" name="allqnaCmtReplyNo"
                       value="${commentList.allqnaCmtReplyNo}">
                <br>
                &emsp; ${commentList.cmtWriter} 님,
                <br/><textarea id="cmtContent${loop.index}" name="cmtContent" rows="4" readonly
                               style="resize: none; width:600px; height: 70px; border-radius: 10px; border: 1px solid #d7d7d7; padding:10px;margin: 10px; ">${commentList.cmtContent}</textarea><br/>
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
                        <input type="hidden" id="regDate${loop.index}" name="regDate"
                               value="${commentList.regDate}">
                        <br> <input type="text" id="cmtReplyWriter${loop.index}" name="cmtWriter"><br/>
                        <br/><textarea id="cmtReplyContent${loop.index}" name="cmtContent"
                                       rows="4"></textarea><br/>
                        <input type="button" onclick="replyCmtWrite(${loop.index})" value="답변등록">
                        <input type="button" onclick="replyCmtCancel(${loop.index})" value="답변닫기">
                    </div>
                </div>
                <br><br><br>
            </div>
        </c:forEach>

    </div>
</div>


<script>

</script>

</body>
</html>
