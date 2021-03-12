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

import model.CheckproblemLogic;
import model.Done_update_Logic;
import model.Problem;
import model.Profile;

@WebServlet("/CheckproblemServret")
public class CheckproblemServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	  HttpSession session = request.getSession();
	  int problemview =(int) session.getAttribute("problemview");
	  String get_problemview = request.getParameter("problemview");
	  problemview = Integer.parseInt(get_problemview);

	  int checkfinal =0;




	  switch(problemview){


	  	case(1):
	  		String getlevel = request.getParameter("select_problem");
	  		int problemnumber = Integer.parseInt(getlevel);
	  		switch(problemnumber){
	  		case 1:
	  			problemnumber=0;

	  			break;
	  		case 2:
	  			problemnumber=21;

	  			break;
	  		case 3:
	  			problemnumber=41;
	  			break;
	  		case 4:
	  			problemnumber=61;
	  			break;
	  		case 5:
	  			problemnumber=81;
	  			break;
	  		case 6:
	  			problemnumber=101;
	  			break;
	    	}
		  ArrayList<Integer> checkproblemnumber = new ArrayList<Integer>();

		  for(int i=0;i<20;i++) {
			  checkproblemnumber.add(problemnumber+i);
			  }
		  CheckproblemLogic checkproblemLogic = new CheckproblemLogic();
		  ArrayList<Problem> checklist =checkproblemLogic.execute(checkproblemnumber);

		  session.setAttribute("checklist",checklist);
		  problemview = 1;
		  session.setAttribute("problemview",problemview);
		  session.setAttribute("checkfinal",checkfinal);

	  		break;

	  	case(2):
	  		problemview = 2;

	  	session.setAttribute("checkfinal",checkfinal);

	  		session.setAttribute("problemview",problemview);
	  		break;






	  	case(3):
	  		int mondainumber =(int) session.getAttribute("mondainumber");

	  		mondainumber++;


	  		if(mondainumber==20) {
	  			problemview=0;
	  			mondainumber=0;
	  			checkfinal = 1;
	  			Profile profile = (Profile) session.getAttribute("userId");
	  			Done_update_Logic update= new Done_update_Logic();
	  			update.execute(1,profile.getOriginalid());
	  		}
	  		else if(mondainumber<20) {
	  			problemview=1;
	  			checkfinal =0;
	  		}


	  		session.setAttribute("mondainumber",mondainumber);
	  		session.setAttribute("checkfinal",checkfinal);

	  		session.setAttribute("problemview",problemview);
	  		session.setAttribute("mondainumber",mondainumber);
	  		break;
	  }

    RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/WEB-INF/jsp/check_problem.jsp");
    dispatcher.forward(request, response);
	  }


  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	  HttpSession session = request.getSession();
	  int problemview =0;




	  session.setAttribute("problemview",problemview);

		int mondainumber =0;
		session.setAttribute("mondainumber",mondainumber);






	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "/WEB-INF/jsp/check_problem.jsp");
	        dispatcher.forward(request, response);
  }
}