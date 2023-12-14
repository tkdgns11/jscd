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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminApplicationList.css"/>">

    <title>정석코딩 세미나 신청서 관리</title>
</head>
<body>
    <h1 id="applicationManageText">/* 정석코딩 세미나 신청서 관리 */</h1>

<div id="applicationManageAll">

    <%--    검색    --%>
    <form id="applicationManageSel" action="<c:url value="/adminSmTraining/list"/>" method="get">
        <select class="inputTxt" name="option">
            <option value="all" ${ah.sa.option=='all' || ah.sa.option=='' ? "selected" : ""}>전체</option>
            <option value="title" ${ah.sa.option=='title' ? "selected" : ""}>강의 이름</option>
            <option value="id" ${ah.sa.option=='id' ? "selected" : ""}>신청자 계정</option>
        </select>

        <input type="text" class="inputTxt" name="keyword" value="${ah.sa.keyword}" placeholder="검색어를 입력해주세요.">
        <input type="submit" id="smApplicationListSearch" class="searchBtn" value=" 검색">
    </form>

    <%--    게시판    --%>
    <table id="applicationManageTable">
        <tr class="applicationManageTr">
            <th class="applicationManageTh">신청 번호</th>
            <th class="applicationManageTh">신청한 강의 이름</th>
            <th class="applicationManageTh">신청자 계정</th>
            <th class="applicationManageTh">신청 일시</th>
        </tr>
        <c:forEach var="smApplicationDto" items="${list}">
            <tr class="applicationManageTr">
            <td class="applicationManageTd">${smApplicationDto.stfmNo}</td>
            <td class="applicationManageTd"><a href="<c:url value='/adminSmTraining/read${ah.sa.queryString}&stfmNo=${smApplicationDto.stfmNo}'/>">${smApplicationDto.title}</a></td>
            <td class="applicationManageTd">${smApplicationDto.id}</td>
            <td class="applicationManageTd"><fmt:formatDate value="${smApplicationDto.regDate}" pattern="yyyy-MM-dd HH시 mm분 ss초"/></td>
        </tr>
        </c:forEach>
    </table>
    <c:if test="${totalCnt==null || totalCnt==0}">
        <div> 신청서가 없습니다.</div>
    </c:if>

    <%--    내비게이션   --%>
    <div id="applicationManageNavi">
    <c:if test="${totalCnt!=null && totalCnt!=0}">
        <c:if test="${ah.showPrev}">
            <a href="<c:url value='/adminSmTraining/list${ah.sa.getQueryString(ah.beginPage-1)}'/>">&lt;&lt;</a>
        </c:if>

        <c:forEach var="i" begin="${ah.beginPage}" end="${ah.endPage}">
            <a href="<c:url value='/adminSmTraining/list${ah.sa.getQueryString(i)}'/>">${i}</a>
        </c:forEach>

        <c:if test="${ah.showNext}">
            <a href="<c:url value='/adminSmTraining/list${ah.sa.getQueryString(ah.endPage+1)}'/>">&gt;&gt;</a>
        </c:if>
    </c:if>
    </div>
</div>
</body>
</html>