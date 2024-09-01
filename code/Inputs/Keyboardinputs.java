package Inputs;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import util.Constants;
import util.Constants.Directions.*;
import main.GamePanel;

public class Keyboardinputs implements KeyListener
{   
    private GamePanel gamepanel;
    public Keyboardinputs(GamePanel gamepanel)
    {
        this.gamepanel = gamepanel;
        
    }
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch ((e.getKeyCode()))
        {
            case KeyEvent.VK_W:
                gamepanel.getgame().getPlayer().setup(true);
                break;
            case KeyEvent.VK_A:
                gamepanel.getgame().getPlayer().setleft(true);
                break;
            case KeyEvent.VK_S:
                gamepanel.getgame().getPlayer().setdown(true);
                break;
            case KeyEvent.VK_D:
                gamepanel.getgame().getPlayer().setright(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch ((e.getKeyCode()))
        {
            case KeyEvent.VK_W:
                gamepanel.getgame().getPlayer().setup(false);
                break;
            case KeyEvent.VK_A:
                gamepanel.getgame().getPlayer().setleft(false);
                break;
            case KeyEvent.VK_S:
                gamepanel.getgame().getPlayer().setdown(false);
                break;
            case KeyEvent.VK_D:
                gamepanel.getgame().getPlayer().setright(false);
                break;
        }
    }
}
