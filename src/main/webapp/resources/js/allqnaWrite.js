


//게시글 등록
function allqnaWrite() {
    console.log("등록");


    // const content = CKEDITOR.instances.content.getData();

    const ctName = document.getElementById("allqnaCategory").value;
    const writer = document.getElementById("writer").value;
    const title = document.getElementById("title").value;
    const editorData = editor.getData();
    const div = document.createElement("div");
    div.innerHTML = editorData;
    const content = div.textContent || div.innerText || "";
    // const openYN = document.querySelector('input[name="openYN"]:checked').value;

    console.log("ctName======="+ctName);
    console.log("writer======="+writer.value);
    console.log("title======="+title.value);
    console.log("content======="+content);


    if (ctName === ""||ctName === "분류") {
        console.log("카테고리입력해주세요");
        return  alert("카테고리를 선택해주세요.");
    }
    if (title === "") {
        console.log("제목입력해주세요");
        return  alert("제목을 입력해주세요.");
    }
    if (content === "") {
        console.log("내용입력해주세요");
        return  alert("내용을 입력해주세요.");
    }
    // if (openYN === undefined || openYN === "") {
    //     alert("공개 여부를 선택해주세요.");
    //     return false;
    // }





    const allqnaData = {ctName: ctName, title: title, writer: writer, content: content};
    console.log(allqnaData);



    $.ajax({
        url: "/board/qna/allqnaWrite",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(allqnaData),
        error: function (error) {
            console.log("에러 발생");
        },
        success: function (data) {
            console.log("성공");
            if (data.redirect) {
                window.location.href = data.redirect;
            }

        }
    });

    return true; // 폼 제출
}


//게시글 상세보기


// 게시글 수정 - 수정하기 버튼 눌렀을때
function allqnaEdit() {

    console.log("수정버튼");

    // var writer = document.getElementById("writer").value;
    // var id = document.getElementById('id').dataset.id;
    //
    // console.log("id"+id);
    // console.log("writer"+writer);
    //
    // if (writer != id) {
    //     alert("해당 게시글의 작성자만 사용할 수 있는 기능입니다.");
    //     return false;
    // }


    // const writer = document.getElementById("writer").value;
    // if(writer!='${id}'){
    //     alert("해당 글의 작성자만 수정할 수 있습니다.");
    // return false;
    // }

// a. 수정버튼 누르면 게시글 reaonly, disabled상태 제거됨 (수정가능)
    document.getElementById('title').readOnly = false;
    document.getElementById('allqnaCategory').removeAttribute('disabled');

    console.log("수정버튼2");
    const contentTextarea = document.querySelector('#content');
    contentTextarea.removeAttribute('readonly');
    console.log("수정버튼3");

    // b. 에디터 나타남
    ClassicEditor
        .create(contentTextarea)
        .then(newEditor => {
            editor = newEditor;
        })
        .catch(error => {
            console.error(error);
        });

    //c. 수정버튼은 수정완료 버튼으로 바뀜
    const editButton = document.getElementById('modifyBtn');
    editButton.value = '수정완료';

    //d. 수정완료 버튼 누르면
    editButton.onclick = function () {
        allqnaModify();
    };
}


//게시글 수정 - 수정한 내용 저장
function allqnaModify() {
    // e.수정내용 저장해주는 함수 호출됨
    console.log("수정완료버튼");

    //f.수정한 내용 변수에 담고
    const ctName = document.getElementById("allqnaCategory").value;
    const writer = document.getElementById("writer").value;
    const title = document.getElementById("title").value;
    const editorData = editor.getData();
    const div = document.createElement("div");
    div.innerHTML = editorData;
    const content = div.textContent || div.innerText || "";
    // const openYN = document.querySelector('input[name="openYN"]:checked').value;
    //


    if (ctName === ""|| ctName === "분류") {
        return   alert("카테고리를 선택해주세요.");;
    }
    if (title === "") {
        return alert("제목을 입력해주세요.");
    }
    if (content === "") {
        return alert("내용을 입력해주세요.");;
    }
    // if (openYN === undefined || openYN === "") {
    //     alert("공개 여부를 선택해주세요.");
    //     return false;
    // }


    //f.내용 다 작성했으면 객체에 담기
    const allqnaData = {ctName: ctName, title: title, content: content, openYN: openYN};
    //writer: writer,


    console.log("ctName======="+ctName);
    // console.log("writer======="+writer.value);
    console.log("title======="+title);
    console.log("content======="+content);
    console.log("openYN======="+openYN);



    //g.컨트롤러로 값 보냄
    $.ajax({
        url: "/board/qna/allqnaModify",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(allqnaData),
        error: function (error) {
            console.log("게시글 수정 실패:", error);
        },
        success: function (data) {
            console.log("게시글 수정 성공");
            console.log("data==="+data.content);
            console.log("data===="+data.title);

            document.getElementById('title').readOnly = true;
            document.getElementById('allqnaCategory').disabled = true;
            document.getElementById('open').disabled = true;
            document.getElementById('close').disabled = true;

            // 'readOnly' 속성 설정
            const content = document.getElementById('content');
            content.readOnly = true;
            content.style.display = 'block';

// 에디터 숨기기
            const editorElement = document.querySelector('.ck-editor');
            if (editorElement) {
                editorElement.style.display = 'none';
            }



            const modifyBtn = document.getElementById('modifyBtn');
            modifyBtn.value = '수정';
            modifyBtn.onclick = function () {
                allqnaEdit();
            }
        }

    });

    return true;

}



