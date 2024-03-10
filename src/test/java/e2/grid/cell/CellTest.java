package e2.grid.cell;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    public static final Position POSITION = new SimplePosition(0, 0);
    private Cell cell;

    @BeforeEach
    public void canCreateCell() {
        this.cell = new CellImpl(POSITION);
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
    public void setMinesAround() {
        assertFalse(this.cell.haveBeenComputeMines());
        this.cell.setMinesAround(5);
        assertTrue(this.cell.haveBeenComputeMines());
        assertEquals(5, this.cell.minesAround());
    }

}
