//board class (8x8)


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//Main program that creates the board
public class Board extends JFrame
{
   public static void main( String args[] )
   {
	BoardFrame boardFrame = new BoardFrame();
	boardFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	boardFrame.setSize(600, 600);
	boardFrame.setVisible(true);
   }


}


class BoardFrame extends JFrame
{
   private JPanel boardArea;
   private JLabel squares[][]; //array of squares
   private JPanel menu;
   private JLabel menuTitle;
   private JComboBox<String> saveDropdown;	//the save menu
   private JLabel playerTurn;
   private int clickCount = 0;
   private int x1;
   private int y1;
   private int x2;
   private int y2;
   private String moveCode;	//4 digit int that stores x and y of move
   private int turnNum = 1;
   private Piece pieceArray[][];	//will store the array of pieces

   public BoardFrame()
   {
	super("Chess");

	//create an 8x8 grid of JLabels 
	squares = new JLabel[8][8];
	boardArea = new JPanel();
	boardArea.setLayout(new GridLayout(8, 8));

	//fill an array with 5 games for toggling with the menu
	Game game1 = new Game();
	Game game2 = new Game();
	Game game3 = new Game();
	Game game4 = new Game();
	Game game5 = new Game();
	Game gameArr[] = {game1, game2, game3, game4, game5};

	for (int i=0; i < 8; i++)
	{
	   for (int j=0; j < 8; j++)
	   {
		pieceArray[i][j] = game1.GetArray()[i][j];
	   }
	}
	menu = new JPanel();
	menu.setLayout(new GridLayout(3,1));
	menu.setBackground(new Color(73,73,73));	
	add(menu, BorderLayout.EAST);
	menuTitle = new JLabel("Menu");

        String arr[] = {"Game 1","Game 2","Game 3",
                        "Game 4","Game 5"};
	saveDropdown = new JComboBox<String>(arr);
	saveDropdown.setBackground(new Color(73,73,73));

	saveDropdown.addItemListener(
	 new ItemListener() // anonymous inner class
         {
            // handle JComboBox event
            public void itemStateChanged( ItemEvent event )
            {
               // determine whether checkbox selected
               if ( event.getStateChange() == ItemEvent.SELECTED )
               {   
		  for (int i=0; i < 8; i++)
		  {
	  	    for (int j=0; j < 8; j++)
	  	    {
			pieceArray[i][j] = 			gameArr[saveDropdown.getSelectedIndex()].GetArray()[i][j];
	 	    }
		  }
			menuTitle.setText( arr[ 
                     saveDropdown.getSelectedIndex() ] );


	       }//end if loop
            } // end method itemStateChanged
         } // end anonymous inner class
      ); // end call to addItemListener
    
	menu.add(menuTitle);
        menu.add(saveDropdown);
	playerTurn = new JLabel("Player " + turnNum + "'s Turn");

	int count = 1;
	for (int i=0; i < 8; i++)
	{
	   for (int j=0; j < 8; j++)
	   {
		squares[i][j] = new JLabel();
		if (count % 2 == 0)
		    squares[i][j].setBackground(new Color(223,227,211));
		else
		    squares[i][j].setBackground(new Color(115,133,62));
		squares[i][j].setOpaque(true);
		squares[i][j].addMouseListener(new MouseClickHandler(i, j));
		boardArea.add(squares[i][j]);
		count++;
	   }
	   count ++;
	}

	add(boardArea, BorderLayout.CENTER);

	add(playerTurn, BorderLayout.SOUTH);
   }

private class MouseClickHandler extends MouseAdapter
{
   private int row;
   private int col;

   public MouseClickHandler(int i, int j)
   {
	row = i;
	col = j;
	
   }//end MouseClickHandler

   public void mouseClicked(MouseEvent event)
   {
	clickCount++;
	if (clickCount == 1)
	{
	    x1 = row;
	    y1 = col;
	}
	else
	{
	    x2 = row;
	    y2 = col;
	    clickCount = 0; 
	    moveCode = Integer.toString(x1) + Integer.toString(y1)
		     + Integer.toString(x2) + Integer.toString(y2);
	    if (turnNum == 1)
	    {
	       turnNum++;
	       playerTurn.setText("Player " + turnNum + "'s Turn");	
	    }
	    else
	    {
	       turnNum = 1;	       
	       playerTurn.setText("Player " + turnNum + "'s Turn");
	    }
	    System.out.println("Move Code: " + moveCode);
	}
   }//end mouseClicked

}//end mouseClickedHandler class


public String GetMoveCode()
{ return moveCode;}
}//end class BoardFrame















