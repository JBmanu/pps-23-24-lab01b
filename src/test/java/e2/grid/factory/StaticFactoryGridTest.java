package e2.grid.factory;

import e2.grid.Grid;
import org.junit.jupiter.api.Test;

public class StaticFactoryGridTest {

    @Test
    public void canCreateFactory() {
        int size = 5;
        Grid grid = StaticFactoryGrid.createGridOneMineInUpLeftCorner(size);
    }
}
