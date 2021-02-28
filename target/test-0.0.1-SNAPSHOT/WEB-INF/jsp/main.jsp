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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value="${userId.getNickName()}" />
<a href="ChatServlet">チャットへ</a>
<a href="RegisterServlet">問題へ</a>
<a href="RegisterServlet">登録</a>
</body>
</html>