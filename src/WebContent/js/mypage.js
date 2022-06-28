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


/*document.getElementById("sample").addEventListener("click", function () {
  location.replace("/lunchBox/LeaveServlet");
}, false);*/

$(document).ready(function () {
    $('#list_table').DataTable({
        // 日本語表示
        "language": {
            "url": "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Japanese.json"
        }
    });
});
