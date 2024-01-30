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
<%--<jsp:include page="../admin/adminHeader.jsp" flush="false"/>--%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>정석코딩</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        html, body {
            width: 100%;
            height: auto;
        }

        #couponArea {
            display: flex;
            flex-direction: row;
            width: 100%;
            height: auto;
            margin-top: 80px;
            margin-bottom: 50px;
            position: absolute;
            top: 0;
            left: 0;
        }

        #couponArea > nav {
            background-color: rgba(0, 0, 0, 0.8);
            height: auto;
            width: 300px;
        }

        #couponArea > main {
            width: calc(100% - 300px);
            height: auto;
            position: relative;
            margin-top: 30px;
            margin-bottom: 30px;
        }

        #whole {
            width: auto;
            height: auto;
            margin-left: 1rem;
            margin-right: 1rem;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin-bottom: 1rem;
        }

        button {
            margin: 10px;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        .coupon-item {
            border-bottom: 1px solid #eee;
            padding: 10px;
            text-align: left;
        }

        .coupon-item:last-child {
            border-bottom: none;
        }

        #couponAreatitle {
            font-size: 2rem;
            font-weight: 500;
            margin-bottom: 1rem;
        }

        #issuedCouponArea {
            height: 100%;
            width: 100%;
            display: flex;
            flex-direction: column;
            overflow: hidden;
        }

        .issuedCouponRows {
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            align-items: center;
            width: 100%;
            padding: 0.5rem;
            border-bottom: 0.5px solid #000;
        }

        .tableBodyRows:hover {
            background-color: #FFE6E6;
        }

        .tableElement {
            font-size: 1rem;
            flex: 1; /* flex 속성을 사용하여 너비를 균등하게 분배 */
            text-align: center;
            padding: 0.25rem;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        .extendElement {
            flex: 2;
        }


    </style>
</head>

<body>

<header>
    <jsp:include page="../admin/header.jsp"/>
</header>
<div id="couponArea">
    <nav>
        <jsp:include page="../admin/sidebar.jsp"/>
    </nav>
    <main>

        <div id="whole">
            <div class="container">
                <h1 id="couponAreatitle">정석코딩 쿠폰 목록</h1>
                <div id="couponList"></div>
                <button id="addCouponInfo">쿠폰 등록</button>
                <button id="createCouponButton">쿠폰 생성</button>
                <button id="modifyCouponInfo">수정</button>
                <button id="removeCouponInfo">삭제</button>
            </div>
            <div id="issuedCouponArea">
            </div>
        </div>

    </main>
</div>

<script>
    window.onload = function () {

        let couponList = document.getElementById('couponList');
        let createCouponButton = document.getElementById('createCouponButton'); //쿠폰생성 버튼 요소 가져옴
        let addCouponInfo = document.getElementById('addCouponInfo'); //쿠폰추가 버튼 요소 가져옴

        //let couponAllSelectCheckbox; // 생성된 쿠폰 전체선택체크박스
        let couponSelectCheckbox; // 생선된 쿠폰 row 체크박스

        let madeCouponID = [];
        let madeCouponNO; //서버로 전송할 쿠폰NO

        let startUseDate = "";
        let endUseDate = "";
        let usableStartTime = "";
        let usableEndTime = "";

        let couponData = [
            <c:forEach var="coupon" items="${couponList}" varStatus="status">
            {
                couponNO: `${coupon.couponNO}`,
                name: `${coupon.name}`,
                description: `${coupon.description}`,
                maxIssueNO: `${coupon.maxIssueNO}`,
                maxPerMebr: `${coupon.maxPerMebr}`,
                maxPerUse: '${coupon.maxPerUse}',
                validityPeriodIssue: '${coupon.validityPeriodIssue}',
                specialNotes: '${coupon.specialNotes}',
                isAvailable: '${coupon.isAvailable}'
            }
            <c:if test="${!status.last}">, </c:if>
            </c:forEach>
        ];

        let checkboxes = []; //couponInfo 체크박스들에 대한 이벤트 추가

        let couponInfoListBoxes = [];

        function loadCouponTemplates() {
            couponList.innerHTML = '';
            couponInfoListBoxes = []; // 배열 초기화

            let div = document.createElement('div');
            div.className = 'issuedCouponRows';
            div.id = 'tableHeaderRow';
            div.style.display = 'flex';
            div.innerHTML = '<span class="tableElement">선택</span>' +
                '<span class="tableElement">쿠폰NO</span>' +
                '<span class="tableElement extendElement">쿠폰명</span>' +
                '<span class="tableElement extendElement">설명</span>' +
                '<span class="tableElement">최대발행수</span>' +
                '<span class="tableElement">ID당최대사용수</span>' +
                '<span class="tableElement">회당최대사용수</span>' +
                '<span class="tableElement">유효기간</span>' +
                '<span class="tableElement extendElement">유의사항</span>' +
                '<span class="tableElement">사용가능여부</span>';
            // '<span class="tableElement">수정</span>'+
            // '<span class="tableElement">삭제</span>';

            couponList.appendChild(div);

            let tmpCount = 0;

            couponData.forEach(function (coupon) {

                let contentDiv = document.createElement('div');

                contentDiv.className = 'issuedCouponRows tableBodyRows';
                contentDiv.innerHTML = '<input type="checkbox" class="coupon-checkbox tableElement" value="' + tmpCount + '">' +
                    '<span class="tableElement">' + coupon.couponNO + '</span>' +
                    '<span class="tableElement extendElement">' + coupon.name + '</span>' +
                    '<span class="tableElement extendElement">' + coupon.description + '</span>' +
                    '<span class="tableElement">' + coupon.maxIssueNO + '</span>' +
                    '<span class="tableElement">' + coupon.maxPerMebr + '</span>' +
                    '<span class="tableElement">' + coupon.maxPerUse + '</span>' +
                    '<span class="tableElement">' + coupon.validityPeriodIssue + '</span>' +
                    '<span class="tableElement extendElement">' + coupon.specialNotes + '</span>' +
                    '<span class="tableElement">' + (coupon.isAvailable === 'y' ? 'y' : 'n') + '</span>';

                couponList.appendChild(contentDiv); // couponDiv를 couponList에 추가

                couponInfoListBoxes.push(coupon); // coupon을 배열에 추가


                tmpCount++;
            });

            // 체크박스들에 대한 이벤트 리스너 추가
            checkboxes = document.querySelectorAll('.coupon-checkbox');

            checkboxes.forEach(function (checkbox) {
                checkbox.addEventListener('change', function () {
                    if (checkbox.checked) {
                        checkboxes.forEach(function (otherCheckbox) {
                            if (otherCheckbox !== checkbox) {
                                otherCheckbox.checked = false;
                            }
                        });
                    }
                });
            });
        }

        function createCoupon() {
            // 체크된 쿠폰들을 확인
            if (checkboxes.length === 0 || !Array.from(checkboxes).some(checkbox => checkbox.checked)) {
                alert("발급할 쿠폰을 선택해주세요.");
                return;
            }

            // 선택된 체크박스의 쿠폰 데이터 가져오기
            let selectedCoupons = Array.from(checkboxes).filter(checkbox => checkbox.checked).map(checkbox => {
                return couponData[checkbox.value];
            });

            madeCouponNO = selectedCoupons[0].couponNO;

            // 발급할 쿠폰의 갯수 입력받기
            let createCount = prompt("선택한 쿠폰에 대해 발급할 쿠폰의 수를 입력하세요:", "10");
            createCount = parseInt(createCount, 10);

            if (isNaN(createCount) || createCount <= 0) {
                alert("유효한 숫자를 입력해주세요.");
                return;
            }

            // 발급 정보 입력받기
            startUseDate = prompt("사용 가능 시작일을 입력하세요 (예: 2023-01-01):", "");

            if (startUseDate === null) {
                return; // '취소'를 눌렀을 경우 함수 종료
            }

            if (!isValidDate(startUseDate) && startUseDate !== "") {
                alert("유효하지 않은 날짜 형식입니다.");
                return;
            }

            endUseDate = prompt("사용 가능 종료일을 입력하세요 (예: 2023-01-31):", "");

            if (endUseDate === null) {
                return; // '취소'를 눌렀을 경우 함수 종료
            }

            if (!isValidDate(endUseDate) && endUseDate !== "") {
                alert("유효하지 않은 날짜 형식입니다.");
                return;
            }

            if (new Date(startUseDate) > new Date(endUseDate)) {
                alert("시작일은 종료일보다 이전이어야 합니다.");
                return;
            }

            usableStartTime = prompt("사용 가능 시작시각을 입력하세요 (예: 09:00):", "");

            if (usableStartTime === null) {
                return; // '취소'를 눌렀을 경우 함수 종료
            }

            if (!isValidTime(usableStartTime) && usableStartTime !== "") {
                alert("유효하지 않은 시각 형식입니다.");
                return;
            }

            usableEndTime = prompt("사용 가능 종료시각을 입력하세요 (예: 18:00):", "");
            if (usableEndTime === null) {
                return; // '취소'를 눌렀을 경우 함수 종료
            }

            if (!isValidTime(usableEndTime) && usableEndTime !== "") {
                alert("유효하지 않은 시각 형식입니다.");
                return;
            }

            if (usableStartTime > usableEndTime) {
                alert("시작시각은 종료시각보다 이전이어야 합니다.");
                return;
            }

            // startUseDate가 빈 문자열이면 현재 날짜로 설정, 그렇지 않으면 기존 값을 그대로 사용
            startUseDate = startUseDate === "" ? getCurrentDateFormatted() : startUseDate;

            // endUseDate가 빈 문자열이면 '9999-12-31'로, 그렇지 않으면 기존 값을 그대로 사용
            endUseDate = endUseDate === "" ? new Date('9999-12-31').toISOString().split('T')[0] : endUseDate;

            // usableStartTime이 빈 문자열이면 "00:00"으로, 아니면 그대로 사용
            usableStartTime = usableStartTime || "00:00:00";

            // usableEndTime이 빈 문자열이면 "24:00"으로, 아니면 그대로 사용
            usableEndTime = usableEndTime || "23:59:59";

            // 발급된 쿠폰 정보를 테이블 형태로 표시
            let issuedCouponArea = document.getElementById('issuedCouponArea');
            issuedCouponArea.innerHTML = ''; // 이전 내용 초기화

            let div = document.createElement('div');
            div.className = 'issuedCouponRows';
            div.id = 'tableHeaderRow';
            div.style.display = 'flex';
            div.innerHTML = '<input type="checkbox" id="couponAllSelectCheckbox" onclick="window.onClickCheckAll(this)">' +
                '<span class="tableElement">생성된 쿠폰 ID</span>' +
                ' <span class="tableElement">쿠폰명</span>' +
                '<span class="tableElement">사용시작일</span>' +
                '<span class="tableElement">사용종료일</span>' +
                '<span class="tableElement">사용시작시각</span>' +
                '<span class="tableElement">사용종료시각</span>';

            issuedCouponArea.appendChild(div);

            //여기서 꺼내서 넘겨주니까 coupon.name 으로 값을 찍을 수 있음.
            selectedCoupons.forEach(selectedCoupon => {
                for (let i = 0; i < createCount; i++) {
                    let couponId = generateRandomCouponId();
                    addCouponToList(couponId, issuedCouponArea, selectedCoupon, startUseDate, endUseDate, usableStartTime, usableEndTime);
                }
            });

            let buttonDiv = document.createElement('div');
            buttonDiv.id = 'tableBottomRow';
            buttonDiv.style.display = 'flex';
            buttonDiv.style.flexDirection = 'row';
            buttonDiv.style.justifyContent = 'center';

            buttonDiv.innerHTML = '<button class="admin" id="removeBtn">삭제</button>' +
                '<button class="admin" id="issueBtn" onclick="window.couponIssue()">발급하기</button>' +
                '<button class="admin" id="cancleBtn">취소</button>';


            issuedCouponArea.appendChild(buttonDiv);


            couponSelectCheckbox = document.getElementsByClassName('couponSelectCheckbox'); //쿠폰 row 체크박스

            //가져온 모든 input태그 각각에 이벤트 적용
            for (let i = 0; i < couponSelectCheckbox.length; i++) {
                couponSelectCheckbox[i].addEventListener("click", onClickCheck);
            }

        }

        // 날짜 형식 검사 함수
        function isValidDate(dateString) {
            const regEx = /^\d{4}-\d{2}-\d{2}$/;
            if (!dateString.match(regEx)) return false;  // 형식 검사
            const d = new Date(dateString);
            const dNum = d.getTime();
            if (!dNum && dNum !== 0) return false; // NaN 값 체크
            return d.toISOString().slice(0, 10) === dateString;
        }

        // 시각 형식 검사 함수
        function isValidTime(timeString) {
            const regEx = /^([01]\d|2[0-3]):([0-5]\d)$/;
            return regEx.test(timeString);
        }

        function addCouponToList(couponId, issuedCouponArea, coupon, startUseDate, endUseDate, usableStartTime, usableEndTime) {
            let div = document.createElement('div');
            div.className = 'issuedCouponRows tableBodyRows';
            div.innerHTML = '<input type="checkbox" class="couponSelectCheckbox" >' +
                '<span class="tableElement">' + couponId + '</span>' +
                '<span class="tableElement">' + coupon.name + '</span>' +
                '<span class="tableElement">' + startUseDate + '</span>' +
                '<span class="tableElement">' + endUseDate + '</span>' +
                '<span class="tableElement">' + usableStartTime + '</span>' +
                '<span class="tableElement">' + usableEndTime + '</span>';

            issuedCouponArea.appendChild(div);

        }


        function generateRandomCouponId() {
            let timestamp = new Date().getTime().toString(); // 현재 시간을 밀리초로 가져온 후 문자열로 변환
            let uniquePart = ''; // UUID 부분
            let characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
            let charactersLength = characters.length;
            for (let i = 0; i < 6; i++) { // 6자리의 랜덤 문자열 생성
                uniquePart += characters.charAt(Math.floor(Math.random() * charactersLength));
            }

            //타임스탬프를 3개 부분으로 나누고, 각 부분 사이에 랜덤 문자열 추가
            let part1 = timestamp.substring(0, 5);
            let part2 = timestamp.substring(5, 10);
            let part3 = timestamp.substring(10);

            return part1.trim() + uniquePart.substring(0, 2).trim() + part2.trim() + uniquePart.substring(2, 4).trim() + part3.trim() + uniquePart.substring(4, 6).trim();
        }

        function addNewCoupon() {

        }

        function editCoupon(name) {

        }

        function deleteCoupon(name) {

        }

        function onClickCheck() {
            // 전체 체크박스
            const checkboxes = document.querySelectorAll(".couponSelectCheckbox");
            // 선택된 체크박스
            const checked = document.querySelectorAll(".couponSelectCheckbox:checked");
            // 전체선택 체크박스
            const selectAll
                = document.querySelector('input[id="couponAllSelectCheckbox"]');

            if (checkboxes.length === checked.length) {
                selectAll.checked = true;
            } else {
                selectAll.checked = false;
            }
        }

        addCouponInfo.addEventListener('click', addNewCoupon);

        createCouponButton.addEventListener('click', createCoupon);

        window.onClickCheckAll = function onClickCheckAll(checkbox) {

            // 전체 체크 박스의 상태에 따라 다른 동작 수행
            let checkboxes = document.getElementsByClassName('couponSelectCheckbox');

            for (var i = 0; i < checkboxes.length; i++) {
                checkboxes[i].checked = checkbox.checked;
            }
        }

        // 현재 날짜를 'YYYY-MM-DD' 형식으로 얻기
        function getCurrentDateFormatted() {
            return new Date().toISOString().split('T')[0];
        }

        window.couponIssue = function couponIssue() {

            //생성된 쿠폰목록에서 체크된 체크박스 전체 가져옴
            const checkedCoupon = document.querySelectorAll(".couponSelectCheckbox:checked");

            checkedCoupon.forEach(function (checkbox) {
                // 체크박스 옆에 있는 형제 요소의 ID 값을 가져옴
                let couponId = checkbox.nextElementSibling.innerText;
                madeCouponID.push(couponId);
            });

             let couponDtos = madeCouponID.map((id) => {
                return {
                    couponID: id,
                    couponNO: madeCouponNO,
                    startUseDate: startUseDate,
                    endUseDate: endUseDate,
                    usableStartTime: usableStartTime,
                    usableEndTime: usableEndTime
                };
            });

            // 등록 관련 로직 처리
            confirm("쿠폰을 발급하시겠습니까?");
            if (confirm) {

               // 서버로 Post 요청
                fetch(`/coupon/register`, {
                    method: 'Post',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(couponDtos),
                })
                    .then(response => {
                        if (response.ok) {
                            let tableBottomRow = document.getElementById('tableBottomRow');
                            tableBottomRow.innerHTML += '<button class="admin" onclick="window.exportTableToExcel(\'coupon_data\')">엑셀다운로드</button>';
                            alert("쿠폰 발급이 완료되었습니다.");
                        } else {
                            alert("응답이 발급 실패: ");
                            throw new Error("쿠폰 발급에 실패했습니다.");
                        }
                    })
                    .catch((error) => {
                        console.error('Error:', error);
                        alert("발급 실패: " + error);
                    });

            } else {
                alert("쿠폰발급을 취소하셨습니다.");
                return;

            }
        }

        window.exportTableToExcel = function exportTableToExcel(filename = 'coupon_data') {

            let couponDtos = madeCouponID.map((id) => {
                return {
                    couponID: id,
                    couponNO: madeCouponNO,
                    startUseDate: startUseDate,
                    endUseDate: endUseDate,
                    usableStartTime: usableStartTime,
                    usableEndTime: usableEndTime
                };
            });

            let csvContent = '쿠폰ID,쿠폰NO,사용시작일,사용종료일,사용시작시각,사용종료시각,배포여부\n'; // CSV 헤더

            for (let dto of couponDtos) {
                let rowData = [
                    `"\${dto.couponID}"`,
                    `"\${dto.couponNO}"`,
                    `"\${dto.startUseDate}"`,
                    `"\${dto.endUseDate}"`,
                    `"\${dto.usableStartTime}"`,
                    `"\${dto.usableEndTime}"`,
                    ""
                ];
                csvContent += rowData.join(',') + '\n';
            }

            let link = document.createElement('a');
            link.href = 'data:text/csv;charset=utf-8,' + encodeURIComponent(csvContent);
            link.download = filename + '.csv';
            link.style.display = 'none';

            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
        }

        // 페이지 로드 시 쿠폰 템플릿 로드
        loadCouponTemplates();

    }

</script>

</body>
</html>