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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootCamp.css"/>">
    <title>bootCampDetail</title>
</head>
<script>
    //231214. 정수 여기에 로그인 검사 필요해요?
    //자스 자바 둘 다 할건가..궁금..?
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
<div id="btDetailInfo">
    <div>
        <%--231214. 정수 오프라인인지 온라인인지 값 가져오고 + 제목 붙여쓰면 될듯 확인 되면 주석 지워주세요 --%>
        <%--231214. 정수 제목이 좀 밋밋한데...고민좀 확인 되면 주석 지워주세요 --%>
        <h1>오프라인&nbsp${lstRegistDto.title}</h1>
    </div>
    <hr/>
    <div>
        <input type="button" class="registeBtn"  value="수강 신청">
        <input type="button" class="modifyBtn"  value="공유 하기">
        <input type="button" class="backBtn"  value="둘러 보기">
<%--        -231214. 정수 이거 버튼 처리해주세요 ajax를 써서 넘기든지.. js로 값들을 넘기든지... 처리되면 주석 삭제--%>
            <a href="<c:url value='/btTraining/btApplication?registCode=${lstRegistDto.registCode}&title=${lstRegistDto.title}&lastPrice=${lstRegistDto.lastPrice}'/>"><button type="button">수강 신청 하기</button></a>
            <a href="<c:url value='/btTraining/list'/>"><button type="button">목록</button></a>

    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/lectureInfo.png"/>">
            <h1>강의 소개</h1>
        </div>
        <input type="text" class="btinputTxt" value="${lstRegistDto.discription}" readonly>
    </div>
    <hr/>
    <div>
        <div>
            <%--  231213 정수           이미지 없음 처리후 삭제--%>
            <img src="<c:url value="/img/lectureInfo.png"/>">
            <h1>커리큘럼</h1>
        </div>
        <%--  231213 정수           표 형식으로 데이터 받아올까? 고민 좀--%>
        <input type="text" class="btinputTxt" readonly>
    </div>
    <hr/>
    <div>
        <div>
            <%--  231213 정수           이미지 없음 처리후 삭제--%>
            <img src="<c:url value="/img/lectureInfo.png"/>">
            <h1>수강 기간</h1>
        </div>
        <input type="text" class="btinputTxt" readonly>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/lectureTime.png"/>">
            <h1>강의 시간</h1>
        </div>
        <input type="text" class="btinputTxt" readonly>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/instructorInfo.png"/>">
            <h1>강사 정보</h1>
        </div>
        <input type="text" class="btinputTxt" readonly>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/book.png"/>">
            <h1>교재(각자구입)</h1>
        </div>
        <input type="text" class="btinputTxt" value="${lstRegistDto.book}" readonly>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/materials.png"/>">
            <h1>준비물</h1>
        </div>
        <input type="text" class="btinputTxt" value="${lstRegistDto.material}" readonly>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/lastPrice.png"/>">
            <h1>비용</h1>
        </div>
        <input type="text" class="btinputTxt" value="${lstRegistDto.lastPrice}" readonly>
        <%--  231213 정수           이거는 할인 가격 컬럼으로 해서 데이터 가져올 수 있으면 처리 좀--%>
        <h2>75% 할인가</h2>
        <h3>*카드 결제, 계좌이체 가능</h3>
    </div>
    <hr/>
    <div>
        <div>
            <img src="<c:url value="/img/addr.png"/>">
            <h1>강의 장소</h1>
        </div>
        <input type="text" class="btinputTxt" value="${lstRegistDto.location}" readonly>
    </div>
</div>
<footer>
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
