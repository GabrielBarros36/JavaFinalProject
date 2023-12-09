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

    public void refreshLegalMoves(Piece[][] board) {



        int y = coordinates[0]; //Vertical
        int x = coordinates[1]; //Horizontal

        //System.out.println("King pos: " + x + " " + y);

        //legalMoves[4][7] = 1;

        //Up
        if(y > 0)
            if(board[coordinates[0]-1][x].isEmpty() || board[coordinates[0]-1][x].isWhite != isWhite)
                legalMoves[coordinates[0]-1][x] = 1;

        //Down
        if(y < 7)
            if(board[coordinates[0]+1][x].isEmpty() || board[coordinates[0]+1][x].isWhite != isWhite)
                legalMoves[coordinates[0]+1][x] = 1;

        //Left
        if(x > 0)
            if(board[y][x-1].isEmpty() || board[y][x-1].isWhite != isWhite)
                legalMoves[y][x-1] = 1;

        //Right
        if(x < 7)
            if(board[y][x+1].isEmpty() || board[y][x+1].isWhite != isWhite)
                legalMoves[y][x+1] = 1;

        //Up left
        if(x > 0 && y > 0)
            if(board[y-1][x-1].isEmpty() || board[y-1][x-1].isWhite != isWhite)
                legalMoves[y-1][x-1] = 1;

        //Up right
        if(x < 7 && y > 0)
            if(board[y-1][x+1].isEmpty() || board[y-1][x+1].isWhite != isWhite)
                legalMoves[y-1][x+1] = 1;

        //Down left
        if(x > 0 && y < 7)
            if(board[y+1][x-1].isEmpty() || board[y+1][x-1].isWhite != isWhite)
                legalMoves[y+1][x-1] = 1;

        //Down right
        if(x < 7 && y < 7)
            if(board[y+1][x+1].isEmpty() || board[y+1][x+1].isWhite != isWhite)
                legalMoves[y+1][x+1] = 1;

    }


    //Only testing for now
    public boolean isCheckmate(Piece[][] board){

        if(isChecked(board)){

        }

        return false;

    }


}
