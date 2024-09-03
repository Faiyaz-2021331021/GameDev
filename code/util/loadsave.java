package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class loadsave 
{
    public static  final String  PLAYER_ATLAS = "res/player_sprites.png";

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
}
