package e2.grid.factory;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import e2.grid.Grid;
import e2.grid.GridImpl;

public final class StaticFactoryGrid {

    public static final int EASY_PERCENTAGE_OF_MINES = 20;
    public static final int MEDIUM_PERCENTAGE_OF_MINES = 30;
    public static final int HARD_PERCENTAGE_OF_MINES = 40;

    private StaticFactoryGrid() {
    }

    public static Grid createOneMineInUpLeftCorner(final int size) {
        final Position position = new SimplePosition(0, 0);
        final Grid grid = new GridImpl(size);
        grid.setMineIn(position);
        return grid;
    }

    private static Grid gridOfDifficulty(final int size, final int percentageOfMines) {
        final Grid grid = new GridImpl(size);
        final GridDifficulty difficulty = new GridDifficultlyImpl();
        difficulty.initializationMines(percentageOfMines, grid);
        return grid;
    }

    public static Grid createEasyGrid(final int size) {
        return gridOfDifficulty(size, EASY_PERCENTAGE_OF_MINES);
    }

    public static Grid createMediumGrid(final int size) {
        return gridOfDifficulty(size, MEDIUM_PERCENTAGE_OF_MINES);
    }

    public static Grid createHardGrid(final int size) {
        return gridOfDifficulty(size, HARD_PERCENTAGE_OF_MINES);
    }
}
