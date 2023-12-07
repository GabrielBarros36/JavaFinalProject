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

        //If pawn is white
        if(isWhite){

            //If square 1 spot ahead is free
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
            if(board[x][y+1].isEmpty()){
                legalMoves[x][y+1] = 1;

                //If square 2 spots ahead is also free
                if(board[x][y+2].isEmpty())
                    legalMoves[x][y+2] = 1;

            }

            //If there's a piece to be captured in the left diagonal
            if(x > 0 && y > 0 && !board[x-1][y+1].isEmpty() && board[x-1][y+1].isWhite != isWhite)
                legalMoves[x-1][y+1] = 1;

            //If there's a piece to be captured in the right diagonal
            if(x < 7 && y > 0 && !board[x+1][y+1].isEmpty() && board[x+1][y+1].isWhite != isWhite)
                legalMoves[x+1][y+1] = 1;

        }

    }

    public char getType(){
        return 'P';
    }


}
