
window.onload=function (){

    let memberStatusElements = document.querySelectorAll('.memberStatus');
    let memberStatusArr=[];
    for (let i = 0; i < memberStatusElements.length; i++) {
        memberStatusArr.push(memberStatusElements[i].value);
        console.log(memberStatusArr[i]);
    }


    const memberStatuslabels = ["회원", "학생", "강사", "관리자","최고관리자","전체"];
    const memberStatusdata = {
        labels : memberStatuslabels,
        datasets: [
            {
                label: "# of Votes",
                data: [],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(255, 159, 64, 0.2)',
                    'rgba(255, 205, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(201, 203, 207, 0.2)'
                ],
                borderColor: [
                    'rgb(255, 99, 132)',
                    'rgb(255, 159, 64)',
                    'rgb(255, 205, 86)',
                    'rgb(75, 192, 192)',
                    'rgb(54, 162, 235)',
                    'rgb(153, 102, 255)',
                    'rgb(201, 203, 207)'
                ],
                borderWidth: 1
            }]
    }

    for (let i = 0; i < memberStatusElements.length; i++) {
        memberStatusdata.datasets[0].data.push(memberStatusArr[i]); // 데이터를 배열에 추가
    }


    new Chart(document.getElementById("bar-chart"), {
        type: 'bar',
        data: memberStatusdata,
        options: {
            legend: { display: false },
            title: {
                display: true,
                text: '회원 현황'
            },
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    }); //회원현황 끝



    new Chart(document.getElementById("line-chart"), {
        type: 'line',
        data: {
            labels: [1500,1600,1700,1750,1800,1850,1900,1950,1999,2050],
            datasets: [{
                data: [86,114,106,106,107,111,133,221,783,2478],
                label: "부트캠프 매출",
                borderColor: "#3e95cd",
                fill: false
            }, {
                data: [282,350,411,502,635,809,947,1402,3700,5267],
                label: "세미나 매출",
                borderColor: "#8e5ea2",
                fill: false
            }
            // , {
            //     data: [168,170,178,190,203,276,408,547,675,734],
            //     label: "학생",
            //     borderColor: "#3cba9f",
            //     fill: false
            // }, {
            //     data: [40,20,10,16,24,38,74,167,508,784],
            //     label: "강사",
            //     borderColor: "#e8c3b9",
            //     fill: false
            // }, {
            //     data: [6,3,2,2,7,26,82,172,312,433],
            //     label: "North America",
            //     borderColor: "#c45850",
            //     fill: false
            // }
            ]
        },
        options: {
            title: {
                display: true,
                text: '학원 매출'
            }
        }
    }); //학원 매출 현황 끝

    let lstRegistStatusElements = document.querySelectorAll('.lstRegistStatus');
    let lstRegistStatusArr=[];
    for (let i = 0; i < lstRegistStatusElements.length; i++) {
        lstRegistStatusArr.push(lstRegistStatusElements[i].value);
        console.log(lstRegistStatusArr[i]);
    }

    const lstRegistStatuslabels = ["진행 중 부트캠프", "진행 예정 부트캠프", "종료 부트캠프","전체 부트캠프", "진행 중 세미나", "진행 예정 세미나", "종료 세미나", "전체 세미나"];
    const lstRegistStatusdata = {
        labels : lstRegistStatuslabels,
        datasets: [
            {
                label: "# of Votes",
                data: [],
                backgroundColor: [
                    'rgb(255, 51, 51)',
                    'rgb(255, 153, 153)',
                    'rgb(255, 204, 51)',
                    'rgb(255, 153, 00)',
                    'rgb(75, 192, 192)',
                    'rgb(54, 162, 235)',
                    'rgb(000, 51, 255)',
                    'rgb(153, 102, 255)',

                ],
                borderWidth: 1
            }]
    }

    for (let i = 0; i < lstRegistStatusElements.length; i++) {
        lstRegistStatusdata.datasets[0].data.push(lstRegistStatusArr[i]); // 데이터를 배열에 추가
    }


    new Chart(document.getElementById("pie-chart"), {
        type: 'pie',
        data: lstRegistStatusdata,
        options: {
            title: {
                display: true,
                text: '강의 현황'
            }
        }
    }); //강의 현황 끝


    let qnaCategoryStatusElements = document.querySelectorAll('.qnaCategoryStatus');
    let qnaCategoryStatusArr=[];
    for (let i = 0; i < qnaCategoryStatusElements.length; i++) {
        qnaCategoryStatusArr.push(qnaCategoryStatusElements[i].value);
        console.log(qnaCategoryStatusArr[i]);
    }

    const qnaCategoryStatuslabels = ["부트캠프", "세미나", "결제 및 환불", "사이트 이용", "학원 관련", "기타"];
    const qnaCategoryStatusdata = {
        labels : qnaCategoryStatuslabels,
        datasets: [
            {
                label: "category",
                data: [],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(255, 159, 64, 0.2)',
                    'rgba(255, 205, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(201, 203, 207, 0.2)'
                ],
                borderColor: [
                    'rgb(255, 99, 132)',
                    'rgb(255, 159, 64)',
                    'rgb(255, 205, 86)',
                    'rgb(75, 192, 192)',
                    'rgb(54, 162, 235)',
                    'rgb(153, 102, 255)',
                    'rgb(201, 203, 207)'
                ],
                borderWidth: 1
            }]
    }

    for (let i = 0; i < qnaCategoryStatusElements.length; i++) {
        qnaCategoryStatusdata.datasets[0].data.push(qnaCategoryStatusArr[i]); // 데이터를 배열에 추가
    }


    new Chart(document.getElementById("bar-chart-horizontal"), {
        type: 'horizontalBar',
        data: qnaCategoryStatusdata,
        options: {
            title: {
                display: true,
                text: 'qna (전체) 게시글 분류'
            },
            scales: {
                xAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    }); //'qna (전체) 게시글 분류' 끝

    function Clock() {
        var date = new Date();
        var YYYY = String(date.getFullYear());
        var MM = String(date.getMonth() + 1);
        var DD = Zero(date.getDate());
        var hh = Zero(date.getHours());
        var mm = Zero(date.getMinutes());
        var ss = Zero(date.getSeconds());
        var Week = Weekday();

        Write(YYYY, MM, DD, hh, mm, ss, Week);
        //시계에 1의자리수가 나올때 0을 넣어주는 함수 (ex : 1초 -> 01초)

        function Zero(num) {
            return (num < 10 ? '0' + num : '' + num);
        }

        //요일을 추가해주는 함수
        function Weekday() {
            var Week = ['일', '월', '화', '수', '목', '금', '토'];
            var Weekday = date.getDay();
            return Week[Weekday];
        }


        //시계부분을 써주는 함수
        function Write(YYYY, MM, DD, hh, mm, ss, Week) {
            var Clockday = document.getElementById("Clockday");
            var Clock = document.getElementById("Clock");
            Clockday.innerText = YYYY + '/' + MM + '/' + DD + '(' + Week + ')';
            Clock.innerText = hh + ':' + mm + ':' + ss;
        }
    }

    setInterval(Clock, 1000); //1초(1000)마다 Clock함수를 재실행 한다


} //window.onload 끝
