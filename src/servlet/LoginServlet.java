package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)

      throws ServletException, IOException {

	  HttpSession session = request.getSession();
  	String failure ="";
  	session.setAttribute("failure", failure);

    // フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/WEB-INF/jsp/login.jsp");
    dispatcher.forward(request, response);
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    // リクエストパラメータの取得
    request.setCharacterEncoding("UTF-8");
    String originalid = request.getParameter("originalid");
    String pass = request.getParameter("pass");
    int id=0;
    int point =0;
    String nickname =null;




    // ログイン処理の実行
    Login login = new Login(id, originalid,nickname, pass,point);
    LoginLogic bo = new LoginLogic();
    model.Profile result = bo.execute(login);

    HttpSession session = request.getSession();

    // ログイン処理の成否によって処理を分岐
    if (result != null) { // ログイン成功時


      // セッションスコープにユーザーIDを保存

      session.setAttribute("userId", result);


      // フォワード
      RequestDispatcher dispatcher =
          request.getRequestDispatcher("MainServlet");
      dispatcher.forward(request, response);
    } else {

    	String failure ="登録はありませんでした,ID パスワードをご確認ください";
    	session.setAttribute("failure", failure);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
    }
  }
}