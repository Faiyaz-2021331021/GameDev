package levels;
import main.Game;
import util.loadsave;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class levelmanager
{
    private Game game;
    private BufferedImage[] levelSprite;
    private level levelone;
    
    public levelmanager(Game game)
    {
        this.game = game;
        importOutsideSprites();
        levelone = new level(loadsave.Getleveldata());
    }
    
    private void importOutsideSprites()
    {
        BufferedImage img = loadsave.Getspriteatlas(loadsave.LEVEL_ATLAS);
        levelSprite = new BufferedImage[48];
        for(int j=0;j<4;j++)
        {
            for(int i=0;i<12;i++)
            {
                int index = j*12 + i;
                levelSprite[index] = img.getSubimage(i*32,j*32,32,32);
            }
        }
    }

    public void draw(Graphics g)
    {
        for(int j=0;j<Game.TILES_IN_HEIGHT;j++)
        {
            for(int i=0;i<Game.TILES_IN_WIDTH;i++)
            {
                int index = levelone.getspriteindex(i, j);
                g.drawImage(levelSprite[index], Game.TILES_SIZE*i,Game.TILES_SIZE*j,Game.TILES_SIZE,Game.TILES_SIZE,null);
            }
        }
    }
    public void update()
    {

    }
}
