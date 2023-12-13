<%--
  Created by IntelliJ IDEA.
  User: sanghoon
  Date: 2023/12/13
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>정석코딩</title>
    <style>

        #content{
            width: 960px;
            height: 1080px;
            margin: 0 auto;
            background-color: gray;
        }

        .mySlides {
            display: none;
            height: 25rem;
        }

        img {
            vertical-align: middle;
        }

        /* Slideshow container */
        .slideshow-container {
            overflow: hidden;
            height: 18rem;
            position: relative;
            margin: auto;
        }

        /* Next & previous buttons */
        .prev,
        .next {
            cursor: pointer;
            position: absolute;
            top: 50%;
            width: auto;
            padding: 16px;
            margin-top: -22px;
            color: white;
            font-weight: bold;
            font-size: 18px;
            transition: 0.6s ease;
            border-radius: 0 3px 3px 0;
            user-select: none;
        }

        /* Position the "next button" to the right */
        .next {
            right: 0;
            border-radius: 3px 0 0 3px;
        }

        /* On hover, add a black background color with a little bit see-through */
        .prev:hover,
        .next:hover {
            background-color: rgba(0, 0, 0, 0.8);
        }

        /* Caption text */
        .text {
            color: #f2f2f2;
            font-size: 15px;
            padding: 8px 12px;
            position: absolute;
            bottom: 8px;
            width: 100%;
            text-align: center;
        }

        /* Number text (1/3 etc) */
        .numbertext {
            color: #f2f2f2;
            font-size: 12px;
            padding: 8px 12px;
            position: absolute;
            top: 0;
        }

        /* The dots/bullets/indicators */
        .dot {
            cursor: pointer;
            height: 15px;
            width: 15px;
            margin: 0 2px;
            background-color: #bbb;
            border-radius: 50%;
            display: inline-block;
            transition: background-color 0.6s ease;
        }

        .active,
        .dot:hover {
            background-color: #717171;
        }

        /* Fading animation */
        .fade {
            animation-name: fade;
            animation-duration: 1.5s;
        }

        @keyframes fade {
            from {
                opacity: .4
            }

            to {
                opacity: 1
            }
        }

        /* On smaller screens, decrease text size */
        @media only screen and (max-width: 300px) {

            .prev,
            .next,
            .text {
                font-size: 11px
            }
        }

        .sentence {
            font-size: 3vw;
            margin-left:1rem;
            /* display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: center; */
        }

        /* #title {
            text-align: center;
        } */

        .margin_bottom {
            margin: 20px;
        }

        iframe {
            border-radius: 30px;
        }

        button {
            border-radius: 10px;
        }

        .fieldButton button {
            margin-left:2rem;
            width: 150px;        /* 버튼의 너비 */
            height: 50px;        /* 버튼의 높이 */
            font-size: 20px;     /* 글자 크기 */
            padding: 10px 20px;  /* 위아래 10px, 좌우 20px의 패딩을 추가 */
            cursor: pointer;     /* 마우스 오버시 포인터 모양으로 변경 */
            transition: background-color 0.3s;  /* 배경색 변경시 부드러운 전환 효과 */
            border-radius: 50%;
        }

        .fieldButton button:hover {
            background-color: darkslategray;  /* 버튼 위에 마우스를 올렸을 때의 배경색 */
            color:white;
            border: none;
        }


        #textBlue {
            color: blue;
        }

        .youtube {
            display: flex;
            flex-direction: row;
            flex-wrap: nowrap;
            justify-content: space-around;
            margin: 1rem;
        }

        .youtubeTitle {
            color: blue;
        }

        .youtubeText {
            font-size: 3vw;
        }

    </style>
</head>
<body>
<div id="content">

    <div class="slideshow-container">

        <div class="mySlides fade">
            <div class="numbertext"><button>1/3</button></div>
            <img src="../img/campMain/introduce.png" style="width:100%">
        </div>

        <div class="mySlides fade">
            <div class="numbertext"><button>2/3</button></div>
            <img src="../img/campMain/lounge.png" style="width:100%">
        </div>

        <div class="mySlides fade">
            <div class="numbertext"><button>3/3</button></div>
            <img src="../img/campMain/study.png" style="width:100%">
        </div>

        <a class="prev" onclick="plusSlides(-1)">❮</a>
        <a class="next" onclick="plusSlides(1)">❯</a>

    </div>
    <br>

    <div style="text-align:center">
        <span class="dot" onclick="currentSlide(1)"></span>
        <span class="dot" onclick="currentSlide(2)"></span>
        <span class="dot" onclick="currentSlide(3)"></span>
    </div>

    <div class="sentence">
        <h1 class="titleText">남궁성의 정석코딩은<br>
            책임감으로 가르칠 <strong id="textBlue">확실한 강사</strong>가 있습니다</h1><br>
    </div>

    <div class="fieldButton">
            <span class="fieldButton">
                <button>세미나</button>
                <button>정석코딩</button>
            </span>
    </div>

    <div class="margin_bottom">
        <img src="../img/campMain/teacher_environment.png" alt="">
    </div>

    <div class="youtube">
            <span>
                <iframe width="300" height="150" src="https://www.youtube.com/embed/hyEj73e0Z7M?start=423" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen></iframe>

                <p class="youtubeText">
                <h5 class="youtubeTitle">정석코딩 2기 2팀 프로젝트 발표</h5><br>2개월 동안 누구의 도움도 받지 않고<br>학생들 스스로 열심히 만든<br>갓벽한 프로젝트 발표 영상!
                </p>
            </span>

        <span>
                <iframe width="300" height="150" src="https://www.youtube.com/embed/dVh9y144_lw" frameborder="0"
                        allowfullscreen></iframe>
                <p class="youtubeText">
                <h5 class="youtubeTitle">DB설계 1대1 리뷰</h5><br>1:1꼼꼼한 코드 리뷰와 동시에<br>스스로 DB를 설계하는 능력을 <br>키워주기 위한 원장님의 고군분투!</p>

            </span>

        <span>
                <iframe width="300" height="150"
                        src="https://www.youtube.com/embed/4-szaYqeP9k?list=PLW2UjW795-f4Mxu9bouFWlNNZXQUV8fxL" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen></iframe>

                <p class="youtubeText">
                <h5 class="youtubeTitle">코포자를 위한 코딩 공부법</h5><br>예제 공부법, 연습문제 푸는 방법 등<br>남궁성 원장님의 꿀팁 대방출!</p>
            </span>
    </div>
</div>
<script>
    let slideIndex = 1;
    showSlides(slideIndex);

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    function currentSlide(n) {
        showSlides(slideIndex = n);
    }

    function showSlides(n) {
        let i;
        let slides = document.getElementsByClassName("mySlides");
        let dots = document.getElementsByClassName("dot");
        if (n > slides.length) { slideIndex = 1 }
        if (n < 1) { slideIndex = slides.length }
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex - 1].style.display = "block";
        dots[slideIndex - 1].className += " active";
    }
</script>
</body>
</html>