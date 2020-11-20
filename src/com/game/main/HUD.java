package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	public int bounds=0;
	public static float HEALTH=100;
	private float score = 0;
	public static float level=0;
	
	public void tick() {
		HEALTH= Game.clamp(HEALTH, 0, 100+(bounds)/2);
		
		score++;
	}
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.drawString(HEALTH+"%", 220, 40);
		g.fillRect(15, 15, 200+bounds, 32);
		g.setColor(Color.getHSBColor( (1f * HEALTH) / 360, 1f, 1f));
		g.fillRect(15, 15,(int) HEALTH*2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200+bounds, 32);
		
		g.drawString("Score:"+score,15 , 64);
		g.drawString("Level:"+level,15 , 80);
		g.drawString("Space for Shop:",15 , 94);
		
}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public float getLevel() {
		return level;
	}
	public void setLevel(float level) {
		HUD.level = level;
	}
	
}
