// const textarea = document.getElementById("content");
//
// function f1(e) {
//     let value = e.value;
//     textarea.style.fontSize = value + "px";
// }
// function  f2(e){
//     if(textarea.style.fontWeight==="bold"){
//         textarea.style.fontWeight="normal";
//         e.classList.remove("active");
//     }else{
//         textarea.style.fontWeight="bold";
//         e.classList.add("active");
//     }
// }
// function  f3(e){
//     if(textarea.style.fontWeight==="italic"){
//         textarea.style.fontWeight="normal";
//         e.classList.remove("active");
//     }else{
//         textarea.style.fontWeight="italic";
//         e.classList.add("active");
//     }
// }
// function  f4(e){
//     if(textarea.style.textDecoration==="underline"){
//         textarea.style.textDecoration="none";
//         e.classList.remove("active");
//     }else{
//         textarea.style.textDecoration="underline";
//         e.classList.add("active");
//     }
// }
//
// function  f5(e){
//     textarea.style.textAlign = "left"
// }
// function  f6(e){
//     textarea.style.textAlign = "center"
// }
// function  f7(e){
//     textarea.style.textAlign = "right"
// }
// function  f8(e){
//     if(textarea.style.textTransform==="uppercase"){
//         textarea.style.textTransform="none";
//         e.classList.remove("active");
//     }else{
//         textarea.style.textTransform="uppercase";
//         e.classList.add("active");
//     }
// }
//
// function  f9(){
//   textarea.style.fontWeight = "normal";
//   textarea.style.textAlign = "left";
//   textarea.style.fontStyle = "normal";
//   textarea.style.textTransform = "capitalize";
//   textarea.value = "";
// }
//
// function f10(e){
//     let value = e.value;
//     textarea.style.color = value;
// }
//
// window.addEventListener("load", ()=> {
//     textarea.value = "";
// });

// window.onload = function () {
//     // 현재 페이지 URL 가져오기
//     var url = window.location.href;
//
//     // 페이지네이션 링크 각각에 대해
//     var links = document.querySelectorAll("#board_paging a");
//     links.forEach(function(link) {
//         // 만약 현재 페이지의 URL이 링크의 href와 일치한다면
//         if (link.href === url) {
//             // 해당 링크에 'active' 클래스를 추가합니다.
//             link.classList.add("active");
//         }
//     });
// };

window.onload = function () {
    // 페이징 요소 개별 클릭 시 현재 페이지 표시
    handleOnLoad();
}

// 페이징 요소 개별 클릭 시 현재 페이지 표시
function handleOnLoad() {
    var url = window.location.href; // 현재 페이지의 URL을 가져옵니다.

    // 페이징 링크 요소 각각에 대해
    var links = document.querySelectorAll("#board_paging a");
    links.forEach(function(link) {
        // 만약 현재 페이지의 URL이 링크의 href와 일치한다면
        if (link.href === url) {
            // 해당 링크에 'active' 클래스를 추가합니다.
            link.classList.add("active");
        }
    });
}

