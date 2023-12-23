
window.onload=function (){
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
    });


    new Chart(document.getElementById("bar-chart"), {
        type: 'bar',
        data: {
            labels: ["전체 회원", "학생", "강사", "관리자"],
            datasets: [
                {
                    label: "Population (millions)",
                    backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9"],
                    data: [2478,5267,734,784]
                }
            ]
        },
        options: {
            legend: { display: false },
            title: {
                display: true,
                text: '회원 현황'
            }
        }
    });


    new Chart(document.getElementById("pie-chart"), {
        type: 'pie',
        data: {
            labels: ["진행중인 부트캠프", "진행중인 세미나", "진행 예정 부트캠프", "진행 예정 세미나", "종료 강의"],
            datasets: [{
                label: "Population (millions)",
                backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
                data: [2478,5267,734,784,433]
            }]
        },
        options: {
            title: {
                display: true,
                text: '강의 현황'
            }
        }
    });



    new Chart(document.getElementById("bar-chart-horizontal"), {
        type: 'horizontalBar',
        data: {
            labels: ["부트캠프", "세미나", "결제 및 환불", "사이트 이용", "학원 관련", "기타"],
            datasets: [
                {
                    label: "Population (millions)",
                    backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850", "#fff000"],
                    data: [2478,5267,734,784,433,500]
                }
            ]
        },
        options: {
            legend: { display: false },
            title: {
                display: true,
                text: 'qna (전체) 게시글 분류'
            }
        }
    });



}
