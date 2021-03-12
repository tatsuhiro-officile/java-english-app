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
<p>本日完了した問題を選択して学習報告をして下さい</p>
<form action="ChatServlet" method="post">

<c:if test="${done.reading>0}">
■本日のリーディング完了
</c:if>
<c:if test="${done.writeing>0}">
■本日のライティング完了
</c:if>
<c:if test="${done.listning>0}">
■本日のリスニング完了
</c:if>




<p>学習コメント</p>
<p><input type="text" name="text"></p>
<input type="submit" value="学習報告">

</form>

<hr>
<c:if test="${not empty errorMsg2}">
<p>${errorMsg2}</p>
</c:if>
<c:forEach var="mutter" items="${chatList}">
　 <p><c:out value="${mutter.name}" /> <c:out value="${mutter.time}" /></p>
   <p><c:out value="${mutter.text}" /></p>

   <hr>
</c:forEach>
</body>
</html>