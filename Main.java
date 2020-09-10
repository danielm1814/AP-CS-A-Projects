import javax.swing.JFrame;


/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    /**
     * This creates the basic graphics

     */
    public Main()
    {
        JFrame frame = new JFrame();
        GamePanel gamepanel = new GamePanel();
        
        frame.add(gamepanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake Game");
        
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
    }
    
    public static void main(String[] args)
    {
      new Main();   
    }
     
}
