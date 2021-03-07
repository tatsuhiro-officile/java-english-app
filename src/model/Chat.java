package model;

public class Chat {
  private String name;
  private String text;


  public Chat(String name,String text) {

    this.name=name;
	this.text = text;

  }

  public String getName() {
	    return name;
  }
public String getText() {
	        return text;
}
}