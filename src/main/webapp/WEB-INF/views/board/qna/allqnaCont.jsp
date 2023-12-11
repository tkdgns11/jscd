<%@ page import="com.jscd.app.board.qna.qnaDto.AllqnacDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>게시판-${read.title}</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/allqnaView.css"/>">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>


<div id="content">
    <div class="board_title">
        <strong>Q&A</strong>
    </div>

    <div id="viewContainer">
        <div id="title">
            ${read.title}
        </div>
        <div id="info">
            <dl>
                <dt>글번호</dt>
                <dd>${read.allqnaNo}</dd>
            </dl>
            <dl>
                <dt>작성자</dt>
                <dd>${read.writer}</dd>
            </dl>
            <dl>
                <dt>작성일</dt>
                <dd>${read.regDate}</dd>
            </dl>
            <dl>
                <dt>조회수</dt>
                <dd>${read.hit}</dd>
            </dl>
        </div>

        <div id="allqnaImg">
            <img src='/board/qna/showImg?allqnaNo=${read.allqnaNo}' width="400px">
        </div>


        <div id="cont">
            ${read.content}
        </div>

    </div>

    <div id="buttonContainer">
        <button id="list" onclick="location.href='${path}/board/qna/allqnaList'">목록</button>
        <%--    <c:forEach var="modify"  items="${modify}"> </c:forEach>  ///  modifiy?--%>
        <button id="edit" onclick="location.href='${path}/board/qna/allqnaModify?allqnaNo=${read.allqnaNo}'">수정하기
        </button>
        <button id="delete" onclick="deleteConfirmation()">삭제하기</button>
    </div>

    <script>
        function deleteConfirmation(allqnaNo) {
            if (confirm("${read.allqnaNo}번 글을 정말 삭제하시겠습니까?")) {
                location.href = "${path}/board/qna/allqnaDelete?allqnaNo=${read.allqnaNo}";
            }
        }
    </script>


    <form method="POST" id="commentForm" action="${path}/board/qna/cmmtWrite" target="_self">

        <input type="hidden" class="allqnaNo" name="allqnaNo" value="${read.allqnaNo}">
        <br><br>
        <label>댓글 작성자</label>
        <input id="cmtWriter" type="text" name="writer">
        <br> <br> <br>
        <textarea rows="5" cols="50" name="content"></textarea>

        <button id="cmtWrite" type="submit">댓글작성</button>

    </form>

    <br><br><br>


    <div id="cmtContainer">
        <c:forEach items="${comment}" var="comment">

            <div class="comment">
                <dl>
                    <dt>댓글번호</dt>
                    <dd class="cn" name="allqnaCNo">${comment.allqnaCNo}</dd>
                </dl>
                <dl>
                    <dt>작성자</dt>
                    <dd name="writer">${comment.writer}</dd>
                </dl>
                <dl>
                    <dt>등록일자</dt>
                    <dd name="regDate">${comment.regDate}</dd>
                </dl>
                <br><br><br>

                <div id="cmt" name="content">
                        ${comment.content}
                </div>
                <div id="cmtBtn">
                        <%--                     <button id="cmtEdit">수정</button>--%>
                        <%--                    <button id="cmtDelete" onclick="">삭제</button>--%>

                    <button type="button" id="cmtEdit" class="cmtEdit" data-allqnaCNo="${comment.allqnaCNo}">수정</button>
                    <button type="button" class="cmtDelete" data-allqnaCNo="${comment.allqnaCNo}">삭제
                    </button>
                </div>
            </div>


            <div id="cmmtEditBox">
                <form method="POST" class="cmmtEditForm" target="_self"
                      style="display:none">

                    <input id="allqnaCNo" type="hidden" value="${comment.allqnaCNo}" name="allqnaCNo">
                    <label>댓글 작성자</label>
                    <input id="cmtEditWriter" type="text" value="${comment.writer}" name="writer">
                    <br> <br> <br>
                    <textarea rows="5" cols="50" name="content">${comment.content}</textarea>
                    <div id="cmtEditBtn">
                        <button class="cmtEdited" type="button">등록</button>
                        <button class="cmtCancel"
                                onclick="location.href='${path}/board/qna/allqnaDetail?allqnaNo=${comment.allqnaNo}'">
                            취소
                        </button>
                    </div>

                </form>
            </div>
        </c:forEach>


        <div id="bottom"></div>
    </div>
    </div>


    <script>
    //댓글 수정버튼, 수정폼 가져오기
        window.addEventListener('DOMContentLoaded', () => {
            const editBtns = document.querySelectorAll('.cmtEdit');
            const editForms = document.querySelectorAll('.cmmtEditForm');
    //각 수정버튼마다 이벤트 등록
            editBtns.forEach((btn, index) => {
                btn.addEventListener('click', () => {
                    toggleCommentEditForm(index, true);
                });

                const registerBtn = editForms[index].querySelector('.cmtEdited');
                registerBtn.addEventListener('click', () => {
                    handleCommentEdit(index);
                });
            });

            function toggleCommentEditForm(index, show) {
                editForms[index].style.display = show ? 'block' : 'none';
                const commentContent = document.querySelectorAll('.comment')[index];
                commentContent.style.display = show ? 'none' : 'block';
            }

            function handleCommentEdit(index) {
                const content = editForms[index].querySelector('textarea').value;
                const writer = editForms[index].querySelector('#cmtEditWriter').value;
                const allqnaCNo = editForms[index].querySelector('#allqnaCNo').value;

                const allqnacDto = {
                    content: content,
                    allqnaCNo: allqnaCNo,
                    writer: writer
                };

                $.ajax({
                    url: '/board/qna/cmmtModify',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(allqnacDto),
                    success: function (data) {
                        console.log('수정 응답:', data);
                        toggleCommentEditForm(index, false);
                    },
                    error: function (error) {
                        console.error('에러:', error);
                    }
                });
            }

        });



        //댓글 삭제
        $(document).on('click', '.cmtDelete', function (e) {
            e.preventDefault();
            // let allqnaCNo = document.querySelector('.cmtDelete').getAttribute('data-allqnaCNo');
            let allqnaCNo = $(this).data('allqnaCNo');
            console.log(allqnaCNo);

            if (confirm('해당 댓글을 삭제하시겠습니까?')) {
                $.ajax({
                    data: JSON.stringify({allqnaCNo: allqnaCNo}),
                    url: '/board/qna/cmmtRemove',
                    type: 'POST',
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (result) {
                        alert('삭제완료');
                    }.bind(this)
                });
            };
        });


    //이미지 띄우기
    let allqnaNo = "${read.allqnaNo}";

    let showImg = function (allqnaNo) {
        $.ajax({
            type: 'GET',       // 요청 메서드
            url: '/board/qna/showImg?allqnaNo=' +allqnaNo,  // 요청 URI
            contentType: "image/jpeg",
            success: function (result) {
                $("#allqnaImg").html("하이");
            },
            error: function () {
                $("#allqnaImg").html("");
            }
        }); // $.ajax()
    }



    $(document).ready(function () {
        // showImg(allqnaNo);

    })






    </script>

</body>
</html>
