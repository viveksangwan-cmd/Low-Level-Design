import java.util.Scanner;

public class Game {
    private final Board board;
    private final WinningStrategy winningStrategy;
    private final int totalMoves;

    public Game(int boardSize){
        winningStrategy = new SimpleWinningStrategy(boardSize);
        board = new Board(boardSize);
        totalMoves = boardSize*boardSize;
    }

    public void startGame(){
        run();
    }

    private void run(){
        Scanner scanner = new Scanner(System.in);
        int winner = 0;
        boolean playerATurn = true;
        int remainingMoves = totalMoves;
        while(winner==0 && remainingMoves>0){
            remainingMoves--;
            String player = "A";
            if(!playerATurn) player = "B";
            System.out.println("Coordinates to mark "+player +" :");
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            Move move = new Move(r,c,(playerATurn)?1:-1);
            if(board.setMove(move)){
                playerATurn = !playerATurn;
                winningStrategy.evaluateWin(move);
            }
            winner = winningStrategy.getWinner();
        }

        if(winner == 0) {
            System.out.println("Draw");
            return;
        }
        if(winner==1){
            System.out.println("Player A wins");
        }else if(winner==-1){
            System.out.println("Player B wins");
        }else{
            System.out.println("Something is wrong");
        }
    }
}
