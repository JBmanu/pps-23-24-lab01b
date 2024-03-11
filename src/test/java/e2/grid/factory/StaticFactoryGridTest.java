package e2.grid.factory;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import e2.grid.Grid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StaticFactoryGridTest {

    public static final int SIZE = 5;
    public static final int ONE_MINE = 1;

    @Test
    public void canCreateFactory() {
        final Grid grid = StaticFactoryGrid.createOneMineInUpLeftCorner(SIZE);
    }

    @Test
    public void testMineInUpLeftCorner() {
        final Grid grid = StaticFactoryGrid.createOneMineInUpLeftCorner(SIZE);
        final Position position = new SimplePosition(0, 0);
        assertTrue(grid.isMine(position));
        assertEquals(ONE_MINE, grid.totalMines());
    }

    @Test
    public void testEasyGrid() {
        final Grid grid = StaticFactoryGrid.createEasyGrid(SIZE);
        final int totalMines = SIZE * SIZE % StaticFactoryGrid.EASY_PERCENTAGE_OF_MINES;
        assertEquals(totalMines, grid.totalMines());
    }

    @Test
    public void testMediumGrid() {
        final Grid grid = StaticFactoryGrid.createMediumGrid(SIZE);
        final int totalMines = SIZE * SIZE % StaticFactoryGrid.MEDIUM_PERCENTAGE_OF_MINES;
        assertEquals(totalMines, grid.totalMines());
    }

    @Test
    public void testHardGrid() {
        final Grid grid = StaticFactoryGrid.createHardGrid(SIZE);
        final int totalMines = SIZE * SIZE % StaticFactoryGrid.HARD_PERCENTAGE_OF_MINES;
        assertEquals(totalMines, grid.totalMines());
    }
}
