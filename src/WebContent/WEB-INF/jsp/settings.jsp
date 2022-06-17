<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>設定</title>

<script type="text/javascript" src="js/settings.js"></script>
<link href="css/settings.css" rel="stylesheet" type="text/css" />

</head>
<jsp:include page="header.jsp" />
<body>
<h1>設定</h1>



<!--< var="e" items="${cardList}" -->
	<form action="/lunchBox/SettingsServlet" method="post" enctype="multipart/form-data">




	<table class="tableForm" 	>

		<tr>
			<th colspan="2">
				<input type="file" name="icon" accept="image/*" onchange="previewImage(this);"><br>
			</th>
			<div class="center">
			<canvas id="preview" style="max-width:200px;"></canvas>
			</div>
		</tr>
		<tr>
			<td class="tableLeft">
				名前<br><input type="text" name="accountName" value="${e.accountName}">
			</td>
			<td>
				パスワード<br><input type="password" name="pw" value="${e.pw}">
			</td>
	 	</tr>
	 	<tr>
			<td class="tableLeft">
				部署名<br><input type="text" name="depName" value="${e.depname}">
			</td>
			<td>
				パスワード確認用<br><input type="password" name="pwCheck" value="${e.pwCheck}">
			</td>
		</tr>
	 	<tr>
	 		<td class="tableLeft">
	 			メールアドレス<br><input type="email" name="emailAddress" value="${e.emailAddress}" readOnly>
	 		</td>
			<td>
				公開設定<br>
				<c:if test="${e.range == 1 }">
					<input class="koukai" type="radio" name="range" value="1" id="one" checked >
					<label for="one">公開</label>
		 			<input type="radio" name="range" value="0"id="two" >
		  		    <label for="two">非公開</label>
	  		    </c:if>
	  		    <c:if test="${e.range == 0 }">
					<input class="koukai" type="radio" name="range" value="1" id="one"  >
					<label for="one">公開</label>
		 			<input type="radio" name="range" value="0"id="two" checked>
		  		    <label for="two">非公開</label>
	  		    </c:if>
	  		    	<!-- この下の４行はあとで消します -->
	  		   		 <input class="koukai" type="radio" name="range" value="1" id="one"checked  >
					<label for="one">公開</label>
		 			<input type="radio" name="range" value="0"id="two" >
		  		    <label for="two">非公開</label>
	  		</td>
		</tr>
	</table>


<%--
		<input type="radio" name="range" value="${e.range}"id="one">
		<label for="one">公開</label>
		<input type="radio" name="range" value="${e.range}"id="two">
		<label for="two">非公開</label> --%>





<div class="kousin">
<input type="submit" name="SUBMIT" value="更新する">
</div>
<div >
<p><a href="/lunchBox/LeaveServlet" class="leave">退会する方はこちら</a></p>
</div>








	</form>






</body>
</html>