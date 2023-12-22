// 메서드 실제 적용 영역
window.onload = function () {
    // 1-1. 결제 방법 버튼 id 불러오기 후 변수에 담기
    const cardPay = document.getElementById("card");
    const kakaoPay = document.getElementById("kakaopay");
    const actShow = document.getElementById("account");
    // 1-2. 계좌번호 복사하기 버튼 불러오기 후 변수에 담기
    const copyBtn = document.getElementById("copyBtn");
    // 1-3. 결제하기 버튼 불러오기 후 변수에 담기
    const lastPayBtn = document.getElementById("price-btn");
    // q&a 바로가기 연결
    const goQna = document.getElementById("goQna");
    // aside_orderlist_info 영역 footer 닿으면 사라지는 기능 위한 변수
    const footer = document.querySelector('footer'); // footer 선택
    const fixedElement = document.getElementById("aside_pay"); // fixed 요소 선택

    let currentPaymentMethod = null;

    const paymentMethods = [cardPay, kakaoPay, actShow];

    const newPaymentFunc = function() {
        const isPaymentSelected = paymentMethods.some(function(button) {
            return button.classList.contains("selected"); // "selected"는 선택된 버튼에 추가되는 클래스 이름이어야 합니다.
        });

        if (!isPaymentSelected) {
            alert('결제 방법을 선택해주세요.');
        } else {
            paymentFunc();
        }
    };

    lastPayBtn.addEventListener("click", newPaymentFunc);
    currentPaymentMethod = newPaymentFunc;


    const setPaymentMethod = function (paymentFunc) {
        if (currentPaymentMethod) {
            lastPayBtn.removeEventListener("click", currentPaymentMethod);
        }
        lastPayBtn.addEventListener("click", paymentFunc);
        currentPaymentMethod = paymentFunc;
    }

    // 2-1. 카드 결제
    cardPay.addEventListener("click", async function () {
        changeBtnColor("card"); // 2-1-1. 클릭 시 색상 변경
        toBackBtnsColor(["kakaopay", "account"]); // 2-1-2. 미클릭 버튼 기존 색상으로 변경
        hideAccountDetails(); // 2-1-3. 다른 계좌 상세 정보 숨기기
        setPaymentMethod(payment); // 2-1-4. '#lastPayBtn' 버튼 클릭 시 NHN 결제 API 호출

    });

    // 2-2. 카카오페이 결제
    kakaoPay.addEventListener("click", function () {
        changeBtnColor("kakaopay"); // 2-2-1. 클릭 시 색상 변경
        toBackBtnsColor(["card", "account"]); // 2-2-2. 미클릭 버튼 기존 색상으로 변경
        hideAccountDetails(); // 2-2-3. 다른 계좌 상세 정보 숨기기
        setPaymentMethod(kakaoRequestPay); // 2-2-4. '#lastPayBtn' 버튼 클릭 시 카카오페이 결제 API 호출

    });

    // 2-3. 계좌이체
    actShow.addEventListener("click", function () {
        changeBtnColor("account"); // 2-3-1. 클릭 시 색상 변경
        toBackBtnsColor(["card", "kakaopay"]); // 2-3-2. 미클릭 버튼 기존 색상으로 변경
        showAccountDetails(); // 2-3-3. 계좌 상세 정보 표시

        // 2-3-4. '#lastPayBtn' 버튼 클릭 시 payment(), kakaoRequestPay() 이벤트 제거
        if (currentPaymentMethod) {
            lastPayBtn.removeEventListener("click", currentPaymentMethod);
            currentPaymentMethod = null;
        }


        // '#lastPayBtn' 버튼 클릭 시 handleLastPayBtnClick 함수가 실행되도록 설정
        setPaymentMethod(handleLastPayBtnClick);

    });

    // 3. actNum 복사
    copyBtn.addEventListener("click", function () {
        ActNumcopys(); //3-1. 복사 버튼을 클릭했을 때 #slrActNum의 내용을 복사
    });

    // 4. Q&A 게시판 이동
    if (goQna) {
        goQna.addEventListener("click", function() {
            console.log('Button clicked!');
            ToGoQna();
        });
    } else {
        console.error('Element with id "goQna" not found!');
    }

    // aside_pay 영역 footer 닿으면 사라지기
    window.addEventListener("scroll", function() {
        var rect = footer.getBoundingClientRect(); // footer의 위치와 크기 정보를 가져옴
        var footerHeight = document.body.scrollHeight - window.innerHeight; // footer의 높이 계산

        if (rect.top < window.innerHeight) {
            // 스크롤이 footer에 닿으면 fixed 요소의 top 위치를 늘림
            fixedElement.style.top = (15 + footerHeight) + '%';
        } else {
            // 그렇지 않으면 원래 위치로
            fixedElement.style.top = '15%';
        }
    });

} //window.onload 종료


