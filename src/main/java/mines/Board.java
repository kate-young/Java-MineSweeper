package mines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private Map<String, Field> fields;
    private int rows;
    private int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        generateFields();
    }

    private void generateFields() {
        this.fields = new HashMap<>();
        for(int r = 0; r < this.rows; r++)
            for (int c = 0; c < this.columns; c++) {
                this.fields.put(r + "_" + c, new Field(r, c));
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
        return rows;
    }

    public int getColumns() {
        return columns;
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
            if(right < rows)
                surrounding.add(getField(top, right));
        }
        if( bottom < rows) {
            surrounding.add(getField(bottom, field.getColumn()));
            if(left > -1)
                surrounding.add(getField(bottom, left));
            if(right < rows)
                surrounding.add(getField(bottom, right));
        }
        if( left > -1 )
            surrounding.add(getField(field.getRow(), left));
        if( right < columns) {
            surrounding.add(getField(field.getRow(), right));
        }
        return surrounding;
    }
}
