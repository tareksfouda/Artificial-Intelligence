/**
 * ConnectFourGUI.java
 *
 * Draws the Connect Four board using Connect Four Model
 *
 */

import java.awt.*;
import javax.swing.JComponent;

public class ConnectFourGUI extends JComponent
{
	private static final int cellPxl = 50;
	private static final int numCol = 7;
	private static final int numRow = 6;
	private int colChip;
	private int rowChip;
	private int diff;

	private ConnectFourModel model;

	public ConnectFourGUI(ConnectFourModel cfm,int col, int row)
	{
		setPreferredSize(new Dimension(cellPxl*7+10,cellPxl*7+10));
		setBackground(Color.white);
		model = cfm;
		colChip = col;
		rowChip = row;
		diff = 4;

	}

	public void paintComponent(Graphics g)
	{
		g.setColor(getBackground());
		g.fillRect(0,0,cellPxl*numCol+10,cellPxl*(numRow+1)+10);
		drawBoard(g);
		drawChip(g,colChip,rowChip);

	}

	// Draw a chip blackor blue depending on who is playing.
	public void drawChip(Graphics g, int col, int row)
	{

		int x = cellPxl;
		int y = cellPxl;

		//Check for player win.
		if (model.win())
		{
			if(model.getPlayer()==2)
			{
				g.drawString("You Win! Click 'Start new game'  to play again!",25,25);
			}
			else
			{
				g.drawString("You Lose! Click 'Start new game' to play again!",25,25);
			}
			//Draws the new chip in a not visible area.
			col = -5;

		}
		//Check if draw.
		if (model.full())
		{
			g.drawString("Draw! Click 'Start new game' to play again!",25,25);
			col = -5;
		}

		//If player's turn, draws a chip to be dropped in.
		if (model.getPlayer()==1)
		{
			g.setColor(Color.red);
			g.fillOval(5+x*col,y+y*row,cellPxl,cellPxl);
		}
		//If computer's turn, fills in computer's chip in the model
		// and draws player's chip to be dropped in if computer has not won.
		else
		{
		/*	//Computer generates random number;
			rand comp = new rand();
			int c = comp.random();
			int a = model.drop(c);
			g.setColor(Color.red);
			g.fillOval(5+x*col,y+y*row,cellPxl,cellPxl);*/

			//Computer generates Minimax value;
			Minimax comp = new Minimax(model.getGrid(),diff);
			int c = comp.calcValue();
			int a = model.drop(c);

			//Check for computer win.
			if (model.win())
			{
				if(model.getPlayer()==1)
				{
					g.drawString("You Lose! Click 'Start new game' to play again!",25,25);
				}
				//Draws the new chip in a not visible area.
				col = -5;
			}
			else
			{
			g.setColor(Color.red);
			g.fillOval(5+x*col,y+y*row,cellPxl,cellPxl);
			}
		}


		//Draws the chips already filled in.
		for (int r =5; r>=0; r--)
    	{
    		for (int c=0; c<7; c++)
    		{
    			if (model.getBoardSlot(c,r) == 1)
    			{
    				g.setColor(Color.red);
					g.fillOval(5+x*c,y+y*r,cellPxl,cellPxl);
    			}
    			else if (model.getBoardSlot(c,r) == 2)
    			{
    				g.setColor(Color.blue);
					g.fillOval(5+x*c,y+y*r,cellPxl,cellPxl);
    			}
    		}
    	}

	}

	// Set difficulty.
	public void setDiff(int d)
	{
		diff = d;
	}

	//Set the current column position of the chip.
	public void setCol(int col)
	{
		colChip = col;
	}

	//Returns the current column position of the chip.
	public int chipCol()
	{
		return colChip;
	}

	public void drawBoard(Graphics g)
	{
		int x = cellPxl;
		int y = cellPxl;
		int r,c;
		//Draw a 7*6 grid
		g.setColor(Color.blue);
		g.drawRect(5,y,x*7,y*6);

		for (r=0;r<6;r++)
		{
			g.drawLine(5,y+y*r,x*7+5,y+y*r);
		}
		for (c=0;c<7;c++)
		{
			g.drawLine(x+5+x*c,y,x+5+x*c,y*7);
		}

	}


}