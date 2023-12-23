window.onload = function () {

    const floor4 = document.getElementById("floor4"); //4층 버튼 요소 가져옴
    const floor5 = document.getElementById("floor5"); //5층 버튼 요소 가져옴
    const floor4locker = document.getElementById("floor4locker"); //4층 사물함 요소 가져옴
    const floor5locker = document.getElementById("floor5locker"); //4층 사물함 요소 가져옴
    const moveBtn = document.getElementById("moveBtn"); //자리이동 버튼 요소 가져옴
    const guideText = document.getElementById("guideText"); //자리이동 버튼 클릭될때 text들어갈 요소 가져옴
    const regBtn = document.getElementById("regBtn"); //자리등록 버튼 요소 가져옴
    const extdBtn = document.getElementById("extdBtn"); //기간연장 버튼 요소 가져옴
    const removeBtn = document.getElementById("removeBtn"); //자리삭제 버튼 요소 가져옴
    const lockerCollection4 = document.getElementsByClassName("locker"); // 4층락커 요소 전부 가져옴
    const lockerCollection5 = document.getElementsByClassName("locker5"); // 5층락커 요소 전부 가져옴
    let commentText; //코멘트 텍스트 요소
    let floorStatus = "floor4"; //화면 4층인지 5층인지
    let moveClick = 0; //자리이동버튼 선택됐는지 여부
    let regClick = 0; //자리등록버튼 선택됐는지 여부
    let extdClick = 0; //기간연장버튼 선택됐는지 여부
    let removeClick = 0; //자리삭제버튼 선택됐는지 여부
    let isFirstMoveChoice = 0; //자리옮기는 버튼 클릭됐을때 첫번째 락커 선택인지 여부
    let moveChoiceLocker = ["", ""]; //자리 옮기기에서 클릭된 요소 id담는 배열
    let moveClickedElement = []; //자리 옮기기에서 클릭된 요소를 담는 배열
    let choiceLocker = ""; //등록, 삭제, 기간연장할때 선택된 요소 id담는 변수
    let choiceElement; //등록, 삭제, 기간연장할때 선택된 요소 담는 변수
    let cancelBtn; //취소 버튼 요소 담는 변수
    let changeCommit; //커밋 버튼 요소 담는 변수
    let extdDays; //연장기간 담는 변수
    let forPtagString;
    let mebrID; //회원 ID 담는 변수
    let lockerID; //기존 락커id 담는 변수
    let lockerIdNew; //이동할 위치 락커 id 담는 변수
    let lockerCode; //락커 Code 담는 변수
    let lockerCodeNew; //이동할 위치 락커 Code 담는 변수
    let useDays; //사용기간 담는 변수
    let startDate; //서버로 전송할 Date타입
    let endDate; //서버로 전송할 Date타입

    function changeFloor(event) {
        if (floorStatus === event.target.id) return;

        else if (floorStatus === "floor4") {
            floor4locker.style.display = "none";
            floor5locker.style.display = "block";
            floorStatus = "floor5";
        } else {
            floor5locker.style.display = "none";
            floor4locker.style.display = "block";
            floorStatus = "floor4"
        }
    }

    function moveNo() {
        if (moveClick === 1) return;

        if (regClick === 1) {
            initial();
            regClick = 0;
        }

        if (removeClick === 1) {
            initial();
            removeClick = 0;
        }
        if (extdClick === 1) {
            initial();
            extdClick = 0;
        }
        moveClick = 1;
        guideText.innerHTML = "<p id='commentText'>이동할 자리를 선택해주세요!&nbsp;&nbsp;  위치를 &nbsp;&nbsp;&nbsp;  위치로&nbsp;&nbsp;</p><button class='changeCommit' id='moveTransfer'>옮기기</button><button class='changeCommit' id='cancelBtn'>취소</button>";
        commentText = document.getElementById("commentText");
        cancelBtn = document.getElementById("cancelBtn");
        cancelBtn.addEventListener("click", cancelClick);
        changeCommit = document.getElementById("moveTransfer");
        changeCommit.addEventListener("click", () => changeTransfer(changeCommit.id));
    }

    function regNo() {
        if (regClick === 1) return;
        if (moveClick === 1) {
            initial();
            isFirstMoveChoice = 0;
            moveClick = 0;
        }
        if (removeClick === 1) {
            initial();
            removeClick = 0;
        }
        if (extdClick === 1) {
            initial();
            extdClick = 0;
        }
        regClick = 1;
        guideText.innerHTML = "<p id='commentText'>등록할 자리를 선택해주세요! &nbsp;&nbsp; 자리로&nbsp;&nbsp;</p><button class='changeCommit' id='regTransfer' >등록하기</button><button class='changeCommit' id='cancelBtn'>취소</button>";
        commentText = document.getElementById("commentText");
        cancelBtn = document.getElementById("cancelBtn");
        cancelBtn.addEventListener("click", cancelClick);
        changeCommit = document.getElementById("regTransfer");
        changeCommit.addEventListener("click", () => changeTransfer(changeCommit.id));
    }

    function extdNo() {
        if (extdClick === 1) return;

        if (moveClick === 1) {
            initial();
            isFirstMoveChoice = 0;
            moveClick = 0;
        }
        if (removeClick === 1) {
            initial();
            removeClick = 0;
        }

        if (regClick === 1) {
            initial();
            regClick = 0;
        }

        extdClick = 1;
        guideText.innerHTML = "<p id='commentText'>연장할 자리를 선택해주세요! &nbsp;&nbsp; 자리를&nbsp;&nbsp;</p><button class='changeCommit' id='extdTransfer'>연장하기</button><button class='changeCommit' id='cancelBtn'>취소</button>";
        commentText = document.getElementById("commentText");
        cancelBtn = document.getElementById("cancelBtn");
        cancelBtn.addEventListener("click", cancelClick);
        changeCommit = document.getElementById("extdTransfer");
        changeCommit.addEventListener("click", () => changeTransfer(changeCommit.id));
    }

    function removeNo() {
        if (removeClick === 1) return;

        if (moveClick === 1) {
            initial();
            isFirstMoveChoice = 0;
            moveClick = 0;
        }
        if (regClick === 1) {
            initial();
            regClick = 0;
        }

        if (extdClick === 1) {
            initial();
            extdClick = 0;
        }
        removeClick = 1;
        guideText.innerHTML = "<p id='commentText'>삭제할 자리를 선택해주세요! &nbsp;&nbsp; 자리를&nbsp;&nbsp;</p><button class='changeCommit' id='removeTransfer'>삭제하기</button><button class='changeCommit' id='cancelBtn'>취소</button>";
        commentText = document.getElementById("commentText");
        cancelBtn = document.getElementById("cancelBtn");
        cancelBtn.addEventListener("click", cancelClick);
        changeCommit = document.getElementById("removeTransfer");
        changeCommit.addEventListener("click", () => changeTransfer(changeCommit.id));
    }

    //선택된 락커, 색깔 초기화 하는 함수
    function initial() {
        if (moveChoiceLocker[1] !== "") {
            moveClickedElement[1].style.backgroundColor = '';
        }

        if (moveChoiceLocker[0] !== "") {
            moveClickedElement[0].style.backgroundColor = '';
        }

        if (choiceLocker !== "") {
            choiceElement.style.backgroundColor = '';
        }

        moveChoiceLocker = ["", ""];
        moveClickedElement = [];
        choiceLocker = "";
        choiceElement = null;
    }

    function cancelClick() {
        guideText.innerHTML = "";
        initial();
        isFirstMoveChoice = 0;
        moveClick = 0;
        regClick = 0;
        removeClick = 0;
        extdClick = 0;

    }

    function lockerClick(id, event) {

        if (event.target.tagName === 'BUTTON') {
            return;
        }

        // alert("id 타입 = " + typeof(id));// string

        // 아무것도 클릭안하고 클릭한경우 그냥 return
        if (moveClick === 0 && regClick === 0 && removeClick === 0 && extdClick === 0) return;

        //이동 버튼 누르고 두번째 선택인데 같은 번호 클릭했을시
        if (moveClick === 1 && isFirstMoveChoice === 1 && id === moveChoiceLocker[0]) {
            isFirstMoveChoice = 0;
            moveChoiceLocker[0] = "";
            moveClickedElement[0].style.backgroundColor = '';
            moveClickedElement[0] = null;
            commentText.innerHTML = "이동할 자리를 선택해주세요!&nbsp;&nbsp; 위치를 &nbsp;&nbsp;&nbsp;  위치로&nbsp;&nbsp;";
            return;
        }

        //이동 버튼 누르고 두번째 카드랑 같은 세번째 클릭인경우
        if (moveClick === 1 && isFirstMoveChoice === 0 && id === moveChoiceLocker[1]) {
            isFirstMoveChoice = 1;
            moveChoiceLocker[1] = "";
            moveClickedElement[1].style.backgroundColor = '';
            moveClickedElement[1] = null;
            commentText.innerHTML = "이동할 자리를 선택해주세요!&nbsp;&nbsp; " + moveChoiceLocker[0] + "위치를 &nbsp;&nbsp;&nbsp;  위치로&nbsp;&nbsp;";
            return;
        }

        //이동 버튼 누르고 세번째 클릭인경우
        if (moveClick === 1 && isFirstMoveChoice === 0 && id === moveChoiceLocker[0] && moveChoiceLocker[1] !== "") {
            //alert("첫번째 카드랑 같은 세번째 카드입니다");
            //아무처리 없이 return
            return;
        }

        if (extdClick === 1 && id === choiceLocker) return;

        if (regClick === 1 && id === choiceLocker) return;

        if (removeClick === 1 && id === choiceLocker) return;

        if (event.target.classList.contains('locker') || event.target.classList.contains('locker5')) {
            event.currentTarget.style.backgroundColor = 'aqua';
        } else {
            event.target.parentElement.parentElement.style.backgroundColor = 'aqua';
        }

        if (moveClick === 1 && isFirstMoveChoice === 0) {

            if (document.getElementById(id.substring(0, 1) + "-" + id.substring(2)).innerText === "") {
                if (event.target.classList.contains('locker') || event.target.classList.contains('locker5')) {
                    event.currentTarget.style.backgroundColor = '';
                } else {
                    event.target.parentElement.parentElement.style.backgroundColor = '';
                }
                alert("빈 자리는 옮길 수 없습니다!");
                return;
            }
            //이전클릭 색깔 초기화
            if (moveChoiceLocker[0] !== "") {
                moveClickedElement[0].style.backgroundColor = '';
                moveClickedElement[1].style.backgroundColor = '';
            }

            moveChoiceLocker[0] = id;
            moveChoiceLocker[1] = "";
            isFirstMoveChoice = 1;
            moveClickedElement[0] = event.currentTarget;
            moveClickedElement[1] = null;
            commentText.innerHTML = "이동할 자리를 선택해주세요!&nbsp;&nbsp; " + id + "위치를 &nbsp;&nbsp;&nbsp;  위치로&nbsp;&nbsp;";
            return;
        } else if (moveClick === 1 && isFirstMoveChoice === 1) {
            // 사용중인 자리로는 못 옮기게 막음
            if (document.getElementById(id.substring(0, 1) + "-" + id.substring(2)).innerText !== "") {

                alert("사용중인 자리를 옮길 위치로 선택하는경우 두 자리의 위치가 서로 바뀝니다! \n 즉, " + moveChoiceLocker[0] + "위치와 " + id + "의 위치가 서로 바뀌게 됩니다.");
            }
            moveChoiceLocker[1] = id;
            moveClickedElement[1] = event.currentTarget;
            isFirstMoveChoice = 0;
            commentText.innerHTML = "이동할 자리를 선택해주세요!&nbsp;&nbsp; " + moveChoiceLocker[0] + "위치를 &nbsp;&nbsp;" + id + "위치로&nbsp;&nbsp;";
            return;
        } else if (extdClick === 1) {
            if (document.getElementById(id.substring(0, 1) + "-" + id.substring(2)).innerText === "") {

                //방금클릭한거 초기화
                if (event.target.classList.contains('locker') || event.target.classList.contains('locker5')) {
                    event.currentTarget.style.backgroundColor = '';
                } else {
                    event.target.parentElement.parentElement.style.backgroundColor = '';
                }
                alert("빈 자리는 연장 수 없습니다!");
                return;
            }

            if (choiceLocker !== "") choiceElement.style.backgroundColor = '';

            choiceLocker = id;
            choiceElement = event.currentTarget;
            commentText.innerHTML = "연장할 자리를 선택해주세요! &nbsp;&nbsp;" + id + "자리를&nbsp;&nbsp;";
            return;
        } else if (regClick === 1) {
            if (document.getElementById(id.substring(0, 1) + "-" + id.substring(2)).innerText !== "") {

                if (event.target.classList.contains('locker') || event.target.classList.contains('locker5')) {
                    event.currentTarget.style.backgroundColor = '';
                } else {
                    event.target.parentElement.parentElement.style.backgroundColor = '';
                }
                alert("이미 사용중인 자리는 등록할 수 없습니다!");

                return;
            }

            if (choiceLocker !== "") choiceElement.style.backgroundColor = '';

            choiceLocker = id;
            choiceElement = event.currentTarget;
            commentText.innerHTML = "등록할 자리를 선택해주세요! &nbsp;&nbsp;" + id + "자리로&nbsp;&nbsp;";
            return;

        } else if (removeClick === 1) {
            if (document.getElementById(id.substring(0, 1) + "-" + id.substring(2)).innerText === "") {

                if (event.target.classList.contains('locker') || event.target.classList.contains('locker5')) {
                    event.currentTarget.style.backgroundColor = '';
                } else {
                    event.target.parentElement.parentElement.style.backgroundColor = '';
                }
                alert("빈 자리는 삭제할 수 없습니다!");
                return;
            }

            if (choiceLocker !== "") choiceElement.style.backgroundColor = '';

            choiceLocker = id;
            choiceElement = event.currentTarget;
            commentText.innerHTML = "삭제할 자리를 선택해주세요! &nbsp;&nbsp;" + id + "자리를&nbsp;&nbsp;";
            return;
        }

        alert("아무것도 해당안됨!!!");
    }


    function changeTransfer(id) {
        switch (id) {
            case 'moveTransfer':

                if (confirm("정말 " + moveChoiceLocker[0] + "위치를 " + moveChoiceLocker[1] + "위치로 옮기시겠습니까?")) {
                    if (moveChoiceLocker[0].substring(0, 1) === '4') {
                        lockerCode = "01";
                        lockerID = "01";
                        forPtagString = "4층-";

                    } else {
                        lockerCode = "02";
                        lockerID = "02";
                        forPtagString = "5층-";
                    }

                    if (moveChoiceLocker[0].substring(2).length === 1) {
                        lockerID += ("0" + moveChoiceLocker[0].substring(2));
                        forPtagString += moveChoiceLocker[0].substring(2);
                    } else {
                        lockerID += moveChoiceLocker[0].substring(2);
                        forPtagString += moveChoiceLocker[0].substring(2);
                    }

                    if (moveChoiceLocker[1].substring(0, 1) === '4') {
                        lockerCodeNew = "01";
                        lockerIdNew = "01";
                    } else {
                        lockerCodeNew = "02";
                        lockerIdNew = "02";
                    }

                    if (moveChoiceLocker[1].substring(2).length === 1) {
                        lockerIdNew += ("0" + moveChoiceLocker[1].substring(2));
                    } else {
                        lockerIdNew += moveChoiceLocker[1].substring(2);
                    }

                    mebrID = document.getElementById(forPtagString).innerText;

                    const lockerDto = {
                        lockerID: lockerID,
                        mebrID: mebrID
                    };

                    // 서버로 PATCH 요청
                    fetch(`/locker/` + lockerIdNew + `/move`, {
                        method: 'PATCH',
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        body: JSON.stringify(lockerDto),
                    })
                        .then(response => {
                            if (response.ok) {
                                alert("락커 이동이 완료되었습니다.");
                                location.reload();
                            } else {
                                throw new Error("락커 이동에 실패했습니다.");
                            }
                        })
                        .catch((error) => {
                            console.error('Error:', error);
                            alert("이동 실패: " + error);
                            cancelClick();
                            location.reload();
                        });
                } else {
                    cancelClick();
                }
                break;

            case 'extdTransfer':
                if (confirm("정말 " + choiceLocker + "위치를 연장하시겠습니까?")) {
                    extdDays = prompt("연장할 기간을 일단위로 숫자만 입력해주세요(ex 30)", "");
                    if (!isOnlyNumber(extdDays)) {
                        alert("연장 기간은 숫자만 입력해야 합니다. 현재 입력된 값: " + extdDays);
                        cancelClick();
                        return;
                    }
                    if (choiceLocker.substring(0, 1) === '4') {
                        lockerCode = "01";
                        lockerID = "01";
                        forPtagString = "4층-";

                    } else {
                        lockerCode = "02";
                        lockerID = "02";
                        forPtagString = "5층-";
                    }

                    if (choiceLocker.substring(2).length === 1) {
                        lockerID += ("0" + choiceLocker.substring(2));
                        forPtagString += choiceLocker.substring(2);
                    } else {
                        lockerID += choiceLocker.substring(2);
                        forPtagString += choiceLocker.substring(2);
                    }

                    mebrID = document.getElementById(forPtagString).innerText;

                    const lockerDto = {
                        lockerID: lockerID,
                        mebrID: mebrID,
                        extdDays: extdDays
                    };

                    // 서버로 PATCH 요청
                    fetch(`/locker/` + lockerID + `/extend`, {
                        method: 'PATCH',
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        body: JSON.stringify(lockerDto),
                    })
                        .then(response => {
                            if (response.ok) {
                                alert("락커 연장이 완료되었습니다.");
                                location.reload();
                            } else {
                                throw new Error("락커 연장에 실패했습니다.");
                            }
                        })
                        .catch((error) => {
                            console.error('Error:', error);
                            alert("연장 실패: " + error);
                            cancelClick();
                            location.reload();
                        });
                } else {
                    cancelClick();
                }
                break;

            case 'regTransfer':
                // 등록 관련 로직 처리
                confirm("정말 " + choiceLocker + "위치로 등록하시겠습니까?");
                if (confirm) {
                    mebrID = prompt("정석코딩 홈페이지 이메일을 입력해 주세요(aaa@aaa.com)", "");
                    //서버로 전송 -> 여기서 일단 null값으로 데이터 입력. 회원의 이름을 받아서. ooo님 맞습니까? 나중에 userService;
                    //기간을 입력해주세요. 기간입력 후 등록.
                    if (!isValidEmail(mebrID)) {
                        alert("유효한 이메일 주소를 입력해야 합니다. 현재 입력된 값: " + mebrID);
                        mebrID = "";
                        cancelClick();
                        return;
                    }

                    useDays = prompt("사용할 기간을 일단위로 숫자만 입력해주세요(ex 30)", "");
                    if (!isOnlyNumber(useDays)) {
                        alert("사용 기간은 숫자만 입력해야 합니다. 현재 입력된 값: " + useDays);
                        cancelClick();
                        return;
                    }

                    makeEndDate(parseInt(useDays, 10));

                    if (confirm("사용기간은 " + useDays + "일이고, 종료날짜는 " + endDate.toISOString().split('T')[0] + " 입니다. 맞으면 확인을 눌러주세요.")) {

                        if (choiceLocker.substring(0, 1) === '4') {
                            lockerCode = "01";
                            lockerID = "01";
                            forPtagString = "4층-";

                        } else {
                            lockerCode = "02";
                            lockerID = "02";
                            forPtagString = "5층-";
                        }

                        if (choiceLocker.substring(2).length === 1) {
                            lockerID += ("0" + choiceLocker.substring(2));
                            forPtagString += choiceLocker.substring(2);
                        } else {
                            lockerID += choiceLocker.substring(2);
                            forPtagString += choiceLocker.substring(2);
                        }

                        const lockerDto = {
                            lockerID: lockerID,
                            mebrID: mebrID,
                            startDate: startDate,
                            endDate: endDate
                        };

                        // 서버로 Post 요청
                        fetch(`/locker/register`, {
                            method: 'Post',
                            headers: {
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify(lockerDto),
                        })
                            .then(response => {
                                if (response.ok) {
                                    alert("락커 등록이 완료되었습니다.");
                                    location.reload();
                                } else {
                                    throw new Error("락커 등록에 실패했습니다.");
                                }
                            })
                            .catch((error) => {
                                console.error('Error:', error);
                                alert("등록 실패: " + error);
                                cancelClick();
                                location.reload();
                            });


                    } else {
                        alert("등록을 취소하셨습니다.");
                        cancelClick();
                    }
                } else {
                    cancelClick();
                }
                break;

            case 'removeTransfer':
                // 삭제 관련 로직 처리
                confirm("정말 " + choiceLocker + "위치를 삭제하시겠습니까?");
                if (confirm) {

                    if (choiceLocker.substring(0, 1) === '4') {
                        lockerCode = "01";
                        lockerID = "01";
                        forPtagString = "4층-";

                    } else {
                        lockerCode = "02";
                        lockerID = "02";
                        forPtagString = "5층-";
                    }

                    if (choiceLocker.substring(2).length === 1) {
                        lockerID += ("0" + choiceLocker.substring(2));
                        forPtagString += choiceLocker.substring(2);
                    } else {
                        lockerID += choiceLocker.substring(2);
                        forPtagString += choiceLocker.substring(2);
                    }

                    mebrID = document.getElementById(forPtagString).innerText;

                    const lockerDto = {
                        lockerID: lockerID,
                        mebrID: mebrID,
                    };

                    // 서버로 PATCH 요청
                    fetch(`/locker/` + lockerID + `/delete`, {
                        method: 'PATCH',
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        body: JSON.stringify(lockerDto),
                    })
                        .then(response => {
                            if (response.ok) {
                                alert("락커 삭제가 완료되었습니다.");
                                location.reload();
                            } else {
                                throw new Error("락커 삭제에 실패했습니다.");
                            }
                        })
                        .catch((error) => {
                            console.error('Error:', error);
                            alert("삭제 실패: " + error);
                            cancelClick();
                            location.reload();
                        });
                } else {
                    cancelClick();
                }
                break;

            default:
                alert("아무것도 해당안됨");
                break;
        }
    }

    function isOnlyNumber(value) {
        return !isNaN(value) && isFinite(value);
    }

    function isValidEmail(email) {
        let emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        return emailRegex.test(email);
    }

    function makeEndDate(useDays) {
        let today = new Date();
        endDate = new Date(today); // 오늘 날짜를 기반으로 새 Date 객체 생성
        endDate.setDate(today.getDate() + useDays); // 날짜 변경
    }

    floor4.addEventListener("click", changeFloor);

    floor5.addEventListener("click", changeFloor);

    moveBtn.addEventListener("click", moveNo);

    regBtn.addEventListener("click", regNo);

    extdBtn.addEventListener("click", extdNo);

    removeBtn.addEventListener("click", removeNo);

    for (let i = 0; i < lockerCollection4.length; i++) {
        lockerCollection4[i].addEventListener("click", function (event) {
            lockerClick(this.id, event);
        });
    }

    for (let i = 0; i < lockerCollection5.length; i++) {
        lockerCollection5[i].addEventListener("click", function (event) {
            lockerClick(this.id, event);
        });
    }
}