$(function(){
	$('#radioBtn input').on('click', function(){
		var index = $('#radioBtn input').index(this);
		$('#displayBox .cm_box').eq(index).addClass('active').siblings('div').removeClass('active');
	});
});

jQuery(function($){
  $('.tab').click(function(){
    $('.is-active').removeClass('is-active');
    $(this).addClass('is-active');
    $('.is-show').removeClass('is-show');
    // クリックしたタブからインデックス番号を取得
    const index = $(this).index();
    // クリックしたタブと同じインデックス番号をもつコンテンツを表
    $('.panel').eq(index).addClass('is-show');
  });
});