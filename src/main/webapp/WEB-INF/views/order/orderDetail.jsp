<%--
주문 상세 내역 페이지 
http://localhost:8080/order/orderDetail?odNo=jscd20231212025948340
  Created by IntelliJ IDEA.
  User: soheepark
  Date: 2023/12/12
  Time: 01:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jscd.app.order.dto.StodDTO" %>
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
    <title>정석코딩 | 주문내역</title>

    <!-- css 파일 불러오기 -->
    <link rel="stylesheet" href="/css/reset.css" type="text/css"/>
    <link rel="stylesheet" href="/css/order.css" type="text/css"/>

    <!--java script 파일 불러오기-->
    <script src="/js/paySuccess.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


</head>
<body>
<div id="root">
    <header>
        <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
    </header>
    <c:forEach var="order" items="${orderDetail}">
        <div class="display-none" id="orderDetailContent">
            <p>주문번호: ${order.odNo}</p>
            <p>상품번호 : ${order.registCode}</p>
            <p>판매자번호 : ${order.slrNo}</p>
            <p class="typing-txt">For your level up !</p>
        </div>
        <main class="orderDetail_main">
            <section id="orderDetail_main-content">
                <section id="orderDetail_header">
                    <h3 class="display-none">영수증 제목</h3>
                    <div>
                        <div class="receipt-text">
                            <p class="typing" id="receipt-text-01"></p>
                            <p id="receipt-text-02">정석코딩</p>
                        </div>
                        <div id="receipt-title">구매 상세 내역</div>
                    </div>
                </section>
                <section id="orderDetail_contents">
                    <section id="orderDetail_info">
                        <h3 class="display-none">주문 정보</h3>
                        <div class="orderdetail_header" id="orderDetail_info_header">
                            <h2>주문 정보</h2>
                        </div>
                        <div id="orderDetail_info_content">
                            <table id="orderDetail_info_odNo1">
                                <tr>
                                    <td class="orderdetail_td-01">주문 번호</td>
                                    <td class="orderdetail_td-02">${order.odNo}</td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">구매 상품명</td>
                                    <td class="orderdetail_td-highlight">${order.title}</td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">상품가격</td>
                                    <td class="orderdetail_td-highlight">${order.lastPrice}</td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">구매일시</td>
                                    <td class="orderdetail_td-02">${order.regDate}</td>
                                </tr>
                            </table>
                        </div>
                    </section>
                    <section id="orderDetail_pay_info">
                        <h3 class="display-none">결제 정보</h3>
                        <div class="orderdetail_header" id="orderDetail_pay_header">
                            <h2>결제 정보</h2>
                        </div>
                        <div id="orderDetail_pay_content">
                            <table id="pay_common_content">
                                <tr>
                                    <td class="orderdetail_td-01">결제상태</td>
                                    <td class="orderdetail_td-highlight">
                                        <c:choose>
                                            <%--                          1. ${order.status} == 'paid' : 결제 완료--%>
                                            <c:when test="${order.status eq 'paid'}">결제 완료</c:when>
                                            <%--                          2.  ${order.status} == 'notPaid' : 결제 대기중--%>
                                            <c:when test="${order.status eq 'notPaid'}">결제 대기중</c:when>
                                            <%--                          3.  ${order.status} == 'cancel' : 결제 취소--%>
                                            <c:when test="${order.status eq 'cancel'}">결제 취소</c:when>
                                            <%--                          3.  나머지 값 : 해당 값 그대로 표시--%>
                                            <c:otherwise>${order.status}</c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">결제일</td>
                                    <td class="orderdetail_td-02">${order.payDay}</td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">결제시각</td>
                                    <td class="orderdetail_td-02">${order.payTime}</td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">거래종류</td>
                                    <td class="orderdetail_td-highlight">
                                        <c:choose>
                                            <%--                          1. ${order.payType} == 'card' : 카드 결제--%>
                                            <c:when test="${order.payType eq 'card'}">신용카드</c:when>
                                            <%--                          2.  ${order.payType} == '계좌이체' : 계좌이체--%>
                                            <c:when test="${order.payType eq '계좌이체'}">현금</c:when>
                                            <%--                          3.  ${order.payType} == 'kakaopay' : 결제 취소--%>
                                            <c:when test="${order.payType eq 'kakaopay'}">카카오페이</c:when>
                                            <%--                          3.  나머지 값 : 해당 값 그대로 표시--%>
                                            <c:otherwise>${order.payType}</c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">결제금액</td>
                                    <td class="orderdetail_td-highlight">${order.lastPrice}</td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-subtitle">[카드/카카오페이 결제]</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">카드사</td>
                                    <td class="orderdetail_td-02">${order.cardType}</td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">카드번호</td>
                                    <td class="orderdetail_td-02">${order.creditNum}</td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">할부개월</td>
                                    <td class="orderdetail_td-02">${order.instlFees}</td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-subtitle">[현금 결제]</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">거래자명</td>
                                    <td class="orderdetail_td-02">${order.payName}</td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">거래 은행</td>
                                    <td class="orderdetail_td-02">${order.payBank}</td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">거래 계좌번호</td>
                                    <td class="orderdetail_td-02">${order.userActNum}</td>
                                </tr>
                                <tr>
                                    <td class="orderdetail_td-01">현금영수증 번호</td>
                                    <td class="orderdetail_td-02">${order.csrcNum}</td>
                                </tr>
                            </table>
                        </div>
                    </section>
                    <section id="orderDetail_buyer_info">
                        <h3 class="display-none">구매자 정보</h3>
                        <div class="orderdetail_header" id="orderDetail_buyer_header">
                            <h2>구매자 정보</h2>
                        </div>
                        <table id="orderDetail_buyer_content">
                            <tr>
                                <td class="orderdetail_td-01">구매자명</td>
                                <td class="orderdetail_td-02">${order.name}</td>
                            </tr>
                            <tr>
                                <td class="orderdetail_td-01">회원 아이디</td>
                                <td class="orderdetail_td-highlight">${order.id}</td>
                            </tr>
                        </table>
                    </section>
                    <section id="orderDetail_seller_info">
                        <h3 class="display-none">판매자 정보</h3>
                        <div class="orderdetail_header" id="orderDetail_seller_header">
                            <h2>판매자 정보</h2>
                        </div>
                        <table id="orderDetail_seller_content">
                            <tr>
                                <td class="orderdetail_td-01">판매자명</td>
                                <td class="orderdetail_td-02">${order.slrName}</td>
                            </tr>
                            <tr>
                                <td class="orderdetail_td-01">이메일</td>
                                <td class="orderdetail_td-02">${order.slrMail}</td>
                            </tr>
                            <tr>
                                <td class="orderdetail_td-01">연락처</td>
                                <td class="orderdetail_td-02">${order.slrPhone}</td>
                            </tr>
                            <tr>
                                <td class="orderdetail_td-01">상호명</td>
                                <td class="orderdetail_td-02">${order.companyName}</td>
                            </tr>
                            <tr>
                                <td class="orderdetail_td-01">상업자등록번호</td>
                                <td class="orderdetail_td-02">${order.slrNum}</td>
                            </tr>
                            <tr>
                                <td class="orderdetail_td-01">주소</td>
                                <td class="orderdetail_td-02">${order.slrAddr}</td>
                            </tr>
                            <tr>
                                <td class="orderdetail_td-01">업태</td>
                                <td class="orderdetail_td-02">${order.indst}</td>
                            </tr>
                            <tr>
                                <td class="orderdetail_td-01">종목</td>
                                <td class="orderdetail_td-02">${order.kind}</td>
                            </tr>
                        </table>
                    </section>
                </section>
                <section id="orderDetail_btn">
                    <h3 class="display-none">주문내역 바로가기 버튼</h3>
                    <div>
                        <input class="order_btns" id="go_orderlist" type="button" value="주문내역 바로가기">
                    </div>
                    <div>
                        <input class="order_btns" id="go_mypage" type="button" value="마이페이지 바로가기">
                    </div>
                </section>
            </section>
        </main>
    </c:forEach>
    <footer>
        <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
    </footer>
</div>
</body>

</html>

