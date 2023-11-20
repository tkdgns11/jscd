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
        #seminarRegistBoard{
            width: 960px;
            height: 1080px;
            margin: 0 auto;
        }
        #seminarRegistBoard a{
            text-decoration: none;
            color: black;
        }
        #seminarRegistBoard a:hover{
            background-color: rgba(0,0,0,0.15);
        }
        #seminarFont{
            margin-bottom: -30px;
            font-size: 40px;
        }
        #seminarRegistHead{
            float: right;
        }
        #seminarRegistSel{
            width: 80px;
            height: 25px;
            border-radius: 10px;
            color: white;
            background-color: #182566;
        }
        #seminarRegistTable{
            width: 100%;
            border-top: 2px groove black;
            border-collapse: collapse;
            text-align: center;
            font-weight: 900;
        }
        .seminarRegistTr, .seminarRegistTd{
            padding: 10px;
            margin-right: -10px;
            border-bottom: 1px groove gray;
        }
        .seminarRegistTh{
            padding: 10px;
            border-bottom: 1px groove gray;
        }
        .seminarRegistTr:nth-child(1){
            background-color: #182566;
            color: white;
        }
        #seminarRegistNavi{
            text-align: center;
            margin-top: 15px;
            font-size: 18px;
            font-weight: 900;
        }
        #seminarRegistNavi a{
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
<h1>/* 정석코딩 세미나 신청 */</h1>

<div>
    <a href="">부트캠프</a> |
    <a href="">세미나</a>
</div>

<div id="seminarRegistBoard">

    <h2 id="seminarFont">세미나</h2>

    <%--    검색    --%>
        <form id="seminarRegistHead" action="" method="get">
            <select>
                <option>전체</option>
                <option>제목</option>
                <option>작성자</option>
            </select>
            <input type="text" placeholder="검색어를 입력해주세요.">
            <input id="seminarRegistSel" type="submit" class="" value="검색">
        </form>

    <%--    게시판    --%>
    <table id="seminarRegistTable">
        <tr class="seminarRegistTr">
            <th class="seminarRegistTh">No.</th>
            <th class="seminarRegistTh">제목</th>
            <th class="seminarRegistTh">작성자</th>
            <th class="seminarRegistTh">작성시간</th>
            <th class="seminarRegistTh">조회수</th>
        </tr>
        <c:forEach var="seminarRegistDto" items="${list}">
            <tr class="seminarRegistTr">
                <td class="seminarRegistTd">${seminarRegistDto.classEnrollNo}</td>
                <td class="seminarRegistTd"><a href="<c:url value='/regist/read?classEnrollNo=${seminarRegistDto.classEnrollNo}&page=${page}&pageSize=${pageSize}'/>">${seminarRegistDto.title}</a></td>
                <td class="seminarRegistTd">${seminarRegistDto.writer}</td>
                <td class="seminarRegistTd"><fmt:formatDate value="${seminarRegistDto.regDate}" pattern="yyyy.MM.dd"/> </td>
                <td class="seminarRegistTd">${seminarRegistDto.viewCnt}</td>
            </tr>
        </c:forEach>
    </table>

    <%--    내비게이션   --%>
    <div id="seminarRegistNavi">
        <c:if test="${sh.showPrev}">
            <a href="<c:url value='/regist/list?page=${sh.beginPage-1}&pageSize=${sh.pageSize}'/>">&lt;&lt;</a>
        </c:if>

        <c:forEach var="i" begin="${sh.beginPage}" end="${sh.endPage}">
            <a href="<c:url value='/regist/list?page=${i}&pageSize=${sh.pageSize}'/>">${i}</a>
        </c:forEach>

        <c:if test="${sh.showNext}">
            <a href="<c:url value='/regist/list?page=${sh.endPage+1}&pageSize=${sh.pageSize}'/>">&gt;&gt;</a>
        </c:if>
    </div>
    <button id="writeBtn" type="button" onclick="location.href='<c:url value="/regist/write"/>'">글쓰기</button>
</div>

</body>
</html>
