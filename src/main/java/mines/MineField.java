package mines;

import java.util.*;

public class MineField {
    private Set<Integer> randoms;
    private final int rows;
    private final int columns;
    private final int mines;

    public MineField(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        generateRandoms();
    }

    public void generateRandoms() {
        randoms = new TreeSet<>();

        Random rand = new Random();
        int max = rows * columns;
        while(randoms.size() < mines) {
           randoms.add(rand.nextInt( max + 1));
        }
    }

    protected Set<Integer> getRandoms() {
        return randoms;
    }
}
