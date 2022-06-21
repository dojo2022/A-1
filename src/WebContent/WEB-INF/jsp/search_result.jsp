<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/timeline.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="header.jsp" />
<main>
テストだよおお
<c:forEach var="e" items="${searchLunch}" >
<form method="POST" action="TimelineServlet">
	${e.accountName}<br>
	${e.ldFoodType}<br>
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
		<input type="submit" name="" value="送信する"><br>
	<c:forEach var="lr" items="${ldReactionList}">
		${lr.ldToGo}
		${lr.ldToTell}
		${lr.ldToUse}<br>
	</c:forEach>
		<input type="button" name="ToGo" value="行きたい">
		<input type="button" name="ToTellMe" value="教えて">
		<input type="button" name="ToUseidea" value="参考にします"><br>
</form>
</c:forEach>
</main>
</body>
</html>