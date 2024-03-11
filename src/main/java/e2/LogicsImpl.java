package e2;

import e1.piece.position.Position;
import e2.grid.Grid;
import e2.grid.factory.StaticFactoryGrid;

public class LogicsImpl implements Logics {
    final Grid grid;

    public LogicsImpl(final int size) {
        this.grid = StaticFactoryGrid.createOneMineInUpLeftCorner(size);
    }

    @Override
    public boolean hasLose(final Position position) {
        return this.isMine(position);
    }

    @Override
    public boolean hasWin(final Position position) {
        return this.grid.hasWin(position);
    }

    @Override
    public boolean isMine(final Position position) {
        return this.grid.isMine(position);
    }

    @Override
    public int minesCountOf(final Position position) {
        return this.grid.countMinesIn(position);
    }

    @Override
    public void showCell(final Position position) {
        this.grid.showCell(position);
    }

    @Override
    public boolean isShowCell(final Position position) {
        return this.grid.isShowCell(position);
    }
}
