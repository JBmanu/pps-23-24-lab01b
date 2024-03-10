package e2.grid;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    public static final int SIZE = 5;
    public static final Position MINE_POSITION = new SimplePosition(2, 1);
    public static final Position FREE_POSITION = new SimplePosition(2, 2);
    public static final int MINE = 1;
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
        this.grid.setMine(MINE_POSITION);
        final boolean isMine = this.grid.isMine(MINE_POSITION);
        final boolean isFree = this.grid.isMine(FREE_POSITION);
        assertTrue(isMine);
        assertFalse(isFree);
    }

    @Test
    public void minesCountFromPosition() {
        this.grid.setMine(MINE_POSITION);
        final int minesCountFromPosition = this.grid.minesCountFrom(FREE_POSITION);
        assertEquals(MINE, minesCountFromPosition);
    }
}
