package mines;

import org.junit.Test;

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
}