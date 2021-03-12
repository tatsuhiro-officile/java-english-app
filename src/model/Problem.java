package model;

public class Problem {
  private int id ;
  private int word;
  private int level;
  private String no1; //japanese
  private String no2; // comma
  private String no3;
  private String no4;
  private String no5;
  private String no6;
  private String no7;
  private String no8;
  private String no9;
  private String no10;
  private String no11;
  private String no12;
  private String no13;
  private String no14;
  private String no15;
  private String japanese;
  private int quations;
  private int comma;



  public Problem(int id,int word,int level,String no1,String no2,String no3,
		  String no4,String no5,String no6,String no7,String no8,String no9,
		  String no10,String no11,String no12,String no13,String no14,String no15,
		  String japanese,int quations,int comma) {
	    this.id = id;
	    this.word = word;
	    this.level = level;
	    this.no1 = no1;
	    this.no2 = no2;
	    this.no3 = no3;
	    this.no4 = no4;
	    this.no5 = no5;
	    this.no6 = no6;
	    this.no7 = no7;
	    this.no8 = no8;
	    this.no9 = no9;
	    this.no10 = no10;
	    this.no11 = no11;
	    this.no12 = no12;
	    this.no13 = no13;
	    this.no14 = no14;
	    this.no15 = no15;
	    this.japanese = japanese;
	    this.quations = quations;
	    this.comma = comma;
	  }



	public int getId() {
	    return id;
	  }
	  public int getWord() {
		    return word;
		  }
	  public int getLevel() {
		    return level;
		  }
	  public String getNo1() {
		    return no1;
		  }
	  public String getNo2() {
		    return no2;
		  }
	  public String getNo3() {
		    return no3;
		  }
	  public String getNo4() {
		    return no4;
		  }
	  public String getNo5() {
		    return no5;
		  }
	  public String getNo6() {
		    return no6;
		  }
	  public String getNo7() {
		    return no7;
		  }
	  public String getNo8() {
		    return no8;
		  }
	  public String getNo9() {
		    return no9;
		  }
	  public String getNo10() {
		    return no10;
		  }
	  public String getNo11() {
		    return no11;
		  }
	  public String getNo12() {
		    return no12;
		  }
	  public String getNo13() {
		    return no13;
		  }
	  public String getNo14() {
		    return no14;
		  }
	  public String getNo15() {
		    return no15;
		  }
	  public String getJapanese() {
		    return japanese;
		  }
	  public int getQuations() {
		    return quations;
	  }
	  public int getComma() {
		    return comma;
	  }
}