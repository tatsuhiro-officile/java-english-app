package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Originalid_Check;
import model.Profile;
import model.Register;
import model.RegisterLogic;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

	  HttpSession session = request.getSession();
	  int registerdone =0;

	  	session.setAttribute("registerdone",registerdone);

    // フォワード
      RequestDispatcher dispatcher = request.
          getRequestDispatcher("/WEB-INF/jsp/register.jsp");
      dispatcher.forward(request, response);
    }


  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    // リクエストパラメータの取得
    request.setCharacterEncoding("UTF-8");
    String originalid = request.getParameter("ORIGINALID");
    String pass = request.getParameter("PASS");
    String nickname = request.getParameter("NICKNAME");
    int point =0;
    Register register = new Register(originalid,nickname,pass,point);



    Originalid_Check originalid_check = new Originalid_Check();
    String originalidresult= originalid_check.originalid_check(register);
    HttpSession session = request.getSession();


    if(!(originalidresult==null)) {


    	session.setAttribute("duplicateoriginalid",originalidresult);

      	int registerdone=  (int) session.getAttribute("registerdone");

    	registerdone=1;

    	session.setAttribute("registerdone",registerdone);
        RequestDispatcher dispatcher = request.
        getRequestDispatcher("/WEB-INF/jsp/register.jsp");
         dispatcher.forward(request, response);
            }



    RegisterLogic registerlogic = new RegisterLogic();
    boolean result =registerlogic.execute(register);

    if(result==true) {
    Profile profile = new Profile(originalid,nickname,pass,point);




        session.setAttribute("userId",profile);

    }




    RequestDispatcher dispatcher = request.
            getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        dispatcher.forward(request, response);
      }}










