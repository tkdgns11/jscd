<%--
  Created by IntelliJ IDEA.
  User: sanghoon
  Date: 2023/12/16
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    html,
    body {
      height: 100%;
      width: 100%;
      padding: 0;
    }

    body {
      font-family: "Lato", sans-serif;
      background-color: #D9D9D9;
    }

    #whole {
      padding-top: 50px;
      width: 88%;
      height: 100%;
      float: right;
      background-color: #D9D9D9;
      position: relative;
      display: flex;
    }

    #warp1 {
      margin: 0;
      width: 75%;
      height: 100%;
    }

    #warp1-layer3 {
      overflow: hidden;
      /*margin: 1rem;*/
      margin-top: 1rem;
      margin-left: 1rem;
      margin-bottom: 1rem;
      width: calc(100% - 2rem);
      height: 40%;
    }

    #warp1-layer3Area {
      margin-left: 1rem;
      margin-right: 1rem;
      padding-right: 2rem;
      width: calc(100% - 1rem);
      height: 100%;
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.1);
      display: flex;
      flex-direction: column;
    }

    .layer3s {
      display: flex;
      flex-direction: row;
      justify-content: space-around;
      flex-wrap: nowrap;
      /*align-items: center;*/
      width: 100%;
      height: 50%;
    }

    .layer3FirstRow {
      margin-bottom: 1rem;
    }

    .layer3Elements {
      width: calc(50% - 0.5rem);
      height: 100%;
      background-color: white;
    }

    .layer3FirstColum {
      margin-right: 1rem;
    }

    .titleArea {
      margin-top: 1rem;
      margin-left: 2rem;
      margin-bottom: 1rem;
      display: flex;
      flex-direction: row;
      justify-content: flex-start;
      align-items: center;
    }

    .title {
      margin-top: 1rem;
      height: 100%;
      font-size: 1.5rem;
      font-weight: 500;
      text-align: center;
      line-height: 100%;
    }

    /*#todoAll {*/
    /*    margin-left: 1rem;*/
    /*    margin-top: 1rem;*/
    /*    border-radius: 0.7rem;*/
    /*    background-color: #FF4646;*/
    /*    border: none;*/
    /*    color: white;*/
    /*    width: 3rem;*/
    /*    height: 100%;*/
    /*    font-size: 1.5rem;*/
    /*    font-weight: 500;*/
    /*    padding: 0.25rem;*/
    /*    text-align: center;*/
    /*    line-height: 100%;*/
    /*}*/

    /*#todoAll:hover {*/
    /*    cursor: default;*/
    /*}*/

    hr {
      border: none;
      height: 0.5px;
      background-color: #000;
    }

    .todolistDetail {
      width: 100%;
      height: 70%;
      display: flex;
      flex-direction: column;
      padding-bottom: 2rem;
      margin-left: 1rem;
    }

    .todolists {
      display: flex;
      flex-direction: row;
      flex-warp: nowarp;
      justify-content: flex-start;
      align-items: center;
      margin-top: 1rem;
    }

    .todolistTitle {
      width: 16%;
      height: 50%;
      font-size: 1.2rem;
      font-weight: 500;
      text-align: center;
      line-height: 100%;
      /*margin-left: 1rem;*/
      display: flex;
      flex-wrap: nowrap;
      justify-content: center;
      align-items: center;
    }

    /*.forFlexUp {*/
    /*    flex:1.1*/
    /*}*/

    .row2 {
      margin-left: 1rem;
    }

    .todolistNum {
      color: #FF4646;
    }

    .warp1-layer21 {
      overflow: hidden;
      width: calc(100% - 2rem);
      height: 50%;
      display: flex;
      flex-direction: row;
      flex-warp: nowrap;
      justify-content: space-between;
      align-items: center;
      margin: 1rem;
    }

    #visitStatusArea {
      justify-content: space-between;
    }

    #visitCountGraph {

    }

    #visitCircleArea {
      height: 100%;
      margin-right: 2rem;
      display: flex;
      align-items: center;
    }

    ul {
      height: 100%;
      list-style-type: none;
      padding: 0;
      display: flex;
      align-items: center;
      margin: 0; /* ul의 기본 마진 제거 */
    }

    li {
      height: 100%;
      font-size: 1rem;
      margin-right: 1rem; /* 리스트 아이템 간의 간격 조정 */
      display: flex; /* Flexbox를 활성화 */
      align-items: center; /* 여기에도 수직 중앙 정렬을 적용 */
    }

    .circle {
      width: 1.5rem; /* 원의 너비 */
      height: 1.5rem; /* 원의 높이 */
      border-radius: 50%; /* 원 모양 만들기 */
      display: inline-block; /* 인라인 블록 요소로 표시 */
      margin-right: 0.5rem; /* 원과 텍스트 사이 간격 조정 */
    }


    .visitGraphList {
      margin-right: 1rem;
    }

    #visitorUl {
      background-color: #FFD1B7;
    }

    #viewUl {
      background-color: #FF7878;
    }

    #visitorGraphWarp {
      width: 100%;
      height: 80%;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    #daySummaryArea {
      justify-content: space-between;
    }

    #monthSummary {
      margin-right: 2rem;
    }

    .warp1-layers {
      width: 50%;
      height: 100%;
      background-color: white;
      box-shadow: 0 0.5rem 0.5rem 0 rgba(0, 0, 0, 0.1); /* x축 오프셋, y축 오프셋, 퍼짐 반경, 색상 */
      /*margin: 1rem; !* 여백을 동일하게 설정 *!*/
      margin-top: 1rem;
      margin-left: 1rem;
      margin-bottom: 1rem;
      overflow: hidden;
    }

    #tableArea {
      height: 100%;
      width: 100%;
      display: flex;
      flex-direction: column;
      overflow: hidden;
    }

    .tableRows {
      display: flex;
      flex-direction: row;
      justify-content: space-around;
      align-items: center;
      width: 100%;
      padding: 0.5rem;
      border-bottom: 0.5px solid #000;
    }

    /*.tableRows:last-child {*/
    /*    padding-top: 0.625rem;*/
    /*    padding-bottom: 0.625rem;*/
    /*}*/

    #lastRowElement2 {
      padding-top: 0.625rem;
      padding-bottom: 0.625rem;
    }

    #lastRowElement {
      border-bottom: none;
      padding-top: 0.625rem;
      padding-bottom: 0.75rem;
    }

    .tableBodyRows:hover {
      background-color: #FFE6E6;
    }

    .tableElement {
      font-size: 1rem;
      flex: 1; /* flex 속성을 사용하여 너비를 균등하게 분배 */
      text-align: center;
      padding: 0.25rem;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
    }


    .dayElement {
      flex: 2;
    }

    .revenueElement {
      flex: 1.5;
    }

    .layer1reset {
      margin-bottom: 3rem;
    }

    .boardContents {
      height: 80%;
      width: 100%;
      display: flex;
      flex-direction: column;
      overflow: hidden;
    }

    .boardContentsRows {
      flex: 1; /* flex 속성을 사용하여 너비를 균등하게 분배 */
      display: flex;
      flex-direction: row;
      justify-content: flex-start;
      align-items: center;
      width: 100%;
      margin-left: 1rem;
      overflow: hidden;
    }

    .boardContentsArea {
      width: 100%;
      height: 90%;
      margin-left: 1rem;
      display: flex;
      flex-direction: column;
      justify-content: flex-start;
      overflow: hidden;
    }

    .boardImgArea {
      width: 20%;
      height: 90%;
      background-color: #FDD7A0;
      overflow: hidden;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .contentsTitle {
      width: 100%;
      height: 50%;
      display: flex;
      align-items: center;
      font-size: 1rem;
      line-height: 100%;
    }

    .boardImgArea img {
      width: 100%; /* 이미지 너비를 컨테이너에 맞춤 */
      height: 100%; /* 이미지 높이를 컨테이너에 맞춤 */
      object-fit: cover; /* 이미지가 비율을 유지하며 컨테이너를 채우도록 함 */
    }

    .circleImgArea {
      border-radius: 50%; /* 원형 모양 만들기 */
    }

    .contentsWriter {
      width: 100%;
      height: 50%;
      display: flex;
      align-items: center;
      font-size: 0.8rem;
      line-height: 100%;
    }

    #warp2 {
      width: 25%;
      height: 120%;
      float: right;
      margin-top: 1rem;
      margin-right: 2rem;
      display: flex;
      flex-direction: column;
    }

    #warp2-top {
      width: 100%;
      height: 60%;
      background-color: #323232;
      float: right;
      margin-bottom: 1rem;
      display: flex;
      flex-direction: column;
      box-shadow: 0 0.5rem 0.5rem 0 rgba(0, 0, 0, 0.1); /* x축 오프셋, y축 오프셋, 퍼짐 반경, 색상 */
    }

    #warp2-top-3 {
      width: 100%;
      height: 40%;
      display: flex;
      flex-direction: column;
    }

    #profileImgArea {
      width: 100%;
      height: 80%;
      display: flex;
      overflow: hidden;
      justify-content: center;
      align-items: center;
    }

    #adminProfileImg{
      width: 100%;
      height: 100%;
      object-fit: cover;
    }

    #profileImgCircle {
      width: 8.6rem;
      height: 8.6rem;
      overflow: hidden;
      background-color: #FDF5E6;
      border-radius: 50%; /* 원형 모양 만들기 */
      display: flex;
      justify-content: center;
      align-items: center;
    }

    #memberName {
      width: 100%;
      height: 10%;
      color: #dcdcdc;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    #memberId {
      width: 100%;
      height: 10%;
      color: #b4b4b4;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    #warp2-top-2 {
      width: 100%;
      height: 30%;
      border-bottom: 0.5px solid #828282;
    }

    #warp2-top-1 {
      width: 100%;
      height: 30%;
    }

    #warp2-2 {
      width: 100%;
      height: 17.5%;
      background-color: #32F1FF;
      float: right;
      margin-bottom: 1rem;
      box-shadow: 0 0.5rem 0.5rem 0 rgba(0, 0, 0, 0.1);
    }

    #warp2-3 {
      width: 100%;
      height: 17.5%;
      background-color: #FAFA96;
      margin-bottom: 1rem;
      float: right;
      box-shadow: 0 0.5rem 0.5rem 0 rgba(0, 0, 0, 0.1);
    }

    #warp2-4 {
      width: 100%;
      height: 17.5%;
      background-color: #FF96FF;
      margin-bottom: 1rem;
      float: right;
      box-shadow: 0 0.5rem 0.5rem 0 rgba(0, 0, 0, 0.1);
    }

    #warp2-5 {
      width: 100%;
      height: 17.5%;
      background-color: #B21EF1;
      margin-bottom: 1.2rem;
      float: right;
      box-shadow: 0 0.5rem 0.5rem 0 rgba(0, 0, 0, 0.1);
    }

    /*#visitorGraph {*/
    /*    overflow-x: auto;*/
    /*}*/

  </style>
  <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
  <script src="https://d3js.org/d3.v6.min.js"></script>
  <script src="https://kit.fontawesome.com/d47308ea25.js" crossorigin="anonymous"></script>
