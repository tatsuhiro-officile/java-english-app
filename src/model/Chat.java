package model;

public class Chat {
	private int id;
	private String name;
  private String text;


  public Chat(int id,String name,String text) {
    this.id=id;
    this.name=name;
	this.text = text;

  }

  public int getId() {
    return id;
  }
  public String getName() {
	    return name;
  }
public String getText() {
	        return text;
}
}