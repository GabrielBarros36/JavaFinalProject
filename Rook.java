public class Rook extends Piece{

    public Rook(int a, int b, boolean c){
        super(a, b, c);
    }

    //Is passed the "pieceArray" in the Game class
    //Makes all moves illegal, then scans the board for legal moves
    public void refreshLegalMoves(Piece[][] board){

        resetLegalMoves();

        //Checks path above the rook
        for(int north = coordinates[1]-1; north > 0; north--){

            //If space is empty or contains an enemy piece
            if(board[ coordinates[0] ][north].isEmpty() || board[ coordinates[0] ][north].isWhite != isWhite)
                legalMoves[ coordinates[0] ][north] = 1;
            else
                break;
        }

        //Checks path below the rook
        for(int south = coordinates[1]+1; south < 8; south++){

            //If space is empty or contains an enemy piece
            if(board[ coordinates[0] ][south].isEmpty() || board[ coordinates[0] ][south].isWhite != isWhite)
                legalMoves[ coordinates[0] ][south] = 1;
            else
                break;

        }

        //Checks path to the left of the rook
        for(int west = coordinates[0]-1; west > 0; west--){

            //If space is empty or contains an enemy piece
            if(board[ west ][coordinates[1]].isEmpty() || board[west][ coordinates[1] ].isWhite != isWhite)
                legalMoves[ west ][coordinates[1]] = 1;
            else
                break;

        }

        //Checks path to the right of the rook
        for(int east = coordinates[0]+1; east < 8; east++){

            //If space is empty or contains an enemy piece
            if(board[ east ][coordinates[1]].isEmpty() || board[east][ coordinates[1] ].isWhite != isWhite)
                legalMoves[ east ][coordinates[1]] = 1;
            else
                break;

        }

    }

    boolean isEmpty(){
        return false;
    }


}
