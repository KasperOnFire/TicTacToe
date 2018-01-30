package Interface;

import java.util.Random;

public class PlayerImpl implements Player {

    private String[] name = {"Kasper", "David", "Tjalfe"};
    private String thisName;
    private Random RNGeesus;

    @Override
    public void init() {
        RNGeesus = new Random();
        thisName = name[RNGeesus.nextInt(3)];
    }

    @Override
    public int[] place() {
        return new int[]{RNGeesus.nextInt(3), RNGeesus.nextInt(3)};
    }

    @Override
    public void board(int[][] board) {
    }

    @Override
    public String getName() {
        return thisName;
    }

}
