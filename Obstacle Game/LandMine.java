import java.awt.*;
/**
 * LandMine.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 * This is an enemy that is very small and will be placed all around the
 * in order to trap the player
 */
public class LandMine extends Enemy
{
    public LandMine(int x, int y) {
        super(x,y,10,10);
    }
    
    public Color getColor()
    {
        return Color.BLACK;
    }
    
    public void move()
    {
        
    }
    
    
}
