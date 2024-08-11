package Inputs;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_A:
                gamepanel.changexdelta(-5);
                break;
            case KeyEvent.VK_D:
                gamepanel.changexdelta(+5);
                break;
            case KeyEvent.VK_W:
                gamepanel.changeydelta(-5);
                break;
            case KeyEvent.VK_S:
                gamepanel.changeydelta(+5);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}