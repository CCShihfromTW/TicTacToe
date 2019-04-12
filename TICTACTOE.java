import java.util.Scanner;

public class TICTACTOE {
    public static void main(String[] args) {

        String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        displayBoard(board);

        while (true) {
            // The first player makes a move
            makeAMove(board, "X");
            displayBoard(board);
            if (isWon("X", board)) {
                System.out.println("X player won");
                break;
            } else if (isDraw(board)) {
                System.out.println("No winner");
                break;
            }
            // The second player makes a move
            makeAMove(board, "O");
            displayBoard(board);

            if (isWon("O", board)) {
                System.out.println("O player won");
                break;
            } else if (isDraw(board)) {
                System.out.println("No winner");
                break;
            }
        }
    }

    private static Boolean isWon(String mark, String[][] board) {
        boolean flag = false;
        //check col (left to right)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mark.equals(board[i][j])) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        flag = false;
        //check row (up to down)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mark.equals(board[j][i])) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        flag = false;
        int j = 2;
        //check Slash (left down to right up)
        for (int i = 0; i < 3; i++) {
            if (board[j][i].equals(mark)) {
                flag = true;
                j--;
            } else if (!board[j][i].equals(mark)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }
        flag = false;
        //check Slash (left up to right down)
        for (int i = 0; i < 3; i++) {
            if (board[i][i].equals(mark)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }
        flag = false;
        return flag;
    }

    private static boolean isDraw(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void displayBoard(String[][] board) {
        for (int i = 0; i < 3; i++) {
            System.out.println("--------------");
            for (int j = 0; j < 3; j++) {
                System.out.print(" | " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    private static void makeAMove(String[][] board, String mark) {
        int col;
        int row;
        System.out.print("Enter a row (0, 1, 2) for player " + mark + " : ");
        Scanner input = new Scanner(System.in);
        row = input.nextInt();
        while(row>2 || row<0){
            System.out.println("The row must be between 0,1 or 2.");
            System.out.print("Enter a row (0, 1, 2) for player " + mark + " : ");
            row = input.nextInt();
        }
        System.out.print("Enter a column(0, 1, 2) for player " + mark + " : ");
        col = input.nextInt();
        while(col>2 || col<0){
            System.out.println("The column must be between 0,1 or 2.");
            System.out.print("Enter a column (0, 1, 2) for player " + mark + " : ");
            col = input.nextInt();
        }
        if (!board[row][col].equals(" ")) {
            System.out.println("This cell is already occupied.Try a different cell");
            makeAMove(board, mark);
        } else if (board[row][col].equals(" ")) {
            board[row][col] = mark;
        }
    }
}
