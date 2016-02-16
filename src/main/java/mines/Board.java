package mines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private Map<String, Field> fields;
    private final int ROWS = 20;
    private final int COLUMNS = 20;
    private final int MINES = 20;
    private MineField mineField;

    private static Board instance = null;

    protected Board() {
        mineField = new MineField(ROWS, COLUMNS, MINES);
        generateFields();
    }

    public static Board getInstance() {
        if(instance == null) {
            instance = new Board();
        }
        return instance;
    }

    private void generateFields() {
        this.fields = new HashMap<>();
        int counter = 0;
        Field field;

        for(int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLUMNS; c++) {
                field = new Field(r, c);
                this.fields.put(r + "_" + c, field);
                if(mineField.getRandoms().contains(counter)) {
                   field.addMine();
                }
                counter++;
            }
    }
    public Map<String, Field> getFields() {
        return fields;
    }

    public Field getField(int row, int column) throws IllegalArgumentException {
        String key = row + "_" + column;
        if(!this.fields.containsKey(key)) {
            throw new IllegalArgumentException("Field does not exist");
        }
        return this.fields.get(key);
    }

    public int getRows() {
        return ROWS;
    }

    public int getColumns() {
        return COLUMNS;
    }

    public List<Field> getSurrounding(Field field) {
        List<Field> surrounding = new ArrayList<>();
        int top = field.getRow() -  1;
        int bottom = field.getRow() + 1;
        int left = field.getColumn() - 1;
        int right = field.getColumn() + 1;
        if(top > -1) {
            surrounding.add(getField(top, field.getColumn()));
            if(left > -1)
               surrounding.add(getField(top, left));
            if(right < ROWS)
                surrounding.add(getField(top, right));
        }
        if( bottom < ROWS) {
            surrounding.add(getField(bottom, field.getColumn()));
            if(left > -1)
                surrounding.add(getField(bottom, left));
            if(right < ROWS)
                surrounding.add(getField(bottom, right));
        }
        if( left > -1 )
            surrounding.add(getField(field.getRow(), left));
        if( right < COLUMNS) {
            surrounding.add(getField(field.getRow(), right));
        }
        return surrounding;
    }

    public int getSurroundingMineCount(Field field) {
        int count = 0;
        for (Field f: getSurrounding(field) ) {
            if(f.isMine()) {
                count++;
            }
        }
        return count;
    }
}
