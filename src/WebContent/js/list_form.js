/*

*/
'use strict';

document.getElementById('editToGoMemo').onsubmit = function(event) {
	//テキストフィールドに入力されている文字列を読み出し定数に代入する
	const memo = document.getElementById('editToGoMemo').value;

	// pタグのコンテンツに文字列を設定する
	if (memo.length < 200) {
		document.getElementById('error_message').textContent = `メモは200字以内で入力してください。`
		return false;
	}
}