package model;

public class Chat {
  private String name;
  private String text;
  private String time;


  public Chat(String name,String text,String time) {

    this.name=name;
	this.text = text;
	this.time = time;

  }

  public String getName() {
	    return name;
  }
public String getText() {
	        return text;
}
public String getTime() {
    return time;
}
}