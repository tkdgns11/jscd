

$(document).ready(function () {
    $(".modifyBtn").on("click", function () {
        const form = document.createElement('form');
        form.setAttribute('method', 'post');
        form.setAttribute('action', '/member/memberEdit');

        var pwd = document.getElementById('pwd');
        form.appendChild(pwd);
        document.body.appendChild(form);
        form.submit();

    })


})
