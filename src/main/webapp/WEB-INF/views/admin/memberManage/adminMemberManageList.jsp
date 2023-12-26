<%--
  Created by IntelliJ IDEA.
  User: wjdtn
  Date: 2023-12-19
  Time: 오전 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/home.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminInfo.css"/>">
    <!-- 탭 아이콘 & 글자 지정 -->
    <link rel="icon" href="/img/white_mainlogo.png"/>
    <link rel="apple-touch-icon" href="/img/white_mainlogo.png"/>
    <title>정석코딩 관리자 | 회원 정보 관리</title>
    <%--폰트어썸 라이브러리 불러오기--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script>
        window.onload=function (){
            let msg = "${param.msg}";
            if (msg == "LIST_ERR") alert("회원 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
            if (msg == "MOD_ERR") alert("수정에 실패했습니다. 다시 시도해 주세요.");
            if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");
        }
    </script>
</head>
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
                    <i class="fa-solid fa-user" style="color: #353739;"></i>
                    &nbsp;&nbsp;회원 정보 관리</h1>
            </div>
            <div id="main_content_controll">
                <div id="memberSearchBox">
                    <form action="#" method="get">
                        <select name="option" id="memberSearchBox_select">
                            <option value="T" ${sc.option=='T' || sc.option=='' ? "selected" : ""}>이름</option>
                            <option value="W" ${sc.option=='W' || sc.option=='' ? "selected" : ""}>아이디</option>
                            <option value="R" ${sc.option=='R' || sc.option=='' ? "selected" : ""}>등급</option>
                            <option value="Q" ${sc.option=='Q' || sc.option=='' ? "selected" : ""}>상태</option>
                        </select>
                        <input type="text" name="keyword" value="${param.keyword}" id="keywordInput"
                               placeholder="검색어를 입력해주세요"/>
                        <input type="submit" value="검색" class="searchBtn"/>
                    </form>
                </div>
                <div id="memberUpdateBox">
                    <select name="grade" id="grade">
                        <option value="1">일반</option>
                        <option value="2">학생</option>
                        <option value="3">강사</option>
                        <option value="4">관리자(조교)</option>
                    </select>
                    <select name="status" id="status" style="width: 100px">
                        <option value="1">정상</option>
                        <option value="2">블랙</option>
                        <option value="3">탈퇴</option>
                        <option value="4">휴면</option>
                    </select>
                    <input type="button" value="등급/상태 수정" class="modifyBtn" onclick="statusUpdate()">
                </div>
            </div>
            <div id="memberListBox">
                <table>
                    <tr>
                        <th style="width: 50px;"><input type="checkbox" id="allCheckBox" onclick="allChecked()"></th>
                        <th style="width: 50px;">No.</th>
                        <th style="width: 200px;">아이디</th>
                        <th style="width: 100px;">이름</th>
                        <th style="width: 100px;">닉네임</th>
                        <th style="width: 100px;">성별</th>
                        <th style="width: 150px;">휴대전화</th>
                        <th style="width: 150px;">등급</th>
                        <th style="width: 80px;">상태</th>
                        <th style="width: 200px;">가입일</th>
                        <th style="width: 100px;">비고</th>
                    </tr>
                    <c:forEach var="memberDto" items="${list}">
                        <tr>
                            <td><input type="checkbox"
                                       value="${memberDto.mebrNo}"
                                       class="chk"
                                       name="chk" onclick="chkClicked()"
                            >
                            </td>
                            <td>${memberDto.mebrNo}</td>
                            <td>${memberDto.id}</td>
                            <td>${memberDto.name}</td>
                            <td>${memberDto.nickname}</td>
                            <td>${memberDto.gender}</td>
                            <td id="td_phone">${memberDto.phone}</td>
                            <td>${memberDto.grade}</td>
                            <td>${memberDto.status}</td>
                            <td><fmt:formatDate value="${memberDto.regDate}"
                                                pattern="yyyy-MM-dd" type="date"/></td>
                            <td>
                                <button class="detailBtn"
                                        onclick="location.href='/adminManage/memberManage/read?page=${sc.page}&mebrNo=${memberDto.mebrNo}'">
                                    상세보기
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="infoNaviBox">
                <c:if test="${page.totalCnt==null || page.totalCnt==0}">
                    <p id="noContent">등록된 회원이 없습니다 .</p>
                </c:if>

                <c:if test="${page.totalCnt!=null && page.totalCnt!=0}">
                    <p>
                        <c:if test="${page.showPrev}">
                            <a href="<c:url value="/adminManage/memberManage/list${sc.getQueryString(page.beginPage-1)}"/>">&lt;</a>
                        </c:if>
                        <c:forEach var="i" begin="${page.beginPage}" end="${page.endPage}">
                            <a href="<c:url value="/adminManage/memberManage/list${sc.getQueryString(i)}"/>"
                               class="naviPage${i==sc.page? "-active" : ""}">${i}</a>
                        </c:forEach>
                        <c:if test="${page.showNext}">
                            <a href="<c:url value="/adminManage/memberManage/list${sc.getQueryString(page.endPage+1)}"/>">&gt;</a>
                        </c:if>
                    </p>
                </c:if>
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

    //글삭제
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
                    console.log(v.value);
                });

                const form = document.createElement('form');
                form.setAttribute('method', 'post');        //Post 메소드 적용
                form.setAttribute('action', '/adminManage/memberManage/modifyMain?page=' +${sc.page});

                var input1 = document.createElement('input');
                var input2 = document.getElementById('grade');
                var input3 = document.getElementById('status');
                input1.setAttribute("type", "hidden");
                input1.setAttribute("name", "mebrNoArr");
                input1.setAttribute("value", arr);
                form.appendChild(input1);
                form.appendChild(input2);
                form.appendChild(input3);
                console.log(form);
                document.body.appendChild(form);
                form.submit();
            }
        }
    }
</script>

</html>
