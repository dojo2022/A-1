<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果|LunchBox</title>
<link href="css/timeline.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="header.jsp" />
<main>
<c:forEach var="e" items="${searchLunch}" >
<form method="POST" action="TimelineServlet">
	${e.accountName}<br>
	${e.ldResName}<br>
	${e.ldFoodPhoto}<br>
	${e.ldCategory}<br>
	${e.style}<br>
	${e.ldDate}<br>
	${e.ldFoodName}<br>
	${e.ldCost}<br>
	${e.time}<br>
	${e.distance}<br>
	${e.ldStar}<br>
	${e.ldFeeling}<br>
  	<input type="hidden" name="lunch_id" value="${e.lunchId}">
	<c:forEach var="lc" items="${LdComment}">
	<c:if test="${lc.lunchId == e.lunchId}">
		${lc.accountName}：
		${lc.ldComment}<br>
	</c:if>
	</c:forEach>
		<input type="text" name="ld_comment" placeholder="コメントを入力してください">
		<input type="submit" name="submit" value="送信する"><br>
	<c:forEach var="lr" items="${ldReactionList}">
	<c:if test="${lr.lunchId == e.lunchId}">
		${lr.countLdToGo}|
		${lr.countLdToTell}|
		${lr.countLdToUse}|
	</c:if>
	</c:forEach>
		<input type="submit" name="to" value="行きたい">
		<input type="submit" name="to" value="教えて">
		<input type="submit" name="to" value="参考にします"><br>
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