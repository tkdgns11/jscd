window.addEventListener('load', function () {
    const orderButtons = document.querySelectorAll('.goDetail');

    orderButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            console.log('orderButtons clicked!'); // 버튼 클릭 이벤트가 발생하는지 확인
            const odNo = this.getAttribute('data-odno');
            window.location.href = "/order/orderDetail?odNo=" + odNo;
        });
    });
});