// lastPayBtn 버튼 클릭 이벤트 핸들러
async function handleLastPayBtnClick() {

    // 1차 확인
    if (!confirm('강의 시작 하루 전 23:30까지 입금하지 않으면 주문이 취소됩니다.\n결제를 진행하시겠습니까?')) {
        return;
    }

    const odNo = "jscd" + dateChange(); // 주문고유번호 생성
    const id = document.getElementById("id").value; //'현재 로그인한 회원의 id'; 
    const registCode = document.getElementById("registCode").value; //'registCode 값';
    const lastPrice = document.getElementById("lastPrice").value; //'lastPrice 값';
    const title = document.getElementById("title").value; //'title 값'; //추가

    try {
        // 서버에 데이터를 전송하여 stod 테이블에 값을 추가
        const response = await fetch('/order/actPaySuccess', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                odNo: odNo,
                id: id,
                registCode: registCode,
                payType: "계좌이체",
                status: "notPaid",
                slrNo: "1",
                lastPrice: lastPrice,
                title: title //추가
            })
        });

        if (response.ok) {
            window.location.href = "/order/actPaySuccess";
        } else {
            console.error('서버 응답 오류:', response);
        }
    } catch (error) {
        console.error('서버 요청 오류:', error);
    }
}


//포트원 API : 카드 결제 요청
// [1-1] card 결제 API 호출
function payment() {
    // 1. 포트원 계정 연동 및 API 연결
    var IMP = window.IMP;
    IMP.init("imp43021455"); //포트원 API 계정 번호 //시크릿 키 처리 해야함

    // 2-1. order.jsp 전달 된 데이터를 변수에 저장
    const title = document.getElementById("title");
    const lastPrice = document.getElementById("lastPrice");
    const companyName = document.getElementById("companyName")
    const id = document.getElementById("id");
    const name = document.getElementById("name");
    const phone = document.getElementById("phone");
    // 2-2. 주문 고유 번호 전체 생성
    const odNo = "jscd" + dateChange();

    // 3. 결제 API 호출
    // 각 파라미터 : 페이지에 전달 된 데이터 사용
    IMP.request_pay({
        pg: 'kcp', //결제 API 사용 : NHN KCP
        pay_method: 'card', //결제 방법
        merchant_uid: odNo, //주문 고유 번호
        name: title.value, //결제 상품 이름
        amount: lastPrice.value, //결제 상품 최종 가격
        company: companyName.value, //상품 판매 상호명
        buyer_email: id.value, //구매자 이메일 (=아이디)
        buyer_name: name.value, //구매자 이름
        buyer_tel: phone.value, //구매자 전화번호
    }, function (rsp) {
        // 4-1. 결제 성공
        if (rsp.success) {
            // 4-2. 결제 성공 시 포트원에서 전달 받을 데이터 리스트들을 변수에 저장
            // requestPay()에 넘겨주기 위함
            const rspData = {
                odNo: odNo, //주문 고유 번호
                creditNum: rsp.card_number, //결제카드 번호
                cardType: rsp.card_name, //결제카드 종류
                payType: rsp.pay_method, //결제방법
                status: rsp.status, //결제상태
                instlFees: rsp.card_quota, //할부개월
                payDay: getDate(), //카드 승인일
                payTime: toConvertUnixTimestamp(rsp) //카드 승인시각
            };

            // 4-3. requestPay() 호출 + rspData 데이터 넘겨주기
            requestPay(rspData);

            // 5. 결제 실패 : 실패 알림창 띄우기
        } else {
            alert("[결제 실패] 결제를 다시 시도해주세요.");
            console.log("결제 실패" + rsp.error_msg);
        }
    });
}

