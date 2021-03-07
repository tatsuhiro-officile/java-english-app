package model;

import java.io.Serializable;

public class Profile implements Serializable {
	private int id;
	private String originalid;
    private String nickName;
    private String password;
    private int point;
    private int problem1;
    private int problem2;
    private int problem3;
    private int problem4;
    private int problem5;
    private int problem6;
    private int problem7;
    private int problem8;
    private int problem9;
    private int problem10;
    private int problem11;
    private int problem12;

    public Profile() {
    }


    public Profile(String originalid,String nickName, String password, int point,int problem1,
    int problem2,int problem3,int problem4,int problem5,int problem6,int problem7,int problem8,
    int problem9,int problem10,int problem11,int problem12) {

    	this.originalid = originalid;
    	this.nickName = nickName;
        this.password = password;
        this.point = point;
        this.problem1 = problem1;
        this.problem2 = problem2;
        this.problem3 = problem3;
        this.problem4 = problem4;
        this.problem5 = problem5;
        this.problem6 = problem6;
        this.problem7 = problem7;
        this.problem8 = problem8;
        this.problem9 = problem9;
        this.problem10 = problem10;
        this.problem11 = problem11;
        this.problem12 = problem12;
    }
    public int getId() {
        return id;
    }

    public String getOriginalid() {
        return originalid;
    }
    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public int getPoint() {
        return point;
    }
    public int getProblem1() {
        return problem1;
    }
    public int getProblem2() {
        return problem2;
    }
    public int getProblem3() {
        return problem3;
    }
    public int getProblem4() {
        return problem4;
    }
    public int getProblem5() {
        return problem5;
    }
    public int getProblem6() {
        return problem6;
    }
    public int getProblem7() {
        return problem7;
    }
    public int getProblem8() {
        return problem8;
    }

    public int getProblem9() {
        return problem9;
    }
    public int getProblem10() {
        return problem10;
    }
    public int getProblem11() {
        return problem11;
    }
    public int getProblem12() {
        return problem12;
    }

}