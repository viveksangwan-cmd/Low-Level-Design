public class Move {
    private final int row;
    private final int col;
    private final int playerValue;
    Move(final int row,final int col,final int playerValue){
        this.row = row;
        this.col = col;
        this.playerValue = playerValue;
    }

    public int getPlayerValue() {
        return playerValue;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol(){
        return this.col;
    }
}
