// typing() 내에서 참조 위한 전역 변수 선언
let typingBool = false;
let typingIdx = 0;
let typingTxt;
let tyInt;

window.addEventListener('load', function () {
    // 주문내역 바로가기 연결
    const goOrderlist = document.getElementById("go_orderlist");
    // 마이페이지 바로가기 연결
    const goMypage = document.getElementById("go_mypage");

    // 5. 주문내역 페이지 이동
    if (goOrderlist) {
        goOrderlist.addEventListener("click", function() {
            console.log('Button clicked!');
            ToGoOrderlist();
        });
    } else {
        console.error('Element with id "go_orderlist" not found!');
    }

    // 6. 마이페이지 이동
    if (goMypage) {
        goMypage.addEventListener("click", function() {
            console.log('Button clicked!');
            ToGoMypage();
        });
    } else {
        console.error('Element with id "go_mypage" not found!');
    }
    
    // 7. 타이핑
    // 타이핑될 텍스트 가져오기
    typingTxt = $(".typing-txt").text();
    typingTxt = typingTxt.split(""); // 한글자씩 분리

    if (typingBool == false) {
        // 타이핑이 진행되지 않았다면
        typingBool = true;
        tyInt = setInterval(typing, 100); // 반복동작
    }
});

// 주문내역 바로가기 연결
function ToGoOrderlist() {
    console.log('go orderlist');
    window.location.href = "http://localhost:8080/order/orderList";
}

// 마이페이지 바로가기 연결
function ToGoMypage() {
    console.log('go mypage');
    window.location.href = "http://localhost:8080/member/memberEdit";
}

// 타이핑 효과
function typing() {
    if (typingIdx < typingTxt.length) {
        // 타이핑될 텍스트 길이만큼 반복
        $("#receipt-text-01").append(typingTxt[typingIdx]);
        // 한글자씩 이어붙임
        typingIdx++;
    } else {
        //끝나면 반복종료
        clearInterval(tyInt);
    }
}