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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.njfu.entity.MusicPlayer;
import com.njfu.entity.MyFrame;
import com.njfu.exception.PasswordIsNotRightException;
import com.njfu.exception.PhonenumIsNotRightException;
import com.njfu.exception.UserNameIsNotRightException;
import com.njfu.service.PlayerService;
public class Regist extends MyFrame{
	private static final long serialVersionUID = 1L;
	String code;
	public void makeRegist(){
		init();
		addSetting();
		
		jb1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
				
			@Override
			public void mousePressed(MouseEvent e) {
				jl2.setVisible(true);
				jl1.setVisible(false);
				playc = new MusicPlayer("sounds/others/enter.wav");
				playc.start(false);
				regist();
				jl2.setVisible(false);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jl2.setVisible(false);
				jl1.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jl1.setVisible(true);
				playi = new MusicPlayer("sounds/others/on2.wav");
				playi.start(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jl1.setVisible(false);
			}	
		});
		jb2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				jf1.setText("");
				jp1.setText("");
				jf2.setText("");
				jp2.setText("");
				jf3.setText("");
				playc = new MusicPlayer("sounds/others/enter.wav");
				playc.start(false);
				jl3.setVisible(false);
				jl4.setVisible(true);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jl3.setVisible(true);
				jl4.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jl3.setVisible(true);
				playi = new MusicPlayer("sounds/others/on2.wav");
				playi.start(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jl3.setVisible(false);
			}
			
		});
		jb3.addMouseListener(new MouseListener(){

			@Override
			public void mousePressed(MouseEvent e) {
				jl5.setVisible(false);
				jl6.setVisible(true);
				playc = new MusicPlayer("sounds/others/enter.wav");
				playc.start(false);
				back();
				dispose();
				jl6.setVisible(false);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jl5.setVisible(true);
				jl6.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				jl5.setVisible(true);
				playi = new MusicPlayer("sounds/others/on2.wav");
				playi.start(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jl5.setVisible(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		jb4.addMouseListener(new MouseListener(){

			@Override
			public void mousePressed(MouseEvent e) {
				jl7.setVisible(false);
				jl8.setVisible(true);
				playc = new MusicPlayer("sounds/others/enter.wav");
				playc.start(false);
				JOptionPane.showMessageDialog(null,"确认退出？");
				System.exit(0);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jl7.setVisible(true);
				jl8.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				jl7.setVisible(true);
				playi = new MusicPlayer("sounds/others/on2.wav");
				playi.start(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jl7.setVisible(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});

	}
	public void regist(){
		try{
			String account = jf1.getText();
			String Password1= String.valueOf(jp1.getPassword());
			String Password2= String.valueOf(jp2.getPassword());
			String Phonenum = jf2.getText();
			if(PlayerService.registPlayer(account,Password1,Password2,Phonenum)){
				request1 = true;
				dispose();
			}
			else{
				JOptionPane.showMessageDialog(null,"重名了大兄弟");
			}
		}
		catch(UserNameIsNotRightException a){
			JOptionPane.showMessageDialog(null,a.getMessage());
		}
		catch(PasswordIsNotRightException b){
			JOptionPane.showMessageDialog(null,b.getMessage());
		}
		catch(PhonenumIsNotRightException d){
			JOptionPane.showMessageDialog(null,d.getMessage());
		}
		catch(Exception f){
			JOptionPane.showMessageDialog(null,f.getMessage());
		}

	}

	public void init(){
		//账户文本窗口
		jf1 = new JTextField();
		jf1.setBounds(443,350,186,20);
		jf1.setForeground(Color.white);
		jf1.setFont(new Font("Cambria",Font.CENTER_BASELINE,15));
		jf1.setBackground(Color.black);
		jf1.setBorder(null);
		//密码文本窗口
		jp1 = new JPasswordField();
		jp2 = new JPasswordField();
		jp1.setBounds(443,405,186,20);
		jp1.setForeground(Color.white);
		jp1.setFont(new Font("Cambria",Font.CENTER_BASELINE,15));
		jp1.setBackground(Color.black);
		jp1.setBorder(null);
		jp2.setBounds(443,461,186,20);
		jp2.setForeground(Color.white);
		jp2.setFont(new Font("Cambria",Font.CENTER_BASELINE,15));
		jp2.setBackground(Color.black);
		jp2.setBorder(null);
		//手机号文本窗口
		jf2 = new JTextField();
		jf2.setBounds(443,515,186,20);
		jf2.setForeground(Color.white);
		jf2.setFont(new Font("Cambria",Font.CENTER_BASELINE,15));
		jf2.setBackground(Color.black);
		jf2.setBorder(null);
		//验证码文本窗口
		jf3 = new JTextField();
		jf3.setBounds(443,574,186,20);
		jf3.setForeground(Color.white);
		jf3.setFont(new Font("Cambria",Font.CENTER_BASELINE,15));
		jf3.setBackground(Color.black);
		jf3.setBorder(null);
		//button				
		jb1 = new JButton();
		jb2 = new JButton();
		jb3 = new JButton();
		jb4 = new JButton();

		jb1.setBounds(437,640,75,21);
		jb2.setBounds(548,640,75,21);
		jb3.setBounds(795,658,85,21);
		jb4.setBounds(900,658,85,21);
		jb1.setContentAreaFilled(false);
		jb1.setBorder(null);
		jb2.setContentAreaFilled(false);
		jb2.setBorder(null);
		jb3.setContentAreaFilled(false);
		jb3.setBorder(null);
		jb4.setContentAreaFilled(false);
		jb4.setBorder(null);
		//按钮图片
		jl1 = new JLabel(new ImageIcon("image/button/regist1.png"));
		jl1.setBounds(424,634,102,34);
		jl1.setVisible(false);

		jl2 = new JLabel(new ImageIcon("image/button/regist2.png"));
		jl2.setBounds(424,634,102,34);
		jl2.setVisible(false);

		jl3 = new JLabel(new ImageIcon("image/button/reset1.png"));
		jl3.setBounds(535,634,102,34);
		jl3.setVisible(false);

		jl4 = new JLabel(new ImageIcon("image/button/reset2.png"));
		jl4.setBounds(535,634,102,34);
		jl4.setVisible(false);

		jl5 = new JLabel(new ImageIcon("image/button/back1.png"));
		jl5.setBounds(788, 653,102,34);
		jl5.setVisible(false);

		jl6 = new JLabel(new ImageIcon("image/button/back2.png"));
		jl6.setBounds(788, 653,102,34);
		jl6.setVisible(false);

		jl7 = new JLabel(new ImageIcon("image/button/quit1.png"));
		jl7.setBounds(892,653,102,34);
		jl7.setVisible(false);

		jl8 = new JLabel(new ImageIcon("image/button/quit2.png"));
		jl8.setBounds(892,653,102,34);
		jl8.setVisible(false);
		
		background = new BackImage(new File("image/background/regist.png"));
		background.setBounds(0, 0, 1024,768);
	}
	public void addSetting(){
		this.setTitle("Knight---Regist");//窗口标题
		this.setLayout(null);//将frame设置为空格式
		this.add(jf1);
		this.add(jf2);
		this.add(jf3);
		this.add(jp1);
		this.add(jp2);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jl1);	
		this.add(jl2);
		this.add(jl3);
		this.add(jl4);	
		this.add(jl5);
		this.add(jl6);
		this.add(jl7);
		this.add(jl8);
		this.add(background);
		this.setUndecorated(true);//边框消失;
		this.setVisible(true);
		this.setLocation(450,130);
		this.setTitle("Knight");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 768);
		this.setIconImage(new ImageIcon("image/logo/ulogo.png").getImage());
	}
	public void back(){
		request1 = true;
	}
}
