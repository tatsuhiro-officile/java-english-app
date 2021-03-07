<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% int view_mondaisuu =  (int) session.getAttribute("mondaisuu") +1; %>
<% int mondaisuu =  (int) session.getAttribute("mondaisuu"); %>
<% int seikaisuu =  (int) session.getAttribute("seikaisuu"); %>
<% int machigaisuu = 19-seikaisuu;%>









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
<a href="SelectProblem">戻る</a>
</p>

<c:if test="${startstop==0}">
<p><a href="ProblemServlet">開始</a></p>
</c:if>

<p>

<c:if test="${startstop>0}">

<p><c:out value="${one_game_problemlist[mondaisuu].getJapanese()}"/></p>

<c:forEach var="e" begin="1" end="${one_game_problemlist[mondaisuu].getWord()}" step="1">
_____________
<c:if test="${one_game_problemlist[mondaisuu].comma== e}">
,
</c:if>




</c:forEach>
<c:if test="${one_game_problemlist[mondaisuu].quations== 0}">
.
</c:if>
<c:if test="${one_game_problemlist[mondaisuu].quations== 1}">
?
</c:if>

</c:if>
</p>


<c:if test="${mondaisuu <20}">
問題<%= view_mondaisuu%>

</c:if>
<c:if test="${mondaisuu>19}">
<p>問題<%= mondaisuu%></p>

</c:if>




<br>
<br>
<c:if test="${startstop>0}">
<c:if test="${mondaisuu <20}">
<form action="AnswerServlet" method="post">
<input type="text" name="input_no1">
<input type="text" name="input_no2">
<input type="text" name="input_no3">
<c:if test="${one_game_problemlist[mondaisuu].getWord()>3}">
<input type="text" name="input_no4">
</c:if>
<c:if test="${one_game_problemlist[mondaisuu].getWord()>4}">
<input type="text" name="input_no5">
</c:if>
<c:if test="${one_game_problemlist[mondaisuu].getWord()>5}">
<input type="text" name="input_no6">
</c:if>
<c:if test="${one_game_problemlist[mondaisuu].getWord()>6}">
<input type="text" name="input_no7">
</c:if>
<c:if test="${one_game_problemlist[mondaisuu].getWord()>7}">
<input type="text" name="input_no8">
</c:if>
<c:if test="${one_game_problemlist[mondaisuu].getWord()>8}">
<input type="text" name="input_no9">
</c:if>
<c:if test="${one_game_problemlist[mondaisuu].getWord()>9}">
<input type="text" name="input_no10">
</c:if>
<c:if test="${one_game_problemlist[mondaisuu].getWord()>10}">
<input type="text" name="input_no11">
</c:if>
<c:if test="${one_game_problemlist[mondaisuu].getWord()>11}">
<input type="text" name="input_no12">
</c:if>
<c:if test="${one_game_problemlist[mondaisuu].getWord()>12}">
<input type="text" name="input_no13">
</c:if>
<c:if test="${one_game_problemlist[mondaisuu].getWord()>12}">
<input type="text" name="input_no14">
</c:if>
<c:if test="${one_game_problemlist[mondaisuu].getWord()>12}">
<input type="text" name="input_no15">
</c:if>
<input type="hidden" name="onemore" value="2">
<input type="submit" value="答える">


</form>
</c:if>

</c:if>





<p>${kekka}</p>
<c:if test="${mondaisuu>=20}">
<c:if test="${machigai>0}">
<%= mondaisuu%>中<%= seikaisuu%>正解<br><br><br>

<c:forEach var="i" begin="0" end="${machigai}" step="1">
------------------------------------------<br>
間違え:<c:out value="${machigailist[i].no3}"/><br>
正解:<c:out value="${kaitoulist[i].no3}"/><br>
------------------------------------------<br>
</c:forEach>
</c:if>
<c:if test="${machigai==0}">
(*ﾟ▽ﾟ)/ﾟ･:*【祝】*:･ﾟ＼(ﾟ▽ﾟ*)全問正解
</c:if>
<a href="OnemoreServlet">もう１回やる</a>
</c:if>













</body>
</html>