<%--
  Created by IntelliJ IDEA.
  User: sanghoon
  Date: 2023/12/10
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page import="java.net.URLDecoder"%>
<html lang="en">
<head>
<%--  <meta charset="UTF-8">--%>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css"/>">
  <script src="https://d3js.org/d3.v7.min.js"></script>
  <style>
    html,
    body {
      height: 100%;
      width: 100%;
      margin: 0;
      padding: 0;
    }

    body {
      font-family: "Lato", sans-serif;
    }

    #headerTop {
      height: 100%;
      justify-items: center;
      align-items: center;
    }

    #headerTop ul {
      height: 100%;
      display: flex;
      flex-direction: row;
      flex-warp: nowrap;
      justify-content: flex-end;
      align-items: center;
    }

    #headerTop ul li {
      height: 100%;
    }

    #headerTop ul li a {
      height: 100%;
      display: flex;
      text-decoration: none;
      font-size: 25px;
      align-items: center;
    }

    .admin_group {
      color: #f1f1f1;
      text-decoration: none;
      font-size: 25px;
    }

    #admin_title {
      margin-left: 45%;
      float:left;
      color: #f1f1f1;
      padding: 1rem 1rem 1rem 1rem;
      text-decoration: none;
      font-size: 25px;
      align-items: center;
    }


    .box {
      border: 1px solid #182566;
      margin-bottom: 10px;
    }

    .box-header {
      padding: 10px;
      cursor: pointer;
      position: relative;
    }

    .box-content {
      display: none;
      padding: 10px;
    }

    .arrow {
      position: absolute;
      top: 50%;
      right: 10px;
      transform: translateY(-50%);
      width: 0;
      height: 0;
      border-style: solid;
      border-width: 0 5px 5px 5px;
      border-color: transparent transparent #f1f1f1 transparent;
    }

    .arrow.up {
      transform: translateY(-50%) rotate(180deg);
    }

    .box-header {
      padding: 10px;
      cursor: pointer;
      position: relative;
    }

    .sidenav {
      height: 100%;
      width: 12%;
      position: fixed;
      z-index: 1;
      top: 0;
      left: 0;
      background-color: #182566;
      overflow-x: hidden;
      padding-top: 50px;
      float: left;
    }

    .sidenav a {
      padding: 6px 8px 6px 16px;
      text-decoration: none;
      font-size: 25px;
      color: #f1f1f1;
      display: block;
    }

    .sidenav a:hover {
      color: gold;
    }

    @media screen and (max-height: 450px) {
      .sidenav {
        padding-top: 15px;
      }

      .sidenav a {
        font-size: 18px;
      }
    }

    .dropdown-content {
      display: none;
      position: absolute;
      background-color: #f1f1f1;
      min-width: 160px;
      overflow: auto;
      box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
      z-index: 1;
    }

    .dropdown-content a {
      color: black;
      padding: 1rem 1rem;
      text-decoration: none;
      display: block;
    }

    .dropdown a:hover {
      background-color: #ddd;
    }

    #whole {
      padding-top: 50px;
      width: 88%;
      height: 100%;
      float: right;
    }

    #warp3 {
      width: 100%;
      height: 20%;
      display: flex;
      flex-direction: row;
      justify-content: space-around;
      align-items: center;
      flex-wrap: nowrap;
      align-content: stretch;
      margin-top: 1%;
      box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.5);

    }

    .list3rd {
      border-radius: 0.5rem;
      width: 23%;
      height: 80%;
      color: #f1f1f1;
      display: flex;
      flex-direction: column;
    }

    .list3rdContent {
      height: 100%;
      display: flex;
      flex-direction: row;
      flex-wrap: nowrap;
      justify-content: center;
      align-items: center;
    }

    .titleLogo {
      height: 50%;
      width: 20%;
    }

    .titleLogo i {
      font-size: 3rem;
      height: 100%;
    }

    .list3rdDetail {
      width: 80%;
      height: 80%;
    }

    .list3rdDetail h4 {
      height: 50%;
      font-size: 1.7rem;
      text-align: center;
    }

    .titleLogo i {
      padding: 6px 8px 6px 16px;
      text-decoration: none;
      font-size: 3rem;
      color: #f1f1f1;

    }

    #totalVisit {

      background-color: #41CDCD;
    }

    #newMember {
      background-color: #5EC75E;

    }

    #newApply {
      background-color: #FF4646;

    }

    #versionStatus {
      background-color: #D7AC87;

    }

    #warp2 {
      width: 100%;
      height: 40%;
      display: flex;
      flex-direction: row;
      justify-content: space-around;
      align-items: center;
      flex-wrap: nowrap;
      align-content: stretch;
      margin-top: 1%;
    }

    .list2ed {
      width: 50%;
      height: 90%;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.5);
      overflow: hidden;
      border-radius: 10px;
      margin-left: auto;
      margin-right: auto;
      position: relative;
      margin: 1%;

    }

    #osChart {
      display: flex;
      align-items: center;
      justify-content: center;

    }

    #visitHistory {}

    #osStatistics {}

    .Titles {
      font-weight: 700;
      margin: 0;
      margin-left: 1rem;
      margin-top: 0.5rem;
      margin-bottom: 0.5rem;
    }

    #warp1 {
      width: 100%;
      height: 30%;
      display: flex;
      flex-direction: row;
      justify-content: space-around;
      align-items: center;
      flex-wrap: nowrap;
      align-content: stretch;
    }

    .list1st {
      border-radius: 0.5rem;
      width: 33%;
      height: 90%;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.5);
      overflow: hidden;
      border-radius: 10px;
      margin-left: auto;
      margin-right: auto;
      margin: 0.5%;
      position: relative;
    }

    #memberStatus {}

    #deviceStatistics {}

    #adminNotice {}

    .layer23title {
      margin-left: 1rem;
    }

    .layer1contents {
      font-size: 2rem;
      padding: 0;
      margin: 0;
      margin-left: 2rem;
      display: flex;
      flex-direction: row;
      flex-wrap: nowrap;
      justify-content: flex-start;
      align-items: center;
      height: 50%;
    }

    #topAdmin i {
      font-size: 3.5rem;
      color: #96F56E;
    }

    #assistant i {
      font-size: 3.5rem;
      color: #FFA0FF;
    }

    .layer1contents h5 {
      margin-left: 1rem;
      font-size: 3rem;
    }

    .deviceContainer {
      width: 100%;
      background-color: #ddd;
      display: flex;
      align-items: center;
    }

    #desktop {
      height: 7rem;
      width: 100%;
    }

    #mobile {
      height: 7rem;
      width: 100%;
    }

    #desktop i {
      width: 20%;
      font-size: 3.5rem;
    }

    #mobile i {
      width: 20%;
      font-size: 4rem;
    }

    .deviceArea {
      width: 70%;
    }

    .device {
      text-align: right;
      padding-top: 10px;
      padding-bottom: 10px;
      color: white;
    }

    .desktop {
      height: 50%;
      width: 80%;
      background-color: #04AA6D;
    }

    .mobile {
      height: 50%;
      width: 20%;
      background-color: #2196F3;
    }

    table {
      width: 100%;
      border-collapse: collapse;
    }

    th, td {
      padding: 8px;
      text-align: center;
      border-bottom: 1px solid #ddd;
    }

    th {
      background-color: #f2f2f2;
    }
  </style>
  <script src="https://kit.fontawesome.com/d47308ea25.js" crossorigin="anonymous"></script>
