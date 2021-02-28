package model;

import dao.UserDAO;

public class LoginLogic {
  public Profile execute(Login login) {
    UserDAO dao = new UserDAO();
    Profile account = dao.findByLogin(login);


    return account;

  }

}
