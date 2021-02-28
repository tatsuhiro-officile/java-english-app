package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Chat;
import model.GetchatLogic;
import model.PostchatLogic;
import model.Profile;

@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {



    // つぶやきリストを取得して、リクエストスコープに保存
    GetchatLogic getMutterListLogic =
        new GetchatLogic();
    List<Chat> chatList = getMutterListLogic.execute();
    request.setAttribute("chatList", chatList);

    // ログインしているか確認するため
    // セッションスコープからユーザー情報を取得
    HttpSession session = request.getSession();
    Profile loginUser = (Profile) session.getAttribute("userId");
    System.out.println("セッションスコープから情報取得");
    if (loginUser == null) { // ログインしていない
    // リダイレクト
      response.sendRedirect("/application2/");
    } else { // ログイン済み
    // フォワード
      RequestDispatcher dispatcher = request.
          getRequestDispatcher("/WEB-INF/jsp/chat.jsp");
      dispatcher.forward(request, response);
    }
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    // リクエストパラメータの取得
    request.setCharacterEncoding("UTF-8");
    String text = request.getParameter("text");

    System.out.println("text確認");

    // 入力値チェック
    if (text != null && text.length() != 0) {


      // セッションスコープに保存されたユーザー情報を取得
      HttpSession session = request.getSession();
      Profile loginUser = (Profile) session.getAttribute("userId");
      System.out.println(loginUser.getNickName());
      // つぶやきをつぶやきリストに追加
      Chat mutter = new Chat(loginUser.getId(),loginUser.getNickName(), text);
      PostchatLogic postMutterLogic = new PostchatLogic();
      postMutterLogic.execute(mutter);

    } else {
      // エラーメッセージをリクエストスコープに保存
      request.setAttribute("errorMsg2",
          "本当に女性？");
    }
    // つぶやきリストを取得して、リクエストスコープに保存
    GetchatLogic getMutterListLogic =
        new GetchatLogic();
    List<Chat> chatList = getMutterListLogic.execute();
    request.setAttribute("chatList", chatList);

    // フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/WEB-INF/jsp/chat.jsp");
    dispatcher.forward(request, response);
  }
}
