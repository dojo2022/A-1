<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LunchBox|タイムライン</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="js/timeline.js"></script>
<link href="css/timeline.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="header.jsp" />


<header>


<form method="POST" action="/lunchBox/SearchServlet" target="_new" >
<div class="searchBox">
<div id="radioBtn">
	<label><input name="lunch" type="radio" value="lunch_diary" checked="checked" />ランチ日記</label>
	<label><input name="lunch" type="radio" value="handmade_diary" />手作り日記</label>
</div>

<div id="displayBox">
	<div class="cm_box active">


			<select name="distance">
				<option value="">会社からの所要時間</option>
				<option value="3分未満">3分未満</option>
				<option value="3～5分">3～5分</option>
				<option value="5～7分">5～7分</option>
				<option value="7～10分">7～10分</option>
				<option value="10分以上">10分以上</option>
			</select>
			<select name="time">
				<option value="">提供時間</option>
				<option value="5分未満">5分未満</option>
				<option value="5～10分">5～10分</option>
				<option value="10～15分">10～15分</option>
				<option value="15分以上">15分以上</option>
			</select>
			<select name="category">
				<option value="">ジャンル</option>
				<option value="和食">和食</option>
				<option value="中華">中華</option>
				<option value="洋食">洋食</option>
				<option value="イタリアン">イタリアン</option>
				<option value="パン">パン</option>
				<option value="ラーメン">ラーメン</option>
				<option value="その他">その他</option>
			</select>
			<select name="cost">
				<option value="">費用</option>
				<option value="100円未満">100円未満</option>
				<option value="100～300円">100円～300円</option>
				<option value="300円～500円">300円～500円</option>
				<option value="500～700円">500円～700円</option>
				<option value="700円～1000円">700円～1000円</option>
				<option value="1000円以上">1000円以上</option>
			</select>
			<input type="text" name="resName" placeholder="店名">
			<input type="submit" name="searchSubmit" value="検索">

	</div>
	<div class="cm_box">

			<select name="time">
				<option value="">所要時間</option>
				<option value="3分未満">3分未満</option>
				<option value="3～5分">3～5分</option>
				<option value="5～7分">5～7分</option>
				<option value="7～10分">7～10分</option>
				<option value="10分以上">10分以上</option>
			</select>
			<input type="text" name="foodName" placeholder="料理名">
			<input type="submit" name="searchSubmit" value="検索">

	</div>
</div>
</div>
</form>
<!--タブ-->
<ul class="tab-group">
  <li class="tab is-active">ランチ日記</li>
  <li class="tab">手作り日記</li>
</ul>
</header>