// [1-2] kakaoPay 결제 API 호출
function kakaoRequestPay() {
    // 1. 포트원 계정 연동 및 API 연결 
    var IMP = window.IMP;
    IMP.init("imp43021455"); //포트원 API 계정 번호 //시크릿 키 처리 해야함

    // 2-1. order.jsp 전달 된 데이터를 변수에 저장
    const title = document.getElementById("title");
    const lastPrice = document.getElementById("lastPrice");
    const companyName = document.getElementById("companyName")
    const id = document.getElementById("id");
    const name = document.getElementById("name");
    const phone = document.getElementById("phone");
    // 2-2. 주문 고유 번호 전체 생성
    const odNo = "jscd" + dateChange();

    // 3. 결제 API 호출
    // 각 파라미터 : 페이지에 전달 된 데이터 사용
    IMP.request_pay({
        pg: 'kakaopay', //결제 API 사용 : NHN KCP
        pay_method: 'kakaopay', //결제 방법
        merchant_uid: odNo, //주문 고유 번호
        name: title.value, //결제 상품 이름
        amount: lastPrice.value, //결제 상품 최종 가격
        company: companyName.value, //상품 판매 상호명
        buyer_email: id.value, //구매자 이메일 (=아이디)
        buyer_name: name.value, //구매자 이름
        buyer_tel: phone.value, //구매자 전화번호
    }, function (rsp) {
        // 4-1. 결제 성공
        if (rsp.success) {
            // 4-2. 결제 성공 시 포트원에서 전달 받을 데이터 리스트들을 변수에 저장
            // requestPay()에 넘겨주기 위함
            const rspData = {
                odNo: odNo, //주문 고유 번호
                creditNum: rsp.card_number, //결제카드 번호 //rsp.card_number,
                cardType: 'kakaopay', //결제카드 종류 //'kakaopay'
                payType: 'kakaopay', //결제방법
                status: rsp.status, //결제상태
                instlFees: rsp.card_quota, //할부개월 //테스트모드 : 일시불 고정
                payDay: getDate(), //카드 승인일
                payTime: toConvertUnixTimestamp(rsp) //카드 승인시각
            };

            // 4-3. requestPay() 호출 + rspData 데이터 넘겨주기
            requestPay(rspData);

            // 5. 결제 실패 : 실패 알림창 띄우기
        } else {
            alert("[결제 실패] 결제를 다시 시도해주세요.");
            console.log("결제 실패" + rsp.error_msg);
        }
    });
}

