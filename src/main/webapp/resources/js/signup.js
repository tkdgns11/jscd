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
    const name = document.getElementById("name");
    const birth = document.getElementById("birth");
    const id = document.getElementById("id");
    const pwd = document.getElementById("pwd");
    const pwdChk = document.getElementById("pwdChk")
    const selectGender = document.getElementsByName("gender");
    let gender;
    for(const option of selectGender){
        if(option.checked){
            gender = option.value;
            break;
        }
    }


    const phone = document.getElementById("phone");

    //모든 공백 체크 정규식
    var empReg = /\s/g;
    // 이름 정규식
    const nameReg =/^([가-힣]{2,10}|[a-zA-Z]{4,20})$/;
    // 생년월일 정규식
    var birthReg = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))$/;
    // 이메일 검사 정규식
    var idReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    // 비밀번호 정규식
    var pwdReg = /^[A-Za-z0-9`~!@#\$%\^&\*\(\)\{\}\[\]\-_=\+\\|;:'"<>,\./\?]{8,20}$/;
    // 휴대폰 번호 정규식
    var phoneReg = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;



    if(
        !nameValid(name, nameReg) ||
        !birthValid(birth, birthReg) ||
        !idValid(id, idReg) ||
        !pwdValid(pwd, pwdChk, pwdReg) ||
        !genderValid(gender) ||
        !phoneValid(phone, phoneReg)
    ){
        alert("유효성 검사 실패");
    } else {
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
}

function  nameValid(name, nameReg){
    /*이름
    1.이름 잘 적었는지
    */
    if(name.value==""){
        alert("이름을 입력해주세요");
        return false;
    };

    if(nameReg.test(name.value)==false){
        alert("이름은 한글 2자~10자, 영문 4자~20자로 해주세요");
        return false;
    }

    return true;

}
function  birthValid(birth, birthReg){
    /*생년월일
    1.생년월일 6자리 잘 적었는지
    */
    if(birth.value==""){
        alert("생년월일을 입력해주세요");
        return false;
    };

    if (!birthReg.test(birth.value)) {
        alert("정규식에 안맞아");
        return false;
    }
    return true;
}

function  idValid(id,idReg){
    /*id
    1.id 잘적었는지
    2.인증번호 확인
    */
    if(id.value==""){
        alert("아이디를 입력해주세요.");
        return false;
    };

    if(!idReg.test(id.value)){
        alert("이메일 양식을 확인하세요.")
        return false;
    }
    return true;
}
function  pwdValid(pwd, pwdChk, pwdReg){
    /*pwd
    1.패스워드 대소문자
    2.패스워드 체크
    */
    if(pwd.value==""){
        alert("패스워드를 입력해주세요.");
        return false;
    }

    if(pwdChk.value==""){
        alert("패스워드 확인을 위해 한번 더 입력해주세요.");
        return false;
    }

    if(pwd.value!==pwdChk.value){
        alert("입력한 패스워드가 다릅니다. 확인해주세요.");
        return false;
    };

    if(!pwdReg.test(pwd.value)) {
        alert("8~20자 영문 대소문자, 숫자, 특수문자를 사용하세요.");
        return false;
    }

    return true;
}
function  genderValid(gender){
    /*성별
    1.성별 체크 했는지
    */
    if(gender==null||gender==undefined){
        alert("성별을 입력해주세요.");
        return false;
    };

    return true;
}

function  phoneValid(phone, phoneReg){
    /*핸드폰번호
    1.핸드폰 번호 제대로 작성 했는지
    */
    if(phone.value==""){
        alert("연락처를 확인하세요.");
        return false;
    }

    if(!phoneReg.test(phone.value)){
        alert("연락처 번호를 확인하세요");
        return false;
    }

    return true;


}


/*
    작성자: 강정수
    작성일: 2023.11.19
    작성기능: 회원가입 이메일 인증 api 구현
 */

$('#emailChkBtn').click(function (){
    const email = $('#id').val(); //이메일 주소값 가져오기
    console.log(email);
    const checkInput = $('#emailChkInput') //인증 번호 입력하는 곳

    $.ajax({
        type:'get',
        url : '/member/mailChk?email='+email, // get방식이라서 url 뒤에 email을 줄 수 있다.
        success: function (data){
            console.log(data);
            checkInput.attr('disabled',false);
            code=data;
            alert("인증번호가 전송됐습니다.");
        }
    });
});

/*
    작성자: 강정수
    작성일: 2023.11.23
    작성기능: 핸드폰 번호 자동 하이픈
 */

const autoHyphen = (target) => {
    target.value = target.value
        .replace(/[^0-9]/g, '')
        .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}