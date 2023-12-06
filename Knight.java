public class Knight extends Piece{

    public Knight(int a, int b, boolean c) {
        super(a, b, c);
    }

    boolean isEmpty() {
        return false;
    }

    public void refreshLegalMoves(Piece[][] board) {

        int x = coordinates[0];
        int y = coordinates[1];

        //2 up 1 left
        if(x > 0 && y > 1)
            if(board[x - 1][y - 2].isEmpty() || board[x - 1][y - 2].isWhite != isWhite)
                legalMoves[x-1][y-2] = 1;

        //2 up 1 right
        if(x < 7 && y > 1)
            if(board[x + 1][y - 2].isEmpty() || board[x + 1][y - 2].isWhite != isWhite)
                legalMoves[x+1][y-2] = 1;

        //2 down 1 left
        if(x > 0 && y < 6)
            if(board[x - 1][y + 2].isEmpty() || board[x - 1][y + 2].isWhite != isWhite)
                legalMoves[x-1][y+2] = 1;

        //2 down 1 right
        if(x < 7 && y < 6)
            if(board[x + 1][y + 2].isEmpty() || board[x + 1][y + 2].isWhite != isWhite)
                legalMoves[x+1][y+2] = 1;

        //2 left 1 up
        if(x > 1 && y > 0)
            if(board[x - 2][y - 1].isEmpty() || board[x - 2][y - 1].isWhite != isWhite)
                legalMoves[x-2][y-1] = 1;

        //2 left 1 down
        if(x > 1 && y < 7)
            if(board[x - 2][y + 1].isEmpty() || board[x - 2][y + 1].isWhite != isWhite)
                legalMoves[x-2][y+1] = 1;

        //2 right 1 up
        if(x < 6 && y > 0)
            if(board[x + 2][y + 1].isEmpty() || board[x + 2][y + 1].isWhite != isWhite)
                legalMoves[x+2][y+1] = 1;

        //2 right 1 down
        if(x < 6 && y > 0)
            if(board[x + 2][y - 1].isEmpty() || board[x + 2][y - 1].isWhite != isWhite)
                legalMoves[x+2][y-1] = 1;
    }

}
