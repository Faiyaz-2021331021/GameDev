package main;

import java.awt.Graphics;

import Entities.Player;
import levels.levelmanager;

public class Game implements Runnable
{
    private int frames=0;private long lastcheck=0;
    private GameWindow gamewindow;
    private GamePanel gamepanel;
    private Thread gamethread;
    private final int FPS = 120;
    private final int UPS_SET  = 200;
    private Player player;
    private levelmanager levelmanager;
    public final static int  TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 1.5f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int)(TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
    

    public Game()
    {
        initclasses();
        gamepanel = new GamePanel(this);
        gamewindow = new GameWindow(gamepanel);
        gamepanel.requestFocus();
        startgameloop();
    }
    
    private void initclasses()
    {
        player = new Player(10, 10);
        levelmanager = new levelmanager(this);
    }

    private void startgameloop()
    {
        gamethread = new Thread(this);
        gamethread.start();
    }
    
    public void render(Graphics g)
    {
        levelmanager.draw(g);
        player.render(g);
        
    }
    
    public void update()
    {
        player.update();
        levelmanager.update();
    }



    @Override
    public void run()
    {
        double  timeperframe = 1000000000.0 / FPS;
        double timeperupdate = 1000000000.0 / UPS_SET;
        long prevtime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        double deltau = 0;
        double deltaf = 0;


        while(true)
        {
            long currenttime = System.nanoTime();

            deltau += (currenttime - prevtime) / timeperupdate;
            deltaf += (currenttime - prevtime) / timeperframe;
            prevtime = currenttime;

            if(deltau >= 1)
            {
                update();
                updates++;
                deltau--;
            }

            if(deltaf >= 1)
            {
                gamepanel.repaint();
                deltaf--;
                frames++;
            }


            if(System.currentTimeMillis() - lastcheck >= 1000)
            {
                lastcheck = System.currentTimeMillis();
                System.out.println("FPS = " + frames + " UPS = " + updates);
                frames=0;
                updates=0;
            }   
        }
    }

    public void windowfocuslost()
    {
        player.resetdirboolean();
    }

    public Player getPlayer()
    {
        return player;
    }
}
