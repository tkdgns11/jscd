<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12/3/23
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <title>정석코딩 강의 등록</title>
    <style>
        #registFont{
            margin-bottom: 30px;
            padding: 30px 30px;
            text-align: center;
            background-color: #182566;
            color: #05CE31;
            font-size: 50px;
            font-weight: 600;
        }
        #registAll{
            width: 960px;
            height: 1080px;
            margin: 0 auto;
            /*background-color: rgba(0,0,0,0.10);*/
            font-weight: 900;
        }
        #registFormAll{
            margin: 0 auto;
            width: 80%;
            height: 1080px;
            /*background-color: rgba(0,0,0,0.20);*/
        }
        #registForm > h1{
            margin-bottom: -5px;
        }
        #registForm input{
            border: 1.5px solid rgba(0,0,0,0.3);
            border-radius: 8px;
            box-shadow: 1px 1px 1px 1px rgba(0,0,0,0.15);
            font-size: 18px;
        }
        #registTitle{
            margin-bottom: 10px;
        }
        #registIntroduction{
            margin-bottom: 20px;
        }
        #registSelect1{
            margin-bottom: 10px;
        }
        #registSelect2{
            margin-bottom: 20px;
        }
        #registPeriod{
            margin-bottom: 10px;
        }
        #registStartDay{
            display: inline-block;
            margin-bottom: 20px;
        }
        #registEndDay{
            display: inline-block;
        }
        #registTime{
            margin-bottom: 10px;
        }
        #registStartTime{
            display: inline-block;
            margin-bottom: 20px;
        }
        #registStartTime input{
            width: 195px;
        }
        #registEndTime{
            display: inline-block;
        }
        #registEndTime input{
            width: 195px;
        }
        .registBody{
            margin-bottom: 10px;
        }
        #registPrice{
            display: inline-block;
            margin-bottom: 30px;
        }
        #registPrice input{
            width: 195px;
            height: 26px;
        }
        #registDiscount{
            display: inline-block;
        }
        #registDiscount select{
            width: 195px;
            height: 26px;
            border-radius: 8px;
        }
        #registTotal{
            display: inline-block;
        }
        #registTotal input{
            width: 195px;
            height: 26px;
        }
        #registEtc{
            margin-bottom: 10px;
        }
        #registAttach input{
            width: 760px;
        }
        #registBtAll{
            text-align: center;
            margin-top: 17px;
        }
        #registModifyBt{
            margin-right: 20px;
            border-radius: 20px;
            width: 110px;
            height: 38px;
            font-size: 17px;
            background-color: red;
            color: white;
        }
        #registRegistBt{
            margin-right: 20px;
            border-radius: 20px;
            width: 110px;
            height: 38px;
            font-size: 17px;
            background-color: red;
            color: white;
        }
        #registRemoveBt{
            margin-right: 20px;
            border-radius: 20px;
            width: 110px;
            height: 38px;
            font-size: 17px;
            background-color: red;
            color: white;
        }
        #registListBt{
            border-radius: 20px;
            width: 110px;
            height: 38px;
            font-size: 17px;
            background-color: #182566;
            color: white;
        }
        .classEnrollInfo { display: none;}
    </style>
