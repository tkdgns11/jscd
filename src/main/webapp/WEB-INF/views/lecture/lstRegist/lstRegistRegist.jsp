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
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Noto+Serif+KR:wght@900&display=swap"
          rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/home.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/regist.css"/>">
    <link rel="icon" href="/img/mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
    <script type="text/javascript" src="<c:url value="/js/lstRegist.js"/>"></script>
    <title>정석코딩 강의 등록</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/admin/header.jsp"/>
</header>
<div id="adminContent">
    <nav>
        <jsp:include page="/WEB-INF/views/admin/sidebar.jsp"/>
    </nav>
    <main>
        <div id="infoDetailBox" class="infoDetailClass">
            <h1 id="infoTitle">정석코딩 강의 ${mode == "new" ? '등록' : '세부사항'}</h1>

            <form id="registForm" action="" enctype="multipart/form-data">
                <input type="hidden" name="registCode" value="${lstRegistDto.registCode}">
                <input type="hidden" id="fileNo" name="fileNo" value="">
                <input type="hidden" id="fileNoDel" name="fileNoDel[]" value="">
                <input type="hidden" id="fileNameDel" name="fileNameDel[]" value="">

                <label style="margin-right: 3px;">강의 제목</label>
                <input type="text" name="title" value="${lstRegistDto.title}" ${mode == "new" ? '' : 'readonly="readonly"'} placeholder="개설할 강의 제목을 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='강의에 대한 소개를 입력해주세요.'" >
                <br>

                <label style="">강의 소개</label>
                <input type="text" name="discription" value="${lstRegistDto.discription}" ${mode == "new" ? '' : 'readonly="readonly"'} placeholder="개설할 강의의 설명을 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='개설할 강의의 설명을 입력해주세요.'" >
                <br>

                <label style="">과정 선택</label>
                <c:choose>
                    <c:when test="${mode eq 'new'}">
                        <select class="modifySelect" name="courseCode" onchange="courseSelect(this.value)">
                            <option value="" disabled selected>과정을 선택해주세요.</option>
                            <c:forEach var="list" items="${list}">
                                <option value="${list.courseCode}">${list.courseName}</option>
                            </c:forEach>
                        </select>
                        <br>
                    </c:when>
                    <c:when test="${mode ne 'new'}">
                        <input type="text" name="courseCode" value="${lstRegistDto.courseName}" ${mode=='new' ? '' : 'disabled="disabled"'}>
                        <br>
                    </c:when>
                </c:choose>

                <label style="">과목구분</label>
                <input type="text" name="courseCategory" value="${lstRegistDto.courseCategory}" ${mode=='new' ? '' : 'disabled="disabled"'} placeholder="세미나 개설시 입력해주세요 ex)디자인패턴 - JAVA" onfocus="this.placeholder=''" onblur="this.placeholder='세미나 개설시 입력해주세요 ex)디자인패턴 - JAVA'">
                <br>

                <label style="">세부사항</label>
                <div id="classEnrollInfo">
                    <c:if test="${mode ne 'new'}">
                        <input type="text" class="detail" name="subject1" value="${lstRegistDto.subject1}" readonly="readonly">
                        <input type="text" class="detail" name="price1" value="${lstRegistDto.price1}" readonly="readonly"><br>
                        <input type="text" class="detail" name="subject2" value="${lstRegistDto.subject2}" readonly="readonly">
                        <input type="text" class="detail" name="price2" value="${lstRegistDto.price2}" readonly="readonly"><br>
                        <input type="text" class="detail" name="subject3" value="${lstRegistDto.subject3}" readonly="readonly">
                        <input type="text" class="detail" name="price3" value="${lstRegistDto.price3}" readonly="readonly"><br>
                        <input type="text" class="detail" name="subject4" value="${lstRegistDto.subject4}" readonly="readonly">
                        <input type="text" class="detail" name="price4" value="${lstRegistDto.price4}" readonly="readonly"><br>
                        <input type="text" class="detail" name="subject5" value="${lstRegistDto.subject5}" readonly="readonly">
                        <input type="text" class="detail" name="price5" value="${lstRegistDto.price5}" readonly="readonly"><br>
                    </c:if>
                </div>

                <label style="">온/오프라인</label>
                <select name="onOff" value="${lstRegistDto.onOff}" ${mode=='new' ? '' : 'disabled="disabled"'}>
                    <c:choose>
                        <c:when test="${mode eq 'new'}">
                            <option value="" disabled selected>온/오프옵션을 선택해주세요.</option>
                        </c:when>
                        <c:when test="${mode ne 'new'}">
                            <option value="${lstRegistDto.onOff}">${lstRegistDto.onOff}</option>
                        </c:when>
                    </c:choose>
                    <option value="<c:out value="온라인"/>">온라인</option>
                    <option value="<c:out value="오프라인"/>">오프라인</option>
                </select>
                <br>

                <label style="">진행 상태</label>
                <select name="status" value="${lstRegistDto.status}" ${mode=='new' ? '' : 'disabled="disabled"'}>
                    <c:choose>
                        <c:when test="${mode eq 'new'}">
                            <option value="" disabled selected>진행상태옵션을 선택해주세요.</option>
                        </c:when>
                        <c:when test="${mode ne 'new'}">
                            <option value="${lstRegistDto.status}">${lstRegistDto.status}</option>
                        </c:when>
                    </c:choose>
                    <option value="<c:out value="진행예정"/>">진행예정</option>
                    <option value="<c:out value="진행 중"/>">진행 중</option>
                    <option value="<c:out value="종료"/>">종료</option>
                </select>
                <br>

                <label style="">최소 인원</label>
                <input type="number" name="minNum" min="5" max="30" value="${lstRegistDto.minNum}" ${mode == "new" ? '' : 'readonly="readonly"'}>
                <br>

                <label style="">최대 인원</label>
                <input type="number" name="maxNum" min="5" max="30" value="${lstRegistDto.maxNum}" ${mode == "new" ? '' : 'readonly="readonly"'}>
                <br>

                <label style="">강의 장소</label>
                <select class="modifySelect" name="location" value="${lstRegistDto.location}" ${mode=='new' ? '' : 'disabled="disabled"'}>
                    <c:choose>
                        <c:when test="${mode eq 'new'}">
                            <option value="" disabled selected>강의 장소를 선택해주세요.</option>
                        </c:when>
                        <c:when test="${mode ne 'new'}">
                            <option value="${lstRegistDto.location}">${lstRegistDto.location}</option>
                        </c:when>
                    </c:choose>
                    <option value="<c:out value="종로구 종로 서울 YMCA 빌딩 423호"/>">서울시 종로구 종로 서울 YMCA 빌딩 423호</option>
                    <option value="<c:out value="종로구 종로 서울 YMCA 빌딩 425호"/>">서울시 종로구 종로 서울 YMCA 빌딩 425호</option>
                    <option value="<c:out value="종로구 종로 서울 YMCA 빌딩 518호"/>">서울시 종로구 종로 서울 YMCA 빌딩 518호</option>
                </select>
                <br>

                <label style="">수강기간</label><br>
                <label style="">시작일</label>
                <input type="date" name="startDate" value="${lstRegistDto.startDate}" ${mode == "new" ? '' : 'readonly="readonly"'}>
                <label style="">종료일</label>
                <input type="date" name="endDate" value="${lstRegistDto.endDate}" ${mode == "new" ? '' : 'readonly="readonly"'}>
                <br>

                <label style="">수강시간</label><br>
                <label style="">시작 시간</label>
                <input type="time" name="startTime" value="${lstRegistDto.startTime}" ${mode == "new" ? '' : 'readonly="readonly"'}>
                <label style="">종료 시간</label>
                <input type="time" name="endTime" value="${lstRegistDto.endTime}" ${mode == "new" ? '' : 'readonly="readonly"'}>
                <br>

                <label style="">강사</label>
                <input type="text" name="name" value="${lstRegistDto.name}" ${mode == "new" ? '' : 'readonly="readonly"'}>
                <br>

                <label style="">교재</label>
                <input type="text" name="book" value="${lstRegistDto.book}" ${mode == "new" ? '' : 'readonly="readonly"'}>
                <br>

                <label style="">준비물</label>
                <input type="text" name="material" value="${lstRegistDto.material}" ${mode == "new" ? '' : 'readonly="readonly"'}>
                <br>

                <label style="">가격</label>
                <input type="text" name="totalPrice" value="${lstRegistDto.totalPrice}" readonly="readonly">
                <br>

                <label style="">할인율</label>
                <select class="modifySelect" name="discount" onchange="calculPrice()" ${mode == "new" ? '' : 'disabled="disabled"'}>
                    <c:choose>
                        <c:when test="${mode eq 'new'}">
                            <option value="" disabled selected>할인율을 선택해주세요.</option>
                        </c:when>
                        <c:when test="${mode ne 'new'}">
                            <option value="${lstRegistDto.discount}">${lstRegistDto.discount}</option>
                        </c:when>
                    </c:choose>
                    <option value="<c:out value="0%"/>">0%</option>
                    <option value="<c:out value="10%"/>">10%</option>
                    <option value="<c:out value="20%"/>">20%</option>
                    <option value="<c:out value="30%"/>">30%</option>
                    <option value="<c:out value="40%"/>">40%</option>
                    <option value="<c:out value="50%"/>">50%</option>
                </select>
                <br>

                <label style="">총 가격</label>
                <input type="text" name="lastPrice" value="${lstRegistDto.lastPrice}" readonly="readonly">
                <br>

                <label style="">내용</label><br>
                <textarea class="contentBox" name="content" content="15" cols="91" ${mode == "new" ? '' : 'readonly="readonly"'} placeholder="개설할 강의의 내용을 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='개설할 강의의 내용을 입력해주세요.'"> ${lstRegistDto.content}</textarea>
                <br>

                <label style="">첨부파일</label>
                <input type="file" name="file" id="file" accept="<c:url value="/img/upload/img/*"/>"  onchange="setThumbnail(event)" multiple ${mode == "new" ? '' : 'readonly="readonly"'}>
                <div id="imgContainer"></div>

                <script>
                    function setThumbnail(event) {
                        for (var image of event.target.files) {
                            var reader = new FileReader();

                            reader.onload = function(event) {
                                var img = document.createElement("img");
                                img.setAttribute("src", event.target.result);
                                document.querySelector("#imgContainer").appendChild(img);
                            };

                            console.log(image);
                            reader.readAsDataURL(image);
                        }
                    }
                </script>

                <div>
                    <p>파일 목록</p>
                    <div style="width: 300px;">
                        <c:forEach var="file" items="${file}" varStatus="var">
                            <input type="hidden" id="fileNo" name="fileNo" value="${file.fileNo}">
                            <input type="hidden" id="fileName" name="fileName" value="fileNo${var.index}">
                            <a href="#" onclick="fn_fileDown('${file.fileNo}'); return false;">${file.originFileName}</a>(${file.fileSize}kb)<br>
                            <img src="<c:url value="/upload/img${file.storedFileName}"/>">
                            <input type="button" class="deleteImg" onclick="fn_del('${file.fileNo}', 'fileNo${var.index}');" value="x">
                        </c:forEach>
                    </div>
                    <%--            파일 삭제를 위해 폼 태그 밑에 선언해둔 곳에 정보를 push하는 메서드--%>
                    <script>
                        var fileNoArray = new Array();
                        var fileNameArray = new Array();
                        function fn_del(value, name) {
                            fileNoArray.push(value);
                            fileNameArray.push(name);
                            $("#fileNoDel").attr("value", fileNoArray);
                            $("#fileNameDel").attr("value", fileNameArray);

                            var imgElement = $("#img" + name);
                            imgElement.hide();
                        }
                    </script>
                </div>
                <br>

                <div>
                    <c:choose>
                        <c:when test="${mode eq 'new'}">
                            <input type="button" class="registeBtn" id="registRegistBt" value="등록하기">
                        </c:when>
                        <c:when test="${mode ne 'new'}">
                            <input type="button" class="registeBtn" id="registModifyBt" value="수정하기">
                        </c:when>
                    </c:choose>
                    <%--글쓰기 모드일때(삭제버튼 비활성화) / 읽기 모드일때(삭제버튼 활성화)--%>
                    <c:if test="${mode ne 'new'}">
                        <input type="button" class="deleteBtn" id="registRemoveBt" value="삭제하기">
                    </c:if>
                    <input type="button" class="backBtn" id="registListBt" value="돌아가기">
                </div>
            </form>


        </div>
    </main>
</div>
</body>


<script>
    $(document).ready(function() {
        $("#registRegistBt").on("click", function(e) {
            e.preventDefault();
            if(!confirm("해당 게시물을 등록하시겠습니까?")) return;

            let form = $("#registForm");
            console.log(form);
            form.attr("action", "<c:url value='/adminManage/lstRegist/addRegist'/>");
            form.attr("method", "post");
            form.attr("enctype", "multipart/form-data");

            form.submit();
        });

        $("#registModifyBt").on("click", function() {
            let form = $("#registForm");
            let readonly = $("input[name=title]", form).attr('readonly');

            // 1. 읽기 상태이면 수정 상태로 변경(form 순서에 맞게 정렬되어 있음)
            // (if에서 readonly 값만 확인해도 문제 없지만 확실하게 둘 다 확인)
            if(readonly!=undefined) {
                $(".head").html("/* 등록된 강의 수정모드 */");
                $("input[name=title]", form).attr('readonly', false);
                $("input[name=discription]", form).attr('readonly', false);
                $("select[name=courseCode]", form).attr('disabled', false);
                $("input[name=courseCategory]", form).attr('disabled', false);

                $("select[name=onOff]", form).attr('disabled', false);
                $("select[name=status]", form).attr('disabled', false);
                $("input[name=minNum]", form).attr('readonly', false);
                $("input[name=maxNum]", form).attr('readonly', false);
                $("select[name=location]", form).attr('disabled', false);

                $("input[name=startDate]", form).attr('readonly', false);
                $("input[name=endDate]", form).attr('readonly', false);
                $("input[name=startTime]", form).attr('readonly', false);
                $("input[name=endTime]", form).attr('readonly', false);
                $("input[name=name]", form).attr('readonly', false);
                $("input[name=book]", form).attr('readonly', false);
                $("input[name=material]", form).attr('readonly', false);
                $("select[name=discount]", form).attr('disabled', false);

                $("textarea[name=content]", form).attr('readonly', false);

                $("input[name=file]", form).attr('disabled', false);

                $("#registModifyBt").val("수정완료");
                return;
            }

            if(!confirm("해당 게시물을 정말로 수정하시겠습니까?")) return;
            form.attr("action", "<c:url value='/adminManage/lstRegist/modifyRegist${searchCondition.queryString}'/>");
            form.attr("method", "post");
            form.attr("enctype", "multipart/form-data");

            form.submit();
        });

        $("#registRemoveBt").on("click", function() {
            if(!confirm("정말로 삭제하시겠습니까?")) return;

            let form = $("#registForm");
            form.attr("action", "<c:url value='/adminManage/lstRegist/removeRegist${searchCondition.queryString}'/>");
            form.attr("method", "post");
            form.submit();
        });

        $("#registListBt").on("click", function() {
            location.href="<c:url value='/adminManage/lstRegist/list${searchCondition.queryString}'/>";
        });
    });
</script>
</html>