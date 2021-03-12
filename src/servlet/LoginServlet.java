package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Done;
import model.DoneLogic;
import model.Login;
import model.LoginLogic;
import model.Loginfailure;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)

      throws ServletException, IOException {

	  HttpSession session = request.getSession();
  	String failuremassage ="";
  	Loginfailure loginresult = new Loginfailure(failuremassage);
  	session.setAttribute("failure", loginresult);

  	session.removeAttribute("userId");





    // フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/WEB-INF/jsp/login.jsp");
    dispatcher.forward(request, response);
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	  request.setCharacterEncoding("UTF-8");
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
    	DoneLogic donelogic = new DoneLogic();
    	Done done= donelogic.select_done(result);


    	session.setAttribute("done", done);






      session.setAttribute("userId", result);


      // フォワード
      RequestDispatcher dispatcher =
          request.getRequestDispatcher("MainServlet");
      dispatcher.forward(request, response);
    } else {
    	String failuremassage ="ログインに失敗しました、IDとパスワードをご確認ください";
    	Loginfailure loginresult = new Loginfailure(failuremassage);


    	session.setAttribute("failure", loginresult);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
    }
  }
}