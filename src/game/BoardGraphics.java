package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.util.Random;

/**
Graphics for chess board
draws board rn not done
*/
public class BoardGraphics extends JPanel
{
   // Define the grid
   private boolean[][] grid = new boolean[100][100];
   
   // Define thread variable for animation
   private Thread anim = new Thread(new UpdateScreen());

   
   /**
   Constructor for our BoardGraphics class
   Sets up the screen correctly with all the variables
   and properties to consider
   */
   public BoardGraphics()
   {
      setSize(new Dimension(500, 500));
      setPreferredSize(new Dimension(500,500));
      setVisible(true);
      // Initialize the board
      // Start the animation
      // The animation updates the board and updates
      // the screen continually...
      anim.start();
   }
   
   // *********************************************************************************************
   // *********************************************************************************************
   // *********************************************************************************************
   
   /**
   Method should properly initialize the board with random true/false values
   Each row/col location in the grid array must be initialized properly!
   */
   /**
   Method should draw the grid to the screen 
   The grid should be colored appropriately depending
   on whether cells are alive or dead. Follow the rules!
   You must use nested loops to receive full credit on this method...
   @param g2
   @param grid a 2D array of boolean values
   */
   public void drawBoard(Graphics2D g2, boolean[][] grid)
   {
	  //Square[][] pieces = Board.getBoardState();
      boolean color = false;
      int y = 0;
      for (int i = 0; i < 8; i++)
      {
         int x = 0;
         for (int j = 0; j < 8; j++)
         {
        	// draw squares
            Rectangle2D.Double rect = new Rectangle2D.Double(x,y,100,100);
            g2.draw(rect);
            x += 100;
            if (color){
               g2.setColor(Color.BLACK);
               g2.fill(rect);
               color = false;
            }
            else {
               g2.setColor(Color.WHITE);
               g2.fill(rect);
               color = true;
            }
            
            //draw pieces
         }
         y += 100;
         color = !color;
      }
      
   }

   
   // *********************************************************************************************
   // *********************************************************************************************
   // *********************************************************************************************
   
   /**
   This method takes care of the animation portion of the simulation.
   All this method does is call repaint() in an infinite loop. Any
   call to repaint() in this file automatically runs paintComponent() again.
   */
   private class UpdateScreen implements Runnable
   {
      public void run()
      {
         while(true)
         {  
            System.out.println("RUNNING");
            try
            {
               Thread.sleep(60);
               // Repaint runs the paintComponent method exactly once
               repaint();
            }
            catch(Exception e)
            {
            
            }
         }
      }
   }
   
   /**
   This method renders objects on the screen. This is where
   you will make changes, declare variables, and draw different
   scenes. The comment inside the method explains how this works
   in the context of Java.
   */
   public void paintComponent(Graphics g)
   {
      // Clear the screen
      super.paintComponent(g);
      // Casting Operation
      // g2 -> representing some paintbrush
      Graphics2D g2 = (Graphics2D) g;
      g2.setBackground(Color.WHITE);
      // If you pass the Graphics2D variable g2 into your method as a parameter
      // You can use all the drawing methods inside your other method
      drawBoard(g2, grid);
   }
   
   /**
   Main Method
   Makes a new JFrame and adds the Canvas to it
   */
   public static void main(String[] args)
   {
      JFrame myFrame = new JFrame("My Frame");
      myFrame.setSize(new Dimension(800,800));
      myFrame.setPreferredSize(new Dimension(800,800));
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.add(new BoardGraphics());
      myFrame.pack();
      myFrame.setVisible(true);
   }

}