package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetproblemLogic;
import model.Making_onsei_Logic;
import model.Makingproblem;
import model.Onsei;
import model.Problem;
import model.Profile;
import model.View_problemLogic;

@WebServlet("/ProblemServlet")
public class ProblemServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {




	  HttpSession session = request.getSession();




	  int startstop = (int) session.getAttribute("startstop");

	  if(startstop==0) {
		  session.removeAttribute("one_game_problemlist");
		  session.removeAttribute("machigailist");
		  session.removeAttribute("kaitoulist");
		  session.removeAttribute("machigaeta_sum");
		  session.removeAttribute("kekka");



    // つぶやきリストを取得して、リクエストスコープに保存
		  GetproblemLogic getProblem =
				  new GetproblemLogic();
		  List<Problem> problemList = getProblem.execute();
		  request.setAttribute("problemList", problemList);

    // ログインしているか確認するため
    // セッションスコープからユーザー情報を取得




		  Makingproblem newproblem = new Makingproblem();
		  ArrayList<Integer> problemnumber = newproblem.execute();


		  int listnumber =0;

		  Integer level_adjustment = (Integer) session.getAttribute("problemnumber");

		  for(int number: problemnumber){
			  problemnumber.set(listnumber,number+level_adjustment);

			  listnumber += 1;
			  }



		  View_problemLogic get_instance = new View_problemLogic();
		  ArrayList<Problem> one_game_problemlist = get_instance.execute(problemnumber);


			System.out.println(one_game_problemlist.get(0).getNo1());
			System.out.println(one_game_problemlist.get(0).getNo2());

			System.out.println(one_game_problemlist.get(0).getNo3());

			System.out.println(one_game_problemlist.get(0).getNo4());

			System.out.println(one_game_problemlist.get(0).getNo5());

			System.out.println(one_game_problemlist.get(0).getNo6());

			System.out.println(one_game_problemlist.get(0).getNo7());
			System.out.println("test");
			System.out.println(one_game_problemlist.get(0).getNo8());
			System.out.println("test");
			System.out.println(one_game_problemlist.get(0).getNo9());
			System.out.println("test");
			System.out.println(one_game_problemlist.get(0).getNo10());
			System.out.println("test");
			System.out.println(one_game_problemlist.get(0).getNo11());
			System.out.println(one_game_problemlist.get(0).getNo12());
			System.out.println(one_game_problemlist.get(0).getNo13());
			System.out.println(one_game_problemlist.get(0).getNo14());
			System.out.println(one_game_problemlist.get(0).getNo15());
			System.out.println(one_game_problemlist.get(0).getWord());
			System.out.println(one_game_problemlist.get(0).getId());
			System.out.println(one_game_problemlist.get(0).getLevel());



		  ArrayList<Problem> machigailist = new ArrayList<Problem> ();
		  ArrayList<Problem> kaitoulist = new ArrayList<Problem> ();

			int yourlevel = (int)session.getAttribute("getlevel");

			if(yourlevel >6) {

			Making_onsei_Logic onsei_logic = new Making_onsei_Logic();

			Onsei[] onseilist = onsei_logic.making_onsei(one_game_problemlist);

			session.setAttribute("onseilist",onseilist);

			}

		  startstop = 1;
		  session.setAttribute("startstop",startstop);




		  session.setAttribute("one_game_problemlist",one_game_problemlist);
		  session.setAttribute("machigailist",machigailist);
		  session.setAttribute("kaitoulist",kaitoulist);
	  }else{


	  }


	  Profile loginUser = (Profile) session.getAttribute("userId");



	  request.setCharacterEncoding("UTF-8");


		if (loginUser == null) { // ログインしていない
    // リダイレクト
			response.sendRedirect("/application2/");
		} else { // ログイン済み
			int yourlevel = (int)session.getAttribute("getlevel");

			if(yourlevel <7) {
    // フォワード
			RequestDispatcher dispatcher = request.
					getRequestDispatcher("/WEB-INF/jsp/problem.jsp");
			dispatcher.forward(request, response);
			}else {


		RequestDispatcher dispatcher = request.
				getRequestDispatcher("/WEB-INF/jsp/l-problem.jsp");
		dispatcher.forward(request, response);
			}
		}
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	  HttpSession session = request.getSession();

	  int yourlevel = (int)session.getAttribute("getlevel");

		if(yourlevel <7) {
		    // フォワード
					RequestDispatcher dispatcher = request.
							getRequestDispatcher("/WEB-INF/jsp/problem.jsp");
					dispatcher.forward(request, response);
					}else {
				RequestDispatcher dispatcher = request.
						getRequestDispatcher("/WEB-INF/jsp/l-problem.jsp");
				dispatcher.forward(request, response);
					}
}}
