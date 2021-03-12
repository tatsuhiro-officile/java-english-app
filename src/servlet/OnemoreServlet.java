package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OnemoreServlet")
public class OnemoreServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {





    RequestDispatcher dispatcher = request.getRequestDispatcher(
        "ProblemServlet");
    dispatcher.forward(request, response);
  }


  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	  HttpSession session = request.getSession();








		  int startstop = (int) session.getAttribute("startstop");
		  startstop =0;
		  session.setAttribute("startstop",startstop);

		  session.removeAttribute("mondaisuu");
		  session.removeAttribute("problemnumber");


	  int word = (int) session.getAttribute("getlevel");


	    int problemnumber;


	    if(word>0) {


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
	    int machigai =0;
	    int mondaisuu=0;

	    session.setAttribute("seikaisuu", seikaisuu);
	    session.setAttribute("seikaisuu", machigai);
	    session.setAttribute("mondaisuu", mondaisuu);
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "/ProblemServlet");
	        dispatcher.forward(request, response);

	    }
  }
}
