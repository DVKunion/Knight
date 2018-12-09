package com.njfu.entity;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.njfu.view.BackImage;

/**
 * @author Black Cat
 *定义这个程序所有的窗口文件属性
 */
public class MyFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8; 	//按钮
	public JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8; 		//图片
	public MusicPlayer playc,playi,playbgm;				//音乐播放器
	public JTextField jf1,jf2,jf3,jf4,jf5,jf6,jf7,jf8;					//文本域
	public JPasswordField jp1,jp2;						//密码域
	public BackImage background; 						//背景图片
	public Boolean exists = false ;						//存在位1
	public Boolean request1 = false,request2 = false,request3 = false;			//请求位1,2,3
	
}
