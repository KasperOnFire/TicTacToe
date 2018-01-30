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
            turn(x, board, 1);
            turn(o, board, 2);
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
        playing = ((board[spot[0]][0] == id
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
}
