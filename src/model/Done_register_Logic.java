package model;



import dao.DoneDAO;


public class Done_register_Logic{
  public void create(String originalid) {
	  System.out.println("Logic");
    DoneDAO dao= new DoneDAO();
     dao.create(originalid);

     System.out.println("Dao完了");


}
}
