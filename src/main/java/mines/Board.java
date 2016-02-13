package mines;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<int[], Field> fields;
    private final int rows;
    private final int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.fields = new HashMap<>();
        for(int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
                fields.put(new int[] {r, c}, new Field(r, c));
    }

    public Map<int[], Field> getFields() {
        return fields;
    }

    public Field getField(int row, int column) throws IllegalArgumentException {
        if(row < 0 || column < 0 || row > rows || column > columns) {
            throw new IllegalArgumentException("Field does not exist");
        }
        return fields.get(new int[]{row, column});
    }
}
