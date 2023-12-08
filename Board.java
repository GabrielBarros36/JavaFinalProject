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
   private JPanel southBorder;
   private int clickCount = 0;
   private int x1;
   private int y1;
   private int x2;
   private int y2;
   private String moveCode;	//4 digit int that stores x and y of move
   private int turnNum = 1;
   private Piece pieceArray[][];	//will store the array of pieces
   private boolean whitesTurn;
   private Game gameArr[] = new Game[5];
   private Game currentGame;


//THIS IS THE BOARDFRAME CONSTRUCTOR. IT HAS A LOT OF STUFF IN IT. OH WELL.

   public BoardFrame()
   {
	super("Chess");

	//create an 8x8 grid of JLabels 
	squares = new JLabel[8][8];
	boardArea = new JPanel();
	boardArea.setLayout(new GridLayout(8, 8));

	whitesTurn = true;
	pieceArray = new Piece[8][8];
	//fill an array with 5 games for toggling with the menu
	Game game1 = new Game();
	Game game2 = new Game();
	Game game3 = new Game();
	Game game4 = new Game();
	Game game5 = new Game();
	gameArr[0] = game1;
	gameArr[1] = game2;
	gameArr[2] = game3;
	gameArr[3] = game4;
	gameArr[4] = game5;
	currentGame = game1;
	for (int i=0; i < 8; i++)
	{
	   for (int j=0; j < 8; j++)
	   {
		pieceArray[i][j] = game1.GetArray()[i][j];
	   }
	}


	addComponentListener(new ComponentAdapter() {
	public void componentResized(ComponentEvent e){
	setBoard();}
	});


	menu = new JPanel();
	menu.setLayout(new GridLayout(3,1));
	menu.setBackground(new Color(110,110,110));	
	add(menu, BorderLayout.EAST);
	playerTurn = new JLabel();
	southBorder = new JPanel();
	southBorder.setBackground(new Color(110,110,110));
	add(southBorder, BorderLayout.SOUTH);	
	southBorder.add(playerTurn);
	
	menuTitle = new JLabel("Saved Games");

        String arr[] = {"Game 1","Game 2","Game 3",
                        "Game 4","Game 5"};
	saveDropdown = new JComboBox<String>(arr);
	saveDropdown.setBackground(new Color(110,110,110));


//THIS IS THE PART WHERE WE DEAL WITH THE SAVEGAME DROPDOWN

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
			
			pieceArray[i][j] = gameArr[saveDropdown.getSelectedIndex()].GetArray()[i][j];
	 	    }
		  }
		     currentGame.SetTurn(whitesTurn);
		     currentGame = gameArr[saveDropdown.getSelectedIndex()]; 
		     whitesTurn = currentGame.GetTurn();
		     setBoard();

	       }//end if loop
            } // end method itemStateChanged
         } // end anonymous inner class
      ); // end call to addItemListener
    
	menu.add(menuTitle);
        menu.add(saveDropdown);


//THIS IS PAINTING THE SQUARES BLACK AND WHITE

	int count = 0;
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
	setBoard();
	add(boardArea, BorderLayout.CENTER);




   }



//THIS IS A CLASS TO HANDLE WHEN WE CLICK BOXES. IT RETURNS A STRING WITH THE MOVE CODE

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

	    Move();
	}
   }//end mouseClicked

}//end mouseClickedHandler class



//THIS IS A GETTER CLASS TO RETURN THE MOVE CODE

public String GetMoveCode()
{ return moveCode;}





//THIS IS A HELPER FUNCTION TO SET THE BOARD TO HOW IT SHOULD BE

