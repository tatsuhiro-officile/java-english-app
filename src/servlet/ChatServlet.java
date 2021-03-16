package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Chat;
import model.Done;
import model.DoneLogic;
import model.Done_update_Logic;
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

	DoneLogic donelogic = new DoneLogic();
	Done done= donelogic.select_done(loginUser);


	session.setAttribute("done", done);




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

    HttpSession session = request.getSession();

    Done done = (Done) session.getAttribute("done");


    int effort = done.getListning() + done.getReading() + done.getWriteing();



	if(done.getListning()>0) {
		text = text + " "+"★リスニング達成";

	}
	if(done.getReading()>0) {
		text = text + " "+"★リーディング達成";

	}
	if(done.getWriteing()>0) {
		text = text + " "+"★ライティング達成";

	}




    		if(effort>0) {


    			Profile loginUser = (Profile) session.getAttribute("userId");
    			LocalDateTime localDateTime = LocalDateTime.now();
    			DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy/MM/dd/ HH:mm:ss");
    			String datetimeformated = datetimeformatter.format(localDateTime);
      // つぶやきをつぶやきリストに追加
    			Chat mutter = new Chat(loginUser.getNickName(), text,datetimeformated);
    			PostchatLogic postMutterLogic = new PostchatLogic();
    			postMutterLogic.execute(mutter);


    			Done_update_Logic done_update_logic = new Done_update_Logic();
    			done_update_logic.clear(loginUser);






    			Done resetdone = new Done(loginUser.getOriginalid(),0,0,0);

    			session.setAttribute("done",resetdone);






        	} else {

            // エラーメッセージをリクエストスコープに保存
        		request.setAttribute("errorMsg2",
                "学習が達成されていません");
        	}




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



