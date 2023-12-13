<%--
  Created by IntelliJ IDEA.
  User: sanghoon
  Date: 2023/12/13
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <title>정석코딩</title>
    <style>
        #content{width: 960px; height: 1080px; margin: 0 auto;}

        .title {
            width: 90px;
            height: 40px;
            background-color: #D9D9D9;
            font-weight: 700;
            line-height: 40px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin-bottom: 10px;
        }

        #teacher {
            width: 100%;
            height: 30%;
        }

        .book {
            display : flex;
            flex-wrap: nowrap;
            justify-content: space-between;
        }

        #forMargin{
            margin-right:10px;
        }
    </style>
</head>

<body>

<header>
    <jsp:include page="header.jsp"/>
</header>

<div id="content">

    <div class="title">
        <h2><strong>교육철학</strong></h2>
    </div>
    <div>
        <p>1타 강사 남궁성과 함께하는 720시간 취업 대비 부트캠프<br>
            국비지원교육 전 회차 조기마감, 프로그래밍 분야 Java 베스트셀러 작가, Java - Spring 1타 강사<br>
            성장부터 취업까지 ‘끝까지 책임’지려는 남궁 성 강사의 신념이 만들어낸 수식어입니다.<br>
            남궁 성 강사와 함께 끝없는 성장을 이루기위해 지금 당장 지원하세요!</p>
    </div>

    <img src="../img/introTeacher/main.png" alt="teacher" id="teacher">

    <div class = "book">
        <div>
            <div class="title">
                <h2><strong>원장약력</strong></h2>
            </div>
            <p>이력<br>
                前) 비트 캠프 전임강사<br>
                前) 삼성 멀티 캠퍼스 강사<br>
                前) 삼성전자 캐나다 웹 마스터<br>
                前) 삼성SDS 해외 IS실 개발팀</p>
        </div>
        <div>
            <div class="title">
                <h2><strong>대표저서</strong></h2>
            </div>
            <div class="book">
                    <span id="forMargin">
                        <img src="../img/introTeacher/jungsuk.png" alt="java">
                        <p class="jungsukText">
                        <h5 class="jungsukTitle">Java의 정석</h5><br>프로그래밍 언어 분야 스테디셀러</p>
                    </span>
                <span>
                        <img src="../img/introTeacher/cjungsuk.png" alt="c">
                        <p class="jungsukText">
                        <h5 class="jungsukTitle">C언어의 정석</h5><br>전공을 공부하는 유학생의 극찬을<br>받은 C언어의 모든것을 담은 책</p>
                    </span>
            </div>
        </div>
    </div>
</div>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>

</body>

</html>