package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {

    private final Handler handler;
    Random r= new Random();


    public EnemyBossBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);


        this.handler = handler;

        velX = (r.nextInt(5 - -5)+-5);
        velY = 5;

    }




    public void tick() {
        x += velX;
        y += velY;




         //(y <= 0 || y >= Game.HEIGHT - 32) speedY *= -1;
        //(x <= 0 || x >= Game.WIDTH - 96) speedX *= -1;
        if(y>= Game.HEIGHT) handler.removeObject(this);

        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.magenta, 16, 16, 0.02f, handler));

    }

    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int) x, (int) y, 16, 16);

    }

	public Rectangle getbounds() {
		 return new Rectangle((int) x, (int) y, 16, 16);
		
	}
    }
