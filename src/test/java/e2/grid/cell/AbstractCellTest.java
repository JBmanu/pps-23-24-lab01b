package e2.grid.cell;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractCellTest {
    protected static final Position POSITION = new SimplePosition(0, 0);
    protected Cell cell;

    protected abstract Cell initializationCellInBeforeTest();

    @BeforeEach
    public void createCell() {
        this.cell = this.initializationCellInBeforeTest();
    }

    @Test
    public void equalsPosition() {
        final boolean equalPosition = this.cell.equalsPosition(POSITION);
        assertTrue(equalPosition);
    }

    @Test
    public void testShowCell() {
        assertFalse(this.cell.isShowCell());
        this.cell.showCell();
        assertTrue(this.cell.isShowCell());
    }


}
