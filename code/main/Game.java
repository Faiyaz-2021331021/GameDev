package main;

public class Game implements Runnable
{
    private int frames=0;private long lastcheck=0;
    private GameWindow gamewindow;
    private GamePanel gamepanel;
    private Thread gamethread;
    private final int FPS = 120;
    public Game()
    {
        gamepanel = new GamePanel();
        gamewindow = new GameWindow(gamepanel);
        gamepanel.requestFocus();
        startgameloop();
    }
    
    private void startgameloop()
    {
        gamethread = new Thread(this);
        gamethread.start();
    }

    @Override
    public void run()
    {
        double  timeperframe = 1000000000.0 / FPS;
        long lastframe = System.nanoTime();
        long now = System.nanoTime();
        while(true)
        {
            now = System.nanoTime();
            if(now - lastframe >= timeperframe)
            {
                gamepanel.repaint();
                lastframe = now;
                frames++;
            }
            if(System.currentTimeMillis() - lastcheck >= 1000)
            {
                lastcheck = System.currentTimeMillis();
                System.out.println("FPS = " + frames);
                frames=0;
            }   
        }
    }

    
}