</head>

<body>

<header>
  <jsp:include page="adminHeader.jsp"/>
</header>

<div id="whole">
  <div id="warp3">
    <div id="totalVisit" class="list3rd">
      <div class="list3rdContent">
        <div class="titleLogo">
          <i class="fa-solid fa-person"></i>
        </div>
        <div class="list3rdDetail">
          <h4>전체 방문자 수</h4>
          <h4>99999</h4>
        </div>
      </div>
      <div></div>
    </div>
    <div id="newMember" class="list3rd">
      <div class="list3rdContent">
        <div class="titleLogo">
          <i class="fa-solid fa-address-card"></i>
        </div>
        <div class="list3rdDetail">
          <h4>신규가입 현황</h4>
          <h4>55</h4>
        </div>
      </div>
      <div></div>
    </div>
    <div id="newApply" class="list3rd">
      <div class="list3rdContent">
        <div class="titleLogo">
          <i class="fa-solid fa-laptop"></i>
        </div>
        <div class="list3rdDetail">
          <h4>과정신청 현황</h4>
          <h4>33</h4>
        </div>
      </div>
      <div></div>
    </div>
    <div id="versionStatus" class="list3rd">
      <div class="list3rdContent">
        <div class="titleLogo">
          <i class="fa-solid fa-tags"></i>
        </div>
        <div class="list3rdDetail">
          <h4>version정보</h4>
          <h4>v 1.0</h4>
        </div>
      </div>
      <div></div>
    </div>
  </div>
  <div id="warp2">
    <div id="visitHistory" class="list2ed">
      <h4 class="Titles">방문자수 통계</h4>
      <div id="visitorsStatistics">
        <div id="visitorsChart">
        </div>
      </div>
    </div>
    <div class="list2ed">
      <h4 class="Titles">OS별 통계</h4>
      <div id="osStatistics">
        <div id="osChart">
        </div>
      </div>
    </div>
  </div>
  <div id="warp1">
    <div id="memberStatus" class="list1st">
      <h4 class="Titles">검색 통계</h4>
      <div id = "search">
      </div>
    </div>
    <div id="deviceStatistics" class="list1st">
      <h4 class="Titles">기기별 통계</h4>
      <div>
        <div id="desktop" class="layer1contents">
          <i class="fa-solid fa-desktop"></i>
          <div class = "deviceArea">
            <div>DESKTOP</div>
            <div class="deviceContainer">
              <div class="device desktop">80%</div>
            </div>
          </div>
        </div>
        <div id="mobile" class="layer1contents">
          <i class="fa-solid fa-mobile"></i>
          <div class = "deviceArea">
            <div>MOBILE</div>
            <div class="deviceContainer">
              <div class="device mobile">20%</div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div id="adminNotice" class="list1st">
      <h4 class="Titles">관리자공지</h4>
      <table>
        <thead>
        <tr>
          <th>제목</th>
          <th>내용</th>
          <th>등록일</th>
        </tr>
        </thead>
        <tbody>
          <tr>
            <td>관리자 공지사항 테스트1</td>
            <td>sdfasdfkjas;ldkfj;alskasdf;kjas;dlkfj;as</td>
            <td>2023-12-10</td>
          </tr>
          <tr>
            <td>관리자 공지사항 테스트2</td>
            <td>sdfasdfkjas;ldkfj;alskasdf;kjas;dlkfj;as</td>
            <td>2023-12-9</td>
          </tr>
          <tr>
            <td>관리자 공지사항 테스트3</td>
            <td>sdfasdfkjas;ldkfj;alskasdf;kjas;dlkfj;as</td>
            <td>2023-12-8</td>
          </tr>
          <tr>
            <td>관리자 공지사항 테스트4</td>
            <td>sdfasdfkjas;ldkfj;alskasdf;kjas;dlkfj;as</td>
            <td>2023-12-8</td>
          </tr>
          <tr>
            <td>관리자 공지사항 테스트5</td>
            <td>sdfasdfkjas;ldkfj;alskasdf;kjas;dlkㅁㄴㅇㅁㄴㅇㄹfj;as</td>
            <td>2023-12-7</td>
          </tr>
          <tr>
            <td>관리자 공지사항 테스트1</td>
            <td>sdfasdfkjas;ldkfj;alskasdf;kjas;dlkfj;as</td>
            <td>2023-12-6</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>

