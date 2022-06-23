
	function previewImage(obj){

		var fileReader = new FileReader();

		// 読み込み後に実行する処理
		fileReader.onload = (function() {

			// canvas にプレビュー画像を表示
			var canvas = document.getElementById('preview');
			var ctx = canvas.getContext('2d');
			var image = new Image();
			image.src = fileReader.result;
			console.log(fileReader.result) // ← (確認用)

			image.onload = (function () {
				canvas.width = image.width;
				canvas.height = image.height;
				ctx.drawImage(image, 0, 0);
			});
		});
		// 画像読み込み
		fileReader.readAsDataURL(obj.files[0]);
		console.log(fileReader.result) // ← (確認用)null
	}
	 let btn = document.getElementById("submitBtn");
	/* 必須項目チェック（ランチ日記）*/
	function ldCheck(){
		let flg = 0;
		let ans = true;
 		if(document.registLdForm.resName.value ==''){
			window.alert('お店の名前が未入力です。');
 			document.getElementById('required1').textContent = '必須項目です。';
			flg+=1;
			ans = false;
 		}
		if(document.registLdForm.date.value == ''){
			window.alert('日付が未入力です。');
 			document.getElementById('required2').textContent = '必須項目です。';
			flg+=1;
			ans = false;
 		}
		if(flg==0){
			if(confirm('日記を登録します。よろしいですか？')){
				ans = true;
			}else{
				ans = false;
			}
		}
		return ans;

	}
	/*必須項目チェック（手作り日記）*/
	function hdCheck(){
		let flg = 0;
		let ans = true;
 		if(document.registHdForm.foodName.value ==''){
			window.alert('料理名が未入力です。');
 			document.getElementById('required3').textContent = '必須項目です。';
			flg+=1;
			ans = false;
 		}
		if(document.registHdForm.date.value == ''){
			window.alert('日付が未入力です。');
 			document.getElementById('required4').textContent = '必須項目です。';
			flg+=1;
			ans = false;
 		}
		if(flg==0){
			if(confirm('日記を登録します。よろしいですか？')){
				ans = true;
			}else{
				ans = false;
			}
		}
		return ans;

	}

