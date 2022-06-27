<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>行きたい場所リスト編集・削除</title>

<!-- <script type="text/javascript" src="js/list_form.js"></script> -->
<link href="css/list_form.css" rel="stylesheet" type="text/css" />

</head>
<body>

<jsp:include page="header.jsp" />

    <header>
    </header>
    <main>
	    <div class="display">
	        <h2 class="list_title">行きたい場所リスト編集・削除</h2>
	        <div class="form_box">
	        	<div class="form_con">
			        <table>
			        <div class="form_table">
				        <form method="post" action="/lunchBox/EditListServlet">
							<tr>
								<input type="hidden" name="EMAIL_ADDRESS" value="${user.emailAddress}">
					            <th><h3>&nbsp;店名&nbsp;<span class="required">必須</span></h3></th>

					            <td><input type="text" name="RES_NAME" placeholder="店舗名(例:鳥貴族 新宿店)まで入力してください" class="form_unit" value="${listResName}" required="required"></td>
					        </tr>
					        <tr>
					            <th><h3>&nbsp;ジャンル</h3></th>

					            <td><select name="category" id="editCategory" class="form_unit">
									<option value="">選択してください</option>
										<option value="和食" <c:if test="${category=='和食' }"> selected </c:if>>和食</option>
										<option value="中華" <c:if test="${category=='中華' }"> selected </c:if>>中華</option>
										<option value="洋食" <c:if test="${category=='洋食' }"> selected </c:if>>洋食</option>
										<option value="イタリアン" <c:if test="${category=='イタリアン' }"> selected </c:if>>イタリアン</option>
										<option value="パン" <c:if test="${category=='パン' }"> selected </c:if>>パン</option>
										<option value="ラーメン" <c:if test="${category=='ラーメン' }"> selected </c:if>>ラーメン</option>
										<option value="その他" <c:if test="${category=='その他' }"> selected </c:if>>その他</option>
							</select></td>
							</tr>
							<tr>
								<th><h3>&nbsp;メモ</h3>※200字以内</th>

					            <td><textarea name="TOGO_MEMO" cols="62" rows="4" placeholder="Add Text" class="form_unit" id="editToGoMemo" >${togoMemo}</textarea><br>
					            </td>
				            </tr>
				            <tr class="hidden">
					            <td colspan="2"><p class="errmsg" id="error_message"><br>${msg}</p>
					            </td>
					        </tr>
					        <tr class="hidden">
					            <td colspan="2">
					            <input type="hidden" name="LIST_ID"  value="${listId}">
					            </td>
				            </tr>

				            </div>
			            </table>
		            <div class="list_button">
			            <input type="submit" name="toGoEdit" value="編集する" >
			            <input type="submit" name="toGoDelete" value="削除する" >
						</div>
		            </form>
			    </div>
	        </div>
		</div>
	</main>
<script>

'use strict';


<%-- let ctgr = window.sessionStorage.getItem(['']); --%>

/* let editCategory = document.getElementById('editCategory');
editCategory.value = 'テスト';
//これいらないかも

let editToGoMemo = document.getElementById('editToGoMemo');
editToGoMemo.value = 'テスト'; */
//これもいらないかも

</script>
</body>
</html>