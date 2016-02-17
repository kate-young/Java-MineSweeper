package mines;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BoardTest {

    @Test
    public void constructorCreatesAMapOfRowXColumnFields() {
        Board board = new Board();
        assertEquals(board.getFields().size(), 400);
    }

    @Test
    public void testGetField() {
        Board board = new Board();
        assertEquals(board.getField(2,2).getRow(),2);
        assertEquals(board.getField(2,2).getColumn(), 2);
    }

    @Test
    public void testAddMines() {
        Board board = new Board();
        board.addMines(100);
        int count = 0;
        Field field;

        for(int r = 0; r < board.getRows(); r++) {
            for(int c = 0; c < board.getColumns(); c++) {
                field = board.getField(r, c);
                if (field.isMine()) {
                    count++;
                }
            }
        }
        assertEquals(100, count);
    }
}