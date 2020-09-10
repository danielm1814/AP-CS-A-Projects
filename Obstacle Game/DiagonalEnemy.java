import java.awt.*;

public class DiagonalEnemy extends VerticalEnemy
{
    private int xSpeed;
    private int screenWidth;
    private int tracker = 0;
    
    public DiagonalEnemy(int x, int y, int w, int h, int sH, int yS, int sW, int xS) {
        super(x,y,w,h,sH,yS);
        xSpeed = xS;
        screenWidth = sW;
    }
    
    public Color getColor()
    {
        return Color.YELLOW;
    }
    
    public void move()
    {
        super.move();
        
        Rectangle rect = getRectangle();
        if(rect.x < 0) {
            rect.x = 0;
            tracker++;
        }
        else if(rect.x + rect.width > screenWidth) {
            rect.x = screenWidth - rect.width;
            tracker++;
        }
        
        if (tracker % 2 == 0)
        {
            rect.x -= xSpeed;
        }
        else if (tracker % 2 != 0)
        {
            rect.x += xSpeed;
        }
    }
}