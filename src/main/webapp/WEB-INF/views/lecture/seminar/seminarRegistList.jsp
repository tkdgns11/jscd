<%--    작성일 : 2023-11-17--%>
<%--    작성자 : 장용호--%>
<%--    작성 기능 : 세미나 등록 게시판(관리자)--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<%--    <link rel="stylesheet" type="text/css" href="<c:url value='/css/reset.css'/>">--%>
    <title>정석코딩 세미나 등록</title>
    <style>
        #seminarRegistListAll{
            width: 960px;
            height: 1080px;
            margin: 0 auto;
        }
        #seminarRegistFont{
            margin-bottom: 30px;
            padding: 30px 30px;
            text-align: center;
            background-color: #182566;
            color: #05CE31;

            font-size: 50px;
            font-weight: 600;
        }
        #seminarRegistNaviHead{
            margin: 0 auto;
            padding-top: 10px;
            text-align: center;
            width: 300px;
            height: 40px;
            border: 1px solid black;
            font-size: 25px;
            font-weight: 600;
        }
        #seminarRegistNaviHead a{
            font-size: 25px;
            font-weight: 600;
            text-decoration: none;
            color: black;
        }
        #seminarFont{
            margin-top: 80px;
            margin-bottom: -30px;
            font-size: 40px;
        }
        #seminarRegistHead{
            float: right;
        }
        #seminarRegistHead select{
            width: 80px;
            height: 20px;
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
            font-weight: 700;
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
        .seminarRegistTr a{
            text-decoration: none;
            color: black;
        }
        .seminarRegistTr a:hover{
            background-color: rgba(0,0,0,0.15);
        }
        #seminarRegistNaviFoot{
            text-align: center;
            margin-top: 15px;
            font-size: 18px;
            font-weight: 700;
        }
        #seminarRegistNaviFoot a{
            text-decoration: none;
            color: black;
        }
        #seminarRegistNaviFoot a:hover{
            background-color: rgba(0,0,0,0.15);
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
<script>
    let msg = "${msg}";
    if(msg=="WRT_OK") alert("성공적으로 등록되었습니다.");
    if(msg=="DEL_OK") alert("성공적으로 삭제되었습니다.");
    if(msg=="MOD_OK") alert("성공적으로 수정되었습니다.");
    if(msg=="DEL_ERR") alert("삭제에 실패했습니다.");
</script>
<h1 id="seminarRegistFont">/* 정석코딩 세미나 등록 */</h1>

<div id="seminarRegistNaviHead">
    <a href="">부트캠프 &emsp;</a>|
    <a href="<c:url value='/regist/list'/>"> &emsp;세미나</a>
</div>

<div id="seminarRegistListAll">

    <h2 id="seminarFont">세미나</h2>

    <%--    검색    --%>
        <form id="seminarRegistHead" action="<c:url value="/regist/list"/>" method="get">
            <select name="option">
                <option >전체</option>
                <option >제목</option>
                <option >작성자</option>
            </select>
            <input type="text"  name="keyword" value="" placeholder="검색어를 입력해주세요.">
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
    <div id="seminarRegistNaviFoot">
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
    <button id="writeBtn" type="button" onclick="location.href='<c:url value="/regist/write?page=${page}&pageSize=${pageSize}"/>'">글쓰기</button>
</div>

</body>
</html>
