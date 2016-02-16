package mines;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MineFieldTest {

    @Test
    public void testGenerateRandoms() throws Exception {
        MineField mines = new MineField(10, 20, 15);
        assertEquals("It generates the correct number of random numbers", mines.getRandoms().size(), 15);
    }
}