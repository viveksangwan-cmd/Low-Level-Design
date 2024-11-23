public class Board {
    private final int boardSize;
    private final int[][] board;
    private final int[] row;
    private final int[] col;
    private int winner;

    Board(final int boardSize){
        this.boardSize = boardSize;
        this.board = new int[boardSize][boardSize];
        this.row = new int[boardSize];
        this.col = new int[boardSize];
        winner = 0;
    }

    public int getWinner(){
        return this.winner;
    }

    public boolean setMove(final Move move){
        final int row = move.getRow();
        final int col = move.getCol();
        if(row<0 || col<0 || row>=boardSize || col>=boardSize) {
            System.out.println("Coordinates are out of board. Try Again");
            return false;
        }else if(board[row][col]!=0){
            System.out.println("Coordinates are already occupied. Try Again");
            return false;
        }
        board[row][col] = move.getPlayerValue();
        evaluateWin(move);
        return true;
    }

    private void evaluateWin(Move move){
        final boolean win = false;
        final int currentRow = move.getRow();
        final int currentCol = move.getCol();
        this.row[currentRow] += move.getPlayerValue();
        this.col[currentCol] += move.getPlayerValue();

        boolean rowWin = Math.abs(this.row[currentRow]) == boardSize;
        boolean colWin = Math.abs(this.col[currentCol]) == boardSize;
        boolean diagonalWin = true;
        boolean antiDiagonalWin = true;
        for(int i=0;i<boardSize;i++){
            if(board[i][i]!=move.getPlayerValue()) diagonalWin = false;
            if(board[boardSize-1-i][boardSize-1-i]!=move.getPlayerValue()) antiDiagonalWin = false;
            if(!diagonalWin && !antiDiagonalWin) break;
        }
        winner =  (rowWin || colWin || diagonalWin || antiDiagonalWin) ? move.getPlayerValue() : 0;
    }
}

