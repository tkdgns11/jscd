
//게시글 등록
function allqnaWrite(){
    const qnaCtNo = document.querySelector('#lang').value;
    const title = document.getElementById("title").value;
    const writer = document.getElementById("writer").value;
    const content = document.getElementById("content").value;
    const openYN = document.querySelector('input[name="openYN"]:checked').value;
    console.log(openYN);
    const allqnaData={"qnaCtNo":qnaCtNo, "title":title, "writer":writer, "content":content, "openYN":openYN};
    console.log(allqnaData);
    $.ajax({
        url:"/board/qna/allqnaWrite",
        type:"POST",
        contentType:"application/json; charset=utf-8",
        data:JSON.stringify(allqnaData),
        error : function (error){
            console.log("error");
        },
        success : function (data){
            console.log("성공");
            if(data.redirect){
                window.location.href = data.redirect;
            }
        }
    });


}
//게시글 수정

//게시글 삭제
function allqnaDelete(){
    console.log("delete");
    const allqnaNo = document.getElementById("allqnaNo").value;
    console.log(allqnaNo);
    const allqnaData = {"allqnaNo":allqnaNo}
    $.ajax({
        url:"/board/qna/allqnaDelete",
        type:"POST",
        contentType:"application/json; charset=utf-8",
        data:JSON.stringify(allqnaData),
        error : function (error){
            console.log("error");
        },
        success : function (data){
            console.log("성공");
            if(data.redirect){
                window.location.href = data.redirect;
            }
        }
    });
}

//댓글 등록
function cmtWrite(){
    console.log("cmtWrite");
    //변수만들고
    const allqnaNo = document.getElementById("allqnaNo").value;
    const cmtWriter = document.getElementById("cmtWriterRegi").value;
    const cmtContent = document.getElementById("cmtContentRegi").value;
    //변수를 객체로 만들어
    const allqnaCmtData = {"allqnaNo":allqnaNo, "cmtWriter":cmtWriter, "cmtContent":cmtContent};
    //ajax로 보낸다.
    $.ajax({
        url:"/board/qna/allqnaCmtWrite",
        type:"POST",
        contentType:"application/json; charset=utf-8",
        data:JSON.stringify(allqnaCmtData),
        error : function (error){
            console.log("error");
        },
        success : function (data){
            console.log("성공");
            setTimeout(function(){
                location.reload();
            }, 500);

        }
    });
}
//댓글 수정 버튼 클릭 시
function cmtEdit(index){
    console.log("cmtEdit");
    document.getElementById('cmtWriter' + index).readOnly = false;
    document.getElementById('cmtContent' + index).readOnly = false;

    var editButton = document.getElementById('cmtEditBtn' + index);
    editButton.value = '등록하기';
    editButton.onclick = function() { cmtModify(index); };


}

//댓글 수정하기
function cmtModify(index){
    const allqnaNo = document.getElementById("allqnaNo").value;
    const allqnaCmtNo = document.getElementById("allqnaCmtNo"+index).value;
    console.log(allqnaCmtNo);
    const cmtWriter = document.getElementById("cmtWriter"+index).value;
    const cmtContent = document.getElementById("cmtContent"+index).value;
    //변수를 객체로 만들어
    const allqnaCmtData = {"allqnaNo":allqnaNo, "allqnaCmtNo":allqnaCmtNo,"cmtWriter":cmtWriter, "cmtContent":cmtContent};

    $.ajax({
        url:"/board/qna/allqnaCmtModify",
        type:"POST",
        contentType:"application/json; charset=utf-8",
        data:JSON.stringify(allqnaCmtData),
        error : function (error){
            console.log("error");
        },
        success : function (data){
            console.log("성공");

            document.getElementById('cmtWriter' + index).readOnly = true;
            document.getElementById('cmtContent' + index).readOnly = true;

            var editButton = document.getElementById('cmtEditBtn' + index);
            editButton.value = '수정하기';
            editButton.onclick = function() { cmtEdit(index); };
        }
    });
}
//댓글 삭제
function cmtDelete(index){
    console.log("cmtDelete");
    const allqnaNo = document.getElementById("allqnaNo").value;
    const allqnaCmtNo = document.getElementById("allqnaCmtNo"+index).value;
    console.log(allqnaCmtNo);
    //변수를 객체로 만들어
    const allqnaCmtData = {"allqnaNo":allqnaNo, "allqnaCmtNo":allqnaCmtNo};
    $.ajax({
        url:"/board/qna/allqnaCmtDelete",
        type:"POST",
        contentType:"application/json; charset=utf-8",
        data:JSON.stringify(allqnaCmtData),
        error : function (error){
            console.log("error");
        },
        success : function (data){
            console.log("성공");
            setTimeout(function(){
                location.reload();
            }, 500);
        }
    });

}