</head>
<body>
<h1 id="registFont">/* 정석코딩 강의 ${mode == "new" ? '등록' : '수정'} */</h1>
<div id="registAll">
    <div id="registFormAll">
        <form id="registForm" action="" method="post">
            <h1>정석코딩 강의 ${mode == "new" ? '등록' : '수정'}</h1>
            <hr>
            <input type="hidden" name="registCode" value="${lstRegistDto.registCode}">

            <script>
                let msg = "${msg}";
                if(msg == "WRT_ERR") alert("등록에 실패했습니다. 다시 시도해주세요.");
            </script>

            <div id="registTitle">
                강의 제목<br>
                <c:choose>
                    <c:when test="${mode eq 'new'}">
                        <input type="text" id="title" name="title" value="${lstRegistDto.title}" size="80">
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <input type="text" id="title" name="title" value="${lstRegistDto.title}" size="80">
                    </c:when>
                </c:choose>
            </div>

            <div id="registIntroduction">
                강의 소개<br>
                <c:choose>
                    <c:when test="${mode eq 'new'}">
                        <input type="text" name="discription" value="${lstRegistDto.discription}" placeholder="강의에 대한 소개를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='강의에 대한 소개를 입력해주세요.'" size="80">
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <input type="text" name="discription" value="${lstRegistDto.discription}" size="80">
                    </c:when>
                </c:choose>
            </div>

            <div id="registSelect3">
                과정선택
                <select id="subjectCodeName" name="courseCode" onchange="courseSelect(this.value)">
                    <c:choose>
                        <c:when test="${mode eq 'new'}">
                            <c:forEach var="list" items="${list}">
                                <option value="${list.courseCode}">${list.courseName}</option>
                            </c:forEach>
                        </c:when>
                        <c:when test="${mode ne 'new'}">
                            <option value="${lstRegistDto.courseCode}">${lstRegistDto.courseName}</option>
                        </c:when>
                    </c:choose>
                </select>
            </div>

            세부사항<br>
            <div id="classEnrollInfo">
                <c:if test="${mode ne 'new'}">
                    <input type="text" name="subject1" value="${lstRegistDto.subject1}">
                    <input type="text" name="price1" value="${lstRegistDto.price1}"><br>
                    <input type="text" name="subject2" value="${lstRegistDto.subject2}">
                    <input type="text" name="price2" value="${lstRegistDto.price2}"><br>
                    <input type="text" name="subject3" value="${lstRegistDto.subject3}">
                    <input type="text" name="price3" value="${lstRegistDto.price3}"><br>
                    <input type="text" name="subject4" value="${lstRegistDto.subject4}">
                    <input type="text" name="price4" value="${lstRegistDto.price4}"><br>
                    <input type="text" name="subject5" value="${lstRegistDto.subject5}">
                    <input type="text" name="price5" value="${lstRegistDto.price5}"><br>
                </c:if>
            </div>

            <div id="registSelect1">
                온/오프라인 선택
                <select name="onOff">
                    <c:choose>
                        <c:when test="${mode eq 'new'}">
                            <option value="<c:out value="온라인"/>">온라인</option>
                            <option value="<c:out value="오프라인"/>">오프라인</option>
                        </c:when>
                        <c:when test="${mode ne 'new'}">
                            <option>${lstRegistDto.onOff}</option>
                        </c:when>
                    </c:choose>
                    <%--                <option>온라인</option>--%>
                    <%--                <option>오프라인</option>--%>
                </select>
                &emsp;&emsp; 진행상태
                <select name="status">
                    <c:choose>
                        <c:when test="${mode eq 'new'}">
                            <option value="<c:out value="진행예정"/>">진행 예정</option>
                            <option value="<c:out value="진행 중"/>">진행 중</option>
                            <option value="<c:out value="종료"/>">종료</option>
                        </c:when>
                        <c:when test="${mode ne 'new'}">
                            <option>${lstRegistDto.status}</option>
                        </c:when>
                    </c:choose>
                    <%--                <option>진행 예정</option>--%>
                    <%--                <option>진행 중</option>--%>
                    <%--                <option>종료</option>--%>
                </select>
                &emsp;&emsp;&emsp; 최소 인원
                <c:choose>
                    <c:when test="${mode eq 'new'}">
                        <input type="number" name="minNum" min="5" max="30">
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <input type="number" name="minNum" min="5" max="30" value="${lstRegistDto.minNum}">
                    </c:when>
                </c:choose>
                &emsp;&emsp; 최대 인원
                <c:choose>
                    <c:when test="${mode eq 'new'}">
                        <input type="number" name="maxNum" min="5" max="30">
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <input type="number" name="maxNum" min="5" max="30" value="${lstRegistDto.maxNum}">
                    </c:when>
                </c:choose>
                <c:if test="${mode ne 'new'}">
                    &emsp;&emsp; 현재인원
                    <input type="number" value="${lstRegistDto.currentNum}">
                </c:if>

            </div>

            <div id="registSelect2">
                강의 장소 선택
                <select name="location">
                    <c:choose>
                        <c:when test="${mode eq 'new'}">
                            <option value="<c:out value="종로구 종로 서울 YMCA 빌딩 423호"/>">서울시 종로구 종로 서울 YMCA 빌딩 423호</option>
                            <option value="<c:out value="종로구 종로 서울 YMCA 빌딩 425호"/>">서울시 종로구 종로 서울 YMCA 빌딩 425호</option>
                            <option value="<c:out value="종로구 종로 서울 YMCA 빌딩 518호"/>">서울시 종로구 종로 서울 YMCA 빌딩 518호</option>
                        </c:when>
                        <c:when test="${mode ne 'new'}">
                            <option>${lstRegistDto.location}</option>
                        </c:when>
                    </c:choose>
                    <%--                <option>서울시 종로구 종로 서울 YMCA 빌딩 423호</option>--%>
                    <%--                <option>서울시 종로구 종로 서울 YMCA 빌딩 425호</option>--%>
                    <%--                <option>서울시 종로구 종로 서울 YMCA 빌딩 522호</option>--%>
                </select>
            </div>

            <div id="registPeriod">* 수강 기간</div>
            <div id="registStartDay">
                시작일<br>
                <c:choose>
                    <c:when test="${mode eq 'new'}">
                        <input type="date" name="startDate">
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <input type="date" name="startDate" value="${lstRegistDto.startDate}">
                    </c:when>
                </c:choose>
            </div>
            &emsp; ~ &emsp;
            <div id="registEndDay">
                종료일<br>
                <c:choose>
                    <c:when test="${mode eq 'new'}">
                        <input type="date" name="endDate">
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <input type="date" name="endDate" value="${lstRegistDto.endDate}">
                    </c:when>
                </c:choose>
            </div>

