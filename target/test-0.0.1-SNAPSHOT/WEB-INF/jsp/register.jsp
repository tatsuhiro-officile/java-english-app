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
<p>登録する</p>




<form action="RegisterServlet" method="post">

オリジナルID
<input type="text" name="ORIGINALID">
パスワード
<input type="text" name="PASS">
ニックネーム
<input type="text" name="NICKNAME">
<input type="submit" value="登録する">
</form>
<c:if test="${registerdone>0}">
<c:out value="${duplicateoriginalid}" />は既に登録されている

登録完了
</c:if>


<a href="/application2/">戻る</a>

</body>
</html>