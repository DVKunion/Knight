package com.njfu.entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MonSlime extends Monster{
	public MonSlime(int x1,int y1){
		this.gold = 10;
		this.x = x1;
		this.y = y1;
		this.wid=140;
		this.hig=145;
		this.setSpeed(3);
		this.setTspeed(3);
		this.atkanum = 14;
		this.atkdnum = 11;
		this.indexnum = 8;
		this.relwid = 60;
		this.relhig = 65;
		this.atksindex = 0;
		this.atksnum = 0;
		this.bloodnum = 50;
		this.setAttack_Damage(1);
		this.setDis(300);
		this.setCd(20);
		this.setCdrel(0);
		this.setHealth_Point(this.bloodnum);
		this.setExperience_Pecent(10);
		initcenter();
		initMonSlime();
		this.std = new BufferedImage[] {std1,std2,std3,std4,std5,std6,std7,std8};
		this.walkl = new BufferedImage[] {wl1,wl2,wl3,wl4,wl5,wl6,wl7,wl8,wl9,wl10,wl11,wl12,wl13,wl14};
		this.attacka = new BufferedImage[] {wl1,wl2,wl3,wl4,wl5,wl6,wl7,wl8,wl9,wl10,wl11,wl12,wl13,wl14};
		this.attacked = new BufferedImage[] {atkd1,atkd2,atkd3,atkd4,atkd5,atkd6,atkd7,atkd8,atkd9,atkd10,atkd11};
	}
	public void initMonSlime(){
		try {
			emptyblood =ImageIO.read(new File("image/monster/slime/bar.png"));
			blood = ImageIO.read(new File("image/monster/slime/bloodbar.png"));
			std1 = ImageIO.read(new File("image/monster/slime/standl/2.png"));
			std2 = ImageIO.read(new File("image/monster/slime/standl/2.png"));
			std3 = ImageIO.read(new File("image/monster/slime/standl/2.png"));
			std4 = ImageIO.read(new File("image/monster/slime/standl/2.png"));
			std5 = ImageIO.read(new File("image/monster/slime/standl/3.png"));
			std6 = ImageIO.read(new File("image/monster/slime/standl/3.png"));
			std7 = ImageIO.read(new File("image/monster/slime/standl/3.png"));
			std8 = ImageIO.read(new File("image/monster/slime/standl/3.png"));
			wl1 = ImageIO.read(new File("image/monster/slime/walkl/1.png"));
			wl2 = ImageIO.read(new File("image/monster/slime/walkl/2.png"));
			wl3 = ImageIO.read(new File("image/monster/slime/walkl/3.png"));
			wl4 = ImageIO.read(new File("image/monster/slime/walkl/4.png"));
			wl5 = ImageIO.read(new File("image/monster/slime/walkl/5.png"));
			wl6 = ImageIO.read(new File("image/monster/slime/walkl/6.png"));
			wl7 = ImageIO.read(new File("image/monster/slime/walkl/7.png"));
			wl8 = ImageIO.read(new File("image/monster/slime/walkl/8.png"));
			wl9 = ImageIO.read(new File("image/monster/slime/walkl/9.png"));
			wl10 = ImageIO.read(new File("image/monster/slime/walkl/10.png"));
			wl11 = ImageIO.read(new File("image/monster/slime/walkl/11.png"));
			wl12 = ImageIO.read(new File("image/monster/slime/walkl/12.png"));
			wl13 = ImageIO.read(new File("image/monster/slime/walkl/13.png"));
			wl14 = ImageIO.read(new File("image/monster/slime/walkl/14.png"));
			atkd1 = ImageIO.read(new File("image/monster/slime/die/1.png"));
			atkd2 = ImageIO.read(new File("image/monster/slime/die/2.png"));
			atkd3 = ImageIO.read(new File("image/monster/slime/die/3.png"));
			atkd4 = ImageIO.read(new File("image/monster/slime/die/4.png"));
			atkd5 = ImageIO.read(new File("image/monster/slime/die/5.png"));
			atkd6 = ImageIO.read(new File("image/monster/slime/die/6.png"));
			atkd7 = ImageIO.read(new File("image/monster/slime/die/7.png"));
			atkd8 = ImageIO.read(new File("image/monster/slime/die/8.png"));
			atkd9 = ImageIO.read(new File("image/monster/slime/die/9.png"));
			atkd10 = ImageIO.read(new File("image/monster/slime/die/10.png"));
			atkd11 = ImageIO.read(new File("image/monster/slime/die/11.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
