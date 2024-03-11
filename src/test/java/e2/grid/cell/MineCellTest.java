package e2.grid.cell;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.Test;

public class MineCellTest {

    @Test
    public void canCreateMineCell() {
        Position position = new SimplePosition(0, 0);
        final Cell mineCell = new MineCell(position);
    }
}
