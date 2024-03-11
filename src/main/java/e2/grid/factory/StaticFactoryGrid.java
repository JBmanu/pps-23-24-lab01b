package e2.grid.factory;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import e2.grid.Grid;
import e2.grid.GridImpl;

public final class StaticFactoryGrid {

    public static final int PERCENTAGE_OF_MINES = 20;

    private StaticFactoryGrid() { }

    public static Grid createOneMineInUpLeftCorner(final int size) {
        final Position position = new SimplePosition(0, 0);
        final Grid grid = new GridImpl(size);
        grid.setMineIn(position);
        return grid;
    }

    public static Grid createEasyGrid(final int size) {
        final Grid grid = new GridImpl(size);
        final GridDifficulty difficulty = new GridDifficultlyImpl();
        difficulty.initializationMines(PERCENTAGE_OF_MINES, grid);
        return grid;
    }
}
