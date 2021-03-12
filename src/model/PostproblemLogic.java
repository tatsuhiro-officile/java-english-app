package model;

import dao.ProblemDao;

public class PostproblemLogic {
  public void execute(Problem problem) { // 引数を1つに変更
    ProblemDao dao = new ProblemDao();
    dao.create(problem);
  }
}