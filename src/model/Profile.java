package model;

import java.io.Serializable;

public class Profile implements Serializable {
	private int id;
	private String originalid;
    private String nickName;
    private String password;
    private int point;

    public Profile() {
    }

    public Profile(String originalid,String nickName, String password, int point) {
    	this.originalid = originalid;
    	this.nickName = nickName;
        this.password = password;
        this.point = point;
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

}