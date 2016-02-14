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
        assertEquals(board.getField(2,2).getRow(),2);
        assertEquals(board.getField(2,2).getColumn(), 2);
    }

}