<%--            <div id="registTime">* 수강 시간</div>--%>
<%--            <div id="registStartTime">--%>
<%--                시작 시간<br>--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${mode eq 'new'}">--%>
<%--                        <input type="time" name="startTime">--%>
<%--                    </c:when>--%>
<%--                    <c:when test="${mode ne 'new'}">--%>
<%--                        <input type="time" name="startTime" value="${lstRegistDto.startTime}">--%>
<%--                    </c:when>--%>
<%--                </c:choose>--%>
<%--            </div>--%>
<%--            &emsp; ~ &emsp;--%>
<%--            <div id="registEndTime">--%>
<%--                종료 시간<br>--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${mode eq 'new'}">--%>
<%--                        <input type="time" name="endTime">--%>
<%--                    </c:when>--%>
<%--                    <c:when test="${mode ne 'new'}">--%>
<%--                        <input type="time" name="endTime" value="${lstRegistDto.endTime}">--%>
<%--                    </c:when>--%>
<%--                </c:choose>--%>
<%--            </div>--%>

<%--            <div class="registBody"> 강사<br>--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${mode eq 'new'}">--%>
<%--                        <input type="text" name="name" placeholder="담당 강사님의 이름을 입력해주세요." size="80">--%>
<%--                    </c:when>--%>
<%--                    <c:when test="${mode ne 'new'}">--%>
<%--                        <input type="text" name="name" value="${lstRegistDto.name}" size="80"><br>--%>
<%--                    </c:when>--%>
<%--                </c:choose>--%>
<%--            </div>--%>
            <div class="registBody" > 교재<br>
                <c:choose>
                    <c:when test="${mode eq 'new'}">
                        <input type="text" name="book" placeholder="해당 강의에 해당하는 교재를 입력해주세요." size="80">
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <input type="text" name="book" value="${lstRegistDto.book}" size="80"><br>
                    </c:when>
                </c:choose>
            </div>
            <div class="registBody"> 준비물<br>
                <c:choose>
                    <c:when test="${mode eq 'new'}">
                        <input type="text" name="material" placeholder="해당 강의에 필요한 준비물을 입력해주세요." size="80">
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <input type="text" name="material" value="${lstRegistDto.material}" size="80"><br>
                    </c:when>
                </c:choose>
            </div>

            <div id="registPrice">
                가격<br>
                <c:choose>
                    <c:when test="${mode eq 'new'}">
                        <input type="text" name="totalPrice" placeholder="가격을 입력해주세요." onchange="calculPrice()">
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <input type="text" name="totalPrice" onchange="calculPrice()" value="${lstRegistDto.totalPrice}">원&emsp;&emsp;&emsp;
                    </c:when>
                </c:choose>
            </div>
            <div id="registDiscount">
                할인율<br>
                <select name="discount" onchange="calculPrice()">
                    <c:choose>
                        <c:when test="${mode eq 'new'}">
                            <option value="<c:out value="0%"/>">0%</option>
                            <option value="<c:out value="10%"/>">10%</option>
                            <option value="<c:out value="20%"/>">20%</option>
                            <option value="<c:out value="30%"/>">30%</option>
                            <option value="<c:out value="40%"/>">40%</option>
                            <option value="<c:out value="50%"/>">50%</option>
                        </c:when>
                        <c:when test="${mode ne 'new'}">
                            <option id="discount" name="discount">${lstRegistDto.discount}</option>
                        </c:when>
                    </c:choose>
                    <%--                <option>0%</option>--%>
                    <%--                <option>10%</option>--%>
                    <%--                <option>20%</option>--%>
                    <%--                <option>30%</option>--%>
                    <%--                <option>40%</option>--%>
                    <%--                <option>50%</option>--%>
                </select>&emsp;&emsp;&emsp;
            </div>
            <div id="registTotal">
                총 가격<br>
                <c:choose>
                    <c:when test="${mode eq 'new'}">
                        <input type="text" name="lastPrice">
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <input type="text" name="lastPrice" value="${lstRegistDto.lastPrice}">원
                    </c:when>
                </c:choose>
            </div>

            <div id="registEtc"> 내용<br>
                <c:choose>
                    <c:when test="${mode eq 'new'}">
                        <textarea name="content" rows="15" cols="91" placeholder="강의 내용을 입력해주세요."></textarea>
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <textarea name="content" rows="15" cols="91">${lstRegistDto.content}</textarea>
                    </c:when>
                </c:choose>
            </div>

            <div id="registAttach">
                첨부파일<br>
                <c:choose>
                    <c:when test="${mode eq 'new'}">
                        <input type="file"><br>
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <input type="file" value="${lstRegistDto.attachedFile}"><br>
                    </c:when>
                </c:choose>
            </div>
            <hr>

            <div id="registBtAll">
                <c:choose>
