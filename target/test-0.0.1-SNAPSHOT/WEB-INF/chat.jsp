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
<p>
<c:out value="${userId.nickName}" />さん、ログイン中
<a href="MainServlet">戻る</a>
</p>

<p><a href="ChatServlet">更新</a></p>
<form action="ChatServlet" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>

<c:if test="${not empty errorMsg2}">
<p>${errorMsg2}</p>
</c:if>
<c:forEach var="mutter" items="${chatList}">
　 <p><c:out value="${mutter.name}" />
   <c:out value="${mutter.text}" /></p>
</c:forEach>
</body>
</html>