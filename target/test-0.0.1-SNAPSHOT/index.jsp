<%-- リスト10-6の状態 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶへようこそ</h1>
<form action="Login" method="post">
ユーザー名：<input type="text" name="name"><br>
パスワード：<input type="password" name="pass"><br>
あなたの性別<input type="text" name="sex"><br>
<input type="submit" value="入る">

<a href="LoginServlet">ログイン</a>
<a href="RegisterServlet">登録</a>
</form>
</body>
</html>