<%--                    <c:when test="${mode eq 'new'}">--%>
<%--                        <input type="button" id="registRegistBt"  onclick="regist()" value="등록하기">--%>
<%--                    </c:when>--%>
                    <c:when test="${mode eq 'new'}">
                        <input type="button" id="registRegistBt" value="등록하기">
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <button type="button" id="registModifyBt">수정하기</button>
                    </c:when>
                </c:choose>
                <%--글쓰기 모드일때(삭제버튼 사라짐) / 읽기 모드일때(삭제버튼 활성화)--%>
                <c:if test="${mode eq null}">
                    <button type="button" id="registRemoveBt">삭제하기</button>
                </c:if>
                <button type="button" id="registListBt">돌아가기</button>
            </div>
        </form>
    </div>
</div>
<script>

</script>

<script>
    $(document).ready(function() {
        $("#registRegistBt").on("click", function() {
            if(!confirm("해당 게시물을 등록하시겠습니까?")) return;

            let form = $("#registForm");
            <%--form.attr("action", "<c:url value='/onlyAdmin/lstRegist/addRegist'/>");--%>
            form.attr("action", "<c:url value='/lstRegist/addRegist'/>");
            form.attr("method", "post");


            let formData = new FormData(form[0]);
            for (let pair of formData.entries()) {
                console.log(pair[0]+ ', ' + pair[1]);
            }

           form.submit();
        });

        $("#registModifyBt").on("click", function() {
            if(!confirm("해당 게시물을 정말로 수정하시겠습니까?")) return;

            let form = $("#registForm");
            <%--form.attr("action", "<c:url value='/onlyAdmin/lstRegist/modifyRegist${searchCondition.queryString}'/>");--%>
            form.attr("action", "<c:url value='/lstRegist/modifyRegist${searchCondition.queryString}'/>");
            form.attr("method", "post");
            form.submit();
        });

        $("#registRemoveBt").on("click", function() {
            if(!confirm("정말로 삭제하시겠습니까?")) return;

            let form = $("#registForm");
            <%--form.attr("action", "<c:url value='/onlyAdmin/lstRegist/removeRegist'/>?page=${param.page}&pageSize=${param.pageSize}");--%>
            form.attr("action", "<c:url value='/lstRegist/removeRegist${searchCondition.queryString}'/>");
            form.attr("method", "post");
            form.submit();
        });

        $("#registListBt").on("click", function() {
            <%--location.href="<c:url value='/onlyAdmin/lstRegist/list?page=${param.page}&pageSize=${param.pageSize}'/>";--%>
            location.href="<c:url value='/lstRegist/list${searchCondition.queryString}'/>";
        });
    });

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
                        .attr("type", "text")
                        .attr("name", subjectName)
                        .val(className)[0];
                    var inputElement2 = $("<input>")
                        .attr("type", "text")
                        .attr("name", priceName)
                        .val(price)[0]; // jQuery 객체를 DOM 요소로 변환
                    var brTag = $("<br>");

                    // 각각의 input 요소와 함께 추가
                    $("#classEnrollInfo").append(inputElement, inputElement2, brTag);
                    totalPrice += parseFloat(price) || 0;
                });
                document.getElementsByName("totalPrice")[0].value = totalPrice;
            },
            error: function (error) {
                console.log("실패");
            },
        });

    }
    <%--  가격계산하는 script  --%>
    function calculPrice() {
        var price = document.getElementsByName('totalPrice')[0].value;
        var rate = document.getElementsByName('discount')[0].value;
        rate = rate.replace(/[^0-9]/g, '');
        var totalPrice = price - (price * (rate * 0.01));
        document.getElementsByName('lastPrice')[0].value = totalPrice;
    }
</script>
</body>
</html>
