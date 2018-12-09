package com.njfu.entity;

public class HaiBaoSounds {
	static MusicPlayer player;
	public static void attackd(int k){
		switch(k){
		case 0: player= new MusicPlayer("sounds/monster/haibao/1605_damage.wav");
		case 1: player=new MusicPlayer("sounds/monster/haibao/1605_die.wav");
		}
		player.start(false);
	}
}
