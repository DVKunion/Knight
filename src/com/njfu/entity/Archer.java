package com.njfu.entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Archer extends Hero{
	public Archer(){
		this.gongji=new MusicPlayer("sounds/player/archer/attack/4016_shout.wav");
		this.shoushang = new MusicPlayer("sounds/player/archer/attack/4031_damage.wav");
		this.siwang = new MusicPlayer("sounds/player/archer/attack/4031_die.wav");
		this.x = 400;
		this.y = 350;
		this.wid = 204;
		this.hig = 186;
		this.relwid = 80;
		this.relhig = 110;
		this.indexnum=6;
		this.walknum=7;
		this.atknum = 8;
		this.atkdnum = 10;
		this.maxx =980;
		this.maxy =500;
		this.miny =200;
		this.minx =0;
		this.dir = 1;
		this.alive = true;
		initArcher();
		initcenter();
		setData();
		this.walkr = new BufferedImage[] {wr1,wr2,wr3,wr4,wr5,wr6,wr7};
		this.walkl =	new BufferedImage[] {wl1,wl2,wl3,wl4,wl5,wl6,wl7};
		this.stdr =	new BufferedImage[] {stdr1,stdr2,stdr3,stdr4,stdr5,stdr6};
		this.stdl =	new BufferedImage[] {stdl1,stdl2,stdl3,stdl4,stdl5,stdl6};
		this.attacked = new BufferedImage[] {atkd1,atkd2,atkd3,atkd4,atkd5,atkd6,atkd7,atkd8,atkd9,atkd10};
		this.attackr = new BufferedImage[] {atkr1,atkr2,atkr3,atkr4,atkr5,atkr6,atkr7,atkr8};
		this.attackl = new BufferedImage[] {atkl1,atkl2,atkl3,atkl4,atkl5,atkl6,atkl7,atkl8};
	}
	public void initArcher() {
		// ¶ÁÈ¡Í¼Æ¬£¬¸øÍ¼Æ¬¸³Öµ£»
		try {
			th1 = ImageIO.read(new File("image/things/1.png"));
			th2 = ImageIO.read(new File("image/things/2.png"));
			th3 = ImageIO.read(new File("image/things/3.png"));
			skilln1 = ImageIO.read(new File("image/hero/archer/skill/black1.png"));
			skilln2 = ImageIO.read(new File("image/hero/archer/skill/black2.png"));
			skilln3 = ImageIO.read(new File("image/hero/archer/skill/black3.png"));
			skilln4 = ImageIO.read(new File("image/hero/archer/skill/black4.png"));
			skill1 = ImageIO.read(new File("image/hero/archer/skill/1.png"));
			skill2 = ImageIO.read(new File("image/hero/archer/skill/2.png"));
			skill3 = ImageIO.read(new File("image/hero/archer/skill/3.png"));
			skill4 = ImageIO.read(new File("image/hero/archer/skill/4.png"));
			skillbox = ImageIO.read(new File("image/hero/archer/skillbox.png"));
			magic = ImageIO.read(new File("image/hero/archer/fmagic.png"));
			emptymagic= ImageIO.read(new File("image/hero/archer/eblood.png"));
			blood = ImageIO.read(new File("image/hero/archer/fblood.png"));
			emptyblood = ImageIO.read(new File("image/hero/archer/eblood.png"));
			stdr1 = ImageIO.read(new File("image/hero/archer/standr/1.png"));
			stdr2 = ImageIO.read(new File("image/hero/archer/standr/1.png"));
			stdr3 = ImageIO.read(new File("image/hero/archer/standr/1.png"));
			stdr4 = ImageIO.read(new File("image/hero/archer/standr/2.png"));
			stdr5 = ImageIO.read(new File("image/hero/archer/standr/2.png"));
			stdr6 = ImageIO.read(new File("image/hero/archer/standr/2.png"));
			stdl1 = ImageIO.read(new File("image/hero/archer/standl/1.png"));
			stdl2 = ImageIO.read(new File("image/hero/archer/standl/1.png"));
			stdl3 = ImageIO.read(new File("image/hero/archer/standl/1.png"));
			stdl4 = ImageIO.read(new File("image/hero/archer/standl/2.png"));
			stdl5 = ImageIO.read(new File("image/hero/archer/standl/2.png"));
			stdl6 = ImageIO.read(new File("image/hero/archer/standl/2.png"));
			wl1 = ImageIO.read(new File("image/hero/archer/walkl/1.png"));
			wl2 = ImageIO.read(new File("image/hero/archer/walkl/2.png"));
			wl3 = ImageIO.read(new File("image/hero/archer/walkl/3.png"));
			wl4 = ImageIO.read(new File("image/hero/archer/walkl/4.png"));
			wl5 = ImageIO.read(new File("image/hero/archer/walkl/5.png"));
			wl6 = ImageIO.read(new File("image/hero/archer/walkl/6.png"));
			wl7 = ImageIO.read(new File("image/hero/archer/walkl/7.png"));
			wr1 = ImageIO.read(new File("image/hero/archer/walkr/1.png"));
			wr2 = ImageIO.read(new File("image/hero/archer/walkr/2.png"));
			wr3 = ImageIO.read(new File("image/hero/archer/walkr/3.png"));
			wr4 = ImageIO.read(new File("image/hero/archer/walkr/4.png"));
			wr5 = ImageIO.read(new File("image/hero/archer/walkr/5.png"));
			wr6 = ImageIO.read(new File("image/hero/archer/walkr/6.png"));
			wr7 = ImageIO.read(new File("image/hero/archer/walkr/7.png"));
			atkd1 = ImageIO.read(new File("image/hero/archer/attacked/1.png"));
			atkd2 = ImageIO.read(new File("image/hero/archer/attacked/1.png"));
			atkd3 = ImageIO.read(new File("image/hero/archer/attacked/2.png"));
			atkd4 = ImageIO.read(new File("image/hero/archer/attacked/2.png"));
			atkd5 = ImageIO.read(new File("image/hero/archer/attacked/3.png"));
			atkd6 = ImageIO.read(new File("image/hero/archer/attacked/4.png"));
			atkd7 = ImageIO.read(new File("image/hero/archer/attacked/5.png"));
			atkd8 = ImageIO.read(new File("image/hero/archer/attacked/5.png"));
			atkd9 = ImageIO.read(new File("image/hero/archer/attacked/5.png"));
			atkd10 = ImageIO.read(new File("image/hero/archer/attacked/5.png"));
			atkr1 = ImageIO.read(new File("image/hero/archer/attackr/1.png"));
			atkr2 = ImageIO.read(new File("image/hero/archer/attackr/2.png"));
			atkr3 = ImageIO.read(new File("image/hero/archer/attackr/3.png"));
			atkr4 = ImageIO.read(new File("image/hero/archer/attackr/4.png"));
			atkr5 = ImageIO.read(new File("image/hero/archer/attackr/5.png"));
			atkr6 = ImageIO.read(new File("image/hero/archer/attackr/6.png"));
			atkr7 = ImageIO.read(new File("image/hero/archer/attackr/7.png"));
			atkr8 = ImageIO.read(new File("image/hero/archer/attackr/8.png"));
			atkl1 = ImageIO.read(new File("image/hero/archer/attackl/1.png"));
			atkl2 = ImageIO.read(new File("image/hero/archer/attackl/2.png"));
			atkl3 = ImageIO.read(new File("image/hero/archer/attackl/3.png"));
			atkl4 = ImageIO.read(new File("image/hero/archer/attackl/4.png"));
			atkl5 = ImageIO.read(new File("image/hero/archer/attackl/5.png"));
			atkl6 = ImageIO.read(new File("image/hero/archer/attackl/6.png"));
			atkl7 = ImageIO.read(new File("image/hero/archer/attackl/7.png"));
			atkl8 = ImageIO.read(new File("image/hero/archer/attackl/8.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void setData(){
		this.setHealth_Point(100);
		this.setMana_Point(100);
		this.setSpeed(10);
		this.setTspeed(10);
		this.setDis(450);
		this.setCd(10);
		this.setCdrel(0);
		this.setRemagic(30);
		this.setRemagicnum(30);
		this.setAttack_Damage(10);
		this.cdS = new int[]{30,40,50,120};
		this.cdSrel = new int[]{0,0,0,0};
		this.mananum = new int[]{10,20,50,90};
	}
}	
