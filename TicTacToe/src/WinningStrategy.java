public interface WinningStrategy {
    int evaluateWin(Move board);
    int getWinner();
}