<script>

let msg = "${param.msg}";
if (msg != "") alert("원장님만 접근 가능한 페이지 입니다.");

  function toggleBoxContent(element) {
    var boxContent = element.nextElementSibling;
    var arrow = element.querySelector('.arrow');
    if (window.getComputedStyle(boxContent).display === 'none' || window.getComputedStyle(boxContent).display === '') {
      boxContent.style.display = 'block';
      arrow.classList.remove('up');
    } else {
      boxContent.style.display = 'none';
      arrow.classList.add('up');
    }
  }

  /////로그인 os 통계 그래프

  let loginData = [
    { os: "Windows", logins: 200 },
    { os: "macOS", logins: 150 },
    { os: "Linux", logins: 90 },
    { os: "Ubuntu", logins: 60 },
    { os: "Fedora", logins: 40 }
  ];

  let color = d3.scaleOrdinal()
          .domain(loginData.map(d => d.os))
          .range(["#1f77b4", "#ff7f0e", "#2ca02c", "#d62728", "#9467bd"]);

  let pieChart = d3.pie()
          .value(d => d.logins);
  let yourPie = pieChart(loginData);

  // 아크 생성
  let newArc = d3.arc()
          .innerRadius(0)
          .outerRadius(145);

  // SVG 생성
  let svg = d3.select("#osChart").append("svg")
          .attr("width", 300)
          .attr("height", 300);

  let g = svg.append("g")
          .attr("transform", "translate(150,150)");

  // 조각 추가
  g.selectAll("path")
          .data(yourPie)
          .enter()
          .append("path")
          .attr("d", newArc)
          .style("fill", d => color(d.data.os))
          .style("opacity", .7)
          .style("stroke", "#182566")
          .style("stroke-width", "2px");

  // 레이블 추가
  let labelArc = d3.arc()
          .innerRadius(100)
          .outerRadius(145);


  g.selectAll("text")
          .data(yourPie)
          .enter()
          .append("text")
          .attr("transform", d => `translate(\${labelArc.centroid(d)})`)
          .attr("dy", "0.35em")
          .style("text-anchor", "middle")
          .text(d => d.data.os);


  ///////////////////////////////
  //방문자 통계 그래프 그리기

  let visitorsData = [
    { day: "2023-09-01", visitors: 120 },
    { day: "2023-09-02", visitors: 200 },
    { day: "2023-09-03", visitors: 150 },
    { day: "2023-09-04", visitors: 350 },
    { day: "2023-09-05", visitors: 300 },
    { day: "2023-09-06", visitors: 250 },
    { day: "2023-09-07", visitors: 400 }
  ];

  // 날짜 포맷 파서
  let parseDate = d3.timeParse("%Y-%m-%d");

  // 데이터 포맷 적용
  visitorsData.forEach(function (d) {
    d.day = parseDate(d.day);
  });


  // 라인 제너레이터
  var todayVisitors = d3.line()
          .x(function (d) {
            return xScale(d.day);
          })
          .y(function (d) {
            return yScale(d.visitors);
          });

  // 스케일 설정
  let xScale = d3.scaleTime()
          .domain(d3.extent(visitorsData, d => d.day)) // 데이터의 최소, 최대 날짜
          .range([0, 650]); // SVG의 너비

  let yScale = d3.scaleLinear()
          .domain([0, d3.max(visitorsData, d => d.visitors)]) // 0부터 최대 방문자 수
          .range([300, 0]); // SVG의 높이


  // 축 생성
  let xAxis = d3.axisBottom(xScale);
  let yAxis = d3.axisLeft(yScale);

  // SVG 요소 생성
  svg = d3.select("#visitorsChart").append("svg")
          .attr("width", 700)
          .attr("height", 400);

  // X축 추가
  svg.append("g")
          .attr("class", "x axis")
          .attr("transform", "translate(50,250)") // X축 위치 조정
          .call(xAxis);

  // Y축 추가
  svg.append("g")
          .attr("class", "y axis")
          .attr("transform", "translate(50,-50)") // Y축 위치 조정
          .call(yAxis);

  // 라인 차트 경로 추가
  svg.append("path")
          .datum(visitorsData) // todayVisitors에 데이터 연결
          .attr("d", todayVisitors)
          .attr("transform", "translate(50,40)") // 라인 차트 위치 조정
          .attr("fill", "none")
          .attr("stroke", "darkred")
          .attr("stroke-width", 2);
