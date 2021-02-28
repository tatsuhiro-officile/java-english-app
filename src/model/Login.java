package model;

public class Login {
  private int id;
  private String originalid;
  private String password;
  private int point;
  private String nicikname;



  public Login(int id ,String originalid,String nickName, String password, int point){
     this.id = id;
	 this.originalid = originalid;
     this.password = password;
     this.point = point;
     this.nicikname = nickName;
  }
  public int getId() {
	    return id;
	  }
  public String getOriginalid() {
    return originalid;
  }
  public String getNicikname() {
	    return nicikname;
	  }
  public String getpassword() {
	    return password;
	  }

  public int getPoint() {
	    return point;
	  }

}