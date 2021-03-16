package model;

import dao.DoneDAO;


public class Done_update_Logic{
	  public void execute(int level,String mooji) { // 引数を1つに変更
		    DoneDAO dao = new DoneDAO();
		    String inputting = null;


		      switch(level){
	    	  case(1):
	    		  inputting="READING";
	    	  break;

	    	  case(2):
	    		  inputting="WRITEING";

	    	  break;
	    	  case(3):
	    		  inputting="LISTNING";
	    	  break;
	      }


		    String inputsql = "UPDATE DONE SET "+ inputting +
		    		" = " +inputting + "+ 1 WHERE  ORIGINALID=" + '\'' + mooji +'\'';
		    System.out.println(inputsql);


		     dao.point_update(inputsql);

		  }
	  public void clear(Profile profile) { // 引数を1つに変更
		    DoneDAO dao = new DoneDAO();

		    String originalid = profile.getOriginalid();





		    String inputsql =  "UPDATE DONE SET LISTNING=0 ,READING=0,WRITEING=0 WHERE ORIGINALID=" +
		    '\'' + originalid +'\'';



		     dao.point_update(inputsql);

		  }
		}