<%--
  Created by IntelliJ IDEA.
  User: jskang
  Date: 12/6/23
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/myPage.css"/>">
    <script type="text/javascript" src="<c:url value="/js/myPage.js"/>"></script>

    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/white_mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/white_mainlogo.png"/>
    <title>정석코딩 | myPage</title>

    <%--폰트어썸 라이브러리 불러오기--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>

</head>
<script>
    let msg = "${param.msg}";
    if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");
    if (msg == "MOD_ERR") alert("수정이 실패했습니다.다시 시도해주세요.");
</script>

<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>

<div id="myPageContentBox">
    <nav>
        <ul>
            <li><a href="/member/memberEdit">회원 정보 수정</a></li>
            <li><a href="/member/lectureApplyState">강의 신청 현황</a></li>
            <li><a href="/order/orderList">내 주문 내역</a></li>
            <c:if test="${memberDto.getGrade() eq '3'}">
                <li><a href="/member/instructorIntro">강사 소개말 등록</a></li>
            </c:if>
        </ul>
    </nav>

    <div id="myPageBox">
        <label class="memberInfoLabel">아이디(이메일)</label><br>
        <input type="text" value="${memberDto.id}" readonly class="memberInfoInput"  readonly name="id" id="id"><br>
        <label class="memberInfoLabel">이름</label><br>
        <input type="text" value="${memberDto.name}"  class="memberInfoInput" readonly><br>
        <label class="memberInfoLabel">닉네임</label><br>
        <input type="text" value="${memberDto.nickname}" class="memberModifyInput" id="nickname" name="nickname"><br>
        <label class="memberInfoLabel">비밀번호 변경</label><br>
        <input type="password" class="password" id="pwd1" style="margin-bottom:15px"><br>
        <label class="memberInfoLabel">비밀번호 변경 확인</label><br>
        <input type="password" name="pwd" class="password" id="pwd2" style="margin-bottom:5px"><br>
        <font id="checkPwd" size="2"></font><br>
        <input type="hidden" id="pwdChkYN" value="">
        <label class="memberInfoLabel" style="margin-top: 10%">성별</label><br>
        <input type="text"  class="memberInfoInput" value="${memberDto.gender== 1 ? '남' : '여'}" readonly><br>
        <label class="memberInfoLabel">생년월일</label><br>
        <input type="text"  class="memberModifyInput"  name="birth" id="birth" value="${memberDto.birth}" name="birth" placeholder="생년월일 6자리를 입력해주세요(Ex.950324)"><br>
        <label class="memberInfoLabel">휴대전화</label><br>
        <input type="text" value="${memberDto.phone}" name="phone" id="phone" class="memberModifyInput" oninput="autoHyphen(this)"><br>
        <label class="memberInfoLabel">환불 계좌번호</label><br>
        <input type="text" value="${memberDto.acct}" class="memberModifyInput" id="acct" name="acct" placeholder="은행명 / 예금주 / 계좌번호 형식으로 입력해주세요."><br>
        <div id="myPageBtnBox">
            <input type="button" value="수정" class="modifyBtn" onclick="infoModify()">
        </div>
        <div id="myPageDelBox">
            <a href="">회원 탈퇴</a>
        </div>
    </div>


</div>
<header>
    <jsp:include page="../footer.jsp"/>
</header>

</body>
</html>


