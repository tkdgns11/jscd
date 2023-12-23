    <%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page session="false" %>
    <c:set var="loginId"
           value="${pageContext.request.getSession(false)==null ? null : pageContext.request.session.getAttribute('id')}"/>
    <c:set var="loginPath" value="${loginId=='' ? '/member/login' : '/member/logout'}"/>
    <c:set var="loginStatus" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>

    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>">


        <!-- 탭 아이콘 & 글자 지정 -->
        <link rel="icon" href="/img/mainlogo.png"/>
        <link rel="apple-touch-icon" href="/img/mainlogo.png"/>
        <title>정석코딩 | 아이디 찾기</title>
        <style>
            #findEmailBox {
                margin-left: 20%;
            }

            #findEmailBox input[type=text] {
                width: 350px;
                height: 40px;
                background-color: rgba(0, 0, 0, 0.1);
                border: 0;
                border-radius: 5px;

            }

            #findEmailBox input[type=text]:focus {
                outline: none;
            }

            #findEmail {
                width: 357px;
                height: 40px;
                font-size: 19px;
                background-color: #0185FE;
                color: #fff;
                cursor: pointer;
                border-radius: 5px;
                letter-spacing: 10px;
                font-weight: 600;
                border: 0;
                margin-top: 30px;
                margin-bottom: 30px;
                /*margin-left: 10px;*/
            }

        </style>
    </head>
    <body>

    <script>
        let msg = "${param.msg}";
        if (msg == "EMAIL_ERR") alert("입력하신 회원정보에 맞는 아이디가 없습니다.");

    </script>
    <header>
        <jsp:include page="../../header.jsp"/>
    </header>
    <div id="loginWrap">
        <div id="loginHeader" style="border: none;margin-left: 360px">
            <h1>이메일찾기</h1>
        </div>

        <div id="findEmailBox">
            <input type="text" name="name" id="name" placeholder="이름"
            ><br><br>
            <input type="text" name="phone" id="phone" placeholder="휴대전화"
                   oninput="autoHyphen(this)"><br><br>
            <input type="text" name="birth" id="birth"
                   placeholder="생년월일 6자리(ex.950324)"><br>
        </div>
        <input type="submit" value="확인" id="findEmail">
    </div>
    <footer style="flex-shrink: 0;">
        <jsp:include page="../../footer.jsp" flush="true"/>
    </footer>

    <script>
        const autoHyphen = (target) => {
            target.value = target.value
                .replace(/[^0-9]/g, '')
                .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
        }
        $(document).ready(function () {

            let name = document.getElementById('name');
            let phone = document.getElementById('phone');
            let birth = document.getElementById('birth');

            $('#findEmail').on("click", function () {

                if (name.value == "" || phone.value == "" || birth.value == "") {
                    alert("회원 정보를 입력 해주세요");
                } else {
                    const form = document.createElement('form');
                    form.setAttribute('method', 'post');
                    form.setAttribute('action', '/member/findEmail');
                    form.appendChild(name);
                    form.appendChild(phone);
                    form.appendChild(birth);

                    document.body.appendChild(form);
                    form.submit()
                }


            })


        })
    </script>
    </body>
    </html>