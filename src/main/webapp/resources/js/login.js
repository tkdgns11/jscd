
window.onload = function (){
    var loginBtn = document.getElementById("loginBtn");
    loginBtn.addEventListener('click', function (){
        login();
    });
}

function login(){
    console.log("hello login");
    const id = document.getElementById("id");
    const pwd = document.getElementById("pwd");
    const rememberIdChk = document.getElementById("rememberId");
    let rememberId;

    if(rememberIdChk.checked){
        rememberId = "true";
    }else {
        rememberId = 'false'
    }


    let loginData = {"id":id.value, "pwd":pwd.value, "rememberId":rememberId};

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