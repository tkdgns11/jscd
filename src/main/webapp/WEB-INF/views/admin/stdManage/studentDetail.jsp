<%--
  Created by IntelliJ IDEA.
  User: sanghoon
  Date: 2023/12/08
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../admin/adminHeader.jsp"/>

<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <script src="https://d3js.org/d3.v7.min.js"></script>
  <style>
    html,
    body {
      height: 100%;
      width: 100%;
      margin: 0;
      padding: 0;

    }

    #warp2 {
      width: 100%;
      height: 40%;
      display: flex;
      flex-direction: row;
      justify-content: center;
      flex-wrap: nowrap;
      margin-top: 1%;
    }

    #warp1 {
      width: 100%;
      height: 60%;
      display: flex;
      flex-direction: row;
      justify-content: center;
      flex-wrap: nowrap;
      margin-top: 1%;
    }


    #profileImg {
      overflow: hidden;
      width: 30%;
      height: 100%;
      border: 2px solid #182566;
      border-radius: 10px;
      margin-left: auto;
      margin-right: auto;
      margin: 1%;
      position: relative;
      margin: 1%;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.5);
    }

    #examRecord {
      margin: 1%;
      overflow: hidden;
      width: 80%;
      height: 100%;
      border: 2px solid #182566;
      border-radius: 10px;
      margin-left: auto;
      margin-right: auto;
      position: relative;
      margin: 1%;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.5);

    }

    #search {
      overflow: hidden;
      width: 80%;
      height: 80%;
      border: 2px solid #182566;
      border-radius: 10px;
      margin-left: auto;
      margin-right: auto;
      position: relative;
      margin: 1%;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.5);

    }

    #board {
      overflow: hidden;
      width: 90%;
      height: 80%;
      border: 2px solid #182566;
      border-radius: 10px;
      margin-left: auto;
      margin-right: auto;
      position: relative;
      margin: 1%;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.5);

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

    #searchArrow {
      border-color: transparent transparent #182566 transparent;

    }

    .arrow.up {
      transform: translateY(-50%) rotate(180deg);
    }

    body {
      font-family: "Lato", sans-serif;
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

    #whole {
      padding-top: 50px;
      width: 88%;
      height: 100%;
      float: right;
    }

    .category-box {
      display: flex;
      height: 250px;
    }

    .category-box .category {
      flex: 1;
      border: 1px solid #ccc;
      padding: 10px;
      margin-right: 10px;
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

    #student_name {
      text-align: center;
      margin: 0.5%;
      font-weight: bold; /* 굵은 글씨 */
    }

    #student_img {
      display: flex;
      flex-direction: column;
      justify-content: center; /* 가로 중앙 정렬 */
      align-items: center; /* 세로 중앙 정렬 */
    }

    #img_area {
      width: 80%;
      height: 80%;
    }
  </style>
  <script src="https://kit.fontawesome.com/d47308ea25.js" crossorigin="anonymous"></script>
</head>

<body>
<div class="sidenav">
  <div class="box">
    <div class="box-header" onclick="toggleBoxContent(this)">
      <a href="#contact"><i class="fa-solid fa-user-graduate"></i>사이트 통계</a>
    </div>
  </div>
  <div class="box">
    <div class="box-header" onclick="toggleBoxContent(this)">
      <a href="#about"><i class="fa-solid fa-user"></i> My page</a>
      <span class="arrow up"></span>
    </div>
    <div class="box-content">
      <a href="#"></a>
    </div>
  </div>
  <div class="box">
    <div class="box-header" onclick="toggleBoxContent(this)">
      <a href="#about"><i class="fa-solid fa-circle-user"></i> 학사관리</a>
      <span class="arrow up"></span>
    </div>
    <div class="box-content">
      <a href="#">학생관리</a>
      <a href="#">성적관리</a>
      <a href="#">출결관리</a>
      <a href="#">강사관리</a>
      <a href="#">회원관리</a>
    </div>
  </div>
  <div class="box">
    <div class="box-header" onclick="toggleBoxContent(this)">
      <a href="#services"><i class="fa-solid fa-synagogue"></i> 교육등록</a>
      <span class="arrow up"></span>
    </div>
    <div class="box-content">
      <a href="#">부트캠프</a>
      <a href="#">세미나</a>
    </div>
  </div>
  <div class="box">
    <div class="box-header" onclick="toggleBoxContent(this)">
      <a href="#clients"><i class="fa-solid fa-users"></i> 커뮤니티</a>
      <span class="arrow up"></span>
    </div>
    <div class="box-content">
      <a href="#">전체공지</a>
      <a href="#">학생공지</a>
      <a href="#">FAQ</a>
    </div>
  </div>
  <div class="box">
    <div class="box-header" onclick="toggleBoxContent(this)">
      <a href="#contact"><i class="fa-solid fa-city"></i> 시설물</a>
      <span class="arrow up"></span>
    </div>
    <div class="box-content">
      <a href="#">강의실</a>
      <a href="#">사물함</a>
    </div>
  </div>
