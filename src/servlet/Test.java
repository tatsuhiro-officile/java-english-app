package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Human;

@WebServlet("/Test")
public class Test extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {


Human human = new Human();
human.setName("死ね死ね");
human.setAge(43243);

HttpSession session = request.getSession();

session.setAttribute("human", human);







    // フォワード
    RequestDispatcher dispatcher =
        request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
    dispatcher.forward(request, response);
  }
}