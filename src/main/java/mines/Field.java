package mines;

public class Field {
    private int row;
    private int column;
    private boolean mine;
    private boolean revealed;

    public Field(int row, int column) {
        this.row = row;
        this.column = column;
        this.mine = false;
        this.revealed = false;
    }

    public void addMine() {
        this.mine = true;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isMine() {
        return mine;
    }

    public void reveal() {
        if(!isRevealed()) {
            revealed = true;
        }
    }

    public boolean isRevealed() {
        return this.revealed;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

}
