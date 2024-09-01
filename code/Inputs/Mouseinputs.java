package Inputs;

import java.awt.event.MouseEvent;
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
        
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            gamepanel.getgame().getPlayer().setattacking(true);
        }
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
