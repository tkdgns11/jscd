<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">

    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <title>정석코딩 | 정석코딩 위치</title>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2282f0ae50d3344aacbb4711c04360bd"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/reset.css'/>">

    <style>
        #loadContentBox{
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        #loadContentBox > p{
            background-color: #D9D9D9;
            width: 150px;
            height: 40px;
            margin-right: 450px;
            font-weight: 700;
            text-align: center;
            line-height: 40px;
            margin-top: 20px;
            margin-bottom: 20px;
        }
        #loadBox{
            margin: -3px 0 50px 0;
            padding-right: 55px;
            padding-left: 50px;
            padding-bottom: 20px;
            /*border: 1px solid #D9D9D9;*/
        }
        #addTitle{
            background-color: #0185FE;
            width: 100px;
            height: 30px;
            font-weight: 700;
            color: white;
            text-align: center;
            line-height: 30px;
            border-radius: 20px;
            margin-right: 60px;
            margin-top: 20px;
        }
        #jsAdd{
            text-align: center;
            margin-top: 20px;
            font-weight: 700;
            margin-right: 25px;

        }
        #map{
            width: 600px;
            height: 500px;
            margin-bottom: 20px;
            /*filter: drop-shadow(10px 8px 6px #c3c3c3);*/
        }

    </style>
</head>
<body>

<header>
    <jsp:include page="header.jsp"/>
</header>

<div id="loadContentBox">
    <p>찾아오시는 길</p>


    <div id="map"></div>

    <div id="loadBox">
        <p id="addTitle">주소</p>
        <p id="jsAdd">서울 종로구 종로 69 서울YMCA 빌딩 5층 517호
            1호선 종각역 8번출구 7m</p>
    </div>

</div>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>

<script>
    var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
    var options = { //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(37.57049902807725, 126.9853071423654), //지도의 중심좌표.
        level: 3 //지도의 레벨(확대, 축소 정도)
    };

    var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

    var markerPosition  = new kakao.maps.LatLng(37.57049902807725, 126.9853071423654);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);

</script>
</body>
</html>
