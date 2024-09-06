package Entities;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;

public abstract class Entity
{
    protected float x,y;
    protected int width,height;
    protected Rectangle hitbox;

    public Entity(float x,float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        inithitbox();
    }

    protected void drawhitbox(Graphics g)
    {
        g.setColor(Color.RED);
        g.drawRect(hitbox.x+20, hitbox.y+3, hitbox.width+20, hitbox.height+10);

    }

    private void inithitbox()
    {
       hitbox = new Rectangle((int)x,(int)y,width,height);
    }


    protected void updatehitbox()
    {
        hitbox.x = (int)x;
        hitbox.y = (int)y;
    }


    public Rectangle  gethitbox()
    {
        return hitbox;
    }

}
