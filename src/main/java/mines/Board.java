package mines;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<String, Field> fields;
    private final int rows;
    private final int columns;

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
}
