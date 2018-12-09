package com.njfu.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Hero extends commonData{
	//Ѫ��
	public MusicPlayer gongji;
	public MusicPlayer shoushang;
	public MusicPlayer siwang;
	public BufferedImage emptyblood;
	public BufferedImage blood;
	//����
	public BufferedImage emptymagic;
	public BufferedImage magic;
	//���ܿ�
	public BufferedImage skillbox;
	//����
	public BufferedImage skill1,skill2,skill3,skill4,skilln1,skilln2,skilln3,skilln4;
	//����
	public BufferedImage th1,th2,th3;
	//����
	public int x; 		//�����꣬����ʱ¼��
	public int y;		//������,����ʱ¼��
	public int wid;		//ͼƬ����
	public int hig;		//ͼƬ���
	public int centerx = (x+x+wid)/2;     //��������x
	public int centery = (y+y+hig)/2;		//��������y
	public int maxx,minx;					//��ǰ��Զ����x
	public int maxy,miny;					//��ǰ��Զ����y
	public int relwid ; 					//����ʵ�ʳߴ�
	public int relhig ;						//����ʵ�ʳߴ�
	//��־����(״̬)
	public boolean alive = true;		//����־����,Ĭ�ϴ��;
	public boolean  atk = false;			//������־������Ĭ����;
	public boolean  atkd = false;			//������־������Ĭ����;
	public int run = 0;							//�ƶ���־����;
	public int dir; 						//���������0�� 1��;
	//����֡��
	public int atkdindex;		//����������
	public int atkdnum;		//������֡��
	public int atkindex;		//��������
	public int atknum;			//����֡��
	public int index;			//��ͨ״̬����
	public int indexnum;		//��ͨ״̬֡��
	public int walkindex;		//���߼���
	public int walknum;			//����֡��
	
	public BufferedImage image; //ÿһ֡���;
	public BufferedImage wr1,wr2,wr3,wr4,wr5,wr6,wr7,
	wl1,wl2,wl3,wl4,wl5,wl6,wl7,
	stdr1,stdr2,stdr3,stdr4,stdr5,stdr6,
	stdl1,stdl2,stdl3,stdl4,stdl5,stdl6,
	atkd1,atkd2,atkd3,atkd4,atkd5,atkd6,atkd7,atkd8,atkd9,atkd10,
	atkr1,atkr2,atkr3,atkr4,atkr5,atkr6,atkr7,atkr8,
	atkl1,atkl2,atkl3,atkl4,atkl5,atkl6,atkl7,atkl8;;
	
	public BufferedImage[] walkr = {};
	public BufferedImage[] walkl = {};
	public BufferedImage[] stdl = {};
	public BufferedImage[] stdr = {};
	public BufferedImage[] attacked = {};
	public BufferedImage[] attackr = {};
	public BufferedImage[] attackl = {};

	public void initcenter(){
		centerx = (x+x+wid)/2;    
		centery = (y+y+hig)/2;		
	}
	public void step(){
		//�����ж�
		if(atk){
			if(dir == 1){
				if(atkindex < atknum)
					image =	attackr[atkindex++];
				else{
					image =stdr[index++ % indexnum];
					atk = false;
					atkindex = 0;
				}
			}
			else if(dir == 0){
				if(atkindex < atknum)
					image =	attackl[atkindex++];
				else{
					image =stdl[index++ % indexnum];
					atk = false;
					atkindex = 0;
				}
			}
		}
		//�ƶ��ж�
		else if(run != 0){
			if(dir == 0){
				switch(run){
				case 1: {
					if(y<=miny)
						y=miny;
					else this.y -= getSpeed();
					initcenter();
					image =	walkl[walkindex++% walknum];
					if(walkindex >10000){
						walkindex = 0;
					}
					break;
				}
				case 2:{
					if(y>=maxy)
						y=maxy; 
					else y += getSpeed();
					initcenter();
					image =	walkl[walkindex++% walknum];
					if(walkindex >10000){
						walkindex = 0;
					}
					break;
				}
				case 3:{
					if(x<=minx)
						x=minx;
					else x-=getSpeed();
					initcenter();
					image =	walkl[walkindex++% walknum];
					if(walkindex >10000){
						walkindex = 0;
					}
					break;
				}
				case 4:{
					if(x>=maxx*2/3)
						x=maxx*2/3;
					else x+=getSpeed();
					initcenter();
					image =	walkl[walkindex++% walknum];
					if(walkindex >10000){
						walkindex = 0;
					}
					break;
				}
				}
			}
			else {
				switch(run){
				case 1: {
					y -= getSpeed();
					if(y<=miny)
						y=miny;
					initcenter();
					image =	walkr[walkindex++% walknum];
					if(walkindex >10000){
						walkindex = 0;
					}
					break;
				}
				case 2: {
					y += getSpeed();
					if(y>=maxy)
						y=maxy;
					initcenter();
					image =	walkr[walkindex++% walknum];
					if(walkindex >10000){
						walkindex = 0;
					}
					break;
				}
				case 3:{
					x-=getSpeed();
					if(x<=minx)
						x=minx;
					initcenter();
					image =	walkr[walkindex++% walknum];
					if(walkindex >10000){
						walkindex = 0;
					}
					break;
				}
				case 4:{
					x+=getSpeed();
					if(x>=maxx*2/3)
						x=maxx*2/3;
					initcenter();
					image =	walkr[walkindex++% walknum];
					if(walkindex >10000){
						walkindex = 0;
					}
					break;
				}
				}
			}
		}
		//�������ж�
		else if(atkd){
			
			if(getHealth_Point() <= 0){
				if(atkdindex == atkdnum-1){
					ArcherSounds.damage(1);
				}
				if(atkdindex < atkdnum)
					image =	attacked[atkdindex++];
				else{
					image =stdl[index++ % indexnum];
					atkd = false;
					alive = false;
					atkdindex = 0;
				}
			}
			else{
				if(atkdindex == atkdnum-7){
					ArcherSounds.damage(0);
				}
				if(atkdindex < atkdnum-6)
					image =	attacked[atkdindex++];
				else{
					image =stdl[index++ % indexnum];
					atkdindex = 0;
				}
			}
		}
		
		else switch(dir){	
		case 0: {
			image =	stdl[index++% indexnum];
			if(index >10000){
				index = 0;
			}
			break;
		}
		case 1:{
			image =	stdr[index++% indexnum];
			if(index >10000){
				index = 0;
			}
			break;
		}
		}
	}
	public void last(){
		if(y>=450 && y<=550){
			maxx = 580;
		}
		else{
			maxx = 880;
		}
		if(x > 580 && x <=880){
			maxy = 400;
		}
		else{
			maxy = 550;
		}
	}
	
	public void paint(Graphics g){
		g.drawImage(image,x,y,wid,hig,null);
		g.drawImage(skillbox,255,648,755,98,null);
		g.drawImage(th1,330,700,14,22,null);
		g.drawImage(th2,385,700,14,22,null);
		g.drawImage(th3,440,700,14,22,null);
		if(getCdrel() != 0){
			g.drawImage(skilln1,739,690,44,44,null);
		}
		else g.drawImage(skill1,739,690,44,44,null);
		if(cdSrel[0] != 0 || getMana_Point() < mananum[0]){
			g.drawImage(skilln2,793,690,44,44,null);
		}
		else g.drawImage(skill2,793,690,44,44,null);
		if(cdSrel[1] != 0 ||getMana_Point() < mananum[1]){
			g.drawImage(skilln3,846,690,44,44,null);
		}
		else g.drawImage(skill3,846,690,44,44,null);
		if(cdSrel[2] != 0 ||getMana_Point() < mananum[2]){
			g.drawImage(skilln4,902,690,44,44,null);
		}
		else g.drawImage(skill4,902,690,44,44,null);
		g.drawImage(emptyblood,50,50,357,30,null);
		g.drawImage(emptyblood,50,80,320,25,null);
		int temp1 = (int)((double)(357-45)*((double)this.getHealth_Point()/(double)100));
		int temp2 = (int)((double)(320-45)*((double)this.getMana_Point()/(double)100));
		if(temp1 >=0){
			g.drawImage(blood,73,59,temp1,13,null);
		}
		if(temp2 >=0){
			g.drawImage(magic,73,89,temp2,13,null);
		}
	}
}
