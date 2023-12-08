# JavaFinalProject

## Process of moving a piece
1. User selects piece in coordinates x1,y1 AND selects square to move to in coordinates x2,y2
2. Game class accesses pieceArray[x][x] 
3. If pieceArray[x1][y1].isEmpty() == false && pieceArray[x1][y1].isWhite() == whoseTurn 
4. Run pieceArray[x1][y1].refreshLegalMoves() 
5. If pieceArray[x1][y1].getLegalMoves(x2, y2) == 1 (if square user moved to is legal) 
6. Move piece (set (x2,y2) = pieceArray[x1][y1], set (x1,y1) = new Piece() ) 
7. If piece moved was a pawn, call pieceArray[x2][y2].hasMoved(true)

## Colby
- Make Move() function - described above
- Update move output to string data type
- Try to populate board w icons

## Gabe
- Enable castling
- Make check/checkmate functions
- Finish all pieces
- (Optional) Algebraic Chess Notation Feature
- 
## Observations for Move()
- Don't let piece move to the same spot it's already in 
- Check for illegal moves
- Check for checks