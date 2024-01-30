<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en"> 
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/signup.css"/>">
    <script type="text/javascript" src="<c:url value="/js/signup.js"/>"></script>

    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | 회원가입</title>
    <style>

        /* //모달팝업을 감싸고 있는 최상위 부모 */
        .signModalBox {
            position: fixed;
            z-index: 1;
            padding-top: 100px;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
            display: none;
        }

        /* //모달 팝업창 */
        .modalBody {
            width: 500px;
            height: 300px;
            padding: 30px 30px;
            margin: 0 auto;
            border: 1px solid #777;
            background-color: #fff;
            border-radius: 20px;
        }
    </style>

</head>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>
<form>
    <div id="wrap">
        <div id="signupHeader" style="border: none; box-shadow: none;">
            <img src="<c:url value="/img/mainlogo.png"/>">
            <p class="typing-txt">정석코딩</p>
            <h1 id="receipt-text-01"></h1>
        </div>
        <div style="margin-top: 50px;">
            <input type="hidden" name="mebrNO" >
            <div>
                <img src="<c:url value="/img/signup_user.png"/>">
                <input type="text" id="name" name="name" placeholder="이름">
            </div>

            <div style="border-bottom: none;">
                <img src="<c:url value="/img/signup_birth.png"/>">
                <input type="text" id="birth" name="birth" placeholder="생년월일 6자리 (Ex.990317)">
            </div>
        </div>
        <div>
            <div>
                <img id="idImg" src="<c:url value="/img/signup_user.png"/>">
                <input type="text" id="id" name="id" placeholder="아이디(Ex.ghdrlfehd@naver.com)">
                <input type="button" id="idChkBtn" value="중복확인" onclick="idCheck()" class="signup_btn">
                <input type="hidden" id="idChkYN" value="">
            </div>
            <div>
                <img id="certificationImg" src="<c:url value="/img/signup_user.png"/>">
                <input type="text" id="certification" name="인증번호" placeholder="인증번호를 입력해주세요." autocomplete="off">
                <input type="button" id="emailChkBtn" value="본인인증" class="signup_btn">
                <input type="hidden" id="emailChkYN" value="">
            </div>
            <div>
                <img src="<c:url value="/img/signup_pwd.png"/>">
                <input type="password" id="pwd" name="pwd" placeholder="비밀번호(영문자 + 숫자 + 특수문자 포함 필수)"style="width: 400px;" autocomplete="off">
            </div>

            <div style="border-bottom: none;">
                <img src="<c:url value="/img/signup_pwd.png"/>">
                <input type="password" id="pwdChk" name="pwdChk" placeholder="비밀번호 확인" autocomplete="off">
            </div>
        </div>
        <div>
            <div class="radioBox">
                <img src="<c:url value="/img/signup_gender.png"/>">
                <!-- 라디오 버튼 1 -->
                <div id="radioBtn">
                    <label class="radio-label" style="border-right: none;">
                        <input type="radio" class="radio-input"  id="male" name="gender" value="1">
                        <span style="border-right: solid 1px #61b1fa; ; border-top-right-radius: 0px; border-bottom-right-radius: 0px;">남자</span>
                    </label>
                    <!-- 라디오 버튼 2 -->
                    <label class="radio-label" style="border-left: none;">
                        <input type="radio" class="radio-input" id="female" name="gender" value="2">
                        <span style="border-top-left-radius: 0px; border-bottom-left-radius: 0px;">여자</span>
                    </label>
                </div>
            </div>
            <div id="phoneBox" style="border-bottom: none;">
                <img src="<c:url value="/img/signup_phone.png"/>">
                <input type="text"  id="phone" name="phone" oninput="autoHyphen(this)" maxlength="13" placeholder="전화번호를 입력해주세요.">
            </div>
        </div>
        <div id="termsBox">
            <div id="termsBox_title">
                <input type="checkbox" class="selectAll" id="selectAll" name="selectAll" onclick="window.selectAll(this)">
                <p>전체 동의</p>
            </div>
            <div>
                <input type="checkbox" class="terms" id="serviceChkYN" name="serviceChkYN" onclick="checkSelectAll()">
                <p class="termsBox_element">서비스 이용약관 동의 (필수)</p>
                <p class="termsDetail"><span id="detailBtn">상세보기></span></p>
            </div>
            <div>
                <input type="checkbox" class="terms" id="privacyChkYN" name="privacyChkYN" onclick="checkSelectAll()">
                <p class="termsBox_element">개인정보 수집 및 이용 동의 (필수)</p>
                <p class="termsDetail"><span id="detailBtn2">상세보기></span></p>
            </div>
            <div>
                <input type="checkbox" class="terms" id="ageChkYN" name="ageChkYN" onclick="checkSelectAll()">
                <p class="termsBox_element">만 14세 이상입니다 (필수)</p>
                <p class="termsDetail"><span id="detailBtn3">상세보기></span></p>
            </div>
            <div style="border: none">
                <input type="checkbox" class="terms" id="marketingChkYN" name="marketingChkYN" onclick="checkSelectAll()">
                <p class="termsBox_element">마케팅 수신 동의 (선택)</p>
                <p class="termsDetail"><span id="detailBtn4">상세보기></span></p>
            </div>
        </div>
        <div id="btnBox" style="border: none; box-shadow: none;">
            <input type="button" id="signupBtn" value="가입 완료" onclick="member('signup')">
            <input type="button" id="cancleBtn" value="취소" onclick="cancle()" style="margin-left: 20px;">
        </div>


    </div>
