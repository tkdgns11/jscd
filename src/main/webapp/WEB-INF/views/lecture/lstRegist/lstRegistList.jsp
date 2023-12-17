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
    <title>정석코딩 강의 등록</title>
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <style>
        #registListAll{
            width: 960px;
            height: 1080px;
            margin: 0 auto;
        }
        #registHeadFont{
            margin-bottom: 30px;
            padding: 30px 30px;
            text-align: center;
            background-color: #182566;
            color: #05CE31;
            font-size: 50px;
            font-weight: 600;
        }
        #registNaviHead{
            margin: 0 auto;
            padding-top: 10px;
            text-align: center;
            width: 300px;
            height: 40px;
            border: 1px solid black;
            font-size: 25px;
            font-weight: 600;
        }
        #registNaviHead a{
            font-size: 25px;
            font-weight: 600;
            text-decoration: none;
            color: black;
        }
        #registBoard a{
            text-decoration: none;
            color: black;
        }
        #registBoard a:hover{
            background-color: rgba(0,0,0,0.15);
        }
        #registFont{
            margin-top: 80px;
            margin-bottom: -30px;
            font-size: 40px;
        }
        #registHead{
            float: right;
        }
        #registHead select{
            width: 80px;
            height: 20px;
        }
        #registSel{
            width: 80px;
            height: 25px;
            border-radius: 10px;
            color: white;
            background-color: #182566;
        }
        #registTable{
            width: 100%;
            border-top: 2px groove black;
            border-collapse: collapse;
            text-align: center;
            font-weight: 700;
        }
        .registTr, .registTd{
            padding: 10px;
            margin-right: -10px;
            border-bottom: 1px groove gray;
        }
        .registTh{
            padding: 10px;
            border-bottom: 1px groove gray;
        }
        .registTr:nth-child(1){
            background-color: #182566;
            color: white;
        }
        #registNaviFoot{
            text-align: center;
            margin-top: 15px;
            font-size: 18px;
            font-weight: 700;
        }
        #registNavi a{
            padding-right: 5px;
        }
        #writeBtn{
            float: right;
            margin-top: -25px;
            width: 90px;
            height: 25px;
            border-radius: 10px;
            color: white;
            background-color: #182566;
        }
        a {
            text-decoration: none;
            color: #182566;
        }
    </style>
</head>
<body>
<h1 id="registHeadFont">/* 정석코딩 강의 등록 */</h1>

<div id="registNaviHead">
    <a href="<c:url value=''/>">부트캠프</a> |
    <a href="<c:url value=''/>"> &emsp;세미나</a>
</div>
<script>
    let msg = "${msg}";
    if(msg == "DEL_ERR") alert("삭제되었거나 없는 게시물입니다.");
    if(msg == "DEL_OK") alert("성공적으로 삭제되었습니다.");
    if(msg == "WRT_OK") alert("성공적으로 등록되었습니다.");
    if(msg == "MOD_OK") alert("해당 게시물을 정상적으로 수정하였습니다.");
</script>
<div id="registListAll">

    <h2 id="registFont">강의 목록</h2>

    <%--    검색    --%>
    <form id="registHead" action="" method="get">
        <select class="search-option" name="option">
            <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
            <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
            <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
        </select>
        <input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}" placeholder="검색어를 입력해주세요">
        <input type="submit" class="search-button" value="검색">
    </form>

    <%--    게시판    --%>
    <table id="registTable">
        <tr class="registTr">
            <th class="registTh">No.</th>
            <th class="registTh">제목</th>
<%--            <th class="registTh">작성자</th>--%>
            <th class="registTh">작성시간</th>
        </tr>
        <c:forEach var="list" items="${list}">
            <tr class="registTr">
                <td class="registTd">${list.registCode}</td>
<%--                <td class="registTd"><a href="<c:url value='/onlyAdmin/lstRegist/detailRegist${ph.sc.queryString}&registCode=${list.registCode}'/>">${list.title}</a></td>--%>
                <td class="registTd"><a href="<c:url value='/lstRegist/detailRegist${ph.sc.queryString}&registCode=${list.registCode}'/>">${list.title}</a></td>
                <td class="registTd">${list.regDate} </td>
            </tr>
        </c:forEach>
    </table>

    <%--    내비게이션   --%>
    <div id="registNaviFoot">
        <c:if test="${totalCnt==null || totalCnt==0}">
            <div> 게시물이 없습니다. </div>
        </c:if>
        <c:if test="${totalCnt!=null && totalCnt!=0}">
            <c:if test="${ph.showPrev}">
<%--                <a class="page" href="<c:url value='/onlyAdmin/lstRegist/list${ph.sc.getQueryString(ph.beginPage-1)}'/>">&lt;</a>--%>
                <a class="page" href="<c:url value='/lstRegist/list${ph.sc.getQueryString(ph.beginPage-1)}'/>">&lt;</a>
            </c:if>
            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
<%--                <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value='/onlyAdmin/lstRegist/list${ph.sc.getQueryString(i)}'/>">${i}</a>--%>
                <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value='/lstRegist/list${ph.sc.getQueryString(i)}'/>">${i}</a>
            </c:forEach>
            <c:if test="${ph.showNext}">
<%--                <a class="page" href="<c:url value='/onlyAdmin/lstRegist/list${ph.sc.getQueryString(ph.endPage+1)}'/>">&gt;</a>--%>
                <a class="page" href="<c:url value='/lstRegist/list${ph.sc.getQueryString(ph.endPage+1)}'/>">&gt;</a>
            </c:if>
        </c:if>
    </div>
<%--    <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/onlyAdmin/lstRegist/addRegist"/>'">강의 추가하기</button>--%>
    <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/lstRegist/addRegist"/>'">강의 추가하기</button>
</div>
</body>
</html>
