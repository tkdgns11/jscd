document.addEventListener('DOMContentLoaded', function () {
    var menus = {
        'about': document.querySelector('#about .Menu'),
        'apply': document.querySelector('#apply .Menu'),
        'community': document.querySelector('#community .Menu'),
        'manage': document.querySelector('#manage .Menu'),
    };

    // 토글 상태 변수
    let isMenuVisible = false;

    // 각 메뉴에 이벤트 리스너 등록
    for (var key in menus) {
        if (menus.hasOwnProperty(key)) {
            var menu = menus[key];
            console.log(menu);
            var trigger = document.getElementById(key);
            if (trigger) {
                trigger.addEventListener('mouseover', createToggleMenu(menu));
                trigger.addEventListener('mouseout', createToggleMenu(menu));
            }
        }
    }

    function createToggleMenu(menu) {
        return function () {
            isMenuVisible = !isMenuVisible;
            if (isMenuVisible) {
                showMenu(menu);
            } else {
                hideMenu(menu);
            }
        };
    }

    function showMenu(menu) {
        menu.style.display = 'flex';
        menu.style.opacity = '1';
        menu.style.visibility = 'visible';
    }

    function hideMenu(menu) {
        menu.style.display = 'none';
        menu.style.opacity = '0';
        menu.style.visibility = 'hidden';
    }

});

//
//     document.addEventListener('DOMContentLoaded', function () {
//     var menus = {
//     'all': document.querySelector('.all .Menu'),
//     'about': document.querySelector('#about .Menu'),
//     'apply': document.querySelector('#apply .Menu'),
//     'board': document.querySelector('#board .Menu'),
//     'manage': document.querySelector('#manage .Menu'),
// };
//
//     // 토글 상태 변수
//     let isMenuVisible = false;
//
//     // 각 메뉴에 이벤트 리스너 등록
//     for (var key in menus) {
//     if (menus.hasOwnProperty(key)) {
//     var menu = menus[key];
//     var trigger = document.getElementById(key);
//     if (trigger) {
//     trigger.addEventListener('mouseover', createToggleMenu(menu));
//     trigger.addEventListener('mouseout', createToggleMenu(menu));
// }
// }
// }
//
//     function createToggleMenu(menu) {
//     return function () {
//     isMenuVisible = !isMenuVisible;
//     if (isMenuVisible) {
//     showMenu(menu);
// } else {
//     hideMenu(menu);
// }
// };
// }
//
//     function showMenu(menu) {
//     menu.style.display = 'flex';
//     menu.style.opacity = '1';
//     menu.style.visibility = 'visible';
// }
//
//     function hideMenu(menu) {
//     menu.style.display = 'none';
//     menu.style.opacity = '0';
//     menu.style.visibility = 'hidden';
// }
// });
