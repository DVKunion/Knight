package com.njfu.view;

import java.io.File;

import javax.swing.JFrame;

/**
 * 任务界面，展开图鉴
 * 2018.8.28日
 * @author apple
 *
 */
public class AbilityFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int locX = 120;
	int locY = 0;
	int width = 1024;
	int height = 768;
	
	public AbilityFrame() {
		this.setLayout(null);
		
		BackImage back = new BackImage(new File("image/bg_ability_frame.png"));
		back.setBounds(0, 0, width, height);
		
		
		this.add(back);
		
		this.setUndecorated(true);//边框消失;
		this.setVisible(true);
		this.setLocation(locX,locY);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new AbilityFrame();
	}
}
