var slideIndex = 0; //slide index

// HTML 로드가 끝난 후 동작
window.onload=function(){
    showSlides(slideIndex);

    // Auto Move Slide
    var sec = 5000;
    setInterval(function(){
        slideIndex++;
        showSlides(slideIndex);

    }, sec);


    showSlides01(slideIndex01);

    // Auto Move Slide
    var sec = 5000;
    setInterval(function(){
        slideIndex01++;
        showSlides01(slideIndex01);

    }, sec);

    // 스크롤 시 해당 id 영역 떠오르기 효과 구현
    window.addEventListener('scroll', function() {
        applyFloatUpEffect('keyElementTxt');
        applyFloatUpEffect('youtubeBox');
    });

}

// Next/previous controls
function moveSlides(n) {
    slideIndex = slideIndex + n
    showSlides(slideIndex);
}

// Thumbnail image controls
function currentSlide(n) {
    slideIndex = n;
    showSlides(slideIndex);
}

function showSlides(n) {

    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    var size = slides.length;

    if ((n+1) > size) {
        slideIndex = 0; n = 0;
    }else if (n < 0) {
        slideIndex = (size-1);
        n = (size-1);
    }

    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }

    slides[n].style.display = "block";
    dots[n].className += " active";
}


//하단 슬라이드

var slideIndex01 = 0; //slide index

// HTML 로드가 끝난 후 동작(window.onload에 같이 둠)


// Next/previous controls
function moveSlides01(n) {
    slideIndex01 = slideIndex01 + n
    showSlides01(slideIndex01);
}

// Thumbnail image controls
function currentSlide01(n) {
    slideIndex01 = n;
    showSlides01(slideIndex01);
}

function showSlides01(n) {

    var slides = document.getElementsByClassName("mySlides01");
    var dots = document.getElementsByClassName("dot01");
    var size = slides.length;

    if ((n+1) > size) {
        slideIndex01 = 0; n = 0;
    }else if (n < 0) {
        slideIndex01 = (size-1);
        n = (size-1);
    }

    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }

    slides[n].style.display = "block";
    dots[n].className += " active";
}

// 세미나 버튼 클릭시 가장 최근 세미나 2개를 불러온다.
function seminarSelect() {
    $.ajax({
        url: '/seminarList',
        method: 'POST',
        contentType: "application/json; charset=utf-8",
        success: function(response) {
            var receivedData = response;

            $("#lectureWrap").empty();

            $.each(receivedData.response, function(index, seminar) {
                var contentDiv = $("<div>");
                var ulElement = $("<ul>");
                var discriptionli = $("<li>").text(seminar.discription);
                var titleli = $("<li>").text(seminar.title);

                var applyButtonli = $("<li>");
                var applyButton = $("<input>")
                    .attr({
                        type: "button",
                        class: "registeBtn",
                        value: "선청하기"
                    });

                // 세미나 코드를 포함한 URL 생성
                var seminarURL = $("<a>")
                    .attr("href", "/smTraining/read?registCode=" + seminar.registCode)
                    .append(applyButtonli.append(applyButton));

                ulElement.append(discriptionli, titleli, seminarURL);

                var imgElement = $("<img>")
                    .attr("src", "/img/code.png");

                contentDiv.append(ulElement, imgElement);

                $("#lectureWrap").append(contentDiv);
            });
        },
        error: function(error) {
            console.log("error");
        }
    });
}
seminarSelect();

function bootCampSelect() {
    $.ajax({
        url: '/bootCampList',
        method: 'POST',
        contentType: "application/json; charset=utf-8",
        success: function(response) {
            var receivedData = response;

            $("#lectureWrap").empty();

            $.each(receivedData.response, function(index, bootCamp) {
                var contentDiv = $("<div>");
                var ulElement = $("<ul>");
                var discriptionli = $("<li>").text(bootCamp.discription);
                var titleli = $("<li>").text(bootCamp.title);

                var applyButtonli = $("<li>");
                var applyButton = $("<input>")
                    .attr({
                        type: "button",
                        class: "registeBtn",
                        value: "선청하기"
                    });

                // 세미나 코드를 포함한 URL 생성
                var seminarURL = $("<a>")
                    .attr("href", "/btTraining/read?registCode=" + bootCamp.registCode)
                    .append(applyButtonli.append(applyButton));

                ulElement.append(discriptionli, titleli, seminarURL);

                var imgElement = $("<img>")
                    .attr("src", "/img/rocket.png");

                contentDiv.append(ulElement, imgElement);

                $("#lectureWrap").append(contentDiv);
            });
        },
        error: function(error) {
            console.log("error");
        }
    });
}

// 스크롤 시 해당 id 영역 떠오르기 효과 구현
function applyFloatUpEffect(elementId) {
    var element = document.getElementById(elementId);
    var elementPosition = element.getBoundingClientRect().top;
    var windowHeight = window.innerHeight;

    if (elementPosition - windowHeight <= 0) {
        element.classList.add('visible');
        element.classList.remove('hidden');
    }
}