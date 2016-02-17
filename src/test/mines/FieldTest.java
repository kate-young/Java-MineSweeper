package mines;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by KY025863 on 2/13/2016.
 */
public class FieldTest {

    @Test
    public void testIsRevealed() throws Exception {
        Field field = new Field(0, 0);
        assertFalse(field.isRevealed());
    }

    @Test
    public void testReveal() throws Exception {
        Field field = new Field(0,0);
        field.reveal();
        assertTrue(field.isRevealed());
    }

    @Test
    public void testIsMine() throws Exception {
        Field field = new Field(0,0);
        assertFalse(field.isMine());
    }

    @Test
    public void testAddMine() throws Exception {
        Field field = new Field(0,0);
        field.addMine();
        assertTrue(field.isMine());
    }
    @Test
    public void surroundingTopCorner() {
        Board board = new Board();
        assertEquals(board.getField(0,0).getSurrounding().size(), 3);
    }

    @Test
    public void surroundingBottomCorner() {
        Board board = new Board();
        assertEquals(board.getField(19,19).getSurrounding().size(), 3);
    }

    @Test
    public void surroundingCenter() {
        Board board = Board.getInstance();
        Field field = board.getField(1,1);
        assertTrue("Contains top left", field.getSurrounding()
                .contains(board.getField(0,0)));
        assertTrue("Contains top center", field.getSurrounding()
                .contains(board.getField(0,1)));
        assertTrue("Contains top right", field.getSurrounding()
                .contains(board.getField(0,2)));
        assertTrue("Contains left", field.getSurrounding()
                .contains(board.getField(1,0)));
        assertTrue("Contains right", field.getSurrounding()
                .contains(board.getField(1,2)));
        assertTrue("Contains bottom left", field.getSurrounding()
                .contains(board.getField(2,0)));
        assertTrue("Contains bottom center", field.getSurrounding()
                .contains(board.getField(2,1)));
        assertTrue("Contains bottom right", field.getSurrounding()
                .contains(board.getField(2,2)));
    }

    @Test
    public void testGetSurroundingMineCount() {
        Board board = Board.getInstance();
        Field field = board.getField(0,0);
        assertEquals("With 0 surrounding mines", field.getSurroundingMineCount(), 0);
        board.getField(0,1).addMine();
        assertEquals("With 1 surrounding mine", field.getSurroundingMineCount(), 1);
        board.getField(1,1).addMine();
        assertEquals("With 2 surrounding mines", field.getSurroundingMineCount(), 2);
        board.getField(1,0).addMine();
        assertEquals("With 3 surrounding mines", field.getSurroundingMineCount(), 3);
    }
}