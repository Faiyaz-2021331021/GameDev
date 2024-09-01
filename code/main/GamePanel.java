package main;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import Inputs.Keyboardinputs;
import Inputs.Mouseinputs;
import java.awt.Graphics;
import java.awt.Dimension;
public class GamePanel extends JPanel
{
    private Mouseinputs mouseinputs;
    private Keyboardinputs keyboardinputs;
    private Game game;
    
    
    public GamePanel(Game game)
    {
        keyboardinputs = new Keyboardinputs(this);
        mouseinputs = new Mouseinputs(this);
        addKeyListener(new Keyboardinputs(this));
        this.game = game;
        setpanelsize();
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);
    }


    public void setpanelsize()
    {
        Dimension size = new Dimension(1280,800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }
    
    public void updategame()
    {
       
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        game.render(g);
    }
    public Game getgame()
    {
        return game;
    }

}
