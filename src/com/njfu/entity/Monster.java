package com.njfu.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Monster extends commonData{
	//music
	//Ѫ��
	public BufferedImage emptyblood;
	public BufferedImage blood;
	public int id;
	public int gold;
	//����
	public int x; 		//������
	public int y;		//������
	public int wid;		//ͼƬ����
	public int hig;		//ͼƬ���
	public int centerx = (x+x+wid)/2;     //��������x
	public int centery = (y+y+hig)/2;		//��������y
	//��־����(״̬)
	public boolean alive = true;		//����־����,Ĭ�ϴ��;
	public boolean  atk = false;			//������־������Ĭ����;
	public boolean  atkd = false;			//������־������Ĭ����;
	public int dir=0; 						//���������0�� 1��;
	//����֡��
	public int atkdindex;		//����������
	public int atkdnum;		//������֡��
	public int atkaindex;		//��������
	public int atkanum;			//����֡��
	public int atksindex;
	public int atksnum;
	public int walknum;
	public int walkindex;
	public int index;			//��ͨ״̬����
	public int indexnum;		//��ͨ״̬֡��
	//����
	public int relwid ; //����ʵ�ʳߴ�
	public int relhig ;	//����ʵ�ʳߴ�
	public int bloodnum;
	//����ͼƬ
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
	
	//����
	
	//��������ȷ��:
	public void initcenter(){
		centerx = (x+x+wid)/2;    
		centery = (y+y+hig)/2;		
	}
	//�����ж������x���ڴ�����ң�����ҵķ�����й���;
	public void monDefine(Hero h){
		if(Math.abs(h.centerx-centerx) < this.getDis() && Math.abs(h.centery-centery)<this.getDis() ){
			atk = true;
		}
		else 
			atk = false;
	}
	//�ܻ��ж�:��Ϊ���˺���������״̬;
	public void monAttacked(Weapon w){
		//��������
		if(w.dir == 1){
			if((w.x+w.wid >=centerx-relwid/2)&&(w.x+w.wid <=centerx+relwid/2)&&(w.y+w.hig/2 >=centery-relhig/2)&& (w.y+w.hig/2 <=centery+relhig/2) && atkd == false ){
				atkd = true;
				w.exist = false;
			}
		}
		//��������
		else {
			if((w.x>=centerx-relwid/2)&&(w.x<= centerx + relwid/2) && (w.y+w.hig/2 >=centery-relhig/2)&& (w.y+w.hig/2 <=centery+relhig/2) && atkd == false ){
				atkd = true;
				w.exist = false;
			}
		}
	}
	//����״̬:
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
	//�ܻ�״̬:������������������,����monster״̬;
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
	//��ͨ״̬:
	public void mStep(){ 
		if(index>=indexnum)
			index = 0;
		image = std[index++ % indexnum];
	}
	//����
	public void atkdsounds(int id,int k){
		switch(id){
		case 0:MonSlimeSound.attackd(k);break;
		case 1:HaiBaoSounds.attackd(k);break;
		}
	}
	//��ͼ��
	public void paint(Graphics g){
		g.drawImage(image,x,y,wid,hig,null);
		g.drawImage(emptyblood,x+10,y,121,20,null);
		int temp1 = (int)((double)(120)*((double)this.getHealth_Point()/(double)this.bloodnum));
		g.drawImage(blood,x+10,y+13,temp1,7,null);
	}
}
