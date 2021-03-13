package model;


import dao.UserDAO;

public class Originalnickname_check{
  public String originalnicikname_check(Register register) { // 引数を1つに変更
    UserDAO dao = new UserDAO();
    String checkresult= dao.findnickname(register);
    System.out.println("オリジナルcheckresult"+checkresult);

    return checkresult;
  }
}