package com.njfu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.njfu.entity.MyFrame;
import com.njfu.entity.Player;
import com.njfu.service.PlayerService;

public class GameOverFrame extends MyFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int locX = 500;
	int locY = 300;
	int width = 455;
	int height = 365;
	
	JTextArea jta1 = new JTextArea(); //攻击的敌人数
	JTextArea jta2 = new JTextArea(); //得金币数
	
	JButton jb1 = new JButton(); //返回主界面
	JButton jb2 = new JButton(); //重开一局
	
	public GameOverFrame(int attack_enemy_number, int get_coin_number,final Player p1) {
		BackImage back = new BackImage(new File("image/game_over.png"));
		back.setBounds(0, 0, width, height);
		
		jta1.setBounds(230, 105, 100, 40);
		jta1.setText(""+attack_enemy_number);
		jta1.setFont(new Font("", 0, 34));
		jta1.setForeground(Color.PINK);
		jta1.setOpaque(false);
		jta1.setEnabled(false);
		
		jta2.setBounds(230, 192, 100, 40);
		jta2.setText(""+get_coin_number);
		jta2.setFont(new Font("", 0, 34));
		jta2.setForeground(Color.PINK);
		jta2.setOpaque(false);
		jta2.setEnabled(false);
		
		jb1.setBounds(108, 275, 74, 74);
		jb1.setContentAreaFilled(false);
		jb1.setBorder(null);
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Player> p = new ArrayList<>();
				try {
					p = PlayerService.showranklist();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				for(int i=0;i<4;i++){
					if(p1.getGoldnum() > p.get(i).getGoldnum()){
						if(!p1.getAccount().equals(p.get(i).getAccount())){
							p.add(i,p1);
						}
						else p.get(i).setGoldnum(p1.getGoldnum());
						break;
					}
				}
				for(int i=0;i<4;i++){
					p.get(i).setId(i+1);
				}
				for(int i=0;i<4;i++){
					PlayerService.updataRanklist(p.get(i),p.get(i).getId());
				}
				try {
					p = PlayerService.showranklist();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				new RankFrame(p);
				dispose();
			}
		});
		
		jb2.setBounds(278, 275, 74, 74);
		jb2.setContentAreaFilled(false);
		jb2.setBorder(null);
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("2");
			}
		});
		
		this.add(jta1);
		this.add(jta2);
		this.add(back);
		this.add(jb1);
		this.add(jb2);
		
		this.setUndecorated(true);//边框消失;
		this.setVisible(true);
		this.setLocation(locX,locY);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("image/logo/ulogo.png").getImage());
		
	}
	
	/*public static void main(String[] args) {
		new GameOverFrame(12, 20);
	}*/
}