//대댓글 등록
function replyCmtWrite(index){

console.log("replyCmtWrite");


    const allqnaNo = document.getElementById("allqnaNo").value;
    const allqnaCmtNo = document.getElementById("allqnaCmtNo"+index).value;
    const cmtReplyWriter = document.getElementById("cmtReplyWriter"+index).value;
    const cmtReplyContent = document.getElementById("cmtReplyContent"+index).value;

    const allqnaCmtReplyData = {"allqnaNo":allqnaNo, "allqnaCmtNo":allqnaCmtNo, "cmtWriter":cmtReplyWriter, "cmtContent":cmtReplyContent};

    $.ajax({
        url:"/board/qna/allqnaCmtReplyWrite",
        type:"POST",
        contentType:"application/json; charset=utf-8",
        data:JSON.stringify(allqnaCmtReplyData),
        error : function (error){
            console.log("error");
        },
        success : function (data){
            console.log("성공");
            setTimeout(function(){
                location.reload();
            }, 500);

        }
    });

}

//
// //대댓글 목록
// function replyCmtList(index){
//
//     console.log("replyCmtWrite");
//
//     const allqnaNo = document.getElementById("allqnaNo").value;
//     const allqnaCmtNo = document.getElementById("allqnaCmtNo"+index).value;
//     const allqnaCmtReplyNo = document.getElementById("allqnaCmtReplyNo"+index).value
//     const replyWriter = document.getElementById("replyWriter"+index).value;
//     const replyContent = document.getElementById("replyContent"+index).value;
//
//     const allqnaCmtReplyData = {"allqnaNo":allqnaNo, "allqnaCmtNo":allqnaCmtNo, "allqnaCmtReplyNo":allqnaCmtReplyNo, "cmtWriter":replyWriter, "cmtContent":replyContent};
//     console.log("replyCmtList==="+allqnaCmtReplyData);
//     $.ajax({
//         url:"/board/qna/allqnaCmtReplyWrite",
//         type:"POST",
//         contentType:"application/json; charset=utf-8",
//         data:JSON.stringify(allqnaCmtReplyData),
//         error : function (error){
//             console.log("error");
//         },
//         success : function (data){
//             console.log("성공");
//             setTimeout(function(){
//                 location.reload();
//             }, 500);
//
//         }
//     });
//
// }


