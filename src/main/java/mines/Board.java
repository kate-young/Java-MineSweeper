package mines;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<String, Field> fields;
    private final int ROWS = 20;
    private final int COLUMNS = 20;
    private int mines;
    private MineField mineField;

    private static Board instance = null;

    protected Board() {
        generateFields();
    }

    public static Board getInstance() {
        if(instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public void generateFields() {
        this.fields = new HashMap<>();
        int counter = 0;
        Field field;

        for(int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLUMNS; c++) {
                field = new Field(r, c);
                this.fields.put(r + "_" + c, field);
                counter++;
            }
    }

    public void addMines(int mines) {
        mineField = new MineField(ROWS, COLUMNS, mines);
        int counter = 0;
        for(int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                if(mineField.getRandoms().contains(counter)) {
                    getField(r, c).addMine();
                }
                counter++;
            }
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
}