</head>

<body>
<header>
  <jsp:include page="adminHeader.jsp"/>
</header>

<div id="whole">

  <div id="warp1">
    <div id="warp1-layer3">
      <div id="warp1-layer3Area">
        <div class="layer3s layer3FirstRow">
          <div class = "layer3Elements layer3FirstColum">
            <div class="titleArea">
              <div class="title">진행중 과정 현황</div>
            </div>
            <hr>
            <div class="todolistDetail">
              <div class="todolists">
                <div class="todolistTitle">전체 <span class="todolistNum">${lstregist}</span></div>
                <div class="todolistTitle">부트캠프 <span class="todolistNum">${lstregistBT}</span></div>
                <div class="todolistTitle">세미나 <span class="todolistNum">${lstregistSM}</span></div>
              </div>
            </div>
          </div>
          <div class = "layer3Elements">
            <div class="titleArea">
              <div class="title">회원 현황</div>
            </div>
            <hr>
            <div class="todolistDetail">
              <div class="todolists">
                <div class="todolistTitle">일반 <span class="todolistNum">${member}</span></div>
                <div class="todolistTitle">학생 <span class="todolistNum">${student}</span></div>
                <div class="todolistTitle">관리자 <span class="todolistNum">${admin}</span></div>
              </div>
            </div>
          </div>
        </div>
        <div class="layer3s">
          <div class = "layer3Elements layer3FirstColum">
            <div class="titleArea">
              <div class="title">부트캠프 신청 현황</div>
            </div>
            <hr>
            <div class="todolistDetail">
              <div class="todolists row2">
                <div class="todolistTitle">승인대기 <span class="todolistNum">${btWaitingNum}</span></div>
                <div class="todolistTitle">승인 <span class="todolistNum">${btApprovalNum}</span></div>
                <div class="todolistTitle">미승인 <span class="todolistNum">${btNotApprovalNum}</span></div>
                <div class="todolistTitle forFlexUp">결제대기 <span class="todolistNum">${btWaitPayNum}</span></div>
                <div class="todolistTitle">등록 <span class="todolistNum">${btRegistNum}</span></div>
              </div>
            </div>
          </div>
          <div class = "layer3Elements">
            <div class="titleArea">
              <div class="title">세미나 신청 현황</div>
            </div>
            <hr>
            <div class="todolistDetail">
              <div class="todolists row2">
                <div class="todolistTitle forFlexUp">결제대기 <span class="todolistNum">${smWaitPayNum}</span></div>
                <div class="todolistTitle">등록 <span class="todolistNum">${smRegistNum}</span></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="warp1-layer21">
      <div class="warp1-layers" id="visitCountGraph">
        <div class="titleArea" id="visitStatusArea">
          <div class="title">방문자 현황</div>
          <span id="visitCircleArea"><ul><li class="visitGraphList"><span class="circle"
                                                                          id="visitorUl"></span> 페이지뷰</li><li
                  class="visitGraphList"><span
                  class="circle" id="viewUl"></span> 방문자</li></ul></span>
        </div>
        <hr>
        <div id="visitorGraphWarp" style="overflow-x: auto; overflow-y: hidden;">
          <svg id="visitorGraph" width="500" height="400"></svg>
        </div>
      </div>
      <div class="warp1-layers" id="daySummary">
        <div class="titleArea" id="daySummaryArea">
          <div class="title">일자별 요약</div>
          <span id="monthSummary"></span>
        </div>
        <hr>
        <div id="tableArea">
          <div class="tableRows">
            <span class="tableElement dayElement">일자</span><span class="tableElement">주문수</span><span
                  class="tableElement revenueElement">매출액 <i class="fa-regular fa-circle-question"></i></span><span
                  class="tableElement">방문자</span><span class="tableElement">가입</span><span
                  class="tableElement">문의</span><span class="tableElement">후기</span>
          </div>

          <div>
            <c:forEach var="dailySummary" items="${dailySummaryDtoList}">
              <div class="tableRows tableBodyRows">
                <span class="tableElement dayElement">${dailySummary.date}</span>
                <span class="tableElement">${dailySummary.orders}</span>
                <span class="tableElement revenueElement">${dailySummary.revenue}원</span>
                <span class="tableElement">${dailySummary.visitors}</span>
                <span class="tableElement">${dailySummary.signups}</span>
                <span class="tableElement">${dailySummary.inquiries}</span>
                <span class="tableElement">${dailySummary.reviews}</span>
              </div>
            </c:forEach>
          </div>
          <div class="tableRows tableBodyRows" id="lastRowElement2">
            <span class="tableElement dayElement">최근 7일 합계</span>
            <span class="tableElement">${weekData.weekOrders}건</span>
            <span class="tableElement revenueElement">${weekData.weekRevenue}원</span>
            <span class="tableElement">${weekData.weekVisitors}명</span>
            <span class="tableElement">${weekData.weekSignups}명</span>
            <span class="tableElement">${weekData.weekInquiries}</span>
            <span class="tableElement">${weekData.weekReviews}</span>
          </div>
          <div class="tableRows tableBodyRows" id="lastRowElement">
            <span class="tableElement dayElement">이번달 합계</span>
            <span class="tableElement">${monthData.monthOrders}건</span>
            <span class="tableElement revenueElement">${monthData.monthRevenue}원</span>
            <span class="tableElement">${monthData.monthVisitors}명</span>
            <span class="tableElement">${monthData.monthSignups}명</span>
            <span class="tableElement">${monthData.monthInquires}</span>
            <span class="tableElement">${monthData.monthReviews}</span>
          </div>
        </div>
      </div>
    </div>

    <div class="warp1-layer21">
      <div class="warp1-layers layer1reset">
        <div class="titleArea">
          <div class="title">Q&A 수강후기</div>
        </div>
        <hr>
        <div class="boardContents">
          <div class="boardContentsRows">
            <div class="boardImgArea">
              <img id="img_area" alt="board_img">
            </div>
            <div class="boardContentsArea">
              <div class="contentsTitle">[문의] 사이즈 조건표가 어떻게 되나요?</div>
              <div class="contentsWriter">Steve | 2023-12-18 19:00</div>
            </div>
          </div>
          <div class="boardContentsRows">
            <div class="boardImgArea">

            </div>
            <div class="boardContentsArea">
              <div class="contentsTitle">[구매평] 좋은 제품 감사합니다</div>
              <div class="contentsWriter">Tom | 2023-12-18 18:00</div>
            </div>
          </div>
          <div class="boardContentsRows">
            <div class="boardImgArea">

            </div>
            <div class="boardContentsArea">
              <div class="contentsTitle">[구매평] 좋은 제품 감사합니다.</div>
              <div class="contentsWriter">Merry | 2023-12-18 17:00</div>
            </div>
          </div>
          <div class="boardContentsRows">
            <div class="boardImgArea">

            </div>
            <div class="boardContentsArea">
              <div class="contentsTitle">[구매평] 좋은 제품 감사합니다.</div>
              <div class="contentsWriter">Merry | 2023-12-18 17:00</div>
            </div>
          </div>
        </div>
      </div>
      <div class="warp1-layers layer1reset">
        <div class="titleArea">
          <div class="title">공지사항</div>
        </div>
        <hr>
        <div class="boardContents">
          <div class="boardContentsRows">
            <div class="boardImgArea circleImgArea">

            </div>
            <div class="boardContentsArea">
              <div class="contentsTitle">[게시판 작성] 한파 배송안내</div>
              <div class="contentsWriter">Jessica | 2023-12-17 13:00</div>
            </div>
          </div>
          <div class="boardContentsRows">
            <div class="boardImgArea circleImgArea">

            </div>
            <div class="boardContentsArea">
              <div class="contentsTitle">[게시판 댓글] 좋은 이벤트 감사합니다!</div>
              <div class="contentsWriter">Steve | 2023-12-16 13:00</div>
            </div>
          </div>
          <div class="boardContentsRows">
            <div class="boardImgArea circleImgArea">

            </div>
            <div class="boardContentsArea">
              <div class="contentsTitle">[입력폼 참여] 사용자 조사</div>
              <div class="contentsWriter">Steve | 2023-12-15 13:00</div>
            </div>
          </div>
          <div class="boardContentsRows">
            <div class="boardImgArea circleImgArea">

            </div>
            <div class="boardContentsArea">
              <div class="contentsTitle">[입력폼 참여] 사용자 조사</div>
              <div class="contentsWriter">Steve | 2023-12-15 13:00</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div id="warp2">
    <div id="warp2-top">
      <div id="warp2-top-3">
        <div id="profileImgArea">
          <div id="profileImgCircle">
          </div>
        </div>
        <div id="memberName">steve</div>
        <div id="memberId">sanghoon@jungsuk.com</div>
      </div>
      <div id="warp2-top-2"></div>
      <div id="warp2-top-1"></div>
    </div>
    <div id="warp2-2"></div>
    <div id="warp2-3"></div>
    <div id="warp2-4"></div>
    <div id="warp2-5"></div>
  </div>
