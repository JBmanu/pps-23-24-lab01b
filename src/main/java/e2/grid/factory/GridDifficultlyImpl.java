package e2.grid.factory;

import e1.piece.position.Position;
import e2.grid.Grid;

public class GridDifficultlyImpl implements GridDifficulty {
    public static final int CENT = 100;

    @Override
    public void initializationMines(final int percentageOfMines, final Grid grid) {
        final int totalCells = grid.totalFreeCells();
        final int mines = totalCells * percentageOfMines / CENT;

        for (int counterMines = 0; counterMines < mines; counterMines++) {
            final Position emptyPosition = grid.generateEmptyCell();
            grid.setMineIn(emptyPosition);
        }
    }

}