//게시글 삭제
function allqnaDelete() {
    console.log("delete");
    const allqnaNo = document.getElementById("allqnaNo").value;
    const writer = document.getElementById("writer").value.trim();
    console.log(allqnaNo);
    const allqnaData = {"allqnaNo": allqnaNo, "writer": writer};

    confirm("삭제하시겠습니까?");

    $.ajax({
        url: "/board/qna/allqnaDelete",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(allqnaData),
        error: function (error) {
            console.log("error");
        },
        success: function (data) {
            console.log("성공");
            if (data.redirect.includes("allqnaList")) {
                alert("삭제되었습니다.");

                location.href = data.redirect;
            } else if (data.redirect.includes("allqnaDetail")) {
                alert("해당 글의 작성자만 삭제할 수 있습니다.");
                location.href = data.redirect;
            }
        }
    });
}


//댓글 등록
function cmtWrite() {
    console.log("cmtWrite");
    //변수만들고
    const allqnaNo = document.getElementById("allqnaNo").value;
    const cmtWriter = document.getElementById("cmtWriterRegi").value;
    const cmtContent = document.getElementById("cmtContentRegi").value;
    //변수를 객체로 만들어
    const allqnaCmtData = {"allqnaNo": allqnaNo, "cmtWriter": cmtWriter, "cmtContent": cmtContent};
    //ajax로 보낸다.
    $.ajax({
        url: "/board/qna/allqnaCmtWrite",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(allqnaCmtData),
        error: function (error) {
            console.log("error");
        },
        success: function (data) {
            console.log("성공");
            setTimeout(function () {
                location.reload();
            }, 500);

        }
    });
}

//댓글 수정 버튼 클릭 시
function cmtEdit(index) {
    console.log("cmtEdit");
    // document.getElementById('cmtWriter' + index).readOnly = false;
    document.getElementById('cmtContent' + index).readOnly = false;

    const editButton = document.getElementById('cmtEditBtn' + index);
    editButton.value = '수정완료';
    editButton.onclick = function () {
        cmtModify(index);
    };


}

//댓글 수정하기
function cmtModify(index) {
    const allqnaNo = document.getElementById("allqnaNo").value;
    const allqnaCmtNo = document.getElementById("allqnaCmtNo" + index).value;
    console.log("수정할 댓글 번호 : " +allqnaCmtNo);
    // const cmtWriter = document.getElementById("cmtWriter" + index).value;
    const cmtContent = document.getElementById("cmtContent" + index).value;
    //변수를 객체로 만들어
    const allqnaCmtData = {
        "allqnaNo": allqnaNo,
        "allqnaCmtNo": allqnaCmtNo,
        // "cmtWriter": cmtWriter,
        "cmtContent": cmtContent
    };

    $.ajax({
        url: "/board/qna/allqnaCmtModify",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(allqnaCmtData),
        error: function (error) {
            console.log("error");
        },
        success: function (data) {
            console.log("성공");

            // document.getElementById('cmtWriter' + index).readOnly = true;
            document.getElementById('cmtContent' + index).readOnly = true;

            const editButton = document.getElementById('cmtEditBtn' + index);
            editButton.value = '수정';
            editButton.onclick = function () {
                cmtEdit(index);
            };
        }
    });
}

//댓글 삭제
function cmtDelete(index) {
    console.log("cmtDelete");
    const allqnaNo = document.getElementById("allqnaNo").value;
    const allqnaCmtNo = document.getElementById("allqnaCmtNo" + index).value;
    console.log(allqnaCmtNo);
    //변수를 객체로 만들어
    const allqnaCmtData = {"allqnaNo": allqnaNo, "allqnaCmtNo": allqnaCmtNo};
    $.ajax({
        url: "/board/qna/allqnaCmtDelete",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(allqnaCmtData),
        error: function (error) {
            console.log("error");
        },
        success: function (data) {
            console.log("성공");
            setTimeout(function () {
                location.reload();
            }, 500);

        }
    });

}


