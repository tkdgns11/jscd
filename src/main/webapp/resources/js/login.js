// typing() 내에서 참조 위한 전역 변수 선언
let typingBool = false;
let typingIdx = 0;
let typingTxt;
let tyInt;

window.onload = function (){
    var loginBtn = document.getElementById("loginBtn");
    loginBtn.addEventListener('click', function (){
        login();
    });

    // 타이핑
    // 타이핑될 텍스트 가져오기
    typingTxt = $(".typing-txt").text();
    typingTxt = typingTxt.split(""); // 한글자씩 분리

    if (typingBool == false) {
        // 타이핑이 진행되지 않았다면
        typingBool = true;
        tyInt = setInterval(typing, 220); // 반복동작
    }
}

function login(){
    console.log("hello login");
    const id = document.getElementById("id");
    const pwd = document.getElementById("pwd");
    const rememberIdChk = document.getElementById("rememberId");
    const toURL = document.getElementById("toURL");
    let rememberId;

    if(rememberIdChk.checked){
        rememberId = "true";
    }else {
        rememberId = 'false'
    }


    let loginData = {"id":id.value, "pwd":pwd.value, "rememberId":rememberId,"toURL":toURL.value};

    $.ajax({
        url:"/member/login",
        type:"POST",
        contentType:"application/json; charset=utf-8",
        data:JSON.stringify(loginData),
        error : function (error){
            console.log("error");
        },
        success : function (data){
            console.log("성공");
            if(data.redirect){
                window.location.href = data.redirect;
            }
        }
    });
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