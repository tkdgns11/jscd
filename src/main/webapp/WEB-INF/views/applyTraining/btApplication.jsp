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
    <title>부트캠프 신청서</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
    <h1>정석코딩 부트캠프 신청서</h1>
    <span>최대한 자세히 작성해주세요.</span>
    <hr>

    <form id="btApplicationForm" method="post" >
            <input type="hidden" name="id" value="${id}">
            <input type="hidden" name="registCode" value="${lstRegistDto.registCode}">
            <input type="hidden" name="title" value="${lstRegistDto.title}">
            <input type="hidden" name="lastPrice" value="${lstRegistDto.lastPrice}">
        <div>
            <div>Q.본인의 프로그래밍 지식이나 경험 수준에 대해 선택해주세요. (선택1)</div>
            <input type="radio" name="level" value="낮음">낮음
            <input type="radio" name="level" value="중간">중간
            <input type="radio" name="level" value="높은">높은
        </div>
        <br>
        <div>
            <div>Q.본인의 코딩 경험이나 수준에 대해서 자세히 적어주세요. (300자 내외)</div>
            <textarea name="levelDetail" maxlength="300"></textarea>
        </div>
        <br>
        <div>
            <div>Q.정석코딩 부트캠프에 참여하려는 목적을 선택해주세요. (선택1)</div>
            <input type="radio" name="attdPps" value="실무에서 필요">실무에서 필요<br>
            <input type="radio" name="attdPps" value="취업 준비 or 이직 준비">취업 준비 or 이직 준비<br>
            <input type="radio" name="attdPps" value="개인적인 관심">개인적인 관심<br>
            <input type="radio" name="attdPps" value="기타">기타
        </div>
        <br>
        <div>
            <div>Q.정석코딩 부트캠프에 대한 정보를 얻으신 경로를 선택해주세요. (선택1)</div>
            <input type="radio" name="attdPath" value="페이스북, 인스타 등 SNS">페이스북, 인스타 등 SNS<br>
            <input type="radio" name="attdPath" value="정석코딩 네이버 카페">정석코딩 네이버 카페<br>
            <input type="radio" name="attdPath" value="지인 추천">지인 추천<br>
            <input type="radio" name="attdPath" value="기타">기타
        </div>
        <br>
        <div>
            <div>Q.간단한 자기소개를 해주세요.(300자 내외)</div>
            <textarea name="intro" maxlength="300"></textarea>
        </div>
        <br>
        <div>
            <div>Q.정석코딩 부트캠프에서 기대하는 것은 무엇입니까? (300자 내외)</div>
            <textarea name="expect" maxlength="300"></textarea>
        </div>
        <br>
        <div>
            <div>Q.학업에 전념(하루 14시간 이상)하지 않거나 타인에게 피해를 주는 경우<br>
            &emsp;퇴소 될 수 있습니다. 동의하십니까? (선택1)</div>
            <input type="radio" name="agreeYN" value="Y">예<br>
            <input type="radio" name="agreeYN" value="N">아니오<br>
        </div>
        <br>
        <button type="button" id="writeBtn">제출하기</button>
    </form>

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
        });
    </script>
</body>
</html>
