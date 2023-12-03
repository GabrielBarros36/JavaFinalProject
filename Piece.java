//abstract piece class

public class Piece{

    //Current position of that piece in a board. (0,0) is the top left
    //corner where the White rook starts while (7,7) is the bottom right
    //corner where the Black rook starts
    int[] coordinates = new int[2];

    //Each entry is 0 if moving there is illegal, 1 if moving there is legal
    //Every Piece class is initialized with all moves being illegal
    int[][] legalMoves = new int[8][8];

    //True if the piece is White, false if the piece is Black
    boolean isWhite;

    //Initializes the piece at (0,0), as a White piece, with every move being illegal
    Piece(){

        isWhite = true;

        coordinates[0] = 0;
        coordinates[1] = 0;

        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                legalMoves[i][j] = 0;

    }

    //Arguments are (1 & 2) coordinates piece is initialized at and
    //(3) whether the piece is White or not
    Piece(int a, int b, boolean c){

        isWhite = c;

        coordinates[0] = a;
        coordinates[1] = b;

        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                legalMoves[i][j] = 0;
    }

    //Changes coordinates of piece.
    //Does *NOT* check if space is not occupied by friendly piece
    //Does *NOT* check if move is legal
    //Does *NOT* change array of legal moves
    public void setCoordinates(int a, int b){

        coordinates[0] = a;
        coordinates[1] = b;

    }

    //Returns 1 if move is legal, 0 otherwise
    public int isMoveLegal(int a, int b){

        return legalMoves[a][b];

    }

    //******** This is an important one ********
    //******** Will prob have to be changed often ********
    public void resetLegalMoves(){

    }

}