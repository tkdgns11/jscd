<%--    작성일 : 2023-11-17--%>
<%--    작성자 : 장용호--%>
<%--    작성 기능 : 세미나 등록 게시판(관리자)--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="loginId" value="${sessionScope.id}"/>
<html>
<head>
    <title>정석코딩 세미나 등록</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <style>
        #seminarRegistFont{
            margin-bottom: 30px;
            padding: 30px 30px;
            text-align: center;
            background-color: #182566;
            color: #05CE31;
            font-size: 50px;
            font-weight: 600;
        }
        #seminarRegistAll{
            width: 960px;
            height: 1080px;
            margin: 0 auto;
            /*background-color: rgba(0,0,0,0.10);*/
            font-weight: 900;
        }
        #seminarRegistFormAll{
            margin: 0 auto;
            width: 80%;
            height: 1080px;
            /*background-color: rgba(0,0,0,0.20);*/
        }
        #seminarRegistForm > h1{
            margin-bottom: -5px;
        }
        #seminarRegistForm input{
            border: 1.5px solid rgba(0,0,0,0.3);
            border-radius: 8px;
            box-shadow: 1px 1px 1px 1px rgba(0,0,0,0.08);
            font-size: 18px;
        }
        #seminarRegistTitle{
            margin-bottom: 10px;
        }
        #seminarRegistIntroduction{
            margin-bottom: 20px;
        }
        #seminarRegistSelect1{
            margin-bottom: 10px;
        }
        #seminarRegistSelect2{
            margin-bottom: 20px;
        }
        #seminarRegistPeriod{
            margin-bottom: 10px;
        }
        #seminarRegistStartDay{
            display: inline-block;
            margin-bottom: 20px;
        }
        #seminarRegistEndDay{
            display: inline-block;
        }
        #seminarRegistTime{
            margin-bottom: 10px;
        }
        #seminarRegistStartTime{
            display: inline-block;
            margin-bottom: 20px;
        }
        #seminarRegistStartTime input{
            width: 195px;
        }
        #seminarRegistEndTime{
            display: inline-block;
        }
        #seminarRegistEndTime input{
            width: 195px;
        }
        .seminarRegistBody{
            margin-bottom: 10px;
        }
        #seminarRegistPrice{
            display: inline-block;
            margin-bottom: 30px;
        }
        #seminarRegistPrice input{
            width: 195px;
            height: 26px;
        }
        #seminarRegistDiscount{
            display: inline-block;
        }
        #seminarRegistDiscount select{
            width: 195px;
            height: 26px;
            border-radius: 8px;
        }
        #seminarRegistTotal{
            display: inline-block;
        }
        #seminarRegistTotal input{
            width: 195px;
            height: 26px;
        }
        #seminarRegistEtc{
            margin-bottom: 10px;
            resize: none;
            border: solid 2px rgba(0,0,0,0.15);
            border-radius: 8px;
            box-shadow: 1px 1px 1px 1px rgba(0,0,0,0.08);
        }
        #seminarRegistAttach input{
            width: 760px;
        }
        #seminarRegistBtAll{
            text-align: center;
            margin-top: 17px;
        }
        #seminarRegistWriteBt{
            margin-right: 20px;
            border-radius: 20px;
            width: 110px;
            height: 38px;
            font-size: 17px;
            background-color: red;
            color: white;
        }
        #seminarRegistModifyBt{
            margin-right: 20px;
            border-radius: 20px;
            width: 110px;
            height: 38px;
            font-size: 17px;
            background-color: red;
            color: white;
        }
        #seminarRegistRemoveBt{
            margin-right: 20px;
            border-radius: 20px;
            width: 110px;
            height: 38px;
            font-size: 17px;
            background-color: red;
            color: white;
        }
        #seminarRegistListBt{
            border-radius: 20px;
            width: 110px;
            height: 38px;
            font-size: 17px;
            background-color: #182566;
            color: white;
        }
    </style>
</head>
<body>
<script>
    let msg="${msg}";
    if(msg=="WRT_ERR") alert("게시물 등록에 실패했습니다. 다시 시도해 주세요.");
