window.onload = function () {
    // q&a 바로가기 연결
    const goQna = document.getElementById("orderlist_goQna");
    const goFaq = document.getElementById("goFaq");
    // 계좌번호 복사하기 버튼 불러오기 후 변수에 담기
    const copyBtn = document.getElementById("orderlist_copyBtn");
    // 메일 보내기 변수
    const copyMail = document.getElementById("copyMail");
    const slrMail = document.getElementById("slrMail_copy").textContent;
    // 결제 상태에 따라 주문 내역 title 색상 변경하기 위한 변수
    const statusElement = document.querySelector('#orderlist_content-title div');
    const titleElement = document.getElementById('orderlist_content-title');
    // aside_orderlist_info 영역 footer 닿으면 사라지는 기능 위한 변수
    const footer = document.querySelector('footer'); // footer 선택
    const fixedElement = document.getElementById("aside_orderlist_info"); // fixed 요소 선택


    // 결제 상태에 따른 orderlist_content-title 색상 변화
    switch(statusElement.textContent.trim()) {
        case '결제 대기중':
            titleElement.style.backgroundColor = '#ff5959';
            break;
        case '결제 취소':
            titleElement.style.backgroundColor = '#adadad';
            break;
        default:
            titleElement.style.backgroundColor = '#0185FE';
            break;
    }

    // Q&A 게시판 이동
    if (goQna) {
        goQna.addEventListener("click", function () {
            console.log('Button clicked!');
            ToGoQna();
        });
    } else {
        console.error('Element with id "goQna" not found!');
    }

    // FAQ 게시판 이동
    if (goFaq) {
        goFaq.addEventListener("click", function () {
            console.log('Button clicked!');
            ToGoFaq();
        });
    } else {
        console.error('Element with id "goFaq" not found!');
    }

    // actNum 복사
    if (copyBtn) {
        console.log('copyBtn found!'); // copyBtn이 존재하는지 확인
        copyBtn.addEventListener("click", function () {
            console.log('copyBtn clicked!'); // 버튼 클릭 이벤트가 발생하는지 확인
            ActNumcopys();
        });
    } else {
        console.error('copyBtn not found!'); // copyBtn이 존재하지 않는 경우 에러 메시지 출력
    }

    // 메일 보내기
    if (copyMail) {
        copyMail.addEventListener("click", function () {
            window.location.href = `mailto:${slrMail}`;
        });
    } else {
        console.error('copyMail not found!');
    }

    // aside_orderlist_info 영역 footer 닿으면 사라지기
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

    handlePageButtonClick();
} // window.onload 종료


// qna 바로가기 연결
function ToGoQna() {
    console.log('go qna');
    window.location.href = "http://localhost:8080/board/qna/allqnaList";
}

// faq 바로가기 연결
function ToGoFaq() {
    console.log('go faq');
    window.location.href = "http://localhost:8080/board/faq";
}

// 계좌번호 복사하기
function ActNumcopys() {
    // 1. #slrActNum 내 불러온 계좌번호를 변수에 담아 저장
    var text = document.querySelector('#copy_slrActNum').textContent;
    console.log('Text to copy: ', text);

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

// 페이지 버튼 클릭 이벤트 처리 함수 정의
function handlePageButtonClick() {
    var paginationLinks = document.querySelectorAll('.pagination a');

    paginationLinks.forEach(function(link) {
        link.addEventListener('click', function(event) {
            // event.preventDefault();

            // 기존에 .active 클래스를 가지는 요소에서 .active 클래스를 제거
            var currentActive = document.querySelector('.pagination a.active');
            if (currentActive) {
                currentActive.classList.remove('active');
            }

            // 클릭한 요소에 .active 클래스를 추가
            this.classList.add('active');
        });
    });
}