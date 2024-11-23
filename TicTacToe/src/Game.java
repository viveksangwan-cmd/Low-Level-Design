import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Board board;
    private void setUpGame(){
        board = new Board(3);
    }

    public void startGame(){
        setUpGame();
        Scanner scanner = new Scanner(System.in);
        int winner = 0;
        boolean playerATurn = true;
        while(winner==0){
            String player = "A";
            if(!playerATurn) player = "B";
            System.out.println("Coordinates to mark "+player +" :");
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            Move move = new Move(r,c,(playerATurn)?1:-1);
            if(board.setMove(move)){
                playerATurn = !playerATurn;
            }
            if(board.getWinner()!=0){
                winner = board.getWinner();
            }
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
