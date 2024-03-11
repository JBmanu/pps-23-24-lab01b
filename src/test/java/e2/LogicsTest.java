package e2;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogicsTest {
    public static final int SIZE = 5;
    public static final int ONE_MINE = 1;
    public static final Position MINE_POSITION = new SimplePosition(0, 0);
    public static final Position FREE_POSITION = new SimplePosition(0, 1);
    private Logics logics;

    @BeforeEach
    public void canCreateLogics() {
        this.logics = new LogicsImpl(SIZE);
    }

    @Test
    public void testOnePositionOfMine() {
        final boolean isMinePosition = this.logics.isMine(MINE_POSITION);
        final boolean isFreePosition = this.logics.isMine(FREE_POSITION);
        assertTrue(isMinePosition);
        assertFalse(isFreePosition);
    }

    @Test
    public void loseGame() {
        final boolean hasLose = this.logics.hasLose(MINE_POSITION);
        assertTrue(hasLose);
    }

    @Test
    public void minesCountFromPosition() {
        this.logics.showCell(FREE_POSITION);
        assertEquals(ONE_MINE, this.logics.minesCountOf(FREE_POSITION));
    }

    @Test
    public void setMineAroundOfPosition() {
        this.logics.showCell(FREE_POSITION);
        assertTrue(this.logics.isShowCell(FREE_POSITION));
    }

    @Test
    public void winGame() {
        final int startOfFor = 0;
        for (int row = startOfFor; row < SIZE; row++) {
            for (int colum = startOfFor; colum < SIZE; colum++) {
                this.logics.showCell(new SimplePosition(row, colum));
            }
        }
        assertTrue(this.logics.hasWin(FREE_POSITION));
    }

}
