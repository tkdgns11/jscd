<%--
  Created by IntelliJ IDEA.
  User: soheepark
  Date: 2023/12/20
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jscd.app.order.dto.StodDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>정석코딩 | 강의 신청 현황</title>

    <!-- css 파일 불러오기 -->
    <link rel="stylesheet" href="/css/reset.css" type="text/css"/>
    <link rel="stylesheet" href="/css/lectureApplyState.css" type="text/css"/>

    <!--java script 파일 불러오기-->
    <script src="/js/orderList.js"></script>
    <script src="/js/applyStatPay.js"></script>


    <%--폰트어썸 라이브러리 불러오기--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
</header>
<div id="root">

    <%--<c:forEach items="${orderList}" var="order">--%>
    <main id="main_orderlist">
        <%--        <div id="main_orderlist_contents">--%>
        <section id="section_orderlist">
            <section id="section_orderlist_title">
                <div>
                    <h2>내 강의 신청 현황</h2>
                </div>
            </section>
            <c:forEach items="${orderList}" var="order">
                <c:if test="${order.status eq 'paid' or order.status eq 'notPaid'}">
                    <section id="section_orderlist_contents">
                        <div id="orderlist_content">
                            <div id="orderlist_content-title"
                                 class="<c:choose>
                    <c:when test="${order.status eq 'paid'}">paid</c:when>
                    <c:when test="${order.status eq 'notPaid'}">notPaid</c:when>
                    <c:when test="${order.status eq 'cancel'}">cancel</c:when>
                </c:choose>">
                                <div>
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
                                </div>
                            </div>
                            <div id="orderlist_content-info">
                                <div>
                                    <table id="order_date">
                                        <tr>
                                            <td class="order_date_title">주문일시</td>
                                            <td>${order.regDate}</td>
                                        </tr>
                                        <tr>
                                            <td class="order_date_title">주문번호</td>
                                            <td>${order.odNo}</td>
                                        </tr>
                                    </table>
                                </div>
                                <div id="order_content">
                                    <div id="order_state_photo">
                                        <div>
                                            <c:choose>
                                                <%--                          1. ${order.status} == 'paid' : 결제 완료--%>
                                                <c:when test="${order.status eq 'paid'}">
                                                    <div id="img_paid_hover">
                                                        <img class="pay_img" id="img_paid" alt="payment status is paid"
                                                             src="<c:url value="/img/paid.png"/>">
                                                    </div>
                                                </c:when>
                                                <%--                          2.  ${order.status} == 'notPaid' : 결제 대기중--%>
                                                <c:when test="${order.status eq 'notPaid'}">
                                                    <img class="pay_img" id="img_not-paid" alt="payment status is not paid"
                                                         src="<c:url value="/img/notPaid.png"/>">
                                                </c:when>
                                                <%--                          3.  ${order.status} == 'cancel' : 결제 취소--%>
                                                <c:when test="${order.status eq 'cancel'}">
                                                    <img class="pay_img" id="img_pay-cancel" alt="payment status is cancel"
                                                         src="<c:url value="/img/pay_cancel.png"/>">
                                                </c:when>
                                                <%--                          3.  나머지 값 : 해당 값 그대로 표시--%>
                                                <c:otherwise>${order.status}</c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <div id="orderlist_info">
                                        <div>
                                            <div id="orderlist_lecture-title">
                                                <h2>${order.title}</h2>
                                            </div>
                                            <div id="orderlist_lecture-date">
                                                <table>
                                                    <tr>
                                                        <td>시작일</td>
                                                        <td>${order.startDate}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>종료일</td>
                                                        <td>${order.endDate}</td>
                                                    </tr>
                                                </table>
                                            </div>
                                            <div id="orderlist_lecture-price">
                                                <div id="orderlist_lecture-price_num">
                                                    <fmt:formatNumber type="number" value="${order.lastPrice}" pattern="#,##0" />
                                                </div>
                                                <div id="orderlist_lecture-price_unit">원</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="orderlist_content-btns">
                                <div>
                                    <input class="order_btns" id="orderlist_cancel_btn" type="button" value="신청 승인">
                                </div>
                                <div>
                                    <input class="goDetail" id="orderlist_goDetail" type="button" value="결제하기">
                                </div>
                            </div>
                        </div>
                    </section>
                </c:if>
            </c:forEach>
            <section id="orderlist_paging">
                <div id="section_paging">
                    <div id="paging_per">
                        <div id="paging_per_left_arrow">
                            <input class="order_btns" type="button" value="">
                        </div>
                        <div id="pagination_parent">
                            <div class="pagination">
                                <c:forEach begin="1" end="${totalPages}" var="i">
                                    <%--                                    <a href="<c:url value='/order/orderList?page=${i}'/>">${i}</a>--%>
                                    <a href="<c:url value='/member/lectureApplyState?page=${i}'/>"
                                       <c:if test="${i eq currentPage}">class="active"</c:if>>${i}</a>
                                </c:forEach>
                            </div>
                        </div>
                        <div id="paging_per_right_arrow">
                            <input class="order_btns" type="button" value="">
                        </div>
                    </div>
                    <div id="paging_group">
                        <div id="paging_group_fst">
                            <input class="order_btns" type="button" value="   처음">
                        </div>
                        <div id="paging_group_end">
                            <input class="order_btns" type="button" value="마지막   ">
                        </div>
                    </div>
                </div>
            </section>
        </section>
        <aside id="aside_orderlist_info">
            <section id="orderlist_member_info">
                <h2 class="display-none">회원 정보</h2>
                <div id="orderlist_member_contents">
                    <div id="member_img">
                        <img id="user_profile_img" alt="user profile photo"
                             src="<c:url value="/img/orderlist_user.png"/>">
                    </div>
                    <div id="member_content">
                        <div id="member_name">
                            <span id="member_name_var">${memberDto.name}</span>
                            <span>님</span>
                        </div>
                        <div id="member_id">${memberDto.id}</div>
                    </div>
                </div>
            </section>
            <section id="orderlist_slr-account-info">
                <h2 class="display-none">판매자 계좌 정보</h2>
                <div class="orderlist_aside" id="slr-account-info">
                    <div id="slr-account-header">
                        <div id="slr-account-title">
                            <span>판매자 계좌 정보</span>
                        </div>
                    </div>
                    <div id="slr-account-content">
                        <table id="account-content_text">
                            <tr class="account-elements" id="slrname">
                                <td>예금주</td>
                                <td>${companyInfoDto.slrName}</td>
                            </tr>
                            <tr class="account-elements" id="actname">
                                <td>입금 은행</td>
                                <td>${companyInfoDto.actName}</td>
                            </tr>
                            <tr class="account-elements" id="actnum">
                                <td>계좌번호</td>
                                <td id="copy_slrActNum">${companyInfoDto.actNum}</td>
                            </tr>
                        </table>
                        <div class="AcnCopyBtn">
                            <input type="button" class="order_btns" id="orderlist_copyBtn" value="계좌번호 복사">
                        </div>

                    </div>
                    <div id="slr-account-notice">
                        <div>
                            <p>* <span>강의 시작 하루 전 23:30</span>까지 미입금 시<br>&nbsp;&nbsp;주문이 취소됩니다</p>
                        </div>
                    </div>
                </div>
            </section>
            <section id="orderlist_contact">
                <h2 class="display-none">문의하기</h2>
                <div class="orderlist_aside" id="contact">
                    <div id="contact-header">
                        <div id="contact-header-title">
                            <span>문의하기</span>
                        </div>
                    </div>
                </div>
                <div id="contact-btn">
                    <div>
                        <input class="order_btns" id="orderlist_goQna" type="button" value="Q&A 바로가기">
                    </div>
                    <div>
                        <input class="order_btns" id="goFaq" type="button" value="FAQ 바로가기">
                    </div>
                    <div>
                        <h2 class="display-none" id="slrMail_copy">${companyInfoDto.slrMail}</h2>
                        <input class="order_btns" id="copyMail" type="button" value="1:1 메일 문의">
                    </div>
                </div>
            </section>
        </aside>
    </main>
</div>
<footer>
    <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</body>


</html>