public void setBoard()
{
   int w = squares[0][0].getWidth() - 5;
   int h = squares[0][0].getHeight() -5;

   for (int i=0; i<8; i++)
   {
	for (int j=0; j<8; j++)
	{
	   if (pieceArray[i][j] instanceof Queen)
	   {	
		if (pieceArray[i][j].getColor() == true)
		   squares[i][j].setIcon(resizeIcon(new ImageIcon(getClass().getResource("Queen_White.gif")), w, h));
		else
		   squares[i][j].setIcon(resizeIcon(new ImageIcon(getClass().getResource("Queen_Black.gif")), w, h));	   }
	   else if (pieceArray[i][j] instanceof King)
	   {	
		if (pieceArray[i][j].getColor() == true)
		   squares[i][j].setIcon(resizeIcon(new ImageIcon(getClass().getResource("King_White.gif")), w, h));			   	else
		   squares[i][j].setIcon(resizeIcon(new ImageIcon(getClass().getResource("King_Black.gif")), w, h));	   
	   }
	   else if (pieceArray[i][j] instanceof Bishop)
	   {	
		if (pieceArray[i][j].getColor() == true)
		   squares[i][j].setIcon(resizeIcon(new ImageIcon(getClass().getResource("Bishop_White.gif")), w, h));	
	   	else
		   squares[i][j].setIcon(resizeIcon(new ImageIcon(getClass().getResource("Bishop_Black.gif")), w, h));	  
	   }
	   else if (pieceArray[i][j] instanceof Knight)
	   {	
		if (pieceArray[i][j].getColor() == true)
		   squares[i][j].setIcon(resizeIcon(new ImageIcon(getClass().getResource("Knight_White.gif")), w, h));				else
		   squares[i][j].setIcon(resizeIcon(new ImageIcon(getClass().getResource("Knight_Black.gif")), w, h));
	   }
	   else if (pieceArray[i][j] instanceof Rook)
	   {	
		if (pieceArray[i][j].getColor() == true)
		   squares[i][j].setIcon(resizeIcon(new ImageIcon(getClass().getResource("Rook_White.gif")), w, h));				else
		   squares[i][j].setIcon(resizeIcon(new ImageIcon(getClass().getResource("Rook_Black.gif")), w, h));
	   }
	   else if (pieceArray[i][j] instanceof Pawn)
	   {	
		if (pieceArray[i][j].getColor() == true)
		   squares[i][j].setIcon(resizeIcon(new ImageIcon(getClass().getResource("Pawn_White.gif")), w, h));				else
		   squares[i][j].setIcon(resizeIcon(new ImageIcon(getClass().getResource("Pawn_Black.gif")), w, h));
	   }
	   else
	   {
		squares[i][j].setIcon(null);
	   }
	   
	//now reset the game array appropriately
	for (int n=0; n<8; n++)
	   for (int m=0; m<8; m++)
	      currentGame.SetArray(m,n,pieceArray[m][n]);

	if (currentGame.GetTurn() == true)
	   playerTurn.setText("White's Turn");
	else
	   playerTurn.setText("Black's Turn");
	

	}
   }


}




//THIS IS A HELPER FUNCTION TO MOVE THE PIECES. IT DOESNT WORK VERY WELL YET

 public void Move()
   {
	int x1 = Character.getNumericValue(moveCode.charAt(0));
	int y1 = Character.getNumericValue(moveCode.charAt(1));
	int x2 = Character.getNumericValue(moveCode.charAt(2));
	int y2 = Character.getNumericValue(moveCode.charAt(3));
	
	if (pieceArray[x1][y1].isEmpty() == false && pieceArray[x1][y1].getColor() == whitesTurn)
	{

	//    pieceArray[x1][y1].refreshLegalMoves();
	//    if (pieceArray[x1][y1].getLegalMoves(x2,y2) == 1)
	//    {	
		//System.out.println("Running\n");
		pieceArray[x2][y2] = pieceArray[x1][y1];
		pieceArray[x1][y1] = new Piece();
		whitesTurn = !whitesTurn;
		currentGame.SetTurn(!currentGame.GetTurn());
		setBoard();
	//    }

	}




   }


    private static ImageIcon resizeIcon(ImageIcon icon, int width, int height) 
    {
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

}//end class BoardFrame










