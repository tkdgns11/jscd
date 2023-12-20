

$(document).ready(function () {
    $(".modifyBtn").on("click", function () {
        const form = document.createElement('form');
        form.setAttribute('method', 'post');
        form.setAttribute('action', '/member/memberEdit');

        var pwd = document.getElementById('pwd');
        form.appendChild(pwd);
        document.body.appendChild(form);
        form.submit();

    })
    //
    // $("#pwd").on("propertychange change keyup paste input", function () {
    //     let pass1 = $("#pwd").val();
    //     let pass2 = "${memberDto.pwd}"
    //
    //     if (pass1 != "") {
    //         if (pass1 === pass2) {
    //             $("#checkPwd").html("비밀번호 일치");
    //             $("#checkPwd").attr("color", "green");
    //             $("#myPagePwdChk").css("border", "1.5px solid green");
    //         } else {
    //             $("#checkPwd").html("비밀번호 불일치");
    //             $("#checkPwd").attr("color", "red");
    //             $("#myPagePwdChk").css("border", "1.5px solid red");
    //
    //         }
    //     }
    //
    // })

})
