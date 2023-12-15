

function courseSelect(value){
    $.ajax({
        url: '/lstRegist/getData',
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: value,
        success: function (courseList) {
            //console.log("성공");
            //console.log("받은 데이터: ", courseList);

            var receivedData = courseList;
            var totalPrice = 0;
            $("#classEnrollInfo").empty();

            $.each(receivedData.courseList, function(index, classInfo) {
                var className = classInfo.className;
                var price = classInfo.price;
                // name 속성 처리: 특수문자 및 공백을 언더스코어로 대체
                index++;
                var subjectName = "subject" + index;
                var priceName = "price" + index;

                var inputElement = $("<input>")
                    .attr("class", "lectureDetail")
                    .attr("type", "text")
                    .attr("readonly", "readonly")
                    .attr("name", subjectName)
                    .val(className)[0];
                var inputElement2 = $("<input>")
                    .attr("class", "lectureDetail")
                    .attr("type", "text")
                    .attr("readonly", "readonly")
                    .attr("name", priceName)
                    .val(price)[0]; // jQuery 객체를 DOM 요소로 변환
                var space = $("<span>&nbsp;</span>");
                var brTag = $("<br>");
                var brTag2 = $("<br>");

                // 각각의 input 요소와 함께 추가
                $("#classEnrollInfo").append(inputElement, space, inputElement2, brTag, brTag2);
                totalPrice += parseFloat(price) || 0;
            });
            document.getElementsByName("totalPrice")[0].value = totalPrice;
        },
        error: function (error) {
            console.log("실패");
        },
    });

}
// 가격계산하는 script
function calculPrice() {
    var price = document.getElementsByName('totalPrice')[0].value;
    var rate = document.getElementsByName('discount')[0].value;
    rate = rate.replace(/[^0-9]/g, '');
    var totalPrice = price - (price * (rate * 0.01));
    document.getElementsByName('lastPrice')[0].value = totalPrice;
}

$("input[type='file']").on("change", function(e) {

    let formData = new FormData();
    let fileInput = $('input[name="uploadFile"]');
    let fileList = fileInput[0].files;
    let fileObj = fileList[0];

    if (!fileCheck(fileObj.name, fileObj.size)) {
        return false;
    }

    for(let i=0; i < fileList.length; i++) {
        formData.append("uploadFile", fileList[i]);
    }

    // 첨부파일을 resources/img에 집어넣는다.
    $.ajax({
        url: '/lstRegist/uploadAjaxAction',
        processData: false,
        contentType: false,
        data: formData,
        type: 'POST',
        dataType: 'json',
        success : function(result) {
            console.log(result);
            // showUploadImage(result);
        },
        error : function(result) {
            alert("이미지 파일이 아닙니다.");
        }
    });
});

/* var, method related with attachFile */
let regex = new RegExp("(.*?)\.(jpg|png)$");
let maxSize = 1048576; //1MB

function fileCheck(fileName, fileSize){

    if(fileSize >= maxSize){
        alert("파일 사이즈 초과");
        return false;
    }

    if(!regex.test(fileName)){
        alert("해당 종류의 파일은 업로드할 수 없습니다.");
        return false;
    }

    return true;
}