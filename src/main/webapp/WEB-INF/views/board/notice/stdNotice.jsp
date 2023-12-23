<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학생공지 글쓰기 리스트</title>
<%--    <link rel="stylesheet" href="<c:url value='/css/noticeList.css'/>">--%>
    <link rel="stylesheet" href="<c:url value='/css/noticeReading.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/jscdReset.css'/>">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/40.2.0/classic/ckeditor.js"></script>
</head>
<body>


<div id="topLetter">
   <span id="notice">학생 공지사항</span>
</div>
<script>
    let msg = "${msg}";
    if (msg == "wrt_err") alert("등록에 실패했습니다. 다시 시도해주세요.")
</script>

<form action="" id="form">
    <div id="detailHd">
        <input type="hidden" name="bno" value="${stdNoticeDto.bno}"><br>
        <input id="title" placeholder="제목에 핵심 내용을 요약해보세요." name="title" value="${stdNoticeDto.title}" ${mode=="new" ? '' : 'readonly="readonly"'}><br>
        <span>작성 <input type="text" id="regDate" name="regDate" value="${stdNoticeDto.modifyDate} " readonly> ･</span>
        <span>조회수 <input type="text" id="viewCnt" name="viewCnt" value=" ${stdNoticeDto.viewCnt}" readonly></span><br>
        <span>작성자 <input type="text" name="writer" id="writer" value=" ${stdNoticeDto.writer}" ></span><br>
    </div>

    <div id="wrapCon">
        <textarea name="content" id="content" ${mode=="new" ? '' : 'readonly="readonly"'}>${stdNoticeDto.content}</textarea><%--위지윅 적용--%>
        <%--위지윅 적용--%>
        <script>
            ClassicEditor
                .create(document.querySelector('#content'))
                .catch(error=>{
                    console.error(error);
                });
        </script>
        </div>
        <div id="wrapAtc">
            <input type="file" id="upload" class="attachBtn">
        </div>
    </div>

    <div id="buttonBox">
        <input type="button" id="writeBtn" class="registeBtn" value="${mode eq 'new' ? '등록' : ''}"
               style="display: ${mode eq 'new' ? 'inline-block' : 'none'}">
        <input type="button" id="modifyBtn" class="modifyBtn" value="${mode eq 'new' ? '' : '수정'}"
               style="display: ${mode eq 'new' ? 'none' : 'inline-block'}">
        <input type="button" id="removeBtn" class="deleteBtn" value="삭제">
        <input type="button" id="listBtn" class="backBtn" value="목록">
    </div>
</form>
<script>
    $(document).ready(function () { // the same as main() -- document는 html문서이고 그 문서가 실행되면 준비해라 펑션을
        let formCheck = function() {
            let form = document.getElementById("form");
            if(form.title.value=="") {
                alert("제목을 입력해 주세요.");
                form.title.focus();
                return false;
            }

            if(form.content.value=="") {
                alert("내용을 입력해 주세요.");
                form.content.focus();
                return false;
            }
            return true;
        }

        $('#listBtn').on('click', function () {
            location.href = "<c:url value='list?page=${page}&pageSize=${pageSize}'/>";
            // history.back();
        });

        $('#removeBtn').on('click', function () {
            if (!confirm("정말로 삭제하시겠습니까?")) return; //yes가 아니면 return
            let form = $('#form');
            form.attr("action", "<c:url value='remove?page=${page}&pageSize=${pageSize}'/>"); //폼에 액션을 보드 리무브로 하고
            form.attr("method", "post"); //포스트로 해서 전송
            form.submit();
        });

        $('#writeBtn').on('click', function () {

            console.log('Button clicked');

            let form = $('#form');

            console.log('Form:', form);

            form.attr("action", "<c:url value='/board/stdNotice/write'/>");
            form.attr("method", "post");

            console.log('Form data:', form.serialize());

            form.submit();
        });


        $('#modifyBtn').on('click', function () {
            //1. 읽기 상태이면 수정 상태로 변경
            let form = $('#form');
            let isReadOnly = $("input[name=title]").attr('readonly');

            if (isReadOnly == 'readonly') {

                $("input[name=title]").removeAttr('readonly'); //title
                $("textarea").removeAttr('readonly'); //content
                $("#modifyBtn").val("수정완료");

                return;
            }

            //2. 수정 상태이면, 수정된 내용을 서버로 전송
            form.attr("action", "<c:url value='/board/stdNotice/modify?page=${page}&pageSize=${pageSize}'/>");
            form.attr("method", "post"); //포스트로 해서 전송
            if (formCheck()){form.submit();}

        })
    });
</script>



</body>
</html>