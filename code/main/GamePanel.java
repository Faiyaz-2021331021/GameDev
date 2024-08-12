package main;
import javax.swing.JPanel;
import Inputs.Keyboardinputs;
import Inputs.Mouseinputs;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;

public class GamePanel extends JPanel
{
    private Mouseinputs mouseinputs;
    private float xdelta=100;private float ydelta=100;
    
    private float xdir = 1f;private float ydir=1f;
    private Color color = new Color(50,80,200);
    private Random random;
    
    public GamePanel()
    {
        mouseinputs = new Mouseinputs(this);
        addKeyListener(new Keyboardinputs(this));
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);
        random = new Random();
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
    private Color getrndcolor()
    {
        int r=random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r,g,b);
    }
    private void updaterectangle()
    {
        xdelta+=xdir;
        if(xdelta > 400 || xdelta < 0)
        {
            xdir*= - 1;
            color = getrndcolor();
        }
        ydelta+=ydir;
        if(ydelta > 400 || ydelta < 0)
        {
            ydir*= - 1;
            color = getrndcolor();
        }
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        updaterectangle();
        g.setColor(color);
        g.fillRect((int)xdelta,(int)ydelta,200,50);
    }
}
