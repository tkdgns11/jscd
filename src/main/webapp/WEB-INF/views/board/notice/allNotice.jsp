<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글쓰기 리스트</title>
<%--    <link rel="stylesheet" href="<c:url value='/css/noticeList.css'/>">--%>
    <link rel="stylesheet" href="<c:url value='/css/noticeReading.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/jscdReset.css'/>">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/40.2.0/classic/ckeditor.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
</head>
<body>
<div id="topLetter">
    <span id="notice">공지사항</span>
</div>



<form action="" id="form" value="">
    <div id="detailHd">
        <input type="hidden" name="bno" value="${noticeDto.bno}"><br>
        <input id="title" placeholder="제목에 핵심 내용을 요약해보세요." name="title" value="${noticeDto.title}" ${mode=="new" ? '' : 'readonly="readonly"' }><br>
        <span>작성 <input type="text" id="regDate" name="regDate" value="${noticeDto.regDate} " readonly> ･</span>
        <span>수정 <input type="text" id="modifyDate" name="modifyDate" value="${noticeDto.modifyDate} " readonly>･</span>
        <span>조회수 <input type="text" id="viewCnt" name="viewCnt" value=" ${noticeDto.viewCnt}" readonly></span><br>
        <span>작성자 <input type="text" name="writer" id="writer" value=" ${noticeDto.writer}" readonly></span><br>

        <div id="wrapCon">
            <textarea name="content" id="content" ${mode=="new" ? '' : 'readonly="readonly"'}>${noticeDto.content}</textarea>
<%--            <input type="submit" value="Submit" onclick="return formCheck();" />--%>
<%--            위지윅 적용--%>
            <script>

            ClassicEditor.create( document.querySelector( '#content' ), {
                language: "ko"

            } );

            </script>
        </div>
        <div id="wrapAtc">
            <input type="file" id="upload" class="attachBtn">
        </div>
    </div>

    <div id="buttonBox">
        <input type="button" id="listBtn" class="backBtn" value="목록">
        <div id="eachBtn">
        <input type="button" id="writeBtn" class="registeBtn" value="${mode eq 'new' ? '등록' : ''}"
               style="display: ${mode eq 'new' ? 'inline-block' : 'none'}">
        <input type="button" id="modifyBtn" class="modifyBtn" value="${mode eq 'new' ? '' : '수정'}"
               style="display: ${mode eq 'new' ? 'none' : 'inline-block'}">
        <input type="button" id="removeBtn" class="deleteBtn" value="삭제"></div>
    </div>
</form>
<script>
    let msg = "${msg}";
    if (msg == "wrt_err") alert("등록 실패!!!! 다시 시도 바람")
</script>

<script>
    $(document).ready(function () { // the same as main() -- document는 html문서이고 그 문서가 실행되면 준비해라 펑션을
        let formCheck = function () {
            let form = document.getElementById("form");
            // CKEDITOR.instance.content.getData();
            if (form.title.value == "") {
                alert("제목을 입력해 주세요.");
                form.title.focus();
                return false;
            }

            if (form.content.value == "") {

                alert("내용을 입력하셨나요?.");
                form.content.focus();
                return false;
            }
            return true;
        }

        $('#listBtn').on('click', function () {
            location.href = "<c:url value='list?page=${page}&pageSize=${pageSize}'/>";
        });

        $('#removeBtn').on('click', function () {
            if (!confirm("정말로 삭제하시겠습니까?")) return; //yes가 아니면 return
            let form = $('#form');
            form.attr("action", "<c:url value='remove?page=${page}&pageSize=${pageSize}'/>"); //폼에 액션을 보드 리무브로 하고
            form.attr("method", "post"); //포스트로 해서 전송
            form.submit();
        });


        $('#writeBtn').on('click', function () {
            console.log("Write button clicked");
            let form = $('#form');
            form.attr("action", "<c:url value='/board/notice/write'/>");
            form.attr("method", "post"); //포스트로 해서 전송
                          console.log(form);

            // if (formCheck()) {
            //     console.log(formCheck());
                 form.submit();
            // }
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

            form.attr("action", "<c:url value='/board/notice/modify?page=${page}&pageSize=${pageSize}'/>");
            form.attr("method", "post"); //포스트로 해서 전송
                        if (formCheck()) {
                            form.submit();
                        }
        })
    });
</script>
</body>
</html>