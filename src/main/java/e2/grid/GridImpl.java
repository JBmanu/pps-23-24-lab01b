package e2.grid;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import e2.grid.cell.Cell;
import e2.grid.cell.CellImpl;

public class GridImpl implements Grid {
    final Cell[][] grid;

    public GridImpl(final int size) {
        this.grid = new CellImpl[size][size];

        for (int row = 0; row < size; row++) {
            for (int colum = 0; colum < size; colum++) {
                final Position position = new SimplePosition(row, colum);
                this.grid[row][colum] = new CellImpl(position);
            }
        }
    }

    @Override
    public void setMine(final Position position) {
        final int y = position.y();
        final int x = position.x();
        this.grid[x][y].setMine();
    }

    @Override
    public boolean isMine(final Position position) {
        final int y = position.y();
        final int x = position.x();
        return this.grid[x][y].isMine();
    }
}
