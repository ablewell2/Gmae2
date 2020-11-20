package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BossBoom extends GameObject {
	
	private final Handler handler;
	Random r= new Random();
	
	public BossBoom(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
		// TODO Auto-generated constructor stub
		velX=r.nextInt(5);
		velY=r.nextInt(5);		
		
		
		
		
	}
	public void tick() {
		x+=velX;
		y+=velY;
		
		if(y<=0||y>=Game.HEIGHT-32)velY*= -1;
		if(x<=0||x>=Game.WIDTH-16)velX*= -1;
		
		
		handler.addObject(new Trail((int)x,(int)y,ID.Trail,Color.red,16,16,0.02f,handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 32, 32);
		
	}
	@Override
	public Rectangle getbounds() {
		
		return new Rectangle((int)x,(int)y,16,16);
	}
	}

