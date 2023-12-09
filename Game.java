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
   private boolean whitesTurn;

   int[] whiteKingPos;
   int[] blackKingPos;
   boolean whiteKingChecked;
   boolean blackKingChecked;

   //the Game constructor should initialize the board to 
   //have an array of pieces in normal chess order and 
   //set the turn to player 1 (white)
   public Game()
   {
	pieceArray = new Piece[8][8];
	whitesTurn = true;

	whiteKingPos = new int[2];
	blackKingPos = new int[2];

/*      the following code should populate the array
	with the starting chess setup. Just need to know
	how to initialize the pieces as white/black */

	pieceArray[0][0] = new Rook(0,0,false);
	pieceArray[0][1] = new Knight(0,1,false);
	pieceArray[0][2] = new Bishop(0,2,false);
	pieceArray[0][3] = new Queen(0,3,false);
	pieceArray[0][4] = new King(0,4,false);
	blackKingPos[0] = 0;
	blackKingPos[1] = 4;
	blackKingChecked = false;
	pieceArray[0][5] = new Bishop(0,5,false);
	pieceArray[0][6] = new Knight(0,6,false);
	pieceArray[0][7] = new Rook(0,7,false);
	for (int j=0; j<8; j++)
	{
	  pieceArray[1][j] = new Pawn(1,j,false);
	  pieceArray[6][j] = new Pawn(6,j,true);
	  for (int i=2; i<6; i++)
	  {
		pieceArray[i][j] = new Piece();
	  }
	}
	pieceArray[7][0] = new Rook(7,0,true);
	pieceArray[7][1] = new Knight(7,1,true);
	pieceArray[7][2] = new Bishop(7,2,true);
	pieceArray[7][3] = new Queen(7,3,true);
	pieceArray[7][4] = new King(7,4,true);
	whiteKingPos[0] = 7;
	whiteKingPos[1] = 4;
	whiteKingChecked = false;
	pieceArray[7][5] = new Bishop(7,5,true);
	pieceArray[7][6] = new Knight(7,6,true);
	pieceArray[7][7] = new Rook(7,7,true);


	//Generates legal move array for every piece
	   for(int x = 0; x < 8; x++)
		   for(int y = 0; y < 8; y++)
			   pieceArray[x][y].refreshLegalMoves(pieceArray);

	/*Populate middle of the board with Piece() objects - that is, empty spots*/
	//for(int y = 2; y < 5; y++)
	//	for(int x = 0; x < 7; x++)
	//		pieceArray[y][x] = new Piece(y,x,false);


   }

  
   public Piece[][] GetArray ()
   { return pieceArray; }

   public void SetArray(int i, int j, Piece p)
   {  pieceArray[i][j] = p; }

   public void SetTurn(boolean w)
   {  whitesTurn = w; }

   public boolean GetTurn()
   {  return whitesTurn; }

}