</div>
<div id="whole">
  <div id="warp2">
            <span id="profileImg" class="layer2">
                <div id="student_img">
                  <h3 id="student_name">이름 : 아톰</h3>
                    <hr>
                    <img id="img_area" src="../img/memberProfile/aaa4.jpeg" alt="profile_img">
                </div>
            </span>
    <span id="examRecord" class="layer2"></span>
  </div>
  <div id="warp1">
    <span id="search" class="layer1"></span>
    <span id="board" class="layer1"></span>
  </div>
</div>

<script>

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

  /* When the user clicks on the button,
  toggle between hiding and showing the dropdown content */
  function searchOptionSpread() {
    document.getElementById("searchOption").classList.toggle("show");
  }

  // Close the dropdown if the user clicks outside of it
  window.onclick = function (event) {
    if (!event.target.matches('.dropbtn')) {
      var dropdowns = document.getElementsByClassName("dropdown-content");
      var i;
      for (i = 0; i < dropdowns.length; i++) {
        var openDropdown = dropdowns[i];
        if (openDropdown.classList.contains('show')) {
          openDropdown.classList.remove('show');
        }
      }
    }
  }

  // 1. 데이터 준비
  var examDataSet = [
    [1, 40],
    [2, 50],
    [3, 50],
    [4, 95],
    [5, 65],
    [6, 70],
    [7, 85],
    [8, 90],
    [9, 95],
    [10, 100],
    [11, 40],
    [12, 50],
    [13, 50],
    [14, 95],
    [15, 65],
    [16, 70],
    [17, 85],
    [18, 90],
    [19, 95],
    [20, 100]
  ];

  var width = 1000; // 그래프 넓이
  var height = 350; // 그래프 높이
  var margin = { "top": 30, "bottom": 60, "right": 30, "left": 60 };

  // 2. SVG 영역 설정
  var svg = d3.select("#examRecord").append("svg").attr("width", width).attr("height", height);

  // 3. 축 스케일(눈금) 설정
  var xScale = d3.scaleLinear()
          .domain([0, d3.max(examDataSet, function (d) { return d[0]; })])
          .range([margin.left, width - margin.right]);

  var yScale = d3.scaleLinear()
          .domain([0, d3.max(examDataSet, function (d) { return d[1]; })])
          .range([height - margin.bottom, margin.top]);

  // 4. 축 표시
  var axisx = d3.axisBottom(xScale).ticks(5);
  var axisy = d3.axisLeft(yScale).ticks(5);

  svg.append("g")
          .attr("transform", "translate(" + 0 + "," + (height - margin.bottom) + ")")
          .call(axisx)
          .append("text")
          .attr("fill", "black")
          .attr("x", (width - margin.left - margin.right) / 2 + margin.left)
          .attr("y", 35)
          .attr("text-anchor", "middle")
          .attr("font-size", "10pt")
          .attr("font-weight", "bold")
          .text("시험(회차)");

  svg.append("g")
          .attr("transform", "translate(" + margin.left + "," + 0 + ")")
          .call(axisy)
          .append("text")
          .attr("fill", "black")
          .attr("text-anchor", "middle")
          .attr("x", -(height - margin.top - margin.bottom) / 2 - margin.top)
          .attr("y", -35)
          .attr("transform", "rotate(-90)")
          .attr("font-weight", "bold")
          .attr("font-size", "10pt")
          .text("점수");

  // 5. 라인 표시
  svg.append("path")
          .datum(examDataSet)
          .attr("fill", "none")
          .attr("stroke", "steelblue")
          .attr("stroke-width", 3)
          .attr("d", d3.line()
                  .x(function (d) { return xScale(d[0]); })
                  .y(function (d) { return yScale(d[1]); }));

  /////// searchData


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
    { name: "리액트", value: 20 },
    // 추가 데이터...
  ];

  var svgWidth = 600, svgHeight = 400;

  // SVG 요소 생성
  var svg = d3.select("#search").append("svg")
          .attr("width", svgWidth)
          .attr("height", svgHeight)
          .attr("class", "bubble");

  // 색상 스케일 설정
  var color = d3.scaleOrdinal(d3.schemeCategory10);

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
  var bubbles = svg.selectAll(".bubble")
          .data(root.children)
          .enter().append("g")
          .attr("transform", function (d) {
            return "translate(" + d.x + "," + d.y + ")";
          });

  bubbles.append("circle")
          .attr("r", function (d) { return d.r; })
          .style("fill", function (d) { return color(d.data.name); });

  bubbles.append("text")
          .attr("dy", ".3em")
          .style("text-anchor", "middle")
          .text(function (d) { return d.data.name; });

</script>

</body>

</html>