</form>
<%--약관동의 모달창--%>
<div id="modalWrap" class="signModalBox">
    <div class="modalContent">
        <div class="modalBody">
            <h1>서비스 이용약관 동의(필수)</h1>
            <textarea rows="17" cols="57">제 1 조 (목적)</textarea>
            <input type="button" class="registeBtn" id="agreeBtn" value="동의">
            <input type="button" class="cancleBtn" id="closeBtn" value="닫기">
        </div>
    </div>
</div>

<div id="modalWrap2" class="signModalBox">
    <div class="modalContent">
        <div class="modalBody">
            <h1>개인정보 수집 및 이용 동의(필수)</h1>
            <textarea rows="17" cols="57">제 1 조 (목적)</textarea>
            <input type="button" class="" id="agreeBtn2" value="동의">
            <input type="button" class="" id="closeBtn2" value="닫기">
        </div>
    </div>
</div>

<div id="modalWrap3" class="signModalBox">
    <div class="modalContent">
        <div class="modalBody">
            <h1>만 14세 이상(필수)</h1>
            <textarea rows="17" cols="57">제 1 조 (목적)</textarea>
            <input type="button" class="" id="agreeBtn3" value="동의">
            <input type="button" class="" id="closeBtn3" value="닫기">
        </div>
    </div>
</div>

<div id="modalWrap4" class="signModalBox">
    <div class="modalContent">
        <div class="modalBody">
            <h1>마케팅 수신 동의(선택)</h1>
            <textarea rows="17" cols="57">제 1 조 (목적)</textarea>
            <input type="button" class="" id="agreeBtn4" value="동의">
            <input type="button" class="" id="closeBtn4" value="닫기">
        </div>
    </div>
</div>

<footer>
    <jsp:include page="../footer.jsp" flush="true"/>
</footer>

<script>
    const modal = document.getElementById('modalWrap');
    const modal2 = document.getElementById('modalWrap2');
    const modal3 = document.getElementById('modalWrap3');
    const modal4 = document.getElementById('modalWrap4');

    $(document).ready(function () {

        $('#detailBtn').on("click", function () {
            modal.style.display = 'block'; //상세보기 클릭 시, 모달창 보임
        });

        $('#detailBtn2').on("click", function () {
            modal2.style.display = 'block'; //상세보기 클릭 시, 모달창 보임
        });

        $('#detailBtn3').on("click", function () {
            modal3.style.display = 'block'; //상세보기 클릭 시, 모달창 보임
        });

        $('#detailBtn4').on("click", function () {
            modal4.style.display = 'block'; //상세보기 클릭 시, 모달창 보임
        });

        $('#closeBtn').on("click", function () {
            modal.style.display = 'none'; //모달창 속 닫기 버튼 클릭 시, 모달창 안 보임
        });
        $('#closeBtn2').on("click", function () {
            modal2.style.display = 'none'; //모달창 속 닫기 버튼 클릭 시, 모달창 안 보임
        });
        $('#closeBtn3').on("click", function () {
            modal3.style.display = 'none'; //모달창 속 닫기 버튼 클릭 시, 모달창 안 보임
        });
        $('#closeBtn4').on("click", function () {
            modal4.style.display = 'none'; //모달창 속 닫기 버튼 클릭 시, 모달창 안 보임
        });

        $(window).on("click", function (event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
            if (event.target == modal2) {
                modal2.style.display = "none";
            }
            if (event.target == modal3) {
                modal3.style.display = "none";
            }
            if (event.target == modal4) {
                modal4.style.display = "none";
            }
        })

        $('#agreeBtn').on("click", function () {
            $('#serviceChkYN').prop("checked", true);
            modal.style.display = 'none';
        })
        $('#agreeBtn2').on("click", function () {
            $('#privacyChkYN').prop("checked", true);
            modal2.style.display = 'none';

        })
        $('#agreeBtn3').on("click", function () {
            //같은 값을 가진 id의 checkBox의 checked가 활성화
            $('#ageChkYN').prop("checked", true);
            modal3.style.display = 'none';

        })
        $('#agreeBtn4').on("click", function () {
            $('#marketingChkYN').prop("checked", true);
            modal4.style.display = 'none';

        })
    })
</script>
<script>
    window.onload = function() {
        typing();
    };
    //로고 텍스트 타이핑 효과
    function typing() {
        let typingBool = false;
        let typingIdx = 0;
        let typingTxt;
        let tyInt;

        // 타이핑될 텍스트 가져오기
        typingTxt = $(".typing-txt").text();
        typingTxt = typingTxt.split(""); // 한글자씩 분리

        if (typingBool == false) {
            // 타이핑이 진행되지 않았다면
            typingBool = true;
            tyInt = setInterval(typing, 220); // 반복동작
        }

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
    }
</script>
</body>

</html>
