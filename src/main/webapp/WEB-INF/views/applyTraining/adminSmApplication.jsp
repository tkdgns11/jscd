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

    <title>세미나 신청서</title>
</head>
<body>
<header>
    <jsp:include page="../admin/header.jsp"/>
</header>
<div id="adminContent">
    <nav>
        <jsp:include page="../admin/sidebar.jsp"/>
    </nav>
    <main>
        <div id="applicationAll">
            <h1 id="applicationText">정석코딩 세미나 신청서 관리</h1>
            <hr class="applicationHr">

            <form id="smApplicationForm" method="post">
                <div class="applicationInformation">
                    신청 번호 :
                    <input type="text" name="stfmNo" value="${smApplicationDto.stfmNo}" readonly>
                    <br>
                    신청자 계정 :
                    <input type="text" name="id" value="${smApplicationDto.id}" readonly>
                    <input type="hidden" name="registCode" value="${smApplicationDto.registCode}">
                    <br>
                    신청한 강의 이름 :
                    <input type="text" name="title" value="${smApplicationDto.title}" readonly>
                    <input type="hidden" name="lastPrice" value="${smApplicationDto.lastPrice}">
                </div>
                <hr class="applicationHr">
                <div>
                    <div class="question">Q. 본인의 프로그래밍 지식이나 경험 수준에 대해 선택해주세요. <span class="redText">(선택 1)</span></div>
                    <div id="selAll">
                        <label><input type="radio" name="level" value="낮음" onclick="return(false);"
                        <c:if test="${smApplicationDto.level eq '낮음'}"> checked="checked"</c:if>>낮음</label><hr class="applicationHr">
                        <label><input type="radio" name="level" value="중간" onclick="return(false);"
                        <c:if test="${smApplicationDto.level eq '중간'}"> checked="checked"</c:if>>중간</label><hr class="applicationHr">
                        <label><input type="radio" name="level" value="높은" onclick="return(false);"
                        <c:if test="${smApplicationDto.level eq '높은'}"> checked="checked"</c:if>>높은</label>
                    </div>
                </div>
                <br>
                <div>
                    <div class="question">Q. 본인의 코딩 경험이나 수준에 대해서 자세히 적어주세요. <span class="redText">(300자 내외)</span></div>
                    <textarea class="applicationTextarea" name="levelDetail" maxlength="300" readonly>${smApplicationDto.levelDetail}</textarea>
                </div>
                <br>
                <div>
                    <div class="question">Q. 정석코딩 세미나에 참여하려는 목적을 선택해주세요. <span class="redText">(선택 1)</span></div>
                    <div id="selAll">
                        <label><input type="radio" name="attdPps" value="실무에서 필요" onclick="return(false);"
                        <c:if test="${smApplicationDto.attdPps eq '실무에서 필요'}"> checked="checked"</c:if>>실무에서 필요</label><hr class="applicationHr">
                        <label><input type="radio" name="attdPps" value="취업 준비 or 이직 준비" onclick="return(false);"
                        <c:if test="${smApplicationDto.attdPps eq '취업 준비 or 이직 준비'}"> checked="checked"</c:if>>취업 준비 or 이직 준비</label><hr class="applicationHr">
                        <label><input type="radio" name="attdPps" value="개인적인 관심" onclick="return(false);"
                        <c:if test="${smApplicationDto.attdPps eq '개인적인 관심'}"> checked="checked"</c:if>>개인적인 관심</label><hr class="applicationHr">
                        <label><input type="radio" name="attdPps" value="기타" onclick="return(false);"
                        <c:if test="${smApplicationDto.attdPps eq '기타'}"> checked="checked"</c:if>>기타</label>
                    </div>
                </div>
                <br>
                <div>
                    <div class="question">Q. 정석코딩 세미나에 대한 정보를 얻으신 경로를 선택해주세요. <span class="redText">(선택 1)</span></div>
                    <div id="selAll">
                        <label><input type="radio" name="attdPath" value="페이스북, 인스타 등 SNS" onclick="return(false);"
                        <c:if test="${smApplicationDto.attdPath eq '페이스북, 인스타 등 SNS'}"> checked="checked"</c:if>>페이스북, 인스타 등 SNS</label><hr class="applicationHr">
                        <label><input type="radio" name="attdPath" value="정석코딩 네이버 카페" onclick="return(false);"
                        <c:if test="${smApplicationDto.attdPath eq '정석코딩 네이버 카페'}"> checked="checked"</c:if>>정석코딩 네이버 카페</label><hr class="applicationHr">
                        <label><input type="radio" name="attdPath" value="지인 추천" onclick="return(false);"
                        <c:if test="${smApplicationDto.attdPath eq '지인 추천'}"> checked="checked"</c:if>>지인 추천</label><hr class="applicationHr">
                        <label><input type="radio" name="attdPath" value="기타" onclick="return(false);"
                        <c:if test="${smApplicationDto.attdPath eq '기타'}"> checked="checked"</c:if>>기타</label>
                    </div>
                </div>
                <br>
                <div>
                    <div class="question">Q. 간단한 자기소개를 해주세요. <span class="redText">(300자 내외)</span></div>
                    <textarea class="applicationTextarea" name="intro" maxlength="300" readonly>${smApplicationDto.intro}</textarea>
                </div>
                <br>
                <div>
                    <div class="question">Q. 정석코딩 세미나에서 기대하는 것은 무엇입니까? <span class="redText">(300자 내외)</span></div>
                    <textarea class="applicationTextarea" name="expect" maxlength="300" readonly>${smApplicationDto.expect}</textarea>
                </div>
                <br>
                <hr>
                <br>
                &emsp;<input type="button" id="listBtn" class="backBtn" value=" 목록">
                <br>
            </form>
        </div>
    </main>
</div>
<script>
    $(document).ready(()=>{
        // 목록
        $('#listBtn').on("click", ()=>{
            location.href="<c:url value='/adminManage/adminSmTraining/list?page=${page}&pageSize=${pageSize}'/>";
        });

    });
</script>
</body>
</html>
