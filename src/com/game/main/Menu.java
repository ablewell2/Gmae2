package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.game.main.Game.STATE;

public class Menu extends MouseAdapter{
	private final Game game;
	private final Handler handler;
	private final Random r= new Random();
	private final HUD hud;
	private final Shop shop;
	public Menu(Game game ,Handler handler, HUD hud,Shop shop) {
		this.game=game;
		this.handler=handler;
		this.hud=hud;
		this.shop=shop;
	}
	
	
	public void mousePressed(MouseEvent e) {
		int mx= e.getX();
		int my=e.getY();
		
	if(Game.gameState ==STATE.Menu) {
		//play button
		if(mouseOver(mx,my,210,150,200,64)) {
			
			Game.gameState =STATE.Select;
			return;
			
		}

		//help button
		if(mouseOver(mx,my,210,250,200,64)) {
			Game.gameState =STATE.Help;
			
	}
		//quite button
		 if (mouseOver(mx, my, 210, 350, 200, 64)) {
             System.exit(1);
		}
					}	
				if(Game.gameState ==STATE.Select) {
					//normal button
					if(mouseOver(mx,my,210,150,200,64)) {
						Game.gameState =STATE.Game;
						handler.addObject(new Player((Game.WIDTH)/2-32,(Game.HEIGHT)/2-32,ID.Player ,handler));
						handler.clearEnemys();
						handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH)),(r.nextInt(Game.HEIGHT)),ID.BasicEnemy,handler));
						
						game.diff=0;
					}

					//hard button
					if(mouseOver(mx,my,210,250,200,64)) {
						Game.gameState =STATE.Game;
						handler.addObject(new Player((Game.WIDTH)/2-32,(Game.HEIGHT)/2-32,ID.Player ,handler));
						handler.clearEnemys();
						handler.addObject(new HardEnemy((r.nextInt(Game.WIDTH)),(r.nextInt(Game.HEIGHT)),ID.BasicEnemy,handler));
						game.diff=1;
				}
					//back button
					 if (mouseOver(mx, my, 210, 350, 200, 64)) {
							Game.gameState =STATE.Menu;
		     				return;
					 }
				}
			           //back button for help
			     		if(Game.gameState ==STATE.Help) {
			     			if(mouseOver(mx,my,210,350,200,64)) {
			     				Game.gameState =STATE.Menu;
			     				
			     				return;
			     			}
			     		}
			     			//try again button
			     			if(Game.gameState ==STATE.End|| Game.gameState ==STATE.Win) {
			     				if(mouseOver(mx,my,210,350,200,64)) {
			     					Game.gameState =STATE.Menu;
			     					hud.setLevel(1);
				     				hud.setScore(0);
				     				shop.setB1(200);
				     				shop.setB2(200);
				     				shop.setB3(200);
				     				hud.bounds=0;
				     				handler.spd=5;
			     					return;
					}
				}
			}
		
	
	public void mouseReleased(MouseEvent e) {
		
	}
	private boolean mouseOver(int mx,int my,int x,int y, int width, int height) {
		if(mx>x&&mx<x+width) {
			return my > y && my < y + height;
		}else return false;
	}
	 public void tick() {
	}
	 
	  public void render(Graphics g) {
		  if(Game.gameState ==STATE.Menu) {
			  Font fnt=new Font("arial",1,50);
			  Font fnt2=new Font("arial",1,30);
			  
			  g.setFont(fnt);
			  g.setColor(Color.white);
			  g.drawString("Dodge",240,70);
			  
			  g.setFont(fnt2);
			  g.drawRect(210, 150, 200, 64);
			  g.drawString("Play",270,190);
			  
			  
			  g.drawRect(210, 250, 200, 64);
			  g.drawString("Help",270,290);
			  
			  
			  g.drawRect(210, 350, 200, 64);
			  g.drawString("Quit",270,390);
			  
	}else if (Game.gameState ==STATE.Help) {
		Font fnt=new Font("arial",1,50);
		Font fnt2=new Font("arial",1,30);
		Font fnt3=new Font("arial",1,20);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Help",240,70);
		
		g.setFont(fnt3);
		g.drawString("Use WASD keys to move player and dodge",100,200);
		g.drawString("And P to Pause",200,250);
		
		g.setFont(fnt2);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Back",270,390);
	}else if (Game.gameState ==STATE.End) {
		Font fnt=new Font("arial",1,50);
		Font fnt2=new Font("arial",1,30);
		Font fnt3=new Font("arial",1,20);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Game Over",180,70);
		
		g.setFont(fnt3);
		g.drawString("You lost with a score of:"+hud.getScore(),175,200);
		
		
		g.setFont(fnt2);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Try Again",245,390);
	}else if (Game.gameState ==STATE.Win) {
		Font fnt=new Font("arial",1,50);
		Font fnt2=new Font("arial",1,30);
		Font fnt3=new Font("arial",1,20);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("You Win!",180,70);
		
		g.setFont(fnt3);
		g.drawString("You win with a score of:"+hud.getScore(),175,200);
		
		g.setFont(fnt2);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Try Again",245,390);
		
	}else if(Game.gameState ==STATE.Select) {
		  Font fnt=new Font("arial",1,50);
		  Font fnt2=new Font("arial",1,30);
		  
		  g.setFont(fnt);
		  g.setColor(Color.white);
		  g.drawString("SELECT MODE",140,70);
		  
		  g.setFont(fnt2);
		  g.drawRect(210, 150, 200, 64);
		  g.drawString("NORMAL",250,190);
		  
		  
		  g.drawRect(210, 250, 200, 64);
		  g.drawString("TEST",270,290);
		  
		  
		  g.drawRect(210, 350, 200, 64);
		  g.drawString("Back",270,390);
		  
		  }
	  } 
}