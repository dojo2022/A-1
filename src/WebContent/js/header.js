/*登録をクリックしたときにメニューを表示と非表示を切り替えるjQuery */


window.onload = function () {
    var nav = document.getElementById('nav-wrapper');
    var hamburger = document.getElementById('js-hamburger');
    var blackBg = document.getElementById('js-black-bg');
	var regist = document.getElementById('regist');
	var hidden = document.getElementById('hidden');

    hamburger.addEventListener('click', function () {
        nav.classList.toggle('open');
    });
    blackBg.addEventListener('click', function () {
        nav.classList.remove('open');
    });
	regist.addEventListener('click', function(){
		hidden.classList.remove('hidden');
	});
};



