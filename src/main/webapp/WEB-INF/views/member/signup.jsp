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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/signup.css"/>">
    <script type="text/javascript" src="<c:url value="/js/signup.js"/>"></script>
    <title>회원가입 폼</title>

</head>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>
<form>
    <div id="wrap">
        <div id="signupHeader" style="border: none;">
            <img src="<c:url value="/img/logo.png"/>">
            <h1>정석코딩</h1>
        </div>
        <div style="margin-top: 50px;">
            <input type="hidden" name="mebrNo" value="${memberDto.mebrNo}">
            <div>
                <img src="<c:url value="/img/signup_user.png"/>">
                <input type="text" id="name" name="name" placeholder="이름" value="${memberDto.name}">
            </div>

            <div style="border-bottom: none;">
                <img src="<c:url value="/img/signup_birth.png"/>">
                <input type="text" id="birth" name="birth" placeholder="생년월일 6자리 (Ex.990317)" value="${memberDto.birth}">
            </div>
        </div>
        <div>
            <div>
                <img src="<c:url value="/img/signup_user.png"/>">
                <input type="text" id="id" name="id" placeholder="아이디(Ex.ghdrlfehd@naver.com)" value="${memberDto.id}">
                <c:if test="${empty memberDto.id}">
                    <input type="button" id="idChkBtn" value="중복확인" onclick="" class="signup_btn">
                </c:if>
            </div>
            <c:if test="${empty memberDto.id}">
                <div>
                    <img src="<c:url value="/img/signup_user.png"/>">
                    <input type="text" id="emailChkInput" name="인증번호" placeholder="인증번호를 입력해주세요." autocomplete="off">
                    <input type="button" id="emailChkBtn" value="본인인증" onclick="" class="signup_btn">
                </div>
            </c:if>
            <div>
                <img src="<c:url value="/img/signup_pwd.png"/>">
                <input type="password" id="pwd" name="pwd" placeholder="비밀번호(영문자 + 숫자 + 특수문자 포함 필수)" value="${memberDto.pwd}" style="width: 400px;" autocomplete="off">
            </div>

            <div style="border-bottom: none;">
                <img src="<c:url value="/img/signup_user.png"/>">
                <input type="password" id="pwdChk" name="pwdChk" placeholder="비밀번호 확인" autocomplete="off">
            </div>
        </div>
        <div>
            <div class="radioBox">
                <img src="<c:url value="/img/signup_gender.png"/>">
                <!-- 라디오 버튼 1 -->
                <div id="radioBtn">
                    <label class="radio-label" style="border-right: none;">
                        <input type="radio" class="radio-input"  id="male" name="gender" value="0" <c:if test="${memberDto.gender eq '0'}">checked</c:if>>

                        <span style="border-right: 1px solid rgb(128, 128, 128); border-top-right-radius: 0px; border-bottom-right-radius: 0px;">남자</span>
                    </label>
                    <!-- 라디오 버튼 2 -->
                    <label class="radio-label" style="border-left: none;">
                        <input type="radio" class="radio-input" id="female" name="gender" value="1" <c:if test="${memberDto.gender eq '1'}">checked</c:if>>
                        <span>여자</span>
                    </label>
                </div>
            </div>
            <div id="phoneBox" style="border-bottom: none;">
                <img src="<c:url value="/img/signup_phone.png"/>">
                <input type="text"  id="phone" name="phone" oninput="autoHyphen(this)" maxlength="13" placeholder="전화번호를 입력해보세요!" value="${memberDto.phone}">
            </div>
        </div>
    <c:if test="${empty memberDto.id}">
        <div style="border: none; display: flex; flex-direction: row;justify-content: center; align-items: center">
            <input type="button" id="signupBtn" value="가입 완료" onclick="member('signup')">
            <input type="button" class="cancleBtn" value="취소" onclick="cancle()" style="margin-left: 20px;">
        </div>
    </c:if>
    <c:if test="${not empty memberDto.id}">
        <div style="border: none; display: flex; justify-content: flex-end">
            <input type="button" id="memberDel" value="*회원탈퇴*">
        </div>
        <div style="border: none; display: flex; flex-direction: row;justify-content: center; align-items: center">
            <input type="button" id="memberEditBtn" value="수정 완료" onclick="member('memberEdit')" >
            <input type="button" class="cancleBtn" value="취소" onclick="cancle()" style="margin-left: 20px;">
        </div>
    </c:if>
    </div>
</form>
<footer>
    <jsp:include page="../footer.jsp" flush="true"/>
</footer>
</body>

</html>