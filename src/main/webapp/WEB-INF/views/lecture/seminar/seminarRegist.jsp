<%--    작성일 : 2023-11-17--%>
<%--    작성자 : 장용호--%>
<%--    작성 기능 : 세미나 등록 게시판(관리자)--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>정석코딩 세미나 신청</title>
    <title>정석코딩 세미나 등록</title>
    <style>
        #seminarRegist{
            width: 960px;
            height: 1080px;
            margin: 0 auto;
            background-color: rgba(0,0,0,0.10);
            font-weight: 900;
        }
        #seminarRegistForm input{
            padding: 3px;
            border-radius: 5px;
            font-size: 20px;
        }
    </style>
</head>
<body>
    <div id="seminarRegist">
        <h1>정석코딩 세미나 신청</h1>
        <form id="seminarRegistForm" action="" method="post">
            <input type="hidden" value="">

            <div class="" style="padding: 5px">
            강의명<br>
            <input type="text" value="" size="70">
            </div>
            <div class="">
            강의 소개<br>
            <input type="text" value="" size="70">
            </div>
            과목 선택
            <select>
                <option>해결해야 함.</option>
            </select>
            온/오프라인 선택
            <select>
                <option>온라인</option>
                <option>오프라인</option>
            </select>
            강의 장소 선택
            <select>
                <option>서울시 종로구 종로 서울 YMCA 빌딩 423호</option>
                <option>서울시 종로구 종로 서울 YMCA 빌딩 425호</option>
                <option>서울시 종로구 종로 서울 YMCA 빌딩 522호</option>
            </select><br>
            최소 인원
            <input type="number" min="5">
            최대 인원
            <input type="number" max="30">
            <input type="hidden" value="현재 인원"><br>
            수강 기간<br>
            시작일
            <input type="date"> ~
            종료일
            <input type="date"><br>
            시작 시간
            <input type="time"> ~
            종료 시간
            <input type="time"><br>
            강사<br>
            <input type="text"><br>
            교재<br>
            <input type="text"><br>
            준비물<br>
            <input type="text"><br>
            가격<br>
            <input type="text"><br>
            할인율<br>
            <select>
                <option>10%</option>
                <option>20%</option>
                <option>30%</option>
                <option>40%</option>
                <option>50%</option>
            </select><br>
            총 가격<br>
            <input type="text"><br>
            비고<br>
            <textarea>
            </textarea><br>
            첨부파일<br>
            <input type="file"><br>

            <button>등록하기(파랑)</button>
            <button>수정하기(빨강)</button>
            <button>돌아가기(빨강)</button>
            <button>삭제하기(빨강)</button>
        </form>
    </div>
</body>
</html>
