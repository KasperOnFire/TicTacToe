package Game;

import Interface.Player;
import Interface.PlayerImpl;

public class TicTacToe {

    static boolean playing = true;
    static Player lastPlayed;

    public static void main(String[] args) {

        int[][] board = new int[3][3];

        Player x = new PlayerImpl();
        Player o = new PlayerImpl();

        x.init();
        o.init();

        while (playing) {
            turn(o, board, 1);
            printBoard(board);
            turn(x, board, 2);
            printBoard(board);
        }

        System.out.println("player " + lastPlayed.getName() + " wins!");
    }

    public static void turn(Player p, int[][] board, int id) {
        while (true) {
            p.board(board);
            int[] spot = p.place();
            if (spot[0] > 2 || spot[0] < 0 || spot[1] > 2 || spot[1] < 0) {
                continue;
            }
            if (board[spot[0]][spot[1]] != 0) {
                continue;
            }
            board[spot[0]][spot[1]] = id;
            lastPlayed = p;
            checkBoard(board, spot, id);
            break;
        }
    }

    public static void checkBoard(int[][] board, int[] spot, int id) {
        playing = !((board[spot[0]][0] == id
                && board[spot[0]][1] == id
                && board[spot[0]][2] == id)
                || (board[0][spot[1]] == id
                && board[1][spot[1]] == id
                && board[2][spot[1]] == id)
                || (board[0][0] == id
                && board[1][1] == id
                && board[2][2] == id)
                || (board[0][2] == id
                && board[1][1] == id
                && board[2][0] == id));
    }

    public static void printBoard(int[][] board) {
        for (int row = 0; row < 3;
                ++row) {
            for (int col = 0; col < 3; ++col) {
                printCell(board[row][col]); // print each of the cells
                if (col != 2) {
                    System.out.print("|");   // print vertical partition
                }
            }
            System.out.println();
            if (row != 2) {
                System.out.println("-----------"); // print horizontal partition
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();

    }

    public static void printCell(int content) {
        switch (content) {
            case 0:
                System.out.print("   ");
                break;
            case 1:
                System.out.print(" O ");
                break;
            case 2:
                System.out.print(" X ");
                break;
        }
    }
}
