package com.njfu.entity;

import com.njfu.entity.MusicPlayer;

public class ArcherSounds {
	static MusicPlayer player;
	public static void arrowSounds(int k){
		switch(k){
		case 0: player = new MusicPlayer("sounds/player/archer/attack/arrow01.wav");break;
		case 1: player = new MusicPlayer("sounds/player/archer/attack/arrow04.wav");break;
		case 2: player = new MusicPlayer("sounds/player/archer/attack/arrow03.wav");break;
		case 3: player = new MusicPlayer("sounds/player/archer/attack/arrow02.wav");break;
		}
		player.start(false); 
	}
	public static void runSounds(int k){
		switch(k){
		case 0: player = new MusicPlayer("sounds/player/archer/run/run01.wav");break;
		case 1: player = new MusicPlayer("sounds/player/archer/run/run02.wav");break;
		}
		player.start(false); 
	}
	public static void attack(int k){
		switch(k){
		case 0: player = new MusicPlayer("sounds/player/archer/attack/4016_shout.wav");break;
		case 1: player = new MusicPlayer("sounds/player/archer/attack/4031_shout_02.wav");break;
		}
		player.start(false); 
	}
	public static void damage(int k){
		switch(k){
		case 0: player = new MusicPlayer("sounds/player/archer/attack/4031_damage.wav");break;
		case 1: player = new MusicPlayer("sounds/player/archer/attack/4031_die.wav");break;
		}
		player.start(false); 
	}
}
