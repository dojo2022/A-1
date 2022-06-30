<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果|LunchBox</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="js/timeline.js"></script>
<link href="css/timeline.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="header.jsp" />
<main>
<input type="hidden" name="mailAddress" id="emailAddress" value="${user.emailAddress}">
<c:forEach var="e" items="${searchLunch}" varStatus="status">
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
<c:forEach var="e" items="${handmade}" >
<form method="POST" action="TimelineServlet">
		${e.handmadeId}<br>
		${e.accountName}<br>
		${e.emailAddress}<br>
		${e.hdFoodPhoto}<br>
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
	<input type="submit" name="submit" value="送信する"><br>
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
</main>
</body>
</html>