package model;

import java.io.Serializable;

public class Register implements Serializable {
	private String originalid;
    private String nickName;
    private String password;
    private int point;

    public Register() {
    }

    public Register(String originalid,String nickName, String password, int point) {
    	this.originalid = originalid;
    	this.nickName = nickName;
        this.password = password;
        this.point = point;
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

}