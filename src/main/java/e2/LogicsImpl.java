package e2;

import e1.piece.position.Position;
import e2.grid.Grid;
import e2.grid.GridImpl;

public class LogicsImpl implements Logics {
    final Grid grid;

    public LogicsImpl(final int size) {
        this.grid = new GridImpl(size);
    }

    @Override
    public boolean hasLose(final Position position) {
        return this.isMine(position);
    }

    @Override
    public boolean hasWin() {
        return false;
    }

    @Override
    public boolean isMine(final Position position) {
        return this.grid.isMine(position);
    }

    @Override
    public int minesCountOf(final Position position) {
        return this.grid.minesCountOf(position);
    }

    @Override
    public void setMinesAroundOf(final Position position) {
        this.grid.setMineAroundOf(position);
    }

    @Override
    public boolean haveBeenComputeMinesOf(final Position position) {
        return this.grid.haveBeenComputeMinesOf(position);
    }
}
