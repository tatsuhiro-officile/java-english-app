package model;

public class Employee {

  private String id;
  private String name;
  private String last_name;
  private int age;

  public Employee(String id, String name,String last_name, int age) {
    this.id = id;
    this.name = name;
    this.last_name =last_name;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
  public String getlast_Name() {
	  return last_name;
  }

  public int getAge() {
    return age;
  }

}