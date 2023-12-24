window.addEventListener('load', function () {
    document.querySelectorAll('.goDetail').forEach(function(btn) {
        var status = btn.getAttribute('data-status');
        var approval = btn.getAttribute('data-approval');
        var registCode = btn.getAttribute('data-registCode');

        if(status !== 'notPaid' || approval !== '승인') {
            btn.disabled = true;
            btn.onclick = function(e) {
                e.preventDefault();
                alert('이미 결제가 완료된 상태이거나 신청이 승인되지 않았습니다.');
                return false;
            };
        } else {
            btn.addEventListener('click', function() {
                if (confirm('결제하시겠습니까?')) {
                    location.href = 'http://localhost:8080/order/order?registCode=' + registCode;
                }
            });
        }
    });
});
