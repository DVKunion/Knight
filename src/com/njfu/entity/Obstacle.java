package com.njfu.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Obstacle {
	//坐标
	public int x; 		//横坐标
	public int y;		//纵坐标 
	public int wid;		//图片长度
	public int hig;		//图片宽度
	public int centerx = (x+x+wid)/2;     //物理中心x
	public int centery = (y+y+hig)/2;		//物理中心y
	public int relwid ; 
	public int relhig ;	
	public int sel;
	//图片
	public BufferedImage Obs;
	public BufferedImage Obs1,Obs2,Obs3,Obs4,Obs5,Obs6,Obs7,Obs8;
	public BufferedImage[] obstacle = {};
	public Obstacle(int x,int y,int sel){
		this.x =x;
		this.y =y;
		this.sel =sel;
		initcenter();
		initobs();
		obstacle = new BufferedImage[]{Obs1,Obs2,Obs3,Obs4,Obs5,Obs6,Obs7,Obs8};
		Obs = obstacle[sel];
		this.wid =Obs.getWidth();
		this.hig =Obs.getHeight();		
	}
	public void initcenter(){
		centerx = (x+x+wid)/2;    
		centery = (y+y+hig)/2;		
	}
	public void initobs(){
		try {
			Obs1 = ImageIO.read(new File("Image/Obstacle/bg1-01.png"));
			Obs2 = ImageIO.read(new File("Image/Obstacle/bg1-02.png"));
			Obs3 = ImageIO.read(new File("Image/Obstacle/bg1-03.png"));
			//Obs4 = ImageIO.read(new File("Image/Obstacle/1.png"));
			//Obs5 = ImageIO.read(new File("Image/Obstacle/1.png"));
			//Obs6 = ImageIO.read(new File("Image/Obstacle/1.png"));
			//Obs7 = ImageIO.read(new File("Image/Obstacle/1.png"));
			//Obs8 = ImageIO.read(new File("Image/Obstacle/1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//public void 
	public void paint(Graphics g){
		g.drawImage(Obs,x,y,wid,hig,null);	
	}
}
