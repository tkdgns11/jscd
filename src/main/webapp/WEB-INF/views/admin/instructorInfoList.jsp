<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>강사 정보 관리</title>
    <style>
        *{
            text-decoration: none;
            font-family: IBM Plex Sans KR;

        }
        table, td, th {
            border-top : 1px solid black;
            border-bottom: 1px solid black;
            border-collapse : collapse;
            text-align: center;
        }
        #searchBtn{
            width: 100px;
            height: 30px;
            border-radius: 20px;
            border: 0;
            color: white;
            background-color: #18214F;
        }
        #searchBtn:hover{background-color: #bebebe;
        }
        #infoListBox{
            position: relative;

        }
        #infoListTitle{
            position: absolute;
            margin-left:400px;
        }
        #selectList{
            height: 30px;
        }
        #keywordInput{
            height: 25px;
        }
        #choiceBox{
            position:absolute;
            margin-left: 650px;
            top: 280px;
        }
        #infoListTable{
            position: absolute;
            margin-left: 220px;
            top: 350px;
        }
        #infoNav{
            position: absolute;
            margin-left:400px;
            top: 750px;
        }
        .thInput{
            width:40px;
        }
    </style>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Noto+Serif+KR:wght@900&display=swap" rel="stylesheet">
</head>
<script>
    let msg = "${param.msg}";
    if(msg=="MOD_OK")    alert("성공적으로 수정되었습니다.");
    if(msg=="LIST_ERR")  alert("강사 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
</script>
<body>

<div id="infoListBox" style="width: 960px;height: 700px;">
    <div id="infoListTitle">
        <h1>강사 정보 관리</h1>
    </div>

    <div id="choiceBox">
        <form action="/instructor/list" method="get";>
            <select name="option" id="selectList">
                <option value="T" ${sc.option=='T' || sc.option=='' ? "selected" : ""}>이름</option>
                <option value="W" ${sc.option=='W' || sc.option=='' ? "selected" : ""}>아이디</option>
                <option value="R" ${sc.option=='R' || sc.option=='' ? "selected" : ""}>상태</option>
            </select>

            <input type="text" name="keyword" type="text" value="${param.keyword}" id="keywordInput" placeholder="검색어를 입력해주세요">
            <button id="searchBtn">검색</button>

        </form>
    </div>

    <div id="infoListTable">
    <table>
        <tr>
            <th><input type="checkbox" class="thInput"></th>
            <th>No.</th>
            <th style="width: 80px;">아이디</th>
            <th style="width: 80px;">이름</th>
            <th style="width: 150px;">폰번호</th>
            <th style="width: 80px;">상태</th>
            <th style="width: 200px;">가입일</th>
        </tr>
        <c:forEach var="instructorDto" items="${list}">
            <tr>
                <td><input type="checkbox" class="thInput"></td>
                <td>${instructorDto.iscrNo}</td>
                <td>${instructorDto.id}</td>
                <td>
                    <a href="<c:url value="/instructor/read?page=${sc.page}&iscrNo=${instructorDto.iscrNo}"/>">${instructorDto.name}</a>
                </td>
                <td>${instructorDto.phone}</td>
                <td>${instructorDto.status}</td>
                <td><fmt:formatDate value="${instructorDto.regDate}" pattern="yyyy-MM-dd" type="date"/></td>
            </tr>
        </c:forEach>
    </table>
        </div>


    <div id="infoNav">
        <c:if test="${page.totalCnt==null || page.totalCnt==0}">
                    게시물이 없습니다.
                </c:if>

                <c:if test="${page.totalCnt!=null && page.totalCnt!=0}">
                    <p>
                    <c:if test="${page.showPrev}">
                        <a href="<c:url value="/instructor/list${sc.getQueryString(page.beginPage-1)}"/>">&lt;</a>
                    </c:if>
                    <c:forEach var="i" begin="${page.beginPage}" end="${page.endPage}">
                        <a href="<c:url value="/instructor/list${sc.getQueryString(i)}"/>">${i}</a>
                    </c:forEach>
                    <c:if test="${page.showNext}">
                        <a href="<c:url value="/instructor/list${sc.getQueryString(page.endPage+1)}"/>">&gt;</a>
                    </c:if>
                    </p>
                </c:if>
            </div>
        </div>


</body>
</html>
