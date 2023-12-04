<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>classEnroll</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<script>
    let msg = "${msg}";
    if(msg == "write fail") alert("게시물 등록 실패")
    if(msg == "modify fail") alert("게시물 수정 실패")
</script>

    classEnroll
    <form id="classEnrollForm" name="" action="" method="post">

        <input type="hidden" name="classCode" value="${classEnrollDto.classCode}">
<%--        <c:forEach var="courseDto" items="${courseList}">--%>
<%--            <input type="text" value="${courseDto.courseCode}">--%>
<%--        </c:forEach>--%>

        강의 선택
        <select id="courseName" name="courseCode" ${mode=="new" ? "" : "disabled='disabled'"} onchange="autoClassName()">
            <c:forEach var="courseDto" items="${courseList}">
                <option name="courseCode" value="${courseDto.courseCode}"
                    <c:if test="${classEnrollDto.courseCode eq courseDto.courseCode}">
                        selected="selected"</c:if>>${courseDto.courseName}</option>
            </c:forEach>
        </select>

        회차 선택
        <select id="roundName" name="roundCode" ${mode=="new" ? "" : "disabled='disabled'"} onchange="autoClassName()">
            <c:forEach var="roundDto" items ="${roundList}">
                <option name="roundCode" value="${roundDto.roundCode}"
                    <c:if test="${classEnrollDto.roundCode eq roundDto.roundCode}">
                        selected="selected"</c:if>>${roundDto.roundName}</option>
            </c:forEach>
        </select>

        강의 이름
        <input type="text" id="className" name="className" value ="${classEnrollDto.className}" readonly="readonly">
        <br>

        가격
        <input type="text" id="price" name="price" ${mode=="new" ? "" : "readonly='readonly'"} onchange="calculate()" value="${classEnrollDto.price}"  >원

        할인율
        <select id="discount" name="discount" ${mode=="new" ? "" : "disabled='disabled'"} onchange="calculate()">
            <option value="0%"
                <c:if test="${classEnrollDto.discount eq '0%'}">
                    selected="selected"</c:if>> 0%</option>
            <option value="10%"
                <c:if test="${classEnrollDto.discount eq '10%'}">
                    selected="selected"</c:if>> 10%</option>
            <option value="20%"
                <c:if test="${classEnrollDto.discount eq '20%'}">
                    selected="selected"</c:if>> 20%</option>
            <option value="30%"
                <c:if test="${classEnrollDto.discount eq '30%'}">
                    selected="selected"</c:if>> 30%</option>
            <option value="40%"
                <c:if test="${classEnrollDto.discount eq '40%'}">
                    selected="selected"</c:if>> 40%</option>
            <option value="50%"
                <c:if test="${classEnrollDto.discount eq '50%'}">
                    selected="selected"</c:if>> 50%</option>
        </select>

        할인 가격
        <input type="text" id="lstPrice" name="lstPrice" value="${classEnrollDto.lstPrice}" readonly="readonly">원
        <br>

        비고<br>
        <textarea id="etc" name="etc" ${mode=="new" ? "" : "readonly='readonly'"}>${classEnrollDto.etc}</textarea>

        <br>
        <c:if test="${mode eq 'new'}">
            <button type="button" id="classEnrollWriteBt">등록하기</button>
        </c:if>

        <c:if test="${mode ne 'new'}">
            <button type="button" id="classEnrollModifyBt">수정하기</button>
            <button type="button" id="classEnrollRemoveBt">삭제하기</button>
        </c:if>

        <button type="button" id="classEnrollListBt">돌아가기</button>
    </form>

    <script>
        // 강의 이름 자동 완성 함수 값이 바뀌면 실행
        const autoClassName = () => {
            let courseName = document.getElementById("courseName");
            let courseValue = (courseName.options[courseName.selectedIndex].innerHTML);

            let roundName = document.getElementById("roundName");
            let roundValue = (roundName.options[roundName.selectedIndex].innerHTML);

            console.log(courseValue);
            console.log(roundValue);

            document.getElementById("className").value = courseValue + " " + roundValue;
        }
        // 강의 이름 자동 완성 함수 로딩시 무조건 한번 실행
        (autoClassName)();

        // 할인 가격 계산 함수
        const calculate = () => {
            let price = document.getElementById("price").value;
            let discount = document.getElementById("discount").value;

            const regex = /[^0-9]/g; // 0~9가 아닌 문자열 제거 정규식
            price = parseInt(price);
            discount = parseInt(discount.replace(regex, ""));

            let savePrice; // 절약한 가격
            let resultPrice; // 할인 가격

            if(price > 0 && discount >= 0){
                savePrice = price * (discount / 100);
                resultPrice = price - savePrice;
            }
            console.log("절약한 가격 = " + savePrice);
            console.log("할인 가격 = " + resultPrice);

            document.getElementById("lstPrice").value = resultPrice;
        }
    </script>

    <script>
        $(document).ready(function() {

            let formCheck = () => {
                let form = document.getElementById("classEnrollForm");

                if(form.price.value == ""){
                    alert("가격을 입력해 주세요.")
                    form.price.focus();
                    return false;
                }
                return true;
            }

            $("#classEnrollWriteBt").on("click", function(){
                let form = $("#classEnrollForm");
                form.attr("action", "<c:url value='/classEnroll/write'/>");
                form.attr("method", "post");

                if(formCheck())
                    form.submit();
            });

            // 수정하기 버튼
            $("#classEnrollModifyBt").on("click", function(){
                let form = $("#classEnrollForm");
                let disabled = $("select[name=courseCode]", form).attr('disabled');
                let readonly = $("input[name=price]", form).attr('readonly');

                // 1. 읽기 상태이면 수정 상태로 변경
                if(readonly!=undefined && disabled!=undefined){
                    console.log("disabled의 값 확인 = " + disabled);
                    console.log("readonly의 값 확인 = " + readonly);

                    $("select[name=courseCode]", form).attr('disabled', false);
                    $("select[name=roundCode]", form).attr('disabled', false);
                    $("input[name=price]", form).attr('readonly', false);
                    $("select[name=discount]", form).attr('disabled', false);
                    $("input[name=etc]", form).attr('readonly', false);


                    $("#classEnrollModifyBt").html("등록하기");
                    return;
                };

                // 2. 수정 상태이면 formcheck 함수 호출 후 전송
                form.attr("action", "<c:url value='/classEnroll/modify'/>");
                form.attr("method", "post");

                if(formCheck())
                    form.submit();
            });

            // 삭제하기
            $("#classEnrollRemoveBt").on("click", function(){
                if(!confirm("정말로 삭제하시겠습니까?")) return;

                let form = $("#classEnrollForm");
                form.attr("action", "<c:url value='/classEnroll/remove'/>");
                form.attr("method", "post");
                form.submit();
            });

            // 돌아가기 버튼
            $("#classEnrollListBt").on("click", function(){
                location.href="<c:url value='/classEnroll/list'/>";
            });
        });
    </script>
</body>
</html>


