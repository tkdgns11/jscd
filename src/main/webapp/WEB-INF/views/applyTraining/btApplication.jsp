<%--
  Created by IntelliJ IDEA.
  User: jang-yongho
  Date: 12/4/23
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | 부트캠프 신청</title>
</head>
<body>

<header><jsp:include page="../header.jsp"/></header>

<div id="applicationAll">
    <h1 id="applicationText">정석코딩 부트캠프 신청서</h1>
    <span id="detailsText">최대한 자세히 작성해주세요.</span>
    <hr class="applicationHr">
    <form id="btApplicationForm" method="post">
        <input type="hidden" name="id" value="${id}">
        <input type="hidden" name="registCode" value="${lstRegistDto.registCode}">
        <input type="hidden" name="title" value="${lstRegistDto.title}">
        <input type="hidden" name="lastPrice" value="${lstRegistDto.lastPrice}">
        <div>
            <div class="question">Q. 본인의 프로그래밍 지식이나 경험 수준에 대해 선택해주세요. <span class="redText">(선택 1)</span></div>
            <div id="selAll">
                <label><input type="radio" name="level" value="낮음">낮음</label><hr class="applicationHr">
                <label><input type="radio" name="level" value="중간">중간</label><hr class="applicationHr">
                <label><input type="radio" name="level" value="높은">높은</label>
            </div>
        </div>
        <br>
        <div>
            <div class="question">Q. 본인의 코딩 경험이나 수준에 대해서 자세히 적어주세요. <span class="redText">(300자 내외)</span></div>
            <textarea class="applicationTextarea" name="levelDetail" maxlength="300"></textarea>
        </div>
        <br>
        <div>
            <div class="question">Q. 정석코딩 부트캠프에 참여하려는 목적을 선택해주세요. <span class="redText">(선택 1)</span></div>
            <div id="selAll">
                <label><input type="radio" name="attdPps" value="실무에서 필요">실무에서 필요</label><hr class="applicationHr">
                <label><input type="radio" name="attdPps" value="취업 준비 or 이직 준비">취업 준비 or 이직 준비</label><hr class="applicationHr">
                <label><input type="radio" name="attdPps" value="개인적인 관심">개인적인 관심</label><hr class="applicationHr">
                <label><input type="radio" name="attdPps" value="기타">기타</label>
            </div>
        </div>
        <br>
        <div>
            <div class="question">Q. 정석코딩 부트캠프에 대한 정보를 얻으신 경로를 선택해주세요. <span class="redText">(선택 1)</span></div>
            <div id="selAll">
                <label><input type="radio" name="attdPath" value="페이스북, 인스타 등 SNS">페이스북, 인스타 등 SNS</label><hr class="applicationHr">
                <label><input type="radio" name="attdPath" value="정석코딩 네이버 카페">정석코딩 네이버 카페</label><hr class="applicationHr">
                <label><input type="radio" name="attdPath" value="지인 추천">지인 추천</label><hr class="applicationHr">
                <label><input type="radio" name="attdPath" value="기타">기타</label>
            </div>
        </div>
        <br>
        <div>
            <div class="question">Q. 간단한 자기소개를 해주세요. <span class="redText">(300자 내외)</span></div>
            <textarea class="applicationTextarea" name="intro" maxlength="300"></textarea>
        </div>
        <br>
        <div>
            <div class="question">Q. 정석코딩 부트캠프에서 기대하는 것은 무엇입니까? <span class="redText">(300자 내외)</span></div>
            <textarea class="applicationTextarea" name="expect" maxlength="300"></textarea>
        </div>
        <br>
        <div>
            <div class="question">Q. 학업에 전념 <span class="redText">(하루 14시간 이상)</span> 하지 않거나 타인에게 피해를 주는 경우<br>
                &emsp;퇴소 될 수 있습니다. 동의하십니까? <span class="redText">(선택 1)</span></div>
            <div id="selAll">
                <label><input type="radio" name="agreeYN" value="Y">예</label><hr class="applicationHr">
                <label><input type="radio" name="agreeYN" value="N">아니오</label>
            </div>
        </div>
        <br>
        <hr class="applicationHr">
        &emsp;<input type="button" id="writeBtn" class="registeBtn" value=" 제출">
        &emsp;<input type="button" id="listBtn" class="backBtn" value=" 목록">
        <br><br>
    </form>
</div>

<footer><jsp:include page="../footer.jsp"/></footer>

<script>
    $(document).ready(()=>{

        // 신청서 유효성 검사 함수
        let formCheck = ()=>{
            let form = document.getElementById("btApplicationForm");

            if(form.level[0].checked==false && form.level[1].checked==false && form.level[2].checked==false){
                alert("신청서 문항을 확인해주세요.")
                return false;
            }
            if(form.levelDetail.value==""){
                alert("신청서 문항을 확인해주세요.")
                form.levelDetail.focus();
                return false;
            }
            if(form.attdPps[0].checked==false && form.attdPps[1].checked==false && form.attdPps[2].checked==false && form.attdPps[3].checked==false){
                alert("신청서 문항을 확인해주세요.")
                return false;
            }
            if(form.attdPath[0].checked==false && form.attdPath[1].checked==false && form.attdPath[2].checked==false && form.attdPath[3].checked==false){
                alert("신청서 문항을 확인해주세요.")
                return false;
            }
            if(form.intro.value==""){
                alert("신청서 문항을 확인해주세요.")
                form.intro.focus();
                return false;
            }
            if(form.expect.value==""){
                alert("신청서 문항을 확인해주세요.")
                form.expect.focus();
                return false;
            }
            if(form.agreeYN[0].checked==false && form.agreeYN[1].checked==false || form.agreeYN[0].checked==false && form.agreeYN[1].checked==true){
                alert("신청서 문항을 확인해주세요.")
                return false;
            }

            return true;
        }

        // 제출하기
        $("#writeBtn").on("click", ()=>{
            let form = $("#btApplicationForm");
            form.attr("action", "<c:url value='/btTraining/btApplication'/>");
            form.attr("method", "post");

            // 유효성 검사 후 제출
            if(formCheck())
                form.submit();
        })

        // 목록
        $("#listBtn").on("click", function(){
            location.href="<c:url value='/btTraining/list'/>";
        });
    });
</script>
</body>
</html>