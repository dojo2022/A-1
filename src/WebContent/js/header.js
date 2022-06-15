/*登録をクリックしたときにメニューを表示と非表示を切り替えるjQuery */
$(document).ready(function(){
	$('#regist').on('click',function(){
		$(this).children().toggleClass('hidden');
	});
});

window.onload = function () {
    var nav = document.getElementById('nav-wrapper');
    var hamburger = document.getElementById('js-hamburger');
    var blackBg = document.getElementById('js-black-bg');

    hamburger.addEventListener('click', function () {
        nav.classList.toggle('open');
    });
    blackBg.addEventListener('click', function () {
        nav.classList.remove('open');
    });
};



