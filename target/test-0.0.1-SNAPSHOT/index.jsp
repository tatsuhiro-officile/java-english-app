<%-- リスト10-6の状態 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>英語学習サイト</title>
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



<div class ="center">

<p>Reading・Listening・riting訓練が出来る</p>
<p>アウトプットで英語脳を作る</p>

<p>Learning reportで学習の記録・みんなで共有が出来る</p>


</div>







<p class ="center">
<img src="${pageContext.request.contextPath}/pic/index.jpg" alt="リスト" class ="img">
</p>
<div class ="colored">
<h1 class="center">英語脳を手に入れよう</h1>
</div>


</body>
</html>