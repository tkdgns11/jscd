<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var = "path" value = "${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>게시판-${read.title}</title>
</head>
<body>

<button onclick="location.href='${path}/board/qna/qnaForm'">글쓰기</button>
<%--    <c:forEach var="modify"  items="${modify}"> </c:forEach>  ///  modifiy?--%>
<button onclick="location.href='${path}/board/qna/allqnaDelete?allqnaNo=${read.allqnaNo}'">삭제하기</button>
<button onclick="location.href='${path}/board/qna/allqnaModify?allqnaNo=${read.allqnaNo}'">수정하기</button>
<button onclick="deleteConfirmation(${read.allqnaNo})">삭제하기</button>

<script>
    function deleteConfirmation(allqnaNo) {
        if (confirm("정말 삭제하시겠습니까?")) {
            location.href = '${path}/board/qna/allqnaDelete?allqnaNo='+${read.allqnaNo};
        }
    }

    //&{comment.allqnaNo}라고 쓰면 string 변환 오류;
    function deleteConfirmation(allqnaCNo) {
        if (confirm("정말 삭제하시겠습니까?")) {
            location.href = '${path}/board/qna/cmmtDelete?allqnaNo='+${read.allqnaNo};
        }

    }
</script>


<div>
    ${read.title}
</div>
<div>
    ${read.content}
</div>
<div>
    ${read.writer}
</div>






<form method="POST" id="commentForm" action="${path}/board/qna/cmmtWrite" target="commentFrame">

    <input type="hidden" id="allqnaNo" name="allqnaNo" value="${read.allqnaNo}">

    <br><br>
    <label>댓글 작성자</label>
    <input type="text" name="writer">
    </p>
    <p>
        <textarea rows="5" cols="50" name="content"></textarea>
    </p>
    <p>
        <button type="submit">댓글 작성</button>
    </p>
</form>

</div>




<c:forEach items="${comment}" var="comment">
    <button onclick="location.href='${path}/board/qna/cmmtModify?allqnaCNo=${comment.allqnaCNo}'">수정</button>
    <button onclick="deleteConfirmation(${read.allqnaNo})">삭제하기</button>
   댓글번호 : ${comment.allqnaCNo}<br>
   작성자 : ${comment.writer}<br>
   내용 : ${comment.content}<br>
   등록일자 :  ${comment.regDate}<br>
</c:forEach>





</body>
</html>
