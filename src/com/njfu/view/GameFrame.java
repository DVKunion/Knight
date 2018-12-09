package com.njfu.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.njfu.entity.ArcherSounds;
import com.njfu.entity.MyFrame;
import com.njfu.entity.Player;

public class GameFrame extends MyFrame{
	GamePanel g;
	private static final long serialVersionUID = 1L;
	public GameFrame(Player p1){
		g =new GamePanel(p1);
		//º‡Ã˝
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W){
					g.p1.getHero().run=1;
				}
				if(e.getKeyCode() == KeyEvent.VK_S){
					g.p1.getHero().run=2;
				}
				if(e.getKeyCode() == KeyEvent.VK_A){
					g.p1.getHero().dir=0;
					g.p1.getHero().run=3;
				}
				if(e.getKeyCode() == KeyEvent.VK_D){
					g.p1.getHero().dir=1;
					g.p1.getHero().run=4;
				}
				if(e.getKeyCode() == KeyEvent.VK_J){
					if(g.p1.getHero().getCdrel() == 0){
						ArcherSounds.attack(0);
						g.p1.getHero().setCdrel(g.p1.getHero().getCd());
						ArcherSounds.arrowSounds(0);
						g.p1.getHero().atkindex=0;
						g.p1.getHero().atk=true;
						g.makeArrow(g.p1.getHero().x+72,g.p1.getHero().y+84,0);
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_K){
					if(g.p1.getHero().cdSrel[0] == 0 && g.p1.getHero().getMana_Point()-g.p1.getHero().mananum[0]>=0){
						ArcherSounds.attack(1);
						g.p1.getHero().setMana_Point(g.p1.getHero().getMana_Point()-g.p1.getHero().mananum[0]);
						g.p1.getHero().cdSrel[0] = g.p1.getHero().cdS[0];
						ArcherSounds.arrowSounds(1);
						g.p1.getHero().atkindex=0;
						g.p1.getHero().atk=true;
						g.makeArrow(g.p1.getHero().x+72,g.p1.getHero().y+84,1);
						g.makeArrow(g.p1.getHero().x+72,g.p1.getHero().y+44,1);
						g.makeArrow(g.p1.getHero().x+72,g.p1.getHero().y+124,1);
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_L){
					if(g.p1.getHero().cdSrel[1] == 0 && g.p1.getHero().getMana_Point()-g.p1.getHero().mananum[1]>=0){
						g.p1.getHero().setMana_Point(g.p1.getHero().getMana_Point()-g.p1.getHero().mananum[1]);
						g.p1.getHero().cdSrel[1] = g.p1.getHero().cdS[1];
						g.p1.getHero().x-=100;
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_1){
					if(g.p1.getHero().getHealth_Point()>=90){
						g.p1.getHero().setHealth_Point(100);
					}
					else g.p1.getHero().setHealth_Point(g.p1.getHero().getHealth_Point()+10);
				}
				if(e.getKeyCode() == KeyEvent.VK_2){
					if(g.p1.getHero().getMana_Point()>=90){
						g.p1.getHero().setMana_Point(100);
					}
					else g.p1.getHero().setMana_Point(g.p1.getHero().getMana_Point()+10);
				}
				if(e.getKeyCode() == KeyEvent.VK_3){
					g.p1.getHero().setSpeed(g.p1.getHero().getTspeed()+20);
					g.num3 = 30;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				g.p1.getHero().run = 0;
				g.p1.getHero().atkd=false;
			}
			
		});
		//ªÊÕº
		g.runpaint();
		addSetting();
	}
	////º”‘ÿ&…Ë≤Œ
	public void addSetting(){
		this.add(g);
		this.setUndecorated(true);//±ﬂøÚœ˚ ß;
		this.setVisible(true);
		this.setLocation(300,50);
		this.setTitle("Knight");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1280,740);
		this.setIconImage(new ImageIcon("image/logo/ulogo.png").getImage());
	}
}
