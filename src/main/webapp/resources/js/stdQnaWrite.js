window.addEventListener('load', function () {
    const form = document.getElementById('stdQnaForm');
    
    // 버튼에 클릭 이벤트를 연결합니다.
    document.getElementById('listBtn').addEventListener('click', function() {
        // 버튼 클릭시 '/board/qna/stdQnaWrite' 페이지로 이동합니다.
        console.log('click');
        window.location.href = '/board/qna/stdQnaList';
    });
    
    //버튼에 클릭 이벤트 연결
    document.getElementById('writeBtn').addEventListener('click', function (e) {
        e.preventDefault();
        console.log('글 등록 해보겠다 !');
        
        let data = {};
        for (let element of form.elements) {
            if (element.name) {
                data[element.name] = element.value;
            }
        }
        
        // 글 등록 부분
        // fetch -> 비동기 방식
        // 이 부분 동기 방식으로 고쳐서..? 수정해야할 것 같다 ..! 
        fetch(form.action, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
            .then(response => response.json())
            .then(data => {
                console.log('완료되어따', data);
            })
            .catch((error) => {
                console.error('에러 ㅠㅠ', error);
            });
        
        // document.getElementById('stdQnaForm').submit();
    });
    
});
