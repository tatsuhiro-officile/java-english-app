package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProblemDao;
import model.Problem;

@WebServlet("/OriginalServlet")
public class OriginalServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;



  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	  request.setCharacterEncoding("UTF-8");

	  int id=0;
	  int word=0;
	int level=0;
	String no1=" ";
	String no2=" ";

	String no3=" ";
	String no4=" ";
	String no5=" ";
	String no6=" ";
	String no7=" ";
	String no8=" ";
	String no9=" ";

	String no10=" ";
	String no11=" ";
	String no12=" ";
	String no13=" ";
	String no14=" ";
	String no15=" ";
	String japanese=" ";
	int quation=0;
	  int comma=0;


	  String input1 = request.getParameter("input_no1");
	  id = Integer.parseInt(input1);
	  String input2 = request.getParameter("input_no2");
	  word = Integer.parseInt(input2);
	  String input3 = request.getParameter("input_no3");
	  level = Integer.parseInt(input3);

	  no1 = request.getParameter("input_no4");
	  no2 = request.getParameter("input_no5");
	  no3 = request.getParameter("input_no6");
	  no4 = request.getParameter("input_no7");
	  no5 = request.getParameter("input_no8");
	  no6 = request.getParameter("input_no9");
	  no7 = request.getParameter("input_no10");
	  no8 = request.getParameter("input_no11");
	  no9 = request.getParameter("input_no12");
	  no10 = request.getParameter("input_no13");
	  no11 = request.getParameter("input_no14");
	  no12 = request.getParameter("input_no15");
	  no13 = request.getParameter("input_no16");
	  no14 = request.getParameter("input_no17");
	  no15 = request.getParameter("input_no18");

	  japanese = request.getParameter("input_no19");

	  String input17 = request.getParameter("input_no20");
	  quation = Integer.parseInt(input17);
	  String input18 = request.getParameter("input_no21");
	  comma = Integer.parseInt(input18);

	  Problem problem = new Problem(id,word,level,no1,no2,no3,no4,no5,no6,no7,no8,no9,
			  no10,no11,no12,no13,no14,no15,japanese,quation,comma);

	  System.out.println(problem.getNo1());

	  ProblemDao  dao = new ProblemDao();
	  boolean test =dao.create(problem);

	  System.out.println(test);











	  RequestDispatcher dispatcher = request.getRequestDispatcher(
	          "/WEB-INF/jsp/original.jsp");
	      dispatcher.forward(request, response);
  }


  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {



	  RequestDispatcher dispatcher = request.getRequestDispatcher(
	          "/WEB-INF/jsp/original.jsp");
	      dispatcher.forward(request, response);




  }
}

