package com.njfu.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.njfu.entity.MusicPlayer;
import com.njfu.entity.MyFrame;
import com.njfu.entity.Player;
import com.njfu.service.PlayerService;

public class GameStart extends MyFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MenuFrame menu = new MenuFrame();
	Regist regist = new Regist();
	Player p;	
	GameFrame game;
	boolean gamestart =false;
	public static void main(String[] args) {
		new GameStart(true);
	}
	public GameStart(boolean x){
		//x是是否播放BGM的标志位
		runpaint();
		init(x);
		addSetting();
		//添加监听
		jb1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				jl1.setVisible(true);
				playc = new MusicPlayer("sounds/others/enter.wav");
				playc.start(false);
				dispose();
				menu.exists = true;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jl1.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jl2.setVisible(true);
				playi = new MusicPlayer("sounds/others/on2.wav");
				playi.start(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jl2.setVisible(false);
			}
		});

	}
	//图片加载类
	public void init(boolean x){
		jl1 = new JLabel(new ImageIcon("image/button/start1.png"));
		jl1.setBounds(400,515,270,44);
		jl1.setVisible(false);
				
		jl2 = new JLabel(new ImageIcon("image/button/start2.png"));
		jl2.setBounds(400,514,265,44);
		jl2.setVisible(false);
				
		jb1 = new JButton();
		jb1.setContentAreaFilled(false);
		jb1.setBorder(null);
		jb1.setBounds(400,515,270,44);
		
		background= new BackImage(new File("image/background/Start.png"));
		background.setBounds(0, 0, 1024,768);
		
		this.exists = x;
		if(exists == true){
			playbgm = new MusicPlayer("sounds/bgm/main.wav");
			playbgm.start(true);
		}
	}
	//加载&设参
	public void addSetting(){
		this.setLayout(null);
		this.add(jb1);
		this.add(jl1);
		this.add(jl2);
		this.add(background);
		
		this.setUndecorated(true);//边框消失;
		this.setVisible(true);
		this.setLocation(450,130);
		this.setTitle("Knight");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 768);
		this.setIconImage(new ImageIcon("image/logo/ulogo.png").getImage());
	}
	//关闭窗口
	public void frameStop(){
		playbgm.stop();
		dispose();
	}
	//线程
	public void runpaint(){
		//控制线程
		new Thread(){
			public void run(){
				super.run();
				while(true){
					if(menu.temp!=null){
						 p = menu.temp;
					}
					if(menu.exists)
					{
						menu.makeMenuFrame();
						menu.exists = false;
					}
					else if(menu.request1){
						if(p.getStation() == 1){
							frameStop();
							game = new GameFrame(p);
							gamestart = true;
							dispose();
							menu.request1 = false;
							playbgm = new MusicPlayer("sounds/bgm_01_raid.wav");
							playbgm.start(true);
						}
						else if(p.getStation() == 0){
							menu.request1 = false;
							JOptionPane.showMessageDialog(null, "账号异常！");					
						}
						else if(p.getStation() == 2){
							frameStop();
							new  BackControl(p);
							dispose();
							menu.request1 = false;
						}
					}
					else if(menu.request2){
						regist = new Regist();
						regist.makeRegist();
						menu.request2 = false;
					}
					else if(regist.request1){
						menu = new MenuFrame();
						menu.makeMenuFrame();
						regist.request1= false;
					}
					else if(gamestart){
						if(game.g.gameover){
							gamestart=false;
							frameStop();
							if(p.getHero().getHealth_Point() <= 0 )
								playbgm = new MusicPlayer("sounds/enchant_fail.wav");
							else 
								playbgm = new MusicPlayer("sounds/arena_win.wav");
							playbgm.start(false);
							new GameOverFrame(game.g.map.total-game.g.map.monster.size(),game.g.cionnum,p);
							PlayerService.updataPlayer(p);
							game.dispose();
						}
					}
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
