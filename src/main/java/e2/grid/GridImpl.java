package e2.grid;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import e2.grid.cell.Cell;
import e2.grid.cell.FreeCell;
import e2.grid.cell.MineCell;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

public class GridImpl implements Grid {
    public static final int CONDITION_WINNER = 0;
    public static final int MIN_BOUND = 0;
    private final List<Cell> cells;
    private final int size;

    public GridImpl(final int size) {
        this.cells = new ArrayList<>();
        this.size = size;
        for (int row = 0; row < size; row++) {
            for (int colum = 0; colum < size; colum++) {
                final Position position = new SimplePosition(row, colum);
                this.cells.add(new FreeCell(position));
            }
        }
    }

    private Optional<Cell> cellOf(final Position position) {
        return this.cells.stream()
                .filter(cell -> cell.equalsPosition(position))
                .findFirst();
    }

    private void setCellOf(final Position position, final Cell newCell) {
        this.cells.removeIf(cell -> cell.equalsPosition(position));
        this.cells.add(newCell);
    }

    @Override
    public void setMineIn(final Position position) {
        this.setCellOf(position, new MineCell(position));
    }

    @Override
    public boolean isMine(final Position position) {
        final Optional<Cell> cell = this.cellOf(position);
        return cell.isPresent() && cell.get().isMine();
    }

    private boolean checkBounds(final int row, final int colum) {
        return row >= MIN_BOUND && colum >= MIN_BOUND && row < this.size && colum < this.size;
    }

    private int computeCountMinesIn(final Position position) {
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
                        .map(colum -> new SimplePosition(row, colum))
                        .map(this::cellOf)
                        .filter(Optional::isPresent)
                        .map(Optional::get))
                .filter(Cell::isMine)
                .count();
        return (int) minesAround;
    }

    @Override
    public int countMinesIn(final Position position) {
        return this.computeCountMinesIn(position);
    }

    @Override
    public void showCell(final Position position) {
        this.cellOf(position).ifPresent(Cell::showCell);
    }


    @Override
    public boolean isShowCell(final Position position) {
        final Optional<Cell> cell = this.cellOf(position);
        return cell.isPresent() && cell.get().isShowCell();
    }

    @Override
    public boolean hasWin() {
        final long remainingCellsOfMineCalculation = this.cells.stream()
                .filter(cell -> !cell.isMine())
                .filter(cell -> !cell.isShowCell())
                .count();
        return remainingCellsOfMineCalculation == CONDITION_WINNER;
    }

    @Override
    public List<Position> freeCellsPositions() {
        return this.cells.stream()
                .filter(cell -> !cell.isMine())
                .map(Cell::position)
                .toList();
    }

    @Override
    public Position generateEmptyCell() {
        final Random random = new Random();
        final int row = random.nextInt(this.size());
        final int colum = random.nextInt(this.size());
        final Position position = new SimplePosition(row, colum);

        return !this.freeCellsPositions().contains(position) ? this.generateEmptyCell() : position;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int totalMines() {
        return (int) this.cells.stream()
                .filter(Cell::isMine)
                .count();
    }


}
