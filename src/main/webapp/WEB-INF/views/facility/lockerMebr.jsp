<%--
  Created by IntelliJ IDEA.
  User: sanghoon
  Date: 2023/11/27
  Time: 1:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/css/lockerMebr.css">
    <title>정석코딩</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>

        #LockerArea {
            margin-top: 50px;
            margin-bottom: 50px;
        }

        .occupied {
            background-color: #FF7878; /* 빨간색 배경 */
        }

        #floor4 {
            background-color: yellow;
        }

    </style>
</head>

<body>

<header>
    <jsp:include page="../header.jsp"/>
</header>

<div id = "LockerArea">

    <div class="location">
        <button class="floorBtn" id="floor4">4층</button>
        <button class="floorBtn" id="floor5">5층</button>
        <button class="admin" id="moveBtn">자리이동</button>
        <button class="admin" id="regBtn">신규등록</button>
        <button class="admin" id="extdBtn">기간연장</button>
        <button class="admin" id="removeBtn">삭제</button>
        <span id="guideText"></span>
    </div>

    <div class="boundary" id="floor4locker">
        <div class="lockerTitle">4층 425</div>
        <div class="lockerDetail" id="425locker">
            <div class="locker-row">
                <c:forEach items="${lockerList}" var="locker">
                    <c:if test="${locker.lockerCode == '01' and (locker.lockerNO == 1 or locker.lockerNO == 4 or locker.lockerNO == 7 or locker.lockerNO == 10 or locker.lockerNO == 13 or locker.lockerNO == 16 or locker.lockerNO == 19 or locker.lockerNO == 22 or locker.lockerNO == 25 or locker.lockerNO == 28)}">
                        <div class="locker ${locker.mebrID != null ? 'occupied' : ''}" id="4층${locker.lockerNO}">
                            <button class="lockerNO">${locker.lockerNO}</button>
                            <div id="4-${locker.lockerNO}">
                                <c:choose>
                                    <c:when test="${locker.mebrID != null}">
                                        <p>사용중</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>빈자리</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="locker-row">
                <c:forEach items="${lockerList}" var="locker">
                    <c:if test="${locker.lockerCode == '01' and (locker.lockerNO == 2 or locker.lockerNO == 5 or locker.lockerNO == 8 or locker.lockerNO == 11 or locker.lockerNO == 14 or locker.lockerNO == 17 or locker.lockerNO == 20 or locker.lockerNO == 23 or locker.lockerNO == 26 or locker.lockerNO == 29)}">
                        <div class="locker ${locker.mebrID != null ? 'occupied' : ''}" id="4층${locker.lockerNO}">
                            <button class="lockerNO">${locker.lockerNO}</button>
                            <div id="4-${locker.lockerNO}">
                                <c:choose>
                                    <c:when test="${locker.mebrID != null}">
                                        <p>사용중</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>빈자리</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="locker-row">
                <c:forEach items="${lockerList}" var="locker">
                    <c:if test="${locker.lockerCode == '01' and (locker.lockerNO == 3 or locker.lockerNO == 6 or locker.lockerNO == 9 or locker.lockerNO == 12 or locker.lockerNO == 15 or locker.lockerNO == 18 or locker.lockerNO == 21 or locker.lockerNO == 24 or locker.lockerNO == 27 or locker.lockerNO == 30)}">
                        <div class="locker ${locker.mebrID != null ? 'occupied' : ''}" id="4층${locker.lockerNO}">
                            <button class="lockerNO">${locker.lockerNO}</button>
                            <div id="4-${locker.lockerNO}">
                                <c:choose>
                                    <c:when test="${locker.mebrID != null}">
                                        <p>사용중</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>빈자리</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
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
                        <div class="locker ${locker.mebrID != null ? 'occupied' : ''}" id="4층${locker.lockerNO}">
                            <button class="lockerNO">${locker.lockerNO}</button>
                            <div id="4-${locker.lockerNO}">
                                <c:choose>
                                    <c:when test="${locker.mebrID != null}">
                                        <p>사용중</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>빈자리</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="locker-row">
                <c:forEach items="${lockerList}" var="locker">
                    <c:if test="${locker.lockerCode == '01' and (locker.lockerNO == 32 or locker.lockerNO == 35 or locker.lockerNO == 38 or locker.lockerNO == 41 or locker.lockerNO == 44 or locker.lockerNO == 47 or locker.lockerNO == 50 or locker.lockerNO == 53 or locker.lockerNO == 56 or locker.lockerNO == 59)}">
                        <div class="locker ${locker.mebrID != null ? 'occupied' : ''}" id="4층${locker.lockerNO}">
                            <button class="lockerNO">${locker.lockerNO}</button>
                            <div id="4-${locker.lockerNO}">
                                <c:choose>
                                    <c:when test="${locker.mebrID != null}">
                                        <p>사용중</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>빈자리</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="locker-row">
                <c:forEach items="${lockerList}" var="locker">
                    <c:if test="${locker.lockerCode == '01' and (locker.lockerNO == 33 or locker.lockerNO == 36 or locker.lockerNO == 39 or locker.lockerNO == 42 or locker.lockerNO == 45 or locker.lockerNO == 48 or locker.lockerNO == 51 or locker.lockerNO == 54 or locker.lockerNO == 57 or locker.lockerNO == 60)}">
                        <div class="locker ${locker.mebrID != null ? 'occupied' : ''}" id="4층${locker.lockerNO}">
                            <button class="lockerNO">${locker.lockerNO}</button>
                            <div id="4-${locker.lockerNO}">
                                <c:choose>
                                    <c:when test="${locker.mebrID != null}">
                                        <p>사용중</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>빈자리</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
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
                        <div class="locker5 ${locker.mebrID != null ? 'occupied' : ''}" id="5층${locker.lockerNO}">
                            <button class="lockerNO">${locker.lockerNO}</button>
                            <div id="5-${locker.lockerNO}">
                                <c:choose>
                                    <c:when test="${locker.mebrID != null}">
                                        <p>사용중</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>빈자리</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>

                    </c:if>
                </c:forEach>
            </div>
            <div class="locker-row">
                <c:forEach items="${lockerList}" var="locker">
                    <c:if test="${locker.lockerCode == '02' and (locker.lockerNO == 2 or locker.lockerNO == 8 or locker.lockerNO == 14 or locker.lockerNO == 20 or locker.lockerNO == 26 or locker.lockerNO == 32 or locker.lockerNO == 38 or locker.lockerNO == 44)}">
                        <div class="locker5 ${locker.mebrID != null ? 'occupied' : ''}" id="5층${locker.lockerNO}">
                            <button class="lockerNO">${locker.lockerNO}</button>
                            <div id="5-${locker.lockerNO}">
                                <c:choose>
                                    <c:when test="${locker.mebrID != null}">
                                        <p>사용중</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>빈자리</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="locker-row">
                <c:forEach items="${lockerList}" var="locker">
                    <c:if test="${locker.lockerCode == '02' and (locker.lockerNO == 3 or locker.lockerNO == 9 or locker.lockerNO == 15 or locker.lockerNO == 21 or locker.lockerNO == 27 or locker.lockerNO == 33 or locker.lockerNO == 39 or locker.lockerNO == 45)}">
                        <div class="locker5 ${locker.mebrID != null ? 'occupied' : ''}" id="5층${locker.lockerNO}">
                            <button class="lockerNO">${locker.lockerNO}</button>
                            <div id="5-${locker.lockerNO}">
                                <c:choose>
                                    <c:when test="${locker.mebrID != null}">
                                        <p>사용중</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>빈자리</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>

            <div class="locker-row">
                <c:forEach items="${lockerList}" var="locker">
                    <c:if test="${locker.lockerCode == '02' and (locker.lockerNO == 4 or locker.lockerNO == 10 or locker.lockerNO == 16 or locker.lockerNO == 22 or locker.lockerNO == 28 or locker.lockerNO == 34 or locker.lockerNO == 40 or locker.lockerNO == 46)}">
                        <div class="locker5 ${locker.mebrID != null ? 'occupied' : ''}" id="5층${locker.lockerNO}">
                            <button class="lockerNO">${locker.lockerNO}</button>
                            <div id="5-${locker.lockerNO}">
                                <c:choose>
                                    <c:when test="${locker.mebrID != null}">
                                        <p>사용중</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>빈자리</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>

            <div class="locker-row">
                <c:forEach items="${lockerList}" var="locker">
                    <c:if test="${locker.lockerCode == '02' and (locker.lockerNO == 5 or locker.lockerNO == 11 or locker.lockerNO == 17 or locker.lockerNO == 23 or locker.lockerNO == 29 or locker.lockerNO == 35 or locker.lockerNO == 41 or locker.lockerNO == 47)}">
                        <div class="locker5 ${locker.mebrID != null ? 'occupied' : ''}" id="5층${locker.lockerNO}">
                            <button class="lockerNO">${locker.lockerNO}</button>
                            <div id="5-${locker.lockerNO}">
                                <c:choose>
                                    <c:when test="${locker.mebrID != null}">
                                        <p>사용중</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>빈자리</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>

            <div class="locker-row">
                <c:forEach items="${lockerList}" var="locker">
                    <c:if test="${locker.lockerCode == '02' and (locker.lockerNO == 6 or locker.lockerNO == 12 or locker.lockerNO == 18 or locker.lockerNO == 24 or locker.lockerNO == 30 or locker.lockerNO == 36 or locker.lockerNO == 42 or locker.lockerNO == 48)}">
                        <div class="locker5 ${locker.mebrID != null ? 'occupied' : ''}" id="5층${locker.lockerNO}">
                            <button class="lockerNO">${locker.lockerNO}</button>
                            <div id="5-${locker.lockerNO}">
                                <c:choose>
                                    <c:when test="${locker.mebrID != null}">
                                        <p>사용중</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>빈자리</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>

