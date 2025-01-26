import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon && !board.isBoardFull()) {
            board.printBoard();
            System.out.println("Player " + board.getCurrentPlayer() + ", Enter your move(row and column: 0, 1, 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (board.makeMove(row, col) == true) {
                gameWon = board.checkWin();
                if (!gameWon) {
                    board.switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        board.printBoard();
        if (gameWon) {
            System.out.println("Player " + board.getCurrentPlayer() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
        scanner.close();
    }
}