// [2] 주문 및 결제 정보 데이터 넘기기
function requestPay(rspData) {

    //order.jsp 중 <input> id에 value 값 추가
    $("#odNo").val(rspData.odNo);
    $("#creditNum").val(rspData.creditNum);
    $("#cardType").val(rspData.cardType);
    $("#payType").val(rspData.payType);
    $("#status").val(rspData.status);
    $("#instlFees").val(rspData.instlFees);
    $("#payDay").val(rspData.payDay);
    $("#payTime").val(rspData.payTime);

    // 1. serialize() 메서드를 사용하여 폼 데이터를 URL-encoded 문자열로 가져오기
    const formDataString = $('#orderData').serialize();

    // 2. URL-encoded 문자열을 객체로 변환
    const formDataObject = {};
    formDataString.split('&').forEach(pair => {
        const [name, value] = pair.split('=');
        formDataObject[name] = decodeURIComponent(value.replace(/\+/g, ' '));
    });


    // 2.1. creditNum 값을 formDataObject에 추가
    formDataObject.creditNum = rspData.creditNum;
    formDataObject.cardType = rspData.cardType;
    formDataObject.payType = rspData.payType;
    formDataObject.status = rspData.status;
    formDataObject.instlFees = rspData.instlFees;
    formDataObject.payDay = rspData.payDay;
    formDataObject.payTime = rspData.payTime;

    // 3. 객체를 JSON 문자열로 변환
    const formDataJSON = JSON.stringify(formDataObject);

    // JSON 문자열을 콘솔에 출력
    console.log('JSON success' + formDataJSON);

    // formDataJSON을 OrderController.java로 넘김
    $.ajax({
        url: '/order/paySuccess',
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: formDataJSON,
        success: function (response) {
            console.log("ajax 성공");

            // 서버로부터 결제 완료 응답을 받은 후 페이지 이동
            window.location.href = "/order/paySuccess";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("ajax 실패: " + textStatus + ", " + errorThrown);
        }
    });
}

// 주문번호 생성 (년도/월/일/시/분/초/밀리초)
function dateChange() {
    // 1. 날짜 데이터 불러오기
    var today = new Date();

    // 2. 날짜 데이터 중 각 부분 -> String으로 변환
    var year = (today.getFullYear()).toString(); //년도
    var month = (today.getMonth() + 1).toString(); //월은 0부터 시작하므로 +1
    var day = (today.getDate()).toString(); //일
    var hours = (today.getHours()).toString(); //시
    var minutes = (today.getMinutes()).toString();  //분
    var seconds = (today.getSeconds()).toString();  //초
    var milliseconds = (today.getMilliseconds()).toString(); //밀리초

    // 3-1. String 변환 과정 중 최소 자릿수일 때 앞에 0 붙이기
    month = (month.length === 1) ? '0' + month : month;
    day = (day.length === 1) ? '0' + day : day;
    hours = (hours.length === 1) ? '0' + hours : hours;
    minutes = (minutes.length === 1) ? '0' + minutes : minutes;
    seconds = (seconds.length === 1) ? '0' + seconds : seconds;

    // 3-2. milliseconds -> 세 자리로 만들기 위해 앞에 0 추가
    // 주문 고유 번호가 중복되지 않기 위함
    while (milliseconds.length < 3) {
        milliseconds = '0' + milliseconds;
    }

    // 4. 주문 고유 번호 데이터 형식(년도/월/일/시/분/초/밀리초) 지정하여 값 변수에 담기
    var makeMerchantUid = year + month + day + hours + minutes + seconds + milliseconds;

    // 5. 변환 된 형식의 주문 고유 번호 데이터 반환
    return makeMerchantUid;
}

// 결제 승인일 반환
function getDate() {
    // 1. 날짜 데이터 불러오기
    var today = new Date();

    // 2. 날짜 데이터 중 각 부분 -> String으로 변환
    var year = (today.getFullYear()).toString(); //년도
    var month = (today.getMonth() + 1).toString(); //월은 0부터 시작하므로 +1
    var day = (today.getDate()).toString(); //일

    // 3. String 변환 과정 중 최소 자릿수일 때 앞에 0 붙이기
    month = (month.length === 1) ? '0' + month : month;
    day = (day.length === 1) ? '0' + day : day;

    // 4. 날짜 데이터 형식(20231209) 지정하여 값 변수에 담기
    var makePayDate = year + month + day;

    // 5. 변환 된 형식의 날짜 반환
    return makePayDate;
}

