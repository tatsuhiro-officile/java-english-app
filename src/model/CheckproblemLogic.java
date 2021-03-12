package model;

import java.util.ArrayList;

import dao.ProblemDao;

public class CheckproblemLogic {
  public ArrayList<Problem> execute(ArrayList<Integer> list) {
    ProblemDao dao = new ProblemDao();
    ArrayList<Problem> account = dao.view_problem(list);


    return account;

  }

}
