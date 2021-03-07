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
import model.Originalnickname_check;
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
	  session.removeAttribute("duplicateoriginalid");
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
    String chekc_space="";
    int point =0;
    HttpSession session = request.getSession();

    if((originalid.equals(chekc_space))||(nickname.equals(chekc_space))||(pass.equals(chekc_space))){
    	System.out.println("登録");

    	session.removeAttribute("duplicateoriginalid");



    	session.setAttribute("duplicateoriginalid","全ての項目をご入力ください");
   		int registerdone=  (int) session.getAttribute("registerdone");
		registerdone=1;
		session.setAttribute("registerdone",registerdone);
        RequestDispatcher dispatcher = request.
        getRequestDispatcher("/WEB-INF/jsp/register.jsp");
        dispatcher.forward(request, response);
        System.out.println("登録1");
    }else {
    	Register register = new Register(originalid,nickname,pass,point);
    	Originalid_Check originalid_check = new Originalid_Check();
    	String originalidresult= originalid_check.originalid_check(register);
    	Originalnickname_check Originalnickname_check = new Originalnickname_check();
    	String originalniciknameresult= Originalnickname_check.originalnicikname_check(register);
    	if(!(originalidresult==null)){
    		int registerdone=  (int) session.getAttribute("registerdone");
    		registerdone=1;
    		session.setAttribute("registerdone",registerdone);
    		session.setAttribute("duplicateoriginalid","ID:" + originalidresult+ "は既に使用されています。");
    		RequestDispatcher dispatcher = request.
    				getRequestDispatcher("/WEB-INF/jsp/register.jsp");
    		dispatcher.forward(request, response);
            }
    	else if(!(originalniciknameresult==null)) {
    		int registerdone=  (int) session.getAttribute("registerdone");
    		registerdone=1;

    		session.setAttribute("registerdone",registerdone);
    		session.setAttribute("duplicateoriginalid","ニックネーム:"+ originalniciknameresult+ "は既に使用されています。");
    		RequestDispatcher dispatcher = request.
    				getRequestDispatcher("/WEB-INF/jsp/register.jsp");
    		dispatcher.forward(request, response);

    	}else{
    		System.out.println("危険");
    		RegisterLogic registerlogic = new RegisterLogic();
    		boolean result =registerlogic.execute(register);
    		if(result==true) {
    		int problem1=0;
    		int problem2=0;
    		int problem3=0;
    		int problem4=0;
    		int problem5=0;
    		int problem6=0;
    		int problem7=0;
    		int problem8=0;
    		int problem9=0;
    		int problem10=0;
    		int problem11=0;
    		int problem12=0;
    		Profile profile = new Profile(originalid,nickname,pass,point,
    		problem1,problem2,problem3,problem4,problem5,problem6,
    		problem7,problem8,problem9,problem10,problem11,problem12);
    		session.setAttribute("userId",profile);
    		int registerdone=  (int) session.getAttribute("registerdone");
    		registerdone=1;
    		session.setAttribute("registerdone",registerdone);

    		RequestDispatcher dispatcher = request.
            getRequestDispatcher("/WEB-INF/jsp/main.jsp");
    		dispatcher.forward(request, response);
    	}}}}}










