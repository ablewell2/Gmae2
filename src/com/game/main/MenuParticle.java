package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{

    private final Handler handler;

    Random r =new Random();

    private final Color col;


    public MenuParticle(int x, int y,ID id,Handler handler) {
        super(x, y, id);

        this.handler=handler;

    velX=(r.nextInt(7 - -7)+-7);
    velY=(r.nextInt(7 - -7)+-7);
if(velX ==0)velX=1;
if(velY==0)velY=1;
    col=new Color(r.nextInt(225),r.nextInt(225),r.nextInt(225));

}

    public Rectangle getbounds() {
        return new Rectangle((int)x,(int) y, 16, 16);

    }

    public void tick() {
        x += velX;
        y +=velY;

        if(y <= 0 || y>= Game.HEIGHT-32)velY*= -1;
        if(x <= 0 || x>= Game.WIDTH-32) velX*= -1;
        handler.addObject(new Trail((int)x,(int)y, ID.Trail,col,16,16, 0.05f,handler));

    }

    public void render(Graphics g) {
        g.setColor(col);
        g.fillRect((int)x,(int)y,16,16);

    }
}