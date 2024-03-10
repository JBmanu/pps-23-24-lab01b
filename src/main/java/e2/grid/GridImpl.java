package e2.grid;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import e2.grid.cell.Cell;
import e2.grid.cell.CellImpl;

import java.util.stream.IntStream;

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
    public void skillsLikeMineOf(final Position position) {
        final int y = position.y();
        final int x = position.x();
        this.grid[x][y].skillsLikeMine();
    }

    @Override
    public boolean isMine(final Position position) {
        final int y = position.y();
        final int x = position.x();
        return this.grid[x][y].isMine();
    }

    private boolean checkBounds(final int row, final int colum) {
        final int length = this.grid.length;
        return row >= 0 && colum >= 0 && row < length && colum < length;
    }

    @Override
    public int minesCountOf(final Position position) {
        final int y = position.y();
        final int x = position.x();
        final int startCell = x - 1;
        final int endCell = y + 1;

        final var cells = IntStream.rangeClosed(startCell, endCell)
                .boxed()
                .flatMap(row -> IntStream.rangeClosed(startCell, endCell)
                        .filter(colum -> this.checkBounds(row, colum))
                        .filter(colum -> row != x || colum != y)
                        .mapToObj(colum -> this.grid[row][colum]))
                .toList();

        return (int) cells.stream().filter(Cell::isMine).count();
    }

    @Override
    public void setMineAroundOf(final Position position) {
        final int y = position.y();
        final int x = position.x();
        final Cell cell = this.grid[x][y];
        cell.setMinesAround(this.minesCountOf(position));
    }


}
