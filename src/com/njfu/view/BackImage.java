package com.njfu.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackImage extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image background;
	public BackImage(File f){
		try{
			background = ImageIO.read(f);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(background,0,0,null);
	}
}
