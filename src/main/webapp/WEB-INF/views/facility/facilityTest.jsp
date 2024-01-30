<%--
  Created by IntelliJ IDEA.
  User: sanghoon
  Date: 2023/11/26
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
    <title>lockerTest</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<br>
<h1>사물함 테스트 버튼입니다</h1>
<div>
    <button>
        <a href="/locker/adminList">관리자 사물함</a>
    </button>
</div>
<br><br>
<button>
    <a href="/locker/mebrList">유저 사물함</a>
</button>
<br><br>
<button>
    <a href="/locker/mebrFastCampus">패캠 사물함 페이지</a>
</button>
</body>
<br><br>
<button>
    <a href="/coupon/adminList">쿠폰리스트 페이지</a>
</button>
</html>
