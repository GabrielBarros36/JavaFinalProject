public class Queen extends Piece{

    public Queen(int a, int b, boolean c) {
        super(a, b, c);
    }

    boolean isEmpty() {
        return false;
    }

    public void refreshLegalMoves(Piece[][] board) {

        resetLegalMoves();

        //********** CHECKING DIAGONALS **********

        //Checks path up and to the right
        for (int x = coordinates[0] + 1, y = coordinates[1] - 1; x < 8 && y > 0; x++, y--) {
            if (board[x][y].isEmpty())
                legalMoves[x][y] = 1;
            else if (board[x][y].isWhite != isWhite) {
                legalMoves[x][y] = 1;
                break;
            }
            else
                break;

        }

        //Checks path up and to the left
        for (int x = coordinates[0] - 1, y = coordinates[1] - 1; x > 0 && y > 0; x--, y--) {
            if (board[x][y].isEmpty())
                legalMoves[x][y] = 1;
            else if (board[x][y].isWhite != isWhite) {
                legalMoves[x][y] = 1;
                break;
            }
            else
                break;

        }

        //Checks path down and to the right
        for (int x = coordinates[0] + 1, y = coordinates[1] + 1; x < 8 && y < 8; x++, y++) {
            if (board[x][y].isEmpty())
                legalMoves[x][y] = 1;
            else if (board[x][y].isWhite != isWhite) {
                legalMoves[x][y] = 1;
                break;
            }
            else
                break;

        }

        //Checks path down and to the left
        for (int x = coordinates[0] - 1, y = coordinates[1] + 1; x > 0 && y < 8; x--, y++) {
            if (board[x][y].isEmpty())
                legalMoves[x][y] = 1;
            else if (board[x][y].isWhite != isWhite) {
                legalMoves[x][y] = 1;
                break;
            }
            else
                break;

        }

        //********** CHECKING UP AND DOWN **********
        //Checks path above the queen
        for(int north = coordinates[1]-1; north > 0; north--){

            //If space is empty or contains an enemy piece
            if(board[ coordinates[0] ][north].isEmpty() )
                legalMoves[ coordinates[0] ][north] = 1;
            else if(board[ coordinates[0] ][north].isWhite != isWhite){
                legalMoves[ coordinates[0] ][north] = 1;
                break;
            }
            else
                break;
        }

        //Checks path below the queen
        for(int south = coordinates[1]+1; south < 8; south++){

            //If space is empty or contains an enemy piece
            if(board[ coordinates[0] ][south].isEmpty() )
                legalMoves[ coordinates[0] ][south] = 1;
            else if(board[ coordinates[0] ][south].isWhite != isWhite){
                legalMoves[ coordinates[0] ][south] = 1;
                break;
            }
            else
                break;

        }

        //Checks path to the left of the queen
        for(int west = coordinates[0]-1; west > 0; west--){

            //If space is empty or contains an enemy piece
            if(board[ west ][coordinates[1]].isEmpty() )
                legalMoves[ west ][coordinates[1]] = 1;
            else if(board[west][ coordinates[1] ].isWhite != isWhite){
                legalMoves[ west ][coordinates[1]] = 1;
                break;
            }
            else
                break;

        }

        //Checks path to the right of the queen
        for(int east = coordinates[0]+1; east < 8; east++){

            //If space is empty or contains an enemy piece
            if(board[ east ][coordinates[1]].isEmpty() )
                legalMoves[ east ][coordinates[1]] = 1;
            else if(board[east][ coordinates[1] ].isWhite != isWhite){
                legalMoves[ east ][coordinates[1]] = 1;
                break;
            }
            else
                break;

        }

    }

    public char getType(){
        return 'Q';
    }

}
