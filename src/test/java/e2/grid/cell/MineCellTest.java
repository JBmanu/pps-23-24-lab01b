package e2.grid.cell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MineCellTest extends AbstractCellTest {

    @Override
    protected Cell initializationCellInBeforeTest() {
        return new MineCell(POSITION);
    }

    @Test
    public void isMine() {
        assertTrue(this.cell.isMine());
    }

}
