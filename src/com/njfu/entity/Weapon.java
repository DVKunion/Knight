package com.njfu.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Weapon {
	public BufferedImage arr1,arr2,arr3,arr4,arr5,arr6,arr7,arr8;
	public BufferedImage[] arrow = {};
	public int x;
	public int y;
	public int wid;
	public int hig;
	public int sel=0;
	public int speed=50;
	public int dis=0;
	public int dir;
	public boolean exist = true;     //存在标志变量;
	public void paint(Graphics g){
		g.drawImage(arrow[sel],x,y,wid,hig,null);	
	}
	public void astep(){
		if(this.dir == 1)
		{
			this.x+=speed;
			dis+=speed;
		}
		else{
			this.x-=speed;
			dis+=speed;
		}
	}
}
