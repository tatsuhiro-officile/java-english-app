package model;

import java.io.Serializable;

public class Mutter implements Serializable {
  private String userName; // ユーザー名
  private String text; // つぶやき内容
  private String text2;

  public Mutter() {
  }

  public Mutter(String userName, String text,String text2) {
    this.userName = userName;
    this.text = text;
    this.text2= text2;
  }

  public String getUserName() {
    return userName;
  }

  public String getText() {
   return text;
  }
  public String getText2() {
	  return text2;
  }
  }