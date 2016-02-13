package mines;

/**
 * Created by KY025863 on 2/11/2016.
 */
public class Field {
    private int row;
    private int column;
    private boolean mine;

    public Field(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isMine() {
        return mine;
    }
}
