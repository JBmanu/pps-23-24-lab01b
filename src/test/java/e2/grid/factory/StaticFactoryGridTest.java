package e2.grid.factory;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import e2.grid.Grid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StaticFactoryGridTest {

    public static final int SIZE = 5;

    @Test
    public void canCreateFactory() {
        final Grid grid = StaticFactoryGrid.createOneMineInUpLeftCorner(SIZE);
    }

    @Test
    public void testMineInUpLeftCorner() {
        final Grid grid = StaticFactoryGrid.createOneMineInUpLeftCorner(SIZE);
        final Position position = new SimplePosition(0, 0);
        assertTrue(grid.isMine(position));
        assertEquals(1, grid.totalMines());
    }
}
