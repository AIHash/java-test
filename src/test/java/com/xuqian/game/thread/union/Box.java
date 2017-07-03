package com.xuqian.game.thread.union;

public class Box {
	private Wall[] walls;
	public Box() {
		walls = new Wall[4];
		for (int i=0;i<walls.length;i++){
			walls[i] = Wall.BLOCK;
		}
	}
	
}
