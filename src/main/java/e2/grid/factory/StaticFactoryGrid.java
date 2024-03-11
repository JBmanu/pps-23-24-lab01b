package e2.grid.factory;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import e2.grid.Grid;
import e2.grid.GridImpl;

public final class StaticFactoryGrid {

    public static final int EASY_PERCENTAGE_OF_MINES = 20;
    public static final int MEDIUM_PERCENTAGE_OF_MINES = 30;
    public static final int HARD_PERCENTAGE_OF_MINES = 40;

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
        difficulty.initializationMines(EASY_PERCENTAGE_OF_MINES, grid);
        return grid;
    }

    public static Grid createMediumGrid(final int size) {
        final Grid grid = new GridImpl(size);
        final GridDifficulty difficulty = new GridDifficultlyImpl();
        difficulty.initializationMines(MEDIUM_PERCENTAGE_OF_MINES, grid);
        return grid;
    }
}
