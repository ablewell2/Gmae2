package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {
	
	private final Handler handler;
	private GameObject player;

	public SmartEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
		
		for(int i=0;i<handler.object.size();i++) {
			if(handler.object.get(i).getId()==ID.Player)player=handler.object.get(i);
			
			
		}
	
	}
		public Rectangle getbounds() {
		return new Rectangle((int)x,(int)y,16,16);
		
}
	
	public void tick() {
		x+=velX;
		y+=velY;
		//ALGORITHIM FOR SMART ENEMY
		float diffX=x-player.getX()-8;		
		float diffY=y-player.getY()-8;
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()) );
		
		
		velX= (-5/distance)*diffX;
		velY= (-5/distance)*diffY;
		
		if(y<=0||y>=Game.HEIGHT-32)velY*= -1;
		if(x<=0||x>=Game.WIDTH-32)velX*= -1;
		
		handler.addObject(new Trail((int)x,(int)y,ID.Trail,Color.green,16,16,0.02f,handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x,(int) y, 16, 16);
	}
	

	
	}


