package com.njfu.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.njfu.entity.MyFrame;
import com.njfu.entity.Player;
import com.njfu.service.PlayerService;

public class AddPlayer extends MyFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddPlayer(final Player p1,final Player user){
		this.setLayout(null);
		jb1 = new JButton("确认");
		jb1.setBounds(500, 600, 60, 30);
		this.add(jb1);
		
		jb2 = new JButton("重置");
		jb2.setBounds(720, 600, 60, 30);
		this.add(jb2);
		jl1 = new JLabel("账户:");
		jl1.setForeground(Color.red);
		jl1.setBounds(360, 290, 50,50);
		this.add(jl1);
		
		jf1 = new JTextField(p1.getAccount());
		jf1.setBounds(400, 300, 180, 30);
		this.add(jf1);
		
		jf2 = new JTextField(p1.getPassword());
		jf2.setBounds(400, 370, 180, 30);
		this.add(jf2);
		
		jl2 = new JLabel("密码:");
		jl2.setForeground(Color.red);
		jl2.setBounds(360, 360, 50,50);
		this.add(jl2);
		
		jf3 = new JTextField(p1.getPhonenum());
		jf3.setBounds(400, 440, 180, 30);
		this.add(jf3);
		
		jl3 = new JLabel("手机:");
		jl3.setForeground(Color.red);
		jl3.setBounds(360, 430, 50,50);
		this.add(jl3);
		
		jf4 = new JTextField(String.valueOf(p1.getStation()));
		jf4.setBounds(400, 510, 180, 30);
		this.add(jf4);
		
		jl4 = new JLabel("状态:");
		jl4.setForeground(Color.red);
		jl4.setBounds(360, 500, 50,50);
		this.add(jl4);
		
		jf5 = new JTextField(String.valueOf(p1.getGoldnum()));
		jf5.setBounds(700, 300, 180, 30);
		this.add(jf5);
		
		jl5 = new JLabel("金币:");
		jl5.setForeground(Color.red);
		jl5.setBounds(660, 290, 50,50);
		this.add(jl5);
		
		jf6 = new JTextField(String.valueOf(p1.getDiamondnum()));
		jf6.setBounds(700, 370, 180, 30);
		this.add(jf6);
		
		jl6 = new JLabel("钻石:");
		jl6.setForeground(Color.red);
		jl6.setBounds(660, 360, 50,50);
		this.add(jl6);
		
		jf7 = new JTextField(String.valueOf(p1.getLv()));
		jf7.setBounds(700, 440, 180, 30);
		this.add(jf7);
		
		jl7 = new JLabel("等级:");
		jl7.setForeground(Color.red);
		jl7.setBounds(660, 430, 50,50);
		this.add(jl7);
		
		jf8 = new JTextField(String.valueOf(p1.getEpx()));
		jf8.setBounds(700, 510, 180, 30);
		this.add(jf8);
		
		jl8 = new JLabel("经验:");
		jl8.setForeground(Color.red);
		jl8.setBounds(660, 500, 50,50);
		this.add(jl8);
		
		jb1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				String name = jf1.getText();
				String password = jf2.getText();
				String phonenum = jf3.getText();
				String sta = jf4.getText();
				String gold = jf5.getText();
				String dia = jf6.getText();
				String lv = jf7.getText();
				String epx = jf8.getText();
				int stanum = Integer.parseInt(sta);
				int goldnum= Integer.parseInt(gold);
				int dianum= Integer.parseInt(dia);
				int lvnum= Integer.parseInt(lv);
				int epxnum= Integer.parseInt(epx);
				Player p = new Player();
				p.setId(p1.getId());
				p.setAccount(name);
				p.setPassword(password);
				p.setPhonenum(phonenum);
				p.setStation(stanum);
				p.setGoldnum(goldnum);
				p.setDiamondnum(dianum);
				p.setLv(lvnum);
				p.setEpx(epxnum);
				PlayerService.addPlayer(p);
				dispose();
				new  BackControl(user);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		BackImage back = new BackImage(new File("image/background/menuback.jpg"));
		back.setBounds(0, 0,1280,643);
		this.add(back);
		this.setUndecorated(true);//边框消失;
		this.setVisible(true);
		this.setLocation(350,150);
		this.setTitle("Knight");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1280,643);
		this.setIconImage(new ImageIcon("image/logo/ulogo.png").getImage());
	}
}
