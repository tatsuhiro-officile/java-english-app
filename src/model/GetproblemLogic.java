package model;

import java.util.List;

import dao.ProblemDao;

public class GetproblemLogic {

  public List<Problem> execute() {
    ProblemDao dao = new ProblemDao();
    List<Problem> problemList = dao.findAll();
    return problemList;
  }
}