package e2.grid;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {
    public static final int SIZE = 7;
    public static final int MINE_COUNT = 1;
    public static final Position MINE_POSITION = new SimplePosition(2, 1);
    public static final Position FREE_POSITION = new SimplePosition(2, 2);
    public static final Position CORNER_UP_LEFT_POSITION = new SimplePosition(0, 0);
    private static final Position CORNER_DOWN_RIGHT_POSITION = new SimplePosition(SIZE - 1, SIZE - 1);
    private Grid grid;

    @BeforeEach
    public void canCreateGrid() {
        this.grid = new GridImpl(SIZE);
    }

    @Test
    public void setMineInPosition() {
        this.grid.skillsLikeMineOf(MINE_POSITION);
    }

    @Test
    public void checkMinePosition() {
        this.grid.skillsLikeMineOf(MINE_POSITION);
        final boolean isMine = this.grid.isMine(MINE_POSITION);
        final boolean isFree = this.grid.isMine(FREE_POSITION);
        assertTrue(isMine);
        assertFalse(isFree);
    }

    @Test
    public void minesCountFromPosition() {
        this.grid.skillsLikeMineOf(MINE_POSITION);
        this.grid.setMineAroundOf(FREE_POSITION);
        final int minesCountFromPosition = this.grid.minesCountOf(FREE_POSITION);
        assertEquals(MINE_COUNT, minesCountFromPosition);
    }

    @Test
    public void minesCountInCornerUpLeftPosition() {
        final Position minePositionNearCornerUpLeft = new SimplePosition(0, 1);
        this.grid.skillsLikeMineOf(minePositionNearCornerUpLeft);
        this.grid.setMineAroundOf(CORNER_UP_LEFT_POSITION);
        final int minesCountFromPosition = this.grid.minesCountOf(CORNER_UP_LEFT_POSITION);
        assertEquals(MINE_COUNT, minesCountFromPosition);
    }

    @Test
    public void minesCountInCornerDownRightPosition() {
        final Position minePositionNearCornerDownRight
                = new SimplePosition(CORNER_DOWN_RIGHT_POSITION.x() - 1,CORNER_DOWN_RIGHT_POSITION.y());
        this.grid.skillsLikeMineOf(minePositionNearCornerDownRight);
        this.grid.setMineAroundOf(CORNER_DOWN_RIGHT_POSITION);
        final int minesCountFromPosition = this.grid.minesCountOf(CORNER_DOWN_RIGHT_POSITION);
        assertEquals(MINE_COUNT, minesCountFromPosition);
    }

    @Test
    public void haveBeenComputeMinesOfPosition() {
        assertFalse(this.grid.haveBeenComputeMinesOf(FREE_POSITION));
        this.grid.setMineAroundOf(FREE_POSITION);
        assertTrue(this.grid.haveBeenComputeMinesOf(FREE_POSITION));
    }


}
