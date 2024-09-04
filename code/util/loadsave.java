package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Color;

import main.Game;


public class loadsave 
{
    public static  final String  PLAYER_ATLAS = "res/player_sprites.png";
    public static  final String  LEVEL_ATLAS = "res/outside_sprites.png";
    public static  final String  LEVEL_ONE_DATA = "res/level_one_data.png";

    public static BufferedImage Getspriteatlas(String filename)
    {
        BufferedImage img = null;
        InputStream is = loadsave.class.getClassLoader().getResourceAsStream(filename);
        try
        {
            img = ImageIO.read(is);
        }
        catch (IOException e)
        {
            System.out.println("not found");
        }
        finally
        {
            try
            {
                is.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return img;
    }
    public static int[][] Getleveldata()
    {
        int[][] lvldata = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];
        BufferedImage img = Getspriteatlas(LEVEL_ONE_DATA);
        
        for(int j=0;j<img.getHeight();j++)
        {
            for(int i=0;i<img.getWidth();i++)
            {
                Color color = new Color(img.getRGB(i,j));
                int value = color.getRed();
                if(value>=48)value=0;
                lvldata[j][i] = value;
            }
        }
        return lvldata;
    }
}
