//board class (8x8)


import javax.swing.*;
import java.awt.*;

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
   private JMenu saveDropdown;
   private JMenu loadDropdown;
   private JLabel playerTurn;


   public BoardFrame()
   {
	super("Chess");
	squares = new JLabel[8][8];
	boardArea = new JPanel();
	boardArea.setLayout(new GridLayout(8, 8));

	menu = new JPanel();
	menu.setLayout(new GridLayout(3,1));
	menuTitle = new JLabel("Menu");
	saveDropdown = new JMenu("Save");
	loadDropdown = new JMenu("Load");
        for (int i = 1; i < 6; i++)
        {
	   String index = Integer.toString(i);
	   JMenuItem gameIndex = new JMenuItem(index);
	   saveDropdown.add(gameIndex);
	   loadDropdown.add(gameIndex);
        }
	menu.add(menuTitle);
        menu.add(saveDropdown);
        menu.add(loadDropdown);
	playerTurn = new JLabel("Player 1's Turn");

	int count = 1;
	for (int i=0; i < 8; i++)
	{
	   for (int j=0; j < 8; j++)
	   {
		squares[i][j] = new JLabel();
		if (count % 2 == 0)
		    squares[i][j].setBackground(Color.BLACK);
		else
		    squares[i][j].setBackground(Color.WHITE);
		squares[i][j].setOpaque(true);
		boardArea.add(squares[i][j]);
		count++;
	   }
	   count ++;
	}

	add(boardArea, BorderLayout.CENTER);
	add(menu, BorderLayout.EAST);
	add(playerTurn, BorderLayout.SOUTH);
   }


}













