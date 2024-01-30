<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/white_mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/white_mainlogo.png"/>
    <title>정석코딩 관리자 | 학생 정보 관리</title>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Noto+Serif+KR:wght@900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jscdReset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfo.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/home.css"/>">
    <%--폰트어썸 라이브러리 불러오기--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<script>
    let msg = "${param.msg}";
    if (msg == "LIST_ERR") alert("학생 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
    if (msg == "MOD_ERR") alert("수정에 실패했습니다. 다시 시도해 주세요.");
    if (msg == "DEL_OK") alert("삭제 되었습니다.");
    if (msg == "DEL_ERR") alert("삭제가 실패했습니다. 다시 시도해 주세요.");
    if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");


</script>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>
<div id="adminContent">
    <nav>
        <jsp:include page="../sidebar.jsp"/>
    </nav>
    <main>
        <div id="memberInfo">
            <div id="infoTitleBox">
                <h1>
                    <i class="fa-solid fa-user-graduate" style="color: #353739;"></i>
                    &nbsp;&nbsp;학생 정보 관리</h1>
            </div>
            <div id="main_content_controll">
                <div id="memberSearchBox">
                    <form action="#" method="get">
                        <select name="option" id="memberSearchBox_select">
                            <option value="T" ${sc.option=='T' || sc.option=='' ? "selected" : ""}>이름</option>
                            <option value="W" ${sc.option=='W' || sc.option=='' ? "selected" : ""}>아이디</option>
                            <option value="R" ${sc.option=='R' || sc.option=='' ? "selected" : ""}>기수</option>
                            <option value="Q" ${sc.option=='Q' || sc.option=='' ? "selected" : ""}>상태</option>
                        </select>
                        <input type="text" name="keyword" value="${param.keyword}" id="keywordInput" placeholder="검색어를 입력해주세요"/>
                        <input type="submit" value="검색" class="searchBtn"/>
                    </form>
                </div>
                <div id="stdUpdateBox">
                    <select name="status" id="status">
                        <option value="" disabled selected>변경할 상태를 골라주세요</option>
                        <option value="1">수강예정</option>
                        <option value="2">수강중</option>
                        <option value="3">수료</option>
                    </select>
                    <input type="button" value="수정" class="modifyBtn" onclick="statusUpdate()">
                    <input type="button" value="삭제" class="deleteBtn" onclick="stdDelete()">
                </div>
            </div>

            <div id="memberListBox">
                <table>
                    <tr>
                        <th style="width: 50px;"><input type="checkbox" id="allCheckBox" onclick="allChecked()"></th>
                        <th style="width: 80px">No.</th>
                        <th style="width: 250px;">아이디</th>
                        <th style="width: 100px;">이름</th>
                        <th style="width:250px;">휴대전화</th>
<%--                        <th style="width: 100px;">기수</th>--%>
                        <th style="width:100px;">상태</th>
                        <th style="width:250px;">가입일</th>
                        <th style="width:100px;"></th>
                    </tr>
                    <c:forEach var="stdDto" items="${list}">
                        <tr>
                            <td><input type="checkbox"
                                       value="${stdDto.mebrNO}"
                                       class="chk"
                                       name="chk" onclick="chkClicked()">
                            </td>
                            <td>${stdDto.mebrNO}</td>
                            <td>${stdDto.id}</td>
                            <td>${stdDto.name}</td>
                            <td>${stdDto.phone}</td>
<%--                            <td>${stdDto.gisu}</td>--%>
                            <td>${stdDto.status}</td>
                            <td><fmt:formatDate value="${stdDto.regDate}"
                                                pattern="yyyy-MM-dd"
                                                type="date"/></td>
                            <td>
                                <button class="detailBtn"
                                        onclick="location.href='/adminManage/stdManage/read?page=${sc.page}&mebrNO=${stdDto.mebrNO}'">
                                    상세보기
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="infoNaviBox">
                <c:if test="${totalCnt==null || totalCnt==0}">
                    <p id="noContent">등록된 학생이 없습니다 .</p>
                </c:if>
                <c:if test="${totalCnt!=null && totalCnt!=0}">
                    <c:if test="${page.showPrev}">
                        <a href="<c:url value="/adminManage/stdManage/list${sc.getQueryString(page.beginPage-1)}"/>">
                            <i class="fa-solid fa-backward" style="color: #353739;"></i></a>
                    </c:if>
                    <c:forEach var="i" begin="${page.beginPage}" end="${page.endPage}">
                        <a href="<c:url value="/adminManage/stdManage/list${sc.getQueryString(i)}"/>"
                           class="naviPage${i==sc.page? "-active" : ""}"
                        >${i}</a>
                    </c:forEach>
                    <c:if test="${page.showNext}">
                        <a href="<c:url value="/adminManage/stdManage/list${sc.getQueryString(page.endPage+1)}"/>">&gt;&g
                            <i class="fa-solid fa-forward" style="color: #353739;"></i></a>
                    </c:if>
                </c:if>
            </div>

        </div>
</div>
</main>
</div>
</body>

<script>
    function allChecked(target) {

        //전체 체크박스 버튼
        const checkbox = document.getElementById('allCheckBox');

        //전체 체크박스 버튼 체크 여부
        const is_checked = checkbox.checked;

        //전체 체크박스 제외한 모든 체크박스
        if (is_checked) {
            //체크박스 전체 체크
            chkAllChecked()
        } else {
            //체크박스 전체 해제
            chkAllUnChecked()
        }
    }

    //자식 체크박스 클릭 이벤트
    function chkClicked() {

        //체크박스 전체개수
        const allCount = document.querySelectorAll(".chk").length;

        //체크된 체크박스 전체개수
        const query = 'input[name="chk"]:checked'
        const selectedElements = document.querySelectorAll(query)
        const selectedElementsCnt = selectedElements.length;

        //체크박스 전체개수와 체크된 체크박스 전체개수가 같으면 전체 체크박스 체크
        if (allCount == selectedElementsCnt) {
            document.getElementById('allCheckBox').checked = true;
        }

        //같지않으면 전체 체크박스 해제
        else {
            document.getElementById('allCheckBox').checked = false;
        }
    }

    //체크박스 전체 체크
    function chkAllChecked() {
        document.querySelectorAll(".chk").forEach(function (v, i) {
            v.checked = true;
        });
    }

    //체크박스 전체 체크 해제
    function chkAllUnChecked() {
        document.querySelectorAll(".chk").forEach(function (v, i) {
            v.checked = false;
        });
    }

    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    //글수정
    function statusUpdate() {
        //체크박스 체크된 항목
        const query = 'input[name="chk"]:checked'
        const selectedElements = document.querySelectorAll(query)

        //체크박스 체크된 항목의 개수
        const selectedElementsCnt = selectedElements.length;

        if (selectedElementsCnt == 0) {
            alert("수정할 항목을 선택해주세요.");
            return false;
        } else {
            if (confirm("상태를 변경 하시겠습니까?")) {
                //배열생성
                const arr = new Array(selectedElementsCnt);

                document.querySelectorAll('input[name="chk"]:checked').forEach(function (v, i) { //i는 인덱스, v는 input체크박스
                    arr[i] = v.value;
                });

                const form = document.createElement('form');
                form.setAttribute('method', 'post');        //Post 메소드 적용
                form.setAttribute('action', '/adminManage/stdManage/modifyStatus?page=' +${sc.page});

                var input1 = document.createElement('input');
                var input2 = document.getElementById('status');
                input1.setAttribute("type", "hidden");
                input1.setAttribute("name", "mebrNoArr");
                input1.setAttribute("value", arr);
                form.appendChild(input1);
                form.appendChild(input2);
                console.log(form);
                document.body.appendChild(form);
                form.submit();
            }
        }
    }

    //글삭제
    function stdDelete() {
        //체크박스 체크된 항목
        const query = 'input[name="chk"]:checked'
        const selectedElements = document.querySelectorAll(query)

        //체크박스 체크된 항목의 개수
        const selectedElementsCnt = selectedElements.length;

        if (selectedElementsCnt == 0) {
            alert("삭제할 항목을 선택해주세요.");
            return false;
        } else {
            if (confirm("삭제 하시겠습니까?")) {
                //배열생성
                const arr = new Array(selectedElementsCnt);

                document.querySelectorAll('input[name="chk"]:checked').forEach(function (v, i) { //i는 인덱스, v는 input체크박스
                    arr[i] = v.value;
                    console.log(v.value);
                });


                const form = document.createElement('form');
                form.setAttribute('method', 'post');        //Post 메소드 적용
                form.setAttribute('action', '/adminManage/stdManage/deleteMain?page=${sc.page}');

                var input1 = document.createElement('input');
                input1.setAttribute("type", "hidden");
                input1.setAttribute("name", "mebrNoArr");
                input1.setAttribute("value", arr);
                form.appendChild(input1);
                document.body.appendChild(form);
                form.submit();
            }
        }
    }
</script>
</html>