</div>
<script>

  window.onload = function () {

    // DailySummaryDto 리스트를 자바스크립트 객체 배열로 변환
    let dailySummaryData = [
      <c:forEach var="dailySummary" items="${dailySummaryDtoList}" varStatus="status">
      {
        date: '${dailySummary.date.substring(5)}',
        visitors: ${dailySummary.visitors},
        views: ${dailySummary.pageviews}
      }<c:if test="${!status.last}">, </c:if>
      </c:forEach>
    ];

    makeViewGraph();

    function makeViewGraph() {

      // 배열을 역순으로 정렬
      dailySummaryData.reverse();

      const svg = d3.select('\#visitorGraph');
      const margin = {top: 20, right: 20, bottom: 30, left: 50};
      const width = +svg.attr('width') - margin.left - margin.right;
      const height = +svg.attr('height') - margin.top - margin.bottom;
      const g = svg.append('g').attr('transform', `translate(\${margin.left},\${margin.top})`);

      const x = d3.scalePoint()
              .range([0, width])
              .domain(dailySummaryData.map(d => d.date));

      const yMax = Math.max(d3.max(dailySummaryData, d => d.visitors), d3.max(dailySummaryData, d => d.views));

      const y = d3.scaleLinear()
              .rangeRound([height, 0])
              .domain([0, yMax]);

      // 영역 함수 정의
      const areaVisitors = d3.area()
              .x(d => x(d.date))
              .y0(height)
              .y1(d => y(d.visitors));

      // 라인 함수 정의
      const areaViews = d3.area()
              .x(d => x(d.date))
              .y0(height)
              .y1(d => y(d.views));

      // x축 생성
      g.append('g')
              .attr('transform', `translate(0,\${height})`)
              .call(d3.axisBottom(x))
              .selectAll("text")
              .style('font-size', '1rem');

      //y축 생성
      g.append('g')
              .call(d3.axisLeft(y))
              .selectAll("text")
              .style('font-size', '1rem');

      // 페이지뷰 영역
      g.append('path')
              .datum(dailySummaryData)
              .attr('fill', '#FFF0F0')
              .attr('d', areaViews);

      // 방문자수 영역
      g.append('path')
              .datum(dailySummaryData)
              .attr('fill', '#FFDCDC')
              .attr('d', areaVisitors);

      // 페이지뷰 라인
      g.append('path')
              .datum(dailySummaryData)
              .attr('fill', 'none')
              .attr('stroke', '#FFD1B7')
              .attr('stroke-width', 1.5)
              .attr('d', d3.line()
                      .x(d => x(d.date))
                      .y(d => y(d.views))
              );

      // 방문자수 라인
      g.append('path')
              .datum(dailySummaryData)
              .attr('fill', 'none')
              .attr('stroke', '#FF7878')
              .attr('stroke-width', 1.5)
              .attr('d', d3.line()
                      .x(d => x(d.date))
                      .y(d => y(d.visitors))
              );

      // 페이지뷰 좌표
      g.selectAll(".circle-data2")
              .data(dailySummaryData)
              .enter().append("circle")
              .attr("class", "circle-data2")
              .attr("cx", d => x(d.date))
              .attr("cy", d => y(d.views))
              .attr("r", 4)
              .attr("fill", "#FFD1B7");

      //방문자수 좌표
      g.selectAll(".circle-data1")
              .data(dailySummaryData)
              .enter().append("circle")
              .attr("class", "circle-data1")
              .attr("cx", d => x(d.date))
              .attr("cy", d => y(d.visitors))
              .attr("r", 4)
              .attr("fill", "#FF7878");
    }

  }

</script>

</body>

</html>