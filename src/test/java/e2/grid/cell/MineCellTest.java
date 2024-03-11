package e2.grid.cell;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MineCellTest {

    public static final Position POSITION = new SimplePosition(0, 0);
    private Cell mineCell;

    @BeforeEach
    public void canCreateMineCell() {
        this.mineCell = new MineCell(POSITION);
    }

    @Test
    public void isMine() {
        assertTrue(this.mineCell.isMine());
    }

    @Test
    public void testShowCell() {
        assertFalse(this.mineCell.isShowCell());
        this.mineCell.showCell();
        assertTrue(this.mineCell.isShowCell());
    }

    @Test
    public void readPosition() {
        final boolean equalsPosition = this.mineCell.position().equals(POSITION);
        assertTrue(equalsPosition);
        assertTrue(this.mineCell.equalsPosition(POSITION));
    }
}
