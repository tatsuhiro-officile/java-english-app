<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<% User findedUser = (User) request.getAttribute("findedUser"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>TestApp</title>
    </head>
    <body>
        <div>
            <h3>メインページ</h3>
            <p>ようこそ<strong><%= findedUser.getNickName() %></strong>さん</p>
        </div>

<textarea id="text">再生する内容</textarea>
<button id="speak-btn">再生</button>

<script>
  const text     = document.querySelector('#text')
  const speakBtn = document.querySelector('#speak-btn')

  speakBtn.addEventListener('click', function() {
    // 発言を作成
    const uttr = new SpeechSynthesisUtterance(text.value)

    uttr.lang = "en-GB"
    speechSynthesis.speak(uttr)
  })
</script>
</body>
</html>
