package e2.grid.cell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class FreeCellTest extends AbstractCellTest {
    @Override
    protected Cell initializationCellInBeforeTest() {
        return new FreeCell(POSITION);
    }

    @Test
    public void isMine() {
        assertFalse(this.cell.isMine());
    }


}
