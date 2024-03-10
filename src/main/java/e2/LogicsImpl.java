package e2;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import e2.grid.Grid;
import e2.grid.GridImpl;

public class LogicsImpl implements Logics {
    final Grid grid;

    public LogicsImpl(final int size) {
        this.grid = new GridImpl(size);
        this.grid.setMine(new SimplePosition(0, 0));
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
    public int minesCountFrom(final Position position) {
        return this.grid.minesCountFrom(position);
    }

    @Override
    public void updateMinesCounter(final Position position) {

    }
}
