<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
<link rel="stylesheet" href="index.css" />
</head>
<body>
<div class="flex">
<div class="flex__inner">
<p>English brain</p>
<p><img src="${pageContext.request.contextPath}/pic/brain.jpeg" alt="リスト" class ="img_icon">


</div>
<div class="flex__inner">
<p><a href="RegisterServlet">新規登録</a></p>
<p>&nbsp;&nbsp;&nbsp;</p>
<p><a href="LoginServlet">ログイン</a></p>
</div>
</div>

<div class ="colored">
<h1 class="center">繰り返し行う英語脳作り</h1>
</div>
<p class="center">IDとパスワードを入力して下さい</p>
<div class="centering-block">
 <div class="centering-block-inner">

<form action="LoginServlet" method="post">
<p class="center">
&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="originalid"><br>
<br>
パスワード<input type="password" name="pass"></p><br>
<p class="center">
<input type="submit" value="login"></p>
</form>

</div>
 </div>
 <p class="center"><c:out value="${failure.getLoginfailure()}" /></p>













<p class ="center">
<img src="${pageContext.request.contextPath}/pic/index.jpg" alt="リスト" class ="img">
</p>

<div class ="colored">
<h1 class="center">英語脳を手に入れよう</h1>
</div>

</body>
</html>