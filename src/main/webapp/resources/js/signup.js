//취소
function cancle(){
    window.location.href = '/';
}

//회원가입 및 개인정보 변경 유효성 검사 및 ajax를 사용
function member(value){
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
    //체크박스 체크 여부
    const checkboxIds = ["serviceChkYN", "privacyChkYN", "ageChkYN", "marketingChkYN"];
    const checkboxStates = {};

    checkboxIds.forEach(id => {
       if(document.getElementById(id).checked){
           checkboxStates[id] = "Y";
       }else{
           checkboxStates[id] = "N";
       }


    });

    //모든 공백 체크 정규식
    var empReg = /\s/g;
    // 이름 정규식
    const nameReg =/^([가-힣]{2,10}|[a-zA-Z]{4,20})$/;
    // 생년월일 정규식
    var birthReg = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))$/;
    // 이메일 검사 정규식
    var idReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    // 비밀번호 정규식
    var pwdReg = /^[A-Za-z0-9`~!@#\$%\^&\*\(\)\{\}\[\]\-_=+\\|;:'"<>,./?]{8,20}$/

    // 휴대폰 번호 정규식
    var phoneReg = /^(\+82|0)\s?(10|11|16|17|18|19)-?[0-9]{3,4}-?[0-9]{4}$/


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
        const signupData = {"id":id.value, "pwd":pwd.value, "birth":birth.value, "name":name.value, "gender":gender};
        const data= {...signupData, ...checkboxStates}
        console.log(data);
            //회원가입일 경우
            $.ajax({
                url:"/member/signup",
                type:"POST",
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify(data),
                error : function (error){
                    console.log("error");
                },
                success : function (data){
                    // if(data.redirect){
                    //     window.location.href = data.redirect;
                    // }
                }
            });


    }
}


//이름 유효성 검사
function  nameValid(name, nameReg){

    //1.이름 잘 적었는지
    if(name.value==""){
        alert("이름을 입력해주세요.");
        return false;
    };
    //2. 이름은 한글 2~10자, 영문 4~20자
    if(nameReg.test(name.value)==false){
        alert("이름은 한글 2자~10자, 영문 4자~20자로 해주세요.");
        return false;
    }

    return true;

}
//생일 유효성 검사
function  birthValid(birth, birthReg){

    //1. 생년월일 공백 확인
    if(birth.value==""){
        alert("생년월일을 입력해주세요");
        return false;
    };

    //2. 생년월일 6자리 잘 적었는지
    if (!birthReg.test(birth.value)) {
        alert("정규식에 안맞아");
        return false;
    }
    return true;
}

//아이디 유효성 검사
function  idValid(id,idReg){
    //아이디 공백 확인
    if(id.value==""){
        alert("아이디를 입력해주세요.");
        return false;
    };
    //아이디 정규식 유효성 검사
    if(!idReg.test(id.value)){
        alert("이메일 양식을 확인하세요.")
        return false;
    }
    return true;
}

//패스워드 유효성 검사
function  pwdValid(pwd, pwdChk, pwdReg){

    //패스워드 공백 확인
    if(pwd.value==""){
        alert("패스워드를 입력해주세요.");
        return false;
    }

    //패스워드 확인 칸 공백 확인
    if(pwdChk.value==""){
        alert("패스워드 확인을 위해 한번 더 입력해주세요.");
        return false;
    }

    //패스워드와 패스워드 확인 같은지
    if(pwd.value!==pwdChk.value){
        alert("입력한 패스워드가 다릅니다. 확인해주세요.");
        return false;
    };

    //패스워드 정규식 유효성 검사
    if(!pwdReg.test(pwd.value)) {
        alert("8~20자 영문 대소문자, 숫자, 특수문자를 사용하세요.");
        return false;
    }

    return true;
}
//성별 유효성 검사
function  genderValid(gender){
    //성별 null 또는 undefined인지
    if(gender==null||gender==undefined){
        alert("성별을 입력해주세요.");
        return false;
    };
    return true;
}

//핸드폰 번호 유효성 검사
function  phoneValid(phone, phoneReg){
    //핸드폰 번호 공백 확인
    if(phone.value==""){
        alert("연락처를 확인하세요.");
        return false;
    }

    //핸드폰 번호 정규식 유효성 검사
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

//회원탈퇴
function memberDel(){
    console.log("hello del")
}

//핸드폰 번호 자동 하이픈
const autoHyphen = (target) => {
    target.value = target.value
        .replace(/[^0-9]/g, '')
        .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}

//약관 동의
function checkSelectAll()  {
    // 전체 체크박스
    const checkboxes= document.querySelectorAll(".terms");
    // 선택된 체크박스
    const checked= document.querySelectorAll(".terms:checked");
    // select all 체크박스
    const selectAll
        = document.querySelector('input[name="selectAll"]');

    if(checkboxes.length === checked.length)  {
        selectAll.checked = true;
    }else {
        selectAll.checked = false;
    }

}

//전체 체크
function selectAll(selectAll)  {

    const checkboxes= document.querySelectorAll(".terms");
    checkboxes.forEach((checkbox) => {
        checkbox.checked = selectAll.checked
    })
}