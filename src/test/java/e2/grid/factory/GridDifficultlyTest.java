package e2.grid.factory;

import e2.grid.Grid;
import e2.grid.GridImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridDifficultlyTest {

    public static final int PERCENTAGES_OF_MINES = 20;
    public static final int CENT = 100;
    private GridDifficulty difficulty;
    private Grid grid;

    @BeforeEach
    public void canCreateDifficultly() {
        this.difficulty = new GridDifficultlyImpl();
    }

    @Test
    public void initializationMines() {
        final int size = 4;
        this.grid = StaticFactoryGrid.emptyMines(size);
        this.difficulty.initializationMines(PERCENTAGES_OF_MINES, this.grid);
        final int minesTotal = (size * size) * PERCENTAGES_OF_MINES / CENT;
        assertEquals(minesTotal, this.grid.totalMines());
    }

}
