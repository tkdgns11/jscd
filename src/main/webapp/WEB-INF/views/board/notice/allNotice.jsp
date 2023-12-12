<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글쓰기 리스트</title>
    <link rel="stylesheet" href="<c:url value='/css/noticeList.css'/>">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
    <div id="headerNotice">
        <div id="ltone">/* Notice */</div>
        <div id="lttwo">공지사항;</div>
    </div>
    <script>
        let msg = "${msg}";
        if (msg == "wrt_err") alert("등록 실패!!!! 다시 시도 바람")
    </script>

    <form action="" id="form">
        <input type="hidden" name="bno" value="${noticeDto.bno}"><br>
        제목<br>
        <input type="text" name="title" value="${noticeDto.title}" ${mode=="new" ? '' : 'readonly="readonly"'}><br>
        작성자<br>
        <input type="text" name="writer" value="${noticeDto.writer}" ${mode=="new" ? '' : 'readonly="readonly"'}><br>
<%--        <br><input type="hidden" name="reg_date"--%>
<%--                       value="${noticeDto.reg_date}" ${mode=="new" ? '' : 'readonly="readonly"'}><br>--%>
        내용<br>
        <textarea name="content" id="" cols="30"
                        rows="10" ${mode=="new" ? '' : 'readonly="readonly"'}>${noticeDto.content}</textarea><br>
        <button type="button" id="upload">첨부파일</button>
        <br>
        <button type="button" id="writeBtn" class="btn" ${mode eq 'new' ? '' : 'hidden'}>${mode eq 'new' ? '등록하기' : ''}</button>
        <button type="button" id="modifyBtn" class="btn">수정하기</button>
        <button type="button" id="removeBtn" class="btn">삭제하기</button>
        <button type="button" id="listBtn" class="btn">돌아가기</button>
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

                form.attr("action", "<c:url value='/board/notice/write'/>");
                form.attr("method", "post");
                console.log('Form data:', form.serialize());
                form.submit();
            });


            $('#modifyBtn').on('click', function () {
                //1. 읽기 상태이면 수정 상태로 변경
                let form = $('#form');
                let isReadOnly = $("input[name=title]").attr('readonly');

                if (isReadOnly == 'readonly') {

                    console.log("111");

                    $("input[name=title]").removeAttr('readonly'); //title

                    console.log("222");

                    $("textarea").removeAttr('readonly'); //content

                    console.log("333");

                    $("#modifyBtn").html("수정완료");

                    return;

                }

                console.log("444444")

                //2. 수정 상태이면, 수정된 내용을 서버로 전송
                form.attr("action", "<c:url value='/board/notice/modify?page=${page}&pageSize=${pageSize}'/>");
                form.attr("method", "post"); //포스트로 해서 전송
                if (formCheck()){form.submit();}

            })







        });


    </script>
</body>
</html>