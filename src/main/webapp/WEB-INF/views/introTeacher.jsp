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
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/reset.css'/>">
    <title>정석코딩</title>
    <style>
        #content {
            width: 960px;
            height: 1080px;
            margin: 0 auto;
        }

        .title {
            width: 90px;
            height: 40px;
            background-color: #D9D9D9;
            font-weight: 700;
            line-height: 40px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin-bottom: 30px;
            margin-top: 40px;
        }

        #teacher {
            width: 100%;
            height: 450px;
            object-fit: cover;
        }

        .book {
            display: flex;
            flex-wrap: nowrap;
            justify-content: space-between;
            margin-top: -170px;
        }
        .book2{
            display: flex;
            flex-wrap: nowrap;
            justify-content: space-between;
            line-height: 110%;
        }

        #forMargin {
            margin-right: 25px;
        }

        .jcImg {
            object-fit: cover;
            filter: drop-shadow(10px 8px 6px #c3c3c3);
            top:50%
        }

        .jungsukTitle {
            margin-top: 5px;
            font-weight: 600;
        }

        #teacherDesc {
            margin-bottom: 20px;
            margin-left: 5px;
            line-height: 140%;

        }

        #teacherDesc2 {
            margin-top: -400px;
            margin-bottom: 200px;
            margin-left: 30px;
            line-height: 140%;
        }

        .descWeight {
            font-weight: 740;
        }

        .jungsukText {

        }
    </style>
</head>

<body>

<header>
    <jsp:include page="header.jsp"/>
</header>

<div id="content">

    <div class="title">
        <h2><strong>교육 철학</strong></h2>
    </div>
    <div id="teacherDesc">
        <p>1타 강사 남궁성과 함께하는 720시간 취업 대비 부트캠프<br>
            국비지원교육 전 회차 조기마감, 프로그래밍 분야 Java 베스트셀러 작가, Java - Spring 1타 강사<br>
            성장부터 취업까지 ‘끝까지 책임’지려는 남궁 성 강사의 신념이 만들어낸 수식어입니다.<br>
            남궁 성 강사와 함께 끝없는 성장을 이루기위해 지금 당장 지원하세요!</p>
    </div>

    <div>
        <img src="../img/introTeacher/main.png" alt="teacher" id="teacher">
    </div>
    <div id="teacherDesc2">

        <p>많은 학생들을 가르치며 ‘우보만리’라는 말을 강조했었습니다.<br>
            <span class="descWeight">프로그래밍 실력은 하루 아침에 늘지 않습니다.<br>
        어렵고 힘들더라도 묵묵히 그 길을 가야 합니다.</span><br>
            <br>
            저는 어렵고 힘든 걸 쉽고 편하다고 눈속임 하지 않습니다.<br>
            대신 선배로서, 교육자로서 책임감을 갖고 앞에서 이끌고 뒤에서 밀어드립니다.<br>
            <br>
            제 강의를 듣는 분들은 끝까지 제 제자들이고 소중한 동료들입니다.<br>
            이번 캠프에서 현장에서 쓰이는 코드와 제 경험들,<br>
            성공적인 팀프로젝트 진행 방법, 완성도 높은 포트폴리오 준비법까지<br>
            <span class="descWeight">제가 20년 간 쌓은 노하우를 아낌없이 알려드리겠습니다.<br>
            <br>
    ‘개발 공부, 끝까지 간다!’는 마음과 다짐으로<br>
    저 남궁성과 함께 누구보다 열정적으로 보낼 분들을 기다립니다.</span><br>
            <br>
            by. 남궁성</p>
    </div>

    <div class="book">
        <div>
            <div class="title">
                <h2><strong>원장 약력</strong></h2>
            </div>
            <p style="line-height: 130%">
                前) 비트 캠프 전임강사<br>
                前) 삼성 멀티 캠퍼스 강사<br>
                前) 삼성전자 캐나다 웹 마스터<br>
                前) 삼성SDS 해외 IS실 개발팀</p>
        </div>
        <div>
            <div class="title">
                <h2><strong>대표 저서</strong></h2>
            </div>
            <div class="book2">
                    <span id="forMargin">
                        <img src="../img/introTeacher/jungsuk.png" alt="java" class="jcImg">
                        <p class="jungsukText">
                        <h5 class="jungsukTitle">- Java의 정석</h5><br>
                        프로그래밍 언어 분야 스테디셀러</p>
                    </span>
                     <span>
                        <img src="../img/introTeacher/cjungsuk.png" alt="c" class="jcImg">
                        <p class="jungsukText">
                        <h5 class="jungsukTitle" style="margin-top: 13px">- C언어의 정석</h5>
                    <br>전공을 공부하는 유학생의 극찬을<br>받은 C언어의 모든것을 담은 책</p>
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