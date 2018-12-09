package com.njfu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * 英雄选择界面，还差四个职业的图标以及所有职业的男女英雄、技能、属性值
 * 2018.8.27 晚
 * @author apple
 *
 */
public class ChooseHeroFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int locX = 120;
	int locY = 0;
	int width = 1024;
	int height = 768;
	
	JButton jbp1 = new JButton(); //职业图标按钮1-6
	JButton jbp2 = new JButton();
	JButton jbp3 = new JButton();
	JButton jbp4 = new JButton();
	JButton jbp5 = new JButton();
	JButton jbp6 = new JButton();
	JButton jbg1 = new JButton(); //性别男女
	JButton jbg2 = new JButton();
	JButton jbs1 = new JButton(); //技能图标1-4
	JButton jbs2 = new JButton();
	JButton jbs3 = new JButton();
	JButton jbs4 = new JButton();
	JButton jb1 = new JButton(); //随机生成昵称按钮
	JButton jb2 = new JButton(); //确认选择英雄按钮
	
	boolean flag = true; //实现多职业按钮的操作
	
	//职业图标
	JLabel jlp3 = new JLabel(new ImageIcon("image/btn_profession3_hover.png"));
	JLabel jlp5 = new JLabel(new ImageIcon("image/btn_profession5_hover.png"));
	
	//random按钮图标
	JLabel jlbranh = new JLabel(new ImageIcon("image/btn_random_hover.png"));
	JLabel jlbrana = new JLabel (new ImageIcon("image/btn_random_active.png"));
	
	public ChooseHeroFrame() {
		this.setLayout(null);
		jlp3.setBounds(0, 0, width, height);
		jlp3.setVisible(false);
		jlp5.setBounds(0, 0, width, height);
		jlp5.setVisible(false);
		jlbranh.setBounds(0, 0, width, height);
		jlbranh.setVisible(false);
		jlbrana.setBounds(0, 0, width, height);
		jlbrana.setVisible(false);
		
		BackImage back = new BackImage(new File("image/ChooseHeroFrame_bg.png"));
		back.setBounds(0, 0, width, height);	
		
		jbp1.setBounds(80, 145, 54, 54);
		jbp1.setContentAreaFilled(false);
		jbp1.setBorder(null);
		
		jbp2.setBounds(152, 145, 54, 54);
		jbp2.setContentAreaFilled(false);
		jbp2.setBorder(null);
		
		jbp3.setBounds(224, 145, 54, 54);
		jbp3.setContentAreaFilled(false);
		jbp3.setBorder(null);
		jbp3.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(flag)
					jlp3.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(flag)
					jlp3.setVisible(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				jlp5.setVisible(false);
				jlp3.setVisible(true);
				flag = false;
			}
		});
		
		jbp4.setBounds(80, 203, 54, 54);
		jbp4.setContentAreaFilled(false);
		jbp4.setBorder(null);
		
		jbp5.setBounds(152, 203, 54, 54);
		jbp5.setContentAreaFilled(false);
		jbp5.setBorder(null);
		jbp5.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(flag)
					jlp5.setVisible(false);				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(flag)
					jlp5.setVisible(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				jlp3.setVisible(false);
				jlp5.setVisible(true);
				flag = false;
			}
		});
		
		jbp6.setBounds(224, 203, 54, 54);
		jbp6.setContentAreaFilled(false);
		jbp6.setBorder(null);
		
		jbg1.setBounds(82, 305, 70, 70);
		jbg1.setContentAreaFilled(false);
		jbg1.setBorder(null);
		
		jbg2.setBounds(196, 305, 70, 70);
		jbg2.setContentAreaFilled(false);
		jbg2.setBorder(null);
		
		
		final JTextArea jta = new JTextArea();
		jta.setBounds(80, 548, 200, 26);
		jta.setForeground(Color.WHITE);
		jta.setFont(new Font("", 0, 18));
		jta.setOpaque(false);
		
		jb1.setBounds(135, 586, 88, 35);
		jb1.setContentAreaFilled(false);
		jb1.setBorder(null);
		jb1.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jlbranh.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				jlbranh.setVisible(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				jlbranh.setVisible(false);
				jlbrana.setVisible(true);
				jta.setText(makeName());
			}
		});
		
		
		this.add(jlp3);
		this.add(jlp5);
		this.add(jlbranh);
		this.add(jlbrana);
		this.add(jta);
		this.add(back);
		this.add(jb1);
		this.add(jbp1);
		this.add(jbp2);
		this.add(jbp3);
		this.add(jbp4);
		this.add(jbp5);
		this.add(jbp6);
		this.add(jbg1);
		this.add(jbg2);
		
		this.setUndecorated(true);//边框消失;
		this.setVisible(true);
		this.setLocation(locX,locY);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//生成随机昵称
	public String makeName() {
		String s1 = "QWRTYPSDFGHJKLZCVBNM";
		String s2 = "aeiou";
		String s3 = "qwrtypsdfghjklzxcvbnm";
		String name = "";
		name += s1.charAt((int)(Math.random()*20));
		name += s2.charAt((int)(Math.random()*5));
		name += s3.charAt((int)(Math.random()*20));
		name += s2.charAt((int)(Math.random()*5));
		name += s3.charAt((int)(Math.random()*20));
		return name;
	}
	
	public static void main(String[] args) {
		new ChooseHeroFrame();
	}
}
