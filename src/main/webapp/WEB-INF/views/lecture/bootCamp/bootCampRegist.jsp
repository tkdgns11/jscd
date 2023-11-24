<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>정석코딩 부트캠프 신청</title>
    <style>
        #bootCampRegistParents{
            width: 960px;
            height: 1080px;
            margin: 0 auto;
            background-color: rgba(0,0,0,0.10);
            font-weight: 900;
        }
        #bootCampRegistChild{
            margin: 0 auto;
            width: 80%;
            height: 1080px;
            background-color: rgba(0,0,0,0.20);
        }
        #bootCampRegistForm > h1{
            margin-bottom: -5px;
        }
        #bootCampRegistForm input{
            border-radius: 8px;
            font-size: 18px;
        }
        #bootCampRegistTitle{
            margin-bottom: 10px;
        }
        #bootCampRegistIntroduction{
            margin-bottom: 20px;
        }
        #bootCampRegistSelect1{
            margin-bottom: 20px;
        }
        .bootCampRegistSelect1 select {
            border-radius: 8px;
        }
        #bootCampRegistSelect2{
            margin-bottom: 20px;
        }
        #bootCampRegistPeriod{
            margin-bottom: 10px;
        }
        #bootCampRegistStartDay{
            display: inline-block;
            margin-bottom: 20px;
        }
        #bootCampRegistEndDay{
            display: inline-block;
        }
        #bootCampRegistTime{
            margin-bottom: 5px;
        }
        #bootCampRegistStartTime{
            display: inline-block;
            margin-bottom: 20px;
        }
        #bootCampRegistEndTime{
            display: inline-block;
        }
        .bootCampRegistBody{
            margin-bottom: 10px;
        }
        #bootCampRegistPrice{
            display: inline-block;
            margin-bottom: 40px;
        }
        #bootCampRegistDiscount{
            display: inline-block;
        }
        #bootCampRegistTotal{
            display: inline-block;
        }
        #bootCampRegistEtc{
            margin-bottom: 10px;
        }
        #bootCampRegistBtAll{
            text-align: center;
            margin-top: 17px;
        }
        #bootCampRegistModifyBt{
            margin-right: 20px;
            border-radius: 15px;
            width: 110px;
            height: 38px;
            font-size: 17px;
            background-color: #182566;
            color: white;
            box-shadow: 0 5px #999;
        }
        #bootCampRegistModifyBt:hover {
            background-color: rgba(24, 37, 102, 0.8);
        }
        #bootCampRegistModifyBt:active {
            back-shadow: 0 5px #666;
        }
        #bootCampRegistRemoveBt{
            margin-right: 20px;
            border-radius: 15px;
            width: 110px;
            height: 38px;
            font-size: 17px;
            background-color: red;
            color: white;
            box-shadow: 0 5px #999;
        }
        #bootCampRegistRemoveBt:hover {
            background-color: tomato;
        }
        #bootCampRegistRemoveBt:active {
            back-shadow: 0 5px #666;
        }
        #bootCampRegistListBt{
            border-radius: 15px;
            width: 110px;
            height: 38px;
            font-size: 17px;
            background-color: #182566;
            color: white;
        }

    </style>
</head>
<body>
<div id="bootCampRegistParents">
    <div id="bootCampRegistChild">
        <form id="bootCampRegistForm" action="" method="post">
            <h1>정석코딩 세미나 신청</h1>
            <hr>
            <input type="hidden" value="">

            <div id="bootCampRegistTitle">
                강의 제목<br>
                <input type="text" value="${bootCampDto.title}" size="83">
            </div>

            <div id="bootCampRegistIntroduction">
                강의 소개<br>
                <input type="text" value="${bootCampDto.description}" size="83">
            </div>

            <div id="bootCampRegistSelect1">
                과목 선택
                <select>
                    <option>erd 문제</option>
                    <option>해결해야 함</option>
                </select>
                &emsp;&emsp;회차 선택
                <select>
                    <option>1회차</option>
                    <option>2회차</option>
                    <option>3회차</option>
                    <option>4회차</option>
                </select>
                &emsp;&emsp;온/오프라인 선택
                <select>
                    <option>온라인</option>
                    <option>오프라인</option>
                </select>
                &emsp;&emsp;진행상태
                <select>
                    <option>진행중</option>
                    <option>진행 예정</option>
                    <option>종료</option>
                </select>
            </div>

            <div id="bootCampRegistSelect2">
                강의 장소 선택
                <select>
                    <option>서울시 종로구 종로 서울 YMCA 빌딩 423호</option>
                    <option>서울시 종로구 종로 서울 YMCA 빌딩 425호</option>
                    <option>서울시 종로구 종로 서울 YMCA 빌딩 522호</option>
                </select>
                &emsp;&emsp;&emsp; 최소 인원
                <input type="number" min="5" max="30">
                &emsp;&emsp;&emsp; 최대 인원
                <input type="number" min="5" max="30">
                <input type="hidden" value="현재 인원">
            </div>

            <div id="bootCampRegistPeriod">* 수강 기간</div>
            <div id="bootCampRegistStartDay">
                시작일<br>
                <input type="date">
            </div>
            &emsp; ~ &emsp;
            <div id="bootCampRegistEndDay">
                종료일<br>
                <input type="date">
            </div>

            <div id="bootCampRegistTime">* 수강 시간</div>
            <div id="bootCampRegistStartTime">
                시작 시간<br>
                <input type="time" class="timepicker">
            </div>
            &emsp; ~ &emsp;
            <div id="bootCampRegistEndTime">
                종료 시간<br>
                <input type="time" class="timepicker">
            </div>
            <br>

            <div class="bootCampRegistBody"> 강사<br>
                <input type="text"><br>
            </div>
            <div class="bootCampRegistBody" > 교재<br>
                <input type="text" size="80"><br>
            </div>
            <div class="bootCampRegistBody"> 준비물<br>
                <input type="text" size="80"><br>
            </div>

            <div id="bootCampRegistPrice">
                가격<br>
                <input type="text">&emsp;
            </div>
            <div id="bootCampRegistDiscount">
                할인율<br>
                <select>
                    <option>10%</option>
                    <option>20%</option>
                    <option>30%</option>
                    <option>40%</option>
                    <option>50%</option>
                </select>&emsp;
            </div>
            <div id="bootCampRegistTotal">
                총 가격<br>
                <input type="text">
            </div>

            <div id="bootCampRegistEtc" > 내용<br>
                <textarea rows="15" cols="89" >${bootCampDto.etc}</textarea>
            </div>

            첨부파일<br>
            <input type="file"><br>
            <hr>

            <div id="bootCampRegistBtAll">
                <%--            1. writer가 일치하면 보여주기--%>
                <%--            2. writer가 일치하고 최고 관리자이면 보여주기--%>
                <%--            3. 수정하기 누르면 등록하기로 바꿔주기(url도 같이)--%>
                <button type="button" id="bootCampRegistModifyBt">수정하기</button>
                <button type="button" id="bootCampRegistRemoveBt">삭제하기</button>
                <button type="button" id="bootCampRegistListBt">돌아가기</button>
            </div>
        </form>
    </div>
</div>
<script>

</script>
</body>
</html>
