package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -473349850293143017L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	public static boolean paused = false;
	public int diff = 0;


	private final Random r;

	private final Handler handler;
	private final HUD hud;
	private final Spawn spawner;
	private final Menu menu;
	private final Shop shop;

	public enum STATE {
		Menu, Game, Help, End, Select, Shop, Win
	}

	public static STATE gameState = STATE.Menu;

	public static BufferedImage sprite_sheet = null;

	public Game() {


		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			sprite_sheet = loader.loadImage("/Sprite_sheet.png");
			System.out.println("loaded");
		} catch (Exception e) {

			e.printStackTrace();
		}


		handler = new Handler();
		hud = new HUD();
		shop = new Shop(handler, hud);
		menu = new Menu(this, handler, hud, shop);
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		AudioPlayer2.playMenuSound();


		new Window(WIDTH, HEIGHT, "Lets Biuld a Game!", this);


		spawner = new Spawn(handler, hud, this);

		r = new Random();

		if (gameState == STATE.Game) {


			//for(int i=0;i<50;i++) {
			//handler.addObject(new Player(0,0,ID.Player));
			//for(int i =0;i<4;i++)
			handler.addObject(new Player((WIDTH) / 2 - 32, (HEIGHT) / 2 - 32, ID.Player, handler));
			handler.addObject(new BasicEnemy((r.nextInt(WIDTH)), (r.nextInt(HEIGHT)), ID.BasicEnemy, handler));

		}else{
			for (int i = 0; i < 10; i++) {
				handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
			
		}
	}
	}
	public synchronized void start() {
		thread= new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running =false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime= System.nanoTime();
		double amoutOfTicks=60.0;
		double ns= 1_000_000_000/amoutOfTicks;
		double delta=0;
		long timer= System.currentTimeMillis();
		int frames=0;
		
		while(running) {
			long now = System.nanoTime();
			delta +=(now -lastTime)/ns;
			lastTime=now;
			while(delta >=1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis()-timer>1000) {
				timer+=1000;
				System.out.println("FPS:"+frames);
				frames = 0;
			}
		}
		stop();
		
	}
	

	private void tick() {
		
		if (gameState == STATE.Game) {
            hud.tick();
            spawner.tick();
            handler.tick();
           
            if (HUD.HEALTH <= 0) {
                HUD.HEALTH = 100;
                gameState = STATE.End;
                handler.clearEnemys();
    			for (int i = 0; i < 10; i++) {
    				handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
    			}
            }

            }else if (gameState == STATE.Menu || gameState == STATE.Help||gameState == STATE.Select||gameState == STATE.End||gameState ==STATE.Win) {
            	
                menu.tick();
                handler.tick();
               
                
            } if(HUD.level >= 5) {gameState= STATE.Win;handler.clearEnemys();for (int i = 0; i < 10; i++) {
				handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
				
	}
	}
	}
	private void render() {
		BufferStrategy bs= this.getBufferStrategy();
		if (bs==null) {
			this.createBufferStrategy(2);
			return;
		}
		
		Graphics g= bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(paused) {
			g.setColor(Color.white);
			g.drawString("PAUSED", 100, 100);
		}
		if(gameState == STATE.Game) {
		 hud.render(g);
		handler.render(g);
	}else if(gameState == STATE.Shop) {
		shop.render(g);
	}else if(gameState==STATE.Menu||gameState==STATE.Help||gameState==STATE.End||gameState==STATE.Select||gameState==STATE.Win) {
		menu.render(g);
		handler.render(g);
	}
		g.dispose();
		bs.show();
	}

	public static float clamp(float var,float min, float max) {
		if(var>=max)
			return var= max;
		else if (var <= min)
			return  (var = min);
		else 
			return  var;
	}
	
	public static void main(String[] args) {
		new Game();
		

	}

}
