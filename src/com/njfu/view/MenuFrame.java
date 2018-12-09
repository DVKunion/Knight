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
import com.njfu.entity.Player;
import com.njfu.exception.PasswordIsNotRightException;
import com.njfu.exception.PhonenumIsNotRightException;
import com.njfu.exception.UserIsNotExistException;
import com.njfu.exception.UserNameIsNotRightException;
import com.njfu.service.PlayerService;

public class MenuFrame extends MyFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Player temp = null;
	public void makeMenuFrame(){
		this.setLayout(null);
		init();
		addSetting();
		//监听
		jb1.addMouseListener(new MouseListener(){

			@Override
			public void mousePressed(MouseEvent e) {
				jl2.setVisible(true);
				jl1.setVisible(false);
				playc = new MusicPlayer("sounds/others/enter.wav");
				playc.start(false);
				login();
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
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});		
		jb2.addMouseListener(new MouseListener(){

			@Override
			public void mousePressed(MouseEvent e) {
				jl3.setVisible(false);
				jl4.setVisible(true);
				playc = new MusicPlayer("sounds/others/enter.wav");
				playc.start(false);
				regist();
				jl4.setVisible(false);
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
				jl8.setVisible(false);
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
	//图片类加载
	public void init(){
		jf1 = new JTextField();
		jf1.setBounds(443,375,186,20);
		jf1.setForeground(Color.white);
		jf1.setFont(new Font("Cambria",Font.CENTER_BASELINE,15));
		jf1.setBackground(Color.black);
		jf1.setBorder(null);
		
		jp1 = new JPasswordField();
		jp1.setBounds(443,426,186,25);
		jp1.setForeground(Color.white);
		jp1.setBackground(Color.black);
		jp1.setBorder(null);
		jp1.setFont(new Font("Cambria",Font.PLAIN,17));
		
		jb1 = new JButton();
		jb1.setContentAreaFilled(false);
		jb1.setBorder(null);
		jb1.setBounds(446,503,75,21);
		
		jb2 = new JButton();
		jb2.setBounds(545,503,75,21);
		jb2.setContentAreaFilled(false);
		jb2.setBorder(null);
		
		jb4 = new JButton();
		jb4.setBounds(900, 658,85,21);
		jb4.setContentAreaFilled(false);
		jb4.setBorder(null);
		
		jl1 = new JLabel(new ImageIcon("image/button/Login1.png"));
		jl1.setBounds(433,498,102,34);
		jl1.setVisible(false);
		
		jl2 = new JLabel(new ImageIcon("image/button/Login2.png"));
		jl2.setBounds(433,498,102,34);
		jl2.setVisible(false);
		
		jl3 = new JLabel(new ImageIcon("image/button/regist1.png"));
		jl3.setBounds(532,498,102,34);
		jl3.setVisible(false);
		
		jl4 = new JLabel(new ImageIcon("image/button/regist2.png"));
		jl4.setBounds(532,498,102,34);
		jl4.setVisible(false);
		
		jl7 = new JLabel(new ImageIcon("image/button/quit1.png"));
		jl7.setBounds(892,653,102,34);
		jl7.setVisible(false);
		
		jl8 = new JLabel(new ImageIcon("image/button/quit2.png"));
		jl8.setBounds(892,653,102,34);
		jl8.setVisible(false);
		
		background = new BackImage(new File("image/background/login.png"));
		background.setBounds(0, 0, 1024,768);
	}
	//加载&设参
	public void addSetting(){
		this.add(jb1);	
		this.add(jb2);
		this.add(jb4);
		this.add(jl1);	
		this.add(jl2);
		this.add(jl3);
		this.add(jl4);	
		this.add(jl7);
		this.add(jl8);
		this.add(jf1);
		this.add(jp1);
		this.add(background);
		this.setUndecorated(true);//边框消失;
		this.setVisible(true);
		this.setLocation(450,130);
		this.setTitle("Knight");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 768);
		this.setIconImage(new ImageIcon("image/logo/ulogo.png").getImage());
	}
	//登录传参
	public void login(){
		String account = jf1.getText().toString();
		String Password= String.valueOf(jp1.getPassword());
		try {
			Player p = new Player ();
			p = PlayerService.loginPlayer(account,Password);
			if(p != null){
				this.request1 = true ;
				this.dispose();
				temp=p;
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
		catch(UserIsNotExistException e1){
			JOptionPane.showMessageDialog(null,e1.getMessage());
		}
		catch (Exception f) {
			JOptionPane.showMessageDialog(null,f.getMessage());
		}
	}
	//注册跳转
	public void regist(){
		this.request2 = true;
		this.dispose();
	}

}
