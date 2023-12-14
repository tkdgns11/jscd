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

    <title>부트캠프 신청서</title>
</head>
<body>
<div id="applicationAll">
    <h1 id="applicationText">정석코딩 부트캠프 신청서 관리</h1>
    <hr class="applicationHr">

    <form id="btApplicationForm" method="post">
        <div class="applicationInformation">
            신청 번호 :
            <input type="text" name="stfmNo" value="${btApplicationDto.stfmNo}" readonly>
            <br>
            신청자 계정 :
            <input type="text" name="id" value="${btApplicationDto.id}" readonly>
            <input type="hidden" name="registCode" value="${btApplicationDto.registCode}">
            <br>
            신청한 강의 이름 :
            <input type="text" name="title" value="${btApplicationDto.title}" readonly>
            <input type="hidden" name="lastPrice" value="${btApplicationDto.lastPrice}">
        </div>
            <hr class="applicationHr">
        <div>
            <div class="question">Q. 본인의 프로그래밍 지식이나 경험 수준에 대해 선택해주세요. <span class="redText">(선택 1)</span></div>
            <div id="selAll">
                <label><input type="radio" name="level" value="낮음" onclick="return(false);"
                <c:if test="${btApplicationDto.level eq '낮음'}"> checked="checked"</c:if>>낮음</label><hr class="applicationHr">
                <label><input type="radio" name="level" value="중간" onclick="return(false);"
                <c:if test="${btApplicationDto.level eq '중간'}"> checked="checked"</c:if>>중간</label><hr class="applicationHr">
                <label><input type="radio" name="level" value="높은" onclick="return(false);"
                <c:if test="${btApplicationDto.level eq '높은'}"> checked="checked"</c:if>>높은</label>
            </div>
        </div>
        <br>
        <div>
            <div class="question">Q. 본인의 코딩 경험이나 수준에 대해서 자세히 적어주세요. <span class="redText">(300자 내외)</span></div>
            <textarea class="applicationTextarea" name="levelDetail" maxlength="300" readonly>${btApplicationDto.levelDetail}</textarea>
        </div>
        <br>
        <div>
            <div class="question">Q. 정석코딩 부트캠프에 참여하려는 목적을 선택해주세요. <span class="redText">(선택 1)</span></div>
            <div id="selAll">
                <label><input type="radio" name="attdPps" value="실무에서 필요" onclick="return(false);"
                <c:if test="${btApplicationDto.attdPps eq '실무에서 필요'}"> checked="checked"</c:if>>실무에서 필요</label><hr class="applicationHr">
                <label><input type="radio" name="attdPps" value="취업 준비 or 이직 준비" onclick="return(false);"
                <c:if test="${btApplicationDto.attdPps eq '취업 준비 or 이직 준비'}"> checked="checked"</c:if>>취업 준비 or 이직 준비</label><hr class="applicationHr">
                <label><input type="radio" name="attdPps" value="개인적인 관심" onclick="return(false);"
                <c:if test="${btApplicationDto.attdPps eq '개인적인 관심'}"> checked="checked"</c:if>>개인적인 관심</label><hr class="applicationHr">
                <label><input type="radio" name="attdPps" value="기타" onclick="return(false);"
                <c:if test="${btApplicationDto.attdPps eq '기타'}"> checked="checked"</c:if>>기타</label>
            </div>
        </div>
        <br>
        <div>
            <div class="question">Q. 정석코딩 부트캠프에 대한 정보를 얻으신 경로를 선택해주세요. <span class="redText">(선택 1)</span></div>
            <div id="selAll">
                <label><input type="radio" name="attdPath" value="페이스북, 인스타 등 SNS" onclick="return(false);"
                <c:if test="${btApplicationDto.attdPath eq '페이스북, 인스타 등 SNS'}"> checked="checked"</c:if>>페이스북, 인스타 등 SNS</label><hr class="applicationHr">
                <label><input type="radio" name="attdPath" value="정석코딩 네이버 카페" onclick="return(false);"
                <c:if test="${btApplicationDto.attdPath eq '정석코딩 네이버 카페'}"> checked="checked"</c:if>>정석코딩 네이버 카페</label><hr class="applicationHr">
                <label><input type="radio" name="attdPath" value="지인 추천" onclick="return(false);"
                <c:if test="${btApplicationDto.attdPath eq '지인 추천'}"> checked="checked"</c:if>>지인 추천</label><hr class="applicationHr">
                <label><input type="radio" name="attdPath" value="기타" onclick="return(false);"
                <c:if test="${btApplicationDto.attdPath eq '기타'}"> checked="checked"</c:if>>기타</label>
            </div>
        </div>
        <br>
        <div>
            <div class="question">Q. 간단한 자기소개를 해주세요. <span class="redText">(300자 내외)</span></div>
            <textarea class="applicationTextarea" name="intro" maxlength="300" readonly>${btApplicationDto.intro}</textarea>
        </div>
        <br>
        <div>
            <div class="question">Q. 정석코딩 부트캠프에서 기대하는 것은 무엇입니까? <span class="redText">(300자 내외)</span></div>
            <textarea class="applicationTextarea" name="expect" maxlength="300" readonly>${btApplicationDto.expect}</textarea>
        </div>
        <br>
        <div>
            <div class="question">Q. 학업에 전념 <span class="redText">(하루 14시간 이상)</span> 하지 않거나 타인에게 피해를 주는 경우<br>
                &emsp;퇴소 될 수 있습니다. 동의하십니까? <span class="redText">(선택 1)</span></div>
            <div id="selAll">
            <label><input type="radio" name="agreeYN" value="Y" onclick="return(false);"
            <c:if test="${btApplicationDto.agreeYN eq 'Y'}"> checked="checked"</c:if>>예</label><hr class="applicationHr">
            <label><input type="radio" name="agreeYN" value="N" onclick="return(false);"
            <c:if test="${btApplicationDto.agreeYN eq 'N'}"> checked="checked"</c:if>>아니오</label>
            </div>
        </div>
        <hr class="applicationHr">
        <div class="applicationInformation">
        현재 승인 상태 :
        <input type="text"  id="approvalYN" name="approvalYN" value="${btApplicationDto.approvalYN}" readonly>
        </div>
        <br>
        &emsp;<input type="button" id="approvalBtn" class="registeBtn" value=" 승인">
        <input type="button" id="notApprovalBtn" class="cancleBtn" value=" 미승인">
        &emsp;<input type="button" id="listBtn" class="backBtn" value=" 목록">
        <br><br>
    </form>
</div>

    <script>
        $(document).ready(()=>{
            // 승인
            $("#approvalBtn").on("click", ()=>{
                $("#approvalYN").val("승인");
                alert("처리 결과 = " + $("#approvalYN").val());

                let form = $("#btApplicationForm");
                form.attr("action", "<c:url value='/adminBtTraining/modify${searchApplication.queryString}'/>");
                form.attr("method", "post");
                form.submit();
            });

            // 미승인
            $('#notApprovalBtn').on("click", ()=>{
                $("#approvalYN").val("미승인");
                alert("처리 결과 = " + $("#approvalYN").val());

                let form = $("#btApplicationForm");
                form.attr("action", "<c:url value='/adminBtTraining/modify${searchApplication.queryString}'/>");
                form.attr("method", "post");
                form.submit();
            });

            // 목록
            $('#listBtn').on("click", ()=>{
                location.href="<c:url value='/adminBtTraining/list${searchApplication.queryString}'/>";
            });

        });
    </script>
</body>
</html>
