package com.njfu.view;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.njfu.entity.ArchersArrow;
import com.njfu.entity.Map;
import com.njfu.entity.Player;
import com.njfu.entity.Weapon;

public class GamePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map map;
	Player p1;
	ArchersArrow arr;
	int cionnum=0;
	int cnt=0;
	int num3;
	boolean gameover = false;
	ArrayList <Weapon> weapon = new ArrayList<Weapon> ();
	int a = 0;
	public GamePanel(Player p) {
		p1 = p;
		map = new Map(1);
	}
	public void paint(Graphics g){
		super.paint(g);
		
		g.drawImage(map.map,map.mapx,0,4920,740,null);
		for(int i=0;i<map.obstacle.size();i++){
			if(map.obstacle.get(i).x+map.obstacle.get(i).wid<0 )
				map.obstacle.remove(i);
			else map.obstacle.get(i).paint(g);
		}
		p1.getHero().paint(g);
		//画怪
		for(int i=0;i<map.monster.size();i++){
			if(map.monster.get(i).alive == false){
				p1.setGoldnum(p1.getGoldnum()+map.monster.get(i).gold);
				cionnum+=map.monster.get(i).gold;
				map.monster.remove(i);
			}
			else map.monster.get(i).paint(g);
		}
		//画攻击
		for(int i=0;i<weapon.size();i++){
			if(weapon.get(i).dis >= p1.getHero().getDis() || !weapon.get(i).exist)
				weapon.remove(i);
			else {
				weapon.get(i).paint(g);
			}
		}
	}
	public void makeArrow(int x,int y,int s){
		arr = new ArchersArrow(x,y,s,p1.getHero().dir);
		weapon.add(arr);
	}
	public void Mapstep(){
		boolean flag = true;
		for(int i =0;i<map.monster.size();i++){
			if(map.monster.get(i).x<980){
				flag = false;
			}
		}
		if(flag){
			if(map.mapx <= -3600)
				map.mapx = -3600;
			else if(map.mapx == -3525){
				p1.getHero().last();
			}
			else if(p1.getHero().run == 4 && p1.getHero().x >= (980*2/3)){
				map.mapx -= p1.getHero().getSpeed();
			}
			if(map.mapx == 0){
				p1.getHero().minx = 200;
			}
		}
	}
	public void HeroStep(){
		if(p1.getHero().alive == false || map.monster.size()<=0){
			gameover = true;
		}
		if(num3 != 0){
			num3--;
		}
		else{
			p1.getHero().setSpeed(p1.getHero().getTspeed());
		}
		for(int i=0;i<map.monster.size();i++){
			if(map.monster.get(i).centerx-map.monster.get(i).relwid/2 < p1.getHero().centerx+p1.getHero().relwid/2&&
					map.monster.get(i).centerx+map.monster.get(i).relwid/2 > p1.getHero().centerx+p1.getHero().relwid/2&&
					map.monster.get(i).centery-map.monster.get(i).relhig/2 > p1.getHero().centery-p1.getHero().relhig/2&&
					map.monster.get(i).centery+map.monster.get(i).relhig/2 <p1.getHero().centery+p1.getHero().relhig/2){
				p1.getHero().atkd =true;
			}
			if(p1.getHero().atkd){
				map.monster.get(i).setSpeed(0);
			}
			else{
				map.monster.get(i).setSpeed(map.monster.get(i).getTspeed());
			}
		}
		p1.getHero().step();
		//System.out.println(p1.getHealth_Point());
		//System.out.println(p1.centerx-p1.relwid/2+" "+(p1.centerx + p1.relwid/2)+" "+(p1.centery-p1.relhig/2)+" "+(p1.centery+p1.relhig/2));
		//System.out.println(p1.x+" "+p1.y+" ");
	}
	public void WeaponStep(){
		for(int i=0;i<weapon.size();i++){
			for(int j=0;j<map.monster.size();j++)
				map.monster.get(j).monAttacked(weapon.get(i));
			weapon.get(i).astep();
		}
	}
	public void MonsterStep(){
		boolean flag = true;
		for(int i=0;i<map.monster.size();i++){
			map.monster.get(i).monDefine(p1.getHero());
			if(map.monster.get(i).atkd){
				map.monster.get(i).MonsterAtkDd(p1.getHero());
			}
			else if(map.monster.get(i).atk)
				map.monster.get(i).MonsterAtk(p1.getHero());
			else if(map.monster.get(i).alive)
				map.monster.get(i).mStep();
			if(map.monster.get(i).x<980){
				flag = false;
			}
			if(p1.getHero().run == 4 && p1.getHero().x >= (980*2/3) && (map.monster.get(i).x + map.mapx <980)&&flag){
				map.monster.get(i).x -= p1.getHero().getSpeed();
				map.monster.get(i).centerx -= p1.getHero().getSpeed();
			}
		}
	}
	public void ObstacleStep(){
		for(int i=0;i<map.obstacle.size();i++){
			//障碍物与人判定
			if(map.obstacle.get(i).x <1280 ){
				if(p1.getHero().centerx + p1.getHero().relwid/2 >= map.obstacle.get(i).x &&
						p1.getHero().centerx - p1.getHero().relwid/2 <= map.obstacle.get(i).x &&
						p1.getHero().centery + p1.getHero().relhig/2 <= map.obstacle.get(i).y+map.obstacle.get(i).hig &&
						p1.getHero().centery + p1.getHero().relhig/2 >= map.obstacle.get(i).y+30){
					p1.getHero().maxx=map.obstacle.get(i).x+p1.getHero().relwid/2+p1.getHero().wid/2;
				}
				else p1.getHero().maxx = 980;
				if(p1.getHero().centerx - p1.getHero().relwid/2 <=map.obstacle.get(i).x +map.obstacle.get(i).wid &&
						p1.getHero().centerx + p1.getHero().relwid/2 >=map.obstacle.get(i).x +map.obstacle.get(i).wid &&
						p1.getHero().centery + p1.getHero().relhig/2 <= map.obstacle.get(i).y+map.obstacle.get(i).hig &&
						p1.getHero().centery + p1.getHero().relhig/2 >= map.obstacle.get(i).y+30){
					p1.getHero().minx =p1.getHero().x;
				}
				else p1.getHero().minx = 0;
				if(((p1.getHero().centerx + p1.getHero().relwid/2-20>=map.obstacle.get(i).x &&
						p1.getHero().centerx + p1.getHero().relwid/2-20<=map.obstacle.get(i).x+map.obstacle.get(i).wid)||
						((p1.getHero().centerx - p1.getHero().relwid/2+20>=map.obstacle.get(i).x &&
							p1.getHero().centerx - p1.getHero().relwid/2+20<=map.obstacle.get(i).x+map.obstacle.get(i).wid)))&&
						p1.getHero().centery + p1.getHero().relhig/2 -20<= map.obstacle.get(i).y+map.obstacle.get(i).hig+10 &&
						p1.getHero().centery - p1.getHero().relhig/2 >= map.obstacle.get(i).y){
					p1.getHero().miny =map.obstacle.get(i).y+map.obstacle.get(i).hig-p1.getHero().relhig/2-p1.getHero().hig/2;
				}
				else p1.getHero().miny = 200;
				if(((p1.getHero().centerx + p1.getHero().relwid/2-20>=map.obstacle.get(i).x &&
						p1.getHero().centerx + p1.getHero().relwid/2-20<=map.obstacle.get(i).x+map.obstacle.get(i).wid)||
						((p1.getHero().centerx - p1.getHero().relwid/2+20>=map.obstacle.get(i).x &&
							p1.getHero().centerx - p1.getHero().relwid/2+20<=map.obstacle.get(i).x+map.obstacle.get(i).wid)))&&
						p1.getHero().centery + p1.getHero().relhig/2 >=map.obstacle.get(i).y &&
						p1.getHero().centery - p1.getHero().relhig/2 <=map.obstacle.get(i).y ){
					p1.getHero().maxy =map.obstacle.get(i).y-p1.getHero().relhig/2-p1.getHero().hig/2;
				}
				else p1.getHero().maxy = 550;
			}
			//障碍物与怪判定
			
			//移动判定
			boolean flag = true;
			for(int j =0;j<map.monster.size();j++){
				if(map.monster.get(j).x<980){
					flag = false;
				}
			}
			if(p1.getHero().run == 4 && p1.getHero().x >= (980*2/3) && (map.obstacle.get(i).x + map.mapx <980)&&flag){
				map.obstacle.get(i).x -= p1.getHero().getSpeed();
				map.obstacle.get(i).centerx -= p1.getHero().getSpeed();
			}
		}
	}
	public void cdStep(){
		if(p1.getHero().getCdrel() != 0){
			p1.getHero().setCdrel(p1.getHero().getCdrel()-1);
		}
		if(p1.getHero().getRemagicnum() != 0){
			p1.getHero().setRemagicnum(p1.getHero().getRemagicnum()-1);
		}
		if(p1.getHero().getRemagicnum() == 0 &&p1.getHero().getMana_Point()<100){
			p1.getHero().setRemagicnum(p1.getHero().getRemagic());
			p1.getHero().setMana_Point(p1.getHero().getMana_Point()+1);
		}
		for(int i=0;i<4;i++){
			if(p1.getHero().cdSrel[i] != 0){
				p1.getHero().cdSrel[i] = p1.getHero().cdSrel[i]-1;
			}
		}
		for(int i=0;i<map.monster.size();i++){
			if(map.monster.get(i).getCdrel() != 0){
				map.monster.get(i).setCdrel(map.monster.get(i).getCdrel()-1);
			}
		}
	}
	public void runpaint(){
		//位移线程
		new Thread(){
			public void run(){
				super.run();
				while(!gameover){
					Mapstep();
					HeroStep();
					WeaponStep();
					MonsterStep();	
					ObstacleStep();
					cdStep();
					repaint();
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
