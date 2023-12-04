<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>classEnrollList</title>
</head>
<body>
<script>
    let msg = "${msg}";
    if(msg == "write ok") alert("게시물 등록 성공")
    if(msg == "modify ok") alert("게시물 수정 성공")
    if(msg == "remove ok") alert("게시물 삭제 성공")

    if(msg == "remove fail") alert("게시물 삭제 실패")
</script>

    <h2>과목 등록</h2><br>
    <table>
        <tr>
            <th>과목 번호</th>
            <th>등록된 과목 이름</th>
            <th>최초 등록일</th>
            <th>최종 수정일</th>
        </tr>
    <c:forEach var="classEnrollDto" items="${classEnrollList}">
        <tr>
            <td>
                ${classEnrollDto.classCode}
            </td>
            <td>
                <a href="<c:url value='/classEnroll/read?classCode=${classEnrollDto.classCode}'/>">${classEnrollDto.className}</a></td><br>
            </td>
            <td>
                <fmt:formatDate value="${classEnrollDto.regDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
            </td>
            <td>
                <fmt:formatDate value="${classEnrollDto.modifyDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
            </td>
        </tr>
    </c:forEach>
    </table>
    <button type="button" onclick="location.href='<c:url value="/classEnroll/write"/>'">등록하기</button>
</body>
</html>
