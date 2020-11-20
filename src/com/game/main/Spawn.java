package com.game.main;

import java.util.Random;

import com.game.main.Game.STATE;

public class Spawn {
	
	private final Handler handler;
	private final HUD hud;
	private final Game game;
	private final Random r= new Random();
	
	private float scoreKeep=0;
	
	public Spawn(Handler handler,HUD hud,Game game) {
		super();
		this.handler = handler;
		this.hud=hud;
		this.game= game;
}

	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 100) {
			scoreKeep=0;
		hud.setLevel(hud.getLevel() +1 ) ;
		if(game.diff==0) {
			
		
		if(hud.getLevel()==2) {
			handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH)),(r.nextInt(Game.HEIGHT)),ID.BasicEnemy,handler));
			}else if(hud.getLevel()==3) {
			handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH)),(r.nextInt(Game.HEIGHT)),ID.BasicEnemy,handler));
			}else if(hud.getLevel()==4) {
			handler.addObject(new FastEnemy((r.nextInt(Game.WIDTH-100)),(r.nextInt(Game.HEIGHT-100)),ID.FastEnemy,handler));
			}else if(hud.getLevel()==5) {
			handler.addObject(new SmartEnemy((r.nextInt(Game.WIDTH-50)),(r.nextInt(Game.HEIGHT-50)),ID.SmartEnemy,handler));
			}else if(hud.getLevel()==10) {
			handler.clearEnemys();
			handler.addObject(new EnemyBoss((r.nextInt(Game.WIDTH/2))-48,-120,ID.EnemyBoss,handler));
			for(int i=0;i<5;i++) {
			handler.addObject(new SmartEnemy((r.nextInt(Game.WIDTH-50)),(r.nextInt(Game.HEIGHT)),ID.SmartEnemy,handler));
			}
			}else if(hud.getLevel()==20) {
			handler.clearEnemys();
			for(int i=0;i<50;i++) {
			handler.addObject(new BossBoom(0,0,ID.BossBoom,handler));
			}	
		    }else if(hud.getLevel()==30) {
		    	handler.clearEnemys();
		    	for(int i=0;i<5;i++) {
		    handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH)),(r.nextInt(Game.HEIGHT)),ID.BasicEnemy,handler));
		
			handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH)),(r.nextInt(Game.HEIGHT)),ID.BasicEnemy,handler));
		
			handler.addObject(new FastEnemy((r.nextInt(Game.WIDTH-50)),(r.nextInt(Game.HEIGHT-50)),ID.FastEnemy,handler));
		
			handler.addObject(new SmartEnemy((r.nextInt(Game.WIDTH-50)),(r.nextInt(Game.HEIGHT-50)),ID.SmartEnemy,handler));
		    }
		    }else if(hud.getLevel()==45) {
		    	handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH)),(r.nextInt(Game.HEIGHT)),ID.BasicEnemy,handler));
		    	handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH)),(r.nextInt(Game.HEIGHT)),ID.BasicEnemy,handler));
		    	handler.addObject(new FastEnemy((r.nextInt(Game.WIDTH-100)),(r.nextInt(Game.HEIGHT-100)),ID.FastEnemy,handler));
		    	handler.addObject(new SmartEnemy((r.nextInt(Game.WIDTH-50)),(r.nextInt(Game.HEIGHT-50)),ID.SmartEnemy,handler));	
	}
	}
		else if (game.diff==1) 
	{
		if(hud.getLevel()==2) {
		handler.addObject(new HardEnemy((r.nextInt(Game.WIDTH)),(r.nextInt(Game.HEIGHT)),ID.BasicEnemy,handler));
		}else if(hud.getLevel()==3) {
		handler.addObject(new HardEnemy((r.nextInt(Game.WIDTH)),(r.nextInt(Game.HEIGHT)),ID.BasicEnemy,handler));
		}else if(hud.getLevel()==4) {
		handler.addObject(new FastEnemy((r.nextInt(Game.WIDTH-50)),(r.nextInt(Game.HEIGHT-50)),ID.FastEnemy,handler));
		}else if(hud.getLevel()==5) {
		handler.addObject(new SmartEnemy((r.nextInt(Game.WIDTH-50)),(r.nextInt(Game.HEIGHT-50)),ID.SmartEnemy,handler));
		
		}else if(hud.getLevel()==10) {
		handler.clearEnemys();
		
		
}
	}

		}
	}
}
			
		


	
		
		
	
