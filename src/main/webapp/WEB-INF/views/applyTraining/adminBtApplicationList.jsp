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
<%--<jsp:include page="../admin/adminHeader.jsp"/>--%>
<jsp:include page="../admin/adminSidebar.jsp"/>
<html>
<head>
    <title>adminBtApplicationList</title>
    <style>
        #whole{
            width:88% ;
            height: 100%;
            float: right;
        }
    </style>
</head>
<body>
<div id = "whole">
    <h1>정석코딩 부트캠프 신청서 관리</h1>

    <%--    검색    --%>
    <form action="<c:url value="/adminBtTraining/list"/>" method="get">
        <select name="option">
            <option >대기 중</option>
            <option >승인</option>
            <option >미승인</option>
        </select>
        &emsp;
        <select name="option">
            <option >전체</option>
            <option >강의 이름</option>
            <option >신청자 계정</option>
        </select>
        <input type="text" name="keyword" value="" placeholder="검색어를 입력해주세요.">
        <input id="btApplicationListSearch" type="submit" value="검색">
    </form>

    <%--    게시판    --%>
    <table border="1">
        <tr>
            <th>신청 번호</th>
            <th>신청한 강의 이름</th>
            <th>신청자 계정</th>
            <th>신청 일시</th>
            <th>승인 상태</th>
        </tr>
        <c:forEach var="btApplicationDto" items="${list}">
        <tr>
            <td>${btApplicationDto.stfmNo}</td>
            <td><a href="<c:url value='/adminBtTraining/read?stfmNo=${btApplicationDto.stfmNo}&page=${page}&pageSize=${pageSize}'/>">${btApplicationDto.title}</a></td>
            <td>${btApplicationDto.id}</td>
            <td><fmt:formatDate value="${btApplicationDto.regDate}" pattern="yyyy-MM-dd HH시 mm분 ss초"/></td>
            <td>${btApplicationDto.approvalYN}</td>
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

    <c:if test="${bh.showNext}">
        <a href="<c:url value='/adminBtTraining/list?page=${ah.endPage+1}&pageSize=${ah.pageSize}'/>">&gt;&gt;</a>
    </c:if>
</div>
</body>
</html>
