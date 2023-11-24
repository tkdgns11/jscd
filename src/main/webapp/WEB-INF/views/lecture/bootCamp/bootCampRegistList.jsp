<%--    작성일 : 2023-11-17--%>
<%--    작성자 : 장용호--%>
<%--    작성 기능 : 세미나 등록 게시판(관리자)--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>정석코딩 세미나 등록</title>
    <style>
        #bootCampBoard{
            width: 960px;
            height: 1080px;
            margin: 0 auto;
        }
        #bootCampBoard a{
            text-decoration: none;
            color: black;
        }
        #bootCampBoard a:hover{
            background-color: rgba(0,0,0,0.15);
        }
        #bootCampFont{
            margin-bottom: -30px;
            font-size: 40px;
        }
        #bootCampHead{
            float: right;
        }
        #bootCampSel{
            width: 80px;
            height: 25px;
            border-radius: 10px;
            color: white;
            background-color: #182566;
        }
        #bootCampTable{
            width: 100%;
            border-top: 2px groove black;
            border-collapse: collapse;
            text-align: center;
            font-weight: 900;
        }
        .bootCampTr, .bootCampTd{
            padding: 10px;
            margin-right: -10px;
            border-bottom: 1px groove gray;
        }
        .bootCampTh{
            padding: 10px;
            border-bottom: 1px groove gray;
        }
        .bootCampTr:nth-child(1){
            background-color: #182566;
            color: white;
        }
        #bootCampNavi{
            text-align: center;
            margin-top: 15px;
            font-size: 18px;
            font-weight: 900;
        }
        #bootCampNavi a{
            padding-right: 5px;
        }
        #writeBtn{
            float: right;
            margin-top: -25px;
            width: 80px;
            height: 25px;
            border-radius: 10px;
            color: white;
            background-color: #182566;
        }
    </style>
</head>
<body>
<h1>/* 정석코딩 부트캠프 신청 */</h1>

<div>
    <a href="">부트캠프</a> |
    <a href="">세미나</a>
</div>

<div id="bootCampBoard">

    <h2 id="bootCampFont">부트캠프</h2>

    <%--    검색    --%>
    <form id="bootCampHead" action="" method="get">
        <select>
            <option>전체</option>
            <option>제목</option>
            <option>작성자</option>
        </select>
        <input type="text" placeholder="검색어를 입력해주세요.">
        <input id="bootCampSel" type="submit" class="" value="검색">
    </form>

    <%--    게시판    --%>
    <table id="bootCampTable">
        <tr class="bootCampTr">
            <th class="bootCampTh">No.</th>
            <th class="bootCampTh">제목</th>
            <th class="bootCampTh">작성자</th>
            <th class="bootCampTh">작성시간</th>
            <th class="bootCampTh">조회수</th>
        </tr>
        <c:forEach var="BootCampDto" items="${list}">
            <tr class="bootCampTr">
                <td class="bootCampTd">${BootCampDto.classEnrollNo}</td>
                <td class="bootCampTd"><a href="<c:url value='/btregist/read?classEnrollNo=${BootCampDto.classEnrollNo}&page=${page}&pageSize=${pageSize}'/>">${BootCampDto.title}</a></td>
                <td class="bootCampTd">${BootCampDto.writer}</td>
                <td class="bootCampTd"><fmt:formatDate value="${BootCampDto.regDate}" pattern="yyyy.MM.dd"/> </td>
                <td class="bootCampTd">${BootCampDto.viewCnt}</td>
            </tr>
        </c:forEach>
    </table>

    <%--    내비게이션   --%>
    <div id="bootCampNavi">
        <c:if test="${sh.showPrev}">
            <a href="<c:url value='/btregist/list?page=${sh.beginPage-1}&pageSize=${sh.pageSize}'/>">&lt;&lt;</a>
        </c:if>

        <c:forEach var="i" begin="${sh.beginPage}" end="${sh.endPage}">
            <a href="<c:url value='/btregist/list?page=${i}&pageSize=${sh.pageSize}'/>">${i}</a>
        </c:forEach>

        <c:if test="${sh.showNext}">
            <a href="<c:url value='/btregist/list?page=${sh.endPage+1}&pageSize=${sh.pageSize}'/>">&gt;&gt;</a>
        </c:if>
    </div>
    <button id="writeBtn" type="button" onclick="location.href='<c:url value="/btregist/write"/>'">글쓰기</button>
</div>

</body>
</html>
