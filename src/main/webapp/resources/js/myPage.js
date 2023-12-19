

function infoModify() {
    const pwdChk = document.getElementById("pwd2");

    //정규식
    var pwdReg = /^[A-Za-z0-9`~!@#\$%\^&\*\(\)\{\}\[\]\-_=+\\|;:'"<>,./?]{8,20}$/

    if (!pwdValid(pwdChk, pwdReg)) {
        return;
    } else {
        //회원 정보 수정 진행
        const form = document.createElement('form');
        form.setAttribute('method', 'post');
        form.setAttribute('action', '/member/memberEdit/modify');

        //닉네임,비밀번호,생일,휴대전화
        var nickname = document.getElementById('nickname');
        var pwd = document.getElementById('pwd2');
        var birth = document.getElementById('birth');
        var phone = document.getElementById('phone');
        var id = document.getElementById('id');

        form.appendChild(nickname);
        form.appendChild(pwd);
        form.appendChild(birth);
        form.appendChild(phone);
        form.appendChild(id);
        console.log(form)
        document.body.appendChild(form);
        form.submit();

    }


}

function pwdValid(pwdChk, pwdReg) {

    //패스워드 공백 확인
    if (pwdChk.value == "") {
        alert("패스워드를 입력해주세요.");
        return false;
    }

    //패스워드 확인 칸 공백 확인
    if (pwdChk.value == "") {
        alert("패스워드 확인을 위해 한번 더 입력해주세요.");
        return false;
    }

    //패스워드 정규식 유효성 검사
    if (!pwdReg.test(pwdChk.value)) {
        alert("8~20자 영문 대소문자, 숫자, 특수문자를 사용하세요.");
        return false;
    }

    return true;
}



$(document).ready(function () {

    //수정할 뒤에 포커스 위치하도록
    var len = $('#nickname').val().length;
    $('#nickname').focus();
    $('#nickname')[0].setSelectionRange(len, len);

    //전화번호 자동 하이픈
    const autoHyphen = (target) => {
        target.value = target.value
            .replace(/[^0-9]/g, '')
            .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
    }


    //비밀번호 일치 여부 효과
    $(".password").on("propertychange change keyup paste input", function() {

        let pass1 = $("#pwd1").val();
        let pass2 = $("#pwd2").val();

        if (pass1 != "" || pass2 != "") {
            if (pass1 == pass2) {
                $("#checkPwd").html("비밀번호 일치");
                $("#checkPwd").attr("color", "green");
                $("#pwd2").css("border", "1.5px solid green");
            } else {
                $("#checkPwd").html("비밀번호 불일치");
                $("#checkPwd").attr("color", "red");
                $("#pwd2").css("border", "1.5px solid red");

            }
        }

    })

})
