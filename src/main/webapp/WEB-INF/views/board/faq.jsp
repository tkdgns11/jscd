<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2023. 12. 12.
  Time: 오후 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/faq.css">
    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | FAQ</title>
  <link rel="stylesheet" href="<c:url value='/css/noticeList.css'/>">
  <script type="text/javascript" src="<c:url value="/js/board_nav.js"/>"></script>
    <%--폰트어썸 라이브러리 불러오기--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>
<main>
    <section id="boardList_header">
        <div>
            <h1>FAQ</h1>
            <h3>자주 묻는 질문들을 확인해보세요 !</h3>
        </div>
    </section>
    <section id="boardList_content">
        <div id="boardList_nav">
            <ul>
                <li><a href="<c:url value="/board/user/list"/>">
                    <i class="fa-solid fa-bullhorn" style="color: #73b4f0;"></i>
                    &nbsp;&nbsp;공지사항</a></li>
                <li><a href="<c:url value="/board/qna/allqnaList"/>">
                    <i class="fa-solid fa-comment-dots" style="color: #73b4f0;"></i>
                    &nbsp;&nbsp;질문&답변</a></li>
                <li><a href="<c:url value="/board/faq"/>">
                    <i class="fa-solid fa-circle-question" style="color: #73b4f0;"></i>
                    &nbsp;&nbsp;Faq</a></li>
            </ul>
        </div>
      <div id="qna_main">
        <div class="innerbox">
            <div id="pink1">
                <div id="pink1hd">// 정석코딩 부트캠프 주교재</div>
                <div id="pink1bd">
                    <div id="bookimg"><img src="/img/javabook.jpg"></div>
                    <div id="letters"><a href="https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=76083001">
                        <div id="fstLt">Java의 정석</div>
                        <div id="scdLt">(저자 남궁성)</div>
                    </a></div>
                </div>
            </div>
            <div id="pink2">
                <div id="pink2hd">// Java의 정석 온라인 강의</div>
                <div id="pink2bd">
                    <div id="utblink">
                        <iframe width="560" height="315"
                                src="https://www.youtube.com/embed/oJlCC1DutbA?si=_IHvkAgVSV2pP5uE"
                                title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope;
                picture-in-picture; web-share" allowfullscreen></iframe>
                    </div>
                    <div><a href="https://www.youtube.com/watch?v=oJlCC1DutbA&list=PLW2UjW795-f6xWA2_MUhEVgPauhGl3xIp">유튜브
                        바로가기</a></div>
                </div>
            </div>
            <div id="blue1">
                <div id="blue1hd">Q. 매달 보는 테스트는 어떤 것인가요?</div>
                <div id="blue1bd">한 달 동안 배운 내용을 테스트합니다.<br><br>
                    (테스트 형식 : 주관식, 손 코딩)<br><br>
                    한 달 동안 열심히 (하루 14시간 이상) 하셨으면<br><br>
                    대부분 통과할 수준의 문제들입니다.
                </div>
            </div>
            <div id="blue2">
                <div id="blue2hd">Q. 국비와 다른 점이 무엇인가요?</div>
                <div id="blue2bd">강의 퀄리티, 학습 방법 및 관리, 상담 퀄리티에서<br><br>
                    많은 차이를 보입니다.<br><br>
                    학습 환경 및 시설 또한 저희 학원이 우세합니다.<br><br>
                    국비를 경험해 보지 못하신 분들은 검색해 보시거나<br><br>
                    며칠이라도 다녀오실 것을 권해드립니다.
                </div>
            </div>
        </div>

        <div id="curriculum">
            <div id="imgboxNavi">
                <div id="buttons">
                    <span id="circle1" style="color: #FF5F57">●</span>
                    <span id="circle2" style="color: #FEBC2E">●</span>
                    <span id="circle3" style="color: #28C840">●</span>
                </div>
                <div id="btmletter">정석코딩 부트캠프 커리큘럼</div>

            </div>
            <div id="imgbox"><img src="/img/curriculum.png"></div>
        </div>
      </div>
    </section>
</main>
<footer>
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
