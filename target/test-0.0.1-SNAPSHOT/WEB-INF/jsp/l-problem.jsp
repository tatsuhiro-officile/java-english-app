<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% int view_mondaisuu =  (int) session.getAttribute("mondaisuu") +1; %>
<% int mondaisuu =  (int) session.getAttribute("mondaisuu"); %>
<% int seikaisuu =  (int) session.getAttribute("seikaisuu"); %>
<% int machigaisuu = 19-seikaisuu;%>
<%@ page import="model.Onsei,java.util.List" %>










<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listening</title>
<link rel="stylesheet" href="index.css" />
</head>
<body>


<div class="flex">
<div class="flex__inner">
<p>English brain</p>
<p><img src="${pageContext.request.contextPath}/pic/brain.jpeg" alt="リスト" class ="img_icon">

</div>
<div class="flex__inner">
<p><a href="MainServlet">Main</a></p>
<p>&nbsp;&nbsp;&nbsp;</p>
<p><a href="CheckproblemServret">Reading</a></p>
<p>&nbsp;&nbsp;&nbsp;</p>
<p> <a href="SelectProblem">Writing</a></p>
<p>&nbsp;&nbsp;&nbsp;</p>
<p> <a href="L_SelectProblemServlet">Listening</a></p>
<p>&nbsp;&nbsp;&nbsp;</p>
<p> <a href="ChatServlet">Learning report</a></p>
<p>&nbsp;&nbsp;&nbsp;</p>
<p> <a href="LogoutServlet" onclick="return confirm('本当にログアウトしてもよろしいですか？');">Logout</a></p>

</div>
</div>
<hr>



<div class ="center">
<c:if test="${startstop==0}">
<p><a href="ProblemServlet">開始</a></p>

</c:if>

<p>

<c:if test="${startstop>0}">
<p>聴き取った、文章を入力してください</p>

<c:if test="${mondaisuu <20}">
問題<%= view_mondaisuu%>

</c:if>
<c:if test="${mondaisuu>19}">
<p>問題<%= mondaisuu%></p>

</c:if>
<br><br>


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







<br>
<br>
<c:if test="${startstop>0}">
<c:if test="${mondaisuu <20}">
<form action="AnswerServlet" method="post" autocomplete="off">
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
<c:if test="${one_game_problemlist[mondaisuu].getWord()>13}">
<input type="text" name="input_no14">
</c:if>
<c:if test="${one_game_problemlist[mondaisuu].getWord()>14}">
<input type="text" name="input_no15">
</c:if>
<input type="hidden" name="onemore" value="2">
<br><br>
<input type="submit" value="答える">
</form><br>


</c:if>
</c:if>
</div>
<div class="left">
<form action="AnswerServlet" method="post">
<input type="hidden" name="onemore" value="1">


<input type="submit" value="もう１回聴く">


</form>
</div>










<div class="center">
<p>${kekka}</p>
<c:if test="${mondaisuu>=20}">
<c:if test="${machigai>0}">
<%= mondaisuu%>中<%= seikaisuu%>正解<br><br><br>

<c:forEach var="i" begin="0" end="<%= machigaisuu%>" step="1">
<hr>
間違え箇所:<c:out value="${machigailist[i].no1}"/>&nbsp;<c:out value="${machigailist[i].no2}"/>&nbsp;<c:out value="${machigailist[i].no3}"/>&nbsp;
<c:out value="${machigailist[i].no4}"/>&nbsp;<c:out value="${machigailist[i].no5}"/>&nbsp;<c:out value="${machigailist[i].no6}"/>&nbsp;<c:out value="${machigailist[i].no7}"/>&nbsp;<c:out value="${machigailist[i].no8}"/>&nbsp;<c:out value="${machigailist[i].no9}"/>
<c:out value="${machigailist[i].no11}"/>&nbsp;<c:out value="${machigailist[i].no12}"/>&nbsp;<c:out value="${machigailist[i].no13}"/>&nbsp;<c:out value="${machigailist[i].no14}"/>&nbsp;<c:out value="${machigailist[i].no15}"/><br><br>

正解の文章:<c:out value="${kaitoulist[i].no1}"/>&nbsp;<c:out value="${kaitoulist[i].no2}"/>&nbsp;<c:out value="${kaitoulist[i].no3}"/>&nbsp;<c:out value="${kaitoulist[i].no4}"/>&nbsp;<c:out value="${kaitoulist[i].no5}"/>&nbsp;<c:out value="${kaitoulist[i].no6}"/>
<c:out value="${kaitoulist[i].no7}"/>&nbsp;<c:out value="${kaitoulist[i].no8}"/>&nbsp;<c:out value="${kaitoulist[i].no9}"/>&nbsp;<c:out value="${kaitoulist[i].no10}"/>&nbsp;<c:out value="${kaitoulist[i].no11}"/>&nbsp;<c:out value="${kaitoulist[i].no12}"/>
<c:out value="${kaitoulist[i].no13}"/>&nbsp;<c:out value="${kaitoulist[i].no14}"/>&nbsp;<c:out value="${kaitoulist[i].no15}"/><br>

<hr>
</c:forEach>
</c:if>
<c:if test="${machigai==0}">
(*ﾟ▽ﾟ)/ﾟ･:*【祝】*:･ﾟ＼(ﾟ▽ﾟ*)全問正解
</c:if>
<a href="OnemoreServlet">もう１回やる</a>
</c:if>
</div>

<script>
  // 発言を作成
  const uttr = new SpeechSynthesisUtterance("${onseilist[mondaisuu].onsei}")
  // 発言を再生 (発言キューに発言を追加)
  uttr.lang = "en-US"
  speechSynthesis.speak(uttr)
</script>







</body>
</html>