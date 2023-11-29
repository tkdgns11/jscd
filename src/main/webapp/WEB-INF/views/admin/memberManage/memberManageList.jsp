<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>회원 정보 관리</title>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Noto+Serif+KR:wght@900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfoManage.css"/>">
</head>
<script>
    let msg = "${param.msg}";
    if(msg=="MOD_OK")    alert("성공적으로 수정되었습니다.");
    if(msg=="LIST_ERR")  alert("회원 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
</script>
<body>

<div id="content">

    <header>
        <jsp:include page="../adminHeader.jsp"/>
    </header>

<div id="infoListBox">
    <div id="infoListTitle">
        <h1>회원 정보 관리</h1>
    </div>

    <div id="choiceBox">
        <form action="" method="get";>
            <select name="option" id="selectList">
                <option value="T" ${sc.option=='T' || sc.option=='' ? "selected" : ""}>이름</option>
                <option value="W" ${sc.option=='W' || sc.option=='' ? "selected" : ""}>아이디</option>
                <option value="R" ${sc.option=='R' || sc.option=='' ? "selected" : ""}>등급</option>
                <option value="Q" ${sc.option=='Q' || sc.option=='' ? "selected" : ""}>상태</option>
            </select>

            <input type="text" name="keyword" type="text" value="${param.keyword}" id="keywordInput" placeholder="검색어를 입력해주세요">
            <button id="searchBtn">검색</button>

        </form>
    </div>

    <div id="infoListTable">
    <table class="infoListTable">
        <tr>
            <th class="infoListTable"><input type="checkbox" class="thInput"></th>
            <th class="infoListTable">No.</th>
            <th style="width: 80px;height: 45px" class="infoListTable">아이디</th>
            <th style="width: 80px;height: 45px" class="infoListTable">이름</th>
            <th style="width: 80px;height: 45px" class="infoListTable">닉네임</th>
            <th style="width: 150px;height: 45px" class="infoListTable">폰번호</th>
            <th style="width: 80px;height: 45px" class="infoListTable">등급</th>
            <th style="width: 80px;height: 45px" class="infoListTable">상태</th>
            <th style="width: 200px;height: 45px" class="infoListTable">가입일</th>
        </tr>
        <c:forEach var="memberDto" items="${list}">
            <tr>
                <td style="height: 45px" class="infoListTable"><input type="checkbox" class="thInput"></td>
                <td style="height: 45px" class="infoListTable">${memberDto.mebrNo}</td>
                <td style="height: 45px" class="infoListTable">${memberDto.id}</td>
                <td style="height: 45px" class="infoListTable">
                    <a href="<c:url value="/onlyAdmin/memberManage/read?page=${sc.page}&mebrNo=${memberDto.mebrNo}"/>">${memberDto.name}</a>
                </td>
                <td style="height: 45px" class="infoListTable">${memberDto.nickname}</td>
                <td style="height: 45px" class="infoListTable">${memberDto.phone}</td>
                <td style="height: 45px" class="infoListTable">${memberDto.grade}</td>
                <td style="height: 45px" class="infoListTable">${memberDto.status}</td>
                <td style="height: 45px" class="infoListTable"><fmt:formatDate value="${memberDto.regDate}" pattern="yyyy-MM-dd" type="date"/></td>
            </tr>
        </c:forEach>
    </table>
        </div>


    <div id="infoNav">
        <c:if test="${page.totalCnt==null || page.totalCnt==0}">
            <p id="noContent"> 게시물이 없습니다.</p>
        </c:if>

        <c:if test="${page.totalCnt!=null && page.totalCnt!=0}">
            <p>
                <c:if test="${page.showPrev}">
                    <a href="<c:url value="/onlyAdmin/memberManage/list${sc.getQueryString(page.beginPage-1)}"/>">&lt;</a>
                </c:if>
                <c:forEach var="i" begin="${page.beginPage}" end="${page.endPage}">
                    <a href="<c:url value="/onlyAdmin/memberManage/list${sc.getQueryString(i)}"/>">${i}</a>
                </c:forEach>
                <c:if test="${page.showNext}">
                    <a href="<c:url value="/onlyAdmin/memberManage/list${sc.getQueryString(page.endPage+1)}"/>">&gt;</a>
                </c:if>
            </p>
        </c:if>
    </div>
</div>

    <footer>
        <jsp:include page="../../footer.jsp"/>
    </footer>

</div>


</body>
</html>
