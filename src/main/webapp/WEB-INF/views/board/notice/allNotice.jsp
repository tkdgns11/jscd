<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | 공지사항</title>
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
        <input type="hidden" id="bno" name="bno" value="${noticeDto.bno}"><br>
        <input id="title" placeholder="제목에 핵심 내용을 요약해보세요." name="title" value="${noticeDto.title}" ${mode=="new" ? '' : 'readonly="readonly"' }><br>
        <c:if test="${mode ne 'new'}">
            <span>작성 <input type="text" id="regDate" name="regDate" value="${noticeDto.modifyDate} " readonly> ･</span>
            <span>조회수 <input type="text" id="viewCnt" name="viewCnt" value="${noticeDto.viewCnt}" readonly></span><br>
            <span>작성자 <input type="text" name="writer" id="writer" value="${noticeDto.writer}" readonly></span><br>
        </c:if>
        <c:if test="${mode eq 'new'}">
            <input type="hidden" id="regDate" name="regDate" value="${noticeDto.modifyDate}" readonly>
            <input type="hidden" id="viewCnt" name="viewCnt" value="${noticeDto.viewCnt}" readonly>
            <input type="hidden" name="writer" id="writer" value="${noticeDto.writer}" readonly>
        </c:if>
    </div>
        <div id="wrapCon">
            <textarea name="content" id="content" ${mode=="new" ? '' : 'readonly="readonly"'}>${noticeDto.content}</textarea>
<%--            <input type="submit" value="Submit" onclick="return formCheck();" />--%>
<%--            위지윅 적용--%>
            <script>
                document.addEventListener("DOMContentLoaded", function (){
                    const contentTextarea = document.querySelector('#content');
                    // if (!contentTextarea.hasAttribute('readonly')){
                        ClassicEditor
                            .create(contentTextarea,{
                                language: "ko"
                            })
                            .then(newEditor => {
                                editor = newEditor;
                            })
                            .catch(error => {
                                console.error(error);
                            });
                    // }
                });
            </script>
        </div>
        <div id="wrapAtc">
            <input type="file" id="upload" class="attachBtn">
        </div>


    <div id="buttonBox">
        <input type="button" id="listBtn" class="backBtn" value="목록">
        <div id="eachBtn">
        <input type="button" id="writeBtn" class="registeBtn" value="${mode eq 'new' ? '등록' : ''}"
               style="display: ${mode eq 'new' ? 'inline-block' : 'none'}">
        <input type="button" id="modifyBtn" class="modifyBtn" value="${mode eq 'new' ? '' : '수정'}"
               style="display: ${mode eq 'new' ? 'none' : 'inline-block'}">
        <input type="button" id="removeBtn" class="deleteBtn" value="삭제">
        </div>
    </div>
</form>
<script>
    let msg = "${msg}";
    if (msg == "wrt_err") alert("등록에 실패!! 다시 시도 바랍니다.")
    if(msg=="del_err") alert("삭제 실패!! 다시 시도 바랍니다.")
    if (msg=="modify_err") alert ("권한이 없습니다.")
    if (msg=="mod_err")alert("수정 실패!! 다시 시도 바랍니다")

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
            location.href = "<c:url value='list?page=${page} &pageSize=${pageSize}'/>";
        });

        $('#removeBtn').on('click', function () {
            if (!confirm("정말로 삭제하시겠습니까?")) return; //yes가 아니면 return
            let form = $('#form');
            form.attr("action", "<c:url value='/board/notice/remove?page=${page}&pageSize=${pageSize}'/>"); //폼에 액션을 보드 리무브로 하고
            form.attr("method", "post"); //포스트로 해서 전송
            form.submit();
        });


        $('#writeBtn').on('click', function () {
            console.log("등록");


            // const content = CKEDITOR.instances.content.getData();
            const writer = document.getElementById("writer").value;
            const title = document.getElementById("title").value;
            const editorData = editor.getData();
            const div = document.createElement("div");
            div.innerHTML = editorData;
            const content = div.textContent || div.innerText || "";
            // const openYN = document.querySelector('input[name="openYN"]:checked').value;
            console.log("writer=======" + writer.value);
            console.log("title=======" + title.value);
            console.log("content=======" + content);

            if (title === "") {
                console.log("제목입력해주세요");
                return alert("제목을 입력해주세요.");
            }
            if (content === "") {
                console.log("내용입력해주세요");
                return alert("내용을 입력해주세요.");
            }


            const allNoticeData = {title: title, writer: writer, content: content};
            console.log(allNoticeData);


            $.ajax({
                url: "/board/notice/write",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(allNoticeData),
                error: function (error) {
                    console.log("에러 발생");
                },
                success: function (data) {
                    console.log("성공");
                    if (data.redirect) {
                        window.location.href = data.redirect;
                    }

                }
            });
        });



            $('#modifyBtn').on('click', function () {

                //1. 읽기 상태이면 수정 상태로 변경
                let form = $('#form');
                let isReadOnly = $("input[name=title]").attr('readonly');


                if (isReadOnly == 'readonly') {
                    $("input[name=title]").removeAttr('readonly'); //title
                    $("textarea").removeAttr('readonly'); //content
                    // ClassicEditor
                    //     .create(document.querySelector('#content'))
                    //     .catch(error => {
                    //         console.error(error);
                    //     });

                    $("#modifyBtn").val("수정완료");
                    return;

                }
                //2. 수정 상태이면, 수정된 내용을 서버로 전송
                const bno = document.getElementById("bno");
                console.log(bno);
                const writer = document.getElementById("writer").value;
                const title = document.getElementById("title").value;
                const editorData = editor.getData();
                const div = document.createElement("div");
                div.innerHTML = editorData;
                const content = div.textContent || div.innerText || "";
                // const openYN = document.querySelector('input[name="openYN"]:checked').value;
                console.log("writer=======" + writer.value);
                console.log("title=======" + title.value);
                console.log("content=======" + content);

                const allNoticeData = {bno: bno.value, title: title, writer: writer, content:content};
                console.log(allNoticeData);

                $.ajax({
                    url: "/board/notice/modify?page=${page}&pageSize=${pageSize}",
                    type: "POST",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(allNoticeData),
                    error: function (error) {
                        console.log("에러 발생");
                    },
                    success: function (data) {
                        console.log("성공");
                        if (data.redirect) {
                            console.log(data.redirect);
                            window.location.href = data.redirect;
                        }

                     }
                });
            })
        });
</script>
</body>
</html>