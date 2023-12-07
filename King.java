public class King extends Piece{

    public boolean isChecked(Piece[][] board){

        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                if(!board[i][j].isEmpty() && board[i][j].getLegalMoves( coordinates[0], coordinates[1]) == 1 )
                    return true;

        return false;

    }

    //NOT FINISHED
    public boolean isCheckmate(Piece[][] board){

        if(isChecked(board)){



        }

        return false;

    }

    public char getType(){
        return 'K';
    }

}
