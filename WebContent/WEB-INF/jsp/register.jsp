<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
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


<p class="center">登録する、IDとパスワード、ニックネームを入力して下さい</p>
<p class="center">ニックネームは学習報告に標示される名前です。</p><br>









<div class="centering-block">
 <div class="centering-block-inner">
<form action="RegisterServlet"  method="post">
<div>
<p class="center">■登録ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="ORIGINALID">
</p>
</div>
<div>
<p class="center">■パスワード&nbsp;&nbsp;&nbsp;
<input type="text" name="PASS">
</p>
</div>
<div>
<p class="center">■ニックネーム
<input type="text" name="NICKNAME">
</p>
</div>
<br>
<input type="submit" value="登録する">
</form>
</div>
 </div>

<c:if test="${registerdone>0}">
<p class ="center"><c:out value="${duplicateoriginalid}"/></p>
</c:if>









<p class ="center">
<img src="${pageContext.request.contextPath}/pic/index.jpg" alt="リスト" class ="img">
</p>
<div class ="colored">
<h1 class="center">英語脳を手に入れよう</h1>
</div>

</body>
</html>