<main>
<!--タブを切り替えて表示するコンテンツ-->
<div class="panel-group">
<div class="panel is-show">
<input type="hidden" name="mailAddress" id="emailAddress" value="${user.emailAddress}">
<c:forEach var="e" items="${allLunch}" varStatus="status">
<form method="POST" action="TimelineServlet" class="ld">
	<b>${e.accountName}</b>
	<a href="mailto:${e.emailAddress}">${e.emailAddress}</a>
	<span class="date">食べた日：${e.ldDate}</span>
	<span class="category"><b>${e.ldCategory}</b></span><br>



	<%-- ${e.ldFoodPhoto} --%>
	<div class=diarydata>
		<div class = "foodphoto">
			<img src = "/lunchBox/images/${e.ldFoodPhoto}" width="250px" height="180px"><br>
		</div>
		<div class="titles">
		<span class="foodName"><b>${e.ldFoodName}</b></span><br>
		<a href="http://maps.google.co.jp/maps?q=${e.ldResName}" target="_new">${e.ldResName}</a><br>

		<span class="smallTitle">会社からの所要時間：${e.distance}<br>
		費用：${e.ldCost}<br>
		提供時間：${e.time}<br>
		利用：${e.style}<br>
		評価：<span class="star">★</span>${e.ldStar}<br>
		メモ：${e.ldFeeling}<br>
		</span>
		<input type="hidden" name="lunch_id" value="${e.lunchId}" id="lunch_id${status.index}">
		</div>
	</div>


		<c:forEach var="lr" items="${ldReactionList}">
		<c:if test="${lr.lunchId == e.lunchId}">
			<div class="buttons">
			<input type="button" name="to" value="行きたい" onclick="goAjax1(${status.index})" class="toGo">　${lr.countLdToGo}　
			<input type="button" name="to" value="教えて" onclick="goAjax2(${status.index})" class="toTell">　${lr.countLdToTell}　
			<input type="button" name="to" value="参考にします" onclick="goAjax3(${status.index})" class="toUse">　${lr.countLdToUse}<br>
			</div>
		</c:if>
		</c:forEach>
	 		<%-- <input type="button" name="to" value="行きたい" onclick="goAjax1( ${status.index} )">
			<input type="button" name="to" value="教えて" onclick="goAjax2(${status.index})">
			<input type="button" name="to" value="参考にします" onclick="goAjax3(${status.index})"><br> --%>

			<!--lunch_reactionのランチIDとallLunchのランチIDが一致するものの行きたいリアクションについて取得する（1or行がない）-->
			<c:forEach var="a" items="${ldr}" varStatus="st">
				<c:if test="${a.lunchId == e.lunchId and a.ldToGo ==1}">
					<input type = "hidden" name="iki" id="iki${st.index}${status.index}" value="${a.ldToGo}${st.index}">
				</c:if>
				<c:if test="${a.lunchId!= e.lunchId}">
					<input type = "hidden" name="iki" id="iki${st.index}${status.index}" value="">
				</c:if>
				<%-- ${a.lunchId} ----- ${e.lunchId}-------${a.ldToGo} ←ごー<br> --%>
				<c:if test="${a.lunchId == e.lunchId and a.ldToTell ==1}">
					<input type = "hidden" name="oshi" id="oshi${st.index}${status.index}" value="${a.ldToTell}${st.index}">
				</c:if>
				<c:if test="${a.lunchId!= e.lunchId}">
					<input type = "hidden" name="oshi" id="oshi${st.index}${status.index}" value="">
				</c:if>
				<%-- ${a.lunchId} ----- ${e.lunchId}-------${a.ldToTell} ←てるー<br> --%>
				<c:if test="${a.lunchId == e.lunchId and a.ldToUse ==1}">
					<input type = "hidden" name="san" id="san${st.index}${status.index}" value="${a.ldToUse}${st.index}">
				</c:if>
				<c:if test="${a.lunchId!= e.lunchId}">
					<input type = "hidden" name="san" id="san${st.index}${status.index}" value="">
				</c:if>
				<%-- ${a.lunchId} ----- ${e.lunchId}-------${a.ldToUse} ←ゆーず<br> --%>
			</c:forEach>
 		<input type = "hidden" name="iki" id="iki0${status.index}" value="">
		<input type = "hidden" name="oshi" id="oshi0${status.index}" value="">
 		<input type = "hidden" name="san" id="san0${status.index}" value="">

		<div class="commentArea">
 		<input type="text" name="ld_comment" placeholder="コメントを入力してください" id="ld_comment" class="inputText">
		<input type="button" name="send_comment" value="送信" onclick="goAjax4(${status.index})" class="sendText"><br>
		</div>
		<c:forEach var="lc" items="${LdComment}" varStatus="vst">
		<c:if test="${lc.lunchId == e.lunchId}">
		<div class="commentArea">
			${lc.accountName}：
			${lc.ldComment}<br>
			<%-- <input type="hidden" name="account_name" id="account_name" value="${lc.accountName}"> --%>
		</div>
		</c:if>
		</c:forEach>

</form>
</c:forEach>

</div>




  <div class="panel">
