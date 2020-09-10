import java.awt.Color;
import java.awt.Graphics;

/**
 * Write a description of class Body here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Body 
{
    private int xCoor, yCoor, width, height;
    
    
    public Body(int xCoor, int yCoor, int titleSize)
    {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = titleSize;
        height = titleSize;
    }
    
    public void tick()
    {
        
    }
    
    public void draw(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillRect(xCoor * width, yCoor * height, width, height);
        
    }
    
    public int getXCoor()
    {
        return xCoor;
    }
    
    public int getYCoor()
    {
        return yCoor;
    }
    
    public void setXCoor(int xCoor)
    {
        this.xCoor = xCoor;
    }
    
    public void setYCoor(int yCoor)
    {
        this.yCoor = yCoor;
    }
   
}
