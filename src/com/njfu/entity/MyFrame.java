package com.njfu.entity;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.njfu.view.BackImage;

/**
 * @author Black Cat
 *��������������еĴ����ļ�����
 */
public class MyFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8; 	//��ť
	public JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8; 		//ͼƬ
	public MusicPlayer playc,playi,playbgm;				//���ֲ�����
	public JTextField jf1,jf2,jf3,jf4,jf5,jf6,jf7,jf8;					//�ı���
	public JPasswordField jp1,jp2;						//������
	public BackImage background; 						//����ͼƬ
	public Boolean exists = false ;						//����λ1
	public Boolean request1 = false,request2 = false,request3 = false;			//����λ1,2,3
	
}
