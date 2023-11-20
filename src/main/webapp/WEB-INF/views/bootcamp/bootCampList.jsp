<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>정석코딩 부트캠프 등록</title>
    <style>
        #bootcampRegistBoard{
            width: 960px;
            height: 1080px;
            margin: 0 auto;
        }
        #bootcampRegistBoard a{
            text-decoration: none;
            color: black;
        }
        #bootcampRegistBoard a:hover{
            background-color: rgba(0,0,0,0.15);
        }
        #bootcampFont{
            margin-bottom: -30px;
            font-size: 40px;
        }
        #bootcampRegistHead{
            float: right;
        }
        #bootcampRegistSel{
            width: 80px;
            height: 25px;
            border-radius: 10px;
            color: white;
            background-color: #182566;
        }
        #bootcampRegistTable{
            width: 100%;
            border-top: 2px groove black;
            border-collapse: collapse;
            text-align: center;
            font-weight: 900;
        }
        .bootcampRegistTr, .bootcampRegistTd{
            padding: 10px;
            margin-right: -10px;
            border-bottom: 1px groove gray;
        }
        .bootcampRegistTh{
            padding: 10px;
            border-bottom: 1px groove gray;
        }
        .bootcampRegistTr:nth-child(1){
            background-color: #182566;
            color: white;
        }
        #bootcampRegistNavi{
            text-align: center;
            margin-top: 15px;
            font-size: 18px;
            font-weight: 900;
        }
        #bootcampRegistNavi a{
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

<div id="bootcampRegistBoard">

    <h2 id="bootcampFont">세미나</h2>

    <%--    검색    --%>
    <form id="bootcampRegistHead" action="" method="get">
        <select>
            <option>전체</option>
            <option>제목</option>
            <option>작성자</option>
        </select>
        <input type="text" placeholder="검색어를 입력해주세요.">
        <input id="bootcampRegistSel" type="submit" class="" value="검색">
    </form>

    <%--    게시판    --%>
    <table id="bootcampRegistTable">
        <tr class="bootcampRegistTr">
            <th class="bootcampRegistTh">No.</th>
            <th class="bootcampRegistTh">제목</th>
            <th class="bootcampRegistTh">작성자</th>
            <th class="bootcampRegistTh">작성시간</th>
            <th class="bootcampRegistTh">조회수</th>
        </tr>
        <c:forEach var="bootcampRegistDto" items="${list}">
            <tr class="bootcampRegistTr">
                <td class="bootcampRegistTd">${bootcampRegistDto.classEnrollNo}</td>
                <td class="bootcampRegistTd"><a href="<c:url value='/regist/read?classEnrollNo=${bootcampRegistDto.classEnrollNo}&page=${page}&pageSize=${pageSize}'/>">${bootcampRegistDto.title}</a></td>
                <td class="bootcampRegistTd">${bootcampRegistDto.writer}</td>
                <td class="bootcampRegistTd"><fmt:formatDate value="${bootcampRegistDto.regDate}" pattern="yyyy.MM.dd"/> </td>
                <td class="bootcampRegistTd">${bootcampRegistDto.viewCnt}</td>
            </tr>
        </c:forEach>
    </table>

    <%--    내비게이션   --%>
    <div id="bootcampRegistNavi">
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
