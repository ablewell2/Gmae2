package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class HardEnemy extends GameObject {
	
	private final Handler handler;
	
	private final Random r= new Random();
	
	private final BufferedImage enemy_image;
	

	public HardEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
		// TODO Auto-generated constructor stub
		 velX = (r.nextInt(5 - -5)+-5);
	
		SpriteSheet ss= new SpriteSheet(Game.sprite_sheet);
		enemy_image= ss.grabImage(1, 4, 16, 16);
	}

	
	public void tick() {
		x+=velX;
		y+=velY;
		
		if(y<=0||y>=Game.HEIGHT-32) {if(velY<0)velY =-(r.nextInt(7)+1)*-1;else velY = (r.nextInt(7)+1)*-1;}
		if(x<=0||x>=Game.WIDTH-16) {if(velX<0)velX =-(r.nextInt(7)+1)*-1;else velX = (r.nextInt(7)+1)*-1;}
		
		
		//handler.addObject(new Trail((int)x,(int)y,ID.Trail,Color.yellow,16,16,0.02f,handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x,(int) y, 16, 16);
		g.drawImage(enemy_image, (int)x,(int)y,null);
	}
	@Override
	public Rectangle getbounds() {
		
		return new Rectangle((int)x,(int)y,16,16);
	}
	}
