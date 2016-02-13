package mines;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BoardTest {

    @Test
    public void constructorCreatesAMapOfRowXColumnFields() {
        Board board = new Board(10, 20);
        assertEquals(board.getFields().size(), 200);
    }

    @Test
    public void testGetField() {
        Board board = new Board(10, 20);
        Field field = board.getFields().get(new int[] {0, 0});
        assertEquals("Row is correct", field.getRow(),0);
        assertEquals("Column is correct", field.getColumn(), 0);
    }

}