import java.awt.*;

public class VerticalEnemy extends Enemy
{
    private int screenHeight;
    private int ySpeed;
    private int tracker = 0;
    
    public VerticalEnemy(int x, int y, int w, int h, int sH, int yS) {
        super(x,y,w,h);
        screenHeight = sH;
        ySpeed = yS;
    }
    
    public Color getColor()
    {
        return Color.RED;
    }
    
    public void move()
    {
        Rectangle rect = getRectangle();
        
        if(rect.y < 0) {
            rect.y = 0;
            tracker++;
        }
        else if(rect.y + rect.height > screenHeight) {
            rect.y = screenHeight - rect.height;
            tracker++;
        }
        
        if (tracker % 2 == 0)
        {
            rect.y += ySpeed;
        }
        else if (tracker % 2 != 0)
        {
            rect.y -= ySpeed;
        }
    }
    
    public void changeSpeed(int speed)
    {
        ySpeed = speed;
    }
}