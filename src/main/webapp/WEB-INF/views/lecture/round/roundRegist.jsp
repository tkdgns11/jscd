<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12/2/23
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/home.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfo.css"/>">
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/admin/header.jsp"/>
</header>
<div id="adminContent">
    <nav>
        <jsp:include page="/WEB-INF/views/admin/sidebar.jsp"/>
    </nav>
    <main>
        <form id="RoundAddForm" method="post" action="">
            <c:choose>
                <c:when test="${mode eq 'new'}">
                    <div id="infoDetailBox" class="infoDetailClass">
                        <h2 id="infoTitle">회차 등록</h2>
                        <input type="text" name="roundName" placeholder="등록할 회차을 입력해주세요." value="${RoundDto.roundName}">
                        <input type="text" name="firstIdNO" placeholder="회원번호를 입력해주세요." value="${RoundDto.firstIdNO}">
                        <div id="infoDetailBtn">
                            <button type="button" class="registeBtn">등록하기</button>
                        </div>
                    </div>
                </c:when>
                <c:when test="${mode ne 'new'}">
                    <div id="infoDetailBox" class="infoDetailClass">
                        <h2 id="infoTitle">회차 등록</h2>
                        <label style="margin-right: 3px;">회차 번호</label>
                        <input types="text" class="infoInputBox" name="roundCode" value="${roundDto.roundCode}">
                        <label style="margin-right: 3px;">회차 이름</label>
                        <input types="text" class="infoInputBox" name="roundName" value="${roundDto.roundName}">
                        <label style="margin-right: 3px;">회차 등록일</label>
                        <input types="text" class="infoInputBox" name="regDate" value="${roundDto.regDate}">
                        <label style="margin-right: 3px;">회차 최초등록 식별자</label>
                        <input types="text" class="infoInputBox" name="firstIdNO" value="${roundDto.firstIdNO}">
                        <div id="infoDetailBtn">
                            <button type="button" class="deleteBtn">삭제하기</button>
                            <button type="button" class="modifyBtn">수정하기</button>
                        </div>
                    </div>
                </c:when>
            </c:choose>
        </form>
    </main>
</div>

</body>
<script>
    $(document).ready(function() {
        $("#registBt").on("click", function() {
            if(!confirm("해당 과정을 등록하시겠습니까?")) return;
            let form = $("#RoundAddForm");
            <%--form.attr("action", "<c:url value='/onlyAdmin/registRound/addRound'/>");--%>
            form.attr("action", "<c:url value='/adminManage/registRound/addRound'/>");
            form.attr("method", "post");
            form.submit();
        });

        $("#removeBtn").on("click", function() {
            let form = $("#RoundAddForm");
            <%--form.attr("action", "<c:url value='/onlyAdmin/registRound/removeRound?roundCode=${roundDto.roundCode}'/>");--%>
            form.attr("action", "<c:url value='/adminManage/registRound/removeRound?roundCode=${roundDto.roundCode}'/>");
            form.attr("method", "post");
            form.submit();
        });

        $("#modifyBtn").on("click", function() {
            let form = $("#RoundAddForm");
            <%--form.attr("action", "<c:url value='/onlyAdmin/registRound/modifyRound'/>");--%>
            form.attr("action", "<c:url value='/adminManage/registRound/modifyRound'/>");
            form.attr("method", "post");
            form.submit();
        })
    });
</script>
</html>

