$(function(){
  $('.section').hide();

  $('.secList').on('click',function(){
        // クリックした要素の ID と違うクラス名のセクションを非表示
    $('.section').not($('.'+$(this).attr('id'))).hide();
    // クリックした要素の ID と同じクラスのセクションを表示
    $('.'+$(this).attr('id')).show(1000);

    // toggle にすると、同じボタンを 2 回押すと非表示になる
    // $('.'+$(this).attr('id')).toggle();
  });
});








/**
 *
 */