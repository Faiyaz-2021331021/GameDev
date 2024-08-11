package main;
import javax.swing.JPanel;
import Inputs.Keyboardinputs;
import Inputs.Mouseinputs;

import java.awt.Graphics;


public class GamePanel extends JPanel
{
    private Mouseinputs mouseinputs;
    private int xdelta=100;
    private int ydelta=100;
    public GamePanel()
    {
        mouseinputs = new Mouseinputs(this);
        addKeyListener(new Keyboardinputs(this));
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);
    }
    public void changexdelta(int value)
    {
        this.xdelta +=value;
        repaint();
    }
    public void changeydelta(int value)
    {
        this.ydelta +=value;
        repaint();
    }
    public void setRectPos(int x,int y)
    {
        this.xdelta = x;
        this.ydelta = y;
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.fillRect(xdelta,ydelta,200,50);
    }
}
