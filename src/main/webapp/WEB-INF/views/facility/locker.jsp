<%--
  Created by IntelliJ IDEA.
  User: sanghoon
  Date: 2023/11/27
  Time: 1:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" type="text/css" href="/css/locker.css">
    <title>정석코딩</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
<div class="location">
    <button class="floorBtn" id="floor4">4층</button>
    <button class="floorBtn" id="floor5">5층</button>
    <button
            class="admin" id="moveBtn">자리이동
    </button>
    <button class="admin" id="regBtn">신규등록</button>
    <button class="admin"
            id="extdBtn">기간연장
    </button>
    <button class="admin" id="removeBtn">삭제</button>
    <span id="guideText"></span>
</div>

<div class="boundary" id="floor4locker">
    <div class="lockerTitle">4층 425</div>
    <div class="lockerDetail" id="425locker">
        <div class="locker-row">
            <c:forEach items="${lockerList}" var="locker">
                <c:if test="${locker.lockerCode == '01' and (locker.lockerNO == 1 or locker.lockerNO == 4 or locker.lockerNO == 7 or locker.lockerNO == 10 or locker.lockerNO == 13 or locker.lockerNO == 16 or locker.lockerNO == 19 or locker.lockerNO == 22 or locker.lockerNO == 25 or locker.lockerNO == 28)}">
                    <div class="locker" id="4층${locker.lockerNO}">
                        <button class="lockerNO">${locker.lockerNO}</button>
                        <div id="4-${locker.lockerNO}"><c:if test="${locker.mebrID != null}">
                            <p>${locker.name}<br></p><p id = "4층-${locker.lockerNO}">${locker.mebrID}</p><p>${locker.endDateString} 까지<br>
                            남은기간 : ${locker.remainDays}일</p>
                        </c:if></div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="locker-row">
            <c:forEach items="${lockerList}" var="locker">
                <c:if test="${locker.lockerCode == '01' and (locker.lockerNO == 2 or locker.lockerNO == 5 or locker.lockerNO == 8 or locker.lockerNO == 11 or locker.lockerNO == 14 or locker.lockerNO == 17 or locker.lockerNO == 20 or locker.lockerNO == 23 or locker.lockerNO == 26 or locker.lockerNO == 29)}">
                    <div class="locker" id="4층${locker.lockerNO}">
                        <button class="lockerNO">${locker.lockerNO}</button>
                        <div id="4-${locker.lockerNO}"><c:if test="${locker.mebrID != null}">
                            <p>${locker.name}<br></p><p id = "4층-${locker.lockerNO}">${locker.mebrID}</p><p>${locker.endDateString} 까지<br>
                            남은기간 : ${locker.remainDays}일</p>
                        </c:if></div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="locker-row">
            <c:forEach items="${lockerList}" var="locker">
                <c:if test="${locker.lockerCode == '01' and (locker.lockerNO == 3 or locker.lockerNO == 6 or locker.lockerNO == 9 or locker.lockerNO == 12 or locker.lockerNO == 15 or locker.lockerNO == 18 or locker.lockerNO == 21 or locker.lockerNO == 24 or locker.lockerNO == 27 or locker.lockerNO == 30)}">
                    <div class="locker" id="4층${locker.lockerNO}">
                        <button class="lockerNO">${locker.lockerNO}</button>
                        <div id="4-${locker.lockerNO}"><c:if test="${locker.mebrID != null}">
                            <p>${locker.name}<br></p><p id = "4층-${locker.lockerNO}">${locker.mebrID}</p><p>${locker.endDateString} 까지<br>
                            남은기간 : ${locker.remainDays}일</p>
                        </c:if></div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <!-- <hr class="row-line"> -->
    <div class="lockerTitle">4층 423</div>
    <div class="lockerDetail" id="423locker">
        <div class="locker-row">
            <c:forEach items="${lockerList}" var="locker">
                <c:if test="${locker.lockerCode == '01' and (locker.lockerNO == 31 or locker.lockerNO == 34 or locker.lockerNO == 37 or locker.lockerNO == 40 or locker.lockerNO == 43 or locker.lockerNO == 46 or locker.lockerNO == 49 or locker.lockerNO == 52 or locker.lockerNO == 55 or locker.lockerNO == 58)}">
                    <div class="locker" id="4층${locker.lockerNO}">
                        <button class="lockerNO">${locker.lockerNO}</button>
                        <div id="4-${locker.lockerNO}"><c:if test="${locker.mebrID != null}">
                            <p>${locker.name}<br></p><p id = "4층-${locker.lockerNO}">${locker.mebrID}</p><p>${locker.endDateString} 까지<br>
                            남은기간 : ${locker.remainDays}일</p>
                        </c:if></div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="locker-row">
            <c:forEach items="${lockerList}" var="locker">
                <c:if test="${locker.lockerCode == '01' and (locker.lockerNO == 32 or locker.lockerNO == 35 or locker.lockerNO == 38 or locker.lockerNO == 41 or locker.lockerNO == 44 or locker.lockerNO == 47 or locker.lockerNO == 50 or locker.lockerNO == 53 or locker.lockerNO == 56 or locker.lockerNO == 59)}">
                    <div class="locker" id="4층${locker.lockerNO}">
                        <button class="lockerNO">${locker.lockerNO}</button>
                        <div id="4-${locker.lockerNO}"><c:if test="${locker.mebrID != null}">
                            <p>${locker.name}<br></p><p id = "4층-${locker.lockerNO}">${locker.mebrID}</p><p>${locker.endDateString} 까지<br>
                            남은기간 : ${locker.remainDays}일</p>
                        </c:if></div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="locker-row">
            <c:forEach items="${lockerList}" var="locker">
                <c:if test="${locker.lockerCode == '01' and (locker.lockerNO == 33 or locker.lockerNO == 36 or locker.lockerNO == 39 or locker.lockerNO == 42 or locker.lockerNO == 45 or locker.lockerNO == 48 or locker.lockerNO == 51 or locker.lockerNO == 54 or locker.lockerNO == 57 or locker.lockerNO == 60)}">
                    <div class="locker" id="4층${locker.lockerNO}">
                        <button class="lockerNO">${locker.lockerNO}</button>
                        <div id="4-${locker.lockerNO}"><c:if test="${locker.mebrID != null}">
                            <p>${locker.name}<br></p><p id = "4층-${locker.lockerNO}">${locker.mebrID}</p><p>${locker.endDateString} 까지<br>
                            남은기간 : ${locker.remainDays}일</p>
                        </c:if></div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>
