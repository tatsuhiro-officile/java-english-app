package model;

import dao.DoneDAO;

public class DoneLogic {
	public Done select_done(Profile profile) {

		DoneDAO donedao = new DoneDAO() ;
		Done done= donedao.findBytoday(profile);
		return done;


	}

}
