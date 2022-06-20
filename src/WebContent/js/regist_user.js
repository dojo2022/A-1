
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


	//メールアドレスが確認ボックスと違った時の処理
	function checkEmail(emailCheck){

		var input1 = emailAddress.value;
		var input2 = emailCheck.value;

		if(input1 != input2){
			emailCheck.setCustomValidity("入力内容が一致しません。");
		}else{
			emailCheck.setCustomValidity('');
		}
	}



	//パスワードが確認ボックスと違った時の処理
	function checkPassword(pwCheck){

		var input1 = pw.value;
		var input2 = pwCheck.value;

		if(input1 != input2){
			pwCheck.setCustomValidity("入力内容が一致しません。");
		}else{
			pwCheck.setCustomValidity('');
		}
	}