<c:forEach var="e" items="${myHandmade}" >
<form method="POST" action="TimelineServlet">
		${e.handmadeId}<br>
		${e.accountName}<br>
		${e.emailAddress}<br>
		${e.hdFoodType}<br>
		${e.hdFoodPhoto}<br>
		${e.hdCategory}<br>
		${e.hdDate}<br>
		${e.hdFoodName}<br>
		${e.hdCost}<br>
		${e.hdStar}<br>
		${e.hdFeeling}<br>
		${e.cooktime}<br>
		${e.ldRegistTime}<br>
	<input type="hidden" name="handmade_id" value="${e.handmadeId}">
	<c:forEach var="hc" items="${HdComment}">
	<c:if test="${hc.handmadeId == e.handmadeId}">
		${hc.accountName}：
		${hc.hdComment}<br>
	</c:if>
	</c:forEach>
	<input type="text" name="hd_comment" placeholder="コメントを入力してください">
	<input type="submit" name="send_comment" value="手作り記録コメントを送信する"><br>
	<c:forEach var="hr" items="${hdReactionList}">
	<c:if test="${hr.handmadeId == e.handmadeId}">
		${hr.countHdToEat}|
		${hr.countHdToTell}|
		${hr.countHdToUse}|
	</c:if>
	</c:forEach>
		<input type="submit" name="hdbtn" value="食べたい">
		<input type="submit" name="hdbtn" value="教えて">
		<input type="submit" name="hdbtn" value="参考にします"><br>
	</form>
</c:forEach>

</div>

</div>



</main>

<script>
function goAjax1(num){
	//alert('function突入');

	let lunch_id = document.getElementById('lunch_id'+num).value;
	//行きたいボタンを押したかおしてないかの情報を持ってくる
	//let iki = "";

/* 	for(let i = 0; i<2000; i++){
		if(document.getElementById('iki'+i+num).value != null){
			let str = document.getElementById('iki'+i+num).value;
			if(str.length!=0){
				iki=document.getElementById('iki'+i+num).value;
				break;
			}
		}
	} */

	 let iki = document.getElementById('iki0'+num).value;

/* 	if(parseInt(iki)==0){
		iki="";
	} */
	//alert(iki);
	//数値の変化をさせるところ
/* 	if(iki.length!=0){
		let count = document.getElementById("ikiiki");
		count.innerText = "";
		number = count.innerText-1; //int型に変換して
		count.innerText = number;
	}else{
		let count = document.getElementById("ikiiki");
		count.innerText = "";
		number = count.innerText+1; //int型に変換して
		count.innerText = number;
	} */
	//0ならinsert、1ならdelete,サーブレットでかけよ
	//誰が押したか
	let email_address = document.getElementById('emailAddress').value;
	//{変数名：中に入れるもの}みたいに書いて、複数の値をpostData変数に格納
	let postData = {data1:lunch_id,data2:iki,data3:email_address,data4:'to_go'}

	//非同期通信始めるよ
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.ajax({
		//どのサーブレットに送るか
		//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
		url: '/lunchBox/TimelineServlet',
		//どのメソッドを使用するか
		type:"POST",
		//受け取るデータのタイプ
		dataType:"text",
		//何をサーブレットに飛ばすか（変数を記述）
		data: postData,
		//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
		processDate:false,
		timeStamp: new Date().getTime()

	   //非同期通信が成功したときの処理
	}).done(function(data) {
		//alert("成功1");
		// 今回は上の<div id="test"></div>の中に返ってきた文字列を入れる
		location.reload();
	  })
	   //非同期通信が失敗したときの処理
	  .fail(function() {
		//失敗とアラートを出す
		alert("失敗！");
	  });
}

function goAjax2(num){
	//alert('function突入');

	let lunch_id = document.getElementById('lunch_id'+num).value;
	//行きたいボタンを押したかおしてないかの情報を持ってくる
	let oshi = document.getElementById('oshi0'+num).value;
/* 	if(parseInt(oshi)==0){
		oshi="";
	} */
	//alert(oshi);
	//数値の変化をさせるところ
/* 	if(iki.length!=0){
		let count = document.getElementById("ikiiki");
		count.innerText = "";
		number = count.innerText-1; //int型に変換して
		count.innerText = number;
	}else{
		let count = document.getElementById("ikiiki");
		count.innerText = "";
		number = count.innerText+1; //int型に変換して
		count.innerText = number;
	} */
	//0ならinsert、1ならdelete,サーブレットでかけよ
	//誰が押したか
	let email_address = document.getElementById('emailAddress').value;
	//{変数名：中に入れるもの}みたいに書いて、複数の値をpostData変数に格納
	let postData = {data1:lunch_id,data2:oshi,data3:email_address,data4:'to_tell'}

	//非同期通信始めるよ
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.ajax({
		//どのサーブレットに送るか
		//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
		url: '/lunchBox/TimelineServlet',
		//どのメソッドを使用するか
		type:"POST",
		//受け取るデータのタイプ
		dataType:"text",
		//何をサーブレットに飛ばすか（変数を記述）
		data: postData,
		//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
		processDate:false,
		timeStamp: new Date().getTime()

	   //非同期通信が成功したときの処理
	}).done(function(data) {
		//alert("成功1");
		// 今回は上の<div id="test"></div>の中に返ってきた文字列を入れる
		location.reload();
	  })
	   //非同期通信が失敗したときの処理
	  .fail(function() {
		//失敗とアラートを出す
		alert("失敗！");
	  });
}

