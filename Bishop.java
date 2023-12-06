public class Bishop extends Piece{

    public Bishop(int a, int b, boolean c){
        super(a, b, c);
    }

    boolean isEmpty(){
        return false;
    }

    public void refreshLegalMoves(Piece[][] board){

        resetLegalMoves();

        //Checks path up and to the right
        for(int x = coordinates[0] + 1, y = coordinates[1] + 1; x > 0 && y > 0; x++, y++)
            if( board[x][y].isEmpty())
                legalMoves[x][y] = 1;
            else if(board[x][y].isWhite != isWhite ) {
                legalMoves[x][y] = 1;
                break;
            }
            else
                break;

    }

}
