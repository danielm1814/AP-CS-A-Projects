import java.awt.*;

public class StalkerEnemy extends Enemy
{
    private Rectangle player;
    
    public StalkerEnemy(int x, int y, int w, int h, Rectangle p) {
        super(x,y,w,h);
        player = p;
    }
    
    public Color getColor()
    {
        return Color.BLACK;
    }
    
    public void move()
    {
        Rectangle ourRect = getRectangle();
        
        if (ourRect.y < player.y)
        {
            ourRect.y += 3;
        }
        
        if (ourRect.y > player.y)
        {
            ourRect.y -= 3;
        }
        
        if (ourRect.x < player.x)
        {
            ourRect.x += 3;
        }
        
        if (ourRect.x > player.x)
        {
            ourRect.x -= 3; 
        }
    }

}