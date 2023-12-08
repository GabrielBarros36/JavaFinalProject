public class Pawn extends Piece{

    boolean moved;
    public Pawn(int a, int b, boolean c) {
        super(a, b, c);
        moved = false;
    }

    boolean isEmpty() {
        return false;
    }

    public void hasMoved(boolean a){
        moved = a;
    }

    public void refreshLegalMoves(Piece[][] board) {

        resetLegalMoves();

        int x = coordinates[0];
        int y = coordinates[1];

        System.out.println("Pawn coordinates are: " + x + " " + y);

        if(isWhite){

            //Detects if there's a piece in the left diagonal
            if(y > 0)
                if( !board[coordinates[0] - 1][y-1].isEmpty() &&  board[coordinates[0] - 1][y-1].isWhite != isWhite)
                    legalMoves[coordinates[0] - 1][y-1] = 1;

            //Detects if there's a piece in the right diagonal
            if(y < 7)
                if( !board[coordinates[0] - 1][y+1].isEmpty() &&  board[coordinates[0] - 1][y+1].isWhite != isWhite)
                    legalMoves[coordinates[0] - 1][y+1] = 1;

            //Detects if white pawn has moved or not
            if(x == 6)
            {
                legalMoves[5][y] = 1;
                legalMoves[4][y] = 1;

            }
            else
                legalMoves[coordinates[0] - 1 ][y] = 1;

        }
        else{


            //Detects if there's a piece in the left diagonal
            if(y > 0)
                if( !board[coordinates[0] + 1][y-1].isEmpty() &&  board[coordinates[0] + 1][y-1].isWhite != isWhite)
                    legalMoves[coordinates[0] + 1][y-1] = 1;

            //Detects if there's a piece in the right diagonal
            if(y < 7)
                if( !board[coordinates[0] + 1][y+1].isEmpty() &&  board[coordinates[0] + 1][y+1].isWhite != isWhite)
                    legalMoves[coordinates[0] + 1][y+1] = 1;


            //Detects if black pawn has moved or not
            if(x == 1){

                legalMoves[2][y] = 1;
                legalMoves[3][y] = 1;

            }
            else
                legalMoves[coordinates[0] + 1 ][y] = 1;

        }

        //Old implementation
        /*
        //If pawn is white
        if(isWhite){

            //If square 1 spot ahead is free
            if(y > 0)
            if(board[x][y-1].isEmpty()){
                legalMoves[x][y-1] = 1;

                //If square 2 spots ahead is also free
                if(board[x][y-2].isEmpty())
                    legalMoves[x][y-2] = 1;

            }

            //If there's a piece to be captured in the left diagonal
            if(x > 0 && y > 0 && !board[x-1][y-1].isEmpty() && board[x-1][y-1].isWhite != isWhite)
                legalMoves[x-1][y-1] = 1;

            //If there's a piece to be captured in the right diagonal
            if(x < 7 && y > 0 && !board[x+1][y-1].isEmpty() && board[x+1][y-1].isWhite != isWhite)
                legalMoves[x+1][y-1] = 1;

        }
        //If pawn is black
        else{

            //If square 1 spot ahead is free
            if(y < 7)
            if(board[x][y+1].isEmpty()){
                legalMoves[x][y+1] = 1;

                //If square 2 spots ahead is also free
                if(board[x][y+2].isEmpty())
                    legalMoves[x][y+2] = 1;

            }

            //If there's a piece to be captured in the left diagonal
            if(y < 7)
            if(x > 0 && y > 0 && !board[x-1][y+1].isEmpty() && board[x-1][y+1].isWhite != isWhite)
                legalMoves[x-1][y+1] = 1;

            //If there's a piece to be captured in the right diagonal
            if(y < 7 && x < 7)
            if(x < 7 && y > 0 && !board[x+1][y+1].isEmpty() && board[x+1][y+1].isWhite != isWhite)
                legalMoves[x+1][y+1] = 1;

        }

        */

    }


}
