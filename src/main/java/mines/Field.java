package mines;

import java.util.ArrayList;
import java.util.List;

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

    public List<Field> getSurrounding() {
        Board board = Board.getInstance();
        List<Field> surrounding = new ArrayList<>();
        int top = row -  1;
        int bottom = row + 1;
        int left = column - 1;
        int right = column + 1;
        if(top > -1) {
            surrounding.add(board.getField(top, column));
            if(left > -1)
               surrounding.add(board.getField(top, left));
            if(right < board.getRows())
                surrounding.add(board.getField(top, right));
        }
        if( bottom < board.getRows()) {
            surrounding.add(board.getField(bottom, column));
            if(left > -1)
                surrounding.add(board.getField(bottom, left));
            if(right < board.getRows())
                surrounding.add(board.getField(bottom, right));
        }
        if( left > -1 )
            surrounding.add(board.getField(row, left));
        if( right < board.getColumns()) {
            surrounding.add(board.getField(row, right));
        }
        return surrounding;
    }

    public int getSurroundingMineCount() {
        int count = 0;
        for (Field f: getSurrounding() ) {
            if(f.isMine()) {
                count++;
            }
        }
        return count;
    }
}
