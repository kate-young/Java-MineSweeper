package mines;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void surroundingTopCorner() {
        Board board = new Board();
        assertEquals(board.getSurrounding(board.getField(0,0)).size(), 3);
    }

    @Test
    public void surroundingBottomCorner() {
        Board board = new Board();
        assertEquals(board.getSurrounding(board.getField(19,19)).size(), 3);
    }

    @Test
    public void surroundingCenter() {
        Board board = new Board();
        assertTrue("Contains top left", board.getSurrounding(board.getField(1,1))
                .contains(board.getField(0,0)));
        assertTrue("Contains top center", board.getSurrounding(board.getField(1,1))
                .contains(board.getField(0,1)));
        assertTrue("Contains top right", board.getSurrounding(board.getField(1,1))
                .contains(board.getField(0,2)));
        assertTrue("Contains left", board.getSurrounding(board.getField(1,1))
                .contains(board.getField(1,0)));
        assertTrue("Contains right", board.getSurrounding(board.getField(1,1))
                .contains(board.getField(1,2)));
        assertTrue("Contains bottom left", board.getSurrounding(board.getField(1,1))
                .contains(board.getField(2,0)));
        assertTrue("Contains bottom center", board.getSurrounding(board.getField(1,1))
                .contains(board.getField(2,1)));
        assertTrue("Contains bottom right", board.getSurrounding(board.getField(1,1))
                .contains(board.getField(2,2)));
    }

    @Test
    public void testGetSurroundingMineCount() {
        Board board = new Board();
        Field field = board.getField(0,0);
        assertEquals("With 0 surrounding mines", board.getSurroundingMineCount(field), 0);
        board.getField(0,1).addMine();
        assertEquals("With 1 surrounding mine", board.getSurroundingMineCount(field), 1);
        board.getField(1,1).addMine();
        assertEquals("With 2 surrounding mines", board.getSurroundingMineCount(field), 2);
        board.getField(1,0).addMine();
        assertEquals("With 3 surrounding mines", board.getSurroundingMineCount(field), 3);
    }
}