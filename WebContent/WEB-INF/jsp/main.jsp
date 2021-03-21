<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="model.Profile"%>


<%
Profile userinfomation = (Profile) session.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="index.css" />
<meta charset="UTF-8">
<title>Main page</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>

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

<p class="center">ようこそ<c:out value="${userId.getNickName()}" />さん</p>
<p class="center"> 現在の勉強（Writing/Listening）回数は<c:out value="${userId.getPoint()}" />回です。</p>

<div class="centering-block">
 <div class="centering-block-inner">




 <table border="1" class="center">
     <tr>
      <td></td>
      <td>学習の進め方</td>
    </tr>
    <tr>
      <td>1:</td>
      <td>まずはReadingで問題の確認</td>
    </tr>
    <tr>
      <td>2:</td>
      <td>確認した問題のWritingに挑戦</td>
    </tr>
    <tr>
      <td>3:</td>
      <td>確認した問題のListeningに挑戦</td>
    </tr>
        <tr>
      <td>4:</td>
      <td>WritingとListeningがクリアになれば次の問題へ</td>
    </tr>
  </table>


</div>
 </div>







</body>
</html>