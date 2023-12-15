window.onload = function (){
    var registeBtn = document.getElementById("registeBtn");
    registeBtn.addEventListener('click', function (){
        regist();
    });

    var backBtn = document.getElementById("backBtn");
    backBtn.addEventListener('click', function(){
        back();
    })
}

function regist() {
    location.href="<c:url value='/btTraining/btApplication?registCode=${lstRegistDto.registCode}&title=${lstRegistDto.title}&lastPrice=${lstRegistDto.lastPrice}'/>";
}

function back() {
    location.href="<c:url value='/btTraining/list'/>";
}