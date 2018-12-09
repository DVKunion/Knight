package com.njfu.entity;

public class Player {
	private String account;
	private String phonenum;
	private String password;
	private int goldnum;
	private int diamondnum;
	private int station;
	private int sel ;
	private int lv;
	private int epx;
	private int id;
	
	private Hero h;
	//getting & setting
	public Hero getHero(){
		return h;
	}
	public void setHero(){
		switch(sel){
		case 1: h = new Archer();
		case 2:	h = new Archer();
		case 3:	h = new Archer();
		case 4:	h = new Archer();
		case 5:	h = new Archer();
		default :
		}
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getSel() {
		return sel;
	}
	public void setSel(int sel) {
		this.sel = sel;
	}
	public int getGoldnum() {
		return goldnum;
	}
	public void setGoldnum(int goldnum) {
		this.goldnum = goldnum;
	}
	public int getDiamondnum() {
		return diamondnum;
	}
	public void setDiamondnum(int diamondnum) {
		this.diamondnum = diamondnum;
	}
	public int getStation() {
		return station;
	}
	public void setStation(int station) {
		this.station = station;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public int getEpx() {
		return epx;
	}
	public void setEpx(int epx) {
		this.epx = epx;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