<div class="boundary" id="floor5locker">
    <div class="lockerTitle">5층 522 휴게실</div>
    <div class="lockerDetail" id="522locker">
        <div class="locker-row">
            <c:forEach items="${lockerList}" var="locker">
                <c:if test="${locker.lockerCode == '02' and (locker.lockerNO == 1 or locker.lockerNO == 7 or locker.lockerNO == 13 or locker.lockerNO == 19 or locker.lockerNO == 25 or locker.lockerNO == 31 or locker.lockerNO == 37 or locker.lockerNO == 43)}">
                    <div class="locker5" id="5층${locker.lockerNO}">
                        <button class="lockerNO">${locker.lockerNO}</button>
                        <div id="5-${locker.lockerNO}"><c:if test="${locker.mebrID != null}">
                            <p>${locker.name}<br></p><p id = "5층-${locker.lockerNO}">${locker.mebrID}</p><p>${locker.endDateString} 까지<br>
                            남은기간 : ${locker.remainDays}일</p>
                        </c:if></div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="locker-row">
            <c:forEach items="${lockerList}" var="locker">
                <c:if test="${locker.lockerCode == '02' and (locker.lockerNO == 2 or locker.lockerNO == 8 or locker.lockerNO == 14 or locker.lockerNO == 20 or locker.lockerNO == 26 or locker.lockerNO == 32 or locker.lockerNO == 38 or locker.lockerNO == 44)}">
                    <div class="locker5" id="5층${locker.lockerNO}">
                        <button class="lockerNO">${locker.lockerNO}</button>
                        <div id="5-${locker.lockerNO}">
                            <c:if test="${locker.mebrID != null}">
                                <p>${locker.name}<br></p><p id = "5층-${locker.lockerNO}">${locker.mebrID}</p><p>${locker.endDateString} 까지<br>
                                남은기간 : ${locker.remainDays}일</p>
                            </c:if></div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="locker-row">
            <c:forEach items="${lockerList}" var="locker">
                <c:if test="${locker.lockerCode == '02' and (locker.lockerNO == 3 or locker.lockerNO == 9 or locker.lockerNO == 15 or locker.lockerNO == 21 or locker.lockerNO == 27 or locker.lockerNO == 33 or locker.lockerNO == 39 or locker.lockerNO == 45)}">
                    <div class="locker5" id="5층${locker.lockerNO}">
                        <button class="lockerNO">${locker.lockerNO}</button>
                        <div id="5-${locker.lockerNO}"><c:if test="${locker.mebrID != null}">
                            <p>${locker.name}<br></p><p id = "5층-${locker.lockerNO}">${locker.mebrID}</p><p>${locker.endDateString} 까지<br>
                            남은기간 : ${locker.remainDays}일</p>
                        </c:if></div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

        <div class="locker-row">
            <c:forEach items="${lockerList}" var="locker">
                <c:if test="${locker.lockerCode == '02' and (locker.lockerNO == 4 or locker.lockerNO == 10 or locker.lockerNO == 16 or locker.lockerNO == 22 or locker.lockerNO == 28 or locker.lockerNO == 34 or locker.lockerNO == 40 or locker.lockerNO == 46)}">
                    <div class="locker5" id="5층${locker.lockerNO}">
                        <button class="lockerNO">${locker.lockerNO}</button>
                        <div id="5-${locker.lockerNO}"><c:if test="${locker.mebrID != null}">
                            <p>${locker.name}<br></p><p id = "5층-${locker.lockerNO}">${locker.mebrID}</p><p>${locker.endDateString} 까지<br>
                            남은기간 : ${locker.remainDays}일</p>
                        </c:if></div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

        <div class="locker-row">
            <c:forEach items="${lockerList}" var="locker">
                <c:if test="${locker.lockerCode == '02' and (locker.lockerNO == 5 or locker.lockerNO == 11 or locker.lockerNO == 17 or locker.lockerNO == 23 or locker.lockerNO == 29 or locker.lockerNO == 35 or locker.lockerNO == 41 or locker.lockerNO == 47)}">
                    <div class="locker5" id="5층${locker.lockerNO}">
                        <button class="lockerNO">${locker.lockerNO}</button>
                        <div id="5-${locker.lockerNO}"><c:if test="${locker.mebrID != null}">
                            <p>${locker.name}<br></p><p id = "5층-${locker.lockerNO}">${locker.mebrID}</p><p>${locker.endDateString} 까지<br>
                            남은기간 : ${locker.remainDays}일</p>
                        </c:if></div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

        <div class="locker-row">
            <c:forEach items="${lockerList}" var="locker">
                <c:if test="${locker.lockerCode == '02' and (locker.lockerNO == 6 or locker.lockerNO == 12 or locker.lockerNO == 18 or locker.lockerNO == 24 or locker.lockerNO == 30 or locker.lockerNO == 36 or locker.lockerNO == 42 or locker.lockerNO == 48)}">
                    <div class="locker5" id="5층${locker.lockerNO}">
                        <button class="lockerNO">${locker.lockerNO}</button>
                        <div id="5-${locker.lockerNO}"><c:if test="${locker.mebrID != null}">
                            <p>${locker.name}<br></p><p id = "5층-${locker.lockerNO}">${locker.mebrID}</p><p>${locker.endDateString} 까지<br>
                            남은기간 : ${locker.remainDays}일</p>
                        </c:if></div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>
<script type="text/javascript" src="<c:url value="/js/lockerAdmin.js"/>"></script>
</body>
</html>