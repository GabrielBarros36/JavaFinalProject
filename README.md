# Chess Game

## Colby Leavitt & Gabriel Romanini de Barros
### COP 3252, Fall 2023, Bob Myers - Florida State University

In lieu of personal collaboration logs, graders can check our commits at https://github.com/GabrielBarros36/JavaFinalProject .

### Extra features

To the right of the chess board you'll find a drop-down menu labeled "Game : n" where 1 <= n <= 5. 
Games save automatically, and you can switch between as many as 5 games without losing your progress.

### Notes on gameplay
Moving pieces is not always seamless - you might have to click the piece you're trying to move and then the square you want to move it to a few times each.
Every legal move is supported by our program, so if it seems as though you can't make a move you should be allowed to make you might need to follow the advice laid out previously.

In general, every 2 clicks should be a move. If you accidentally click an empty square click it one more time. The program might get finnicky if you don't follow this but will ALWAYS work with every legal move with some persistence in clicking the piece and where you want to move it to.

On the bottom you'll find text indicating whose turn it is. If a king is checked, it will be indicated on the bottom as well.
Our program does not warn users about checkmates - you'll need to figure out if you've been checkmated every time your king is in check.

