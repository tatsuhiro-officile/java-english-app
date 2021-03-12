<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<c:out value="${userId.nickName}" />さん、ログイン中
<a href="MainServlet">戻る</a>
</p>

<c:if test="${problemview==0}">
<form action="CheckproblemServret" method="post">
<p>
<select name="select_problem">
<option value=1>基礎英語1</option>
<option value=2>基礎英語2</option>
<option value=3>基礎英語3</option>
<option value=4>旅行英語1</option>
<option value=5>ビジネス英語1</option>
<option value=6>基礎英語4</option>
</select>
<input type="hidden" name="problemview" value=1>
</p>
<p><input type="submit" value="確認開始"></p>
</form>

</c:if>


<c:if test="${problemview>0}">
<c:out value="${mondainumber+1}" />問目
<c:out value="${checklist[mondainumber].no1}" />
<c:out value="${checklist[mondainumber].no2}" />
<c:out value="${checklist[mondainumber].no3}" />

<c:if test="${checklist[mondainumber].word>3}">
<c:out value="${checklist[mondainumber].no4}" />
</c:if>
<c:if test="${checklist[mondainumber].word>4}">
<c:out value="${checklist[mondainumber].no5}" />
</c:if>
<c:if test="${checklist[mondainumber].word>5}">
<c:out value="${checklist[mondainumber].no6}" />
</c:if>
<c:if test="${checklist[mondainumber].word>6}">
<c:out value="${checklist[mondainumber].no7}" />
</c:if>
<c:if test="${checklist[mondainumber].word>7}">
<c:out value="${checklist[mondainumber].no8}" />
</c:if>
<c:if test="${checklist[mondainumber].word>8}">
<c:out value="${checklist[mondainumber].no9}" />
</c:if>
<c:if test="${checklist[mondainumber].word>9}">
<c:out value="${checklist[mondainumber].no10}" />
</c:if>
<c:if test="${checklist[mondainumber].word>10}">
<c:out value="${checklist[mondainumber].no11}" />
</c:if>
<c:if test="${checklist[mondainumber].word>11}">
<c:out value="${checklist[mondainumber].no12}" />
</c:if>
<c:if test="${checklist[mondainumber].word>12}">
<c:out value="${checklist[mondainumber].no13}" />
</c:if>
<c:if test="${checklist[mondainumber].word>13}">
<c:out value="${checklist[mondainumber].no14}" />
</c:if>
<c:if test="${checklist[mondainumber].word>14}">
<c:out value="${checklist[mondainumber].no15}" />
</c:if>

<c:if test="${checklist[mondainumber].quations== 0}">
.
</c:if>
<c:if test="${checklist[mondainumber].quations== 1}">
?
</c:if>

<form action="CheckproblemServret" method="post">
<input type="hidden" name="problemview" value=2>

<p><input type="submit" value="日本語確認"></p>
</form>
</c:if>

<c:if test="${problemview==2}">
<c:out value="${checklist[mondainumber].japanese}" />
<form action="CheckproblemServret" method="post">
<input type="hidden" name="problemview" value="3">
<p><input type="submit" value="次へ"></p>
</form>
</c:if>
<c:if test="${checkfinal==1}">
終了！
</c:if>

</body>
</html>