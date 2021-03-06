package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Done_update_Logic;
import model.Problem;
import model.Profile;

@WebServlet("/L_AnswerServlet")
public class L_AnswerServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	  RequestDispatcher dispatcher = request.getRequestDispatcher(
	           "/WEB-INF/jsp/problem.jsp");
	        dispatcher.forward(request, response);

  }
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	  request.setCharacterEncoding("UTF-8");


    // リクエストパラメータの取得

	  	String your_answer1 = request.getParameter("input_no1");
	  	String your_answer2 = request.getParameter("input_no2");
	  	String your_answer3 = request.getParameter("input_no3");


	  	HttpSession session = request.getSession();
	  	ArrayList<Problem>one_game_problemlist= (ArrayList<Problem>) session.getAttribute("one_game_problemlist");
	  	int mondaisuu =  (int) session.getAttribute("mondaisuu");
	  	int inputtingform= one_game_problemlist.get(mondaisuu).getWord();

		 int id =0;
		  int word =0;
		  int level =0;
		  String no1 = "";
		  String no2 = "";
		  String no3= "";
		  String no4= "";
		  String no5= "";
		  String no6= "";
		  String no7= "";
		  String no8= "";
		  String no9= "";
		  String no10= "";
		  String no11= "";
		  String no12= "";
		  String no13= "";
		  String no14= "";
		  String no15 = "";
		  String japanese ="";
		  int quations=0;
		  int comma=0;



		  int machigaisuu =0;
		  String answer1 = one_game_problemlist.get(mondaisuu).getNo1();
		  if (!your_answer1.equals(answer1)) {
			  machigaisuu += 1;
			  no3 =  ("X"+your_answer1);
		  }

		  String answer2 = one_game_problemlist.get(mondaisuu).getNo2();
		  if (!your_answer2.equals(answer2)) {
			  machigaisuu += 1;
			  no4 =  ("X"+your_answer2);
		  	}
		  String answer3 = one_game_problemlist.get(mondaisuu).getNo3();
		  if (!your_answer3.equals(answer3)) {
			  machigaisuu += 1;
			  no5 =  ("X"+your_answer3);
		  }


	  	switch(inputtingform){

	  	case(15):
	  		String your_answer15 = request.getParameter("input_no15");
		  	String answer15 = one_game_problemlist.get(mondaisuu).getNo15();
		  	if (!your_answer15.equals(answer15)) {
			  machigaisuu += 1;
			  no15 =  ("X"+your_answer15);
		  }
	  	case(14):
	  		String your_answer14 = request.getParameter("input_no14");
		  	String answer14 = one_game_problemlist.get(mondaisuu).getNo14();
		  	if (!your_answer14.equals(answer14)) {
			  machigaisuu += 1;
			  no14 =  ("X"+your_answer14);
		  }

	  	case(13):
	  		String your_answer13 = request.getParameter("input_no13");
		  	String answer13 = one_game_problemlist.get(mondaisuu).getNo13();
		  	if (!your_answer13.equals(answer13)) {
			  machigaisuu += 1;
			  no13 =  ("X"+your_answer13);
		  }
	  	case(12):
	  		String your_answer12 = request.getParameter("input_no12");
		  String answer12 = one_game_problemlist.get(mondaisuu).getNo12();
		  if (!your_answer12.equals(answer12)) {
			  machigaisuu += 1;
			  no12 =  ("X"+your_answer12);
		  }
	  	case(11):
	  		String your_answer11 = request.getParameter("input_no11");
		  String answer11 = one_game_problemlist.get(mondaisuu).getNo11();
		  if (!your_answer11.equals(answer11)) {
			  machigaisuu += 1;
			  no11 =  ("X"+your_answer11);
		  }
	  	case(10):
	  		String your_answer10 = request.getParameter("input_no10");
		  String answer10 = one_game_problemlist.get(mondaisuu).getNo10();
		  if (!your_answer10.equals(answer10)) {
			  machigaisuu += 1;
			  no10 =  ("X"+your_answer10);
		  }
	  	case(9):
	  		String your_answer9 = request.getParameter("input_no9");
		  String answer9 = one_game_problemlist.get(mondaisuu).getNo9();
		  if (!your_answer9.equals(answer9)) {
			  machigaisuu += 1;
			  no9 =  ("X"+your_answer9);
		  }
	  	case(8):
	  		String your_answer8 = request.getParameter("input_no8");
		  String answer8 = one_game_problemlist.get(mondaisuu).getNo8();
		  if (!your_answer8.equals(answer8)) {
			  machigaisuu += 1;
			  no8 =  ("X"+your_answer8);
		  }
	  	case(7):
	  		String your_answer7 = request.getParameter("input_no7");
		  String answer7 = one_game_problemlist.get(mondaisuu).getNo7();
		  if (!your_answer7.equals(answer7)) {
			  machigaisuu += 1;
			  no7 =  ("X"+your_answer7);
		  }
	  	case(6):
	  		String your_answer6 = request.getParameter("input_no6");
		  String answer6 = one_game_problemlist.get(mondaisuu).getNo6();
		  if (!your_answer6.equals(answer6)) {
			  machigaisuu += 1;
			  no6 =  ("X"+your_answer6);
		  }
	  	case(5):
	  		String your_answer5 = request.getParameter("input_no5");
		  String answer5 = one_game_problemlist.get(mondaisuu).getNo5();
		  if (!your_answer5.equals(answer5)) {
			  machigaisuu += 1;
			  no5 =  ("X"+your_answer5);
		  	}
	  	case(4):
	  		String your_answer4 = request.getParameter("input_no4");
		  String answer4 = one_game_problemlist.get(mondaisuu).getNo4();
		  if (!your_answer4.equals(answer4)) {
			  machigaisuu += 1;
			  no4 =  ("X"+your_answer4);
		  }


	  	}















		  if(machigaisuu ==0) {

			  session.setAttribute("kekka", "正解");
			  int seikasuu = (int) session.getAttribute("seikaisuu");
			  seikasuu += 1;
			  session.setAttribute("seikaisuu", seikasuu);



		  }else {
			  session.setAttribute("kekka", "不正解");
			  ArrayList<Problem>  machigailist =(ArrayList<Problem>) session.getAttribute("machigailist");
			  Problem problem = new Problem(id,word,level,no1,no2,no3,no4,no5,no6,no7,no8,
				  no9,no10,no11,no12,no13,no14,no15,japanese,quations,comma);
			  machigailist.add(problem);
			  session.setAttribute("machigailist",machigailist);

			  ArrayList<Problem>  kaitoulist =(ArrayList<Problem>) session.getAttribute("kaitoulist");

			  Problem machigai_instane = one_game_problemlist.get(mondaisuu);

			  kaitoulist.add(machigai_instane);
			  session.setAttribute("kaitoulist",kaitoulist);

			  int machigai = (int) session.getAttribute("machigai");
			  machigai += 1;
			  session.setAttribute("machigai", machigai);


		  	}




		  mondaisuu = mondaisuu +1;
		  session.setAttribute("mondaisuu", mondaisuu);

		   if(mondaisuu==20) {
			   System.out.println("リスニングアップ");
	  			Profile profile = (Profile) session.getAttribute("userId");
	  			Done_update_Logic update= new Done_update_Logic();
	  			update.execute(3,profile.getOriginalid());
		   }

		  RequestDispatcher dispatcher = request.getRequestDispatcher(
	           "/WEB-INF/jsp/problem.jsp");
	        dispatcher.forward(request, response);

  }
  }
