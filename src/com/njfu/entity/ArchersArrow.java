package com.njfu.entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ArchersArrow extends Weapon{
	public ArchersArrow(int x1,int y1,int s,int dir){
		this.x = x1;
		this.y = y1;
		this.sel = s;
		this.speed = 20;
		this.exist = true;
		this.dir = dir;
		initArcherarrow();
		if(this.dir == 1)
			arrow = new BufferedImage[] {arr1,arr2,arr3,arr4};
		else 
			arrow = new BufferedImage[] {arr5,arr6,arr7,arr8};
		this.wid = 70;
		this.hig = 15;
	}
	public void initArcherarrow(){
		try {
			arr1 = ImageIO.read(new File("image/hero/archer/attackr/hit.png"));
			arr2 = ImageIO.read(new File("image/hero/archer/attackr/hit3.png"));
			arr3 = ImageIO.read(new File("image/hero/archer/attackr/hit4.png"));
			arr4 = ImageIO.read(new File("image/hero/archer/attackr/hit2.png"));
			arr5 = ImageIO.read(new File("image/hero/archer/attackl/hit.png"));
			arr6 = ImageIO.read(new File("image/hero/archer/attackl/hit3.png"));
			arr7 = ImageIO.read(new File("image/hero/archer/attackl/hit4.png"));
			arr8 = ImageIO.read(new File("image/hero/archer/attackl/hit2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
