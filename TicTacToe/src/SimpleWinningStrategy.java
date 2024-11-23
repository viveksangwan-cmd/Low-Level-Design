public class SimpleWinningStrategy implements WinningStrategy{
    private final int boardSize;
    private final int[] row;
    private final int[] col;
    private int diagonalValue;
    private int antiDiagonalValue;
    private int winner;


    public SimpleWinningStrategy(final int boardSize){
        this.boardSize = boardSize;
        this.row = new int[boardSize];
        this.col = new int[boardSize];
        this.antiDiagonalValue = 0;
        this.diagonalValue = 0;
        this.winner = 0;
    }

    @Override
    public int getWinner(){
        return this.winner;
    }

    @Override
    public int evaluateWin(Move move) {
        boolean win = false;
        final int currentRow = move.getRow();
        final int currentCol = move.getCol();
        this.row[currentRow] += move.getPlayerValue();
        this.col[currentCol] += move.getPlayerValue();
        if(currentCol==currentRow) this.diagonalValue += move.getPlayerValue();
        if(currentRow == (boardSize-1-currentCol)) this.antiDiagonalValue += move.getPlayerValue();

        boolean rowWin = Math.abs(this.row[currentRow]) == boardSize;
        boolean colWin = Math.abs(this.col[currentCol]) == boardSize;
        boolean diagonalWin = (move.getPlayerValue()*boardSize)==this.diagonalValue;
        boolean antiDiagonalWin = (move.getPlayerValue()*boardSize)==this.antiDiagonalValue;
        win = (rowWin || colWin || diagonalWin || antiDiagonalWin);
        if(win) winner = move.getPlayerValue();
        return winner;
    }
}
