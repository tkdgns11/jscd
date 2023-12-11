<%--
  Created by IntelliJ IDEA.
  User: jang-yongho
  Date: 12/8/23
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>adminSmApplicationList</title>
</head>
<body>
    <h1>정석코딩 세미나 신청서 관리</h1>

    <%--    검색    --%>
    <form action="<c:url value="/adminSmTraining/list"/>" method="get">
        <select name="option">
            <option >전체</option>
            <option >강의 이름</option>
            <option >신청자 계정</option>
        </select>
        &emsp;
        <input type="text" name="keyword" value="" placeholder="검색어를 입력해주세요.">
        <input id="smApplicationListSearch" type="submit" value="검색">
    </form>

    <%--    게시판    --%>
    <table border="1">
        <tr>
            <th>신청 번호</th>
            <th>신청한 강의 이름</th>
            <th>신청자 계정</th>
            <th>신청 일시</th>
        </tr>
        <c:forEach var="smApplicationDto" items="${list}">
        <tr>
            <td>${smApplicationDto.stfmNo}</td>
            <td><a href="<c:url value='/adminSmTraining/read?stfmNo=${smApplicationDto.stfmNo}&page=${page}&pageSize=${pageSize}'/>">${smApplicationDto.title}</a></td>
            <td>${smApplicationDto.id}</td>
            <td><fmt:formatDate value="${smApplicationDto.regDate}" pattern="yyyy-MM-dd HH시 mm분 ss초"/></td>
        </tr>
        </c:forEach>
    </table>

    <%--    내비게이션   --%>
    <c:if test="${ah.showPrev}">
        <a href="<c:url value='/adminBtTraining/list?page=${ah.beginPage-1}&pageSize=${ah.pageSize}'/>">&lt;&lt;</a>
    </c:if>

    <c:forEach var="i" begin="${ah.beginPage}" end="${ah.endPage}">
        <a href="<c:url value='/adminBtTraining/list?page=${i}&pageSize=${ah.pageSize}'/>">${i}</a>
    </c:forEach>

    <c:if test="${ah.showNext}">
        <a href="<c:url value='/adminBtTraining/list?page=${ah.endPage+1}&pageSize=${ah.pageSize}'/>">&gt;&gt;</a>
    </c:if>

</body>
</html>
