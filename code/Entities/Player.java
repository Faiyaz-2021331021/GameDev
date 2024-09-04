package Entities;
import static util.Constants.Directions.DOWN;
import static util.Constants.Directions.LEFT;
import static util.Constants.Directions.RIGHT;
import static util.Constants.Directions.UP;
import static util.Constants.PlayerConstants.ATTACK_1;
import static util.Constants.PlayerConstants.IDLE;
import static util.Constants.PlayerConstants.RUNNING;
import static util.Constants.PlayerConstants.getSpriteAmount;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


import javax.imageio.ImageIO;

import util.loadsave;
public class Player extends Entity
{
    private BufferedImage[][] animation;
    private int anitick,aniindex,anispeed = 15;
    private int playeraction = IDLE;
    private boolean moving = false ,  attacking = false;
    private boolean left,right,up,down;
    private double playerspeed = 2.0f;
    public Player(float x,float y)
    {
        super(x,y);
        loadanimation();
    }
    public void update()
    {
        updatepos();
        updateanimationtick();
        setanimation();
    }
    public void render(Graphics g)
    {
        g.drawImage(animation[playeraction][aniindex], (int)x, (int)y, 256-120,160-80,null);
    }
    
    private void updateanimationtick()
    {
        anitick++;
        if(anitick >= anispeed)
        {
            anitick = 0;
            aniindex++;
            if(aniindex >= getSpriteAmount(playeraction))
            {
                aniindex = 0;
                attacking = false;
            }
        }
    }

    public void resetanitick()
    {
        anitick = 0;
        aniindex = 0;
    }

    private void setanimation()
    {

        int startani = playeraction;
        

        if(moving)
            playeraction = RUNNING;
        else
            playeraction = IDLE; 
        if(attacking)
            playeraction = ATTACK_1;

        if(startani != playeraction)
        {
            resetanitick();
        }
    }
    private void updatepos()
    {
        moving = false;

        if(left && !right){x-=playerspeed;moving = true;}
        else if(right && !left){x+=playerspeed;moving  = true;}

        if(up && !down){y-=playerspeed;moving = true;}
        else if(down && !up){y+=playerspeed;moving = true;}
    }
    private void loadanimation()
    {
        BufferedImage img = loadsave.Getspriteatlas(loadsave.PLAYER_ATLAS);
        animation = new BufferedImage[9][6];
        for(int j=0;j<animation.length;j++)
        {
            for(int i=0;i<animation[j].length;i++)
            {
                animation[j][i] = img.getSubimage(i*64, j*40, 64, 40);
            }
        }
    }

    public void resetdirboolean()
    {
        left = false;
        right = false;
        up = false;
        down = false;
    }
    
    public void setattacking(boolean attacking)
    {
        this.attacking = attacking;
    }

    public boolean isdown()
    {
        return down;
    }
    public void setdown(boolean down)
    {
        this.down = down;
    }

    public boolean isup()
    {
        return up;
    }
    public void setup(boolean up)
    {
        this.up = up;
    }

    public boolean isleft()
    {
        return left;
    }
    public void setleft(boolean left)
    {
        this.left = left;
    }

    public boolean isright()
    {
        return right;
    }
    public void setright(boolean right)
    {
        this.right = right;
    }

}
