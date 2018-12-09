package com.njfu.entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Haibao extends Monster{
	public Haibao(int x1,int y1){
		this.id =1;
		this.gold = 50;
		this.x = x1;
		this.y = y1;
		this.wid=107;
		this.hig=92;
		this.setSpeed(3);
		this.setTspeed(3);
		this.atkanum = 8;
		this.atkdnum = 11;
		this.walknum = 5;
		this.indexnum = 7;
		this.relwid = 80;
		this.relhig = 70;
		this.setAttack_Damage(10);
		this.setDis(600);
		this.setCd(20);
		this.cdS = new int[]{40,0,0,0};
		this.cdSrel = new int[]{0,0,0,0};
		this.atksindex = 0;
		this.atksnum = 0;
		this.bloodnum = 150;
		this.setCdrel(0);
		initcenter();
		initHaibao();
		this.setHealth_Point(this.bloodnum);
		this.setExperience_Pecent(10);
		this.std = new BufferedImage[] {std1,std2,std3,std4,std5,std6,std7};
		this.walkl = new BufferedImage[] {wl1,wl2,wl3,wl4,wl5};
		this.attacka = new BufferedImage[] {atk1,atk2,atk3,atk4,atk5,atk6,atk7,atk8};
		this.attacked = new BufferedImage[] {atkd1,atkd2,atkd3,atkd4,atkd5,atkd6,atkd7,atkd8,atkd9,atkd10,atkd11,atkd12,atkd13};
	}
	public void initHaibao(){
		try {
			emptyblood =ImageIO.read(new File("image/monster/haibao/seadog.png"));
			blood = ImageIO.read(new File("image/monster/slime/bloodbar.png"));
			std1 = ImageIO.read(new File("image/monster/haibao/stand/1.png"));
			std2 = ImageIO.read(new File("image/monster/haibao/stand/2.png"));
			std3 = ImageIO.read(new File("image/monster/haibao/stand/3.png"));
			std4 = ImageIO.read(new File("image/monster/haibao/stand/4.png"));
			std5 = ImageIO.read(new File("image/monster/haibao/stand/5.png"));
			std6 = ImageIO.read(new File("image/monster/haibao/stand/6.png"));
			std7 = ImageIO.read(new File("image/monster/haibao/stand/7.png"));
			wl1 = ImageIO.read(new File("image/monster/haibao/walk/1.png"));
			wl2 = ImageIO.read(new File("image/monster/haibao/walk/2.png"));
			wl3 = ImageIO.read(new File("image/monster/haibao/walk/3.png"));
			wl4 = ImageIO.read(new File("image/monster/haibao/walk/4.png"));
			wl5 = ImageIO.read(new File("image/monster/haibao/walk/5.png"));
			atkd1 = ImageIO.read(new File("image/monster/haibao/die/1.png"));
			atkd2 = ImageIO.read(new File("image/monster/haibao/die/2.png"));
			atkd3 = ImageIO.read(new File("image/monster/haibao/die/3.png"));
			atkd4 = ImageIO.read(new File("image/monster/haibao/die/4.png"));
			atkd5 = ImageIO.read(new File("image/monster/haibao/die/5.png"));
			atkd6 = ImageIO.read(new File("image/monster/haibao/die/6.png"));
			atkd7 = ImageIO.read(new File("image/monster/haibao/die/7.png"));
			atkd8 = ImageIO.read(new File("image/monster/haibao/die/8.png"));
			atkd9 = ImageIO.read(new File("image/monster/haibao/die/9.png"));
			atkd10 = ImageIO.read(new File("image/monster/haibao/die/10.png"));
			atkd11 = ImageIO.read(new File("image/monster/haibao/die/11.png"));
			atk1 = ImageIO.read(new File("image/monster/haibao/attack/1.png"));
			atk2 = ImageIO.read(new File("image/monster/haibao/attack/1.png"));
			atk3 = ImageIO.read(new File("image/monster/haibao/attack/2.png"));
			atk4 = ImageIO.read(new File("image/monster/haibao/attack/2.png"));
			atk5 = ImageIO.read(new File("image/monster/haibao/attack/3.png"));
			atk6 = ImageIO.read(new File("image/monster/haibao/attack/3.png"));
			atk7 = ImageIO.read(new File("image/monster/haibao/attack/4.png"));
			atk8 = ImageIO.read(new File("image/monster/haibao/attack/4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