// 결제승인시각 Unix timestamp -> 일반 시각 변환
function toConvertUnixTimestamp(rsp) {
    // 1. payment() 내 불러온 rsp.paid_at 값을 저장할 변수 설정
    let unix_timestamp = rsp.paid_at;

    // 2. 유닉스 타임스탬프 기반 신규 자바스크립트 날짜 객체 생성
    // 인자가 밀리초 단위가 되도록 1000 곱하기 (기존 유닉스 타임스탬프 : 초 단위임)
    const date = new Date(unix_timestamp * 1000);

    // 3-1. 타임스탬프에서 시간 가져오기
    const hours = date.getHours();

    // 3-2. 타임스탬프에서 분 가져오기
    const minutes = "0" + date.getMinutes();

    // 3-3. 타임스탬프에서 초 가져오기
    const seconds = "0" + date.getSeconds();

    // 4. 대중적인 시각 형식(24:50:50)으로 변환
    const formattedTime = hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2);

    // 5. 변환 된 형식의 시각 반환
    return formattedTime;
}

// #shwAcnNmb 숨김
function hideAccountDetails() {
    // document.getElementById("shwAcnNmb").style.display = "none";
    document.getElementById("shwAcnNmb").style.visibility = "hidden";
}

// #shwAcnNmb 표시
function showAccountDetails() {
    // document.getElementById("shwAcnNmb").style.display = "flex";
    document.getElementById("shwAcnNmb").style.visibility = "visible";
}

// 결제 방법 '버튼' 클릭 시, 클린 된 버튼의 색상 변경
// 1. changeBtnColor() 호출 시 id를 인자로 받아오도록 설정
function changeBtnColor(id) {
    // 2. 받아온 id를 변수에 담기
    var paymentBtns = document.getElementById(id);

    // 3. border, backgroundColor, text color 설정
    paymentBtns.style.color = "#0185FE";
    paymentBtns.style.fontWeight = "bold";
}

// 결제 방법 '버튼' 클릭 시, 클릭되지 않은 버튼의 색상 변경
// 1. toBackBtnsColor() 호출 시 배열 형태의 ids를 인자로 받아오도록 설정
// ids : 배열 처리 되어 저장된 여러 개의 id 값
function toBackBtnsColor(ids) {
    // 2-1. forEach 메서드 사용하여 각 인자들 처리
    ids.forEach(id => {
        // 2-2. 받아온 id를 변수에 담기
        var paymentBtns = document.getElementById(id);

        // 3. border, backgroundColor, text color 기존 디자인으로 설정
        if (paymentBtns) {
            paymentBtns.style.color = "#676363";
            paymentBtns.style.fontWeight = "normal";
        }
    });
}

// 계좌번호 복사하기
function ActNumcopys() {
    // 1. #slrActNum 내 불러온 계좌번호를 변수에 담아 저장
    var text = document.querySelector('#slrActNum').textContent;

    // 2-1. navigator.clipboard.writeText(text) : 클립보드에 특정 텍스트를 쓰는 비동기 함수 사용 (작업 완료 시 Promise 반환)
    // Promise : 비동기 작업의 최종 완료(또는 실패) & 그 결과 값 표시
    // 2-2. then (Promise 객체의 then 메서드) : Promise가 성공적으로 완료 시 호출할 콜백 함수 등록
    // navigator.clipboard.writeText(text) 작업 성공 시 then 메서드 안의 함수가 실행됨
    navigator.clipboard.writeText(text).then(function () {
        // 3. 클립보드 복사 성공
        alert('계좌 번호가 클립보드에 복사되었습니다.');
    }, function (err) {
        // 4. 클립보드 복사 실패
        alert('이 브라우저에서는 클립보드 복사 기능을 지원하지 않습니다.');
    });
}

// qna 바로가기 연결
function ToGoQna() {
    console.log('go qna');
    window.location.href = "http://localhost:8080/board/qna/allqnaList";
}

