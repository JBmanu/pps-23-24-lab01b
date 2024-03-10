package e2.grid;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridTest {

    public static final int SIZE = 5;
    public static final Position MINE_POSITION = new SimplePosition(0, 0);
    private Grid grid;

    @BeforeEach
    public void canCreateGrid() {
        this.grid = new GridImpl(SIZE);
    }

    @Test
    public void setMineInPosition() {
        this.grid.setMine(MINE_POSITION);
    }

    @Test
    public void checkMinePosition() {
        final Position freePosition = new SimplePosition(0, 1);
        this.grid.setMine(MINE_POSITION);
        final boolean isMine = this.grid.isMine(MINE_POSITION);
        final boolean isFree = this.grid.isMine(freePosition);
        assertTrue(isMine);
        assertFalse(isFree);
    }
}
