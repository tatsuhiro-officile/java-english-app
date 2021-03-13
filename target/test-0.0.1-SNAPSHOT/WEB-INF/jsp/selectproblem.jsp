<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Profile"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
Profile userinfomation = (Profile) session.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>問題選択</title>
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
<p> <a href="SelectProblem">Writing・Listening</a></p>
<p>&nbsp;&nbsp;&nbsp;</p>
<p> <a href="ChatServlet">みんなの学習記録</a></p>

</div>
</div>
<hr>

<div class="centering-block">
 <div class="centering-block-inner">
<form action="SelectProblem" method="post">

問題を選択してください
<p>
<select name="select_problem">
<option value=1>基礎英語1</option>
<option value=2>基礎英語2</option>
<option value=3>基礎英語3</option>
<option value=4>旅行英語1</option>
<option value=5>ビジネス英語1</option>
<option value=6>基礎英語4</option>
<option value=7>基礎英語1リスニング</option>
<option value=8>基礎英語2リスニング</option>
<option value=9>基礎英語3リスニング1</option>
<option value=10>旅行英語1リスニング</option>
<option value=11>ビジネス英語1リスニング</option>
<option value=12>基礎英語4リスニング</option>
</select>
</p>


<p><input type="submit" value="送信する"></p>
</form>



<p>
<c:if test="${userId.problem1==0}">
01：基礎英語1
</c:if>
<c:if test="${userId.problem1>0}">
01：基礎英語1クリア
</c:if>
</p>
<p>
<c:if test="${userId.problem2==0}">
02：基礎英語2
</c:if>
<c:if test="${userId.problem2>0}">
02：基礎英語2クリア
</c:if>
</p>
<p>
<c:if test="${userId.problem3==0}">
03：基礎英語3
</c:if>
<c:if test="${userId.problem3>0}">
03：基礎英語3クリア
</c:if>
</p>
<p>
<c:if test="${userId.problem4==0}">
04：旅行英語1
</c:if>
<c:if test="${userId.problem4>0}">
04：旅行英語1クリア
</c:if>
</p>
<p>
<c:if test="${userId.problem5==0}">
05：ビジネス英語1
</c:if>
<c:if test="${userId.problem5>0}">
05：ビジネス英語1クリア
</c:if>
</p>
<p>
<c:if test="${userId.problem6==0}">
06：基礎英語4
</c:if>
<c:if test="${userId.problem6>0}">
06：基礎英語4クリア
</c:if>
</p>
<p>
<c:if test="${userId.problem7==0}">
07：基礎英語1リスニング
</c:if>
<c:if test="${userId.problem7>0}">
07：基礎英語1リスニングクリア
</c:if>
<p>
<p>
<c:if test="${userId.problem8==0}">
08：基礎英語2リスニング
</c:if>
<c:if test="${userId.problem8>0}">
08：基礎英語2リスニングクリア
</c:if>
<p>
<c:if test="${userId.problem9==0}">
09：基礎英語3リスニング
</c:if>
<c:if test="${userId.problem9>0}">
09：基礎英語3リスニング
</c:if>
</p>
<p>
<c:if test="${userId.problem10==0}">
10：旅行英語1
</c:if>
<c:if test="${userId.problem10>0}">
10：旅行英語1クリア
</c:if>
</p>
<p>
<c:if test="${userId.problem11==0}">
11：ビジネス英語1リスニング
</c:if>
<c:if test="${userId.problem11>0}">
11：ビジネス英語1リスニングクリア
</c:if>
</p>
<p>
<c:if test="${userId.problem12==0}">
12：基礎英語4リスニング
</c:if>
<c:if test="${userId.problem12>0}">
12：基礎英語4リスニングクリア
</c:if>
</p>
</div>
</div>



</body>
</html>