import java.util.Arrays;
import java.util.Scanner;

public class tictactoe {
    private static Scanner scanner;
    private static String player = "X";
    private static String ai = "O";
    public static String[][] board = {{"","",""},{"","",""},{"","",""}};


    public static boolean isBoardFull(String[][] board){
        for (String[] b : board){
            for (String i : b){
                if (i.equals(""))
                    return false;
            }
        }
        return true;
    }
    public static void printBoard(String letter) {
//        int[] board = {1,2,3,4,5,6,7, 8, 9};
        int count = 0;
        int var = 0;
        while (count < 7){
            if (count == 0 || count == 6){
                System.out.println("/---|---|---\\");
            }
            else if (count == 2 || count == 4){
                System.out.println("|------------|");
            }
            else {
                System.out.println("| " + Arrays.toString(board[var++])) ;

            }
            count++;
            }
    }

    private static boolean checkAcross(String[][] board){
        for (int row = 0; row < 3; row++){
            int col = 0;
            if (!board[row][col].equals("") && board[row][col].equals(board[row][col+1]) && board[row][col].equals(board[row][col+2])) {
                return true;
            }
        }
        return false;
    }
    private static boolean checkDown(String[][] board){
        for (int col = 0; col < 3; col++){
            int row = 0;
            if (!board[row][col].equals("") && board[row][col].equals(board[row+1][col]) && board[row][col].equals(board[row+2][col]))
                return true;
        }
        return false;
    }
    private static boolean checkDiagonals(String[][] board){
        if (!board[1][1].equals("") && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) ||
                !board[1][1].equals("") && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]))
            return true;
        return false;
    }
    public static boolean isGameOver(String[][] board){
        /*Game is over if across, down, diagonal and left diagonal all grand*/
        //Check across
        //Check down
        //Check diagonal
        //Check left-diagonal
        return checkAcross(board) || checkDown(board) || checkDiagonals(board);
    }

    public static String getWinner(String[][] board){
        String winner = "";
        if (checkAcross(board)){
            for (int row = 0; row < 3; row++){
                int col = 0;
                if (board[row][col].equals(board[row][col+1]) && board[row][col].equals(board[row][col+2])) {
                    winner = board[row][col];
                    break;
                }
            }
        }
        else if (checkDown(board)){
            for (int col = 0; col < 3; col++){
                int row = 0;
                if (board[row][col].equals(board[row+1][col]) && board[row][col].equals(board[row+2][col])) {
                    winner = board[row][col];
                    break;
                }
            }
        }
        else
            winner = board[1][1];
        return winner;
    }
    public static void autoplay(String[][] board){

    }

    public static void fillBoard(String letter, int index){
        if (index >= 1 && index <= 3){
            board[0][--index] = letter; //decrement first then subtract
        }
        else if(index >= 4 && index <= 6){

            board[1][--index%3] = letter;
        }
        else if (index >= 7 && index <= 9){
            board[2][--index%6] = letter;
        }
        else {
            System.out.println("Invalid position - Try Again");
        }
    }
    public static void main(String[] args) {
        int counter = 0;    //if odd - P1, else P2
        Scanner scan = new Scanner(System.in);
        while (!isBoardFull(board)){
            //Ask for player turn
            //Fill out the board with the corresponding letter
            if (counter == 0) {
                System.out.println("What position do you want to place letter at[1-9]");
                int pos = scan.nextInt();
                fillBoard(player, pos);
                counter = 1;

            } else{
                autoplay(board);//Pop the O in a certain position
              counter = 0;
            }


            if (isGameOver(board)) {
                System.out.println("We have a winner - " + getWinner(board));
                break;
            }

            printBoard(player);
        }
        if (!isGameOver(board))
            System.out.println("There is a tie ");

    }
}
