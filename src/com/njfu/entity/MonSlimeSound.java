package com.njfu.entity;

public class MonSlimeSound {
	static MusicPlayer player;
	public static void attackd(int k){
		switch(k){
		case 0: player = new MusicPlayer("sounds/monster/slime/1102_damage.wav");break;
		case 1: player = new MusicPlayer("sounds/monster/slime/1102_die.wav");break;
		}
		player.start(false); 
	}
}
