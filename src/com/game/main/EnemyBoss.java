package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class EnemyBoss extends GameObject {

    private final Handler handler;
    Random r = new Random();
    private int timer = 80;
    private int timer2 = 50;

    public EnemyBoss(int x, int y, ID id, Handler handler) {
        super(x, y, id);


        this.handler = handler;

        velX = 0;
        velY = 2;

    }

    @Override
	public Rectangle getbounds() {
		
       return new Rectangle((int) x, (int) y, 96, 96);
  
    }

    public void tick() {
        x += velX;
        y += velY;

        if (timer <= 0) velY = 0;
        else timer--;

        if (timer <= 0) timer2--;
        if (timer2 <= 0)
        {
            if (velX == 0)
                velX = 2;
            velX += 0.01f*Math.signum(velX);
            velX=Game.clamp(velX,-10,10);
            int spawn = r.nextInt(10);
            if (spawn == 0) handler.addObject(new EnemyBossBullet((int) x + 48, (int) y + 48, ID.BasicEnemy, handler));
        }
    // if (y <= 0 || y >= Game.HEIGHT - 32) speedY *= -1;
        if(x <=0||x >=Game.WIDTH -96)velX *=-1;
    //handler.addObject(new BasicTrail((int) x, (int) y, ID.BasicTrail, Color.magenta, 96, 96, 0.02f, handler));

}

    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int) x, (int) y, 96, 96);

    }

	}
