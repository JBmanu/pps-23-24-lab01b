package e2.grid.cell;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {

    public static final Position POSITION = new SimplePosition(0, 0);
    private Cell cell;

    @BeforeEach
    public void canCreateCell() {
        this.cell = new CellImpl(POSITION);
    }

    @Test
    public void readPosition() {
        final boolean equalPosition = this.cell.position().equals(POSITION);
        assertTrue(equalPosition);
    }


}
