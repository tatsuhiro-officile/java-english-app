<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User,model.Mutter,java.util.List" %>
<%User loginUser = (User) session.getAttribute("loginUser");
List<Mutter> mutterList =
(List<Mutter>) application.getAttribute("mutterList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォワードのサンプル</title>
</head>
<body>
<h1>フォワードのサンプル</h1>
<p>フォワードされたページです</p>
<p><%= loginUser.getName() %>さん、ログイン中</p>

<% for(Mutter mutter : mutterList){%>
<p><%=mutter.getUserName()%>：<%=mutter.getText()%>
:<%=mutter.getText2() %>
</p>
<% } %>
</body>
</html>