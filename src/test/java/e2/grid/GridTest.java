package e2.grid;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import e2.grid.factory.StaticFactoryGrid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {
    public static final int SIZE = 7;
    public static final int ONE_MINE = 1;
    public static final Position MINE_POSITION = new SimplePosition(2, 1);
    public static final Position FREE_POSITION = new SimplePosition(2, 2);
    public static final Position CORNER_UP_LEFT_POSITION = new SimplePosition(0, 0);
    private static final Position CORNER_DOWN_RIGHT_POSITION = new SimplePosition(SIZE - 1, SIZE - 1);
    private Grid grid;

    @BeforeEach
    public void canCreateGrid() {
        this.grid = StaticFactoryGrid.createOneMineInUpLeftCorner(SIZE);
    }

    @Test
    public void setMineInPosition() {
        this.grid.setMineIn(MINE_POSITION);
    }

    @Test
    public void checkMinePosition() {
        this.grid.setMineIn(MINE_POSITION);
        final boolean isMine = this.grid.isMine(MINE_POSITION);
        final boolean isFree = this.grid.isMine(FREE_POSITION);
        assertTrue(isMine);
        assertFalse(isFree);
    }

    @Test
    public void minesCountFromPosition() {
        this.grid.setMineIn(MINE_POSITION);
        final int minesCountFromPosition = this.grid.countMinesIn(FREE_POSITION);
        assertEquals(ONE_MINE, minesCountFromPosition);
    }

    @Test
    public void minesCountInCornerUpLeftPosition() {
        final Position minePositionNearCornerUpLeft = new SimplePosition(0, 1);
        this.grid.setMineIn(minePositionNearCornerUpLeft);
        final int minesCountFromPosition = this.grid.countMinesIn(CORNER_UP_LEFT_POSITION);
        assertEquals(ONE_MINE, minesCountFromPosition);
    }

    @Test
    public void minesCountInCornerDownRightPosition() {
        final Position minePositionNearCornerDownRight
                = new SimplePosition(CORNER_DOWN_RIGHT_POSITION.x() - 1,CORNER_DOWN_RIGHT_POSITION.y());
        this.grid.setMineIn(minePositionNearCornerDownRight);
        final int minesCountFromPosition = this.grid.countMinesIn(CORNER_DOWN_RIGHT_POSITION);
        assertEquals(ONE_MINE, minesCountFromPosition);
    }

    @Test
    public void showCell() {
        assertFalse(this.grid.isShowCell(FREE_POSITION));
        this.grid.showCell(FREE_POSITION);
        assertTrue(this.grid.isShowCell(FREE_POSITION));
    }

    @Test
    public void winGame() {
        final int startOfFor = 0;
        for (int row = startOfFor; row < SIZE; row++) {
            for (int colum = startOfFor; colum < SIZE; colum++) {
                this.grid.showCell(new SimplePosition(row, colum));
            }
        }
        assertTrue(this.grid.hasWin(FREE_POSITION));
    }

    @Test
    public void testAutoExpanse() {
        this.grid = StaticFactoryGrid.emptyMines(SIZE);
        this.grid.showCell(FREE_POSITION);
        assertTrue(this.grid.hasWin(FREE_POSITION));
    }

    @Test
    public void testAutoExpandWhenHasMine() {
        final Position position = new SimplePosition(0, 1);
        this.grid.showCell(position);
        final boolean isShowOneCell = this.grid.totalShowCells() == 1;
        assertTrue(isShowOneCell);
    }

}
