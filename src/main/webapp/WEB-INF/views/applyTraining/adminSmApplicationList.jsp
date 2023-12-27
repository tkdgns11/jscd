<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12/3/23
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Noto+Serif+KR:wght@900&display=swap"
          rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" tyep="text/css" href="<c:url value="/css/admin/home.css"/>">
<%--    <link rel="stylesheet" tyep="text/css" href="<c:url value="/css/regist.css"/>">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfo.css"/>">

    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/white_mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/white_mainlogo.png"/>
    <title>정석코딩 관리자 | 세미정 신청서 관리</title>
    <%--폰트어썸 라이브러리 불러오기--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script>
        let msg = "${msg}";
        if(msg == "DEL_ERR") alert("삭제되었거나 없는 게시물입니다.");
        if(msg == "DEL_OK") alert("성공적으로 삭제되었습니다.");
        if(msg == "WRT_OK") alert("성공적으로 등록되었습니다.");
        if(msg == "MOD_OK") alert("해당 게시물을 정상적으로 수정하였습니다.");
    </script>
</head>
<body>
<header>
    <jsp:include page="../admin/header.jsp"/>
</header>
<div id="adminContent">
    <nav>
        <jsp:include page="../admin/sidebar.jsp"/>
    </nav>
    <main>
        <div id="memberInfo">
            <div id="infoTitleBox">
                <h1>
                    <i class="fa-solid fa-graduation-cap" style="color: #353739;"></i>
                    &nbsp;&nbsp;세미나 신청서 관리</h1>
            </div>
            <div id="main_content_controll">
                <div id="memberSearchBox">
                    <form id="registHead" action="" method="get">
                        <select class="search-option" name="option">
                            <option value="all" ${ah.sa.option=='all' || ah.sa.option=='' ? "selected" : ""}>전체</option>
                            <option value="title" ${ah.sa.option=='title' ? "selected" : ""}>강의 이름</option>
                            <option value="id" ${ah.sa.option=='id' ? "selected" : ""}>신청자 계정</option>
                        </select>
                        <input type="text" name="keyword" value="${ah.sa.keyword}" placeholder="검색어를 입력해주세요.">
                        <input type="submit" id="smApplicationListSearch" class="searchBtn" value="검색">
                    </form>
                </div>

            </div>
            <div id="memberListBox">
                <%--    게시판    --%>
                <table>
                    <tr class="applicationManageTr">
                        <th class="applicationManageTh">신청 번호</th>
                        <th class="applicationManageTh">신청한 강의 이름</th>
                        <th class="applicationManageTh">신청자 계정</th>
                        <th class="applicationManageTh">신청 일시</th>
                    </tr>
                    <c:forEach var="smApplicationDto" items="${list}">
                        <tr class="applicationManageTr">
                            <td class="applicationManageTd">${smApplicationDto.stfmNo}</td>
                            <td class="applicationManageTd"><a class="subject_name" href="<c:url value='/adminManage/adminSmTraining/read${ah.sa.queryString}&stfmNo=${smApplicationDto.stfmNo}'/>">${smApplicationDto.title}</a></td>
                            <td class="applicationManageTd">${smApplicationDto.id}</td>
                            <td class="applicationManageTd"><fmt:formatDate value="${smApplicationDto.regDate}" pattern="yyyy-MM-dd HH시 mm분 ss초"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="infoNaviBox">
                <c:if test="${totalCnt==null || totalCnt==0}">
                    <div> 신청서가 없습니다.</div>
                </c:if>
                <c:if test="${totalCnt!=null && totalCnt!=0}">
                    <c:if test="${ah.showPrev}">
                        <a href="<c:url value='/adminManage/adminSmTraining/list${ah.sa.getQueryString(ah.beginPage-1)}'/>">
                            <i class="fa-solid fa-backward" style="color: #353739;"></i>
                        </a>
                    </c:if>

                    <c:forEach var="i" begin="${ah.beginPage}" end="${ah.endPage}">
                        <a href="<c:url value="/adminManage/adminSmTraining/list${ah.sa.getQueryString(i)}"/>">${i}</a>
                    </c:forEach>

                    <c:if test="${ah.showNext}">
                        <a href="<c:url value='/adminManage/adminSmTraining/list${ah.sa.getQueryString(ah.endPage+1)}'/>">
                            <i class="fa-solid fa-forward" style="color: #353739;"></i>
                        </a>
                    </c:if>
                </c:if>
            </div>
        </div>
    </main>
</div>
</body>
</html>