</script>
<h1 id="seminarRegistFont">/* 정석코딩 세미나 등록 */</h1>
    <div id="seminarRegistAll">
        <div id="seminarRegistFormAll">
        <form id="seminarRegistForm" action="" method="post">
            <h1>정석코딩 세미나 등록</h1>
            <hr>
            <input type="hidden" name="classEnrollNo" value="${seminarRegistDto.classEnrollNo}">

            <div id="seminarRegistTitle">
            강의 제목<br>
            <input type="text" name="title" size="80" placeholder="ex) 세미나 자바의 정석(기초) 1회차"
                value="${seminarRegistDto.title}"
                ${mode=="new" ? "" : "readonly='readonly'"}>
            </div>

            <div id="seminarRegistIntroduction">
            강의 소개<br>
            <input type="text" name="description" size="80" placeholder="ex) 프로그래밍을 처음하거나 자바를 처음 배우는 분들을 위한 강의."
                value="${seminarRegistDto.description}"
                ${mode=="new" ? "" : "readonly='readonly'"}>
            </div>

            <div id="seminarRegistSelect1">
            강의 선택<select name="courseCodeName" ${mode=="new" ? "" : "disabled='disabled'"}>
                <c:forEach var="seminarCourseDto" items="${courseList}">
                    <option value="${seminarCourseDto.courseCode}"
                    <c:if test="${seminarRegistDto.courseCode eq seminarCourseDto.courseCode}">
                        selected="selected"</c:if>> ${seminarCourseDto.courseCodeName} </option>
                </c:forEach>
            </select>

            &emsp;과목 선택
            <select name="subjectCodeName" ${mode=="new" ? "" : "disabled='disabled'"}>
                <c:forEach var="seminarSubjectDto" items ="${subjectList}">
                    <option value="${seminarSubjectDto.subjectCode}"
                    <c:if test="${seminarRegistDto.subjectCode eq seminarSubjectDto.subjectCode}">
                        selected="selected"</c:if>> ${seminarSubjectDto.subjectCodeName}</option>
                </c:forEach>
            </select>

            &emsp; 온/오프라인 선택
            <select name="onOff" ${mode=="new" ? "" : "disabled='disabled'"}>
                <option value="온라인"
                    <c:if test="${seminarRegistDto.onOff eq '온라인'}">
                        selected="selected"</c:if>> 온라인</option>

                <option value="오프라인"
                     <c:if test="${seminarRegistDto.onOff eq '오프라인'}">
                        selected="selected"</c:if>> 오프라인</option>
            </select>

            &emsp; 진행 상태
            <select name="status" ${mode=="new" ? "" : "disabled='disabled'"}>
                <option value="진행 예정"
                    <c:if test="${seminarRegistDto.status eq '진행 예정'}">
                        selected="selected"</c:if>> 진행 예정</option>

                <option value="진행 중"
                    <c:if test="${seminarRegistDto.status eq '진행 중'}">
                        selected="selected"</c:if>> 진행 중</option>

                <option value="종료"
                    <c:if test="${seminarRegistDto.status eq '종료'}">
                        selected="selected"</c:if>> 종료</option>
            </select>
            </div>

            <div id="seminarRegistSelect2">
            강의 장소 선택
            <select name="location" ${mode=="new" ? "" : "disabled='disabled'"}>
                <option value="서울시 종로구 종로 서울 YMCA 빌딩 423호"
                    <c:if test="${seminarRegistDto.location eq '서울시 종로구 종로 서울 YMCA 빌딩 423호'}">
                        selected="selected"</c:if>> 서울시 종로구 종로 서울 YMCA 빌딩 423호</option>

                <option value="서울시 종로구 종로 서울 YMCA 빌딩 425호"
                    <c:if test="${seminarRegistDto.location eq '서울시 종로구 종로 서울 YMCA 빌딩 425호'}">
                        selected="selected"</c:if>> 서울시 종로구 종로 서울 YMCA 빌딩 425호</option>

                <option value="서울시 종로구 종로 서울 YMCA 빌딩 522호"
                    <c:if test="${seminarRegistDto.location eq '서울시 종로구 종로 서울 YMCA 빌딩 522호'}">
                        selected="selected"</c:if>> 서울시 종로구 종로 서울 YMCA 빌딩 522호</option>
            </select>

            &emsp;&emsp; 최소 인원
            <input type="number" name="minNum" min="5" max="30" value="${seminarRegistDto.minNum}"
            ${mode=="new" ? "" : "readonly='readonly'"}>

            &emsp;&emsp; 최대 인원
            <input type="number" name="maxNum" min="5" max="30" value="${seminarRegistDto.maxNum}"
            ${mode=="new" ? "" : "readonly='readonly'"}>

            <input type="hidden" value="현재 인원" value="${seminarRegistDto.presentNum}">
            </div>

            <div id="seminarRegistPeriod">* 수강 기간</div>
            <div id="seminarRegistStartDay">
            시작일<br>
            <input type="date" name="startDate" value="${seminarRegistDto.startDate}"
            ${mode=="new" ? "" : "readonly='readonly'"}>
            </div>
            &emsp; ~ &emsp;
            <div id="seminarRegistEndDay">
            종료일<br>
            <input type="date" name="endDate" value="${seminarRegistDto.endDate}"
            ${mode=="new" ? "" : "readonly='readonly'"}>
            </div>

            <div id="seminarRegistTime">* 수강 시간</div>
            <div id="seminarRegistStartTime">
            시작 시간<br>
            <input type="time" name="startTime" class="timepicker" value="${seminarRegistDto.startTime}"
            ${mode=="new" ? "" : "readonly='readonly'"}>
            </div>
            &emsp; ~ &emsp;
            <div id="seminarRegistEndTime">
            종료 시간<br>
            <input type="time" name="endTime" class="timepicker" value="${seminarRegistDto.endTime}"
            ${mode=="new" ? "" : "readonly='readonly'"}>
            </div>
            <br>

            <div class="seminarRegistBody"> 강사<br>
            <input type="text" name="name" size="80" placeholder="ex) 남궁성 - Java의 정석 저자" value="${seminarRegistDto.name}"
            ${mode=="new" ? "" : "readonly='readonly'"}>
            </div>

            <div class="seminarRegistBody" > 교재<br>
            <input type="text" name="book" size="80" placeholder="ex) 자바의 정석" value="${seminarRegistDto.book}"
            ${mode=="new" ? "" : "readonly='readonly'"}><br>
            </div>

            <div class="seminarRegistBody"> 준비물<br>
            <input type="text" name="material" size="80" placeholder="ex) 뜨거운 열정, 개인 노트북, 필기구, 교재" value="${seminarRegistDto.material}"
            ${mode=="new" ? "" : "readonly='readonly'"}><br>
            </div>

            <div id="seminarRegistPrice">
            가격<br>
            <input type="text" id="price" name="price" value="${seminarRegistDto.price}"
            onchange="calculate()"
            ${mode=="new" ? "" : "readonly='readonly'"}> 원&emsp;&emsp;&emsp;
            </div>

            <div id="seminarRegistDiscount">
            할인율<br>
            <select id="discount" name="discount" ${mode=="new" ? "" : "disabled='disabled'"}
                    onchange="calculate()">
                <option value="0%"
                        <c:if test="${seminarRegistDto.discount eq '0%'}">
                            selected="selected"</c:if>> 0%</option>
                <option value="10%"
                        <c:if test="${seminarRegistDto.discount eq '10%'}">
                            selected="selected"</c:if>> 10%</option>
                <option value="20%"
                        <c:if test="${seminarRegistDto.discount eq '20%'}">
                            selected="selected"</c:if>> 20%</option>
                <option value="30%"
                        <c:if test="${seminarRegistDto.discount eq '30%'}">
                            selected="selected"</c:if>> 30%</option>
                <option value="40%"
                        <c:if test="${seminarRegistDto.discount eq '40%'}">
                            selected="selected"</c:if>> 40%</option>
                <option value="50%"
                        <c:if test="${seminarRegistDto.discount eq '50%'}">
                            selected="selected"</c:if>> 50%</option>
            </select>&emsp;&emsp;&emsp;
            </div>

            <div id="seminarRegistTotal">
            총 가격<br>
            <input id="lstPrice" name="lstPrice" type="text" value="${seminarRegistDto.lstPrice}"
            readonly="readonly"> 원
            </div>

            <div>내용<br>
            <textarea id="seminarRegistEtc" name="etc" rows="15" cols="91"
                ${mode=="new" ? "" : "readonly='readonly'"}>${seminarRegistDto.etc}
            <c:if test="${mode eq 'new'}">
            베스트 셀러 저자와 함께하는 자바 프로그래밍 기초
            수업방식 : 강의 & 실습 + 퀴즈풀이(개인별 지도) + 상담 & 조언

            - 비전공 또는 문과로 코딩이 약하신분
            - 국비학원이나 부트캠프 입과 예정이신 분
            - 개념이 잘 이해 안되거나 응용이 잘안되는 분
            - 공부 방법이나 진로에 고민이 있으신 분
            </c:if>
            </textarea>
            </div>

            <div id="seminarRegistAttach">
            첨부파일<br>
            <input type="file" name="attachedFile" ${mode=="new" ? "" : "disabled='disabled'"} value="${seminarRegistDto.attachedFile}"><br>
            </div>
            <hr>

            <div id="seminarRegistBtAll">
            <c:if test="${mode eq 'new'}">
                <button type="button" id="seminarRegistWriteBt" >등록하기</button>
            </c:if>

            <c:if test="${mode ne 'new'}">
            <%--관리자 로그인 구현시 writer가 loginId와 같은지 체크하게 수정해야 함--%>
            <%--1. writer가 일치하면 보여주기--%>
            <%--2. 수정하기 누르면 등록하기로 바꿔주기(url도 같이)--%>
                <button type="button" id="seminarRegistModifyBt">수정하기</button>
                <button type="button" id="seminarRegistRemoveBt">삭제하기</button>
            </c:if>

            <button type="button" id="seminarRegistListBt">돌아가기</button>
            </div>
        </form>
        </div>
    </div>

