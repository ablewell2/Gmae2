package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class FastEnemy extends GameObject {
	
	private final Handler handler;
	private final BufferedImage fast_image;

	
	public FastEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
		// TODO Auto-generated constructor stub
		velX=3;
		velY=9;		
	
	SpriteSheet ss= new SpriteSheet(Game.sprite_sheet);
	fast_image= ss.grabImage(1, 3, 16, 16);
	}
	public void tick() {
		x+=velX;
		y+=velY;
		
		if(y<=0||y>=Game.HEIGHT-32)velY*= -1;
		if(x<=0||x>=Game.WIDTH-16)velX*= -1;
		
	
	   //handler.addObject(new Trail((int)x,(int)y,ID.Trail,Color.blue,16,16,0.02f,handler));
	}
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x,(int) y, 16, 16);
		g.drawImage(fast_image, (int)x,(int)y,null);
	}
	@Override
	public Rectangle getbounds() {
		
		return new Rectangle((int)x,(int)y,16,16);
	}
	}

