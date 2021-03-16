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
<div class="center">
<p>
<c:out value="${userId.nickName}" />さん、お疲れ様です。


本日の学習の報告をお願いします。</p>
<form action="ChatServlet" method="post">

<p>
<span class="shitasen">本日の学習結果:</span><br>
<c:if test="${done.reading>0}">
★本日のリーディング完了しています。
</c:if>
<c:if test="${done.writeing>0}">
★本日のライティング完了しています。
</c:if>
<c:if test="${done.listning>0}">
★本日のリスニング完了しています。
</c:if>
</p>




<p>一言コメント:<input type="text" name="text"></p>
<input type="submit" value="学習報告">

</form>
</div>
<div class="center">

<c:if test="${not empty errorMsg2}">
<p>${errorMsg2}</p>
</c:if>
<hr>
<c:forEach var="mutter" items="${chatList}">
　 <p><c:out value="${mutter.name}" /> <c:out value="${mutter.time}" /></p>
   <p><c:out value="${mutter.text}" /></p>

   <hr>
</c:forEach>
</div>
</body>
</html>