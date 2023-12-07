//Game class controls gameflow
/* 
So my idea for the game class would be two takeTurn functions
alternating between the black and white pieces. It could be 
pretty simple--just have it store a 2D array of pieces and whether
it is white or black's turn
*/




public class Game
{
   private Piece pieceArray[][];	//8x8 array of pieces
   

   //the Game constructor should initialize the board to 
   //have an array of pieces in normal chess order and 
   //set the turn to player 1 (white)
   public Game()
   {
	pieceArray = new Piece[8][8];
/*      the following code should populate the array
	with the starting chess setup. Just need to know
	how to initialize the pieces as white/black

	pieceArray[0][0] = new Rook(black);
	pieceArray[0][1] = new Knight(black);
	pieceArray[0][2] = new Bishop(black);
	pieceArray[0][3] = new Queen(black);
	pieceArray[0][4] = new King(black);
	pieceArray[0][5] = new Bishop(black);
	pieceArray[0][6] = new Knight(black);
	pieceArray[0][7] = new Rook(black);
	for (int j=0; j<8; j++)
	{
	  pieceArray[1][j] = new Pawn(black);
	  pieceArray[6][j] = new Pawn(white);
	}
	pieceArray[0][0] = new Rook(white);
	pieceArray[0][1] = new Knight(white);
	pieceArray[0][2] = new Bishop(white);
	pieceArray[0][3] = new Queen(white);
	pieceArray[0][4] = new King(white);
	pieceArray[0][5] = new Bishop(white);
	pieceArray[0][6] = new Knight(white);
	pieceArray[0][7] = new Rook(white);
*/	
   }

   public Piece[][] GetArray ()
   {

	return pieceArray;

   }


}