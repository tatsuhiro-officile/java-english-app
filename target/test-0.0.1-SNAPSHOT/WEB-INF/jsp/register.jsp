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
<h1 class="center">新規登録</h1>

<p>登録する、IDとパスワード、ニックネームを入力して下さい</p>
<p>ニックネームは学習報告に標示される名前です。</p>









<div class="centering-block">
 <div class="centering-block-inner">
<form action="RegisterServlet"  method="post">
<div>
登録ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="ORIGINALID">
</div>
<div>
パスワード&nbsp;&nbsp;&nbsp;
<input type="text" name="PASS">
</div>
<div>
ニックネーム
<input type="text" name="NICKNAME">
</div>

<input type="submit" value="登録する">
</form>
</div>
 </div>

<c:if test="${registerdone>0}">
<c:out value="${duplicateoriginalid}"/>
</c:if>


<p class="right">
<a href="/application2/">戻る</a>
</p>

</body>
</html>