package mines;

public class MineField {
    private int[] randoms;
    private final int rows;
    private final int columns;
    private final int mines;

    public MineField(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
    }
}
