<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <title>정석코딩</title>
</head>
<body>

<footer>
    <div id="footerContent">
        <div id="footerLeft">
            <a href="<c:url value='/'/>"><img id="mainlogo_footer" src="/img/white_mainlogo.png"/><br/></a>
            <a href="<c:url value='/'/>"><p>정석코딩</p></a>
        </div>
        <div id="footerRight">
            <div id="snsBox">
                <ul>
                    <li><a href="https://github.com/castello">
                        <%--                        <img src="/img/github.png"/>--%>
                        <i class="fa-brands fa-github fa-2xl" style="color: #ffffff;"></i>
                    </a></li>
                    <li><a href='https://cafe.naver.com/javachobostudy' target='_blank'>
                        <%--                        <img src="/img/cafe.png"/>--%>
                        <i class="fa-solid fa-mug-saucer fa-2xl" style="color: #ffffff;"></i>
                    </a>
                    </li>
                    <li><a href='https://www.youtube.com/@MasterNKS' target='_blank'>
                        <%--                        <img src="/img/youtube.png"/>--%>
                        <i class="fa-brands fa-youtube fa-2xl" style="color: #ffffff;"></i>
                    </a>
                    </li>
                    <li><a href='https://www.instagram.com/jungsukcoding/' target='_blank'>
                        <%--                        <img src="/img/instagram.png"/>--%>
                        <i class="fa-brands fa-instagram fa-2xl" style="color: #ffffff;"></i>
                    </a></li>
                    <li><a href='https://codechobo.tistory.com/' target='_blank'>
                        <%--                        <img src="/img/tistory.png" id="tistory"/>--%>
                        <i class="fa-solid fa-t fa-2xl" style="color: #ffffff;"></i>
                    </a></li>
                </ul>
            </div>
            <div id="infoBox">
                <ul>
                    <li><a href="#">개인정보처리방침</a></li>
                    <li><a href="#">이용약관</a></li>
                </ul>
            </div>
            <div id="addrBox">
                <span>상호명 : 정석코딩 | 대표 : 남궁성 | 메일 : jungsukcoding@jscd.com | 사업자 번호 : 888-44-00000</span>
                <span>주소 : 서울 종로구 종로2가 서울 YMCA 빌딩 0층 000호</span>
            </div>
            <div id="copyRight">
                <p>Copyright ⓒ2023 HappyHaJo. All rights reserved.</p>
            </div>
        </div>
    </div>
</footer>
</body>
</html>