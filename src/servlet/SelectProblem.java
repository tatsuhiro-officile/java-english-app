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

@WebServlet("/SelectProblem")
public class SelectProblem extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	  request.setCharacterEncoding("UTF-8");

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








	    	switch(word){
	    		case 1:
	    			problemnumber=0;
	    			session.setAttribute("problemnumber", problemnumber);
	    			break;
	    		case 2:
	    			problemnumber=21;
	    			session.setAttribute("problemnumber", problemnumber);
	    			break;
	    		case 3:
	    			problemnumber=41;
	    			session.setAttribute("problemnumber", problemnumber);
	    			break;
	    		case 4:
	    			problemnumber=61;
	    			session.setAttribute("problemnumber", problemnumber);
	    			break;

	    		case 5:
	    			problemnumber=81;
	    			session.setAttribute("problemnumber", problemnumber);
	    			break;
	    		case 6:
	    			problemnumber=101;
	    			session.setAttribute("problemnumber", problemnumber);
	    			break;
	    		case 7:
	    			problemnumber=0;
	    			session.setAttribute("problemnumber", problemnumber);
	    			break;
	    		case 8:
	    			problemnumber=21;
	    			session.setAttribute("problemnumber", problemnumber);
	    			break;
	    	}

	    	int seikaisuu =0;
	    	int mondaisuu=0;
	    	int machigai =0;

	    	session.setAttribute("seikaisuu", seikaisuu);
	    	session.setAttribute("machigai", machigai);
	    	session.setAttribute("mondaisuu", mondaisuu);

	    	RequestDispatcher dispatcher = request.getRequestDispatcher(
	    			"/WEB-INF/jsp/problem.jsp");
	        	dispatcher.forward(request, response);


  }


  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
	  HttpSession session = request.getSession();
	    Login login =(Login)session.getAttribute("login");
	    int number=2;



	    LoginLogic update_user = new LoginLogic();
	     model.Profile profile= update_user.execute(login,number);
	     session.setAttribute("userId" ,profile);


	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "/WEB-INF/jsp/selectproblem.jsp");
	        dispatcher.forward(request, response);
  }
}

