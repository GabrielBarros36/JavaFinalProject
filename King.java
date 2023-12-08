public class King extends Piece{

    public King(int a, int b, boolean c) {
        super(a, b, c);
    }

    boolean isEmpty() {
        return false;
    }

    public boolean isChecked(Piece[][] board){

        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                if(!board[i][j].isEmpty() && board[i][j].getLegalMoves( coordinates[0], coordinates[1]) == 1 )
                    return true;

        return false;

    }

    //Only testing for now
    public boolean isCheckmate(Piece[][] board){

        if(isChecked(board)){

        }

        return false;

    }


}
