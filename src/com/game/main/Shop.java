package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {
	
	Handler handler;
	HUD hud;
	
	private int B1=200;
	public void setB1(int b1) {
		B1 = b1;
	}
	public void setB2(int b2) {
		B2 = b2;
	}
	public void setB3(int b3) {
		B3 = b3;
	}
	private int B2=200;
	private int B3=200;
	
	
	
	public Shop(Handler handler,HUD hud) {
		this.handler=handler;
		this.hud=hud;
		
	}
	public void render (Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("arial",0,48));
		g.drawString("Shop",Game.WIDTH/2-100, 50);
		//box1
		g.setFont(new Font("arial",0,12));
		g.drawString("Upgrade Health",110,120);
		g.drawString("Cost:"+B1,110,140);
		g.drawRect(100,100,100,80);
		//box2

		g.drawString("Upgrade Speed",260,120);
		g.drawString("Cost:"+B2,260,140);
		g.drawRect(250,100,100,80);
		//box3

		g.drawString("Refill Health",410,120);
		g.drawString("Cost:"+B3,410,140);
		g.drawRect(400,100,100,80);
	
		
		g.drawString("SCORE:"+hud.getScore(),Game.WIDTH/2-50,300);
		g.drawString("Press Space to go back",120,300);
		
	}
	public void mousePressed(MouseEvent e) {
		int mx=e.getX();
		int my=e.getY();
		
		//box1
		if(mx >= 10 && mx<=200) {
		if(my>=100 && my<=180) {
		//You've selected box 1
		if(hud.getScore()>=B1) {
		hud.setScore(hud.getScore()-B1);
		B1+=200;
		hud.bounds+=20;
		HUD.HEALTH =(100+(hud.bounds/2));
		}
		}
		}
		//box2
		if(mx >= 250 && mx<=350) {
		if(my>=100 && my<=180) {
		if(hud.getScore()>=B2) {
		hud.setScore(hud.getScore()-B2);
		B2+=200;
		handler.spd++;
		}		
		}
		}//box3
		if(mx >= 400 && mx<=500) {
		if(my>=100 && my<=180) {
			
		if(hud.getScore()>=B3) {
		hud.setScore(hud.getScore()-B3);
		HUD.HEALTH =(100+(hud.bounds/2));
		}
		}
		}
		}
		}