</div>

<script>
    window.onload = function () {

        let loginCheck = <c:out value="${loginCheck}" default="false" />; //loginCheck 속성이 null이거나 존재하지 않을 때 기본값으로 false를 사용
        let loginID = "<c:out value='${mebrID}' default='' />"; // 따옴표로 묶어서 문자열로 만듦


        let mebrLockerList = [
            <c:forEach var="locker" items="${mebrLockerDtoList}" varStatus="status">
            {
                lockerCode: '${locker.lockerCode}',
                lockerID: '${locker.lockerID}',
                lockerNo: '${locker.lockerNO}',
                name: '${locker.name}',
                mebrID: '${locker.mebrID}',
                endDateString: '${locker.endDateString}',
                remainDays: '${locker.remainDays}'
            }<c:if test="${!status.last}">, </c:if>
            </c:forEach>
        ];

        let mebrArea = []; // 사용자 영역 ID를 저장할 배열 초기화

        mebrLockerList.forEach(function (locker) {
            let informationID, EventID, pTagId;

            if (locker.lockerCode === "01") {
                informationID = "4-" + locker.lockerNo;
                EventID = "4층" + locker.lockerNo;
                pTagId = "4층-" + locker.lockerNo;
            } else {
                informationID = "5-" + locker.lockerNo;
                EventID = "5층" + locker.lockerNo;
                pTagId = "5층-" + locker.lockerNo;
            }

            let informationElement = document.getElementById(informationID);
            if (informationElement) {
                informationElement.innerHTML = "<p>" + locker.name + "<br></p><p id='" + pTagId + "'>" + locker.mebrID + "</p><p>" + locker.endDateString + " 까지<br>남은 기간: " + locker.remainDays + "일</p>";
            }

            let eventElement = document.getElementById(EventID);
            if (eventElement) {
                eventElement.style.backgroundColor = '#E1FFE1';

                // mebrArea 배열에 EventID 추가
                mebrArea.push(EventID);
            }
        });

        const floor4 = document.getElementById("floor4"); //4층 버튼 요소 가져옴
        const floor5 = document.getElementById("floor5"); //5층 버튼 요소 가져옴
        const floor4locker = document.getElementById("floor4locker"); //4층 사물함 요소 가져옴
        const floor5locker = document.getElementById("floor5locker"); //4층 사물함 요소 가져옴
        const moveBtn = document.getElementById("moveBtn"); //자리이동 버튼 요소 가져옴
        const guideText = document.getElementById("guideText"); //자리이동 버튼 클릭될때 text들어갈 요소 가져옴
        const regBtn = document.getElementById("regBtn"); //자리등록 버튼 요소 가져옴
        const extdBtn = document.getElementById("extdBtn"); //기간연장 버튼 요소 가져옴
        const removeBtn = document.getElementById("removeBtn"); //자리삭제 버튼 요소 가져옴
        const lockerCollection4 = document.getElementsByClassName("locker"); // 4층락커 요소 전부 가져옴
        const lockerCollection5 = document.getElementsByClassName("locker5"); // 5층락커 요소 전부 가져옴
        let commentText; //코멘트 텍스트 요소
        let floorStatus = "floor4"; //화면 4층인지 5층인지
        let moveClick = 0; //자리이동버튼 선택됐는지 여부
        let regClick = 0; //자리등록버튼 선택됐는지 여부
        let extdClick = 0; //기간연장버튼 선택됐는지 여부
        let removeClick = 0; //자리삭제버튼 선택됐는지 여부
        let isFirstMoveChoice = 0; //자리옮기는 버튼 클릭됐을때 첫번째 락커 선택인지 여부
        let moveChoiceLocker = ["", ""]; //자리 옮기기에서 클릭된 요소 id담는 배열
        let moveClickedElement = []; //자리 옮기기에서 클릭된 요소를 담는 배열
        let choiceLocker = ""; //등록, 삭제, 기간연장할때 선택된 요소 id담는 변수
        let choiceElement; //등록, 삭제, 기간연장할때 선택된 요소 담는 변수
        let cancelBtn; //취소 버튼 요소 담는 변수
        let changeCommit; //커밋 버튼 요소 담는 변수
        let extdDays; //연장기간 담는 변수
        let forPtagString;
        let mebrID; //회원 ID 담는 변수
        let lockerID; //기존 락커id 담는 변수
        let lockerIdNew; //이동할 위치 락커 id 담는 변수
        let lockerCode; //락커 Code 담는 변수
        let lockerCodeNew; //이동할 위치 락커 Code 담는 변수
        let useDays; //사용기간 담는 변수
        let startDate; //서버로 전송할 Date타입
        let endDate; //서버로 전송할 Date타입

        function changeFloor(event) {
            if (floorStatus === event.target.id) return;

            else if (floorStatus === "floor4") {
                floor4locker.style.display = "none";
                floor5locker.style.display = "block";
                floorStatus = "floor5";
                floor5.style.backgroundColor = "yellow";
                floor4.style.backgroundColor = "#dcdcdc";
            } else {
                floor5locker.style.display = "none";
                floor4locker.style.display = "block";
                floorStatus = "floor4"
                floor4.style.backgroundColor = "yellow";
                floor5.style.backgroundColor = "#dcdcdc";
            }
        }

        function moveNo() {
            if (!loginCheck) {
                let Check = confirm("이 기능을 사용하려면 로그인이 필요합니다. 로그인 페이지로 이동하시겠습니까?");

                if (Check) {
                    window.location.href = "/member/login?toURL=" + window.location.pathname;
                }

                return;
            }

            if (moveClick === 1)  {
                cancelClick()
                return;
            }

            moveBtn.style.backgroundColor = '#87F5F5';

            if (regClick === 1) {
                initial();
                regBtn.style.backgroundColor = '#dcdcdc';
                regClick = 0;
            }

            if (removeClick === 1) {
                initial();
                removeBtn.style.backgroundColor = '#dcdcdc';
                removeClick = 0;
            }
            if (extdClick === 1) {
                initial();
                extdBtn.style.backgroundColor = '#dcdcdc';
                extdClick = 0;
            }
            moveClick = 1;
            guideText.innerHTML = "<p id='commentText'>이동할 자리를 선택해주세요!&nbsp;&nbsp;  위치를 &nbsp;&nbsp;&nbsp;  위치로&nbsp;&nbsp;</p><button class='changeCommit' id='moveTransfer'>옮기기</button><button class='changeCommit' id='cancelBtn'>취소</button>";
            commentText = document.getElementById("commentText");
            cancelBtn = document.getElementById("cancelBtn");
            cancelBtn.addEventListener("click", cancelClick);
            changeCommit = document.getElementById("moveTransfer");
            changeCommit.addEventListener("click", () => changeTransfer(changeCommit.id));
        }

        function regNo() {

            if (!loginCheck) {
                let Check = confirm("이 기능을 사용하려면 로그인이 필요합니다. 로그인 페이지로 이동하시겠습니까?");

                if (Check) {
                    window.location.href = "/member/login?toURL=" + window.location.pathname;
                }

                return;
            }

            regBtn.style.backgroundColor = '#87F5F5';


            if (regClick === 1) return;

            if (moveClick === 1) {
                initial();
                moveBtn.style.backgroundColor = '#dcdcdc';
                isFirstMoveChoice = 0;
                moveClick = 0;
            }
            if (removeClick === 1) {
                initial();
                removeBtn.style.backgroundColor = '#dcdcdc';
                removeClick = 0;
            }
            if (extdClick === 1) {
                initial();
                extdBtn.style.backgroundColor = '#dcdcdc';
                extdClick = 0;
            }
            regClick = 1;
            guideText.innerHTML = "<p id='commentText'>등록할 자리를 선택해주세요! &nbsp;&nbsp; 자리로&nbsp;&nbsp;</p><button class='changeCommit' id='regTransfer' >등록하기</button><button class='changeCommit' id='cancelBtn'>취소</button>";
            commentText = document.getElementById("commentText");
            cancelBtn = document.getElementById("cancelBtn");
            cancelBtn.addEventListener("click", cancelClick);
            changeCommit = document.getElementById("regTransfer");
            changeCommit.addEventListener("click", () => changeTransfer(changeCommit.id));
        }

        function extdNo() {

            if (!loginCheck) {
                let Check = confirm("이 기능을 사용하려면 로그인이 필요합니다. 로그인 페이지로 이동하시겠습니까?");

                if (Check) {
                    window.location.href = "/member/login?toURL=" + window.location.pathname;
                }

                return;
            }

            extdBtn.style.backgroundColor = '#87F5F5';

            if (extdClick === 1) return;

            if (moveClick === 1) {
                initial();
                moveBtn.style.backgroundColor = '#dcdcdc';
                isFirstMoveChoice = 0;
                moveClick = 0;
            }
            if (removeClick === 1) {
                initial();
                removeBtn.style.backgroundColor = '#dcdcdc';
                removeClick = 0;
            }

            if (regClick === 1) {
                initial();
                regBtn.style.backgroundColor = '#dcdcdc';
                regClick = 0;
            }

            extdClick = 1;
            guideText.innerHTML = "<p id='commentText'>연장할 자리를 선택해주세요! &nbsp;&nbsp; 자리를&nbsp;&nbsp;</p><button class='changeCommit' id='extdTransfer'>연장하기</button><button class='changeCommit' id='cancelBtn'>취소</button>";
            commentText = document.getElementById("commentText");
            cancelBtn = document.getElementById("cancelBtn");
            cancelBtn.addEventListener("click", cancelClick);
            changeCommit = document.getElementById("extdTransfer");
            changeCommit.addEventListener("click", () => changeTransfer(changeCommit.id));
        }

        function removeNo() {
            alert("관리자에게 문의하세요! 일반회원은 자기자리 이동만 가능합니다! ");
            return;

            if (removeClick === 1) return;

            if (moveClick === 1) {
                initial();
                moveBtn.style.backgroundColor = '#dcdcdc';
                isFirstMoveChoice = 0;
                moveClick = 0;
            }
            if (regClick === 1) {
                initial();
                regBtn.style.backgroundColor = '#dcdcdc';
                regClick = 0;
            }

            if (extdClick === 1) {
                initial();
                extdBtn.style.backgroundColor = '#dcdcdc';
                extdClick = 0;
            }
            removeClick = 1;
            guideText.innerHTML = "<p id='commentText'>삭제할 자리를 선택해주세요! &nbsp;&nbsp; 자리를&nbsp;&nbsp;</p><button class='changeCommit' id='removeTransfer'>삭제하기</button><button class='changeCommit' id='cancelBtn'>취소</button>";
            commentText = document.getElementById("commentText");
            cancelBtn = document.getElementById("cancelBtn");
            cancelBtn.addEventListener("click", cancelClick);
            changeCommit = document.getElementById("removeTransfer");
            changeCommit.addEventListener("click", () => changeTransfer(changeCommit.id));
        }

        //선택된 락커, 색깔 초기화 하는 함수
        function initial() {
            if (moveChoiceLocker[1] !== "") {

                if (mebrArea.includes(moveChoiceLocker[1])) {
                    moveClickedElement[1].style.backgroundColor = '#E1FFE1';
                } else {
                    moveClickedElement[1].style.backgroundColor = '';
                }
            }

            if (moveChoiceLocker[0] !== "") {

                if (mebrArea.includes(moveChoiceLocker[0])) {
                    moveClickedElement[0].style.backgroundColor = '#E1FFE1';
                } else {
                    moveClickedElement[0].style.backgroundColor = '';
                }

            }


            if (choiceLocker !== "") {

                if (mebrArea.includes(choiceLocker)) {
                    choiceElement.style.backgroundColor = '#E1FFE1';
                } else {
                    choiceElement.style.backgroundColor = '#FFD1B7';
                }
            }

            moveChoiceLocker = ["", ""];
            moveClickedElement = [];
            choiceLocker = "";
            choiceElement = null;
        }

        //취소버튼 클릭
        function cancelClick() {
            guideText.innerHTML = "";
            initial();
            isFirstMoveChoice = 0;
            moveClick = 0;
            regClick = 0;
            removeClick = 0;
            extdClick = 0;
            moveBtn.style.backgroundColor = '#dcdcdc';
            regBtn.style.backgroundColor = '#dcdcdc';
            removeBtn.style.backgroundColor = '#dcdcdc';
            extdBtn.style.backgroundColor = '#dcdcdc';
        }

        function lockerClick(id, event) {

            if (event.target.tagName === 'BUTTON') {
                return;
            }

            // 아무것도 클릭안하고 클릭한경우 그냥 return
            if (moveClick === 0 && regClick === 0 && removeClick === 0 && extdClick === 0) return;

            if (moveClick === 1 && isFirstMoveChoice !== 0 && document.getElementById(id.substring(0, 1) + "-" + id.substring(2)).innerText === '사용중') {

                alert("사용중인 자리로는 옮길 수 없습니다!");

                return;
            }

            if (regClick === 1 && document.getElementById(id.substring(0, 1) + "-" + id.substring(2)).innerText === '사용중') {
                alert("사용중인 자리는 등록할 수 없습니다!");
                return;
            }

            if (regClick === 1 && mebrArea.includes(id)) {
                alert("이미 등록한 자리는 신규등록할 수 없습니다!");
                return;
            }

            if (extdClick === 1 && !mebrArea.includes(id)) {
                alert("자기자리만 연장할 수 있습니다!");
                return;
            }

            //이동 버튼 누르고 두번째 선택인데 같은 번호 클릭했을시
            if (moveClick === 1 && isFirstMoveChoice === 1 && id === moveChoiceLocker[0]) {
                isFirstMoveChoice = 0;
                moveChoiceLocker[0] = "";
                moveClickedElement[0].style.backgroundColor = '#E1FFE1';
                moveClickedElement[0] = null;
                commentText.innerHTML = "이동할 자리를 선택해주세요!&nbsp;&nbsp; 위치를 &nbsp;&nbsp;&nbsp;  위치로&nbsp;&nbsp;";
                return;
            }

            //이동 버튼 누르고 두번째 카드랑 같은 세번째 클릭인경우
            if (moveClick === 1 && isFirstMoveChoice === 0 && id === moveChoiceLocker[1]) {

                isFirstMoveChoice = 1;
                moveChoiceLocker[1] = "";

                if (document.getElementById(id.substring(0, 1) + "-" + id.substring(2)).innerText === '빈자리') {
                    moveClickedElement[1].style.backgroundColor = '#FFD1B7';
                } else {
                    moveClickedElement[1].style.backgroundColor = '#E1FFE1';
                }

                // if (document.getElementById(id.substring(0, 1) + "-" + id.substring(2)).innerText === '빈자리') {
                //     moveClickedElement[1].style.backgroundColor = '';
                // } else {
                //     moveClickedElement[1].style.backgroundColor = '';
                // }

                moveClickedElement[1] = null;
                commentText.innerHTML = "이동할 자리를 선택해주세요!&nbsp;&nbsp; " + moveChoiceLocker[0] + "위치를 &nbsp;&nbsp;&nbsp;  위치로&nbsp;&nbsp;";
                return;
            }

            //이동 버튼 누르고 세번째 클릭인경우
            if (moveClick === 1 && isFirstMoveChoice === 0 && id === moveChoiceLocker[0] && moveChoiceLocker[1] !== "") {
                //alert("첫번째 카드랑 같은 세번째 카드입니다");
                //아무처리 없이 return
                return;
            }

            if (extdClick === 1 && id === choiceLocker) return;

            if (regClick === 1 && id === choiceLocker) return;

            if (removeClick === 1 && id === choiceLocker) return;

            if (event.target.classList.contains('locker') || event.target.classList.contains('locker5')) {
                event.currentTarget.style.backgroundColor = 'aqua';
            } else {
                event.target.parentElement.parentElement.style.backgroundColor = 'aqua';
            }

            if (moveClick === 1 && isFirstMoveChoice === 0) {

                if (!mebrArea.includes(id)) {
                    //멤버 말고 다른거 클릭
                    if (event.target.classList.contains('locker') || event.target.classList.contains('locker5')) {
                        event.currentTarget.style.backgroundColor = '';
                    } else {
                        event.target.parentElement.parentElement.style.backgroundColor = '';
                    }
                    alert("자기자리만 옮길 수 있습니다! ");
                    return;
                }

                //이전클릭 색깔 초기화
                if (moveChoiceLocker[0] !== "") {

                    if (mebrArea.includes(moveChoiceLocker[0])) {
                        moveClickedElement[0].style.backgroundColor = '#E1FFE1';
                    } else {
                        moveClickedElement[0].style.backgroundColor = '';
                    }

                    if (mebrArea.includes(moveChoiceLocker[1])) {
                        moveClickedElement[1].style.backgroundColor = '#E1FFE1';
                    } else {
                        moveClickedElement[1].style.backgroundColor = '';
                    }
                }

                moveChoiceLocker[0] = id;
                moveChoiceLocker[1] = "";
                isFirstMoveChoice = 1;
                moveClickedElement[0] = event.currentTarget;
                moveClickedElement[1] = null;
                commentText.innerHTML = "이동할 자리를 선택해주세요!&nbsp;&nbsp; " + id + "위치를 &nbsp;&nbsp;&nbsp;  위치로&nbsp;&nbsp;";
                return;
            } else if (moveClick === 1 && isFirstMoveChoice === 1) {

                // 사용중인 자리로는 못 옮기게 막음
                if (document.getElementById(id.substring(0, 1) + "-" + id.substring(2)).innerText === "사용중") {

                    if (event.target.classList.contains('locker') || event.target.classList.contains('locker5')) {
                        event.currentTarget.style.backgroundColor = '';
                    } else {
                        event.target.parentElement.parentElement.style.backgroundColor = '';
                    }
                    alert("사용중인 자리로는 옮길 수 없습니다!");
                    return;
                }

                moveChoiceLocker[1] = id;
                moveClickedElement[1] = event.currentTarget;
                isFirstMoveChoice = 0;
                commentText.innerHTML = "이동할 자리를 선택해주세요!&nbsp;&nbsp; " + moveChoiceLocker[0] + "위치를 &nbsp;&nbsp;" + id + "위치로&nbsp;&nbsp;";
                return;
            } else if (extdClick === 1) {
                if (!mebrArea.includes(id)) {

                    //방금클릭한거 초기화
                    if (event.target.classList.contains('locker') || event.target.classList.contains('locker5')) {
                        event.currentTarget.style.backgroundColor = '';
                    } else {
                        event.target.parentElement.parentElement.style.backgroundColor = '';
                    }
                    alert("자기자리만 연장할 수 있습니다!");
                    return;
                }

                if (choiceLocker !== "") {

                    if (mebrArea.includes(choiceLocker)) {
                        choiceElement.style.backgroundColor = '#E1FFE1';
                    } else {
                        choiceElement.style.backgroundColor = '';
                    }
                }

                choiceLocker = id;
                choiceElement = event.currentTarget;
                commentText.innerHTML = "연장할 자리를 선택해주세요! &nbsp;&nbsp;" + id + "자리를&nbsp;&nbsp;";
                return;
            } else if (regClick === 1) {

                if (document.getElementById(id.substring(0, 1) + "-" + id.substring(2)).innerText !== "빈자리") {

                    if (event.target.classList.contains('locker') || event.target.classList.contains('locker5')) {
                        event.currentTarget.style.backgroundColor = '';
                    } else {
                        event.target.parentElement.parentElement.style.backgroundColor = '';
                    }
                    alert("이미 사용중인 자리는 등록할 수 없습니다!");

                    return;
                }

                if (choiceLocker !== "") {

                    if (mebrArea.includes(choiceLocker)) {
                        choiceElement.style.backgroundColor = '#E1FFE1';
                    } else {
                        choiceElement.style.backgroundColor = '';
                    }
                }

                choiceLocker = id;
                choiceElement = event.currentTarget;
                commentText.innerHTML = "등록할 자리를 선택해주세요! &nbsp;&nbsp;" + id + "자리로&nbsp;&nbsp;";
                return;
            }

            // } else if (removeClick === 1) {
            //     if (document.getElementById(id.substring(0, 1) + "-" + id.substring(2)).innerText === "") {
            //
            //         if (event.target.classList.contains('locker') || event.target.classList.contains('locker5')) {
            //             event.currentTarget.style.backgroundColor = '';
            //         } else {
            //             event.target.parentElement.parentElement.style.backgroundColor = '';
            //         }
            //         alert("빈 자리는 삭제할 수 없습니다!");
            //         return;
            //     }
            //
            //     if(mebrArea.includes(choiceLocker)) {
            //         choiceElement.style.backgroundColor = '#E1FFE1';
            //     }else {
            //         choiceElement.style.backgroundColor = '';
            //     }
            // }
            //
            //     choiceLocker = id;
            //     choiceElement = event.currentTarget;
            //     commentText.innerHTML = "삭제할 자리를 선택해주세요! &nbsp;&nbsp;" + id + "자리를&nbsp;&nbsp;";
            //     return;
            // }

            alert("아무것도 해당안됨!!!");
        }


        function changeTransfer(id) {
            switch (id) {
                case 'moveTransfer':

                    if (confirm("정말 " + moveChoiceLocker[0] + "위치를 " + moveChoiceLocker[1] + "위치로 옮기시겠습니까?")) {
                        if (moveChoiceLocker[0].substring(0, 1) === '4') {
                            lockerCode = "01";
                            lockerID = "01";
                            forPtagString = "4층-";

                        } else {
                            lockerCode = "02";
                            lockerID = "02";
                            forPtagString = "5층-";
                        }

                        if (moveChoiceLocker[0].substring(2).length === 1) {
                            lockerID += ("0" + moveChoiceLocker[0].substring(2));
                            forPtagString += moveChoiceLocker[0].substring(2);
                        } else {
                            lockerID += moveChoiceLocker[0].substring(2);
                            forPtagString += moveChoiceLocker[0].substring(2);
                        }

                        if (moveChoiceLocker[1].substring(0, 1) === '4') {
                            lockerCodeNew = "01";
                            lockerIdNew = "01";
                        } else {
                            lockerCodeNew = "02";
                            lockerIdNew = "02";
                        }

                        if (moveChoiceLocker[1].substring(2).length === 1) {
                            lockerIdNew += ("0" + moveChoiceLocker[1].substring(2));
                        } else {
                            lockerIdNew += moveChoiceLocker[1].substring(2);
                        }


                        mebrID = document.getElementById(forPtagString).innerText;

                        const lockerDto = {
                            lockerID: lockerID,
                            mebrID: mebrID
                        };

                        // 서버로 PATCH 요청
                        fetch(`/locker/` + lockerIdNew + `/move`, {
                            method: 'PATCH',
                            headers: {
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify(lockerDto),
                        })
                            .then(response => {
                                if (response.ok) {
                                    alert("락커 이동이 완료되었습니다.");
                                    location.reload();
                                } else {
                                    throw new Error("락커 이동에 실패했습니다.");
                                }
                            })
                            .catch((error) => {
                                console.error('Error:', error);
                                alert("이동 실패: " + error);
                                cancelClick();
                                location.reload();
                            });
                    } else {
                        cancelClick();
                    }
                    break;

                case 'extdTransfer':
                    let couponID = prompt("가지고 계신 쿠폰ID를 입력해주세요.", "");

                    if (couponID === null) {
                        return; // '취소'를 눌렀을 경우 함수 종료
                    }

                    $.ajax({
                        url: '/coupon/check',
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify({ couponID: couponID }),
                        success: function(response) {
                            if(response !== 1) {
                                alert("쿠폰 ID를 확인해주세요.");
                                cancelClick();
                                return;
                            }

                            if (confirm("정말 " + choiceLocker + "위치를 연장하시겠습니까?")) {
                                if (couponID === null) {
                                    return; // '취소'를 눌렀을 경우 함수 종료
                                }

                                if (choiceLocker.substring(0, 1) === '4') {
                                    lockerCode = "01";
                                    lockerID = "01";
                                    forPtagString = "4층-";

                                } else {
                                    lockerCode = "02";
                                    lockerID = "02";
                                    forPtagString = "5층-";
                                }

                                if (choiceLocker.substring(2).length === 1) {
                                    lockerID += ("0" + choiceLocker.substring(2));
                                    forPtagString += choiceLocker.substring(2);
                                } else {
                                    lockerID += choiceLocker.substring(2);
                                    forPtagString += choiceLocker.substring(2);
                                }

                                mebrID = document.getElementById(forPtagString).innerText;

                                const lockerDto = {
                                    lockerID: lockerID,
                                    mebrID: loginID,
                                    extdDays: 30
                                };

                                // 서버로 PATCH 요청
                                fetch(`/locker/` + lockerID + `/extend`, {
                                    method: 'PATCH',
                                    headers: {
                                        'Content-Type': 'application/json',
                                    },
                                    body: JSON.stringify(lockerDto),
                                })
                                    .then(response => {
                                        if (response.ok) {
                                            alert("락커 연장이 완료되었습니다.");
                                            location.reload();
                                        } else {
                                            throw new Error("락커 연장에 실패했습니다.");
                                        }
                                    })
                                    .catch((error) => {
                                        console.error('Error:', error);
                                        alert("연장 실패: " + error);
                                        cancelClick();
                                        location.reload();
                                    });
                            } else {
                                cancelClick();
                            }
                        },
                        error: function(error) {
                            console.log('쿠폰ID 확인 중 에러 발생:', error);
                        }
                    });
                    break;

                case 'regTransfer':

                    let confirmRegistration = confirm("정말 " + choiceLocker + "위치로 등록하시겠습니까?");

                    if (confirmRegistration) {

                        let couponID = prompt("가지고 계신 쿠폰ID를 입력해주세요.", "");

                        if (couponID === null) {
                            return; // '취소'를 눌렀을 경우 함수 종료
                        }

                        $.ajax({
                            url: '/coupon/check',
                            type: 'POST',
                            contentType: 'application/json',
                            data: JSON.stringify({ couponID: couponID }), // couponID를 JSON 객체의 속성으로 전송
                            success: function(response) {
                                if(response !== 1) {
                                    alert("쿠폰 ID를 확인해주세요.");
                                    cancelClick();
                                    return;
                                }

                                useDays = 30;
                                makeEndDate(parseInt(useDays, 10));
                                var confirmEndDate = confirm("사용기간은 " + useDays + "일이고, 종료날짜는 " + endDate.toISOString().split('T')[0] + " 입니다. 맞으면 확인을 눌러주세요.");

                                if (confirmEndDate) {
                                    // 락커 ID 및 코드 설정
                                    if (choiceLocker.substring(0, 1) === '4') {
                                        lockerCode = "01";
                                        lockerID = "01";
                                        forPtagString = "4층-";
                                    } else {
                                        lockerCode = "02";
                                        lockerID = "02";
                                        forPtagString = "5층-";
                                    }

                                    if (choiceLocker.substring(2).length === 1) {
                                        lockerID += ("0" + choiceLocker.substring(2));
                                        forPtagString += choiceLocker.substring(2);
                                    } else {
                                        lockerID += choiceLocker.substring(2);
                                        forPtagString += choiceLocker.substring(2);
                                    }

                                    const lockerDto = {
                                        lockerID: lockerID,
                                        mebrID: loginID,
                                        startDate: startDate,
                                        endDate: endDate
                                    };

                                    // 서버로 Post 요청
                                    fetch(`/locker/register`, {
                                        method: 'Post',
                                        headers: {
                                            'Content-Type': 'application/json',
                                        },
                                        body: JSON.stringify(lockerDto),
                                    })
                                        .then(response => {
                                            if (response.ok) {
                                                alert("락커 등록이 완료되었습니다.");
                                                location.reload();
                                            } else {
                                                throw new Error("락커 등록에 실패했습니다.");
                                            }
                                        })
                                        .catch((error) => {
                                            console.error('Error:', error);
                                            alert("등록 실패: " + error);
                                            cancelClick();
                                            location.reload();
                                        });
                                } else {
                                    alert("등록을 취소하셨습니다.");
                                    cancelClick();
                                }
                            },
                            error: function(error) {
                                console.log('쿠폰ID 확인 중 에러 발생:', error);
                            }
                        });
                    } else {
                        cancelClick();
                    }
                    break;


                case 'removeTransfer':
                    // 삭제 관련 로직 처리
                    confirm("정말 " + choiceLocker + "위치를 삭제하시겠습니까?");
                    if (confirm) {

                        if (choiceLocker.substring(0, 1) === '4') {
                            lockerCode = "01";
                            lockerID = "01";
                            forPtagString = "4층-";

                        } else {
                            lockerCode = "02";
                            lockerID = "02";
                            forPtagString = "5층-";
                        }

                        if (choiceLocker.substring(2).length === 1) {
                            lockerID += ("0" + choiceLocker.substring(2));
                            forPtagString += choiceLocker.substring(2);
                        } else {
                            lockerID += choiceLocker.substring(2);
                            forPtagString += choiceLocker.substring(2);
                        }

                        mebrID = document.getElementById(forPtagString).innerText;

                        const lockerDto = {
                            lockerID: lockerID,
                            mebrID: mebrID,
                        };

                        // 서버로 PATCH 요청
                        fetch(`/locker/` + lockerID + `/delete`, {
                            method: 'PATCH',
                            headers: {
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify(lockerDto),
                        })
                            .then(response => {
                                if (response.ok) {
                                    alert("락커 삭제가 완료되었습니다.");
                                    location.reload();
                                } else {
                                    throw new Error("락커 삭제에 실패했습니다.");
                                }
                            })
                            .catch((error) => {
                                console.error('Error:', error);
                                alert("삭제 실패: " + error);
                                cancelClick();
                                location.reload();
                            });
                    } else {
                        cancelClick();
                    }
                    break;

                default:
                    alert("아무것도 해당안됨");
                    break;
            }
        }

        function isOnlyNumber(value) {
            return !isNaN(value) && isFinite(value);
        }

        function isValidEmail(email) {
            let emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            return emailRegex.test(email);
        }

        function makeEndDate(useDays) {
            let today = new Date();
            endDate = new Date(today); // 오늘 날짜를 기반으로 새 Date 객체 생성
            endDate.setDate(today.getDate() + useDays); // 날짜 변경
        }

        floor4.addEventListener("click", changeFloor);

        floor5.addEventListener("click", changeFloor);

        moveBtn.addEventListener("click", moveNo);

        regBtn.addEventListener("click", regNo);

        extdBtn.addEventListener("click", extdNo);

        removeBtn.addEventListener("click", removeNo);

        for (let i = 0; i < lockerCollection4.length; i++) {
            lockerCollection4[i].addEventListener("click", function (event) {
                lockerClick(this.id, event);
            });
        }

        for (let i = 0; i < lockerCollection5.length; i++) {
            lockerCollection5[i].addEventListener("click", function (event) {
                lockerClick(this.id, event);
            });
        }
    }
</script>

<footer>
    <jsp:include page="../footer.jsp"/>
</footer>

</body>
</html>