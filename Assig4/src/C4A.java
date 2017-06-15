

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class C4A extends JApplet// implements KeyListener
{
		//Initial position of chip
		private int initr = 3;
		private int initc = -1;

		private ConnectFourModel cfm = new ConnectFourModel();
		private ConnectFourGUI gui = new ConnectFourGUI(cfm,initr,initc);


		//New game difficulty dialog box
		final JOptionPane newGame = new JOptionPane();
		Object[] options = {"EASY",
                    "INTERMEDIATE", "HARD"};
		//Difficulty (2 is easy, 4 is med, 6 is hard)
		private int diff = 0;
		private String showDiff = "";

    /**
     * Creates a new instance of <code>ConnectFour</code>.
     */
     	public C4A()
     	{
     		init();
     	}
   		public void init()
   		{
   			//Panel components at top
   			JButton left = new JButton("Move Left");
   			JButton down = new JButton("Move Down");
   			JButton right = new JButton("Move Right");

   			JPanel topPanel = new JPanel();
   			topPanel.setLayout(new FlowLayout());
   			topPanel.add(left);
   			topPanel.add(down);
   			topPanel.add(right);

   			//Panel components at bottom

			JButton reset = new JButton("Start new game");
			JButton newDiff = new JButton("Choose difficulty");
   			JPanel botPanel = new JPanel();
   			botPanel.setLayout(new FlowLayout());
			botPanel.add(reset);
			botPanel.add(newDiff);


   			//Listeners for each button
   			left.addActionListener(new leftListener());
   			right.addActionListener(new rightListener());
			down.addActionListener(new downListener());
			reset.addActionListener(new resetListener());
			newDiff.addActionListener(new newDiffListener());

			//Content panel containing top panel and game board
   			Container content = getContentPane();
   			content.setLayout(new BorderLayout());
   			content.add(topPanel, BorderLayout.NORTH);
   			content.add(gui, BorderLayout.CENTER);
   			content.add(botPanel, BorderLayout.SOUTH);
			topPanel.setFocusTraversalKeysEnabled(false);

			//Content keyListener
			topPanel.setFocusable(true);
			topPanel.addKeyListener(new keyPress());
			left.setFocusable(true);
			left.addKeyListener(new keyPress());
			down.setFocusable(true);
			down.addKeyListener(new keyPress());
			right.setFocusable(true);
			right.addKeyListener(new keyPress());
			reset.setFocusable(true);
			reset.addKeyListener(new keyPress());
			newDiff.setFocusable(true);
			newDiff.addKeyListener(new keyPress());


   			setContentPane(content);
   			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   			validate();
   			//setResizable(false);
    	}

		private void reset()
		{
				cfm.reset();
    			//If no difficulty has been set, choose difficulty.
    			if (diff==0)
    			{
    				chooseDiff();
    			}
    			//Sets difficulty to given one.
    			gui.setDiff(diff);
    			//Set displayed difficulty.
    			if (diff == 2)
    			{
    			showDiff = ("Current difficulty: EASY");
    			}
    			else if (diff == 4)
    			{
    			showDiff = ("Current difficulty: INTERMEDIATE");
    			}
    			else if (diff == 6)
    			{
    			showDiff = ("Current difficulty: HARD");
    			}
    			gui.repaint();
		}

    	class resetListener implements ActionListener
    	{
    		public void actionPerformed(ActionEvent ae)
    		{

				reset();
    		}
    	}

		class newDiffListener implements ActionListener
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			chooseDiff();
    		}
    	}

		//If Move Left button is clicked, the chip is moved left.
    	class leftListener implements ActionListener
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			//If no difficulty has been set, choose difficulty.
    			if (diff==0)
    			{
    				chooseDiff();
    				gui.setDiff(diff);
    			}
    			moveLeft();
    		}
    	}

    	private void moveLeft()
    	{
    		int col = gui.chipCol();
    			if (col <= 6 && col >0)
    			{
    				gui.setCol(col-1);
    				gui.repaint();
    			}
    	}

		private void moveRight()
    	{
    			int col = gui.chipCol();
    			if (col < 6 && col >=0)
    			{
    				gui.setCol(col+1);
    				gui.repaint();
    			}
    	}

    	private void moveDown()
    	{
    		int col = gui.chipCol();
    			int dropRow = cfm.drop(col);
    			if (dropRow != -1)
    			{
    				gui.setCol(col);
    				gui.repaint();
    			}
    	}

    	//Select difficulty method.
    	private void chooseDiff()
    	{
    		//If diff == 0 (no games have been played), then do not show message dialogs.
    		if (diff == 0)
    		{
    			int i = newGame.showOptionDialog(null,
 						   showDiff,
  						   "Select difficulty",
 							   JOptionPane.YES_NO_OPTION,
  							  JOptionPane.QUESTION_MESSAGE,
   							 null,     //do not use a custom Icon
   							 options,  //the titles of buttons
   							 options[0]); //default button title
   				if (i == 0)
    			{
    			diff = 2;
    			showDiff = ("Current difficulty: EASY");
    			}
    			else if (i == 1)
    			{
    			diff = 4;
    			showDiff = ("Current difficulty: INTERMEDIATE");
    			}
    			else if (i == 2)
    			{
    			diff = 6;
    			showDiff = ("Current difficulty: HARD");
    			}
    			//Make sure a difficulty is chosen.
    			else if (showDiff=="")
    			{newGame.showMessageDialog(null,
 						   "Please try again.",
  						   "Error",JOptionPane.WARNING_MESSAGE);
    			chooseDiff();
    			}
    		}

			// If diff is already established, show message dialogs.
    		else
    		{

    		int i = newGame.showOptionDialog(null,
 						   showDiff,
  						   "Select difficulty",
 							   JOptionPane.YES_NO_OPTION,
  							  JOptionPane.QUESTION_MESSAGE,
   							 null,     //do not use a custom Icon
   							 options,  //the titles of buttons
   							 options[0]); //default button title
    		if (i == 0)
    		{
    			diff = 2;
    			newGame.showMessageDialog(null,
 						   "Difficulty will be changed to EASY upon new game.",
  						   "EASY",JOptionPane.WARNING_MESSAGE);
    		}
    		else if (i == 1)
    		{
    			diff = 4;
    			newGame.showMessageDialog(null,
 						   "Difficulty will be changed to INTERMEDIATE upon new game.",
  						   "INTERMEDIATE",JOptionPane.WARNING_MESSAGE);
    		}
    		else if (i == 2)
    		{
    			diff = 6;
    			newGame.showMessageDialog(null,
 						   "Difficulty will be changed to HARD upon new game.",
  						   "HARD",JOptionPane.WARNING_MESSAGE);
    		}
    		}
    	}

		//If Move Right button is clicked, the chip is moved right.
    	class rightListener implements ActionListener
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			//If no difficulty has been set, choose difficulty.
    			if (diff==0)
    			{
    				chooseDiff();
    				gui.setDiff(diff);
    			}

    			moveRight();
    		}
    	}

    	//If Move Down button is clicked, the chip is moved down to the lowest row.
    	// The computer acts as well.
    	class downListener implements ActionListener
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			//If no difficulty has been set, choose difficulty.
    			if (diff==0)
    			{
    				chooseDiff();
    				gui.setDiff(diff);
    			}
    			moveDown();
    		}
    	}

		class keyPress implements KeyListener
    	{
    		//If left, down or right is pressed, blackraw board.
    		public void keyPressed(KeyEvent e)
    		{
    			int keyCode = e.getKeyCode();
    			System.out.println(keyCode);
    			//Choose diff if no diff is set.
    			if (diff==0)
    			{
    				chooseDiff();
    				gui.setDiff(diff);
    			}
    			// if left is pressed:
    			if (keyCode == 37)
    			{


    			moveLeft();

    			}
    			// if down is pressed:
    			if (keyCode == 40)
    			{
    				moveDown();
    			}
    			// if right is pressed:
    			if (keyCode == 39)
    			{
    				moveRight();
    			}
    			if (keyCode == 10)
    			{
    				reset();
    			}
    		}
    		//Override methods
    		public void keyTyped(KeyEvent e)
    		{
    		}
    		public void keyReleased(KeyEvent e)
    		{
    		}
    	}
}