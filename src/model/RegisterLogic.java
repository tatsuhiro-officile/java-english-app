package model;


import dao.UserDAO;

public class RegisterLogic {
  public boolean execute(Register register) { // 引数を1つに変更
    UserDAO dao = new UserDAO();
    boolean result = dao.create(register);
    return result;
  }
}