//대댓글 등록
function replyCmtWrite(index) {
    console.log("replyCmtWrite");

    const allqnaNo = document.getElementById("allqnaNo").value;
    const allqnaCmtNo = document.getElementById("allqnaCmtNo" + index).value;
    const cmtReplyWriter = document.getElementById("cmtReplyWriter" + index).value;
    const cmtReplyContent = document.getElementById("cmtReplyContent" + index).value;


    const allqnaCmtReplyData = {
        "allqnaNo": allqnaNo,
        "allqnaCmtNo": allqnaCmtNo,
        "cmtWriter": cmtReplyWriter,
        "cmtContent": cmtReplyContent
    };

    console.log(allqnaCmtReplyData);

    $.ajax({
        url: "/board/qna/allqnaCmtReplyWrite",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(allqnaCmtReplyData),
        error: function (error) {
            console.log("error");
        },
        success: function (data) {
            console.log("성공=" + data.cmtContent);
            console.log("성공성공="+data.map); // "map" 속성에 해당하는 값 출력
            console.log("성공="+data.allqnaDto);
            const replyContainer = document.getElementById(`replyContainer`+index);
            replyContainer.style.display = 'block';

            // 비우기
            document.getElementById("cmtReplyWriter" + index).value = '';
            document.getElementById("cmtReplyContent" + index).value = '';

            // 새로운 대댓글을 생성하여 목록에 추가
            const replyListBox = document.getElementById(`replyListBox`+allqnaCmtNo);
            const newReply = createNewReplyElement(allqnaCmtReplyData); // 새로운 대댓글 요소 생성

            replyListBox.appendChild(newReply); // 목록에 새로운 대댓글 요소 추가
        }
    });
}



function createNewReplyElement(replyData) {

    const newReplyElement = document.createElement('div');
    newReplyElement.classList.add('reply');

    const cmtReplyWriter = replyData.cmtWriter;
    const cmtReplyContent = replyData.cmtContent;
    const replyNo = replyData.allqnaCmtReplyNo;


    newReplyElement.innerHTML = `
        <input type="text" value="${cmtReplyWriter}" id="cmtReplyWriter${replyNo}"><br>
        <input type="text" value="${cmtReplyContent}" id="cmtReplyContent${replyNo}"><br>
        <button onclick="replyEdit(${replyNo})">수정하기</button>
        <button onclick="replyDelete(${replyNo})">삭제하기</button>
    `;


    return newReplyElement;
}



//대댓글 - 답변보기 버튼 누르면 대댓글 폼 열리고 대댓글 목록 보여야됨
function replyBlock(index) {

    const replyContainer = document.getElementById(`replyContainer${index}`);

    replyContainer.style.display = 'block'; // 특정 댓글의 대댓글 상자 표시
    document.getElementById('replyBoxWrite' + index).style.display = 'none'; // 대댓글 버튼 숨기기


    const allqnaNo = document.getElementById("allqnaNo").value;
    const allqnaCmtNo = document.getElementById("allqnaCmtNo" + index).value;
    const allqnaCmtReplyData = {"allqnaNo": allqnaNo, "allqnaCmtNo": allqnaCmtNo};




    $.ajax({
        url: "/board/qna/allqnaCmtReplyRead",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(allqnaCmtReplyData),
        error: function (error) {
            console.log("error");
        },
        success: function (data) {
            console.log("대댓글 가져오기 성공");
            console.log("대댓글 목록 데이터:"+data);


            data.forEach(function (value, index) {


                const replyListBox = document.getElementById(`replyListBox${allqnaCmtNo}`); //리스트 박스
                const allqnaCmtReplyNo = document.createElement('input'); //allqnaCmtReplyNo
                const replyWriter = document.createElement('input'); //cmtReplyWriter
                const replyContent = document.createElement('input'); //cmtReplyContent
                // const regDate = document.createElement('input'); //regDate
                const replyEdit = document.createElement("input");
                const replyDelete = document.createElement("input");
                allqnaCmtReplyNo.setAttribute("type", "hidden");
                allqnaCmtReplyNo.setAttribute('id', 'allqnaCmtReplyNo' + index);
                allqnaCmtReplyNo.setAttribute('name', 'allqnaCmtReplyNo' + index);
                allqnaCmtReplyNo.setAttribute('value', value.allqnaCmtReplyNo);

                replyWriter.setAttribute("type", "text");
                replyWriter.setAttribute('id', 'replyWriter' + index);
                replyWriter.setAttribute('name', 'replyWriter' + index);
                replyWriter.setAttribute('value', value.cmtWriter);
                replyWriter.setAttribute('readonly', true);

                replyContent.setAttribute("type", "text");
                replyContent.setAttribute('id', 'replyContent' + index);
                replyContent.setAttribute('name', 'replyContent' + index);
                replyContent.setAttribute('value', value.cmtContent);
                replyContent.setAttribute('readonly', true);
                //
                // regDate.setAttribute("type", "text");
                // regDate.setAttribute('id', 'replyRegDate' + index);
                // regDate.setAttribute('name', 'replyRegDate' + index);
                // regDate.setAttribute('value', value.regDate);
                // regDate.setAttribute('readonly', true);

                replyEdit.setAttribute("type", "button");
                replyEdit.setAttribute('id', 'replyEditBtn' + index);
                replyEdit.setAttribute('name', 'replyEditBtn' + index);
                replyEdit.setAttribute("onclick", "replyEdit(" + index + ")");
                replyEdit.setAttribute("value", "수정하기");

                replyDelete.setAttribute("type", "button");
                replyDelete.setAttribute('id', 'replyDeleteBtn' + index);
                replyDelete.setAttribute('name', 'replyDeleteBtn' + index);
                replyDelete.setAttribute("onclick", "replyDelete()");
                replyDelete.setAttribute("value", "삭제하기");

                replyListBox.appendChild(allqnaCmtReplyNo); // 새로 생성한 <input>을 해당 요소에 추가
                replyListBox.appendChild(replyWriter);
                replyListBox.appendChild(replyContent);
                // replyListBox.appendChild(regDate);
                replyListBox.appendChild(replyEdit);
                replyListBox.appendChild(replyDelete);

                replyWriter.style.display = 'block';
                replyContent.style.display = 'block';
                replyEdit.style.display = 'inline-block';
                replyDelete.style.display = 'inline-block';





            });
        }

    });
}


