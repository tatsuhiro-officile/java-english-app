package model;

public class Done{

  private String originalid;
  private int listning;
  private int reading;
  private int writeing;




  public Done(String originalid,int listning,int reading,int writeing) {

	  	this.originalid = originalid;
	    this.listning = listning;
	    this.reading = reading;
	    this.writeing = writeing;
	  }


	public String getOriginalid() {
	    return originalid;

	  }

	public int getListning() {
	    return listning;

	  }

	public int getReading() {
	    return reading;
	  }
	public int getWriteing() {
	    return writeing;
	  }

}