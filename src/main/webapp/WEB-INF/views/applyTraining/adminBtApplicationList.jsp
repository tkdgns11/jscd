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
            <option value="all" ${ah.sa.option=='all' || ah.sa.option=='' ? "selected" : ""}>전체</option>
            <option value="title" ${ah.sa.option=='title' ? "selected" : ""}>강의 이름</option>
            <option value="id" ${ah.sa.option=='id' ? "selected" : ""}>신청자 계정</option>
            <option value="approvalYN" ${ah.sa.option=='approvalYN' ? "selected" : ""}>승인 상태</option>
        </select>

        <input type="text" name="keyword" value="${ah.sa.keyword}" placeholder="검색어를 입력해주세요.">
        <input type="submit" id="btApplicationListSearch" value="검색">
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
            <td><a href="<c:url value='/adminBtTraining/read${ah.sa.queryString}&stfmNo=${btApplicationDto.stfmNo}'/>">${btApplicationDto.title}</a></td>
            <td>${btApplicationDto.id}</td>
            <td><fmt:formatDate value="${btApplicationDto.regDate}" pattern="yyyy-MM-dd HH시 mm분 ss초"/></td>
            <td>${btApplicationDto.approvalYN}</td>
        </tr>
        </c:forEach>
    </table>
    <c:if test="${totalCnt==null || totalCnt==0}">
        <div> 신청서가 없습니다.</div>
    </c:if>

    <%--    내비게이션   --%>
    <c:if test="${totalCnt!=null && totalCnt!=0}">
        <c:if test="${ah.showPrev}">
            <a href="<c:url value='/adminBtTraining/list${ah.sa.getQueryString(ah.beginPage-1)}'/>">&lt;&lt;</a>
        </c:if>

        <c:forEach var="i" begin="${ah.beginPage}" end="${ah.endPage}">
            <a href="<c:url value="/adminBtTraining/list${ah.sa.getQueryString(i)}"/>">${i}</a>
        </c:forEach>

        <c:if test="${ah.showNext}">
            <a href="<c:url value='/adminBtTraining/list${ah.sa.getQueryString(ah.endPage+1)}'/>">&gt;&gt;</a>
        </c:if>
    </c:if>
</div>
</body>
</html>
