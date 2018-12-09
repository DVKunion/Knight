package com.njfu.entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Map{
	public int total=21;
	public BufferedImage map;
	public MonSlime monslime;
	public Haibao haibao;
	public Obstacle Obs;
	public ArrayList <Monster> monster = new ArrayList<Monster> ();
	public ArrayList <Obstacle> obstacle = new ArrayList<Obstacle> ();
	public BufferedImage map1,map2,map3,map4,map5,map6,map7,map8,map9,map10;
	public BufferedImage[] maps = {};
	public int mapx = 0;
	public Map(int x){
		mapinit();
		Obstacleinit1();
		maps = new BufferedImage[]{map1,map2,map3,map4,map5,map6,map7,map8,map9,map10};
		map = maps[x];
		switch(x){
		case 1:monsterinit1();Obstacleinit1();break;
		case 2:
		case 3:
		case 4:
		}
	}
	public void mapinit(){
		try {
			map1 = ImageIO.read(new File("Image/background/maps/1.png"));
			map2 = ImageIO.read(new File("Image/background/maps/1.png"));
			map3 = ImageIO.read(new File("Image/background/maps/1.png"));
			map4 = ImageIO.read(new File("Image/background/maps/1.png"));
			map5 = ImageIO.read(new File("Image/background/maps/1.png"));
			map6 = ImageIO.read(new File("Image/background/maps/1.png"));
			map7 = ImageIO.read(new File("Image/background/maps/1.png"));
			map8 = ImageIO.read(new File("Image/background/maps/1.png"));
			map9 = ImageIO.read(new File("Image/background/maps/1.png"));
			map10 = ImageIO.read(new File("Image/background/maps/1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void monsterinit1(){
		monslime = new MonSlime(850,280);
		monster.add(monslime);
		monslime = new MonSlime(950,330);
		monster.add(monslime);
		monslime = new MonSlime(850,380);
		monster.add(monslime);
		monslime = new MonSlime(950,430);
		monster.add(monslime);
		monslime = new MonSlime(850,480);
		monster.add(monslime);
		monslime = new MonSlime(950,530);
		monster.add(monslime);
		monslime = new MonSlime(850,500);
		monster.add(monslime);
		monslime = new MonSlime(1500,280);
		monster.add(monslime);
		monslime = new MonSlime(1400,330);
		monster.add(monslime);
		monslime = new MonSlime(1300,380);
		monster.add(monslime);
		monslime = new MonSlime(1400,430);
		monster.add(monslime);
		monslime = new MonSlime(1500,480);
		monster.add(monslime);
		monslime = new MonSlime(1750,280);
		monster.add(monslime);
		monslime = new MonSlime(1800,380);
		monster.add(monslime);
		monslime = new MonSlime(1750,450);
		monster.add(monslime);
		monslime = new MonSlime(1800,500);
		monster.add(monslime);
		monslime = new MonSlime(2700,280);
		monster.add(monslime);
		monslime = new MonSlime(2700,380);
		monster.add(monslime);
		monslime = new MonSlime(2700,450);
		monster.add(monslime);
		monslime = new MonSlime(2700,500);
		monster.add(monslime);
		haibao  = new  Haibao (2600,380);
		monster.add(haibao);
	}
	public void Obstacleinit1(){
		Obs = new Obstacle(500,500,0);
		obstacle.add(Obs);
		Obs = new Obstacle(1700,200,1);
		obstacle.add(Obs);
		Obs = new Obstacle(1480,200,1);
		obstacle.add(Obs);
		Obs = new Obstacle(1400,340,0);
		obstacle.add(Obs);
		Obs = new Obstacle(2000,340,0);
		obstacle.add(Obs);
	}
}
