package com.njfu.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Monster extends commonData{
	//music
	//血条
	public BufferedImage emptyblood;
	public BufferedImage blood;
	public int id;
	public int gold;
	//坐标
	public int x; 		//横坐标
	public int y;		//纵坐标
	public int wid;		//图片长度
	public int hig;		//图片宽度
	public int centerx = (x+x+wid)/2;     //物理中心x
	public int centery = (y+y+hig)/2;		//物理中心y
	//标志变量(状态)
	public boolean alive = true;		//存活标志变量,默认存活;
	public boolean  atk = false;			//攻击标志变量，默认无;
	public boolean  atkd = false;			//被击标志变量，默认无;
	public int dir=0; 						//方向变量。0左 1右;
	//动画帧数
	public int atkdindex;		//被攻击计数
	public int atkdnum;		//被攻击帧数
	public int atkaindex;		//攻击计数
	public int atkanum;			//攻击帧数
	public int atksindex;
	public int atksnum;
	public int walknum;
	public int walkindex;
	public int index;			//普通状态计数
	public int indexnum;		//普通状态帧数
	//属性
	public int relwid ; //怪物实际尺寸
	public int relhig ;	//怪物实际尺寸
	public int bloodnum;
	//动画图片
	public BufferedImage image;
	public BufferedImage wr1,wr2,wr3,wr4,wr5,wr6,wr7,wr8,wr9,wr10,wr11,wr12,wr13,wr14,wr15,wr16,wr17,wr18,
	wl1,wl2,wl3,wl4,wl5,wl6,wl7,wl8,wl9,wl10,wl11,wl12,wl13,wl14,wl15,wl16,wl17,wl18,
	std1,std2,std3,std4,std5,std6,std7,std8,std9,std10,
	atkd1,atkd2,atkd3,atkd4,atkd5,atkd6,atkd7,atkd8,atkd9,atkd10,atkd11,atkd12,atkd13,
	atk1,atk2,atk3,atk4,atk5,atk6,atk7,atk8,atk9,atk10,atk11;
	public BufferedImage[] std = {};
	public BufferedImage[] walkl = {};
	public BufferedImage[] walkr = {};
	public BufferedImage[] attacked = {};
	public BufferedImage[] attacka = {};
	public BufferedImage[] attacks = {};	
	
	//方法
	
	//物理中心确定:
	public void initcenter(){
		centerx = (x+x+wid)/2;    
		centery = (y+y+hig)/2;		
	}
	//防御判定：如果x码内存在玩家，朝玩家的方向进行攻击;
	public void monDefine(Hero h){
		if(Math.abs(h.centerx-centerx) < this.getDis() && Math.abs(h.centery-centery)<this.getDis() ){
			atk = true;
		}
		else 
			atk = false;
	}
	//受击判定:分为受伤和死亡两个状态;
	public void monAttacked(Weapon w){
		//从右往左
		if(w.dir == 1){
			if((w.x+w.wid >=centerx-relwid/2)&&(w.x+w.wid <=centerx+relwid/2)&&(w.y+w.hig/2 >=centery-relhig/2)&& (w.y+w.hig/2 <=centery+relhig/2) && atkd == false ){
				atkd = true;
				w.exist = false;
			}
		}
		//从左往右
		else {
			if((w.x>=centerx-relwid/2)&&(w.x<= centerx + relwid/2) && (w.y+w.hig/2 >=centery-relhig/2)&& (w.y+w.hig/2 <=centery+relhig/2) && atkd == false ){
				atkd = true;
				w.exist = false;
			}
		}
	}
	//攻击状态:
	public void MonsterAtk(Hero h){
		if(this.getCdrel() == 0 && h.atkd){
			this.setCdrel(this.getCd());
			h.setHealth_Point(h.getHealth_Point()-this.getAttack_Damage());
		}
		if(h.centerx - centerx >0){
			if(centerx == h.centerx){
				centerx = h.centerx;
			}
			else{
				x += this.getSpeed();
				centerx +=this.getSpeed();
			}
		}
		else{
			if(centerx == h.centerx){
				centerx = h.centerx;
			}
			else {
				x -= this.getSpeed();
				centerx -=this.getSpeed();
			}
		}
		if(h.centery - centery >0){
			if(centery == h.centery){
				centery = h.centery;
			}
			else{
				y += this.getSpeed();
				centery +=this.getSpeed();
			}
		}
		else {
			if(centery == h.centery){
				centery = h.centery;
			}
			else {
				y -= this.getSpeed();
				centery -=this.getSpeed();
			}
		}
		if(atkaindex == atkanum-1){
			atkaindex = 0;
		}
		image = attacka[atkaindex++ % atkanum];
	}
	//受击状态:如果死亡动画播放完毕,更新monster状态;
	public void MonsterAtkDd(Hero h){
		if(this.getHealth_Point()-h.getAttack_Damage()<=0){
			atkdnum = 11;
			if(atkdindex == 1){
				this.setHealth_Point(this.getHealth_Point()-h.getAttack_Damage());
			}
			if(atkdindex == atkdnum-1){
				atkdsounds(id,1);
				this.atkd = false;
				this.alive = false;
				atkdindex = 0;
			}
			image = attacked[atkdindex++ % atkdnum];
		}
		else{
			atkdnum = 6;
			if(atkdindex == atkdnum-1){
				atkdsounds(id,0);
				this.atkd = false;
				atkdindex = 0;
				this.setHealth_Point(this.getHealth_Point()-h.getAttack_Damage());
			}
			image = attacked[atkdindex++ % atkdnum];
			
		}
	}
	//普通状态:
	public void mStep(){ 
		if(index>=indexnum)
			index = 0;
		image = std[index++ % indexnum];
	}
	//声音
	public void atkdsounds(int id,int k){
		switch(id){
		case 0:MonSlimeSound.attackd(k);break;
		case 1:HaiBaoSounds.attackd(k);break;
		}
	}
	//绘图：
	public void paint(Graphics g){
		g.drawImage(image,x,y,wid,hig,null);
		g.drawImage(emptyblood,x+10,y,121,20,null);
		int temp1 = (int)((double)(120)*((double)this.getHealth_Point()/(double)this.bloodnum));
		g.drawImage(blood,x+10,y+13,temp1,7,null);
	}
}
