window.onload = function (){
    var signupBtn = document.getElementById("signupBtn");
    signupBtn.addEventListener('click', function (){
       signup();
    });
}
/*
    작성자: 강정수
    작성일: 2023.11.19
    작성기능: 회원가입 자바스크립트 구현
 */
function signup(){
    console.log("signjs도착");
    const name = document.getElementById("name");
    const birth = document.getElementById("birth");
    const id = document.getElementById("id");
    const pwd = document.getElementById("pwd");
    const pwdChk = document.getElementById("pwdChk")
    const gender = document.getElementById("gender");
    const phone1 = document.getElementById("phone1");
    const phone2 = document.getElementById("phone2");
    const phone3 = document.getElementById("phone3");
/*
    nameValid(name);
    birthValid(birth);
    idValid(id);
    pwdValid(pwd, pwdChk);
    genderValid(gender);
    phoneValid(phone1, phone2, phone3);
*/
    $.ajax({
        url:"/member/signup",
        type:"POST",
        data:$('form').serialize(),
        error : function (error){
            console.log("error");
        },
        success : function (data){
            console.log("success");
        }
    });


}

function  nameValid(name){
    /*이름
    1.이름 잘 적었는지
    */
    if(name.value()==""){
        alert("이름을 입력해주세요");
        name.focus();
        return false;
    };
}
function  birthValid(birth){
    /*생년월일
    1.생년월일 6자리 잘 적었는지
    */
    if(birth.value()==""){
        alert("생년월일을 입력해주세요");
        name.focus();
        return false;
    };

}
function  idValid(id){
    /*id
    1.id 잘적었는지
    2.인증번호 확인
    */
    if(id.value()==""){
        alert("아이디를 입력해주세요.");
        id.focus();
        return false;
    };
}
function  pwdValid(pwd, pwdChk){
    /*pwd
    1.패스워드 대소문자
    2.패스워드 체크
    */
    if(pwd.value()==""){
        alert("패스워드를 입력해주세요.");
        pwd.focus();
        return false;
    }
    else if(pwdChk==""){
        alert("패스워드 확인을 위해 한번 더 입력해주세요.");
        pwdChk.focus();
        return false;
    }

    if(!pwd.value().equals(pwdChk.value())){
        alert("입력한 패스워드가 다릅니다. 확인해주세요.");
        pwd.focus();
        pwdChk.focus();
        return false;
    };
}
function  genderValid(gender){
    /*성별
    1.성별 체크 했는지
    */
    if(gender.value()==""){
        alert("성별을 입력해주세요.");
        gender.focus();
        return false;
    };
}

function  phoneValid(phone1, phone2, phone3){
    /*핸드폰번호
    1.핸드폰 번호 제대로 작성 했는지
    */
    for(var i=1; i<=3; i++) {
        var phoneNum = "phone" + i;
        console.log(phoneNum);
        if (phoneNum == "") {
            alert("휴대전화 번호를 확인해주세요.");
            phone1.focus();
            phone2.focus();
            phone3.focus();
        }
    }
    /*
    if(phone1.value()==""){
        alert("핸드폰 번호를 확인해주세요.")
        phone1.focus();
        return false;
    }
    if(phone2.value()==""){
        alert("핸드폰 번호를 확인해주세요.")
        phone1.focus();
        return false;
    }
    if(phone3.value()==""){
        alert("핸드폰 번호를 확인해주세요.")
        phone1.focus();
        return false;
    }
     */
}
