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

 <a href="CheckproblemServret">リーティング</a><br>

 <a href="SelectProblem">ライティング、リスニング</a><br>
<a href="ChatServlet">チャットへ</a><br>
<img src="index.jpg" alt="hi" title="TOP画像">


<p>学習のやり方</p>

 <table border="1" >
    <tr>
      <td>1:</td>
      <td>まずはリーディングで問題の確認</td>
    </tr>
    <tr>
      <td>2:</td>
      <td>リスニングとライティングを繰り返す。</td>
    </tr>
    <tr>
      <td>3:</td>
      <td>1週間経過したら、別問題へ</td>
    </tr>
  </table>

  <p>ポイントは、１週間くらい自分の出来る量の同じ問題を繰り返す</p>
    <p>毎日違う問題はやらない</p>

</div>
 </div>

 勉強回数<c:out value="${userId.getPoint()}" />





</body>
</html>