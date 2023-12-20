<%--
실결제 진행 페이지
http://localhost:8080/order/order?registCode=2
  Created by IntelliJ IDEA.
  User: soheepark
  Date: 2023/11/22
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.jscd.app.order.dto.OrderDTO" %>
<% OrderDTO orderDto = (OrderDTO) request.getAttribute("orderDto"); %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/logo.png"/>
    <link rel="apple-touch-icon" href="/img/logo.png"/>
    <title>정석코딩 | 결제</title>

    <!-- css 파일 불러오기 -->
    <link rel="stylesheet" href="/css/reset.css" type="text/css"/>
    <link rel="stylesheet" href="/css/order.css" type="text/css"/>

    <%--폰트어썸 라이브러리 불러오기--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!--java script 파일 불러오기-->
    <script src="/js/order.js"></script>
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <!-- iamport.payment.js -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
    <!-- iamport.payment.reponse.js -->
    <script type="text/javascript" src="https://cdn.iamport.kr/v1/iamport.js"></script>
</head>
<body>
<div id="root">
    <header class="header">
        <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
    </header>
    <form id="orderData" action="/actPaySuccess" method="post">
        <input type="hidden" id="odNo" name="odNo">
        <input type="hidden" id="id" name="id" value="${memberDto.id}">
        <input type="hidden" id="name" name="name" value="${memberDto.name}">
        <input type="hidden" id="phone" name="phone" value="${memberDto.phone}">

        <input type="hidden" id="registCode" name="registCode" value="${orderDto.registCode}">
        <input type="hidden" id="title" name="title" value="${orderDto.title}">
        <input type="hidden" id="lastPrice" name="lastPrice" value="${orderDto.lastPrice}">
        <input type="hidden" id="startDate" name="startDate" value="${orderDto.startDate}">
        <input type="hidden" id="endDate" name="endDate" value="${orderDto.endDate}">

        <input type="hidden" id="slrNo" name="slrNo" value="${companyInfoDto.slrNo}">
        <input type="hidden" id="slrName" name="slrName" value="${companyInfoDto.slrName}">
        <input type="hidden" id="slrNum" name="slrNum" value="${companyInfoDto.slrNum}">
        <input type="hidden" id="actName" name="actName" value="${companyInfoDto.actName}">
        <input type="hidden" id="actNum" name="actNum" value="${companyInfoDto.actNum}">
        <input type="hidden" id="slrAddr" name="slrAddr" value="${companyInfoDto.slrAddr}">
        <input type="hidden" id="companyName" name="companyName" value="${companyInfoDto.companyName}">
        <input type="hidden" id="indst" name="indst" value="${companyInfoDto.indst}">
        <input type="hidden" id="kind" name="kind" value="${companyInfoDto.kind}">
        <input type="hidden" id="slrPhone" name="slrPhone" value="${companyInfoDto.slrPhone}">

        <%--  추가--%>
        <input type="hidden" id="creditNum" name="creditNum">
        <input type="hidden" id="cardType" name="cardType">
        <input type="hidden" id="payType" name="payType">
        <input type="hidden" id="payDay" name="payDay">
        <input type="hidden" id="payTime" name="payTime">
        <input type="hidden" id="status" name="status">
        <input type="hidden" id="instlFees" name="instlFees">
    </form>
    <main id="pay_main">
        <section class="pay-info">
            <h1 class="pay-info_header">결제하기</h1>
            <section class="pay-info_body-wrapper">
                <section>
                    <h2 class="display-none">강의 리스트</h2>
                    <div class="order_list">
                        <div class="section_lecture_info">
                            <div class="section_lecture-title_info">
                                <div class="lecture-title_info">주문 강의</div>
                                <div class="lecture-title">${orderDto.title}</div>
                            </div>
                            <div class="section_lecture-date_info">
                                <div class="lecture-date_start">
                                    <span class="lecture-date_start_title">강의 시작일</span>
                                    <span class="lecture-date_start_day">${orderDto.startDate}</span>
                                </div>
                                <div class="lecture-date_end">
                                    <span class="lecture-date_end_title">강의 종료일</span>
                                    <span class="lecture-date_end_day">${orderDto.endDate}</span>
                                </div>
                            </div>
                            <div class="section_lecture-price_info">
                                <div class="lecture-price_title">주문 금액</div>
                                <div class="lecture-price">
                                        <span class="lecture-price-num">
                                            <c:if test="${orderDto != null && orderDto.registCode == pageScope.registCode}">
                                                <fmt:formatNumber type="number" value="${orderDto.lastPrice}" pattern="#,##0" />
                                            </c:if>
                                        </span>
                                    <span class="lecture-price-unit">원</span>
                                </div>
                            </div>
                        </div>
                        <div class="section_howpay">
                            <h2>결제 방법</h2>
                            <span>아래 결제 방법 중 하나를 선택해주세요</span>
                            <div id="payBtns">
                                <!-- 각 결제 API 사용 -->
                                <input type="button" class="order_btns" id="card" value="카드 결제">
                                <!-- 계좌 이체 : shwAcnNmb -> display : block -->
                                <input type="button" class="order_btns" id="account" value="계좌 이체">
                                <input type="button" class="order_btns" id="kakaopay" value="카카오페이 결제">
                            </div>
                            <!-- 계좌 이체 x -> display : none -->
                            <div id="shwAcnNmb">
                                <div class="cash-payment_notice">
                                    <span>* 강의 시작 하루 전 23:30까지 입금하지 않으면 주문이 취소됩니다.</span>
                                </div>
                                <div id="AcnNmbTable">
                                    <table>
                                        <tr class="tableText">
                                            <td>예금주</td>
                                            <td id="slrName2">${companyInfoDto.slrName}</td>
                                        </tr>
                                        <tr class="tableText">
                                            <td>입금 은행</td>
                                            <td id="slrAct">${companyInfoDto.actName}</td>
                                        </tr>
                                        <tr class="tableText">
                                            <td>입금 계좌번호</td>
                                            <td id="slrActNum">${companyInfoDto.actNum}</td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="AcnCopyBtn">
                                    <input type="button" class="order_btns" id="copyBtn" value="계좌번호 복사">
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </section>
        </section>
        <aside class="aside_pay" id="aside_pay">
            <h2 class="display-none">결제 정보</h2>
            <section class="section_buyer-info">
                <div class="buyer-info">
                    <div class="buyer-info_header">
                        <span class="buyer-info_title>">구매자정보</span>
                        <input class="order_btns" type="button" value="수정">
                    </div>
                    <div class="buyer-info_list">
                        <div>
                            <dt>이름</dt>
                            <dd>${memberDto.name}</dd>
                        </div>
                        <div>
                            <dt>이메일</dt>
                            <dd>${memberDto.id}</dd>
                        </div>
                        <div>
                            <dt>휴대폰 번호</dt>
                            <dd>${memberDto.phone}</dd>
                        </div>
                    </div>
                </div>
            </section>
            <section class="aside_pay-info">
                <div class="price-info-sticker">
                    <h3 class="display-none">주문정보</h3>
                    <div class="price-info">
                        <div class="price-pay">
                            <span>총 결제금액</span>
                            <div class="price-pay-num-unit">
                                <div class="price-pay-num">
                                    <c:if test="${orderDto != null && orderDto.registCode == pageScope.registCode}">
                                        <fmt:formatNumber type="number" value="${orderDto.lastPrice}" pattern="#,##0" />
                                    </c:if>
                                </div>
                                <div class="price-pay-unit">원</div>
                            </div>
                        </div>
                        <input class="order_btns" id="price-btn" type="button" value="결제하기">
                    </div>
                    <div class="terms-agreement">
                        <div>
                            <div class="terms-agreement_text-agreement">
                                회원 본인은 주문내용을 확인했으며,
                                <span class="e-open-terms" type="button">구매조건 및 개인정보처리방침</span>
                                과 결제에 동의합니다.
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <input class="order_btns" id="goQna" type="button" value="   Q&A 바로가기">
            <footer class="bottom-fixed">
                <div class="bottom-fixed_price">
                    <span class="bottom-fixed_pay-num">
                        <c:if test="${orderDto != null && orderDto.registCode == pageScope.registCode}">
                            <fmt:formatNumber type="number" value="${orderDto.lastPrice}" pattern="#,##0" />
                        </c:if>
                    </span>
                    <span class="bottom-fixed_pay-unit">원</span>
                </div>
            </footer>
        </aside>
    </main>
    
</div>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</body>



</html>
