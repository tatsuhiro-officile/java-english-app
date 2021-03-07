package model;

import java.io.Serializable;

public class Loginfailure implements Serializable {
	private String result;

    public Loginfailure() {
    }


    public Loginfailure(String result) {

    	this.result = result;

    }


    public String getLoginfailure() {
        return result;
    }



}