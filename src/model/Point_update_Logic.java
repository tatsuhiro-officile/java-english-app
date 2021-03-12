package model;


import dao.UserDAO;

public class Point_update_Logic{
  public Profile execute(Profile profile) { // 引数を1つに変更
    UserDAO dao = new UserDAO();
    int point =dao.point_update(profile);


    profile = new Profile(profile.getOriginalid(),profile.getNickName(),profile.getPassword(),
    		point,profile.getProblem1(),profile.getProblem2(),profile.getProblem3(),profile.getProblem4(),
    		profile.getProblem5(),profile.getProblem6(),profile.getProblem7(),profile.getProblem8(),
    		profile.getProblem9(),profile.getProblem10(),profile.getProblem11(),profile.getProblem12());


  return profile;
  }
}
