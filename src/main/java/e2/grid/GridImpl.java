package e2.grid;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import e2.grid.cell.Cell;
import e2.grid.cell.CellImpl;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public int minesCountFrom(final Position position) {
        final List<Cell> cells = new ArrayList<>();
        final int y = position.y();
        final int x = position.x();
        final int startCell = x - 1;
        final int endCell = y + 2;

        for (int row = startCell; row < endCell; row++) {
            for (int colum = startCell; colum < endCell; colum++) {
                if (row >= 0 && colum >= 0) {
                    cells.add(this.grid[row][colum]);
                }
            }
        }


        cells.remove(this.grid[x][y]);
        return (int) cells.stream().filter(Cell::isMine).count();
    }
}
