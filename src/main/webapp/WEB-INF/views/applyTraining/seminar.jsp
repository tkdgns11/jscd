<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12/9/23
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>seminarDetail</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/seminar.css"/>">
</head>
<script>
    let msg = "${msg}";
    if(msg == "login required"){
        const confirmMsg = "로그인이 필요한 서비스입니다. \n로그인 하시겠습니까?";
        const confirmBoolean = confirm(confirmMsg);

        if(confirmBoolean){
            window.location.href='http://localhost:8080/member/login';
        }
    }

    if(msg == "duplicate application"){
        alert("이미 신청한 강의입니다.");
    }
</script>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>
<div id="smDetailInfo">
    <div>
        <%--231214. 정수 제목이 좀 밋밋한데...고민좀 확인 되면 주석 지워주세요 --%>
        <h1>${lstRegistDto.onOff}&nbsp${lstRegistDto.title}</h1>
    </div>
    <hr/>
    <div>
        <%--        <input type="button" class="registesmn"  value="수강 신청">--%>
        <%--        <input type="button" class="modifysmn"  value="공유 하기">--%>
        <%--        <input type="button" class="backsmn"  value="둘러 보기">--%>
        <%--        -231214. 정수 이거 버튼 처리해주세요 ajax를 써서 넘기든지.. js로 값들을 넘기든지... 처리되면 주석 삭제--%>
        <input type="button" class="registeBtn"  id="registesmn" value="수강 신청">
        <input type="button" class="modifyBtn"  value="공유 하기">
        <input type="button" class="backBtn" id="backsmn" value="둘러 보기">
    </div>
    <script>
        $(document).ready(function() {
            $("#registesmn").on("click", function() {
                location.href="<c:url value='/smTraining/smApplication?registCode=${lstRegistDto.registCode}&title=${lstRegistDto.title}&lastPrice=${lstRegistDto.lastPrice}'/>";
            });
            $("#backsmn").on("click", function() {
                location.href="<c:url value='/smTraining/list'/>";
            });
        })
    </script>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/lectureInfo.png"/>">
            <h1>강의 소개</h1>
        </div>
        <input type="text" class="sminputTxt" value="${lstRegistDto.discription}" readonly>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/curri.png"/>">
            <h1>커리큘럼</h1>
        </div>
        <%--  231213 정수           표 형식으로 데이터 받아올까? 고민 좀--%>

        <%--        일반 input형식 코드--%>
        <%--        <c:forEach var="list" items="${list}">--%>
        <%--            <input type="text" class="sminputTxt className" value="${list.className}" readonly>--%>
        <%--            &nbsp&nbsp<input type="text" class="sminputTxt category" value="${list.category}" readonly>--%>
        <%--            &nbsp&nbsp<input type="text" class="sminputTxt content" value="${list.content}" readonly>--%>
        <%--        </c:forEach>--%>
        <%--        <table border="5px" style="width:100%">--%>
        <%--        표형식 코드--%>
        <table id="smTable">
            <tr>
                <th>분류</th>
                <th>주차</th>
                <th>학습내용</th>
            </tr>
            <c:forEach var="list" items="${list}">
                <tr>
                    <td>${list.className}</td>
                    <td>${list.category}</td>
                    <td>${list.content}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/calendar.png"/>">
            <h1>수강 기간</h1>
        </div>
        <input type="text" class="Date" value="${lstRegistDto.startDate}" readonly>&nbsp&nbsp~&nbsp&nbsp
        <input type="text" class="Date" value="${lstRegistDto.endDate}" readonly>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/lectureTime.png"/>">
            <h1>강의 시간</h1>
        </div>
        <input type="text" class="sminputTxt" readonly>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/instructorInfo.png"/>">
            <h1>강사 정보</h1>
        </div>
        <input type="text" class="sminputTxt" readonly>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/book.png"/>">
            <h1>교재(각자구입)</h1>
        </div>
        <input type="text" class="sminputTxt" value="${lstRegistDto.book}" readonly>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/materials.png"/>">
            <h1>준비물</h1>
        </div>
        <input type="text" class="sminputTxt" value="${lstRegistDto.material}" readonly>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/lastPrice.png"/>">
            <h1>비용</h1>
        </div>
        <input type="text" class="sminputTxt" value="${lstRegistDto.lastPrice}" readonly>
        <h2>${lstRegistDto.discount} 할인가</h2>
        <h3>*카드 결제, 계좌이체 가능</h3>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/addr.png"/>">
            <h1>강의 장소</h1>
        </div>
        <input type="text" class="sminputTxt" value="${lstRegistDto.location}" readonly>
    </div>
</div>
<footer>
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
