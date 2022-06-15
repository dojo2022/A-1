$(function(){
	$('#radioBtn input').on('click', function(){
		var index = $('#radioBtn input').index(this);
		$('#displayBox .cm_box').eq(index).addClass('active').siblings('div').removeClass('active');
	});
});