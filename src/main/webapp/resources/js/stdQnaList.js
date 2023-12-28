// // 메서드 실제 적용 영역
// window.onload = function () {
//     // 버튼에 클릭 이벤트 연결
//     document.getElementById('writeBtn').addEventListener('click', function() {
//         // 버튼 클릭시 '/board/qna/stdQnaWrite' 이동
//         window.location.href = '/board/qna/stdQnaWrite';
//     });
// }
window.addEventListener('load', function () {
    // 버튼에 클릭 이벤트를 연결합니다.
    document.getElementById('writeBtn').addEventListener('click', function() {
        // 버튼 클릭시 '/board/qna/stdQnaWrite' 페이지로 이동합니다.
        window.location.href = '/board/qna/stdQnaWrite';
    });
});
