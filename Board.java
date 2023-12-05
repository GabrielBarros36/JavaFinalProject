//board class (8x8)


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
   private JComboBox<String> saveDropdown;
   private JComboBox<String> loadDropdown;
   private JLabel playerTurn;
   private int clickCount = 0;
   private int x1;
   private int y1;
   private int x2;
   private int y2;
   private int moveCode;
   private int turnNum = 1;

   public BoardFrame()
   {
	super("Chess");
	squares = new JLabel[8][8];
	boardArea = new JPanel();
	boardArea.setLayout(new GridLayout(8, 8));

	menu = new JPanel();
	menu.setLayout(new GridLayout(3,1));
	menu.setBackground(new Color(110,64,51));	
	add(menu, BorderLayout.EAST);
	menuTitle = new JLabel("Menu");

        String arr[] = {"Game 1","Game 2","Game 3",
                        "Game 4","Game 5"};
	saveDropdown = new JComboBox<String>(arr);
	saveDropdown.setBackground(new Color(110,64,51));

	loadDropdown = new JComboBox<String>(arr);
	loadDropdown.setBackground(new Color(110,64,51));


    
	menu.add(menuTitle);
        menu.add(saveDropdown);
        menu.add(loadDropdown);
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
		squares[i][j].addMouseListener(new 				                     MouseClickHandler(i, j));
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
	    moveCode = 1000*x1 + 100*y1 + 10*x2 + y2;
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
	}
   }//end mouseClicked

}//end mouseClickedHandler class



}//end class BoardFrame















