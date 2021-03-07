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

<div class="centering-block">
 <div class="centering-block-inner">
<form action="LoginServlet" method="post">
&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="originalid"><br>
パスワード<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>

</div>
 </div>
 <c:out value="${failure.getLoginfailure()}" />
<p class="right">
<a href="/application2/">戻る</a>
</p>
</body>
</html>