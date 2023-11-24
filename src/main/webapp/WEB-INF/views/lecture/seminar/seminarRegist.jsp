<%--    작성일 : 2023-11-17--%>
<%--    작성자 : 장용호--%>
<%--    작성 기능 : 세미나 등록 게시판(관리자)--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>정석코딩 세미나 등록</title>
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
            box-shadow: 1px 1px 1px 1px rgba(0,0,0,0.15);
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
        }
        #seminarRegistAttach input{
            width: 760px;
        }
        #seminarRegistBtAll{
            text-align: center;
            margin-top: 17px;
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
<h1 id="seminarRegistFont">/* 정석코딩 세미나 등록 */</h1>
    <div id="seminarRegistAll">
        <div id="seminarRegistFormAll">
        <form id="seminarRegistForm" action="" method="post">
            <h1>정석코딩 세미나 등록</h1>
            <hr>
            <input type="hidden" value="${seminarRegistDto.classEnrollNo}">

            <div id="seminarRegistTitle">
            강의 제목<br>
            <input type="text" value="${seminarRegistDto.title}" size="80">
            </div>

            <div id="seminarRegistIntroduction">
            강의 소개<br>
            <input type="text" value="${seminarRegistDto.description}" size="80">
            </div>

            <div id="seminarRegistSelect1">
            과목 선택
            <select>
                <option>${seminarRegistDto.subjectName}</option>
<%--                <option>자바의 정석(기초)</option>--%>
<%--                <option>자바의 정석(심화)</option>--%>
<%--                <option>이펙티브 자바</option>--%>
<%--                <option>DB 모델링</option>--%>
<%--                <option>SQL 튜닝</option>--%>
<%--                <option>디자인 패턴</option>--%>
<%--                <option>C언어</option>--%>
<%--                <option>파이썬</option>--%>
<%--                <option>머신러닝</option>--%>
<%--                <option>DB 모델링(은행 실무)</option>--%>
<%--                <option>러스트</option>--%>
            </select>
            &emsp;&emsp;회차 선택
            <select>
                    <option>${seminarRegistDto.roundName}</option>
<%--                <option>1회차</option>--%>
<%--                <option>2회차</option>--%>
<%--                <option>3회차</option>--%>
<%--                <option>4회차</option>--%>
            </select>
            &emsp;&emsp; 온/오프라인 선택
            <select>
                <option>${seminarRegistDto.onOff}</option>
<%--                <option>온라인</option>--%>
<%--                <option>오프라인</option>--%>
            </select>
                &emsp;&emsp; 진행상태
            <select>
                <option>${seminarRegistDto.status}</option>
<%--                <option>진행 예정</option>--%>
<%--                <option>진행 중</option>--%>
<%--                <option>종료</option>--%>
            </select>
            </div>

            <div id="seminarRegistSelect2">
            강의 장소 선택
            <select>
                <option>${seminarRegistDto.location}</option>
<%--                <option>서울시 종로구 종로 서울 YMCA 빌딩 423호</option>--%>
<%--                <option>서울시 종로구 종로 서울 YMCA 빌딩 425호</option>--%>
<%--                <option>서울시 종로구 종로 서울 YMCA 빌딩 522호</option>--%>
            </select>
            &emsp;&emsp;&emsp; 최소 인원
            <input type="number" min="5" max="30" value="${seminarRegistDto.minNum}">
            &emsp;&emsp; 최대 인원
            <input type="number" min="5" max="30" value="${seminarRegistDto.maxNum}">
            <input type="hidden" value="현재 인원" value="${seminarRegistDto.presentNum}">
            </div>

            <div id="seminarRegistPeriod">* 수강 기간</div>
            <div id="seminarRegistStartDay">
            시작일<br>
            <input type="date" value="${seminarRegistDto.startDate}">
            </div>
            &emsp; ~ &emsp;
            <div id="seminarRegistEndDay">
            종료일<br>
            <input type="date" value="${seminarRegistDto.endDate}">
            </div>

            <div id="seminarRegistTime">* 수강 시간</div>
            <div id="seminarRegistStartTime">
            시작 시간<br>
            <input type="time" class="timepicker" value="${seminarRegistDto.startTime}">
            </div>
            &emsp; ~ &emsp;
            <div id="seminarRegistEndTime">
            종료 시간<br>
            <input type="time" class="timepicker" value="${seminarRegistDto.endTime}">
            </div>
            <br>

            <div class="seminarRegistBody"> 강사<br>
            <input type="text" value="${seminarRegistDto.name}"><br>
            </div>
            <div class="seminarRegistBody" > 교재<br>
            <input type="text" size="80" value="${seminarRegistDto.book}"><br>
            </div>
            <div class="seminarRegistBody"> 준비물<br>
            <input type="text" size="80" value="${seminarRegistDto.material}"><br>
            </div>

            <div id="seminarRegistPrice">
            가격<br>
            <input type="text" value="${seminarRegistDto.price}">원&emsp;&emsp;&emsp;
            </div>
            <div id="seminarRegistDiscount">
            할인율<br>
            <select>
                <option>${seminarRegistDto.discount}</option>
<%--                <option>0%</option>--%>
<%--                <option>10%</option>--%>
<%--                <option>20%</option>--%>
<%--                <option>30%</option>--%>
<%--                <option>40%</option>--%>
<%--                <option>50%</option>--%>
            </select>&emsp;&emsp;&emsp;
            </div>
            <div id="seminarRegistTotal">
            총 가격<br>
            <input type="text" value="${seminarRegistDto.lstPrice}">원
            </div>

            <div id="seminarRegistEtc"> 내용<br>
            <textarea rows="15" cols="91">${seminarRegistDto.etc}</textarea>
            </div>

            <div id="seminarRegistAttach">
            첨부파일<br>
            <input type="file"><br>
            </div>
            <hr>

            <div id="seminarRegistBtAll">
<%--            1. writer가 일치하면 보여주기--%>
<%--            2. 최고 관리자이면 보여주기--%>
<%--            3. 수정하기 누르면 등록하기로 바꿔주기(url도 같이)--%>
            <button type="button" id="seminarRegistModifyBt">수정하기</button>
            <button type="button" id="seminarRegistRemoveBt">삭제하기</button>

            <button type="button" id="seminarRegistListBt">돌아가기</button>
            </div>
        </form>
        </div>
    </div>
<script>

</script>
</body>
</html>
