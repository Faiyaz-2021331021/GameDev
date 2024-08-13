package main;
import javax.swing.JFrame;


public class GameWindow
{
    private JFrame jframe;
    public GameWindow(GamePanel gamepanel)
    {
        jframe = new JFrame();

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamepanel);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true);
    }    
}
