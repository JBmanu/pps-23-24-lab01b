package e2.grid.cell;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MineCellTest {

    private Cell mineCell;

    @BeforeEach
    public void canCreateMineCell() {
        Position position = new SimplePosition(0, 0);
        mineCell = new MineCell(position);
    }

    @Test
    public void isMine() {
        assertTrue(this.mineCell.isMine());
    }
}
