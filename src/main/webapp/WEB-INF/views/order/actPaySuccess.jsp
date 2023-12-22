<%--
결제 완료 페이지 (계좌이체)
http://localhost:8080/order/actPaySuccess
  Created by IntelliJ IDEA.
  User: soheepark
  Date: 2023/12/10
  Time: 15:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | 결제완료</title>

    <!-- css 파일 불러오기 -->
    <link rel="stylesheet" href="/css/reset.css" type="text/css" />
    <link rel="stylesheet" href="/css/order.css" type="text/css"/>

    <!--java script 파일 불러오기-->
    <script src="/js/paySuccess.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<div id="root">
    <header class="header">
        <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
    </header>

    <%--  <h1>Payment Success</h1>--%>
    <%--  <div>Order Number: ${stodDto.odNo}</div>--%>
    <%--  <div>Registration Code: ${stodDto.registCode}</div>--%>
    <%--  <div>Title: ${stodDto.title}</div>--%>
    <%--  <div>Last Price: ${stodDto.lastPrice}</div>--%>
    <%--  --%>
    <main id="pay-success_main">
        <section id="pay-success_main-content">
            <section id="pay-success_header">
                <h3 class="display-none">수강신청 완료 안내</h3>
                <h2>수강신청 완료 안내</h2>
                <div class="boss-img_container">
                    <img id="boss_thanks" alt="very thanks photo" src="<c:url value="/img/boss_very_thanks.png"/>">
                </div>
            </section>
            <section id="pay-success_notice">
                <h3 class="display-none">수강신청 완료 상세 안내</h3>
                <p id="cash_pay_notice">* 강의 시작 하루 전 23:30까지 입금하지 않으면 주문이 취소됩니다</p>
                <p id="account_notice">입금 계좌 정보는 주문내역 우측 상단을 참고해 주세요</p>
                <div class="display-none"><p class="typing-txt">수강신청 및 결제가 완료되었습니다 :)</p></div>
                <%--        <p>수강신청 및 결제가 완료되었습니다 :)</p>--%>
                <p id="receipt-text-01"></p>
            </section>
            <section class="display-none" id="odNo_notice">
                <h3 class="display-none">주문 고유 번호</h3>
                <p>[주문번호]<br>jscd123//${orderDto.odNo}</p>
            </section>
            <section class="display-none" id="pay_info_notice">
                <h3 class="display-none">결제 정보</h3>
                <div class="pay_info_amount">
                    <span class="pay_info_amount_title">결제금액</span>
                    <span class="pay_info_amount_num-section">
                        <span class="pay_info_amount_num">500//수정필요</span>
                        <span class="pay_info_amount_unit">원</span>
                    </span>
                </div>
                <div class="pay_info_type">
                    <span class="pay_info_type_title">결제수단</span>
                    <span class="pay_info_type_showType">계좌이체</span>
                </div>
            </section>
            <section class="display-none" id="pay-success_lecture_notice">
                <h3 class="display-none">주문 강의 정보</h3>
                <div>
                    <span class="pay-success_lecture_notice_title">주문 강의명</span>
                    <span class="pay-success_lecture_notice_lecture-title">리눅스//수정필요</span>
                </div>
            </section>
            <section id="goLink_btns">
                <h3 class="display-none">바로가기 버튼</h3>
                <div>
                    <input class="order_btns" id="go_orderlist" type="button" value="주문내역 바로가기">
                </div>
                <div>
                    <input class="order_btns" id="go_mypage" type="button" value="마이페이지 바로가기">
                </div>
            </section>
        </section>
    </main>
    <footer class="footer">
        <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
    </footer>
</div>
</body>

</html>
