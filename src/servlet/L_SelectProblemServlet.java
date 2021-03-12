package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/L_SelectProblemServlet")
public class L_SelectProblemServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	  HttpSession session = request.getSession();

	  session.removeAttribute("mondaisuu");
	  session.removeAttribute("problemnumber");
	  session.removeAttribute("kekka");

	  int startstop = 0;
	  session.setAttribute("startstop",startstop);


	    String getlevel = request.getParameter("select_problem");
	    int word = Integer.parseInt(getlevel);
	    session.setAttribute("getlevel", word);

	    int problemnumber;


	    if(word>0) {


	    switch(word){
	    case 1:
	    	problemnumber=0;
	    	session.setAttribute("problemnumber", problemnumber);
	    	break;
	    case 2:
	    	problemnumber=20;
	    	session.setAttribute("problemnumber", problemnumber);
	    	break;
	    case 3:
	    	problemnumber=40;
	    	session.setAttribute("problemnumber", problemnumber);
	    	break;
	    	}
	    int seikaisuu =0;
	    int mondaisuu=0;

	    session.setAttribute("seikaisuu", seikaisuu);
	    session.setAttribute("mondaisuu", mondaisuu);
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "/WEB-INF/jsp/problem.jsp");
	        dispatcher.forward(request, response);

	    }




    RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/WEB-INF/jsp/selectproblem.jsp");
    dispatcher.forward(request, response);
  }


  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "/WEB-INF/jsp/selectproblem.jsp");
	        dispatcher.forward(request, response);
  }
}

