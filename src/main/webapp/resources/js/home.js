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