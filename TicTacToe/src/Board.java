public class Board {
    private final int boardSize;
    private final int[][] board;

    Board(final int boardSize){
        this.boardSize = boardSize;
        this.board = new int[boardSize][boardSize];
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
        return true;
    }
}

