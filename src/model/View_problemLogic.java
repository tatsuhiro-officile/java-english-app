package model;

import java.util.ArrayList;

import dao.ProblemDao;


public class View_problemLogic {
	public ArrayList<Problem> execute(ArrayList<Integer> list) {

		ProblemDao dao = new ProblemDao();
	    ArrayList<Problem> mutterList =  dao.view_problem(list);

	    return mutterList;

}
}
