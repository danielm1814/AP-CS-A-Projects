import java.awt.*;
import java.util.*;

public class SandLab
{
  public static void main(String[] args)
  {
    SandLab lab = new SandLab(120, 80);
    lab.run();
  }
  
  //add constants for particle types here
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int CLEAR = 3;
  public static final int WATER = 4;
  
  //do not add any more fields
  private int[][] grid;
  private SandDisplay display;
  
  public SandLab(int numRows, int numCols)
  {
    String[] names;
    names = new String[5];
    names[EMPTY] = "Empty";
    names[METAL] = "Metal";
    names[SAND] = "Sand";
    names[CLEAR] = "Clear";
    names[WATER] = "Water";
    display = new SandDisplay("Falling Sand", numRows, numCols, names);
    grid = new int[numRows][numCols];
  }
  
  //called when the user clicks on a location using the given tool
  private void locationClicked(int row, int col, int tool)
  {
      if (grid[row][col] == EMPTY)    
      {
      grid[row][col] = tool;
    }
      else if (tool == EMPTY)
      {
          grid[row][col] = tool;
        }
      else if (tool == CLEAR) //Used to Clear the screen
        {
           for (int i = 0; i < grid.length; i++)
           {
               for (int k = 0; k < grid[i].length; k++)
               {
                   grid[i][k] = EMPTY;
                }
            }
        }
    
  }

  //copies each element of grid into the display
  public void updateDisplay()
  {
      for (int i = 0; i < grid.length; i++)
      {
          for (int t = 0; t < grid[i].length;t++)
          {
              if (grid[i][t] == EMPTY)
              {
                  display.setColor(i,t,new Color(0,0,0));
                }
              else if (grid[i][t] == METAL)
              {
                  display.setColor(i,t,new Color(102,87,87));
                }
              else if (grid[i][t] == SAND)
              {
                  display.setColor(i,t,new Color(222,197,87));
                }
              else if (grid[i][t] == WATER)
              {
                  display.setColor(i,t,new Color(48,82,255));
                }
                }
            }
        }
  

  //called repeatedly.
  //causes one random particle to maybe do something.
  public void step()
  {
       int rR = (int)(Math.random()*grid.length);
       int rC = (int)(Math.random()*grid[0].length);
       
       if (grid[rR][rC] == SAND)
       {
           if (rR + 1 < grid.length)
           {
               if (grid[rR+1][rC] == EMPTY)
               {
                   grid[rR+1][rC] = SAND;
                   grid[rR][rC] = EMPTY;
                }
                else if (grid[rR+1][rC] == WATER)
               {
                   grid[rR+1][rC] = SAND;
                   grid[rR][rC] = WATER;
                }
            }
        }
        int direct = (int)(Math.random()*3);
        
        if (grid[rR][rC] == WATER)
       {
           if (direct == 0)
           {
           if (rR + 1 < grid.length)
           {
               if (grid[rR+1][rC] == EMPTY)
               {
                   grid[rR+1][rC] = WATER;
                   grid[rR][rC] = EMPTY;
                }
            }
        }  
            if (direct == 1)
            {
            if (rC + 1 < grid[0].length)
               {
                   if (grid[rR][rC + 1] == EMPTY)
                   {
                   grid[rR][rC + 1] = WATER;
                   grid[rR][rC] = EMPTY;
                }
                }
            }  
            if (direct == 2) 
            {
            if (rC - 1 >= 0)
                {
                    if (grid[rR][rC - 1] == EMPTY)
                   {
                    grid[rR][rC - 1] = WATER;
                   grid[rR][rC] = EMPTY;
                }
                
            }
        }
        }
       
  }
  
  //do not modify
  public void run()
  {
    while (true)
    {
      for (int i = 0; i < display.getSpeed(); i++)
        step();
      updateDisplay();
      display.repaint();
      display.pause(1);  //wait for redrawing and for mouse
      int[] mouseLoc = display.getMouseLocation();
      if (mouseLoc != null)  //test if mouse clicked
        locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
    }
  }
}
