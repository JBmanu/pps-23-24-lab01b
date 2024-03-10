package e2.grid;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import e2.grid.cell.Cell;
import e2.grid.cell.CellImpl;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GridImpl implements Grid {
    public static final int CONDITION_WINNER = 0;
    final Cell[][] grid;

    public GridImpl(final int size) {
        this.grid = new CellImpl[size][size];

        for (int row = 0; row < size; row++) {
            for (int colum = 0; colum < size; colum++) {
                final Position position = new SimplePosition(row, colum);
                this.grid[row][colum] = new CellImpl(position);
            }
        }

        this.skillsLikeMineOf(new SimplePosition(0, 0));
    }

    private Cell cellOf(final Position position) {
        final int x = position.x();
        final int y = position.y();
        return this.grid[x][y];
    }

    @Override
    public void skillsLikeMineOf(final Position position) {
        this.cellOf(position).skillsLikeMine();
    }

    @Override
    public boolean isMine(final Position position) {
        return this.cellOf(position).isMine();
    }

    private boolean checkBounds(final int row, final int colum) {
        final int length = this.grid.length;
        return row >= 0 && colum >= 0 && row < length && colum < length;
    }

    @Override
    public int minesCountOf(final Position position) {
        return this.cellOf(position).minesAround();
    }

    @Override
    public void setMinesAroundOf(final Position position) {
        final Cell cell = this.cellOf(position);

        final int y = position.y();
        final int x = position.x();
        final int startXCell = x - 1;
        final int endXCell = x + 1;
        final int startYCell = y - 1;
        final int endYCell = y + 1;

        final long minesAround = IntStream.rangeClosed(startXCell, endXCell)
                .boxed()
                .flatMap(row -> IntStream.rangeClosed(startYCell, endYCell)
                        .boxed()
                        .filter(colum -> this.checkBounds(row, colum))
                        .map(colum -> this.grid[row][colum]))
                .filter(Cell::isMine)
                .count();

        cell.setMinesAround((int)minesAround);
    }


    @Override
    public boolean haveBeenComputeMinesOf(final Position position) {
        return this.cellOf(position).haveBeenComputeMines();
    }

    @Override
    public boolean hasWin() {
        final long remainingCellsOfMineCalculation = Arrays.stream(this.grid).flatMap(Arrays::stream)
                .filter(cell -> !cell.isMine())
                .filter(cell -> !cell.haveBeenComputeMines())
                .count();

        return remainingCellsOfMineCalculation == CONDITION_WINNER;
    }


}
