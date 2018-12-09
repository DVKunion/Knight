package com.njfu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.njfu.entity.Player;

public class RankFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int locX = 400;
	int locY = 200;
	int width = 400;
	int height = 471;
	
	JTextArea jta1 = new JTextArea(); //第一名
	JTextArea jta2 = new JTextArea(); //第二名
	JTextArea jta3 = new JTextArea(); //第三名
	JTextArea jta4 = new JTextArea(); //第四名
	JTextArea jtac1 = new JTextArea(); //第一名金币数
	JTextArea jtac2 = new JTextArea(); 
	JTextArea jtac3 = new JTextArea();
	JTextArea jtac4 = new JTextArea();

	JButton jbc = new JButton();
	JButton jbok = new JButton();
	
	public RankFrame(ArrayList<Player> p) {
		this.setLayout(null);
		
		BackImage back = new BackImage(new File("image/rank_back.png"));
		back.setBounds(0, 0, width, height);
		
		jta1.setBounds(40, 80, 150, 40);
		//jta1.setFont(new Font("", 0, 26));
		jta1.setText(p.get(0).getAccount());
		jta1.setForeground(Color.yellow);
		jta1.setOpaque(false);
		/*
		//jtac1.setBounds(210, 80, 95, 50);
		//tac1.setFont(new Font("", 0, 30));
		//jtac1.setText(p.get(0).getGoldnum()+"");
		//jac1.setForeground(Color.yellow);
		//jtac1.setOpaque(false);
		
		//jta2.setBounds(40, 170, 150, 40);
		//jta2.setFont(new Font("", 0, 26));
		//jta2.setText(p.get(1).getAccount());
		//jta2.setForeground(Color.LIGHT_GRAY);
		//jta2.setOpaque(false);
		
		//jtac2.setBounds(210, 170, 95, 50);
		//jtac2.setFont(new Font("", 0, 30));
		//jtac2.setText(p.get(1).getGoldnum()+"");
		//jtac2.setForeground(Color.LIGHT_GRAY);
		//jtac2.setOpaque(false);
		
		//jta3.setBounds(40, 260, 150, 40);
		//jta3.setFont(new Font("", 0, 26));
		//jta3.setText(p.get(2).getAccount());
		//jta3.setForeground(Color.orange);
		//jta3.setOpaque(false);
		
		//jtac3.setBounds(210, 260, 95, 50);
		//jtac3.setFont(new Font("", 0, 30));
		//jtac3.setText(p.get(2).getGoldnum()+"");
		//jtac3.setForeground(Color.orange);
		//jtac3.setOpaque(false);
		
		jta4.setBounds(40, 350, 150, 40);
		//jta4.setFont(new Font("", 0, 26));
		jta4.setText(p.get(3).getAccount());
		jta4.setForeground(Color.cyan);
		jta4.setOpaque(false);
		
		//jtac4.setBounds(210, 350, 95, 50);
		//jtac4.setFont(new Font("", 0, 30));
		//jtac4.setText(p.get(3).getGoldnum()+"");
		//jtac4.setForeground(Color.cyan);
		//jtac4.setOpaque(false);
		
		jbc.setBounds(363, 16, 20, 20);
		jbc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jbc.setContentAreaFilled(false);
		jbc.setBorder(null);
		
		jbok.setBounds(138, 424, 126, 45);
		jbok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jbok.setContentAreaFilled(false);
		jbok.setBorder(null);
		
		this.add(jta1);
		this.add(jta2);
		this.add(jta3);
		this.add(jta4);
		this.add(jtac1);
		this.add(jtac2);
		this.add(jtac3);
		this.add(jtac4);
		this.add(back);
		this.add(jbok);
		this.add(jbc);
		*/
		this.setUndecorated(true);//边框消失;
		this.setVisible(true);
		this.setLocation(locX,locY);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