/////////////////////////////////////////////////

  // 데이터 설정
  var data = [
    { name: "정석코딩", value: 100 },
    { name: "부트캠프", value: 80 },
    { name: "남궁성", value: 70 },
    { name: "java", value: 70 },
    { name: "SQL", value: 50 },
    { name: "SQL튜닝", value: 30 },
    { name: "JavaScript", value: 50 },
    { name: "스프링", value: 50 },
    { name: "웹개발", value: 20 },
    { name: "프로젝트", value: 40 },
    { name: "JPA", value: 10 },
    { name: "스프링부트", value: 10 },
    { name: "백엔드", value: 30 },
    { name: "리액트", value: 20 },
    { name: "정석코딩", value: 100 },
    { name: "부트캠프", value: 80 },
    { name: "남궁성", value: 70 },
    { name: "java", value: 70 },
    { name: "SQL", value: 50 },
    { name: "SQL튜닝", value: 30 },
    { name: "JavaScript", value: 50 },
    { name: "스프링", value: 50 },
    { name: "웹개발", value: 20 },
    { name: "프로젝트", value: 40 },
    { name: "JPA", value: 10 },
    { name: "스프링부트", value: 10 },
    { name: "백엔드", value: 30 },
    { name: "리액트", value: 20 }
  ];

  var svgWidth = 400, svgHeight = 300;

  // SVG 요소 생성
  var svgBubble = d3.select("#search").append("svg")
          .attr("width", svgWidth)
          .attr("height", svgHeight)
          .attr("class", "bubble");

  // 색상 스케일 설정
  var colorBubble = d3.scaleOrdinal(d3.schemeCategory10);

  // 버블 레이아웃 설정
  var bubble = d3.pack()
          .size([svgWidth, svgHeight])
          .padding(5);

  // 데이터를 계층 구조로 변환
  var root = d3.hierarchy({ children: data })
          .sum(function (d) { return d.value; });

  // 버블 노드 계산
  bubble(root);

  // 버블 생성
  var bubbles = svgBubble.selectAll(".bubble")
          .data(root.children)
          .enter().append("g")
          .attr("transform", function (d) {
            return "translate(" + d.x + "," + d.y + ")";
          });

  bubbles.append("circle")
          .attr("r", function (d) { return d.r; })
          .style("fill", function (d) { return colorBubble(d.data.name); });

  bubbles.append("text")
          .attr("dy", ".3em")
          .style("text-anchor", "middle")
          .text(function (d) { return d.data.name; });



</script>

</body>

</html>