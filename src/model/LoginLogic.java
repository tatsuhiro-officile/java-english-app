package model;

import dao.UserDAO;

public class LoginLogic {
  public Profile execute(Login login,int number) {
    UserDAO dao = new UserDAO();
    System.out.println("logicok");
    Profile account = dao.findByLogin(login, number);


    return account;

  }

}
