package e2.grid.cell;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FreeCellTest {

    public static final Position POSITION = new SimplePosition(0, 0);
    private Cell cell;

    @BeforeEach
    public void canCreateCell() {
        this.cell = new FreeCell(POSITION);
    }

    @Test
    public void equalsPosition() {
        final boolean equalPosition = this.cell.equalsPosition(POSITION);
        assertTrue(equalPosition);
    }

    @Test
    public void skillsLikeMine() {
        this.cell.skillsLikeMine();
        assertTrue(this.cell.isMine());
    }

    @Test
    public void showCell() {
        assertFalse(this.cell.isShowCell());
        this.cell.showCell();
        assertTrue(this.cell.isShowCell());
    }

    @Test
    public void readMinesAround() {
        final int minesAround = 5;
        this.cell.setMinesAround(minesAround);
        assertEquals(minesAround, this.cell.minesAround());
    }

}
