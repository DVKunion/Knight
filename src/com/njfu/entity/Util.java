package com.njfu.entity;

public class Util {
	public String code(){
			String s = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
			String code = "";
			for(int i=0;i<4;i++){
				code+=s.charAt((int)(Math.random()*s.length()));
			}
			return code;
		}
}
