<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="model.Profile"%>


<%
Profile userinfomation = (Profile) session.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="index.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p class="center">ようこそ<c:out value="${userId.getNickName()}" />さん</p>

<div class="centering-block">
 <div class="centering-block-inner">
<a href="ChatServlet">チャットへ</a><br>
<a href="SelectProblem">問題へ</a><br>
</div>
 </div>
</body>
</html>