function goAjax3(num){
	//alert('function突入');

	let lunch_id = document.getElementById('lunch_id'+num).value;
	//行きたいボタンを押したかおしてないかの情報を持ってくる
	let san = document.getElementById('san0'+num).value;

/* 	if(parseInt(san)==0){
		san="";
	} */
	//alert(san);
	//数値の変化をさせるところ
/* 	if(iki.length!=0){
		let count = document.getElementById("ikiiki");
		count.innerText = "";
		number = count.innerText-1; //int型に変換して
		count.innerText = number;
	}else{
		let count = document.getElementById("ikiiki");
		count.innerText = "";
		number = count.innerText+1; //int型に変換して
		count.innerText = number;
	} */
	//0ならinsert、1ならdelete,サーブレットでかけよ
	//誰が押したか
	let email_address = document.getElementById('emailAddress').value;
	//{変数名：中に入れるもの}みたいに書いて、複数の値をpostData変数に格納
	let postData = {data1:lunch_id,data2:san,data3:email_address,data4:'to_use'}

	//非同期通信始めるよ
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.ajax({
		//どのサーブレットに送るか
		//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
		url: '/lunchBox/TimelineServlet',
		//どのメソッドを使用するか
		type:"POST",
		//受け取るデータのタイプ
		dataType:"text",
		//何をサーブレットに飛ばすか（変数を記述）
		data: postData,
		//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
		processDate:false,
		timeStamp: new Date().getTime()

	   //非同期通信が成功したときの処理
	}).done(function(data) {
		//alert("成功1");
		// 今回は上の<div id="test"></div>の中に返ってきた文字列を入れる
		location.reload();
	  })
	   //非同期通信が失敗したときの処理
	  .fail(function() {
		//失敗とアラートを出す
		alert("失敗！");
	  });
}

function goAjax4(num){
/* 	alert("functionはいったよ！"); */
	//入力値を取得してくる
	let ld_comment = document.getElementById('ld_comment').value;
	//let account_name = document.getElementById('account_name').value;
	let emailAddress = document.getElementById('emailAddress').value;
	let lunch_id = document.getElementById('lunch_id'+num).value;
	//alert(account_name);
/* 	alert(ld_comment);
	alert(emailAddress);
	alert(lunch_id); */

	//{変数名：中に入れるもの}みたいに書いて、複数の値をpostData変数に格納
	let postData = {data1:ld_comment,data3:emailAddress,data4:lunch_id,data5:'ld_comment_submit'}


	//非同期通信始めるよ
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.ajax({
		//どのサーブレットに送るか
		//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
		url: '/lunchBox/TimelineServlet',
		//どのメソッドを使用するか
		type:"POST",
		//受け取るデータのタイプ
		dataType:"text",
		//何をサーブレットに飛ばすか（変数を記述）
		data: postData,
		//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
		processDate:false,
		timeStamp: new Date().getTime()
	   //非同期通信が成功したときの処理
	}).done(function(data) {
/* 		alert("成功1"); */
		// 今回は上の<div id="test"></div>の中に返ってきた文字列を入れる
		//document.getElementById("test").innerText=data[0].name;
		location.reload();
	  })
	   //非同期通信が失敗したときの処理
	  .fail(function() {
		//失敗とアラートを出す
/* 		alert("失敗！"); */
	  });
}
</script>


</body>
</html>