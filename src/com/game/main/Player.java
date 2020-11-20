package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject{
	Random r= new Random();
	Handler handler;
	private final BufferedImage player_image;
	SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
	public Player( int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
		
		
		
	
		//velX=r.nextInt(5)+1;
		//velY=r.nextInt(5);
		player_image= ss.grabImage(1, 1, 32, 32);
	}
	@Override
	public Rectangle getbounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x,0,Game.WIDTH -38);
		y = Game.clamp(y,0,Game.HEIGHT -61);
		
		//handler.addObject(new Trail((int)x,(int)y,ID.Trail,Color.white,32,32,0.05f,handler));
		collision();
		
		
	}
	public void collision() {
		for(int i=0;i<handler.object.size();i++) {
			
			GameObject tempObject= handler.object.get(i);
			
			if(tempObject.getId()==ID.BasicEnemy||tempObject.getId()==ID.FastEnemy||tempObject.getId()==ID.SmartEnemy||tempObject.getId()==ID.EnemyBoss||tempObject.getId()==ID.BossBoom) {//tempobject is enemy
			 if(getbounds().intersects(tempObject.getbounds())){
				//Collision code
				HUD.HEALTH-=2;
			}
		}
	}
	}
	public void render(Graphics g){
		g.setColor(Color.white);
		g.fillRect((int)x,(int) y, 32,32);
		g.drawImage(player_image, (int)x,(int)y,null);
}

	
}