<script>
    //총 가격 계산 기능
    const calculate = () => {
        let price = document.getElementById("price").value;
        let discount = document.getElementById("discount").value;

        // 1. price에 한글 입력 못하게 처리 해야함.
        // 2. 계산시 소수점 나오지 않게 처리 해야함.

        const regex = /[^0-9]/g; // 0~9가 아닌 문자열 제거 정규식
        price = parseInt(price);
        discount = parseInt(discount.replace(regex, ""));

        let savePrice; // 절약한 가격
        let resultPrice; // 총 가격

        if(price > 0 && discount >= 0){
            savePrice = price * (discount / 100);
            resultPrice = price - savePrice;
        }
        console.log("절약한 가격 = " + savePrice);
        console.log("총 가격 = " + resultPrice);

        document.getElementById("lstPrice").value = resultPrice;
}
</script>
<script>
    $(document).ready(function() {
        // form에 비어있는 값 있는지 확인하는 기능
        let formCheck = function(){
            let form = document.getElementById("seminarRegistForm");
            if(form.title.value==""){
                alert("강의 제목을 입력해 주세요.");
                form.title.focus();
                return false;
            }
            if(form.description.value==""){
                alert("강의 소개를 입력해 주세요.");
                form.description.focus();
                return false;
            }
            if(form.minNum.value==""){
                alert("최소 인원을 선택해 주세요.");
                form.minNum.focus();
                return false;
            }
            if(form.maxNum.value==""){
                alert("최대 인원을 선택해 주세요.");
                form.maxNum.focus();
                return false;
            }
            if(form.startDate.value==""){
                alert("강의 시작일을 선택해 주세요.");
                form.startDate.focus();
                return false;
            }
            if(form.endDate.value==""){
                alert("강의 종료일을 선택해 주세요.");
                form.endDate.focus();
                return false;
            }
            if(form.startTime.value==""){
                alert("강의 시작 시간을 선택해 주세요.");
                form.startTime.focus();
                return false;
            }
            if(form.endTime.value==""){
                alert("강의 종료 시간을 선택해 주세요.");
                form.endTime.focus();
                return false;
            }
            if(form.name.value==""){
                alert("강사 이름을 입력해 주세요.");
                form.name.focus();
                return false;
            }
            if(form.book.value==""){
                alert("교재를 입력해 주세요.");
                form.book.focus();
                return false;
            }
            if(form.material.value==""){
                alert("준비물을 입력해 주세요.");
                form.material.focus();
                return false;
            }
            if(form.price.value==""){
                alert("가격을 입력해 주세요.");
                form.price.focus();
                return false;
            }

            return true;
        }

        // 등록하기 버튼
        $("#seminarRegistWriteBt").on("click", function(){
            let form = $("#seminarRegistForm");
            form.attr("action", "<c:url value='/regist/write'/>");
            form.attr("method", "post");

            if(formCheck())
                form.submit();
        });

        // 수정하기 버튼
        $("#seminarRegistModifyBt").on("click", function(){
            let form = $("#seminarRegistForm");
            let readonly = $("input[name=title]", form).attr('readonly');
            let disabled = $("select[name=courseCodeName]", form).attr('disabled');

            // 1. 읽기 상태이면 수정 상태로 변경(form 순서에 맞게 정렬되어 있음)
            // (if에서 readonly 값만 확인해도 문제 없지만 확실하게 둘 다 확인)
            if(readonly!=undefined && disabled!=undefined){
                alert("readonly의 값 확인 = " + readonly);
                alert("disabled의 값 확인 = " + disabled);
                $("input[name=title]", form).attr('readonly', false);
                $("input[name=description]", form).attr('readonly', false);

                $("select[name=courseCodeName]", form).attr('disabled', false);
                $("select[name=subjectCodeName]", form).attr('disabled', false);
                $("select[name=onOff]", form).attr('disabled', false);
                $("select[name=status]", form).attr('disabled', false);
                $("select[name=location]", form).attr('disabled', false);
                $("select[name=discount]", form).attr('disabled', false);

                $("input[name=minNum]", form).attr('readonly', false);
                $("input[name=maxNum]", form).attr('readonly', false);
                $("input[name=startDate]", form).attr('readonly', false);
                $("input[name=endDate]", form).attr('readonly', false);
                $("input[name=startTime]", form).attr('readonly', false);
                $("input[name=endTime]", form).attr('readonly', false);
                $("input[name=name]", form).attr('readonly', false);
                $("input[name=name]", form).attr('readonly', false);
                $("input[name=book]", form).attr('readonly', false);
                $("input[name=material]", form).attr('readonly', false);
                $("input[name=price]", form).attr('readonly', false);
                $("input[name=discount]", form).attr('readonly', false);

                $("textarea[name=etc]", form).attr('readonly', false);

                $("input[name=attachedFile]", form).attr('disabled', false);

                $("#seminarRegistModifyBt").html("등록하기");
                return;
            };

            // 2. 수정 상태이면 formcheck 함수 호출 후 전송
            form.attr("action", "<c:url value='/regist/modify?page=${page}&pageSize=${pageSize}'/>");
            form.attr("method", "post");
            if(formCheck())
                form.submit();
        });

        // 삭제하기 기능
        $("#seminarRegistRemoveBt").on("click", function(){
            if(!confirm("정말로 삭제하시겠습니까?")) return;

            let form = $("#seminarRegistForm");
            form.attr("action", "<c:url value='/regist/remove?page=${page}&pageSize=${pageSize}'/>");
            form.attr("method", "post");
            form.submit();
        });

        // 돌아가기 기능
        $("#seminarRegistListBt").on("click", function(){
            alert("page = " + ${page});
            alert("pageSize = " + ${pageSize});
            location.href="<c:url value='/regist/list?page=${page}&pageSize=${pageSize}'/>";
        });
    });
</script>
</body>
</html>
