package model;

import dao.UserDAO;

public class SeisekiUpdateLogoc {
	  public boolean execute(int level,Profile mooji) { // 引数を1つに変更
		    UserDAO dao = new UserDAO();
		    String columnlevel = String.valueOf(level);
		    String chengecolumn = "PROBLEM" + columnlevel;

		    String inputsql = "UPDATE USER2 SET "+ chengecolumn +
		    		"=1 WHERE  ORIGINALID=" + '\'' +mooji.getOriginalid() +
		    		'\'';





		    boolean result = dao.seisekiupdate(inputsql);
		    return result;
		  }
		}
