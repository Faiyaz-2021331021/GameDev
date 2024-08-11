package Inputs;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.GamePanel;


public class Mouseinputs implements MouseMotionListener,MouseListener
{
    private GamePanel gamepanel;
    public Mouseinputs(GamePanel gamepanel)
    {
        this.gamepanel = gamepanel;
    }
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e)
    {

    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e)
    {
        gamepanel.setRectPos(e.getX(),e.getY());
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e)
    {
        System.out.println("mouse clicked");
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e)
    {
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e)
    {
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e)
    {
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e)
    {
        
    }
    
}
