package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	  request.setCharacterEncoding("UTF-8");

    RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/WEB-INF/jsp/main.jsp");
    dispatcher.forward(request, response);
  }


  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	  HttpSession session = request.getSession();
	  int registerdone =0;

  	session.setAttribute("registerdone",registerdone);

	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "/WEB-INF/jsp/main.jsp");
	        dispatcher.forward(request, response);
  }
}
