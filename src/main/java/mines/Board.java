package mines;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by KY025863 on 2/11/2016.
 */
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
}
