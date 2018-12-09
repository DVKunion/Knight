package com.njfu.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.njfu.entity.MyFrame;
import com.njfu.entity.Player;

public class ReadyFrame extends MyFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		Player test = new Player();
		test.setSel(1);
		test.setHero();
		new ReadyFrame(test);
	}
	public ReadyFrame(Player x){
		
		
		this.setLayout(null);
		this.setUndecorated(true);
		this.setVisible(true);
		
		this.setLocation(0,0);
		this.setSize(1024, 768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("image/logo/ulogo.png").getImage());
	}
}
