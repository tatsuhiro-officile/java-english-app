package model;


import dao.UserDAO;

public class Originalid_Check {
  public String originalid_check(Register register) { // 引数を1つに変更
    UserDAO dao = new UserDAO();
    String checkresult= dao.findooriginalid(register);

    return checkresult;
  }
}