//대댓글 목록
function replyBlock(index){
    document.getElementById('replyBox').style.display = 'inline-block'; // 혹은 'inline-block' 등 원하는 스타일로 변경
    document.getElementById('replyBoxWrite' + index).style.display = "none"; //대댓글 등록 버튼 숨기기


    const allqnaNo = document.getElementById("allqnaNo").value;
    const allqnaCmtNo = document.getElementById("allqnaCmtNo"+index).value;
    const allqnaCmtReplyData = {"allqnaNo":allqnaNo, "allqnaCmtNo":allqnaCmtNo};

    $.ajax({
        url:"/board/qna/allqnaCmtReplyRead",
        type:"POST",
        contentType:"application/json; charset=utf-8",
        data:JSON.stringify(allqnaCmtReplyData),
        error : function (error){
            console.log("error");
        },
        success : function (data){
            console.log("대댓글 가져오기 성공");
            console.log(data);

            data.forEach(function (value, index){
                const replyListBox = document.getElementById('replyListBox'); //리스트 박스
                const allqnaCmtReplyNo = document.createElement('input'); //allqnaCmtReplyNo
                const replyWriter = document.createElement('input'); //cmtReplyWriter
                const replyContent = document.createElement('input'); //cmtReplyContent
                const regDate = document.createElement('input'); //regDate
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

                regDate.setAttribute("type", "text");
                regDate.setAttribute('id', 'replyRegDate' + index);
                regDate.setAttribute('name', 'replyRegDate' + index);
                regDate.setAttribute('value', value.regDate);
                regDate.setAttribute('readonly', true);

                replyEdit.setAttribute("type", "button");
                replyEdit.setAttribute('id', 'replyEditBtn' + index);
                replyEdit.setAttribute('name', 'replyEditBtn' + index);
                replyEdit.setAttribute("onclick","replyEdit("+index+")");
                replyEdit.setAttribute("value","수정하기");

                replyDelete.setAttribute("type", "button");
                replyDelete.setAttribute('id', 'replyEditBtn' + index);
                replyDelete.setAttribute('name', 'replyEditBtn' + index);
                replyDelete.setAttribute("onclick","replyDelete()");
                replyDelete.setAttribute("value","삭제하기");

                replyListBox.appendChild(allqnaCmtReplyNo); // 새로 생성한 <input>을 해당 요소에 추가
                replyListBox.appendChild(replyWriter);
                replyListBox.appendChild(replyContent);
                replyListBox.appendChild(regDate);
                replyListBox.appendChild(replyEdit);
                replyListBox.appendChild(replyDelete);


            });


        }
    });


}

//대댓글 수정 폼 열기

function replyEdit(index){
    console.log("replyEdit");
    console.log(index);
    //readonly false로 바꿔주기
    document.getElementById('replyWriter'+index).readOnly = false;
    document.getElementById('replyContent'+index).readOnly = false;

    //수정하기 버튼 등록하기로 바꿔주기?
    var replyEditBtn = document.getElementById('replyEditBtn' + index);
    replyEditBtn.value = '등록하기';
    replyEditBtn.onclick = function() { replyModify(index); };

}

//대댓글 수정하기
function replyModify(index){
    console.log(index);
    //데이터 전송하기
    const allqnaCmtNo = document.getElementById("allqnaCmtNo"+index).value;
    const allqnaCmtReplyNo = document.getElementById("allqnaCmtReplyNo"+index).value;
    const replyWriter = document.getElementById("replyWriter"+index).value;
    const reReplyContent = document.getElementById("replyContent"+index).value;

    const allqnaCmtReplyData = {"allqnaCmtNo":allqnaCmtNo, "allqnaCmtReplyNo":allqnaCmtReplyNo, "cmtWriter":replyWriter, "cmtContent":reReplyContent};
    console.log(allqnaCmtReplyData)

    $.ajax({
        url:"/board/qna/allqnaCmtReplyUpdate",
        type:"POST",
        contentType:"application/json; charset=utf-8",
        data:JSON.stringify(allqnaCmtReplyData),
        error : function (error){
            console.log("error");
        },
        success : function (data){
            console.log("성공");
            setTimeout(function(){
                location.reload();
            }, 500);

        }
    });

}

//대댓글 삭제하기
function replyDelete(index){
    console.log("delete")
    console.log(index);
    //데이터 전송하기
    //
    // $.ajax({
    //     url:"/board/qna/allqnaCmtReplyDelete",
    //     type:"POST",
    //     contentType:"application/json; charset=utf-8",
    //     data:JSON.stringify(allqnaCmtReplyData),
    //     error : function (error){
    //         console.log("error");
    //     },
    //     success : function (data){
    //         console.log("성공");
    //         // setTimeout(function(){
    //         //     location.reload();
    //         // }, 500);
    //
    //     }
    // });

}