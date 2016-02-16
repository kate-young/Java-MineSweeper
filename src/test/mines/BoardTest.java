package mines;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void surroundingTopCorner() {
        Board board = new Board(5,5);
        assertEquals(board.getSurrounding(board.getField(0,0)).size(), 3);
    }

    @Test
    public void surroundingBottomCorner() {
        Board board = new Board(5,5);
        assertEquals(board.getSurrounding(board.getField(4,4)).size(), 3);
    }

    @Test
    public void surroundingCenter() {
        Board board = new Board(5,5);
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
}