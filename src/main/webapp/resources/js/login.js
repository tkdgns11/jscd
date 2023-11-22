function kakaoLogin(){

    $.ajax({
        url:"/member/signup",
        type:"POST",
        data:$('form').serialize(),
        error : function (error){
            console.log("error");
        },
        success : function (data){
            if(data.redirect){
                window.location.href = data.redirect;
            }
        }
    });


}