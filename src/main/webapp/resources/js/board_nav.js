window.addEventListener('load', function () {
    //board 페이지의 nav : 현재 위치 표시
    handleActiveLink();
});

// 현재 페이지 URL과 일치하는 a 태그에 특정 스타일 적용 함수
function handleActiveLink() {
    var url = window.location.href;

    // nav 메뉴 링크 각각에 대해
    var links = document.querySelectorAll("#boardList_nav a");
    links.forEach(function(link) {
        // 만약 현재 페이지의 URL이 링크의 href를 포함하고 있다면
        if (url.includes(link.href)) {
            // 해당 링크에 'active' 클래스 추가
            link.classList.add("active");
        } else {
            // 포함하지 않는 링크는 'active' 클래스 제거
            link.classList.remove("active");
        }
    });
}
