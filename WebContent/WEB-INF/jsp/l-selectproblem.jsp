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

<div class="centering-block">
 <div class="centering-block-inner">
<form action="L_SelectProblemServlet" method="post">

問題を選択してください
<p>※開始すると音声が流れます。</p>
<select name="select_problem">

<option value=7>基礎英語1</option>
<option value=8>基礎英語2</option>
<option value=9>基礎英語3</option>
<option value=10>基礎英語4</option>
<option value=11>ビジネス英語1</option>
<option value=12>ビジネス英語2</option>
</select>



<p><input type="submit" value="選択する"></p>
</form>

<p>
<c:if test="${userId.problem7==0}">
01：基礎英語1
</c:if>
<c:if test="${userId.problem7>0}">
01：基礎英語1<span class="blue">★クリア</span>
</c:if>
<p>
<p>
<c:if test="${userId.problem8==0}">
02：基礎英語2
</c:if>
<c:if test="${userId.problem8>0}">
02：基礎英語2<span class="blue">★クリア</span>
</c:if>
<p>
<c:if test="${userId.problem9==0}">
03：基礎英語3
</c:if>
<c:if test="${userId.problem9>0}">
03：基礎英語3<span class="blue">★クリア</span>
</c:if>
</p>
<p>
<c:if test="${userId.problem10==0}">
04：基礎英語4
</c:if>
<c:if test="${userId.problem10>0}">
04：基礎英語4<span class="blue">★クリア</span>
</c:if>
</p>
<p>
<c:if test="${userId.problem11==0}">
05：ビジネス英語1
</c:if>
<c:if test="${userId.problem11>0}">
05：ビジネス英語1<span class="blue">★クリア</span>
</c:if>
</p>
<p>
<c:if test="${userId.problem12==0}">
06：ビジネス英語2
</c:if>
<c:if test="${userId.problem12>0}">
06：ビジネス英語2<span class="blue">★クリア</span>
</c:if>
</p>
</div>
</div>



</body>
</html>