//대댓글 - 취소버튼 누르면 대댓글폼 닫힘
function replyCmtCancel(index) {
    const replyContainer = document.getElementById('replyContainer' + index);
    replyContainer.style.display = 'none'; // 대댓글폼 닫힘

    const replyButton = document.getElementById('replyBoxWrite' + index);
    replyButton.style.display = 'inline-block'; // 답변보기 버튼 다시 나타남


}








//대댓글 수정 폼 열기

function replyEdit(index) {
    console.log("replyEdit");
    console.log("대댓글수정버튼 누르기");

    //readonly 속성 해제
    document.getElementById('replyWriter' + index).readOnly = false;
    document.getElementById('replyContent' + index).readOnly = false;

    // 수정하기 버튼 누르면 수정버튼이 '수정완료'로 변경됨
    const replyEditBtn = document.getElementById('replyEditBtn' + index);
    const replyDeleteBtn = document.getElementById('replyDeleteBtn' + index);
    const originalEditHandler = replyEditBtn.onclick; // 초기 클릭 이벤트 핸들러 저장

    replyEditBtn.value = '수정완료';
    replyEditBtn.onclick = function () {
        replyModify(index);
    };

    // 수정하기 버튼 누르면 삭제하기 버튼을 '수정취소'로 변경
    replyDeleteBtn.value = '수정취소';
    replyDeleteBtn.onclick = function () {
        replyEditBtn.value = '수정하기';
        replyDeleteBtn.value = '삭제하기';
        replyEditBtn.onclick = originalEditHandler; // 초기 클릭 이벤트 핸들러 복원
    };
}



//대댓글 수정하기
function replyModify(index) {
    //데이터 전송하기
    const allqnaCmtNo = document.getElementById("allqnaCmtNo" + index).value;
    const allqnaCmtReplyNo = document.getElementById("allqnaCmtReplyNo" + index).value;
    const replyWriter = document.getElementById("replyWriter" + index).value;
    const reReplyContent = document.getElementById("replyContent" + index).value;

    const allqnaCmtReplyData = {
        "allqnaCmtNo": allqnaCmtNo,
        "allqnaCmtReplyNo": allqnaCmtReplyNo,
        "cmtWriter": replyWriter,
        "cmtContent": reReplyContent
    };
    console.log("수정내용======="+reReplyContent);
    console.log("수정작성자======="+replyWriter);
    console.log("수정댓글번호======="+allqnaCmtReplyNo);
    console.log("수정대댓글번호======="+allqnaCmtNo);

    $.ajax({
        url: "/board/qna/allqnaCmtReplyUpdate",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(allqnaCmtReplyData),
        error: function (xhr, status, error) {
            console.log("HTTP 상태 코드: " + xhr.status); // HTTP 상태 코드 출력
            console.log("에러 메시지: " + error); // 구체적인 에러 메시지 출력
        },
        success: function (data) {
            console.log("성공");
            setTimeout(function () {
                location.reload();
            }, 500);

        }
    });



    //대댓글 수정취소
    function replyModifyCancel(index){
        console.log("대댓글 수정취소 버튼");
        const replyEditBtn = document.getElementById('replyEditBtn' + index);
        const replyDeleteBtn = document.getElementById('replyDeleteBtn' + index);

    };







}


//     비밀글 체크

