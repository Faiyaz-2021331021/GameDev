package main;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import Inputs.Keyboardinputs;
import Inputs.Mouseinputs;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Dimension;

public class GamePanel extends JPanel
{
    private Mouseinputs mouseinputs;
    private float xdelta=100;private float ydelta=100;
    private BufferedImage img;
    private BufferedImage[] idleani;
    private int anitick,aniindex,anispeed = 30;
    
    public GamePanel()
    {
        mouseinputs = new Mouseinputs(this);
        addKeyListener(new Keyboardinputs(this));
        setpanelsize();
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);
        importimage();
        loadanimation();
    }
    private void loadanimation()
    {
        idleani = new BufferedImage[2];
        // for(int i=0;i<5;i++)
        // {
        //     idleani[i] = img.getSubimage(10, 0, 35, 45);
        // }
        idleani[0] = img.getSubimage(10, 0, 35, 45);
        idleani[1] = img.getSubimage(47, 0, 55, 45);
    }
    private void importimage()
    {
        InputStream is = getClass().getClassLoader().getResourceAsStream("res/Player.png");
        try
        {
            img = ImageIO.read(is);
        }
        catch (IOException e)
        {
            // e.printStackTrace();
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
    }
    public void setpanelsize()
    {
        Dimension size = new Dimension(1280,800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }
    public void changexdelta(int value)
    {
        this.xdelta +=value;
    }
    public void changeydelta(int value)
    {
        this.ydelta +=value;
    }
    public void setRectPos(int x,int y)
    {
        this.xdelta = x;
        this.ydelta = y;
    }
    private void updateanimationtick()
    {
        anitick++;
        if(anitick >= anispeed)
        {
            anitick = 0;
            aniindex++;
            if(aniindex >= idleani.length)
            {
                aniindex = 0;
            }
        }
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        updateanimationtick();
        g.drawImage(idleani[aniindex], (int)xdelta, (int)ydelta, 120,80,null);

        
    }
}
