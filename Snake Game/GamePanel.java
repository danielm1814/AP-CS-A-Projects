import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;



/**
 * Write a description of class GamePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GamePanel extends JPanel 
        implements Runnable, KeyListener
{
    private static final long serialVersionUID = 1L;
    
    public static final int WIDTH = 500, HEIGHT = 500;
    
    private Thread thread;
    
    private boolean running;
    
    private boolean right = true, left = false, up = false, down = false;
    
    private Body b;
    private ArrayList<Body> snake;
    
    private Apple apple;
    private ArrayList<Apple> apples;
    
    private Random r;
    
    private int speed = 100000;
    private int count = 0;
    private int record = 0;
    
    private int xCoor = 10, yCoor = 10, size = 5;
    
    private int ticks = 0;
    /**
     * This creates the intended size of a panel
     */
    public GamePanel()
    {
        setFocusable(true);
        
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);
        
        snake = new ArrayList<Body>();
        apples = new ArrayList<Apple>();
        
        r = new Random();
        
        
        
        
        
        start();
    }
    
    public void start()
    {
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public void stop()
    {
        running = false;
        
        try{
            thread.join();
        } catch (InterruptedException e)
        {
        }
    }
    
    public void tick()
    {
        if (snake.size() == 0)
        {
            b = new Body(xCoor, yCoor, 10);
            snake.add(b);
        }
        ticks++;
        if (ticks > speed)
        {
            if(right) xCoor++;
            if(left) xCoor--;
            if(up) yCoor--;
            if(down) yCoor++;
            
            ticks = 0;
            
            b = new Body(xCoor, yCoor, 10);
            snake.add(b);
            
            if (snake.size() > size)
            {
                snake.remove(0);
            }
        }
        
        if(apples.size() == 0)
        {
            int xCoor = r.nextInt(49);
            int yCoor = r.nextInt(49);
            
            apple = new Apple(xCoor, yCoor, 10);
            apples.add(apple);
        }
        
        for(int i = 0; i < apples.size(); i++)
        {
            if(xCoor == apples.get(i).getXCoor() && yCoor == apples.get(i).getYCoor())
            {
                size++;
                apples.remove(i);
                speed = speed - 2000;
                count++;
                i++;
            }
        }
        
        for(int i = 0; i < snake.size(); i++)
        {
            if(xCoor == snake.get(i).getXCoor() && yCoor == snake.get(i).getYCoor())
            {
                if(i != snake.size() - 1)
                {
                    if (count > record)
                    {
                        record = count;
                    }
                    JOptionPane.showMessageDialog(null, "Score: " + count + "\nHigh Score: " + record,"Score",JOptionPane.INFORMATION_MESSAGE);
                    int n = JOptionPane.showConfirmDialog(null, "Game Over! Would you like to play again?", "New Game", JOptionPane.YES_NO_OPTION); //Collision
                    
                    if (n == JOptionPane.NO_OPTION)
                    {
                        stop();
                    }
                    else if (n == JOptionPane.YES_OPTION)
                    {
                        snake.clear();
                        size = 3;
                        speed = 100000;
                        count = 0;
                    }
                    
                }
            }
        }
        
        if(xCoor < 0 || xCoor > 49 || yCoor < 0 || yCoor > 49)
        {
            if (count > record)
            {
                record = count;
            }
            JOptionPane.showMessageDialog(null, "Score: " + count + "\nHigh Score: " + record,"Score",JOptionPane.INFORMATION_MESSAGE);
            int n = JOptionPane.showConfirmDialog(null, "Game Over! Would you like to play again?", "New Game", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.NO_OPTION)
               {
                    stop();
               }
            if (n == JOptionPane.YES_OPTION)
               {
                    snake.clear();
                    size = 3;
                    speed = 100000;
                    count = 0;
                    if(yCoor > 49)
                    {
                        yCoor=25;
                        xCoor=25;
                    }
                    if(yCoor < 0)
                    {
                        yCoor=25;
                        xCoor=25;
                    }
                    if(xCoor > 49)
                    {
                        xCoor=25;
                        yCoor=25;
                    }
                    if(xCoor < 0)
                    {
                        xCoor=25;
                        yCoor=25;
                    }
               }
            
        }
        
    }
    
    /**
     * Colors the background dark gray
     * creates a grid that gets covered by the painted gray
     * @param g
     */
    public void paint(Graphics g)
    {
        g.clearRect(0,0,WIDTH,HEIGHT);
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,WIDTH,HEIGHT);
        
        for(int i = 0; i < WIDTH/10; i++)
        {
            g.drawLine(i*10, 0, i*10, HEIGHT);
        }
        
        for(int i = 0; i < HEIGHT/10; i++)
        {
            g.drawLine(0, i*10, HEIGHT, i*10);
        }
        
        for(int i = 0; i < snake.size(); i++)
        {
            snake.get(i).draw(g);
        }
        
        for(int i = 0; i < apples.size(); i++)
        {
            apples.get(i).draw(g);
        }
    }
    
    
    @Override
    public void run()
    {
        while(running)
        {
            tick();
            revalidate();
            repaint();
        }
    }
    
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT && !left)
        {
            right = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_LEFT && !right)
        {
            left = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_DOWN && !up)
        {
            down = true;
            left = false;
            right = false;
        }
        if(key == KeyEvent.VK_UP && !down)
        {
            up = true;
            left = false;
            right = false;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }
   
}

