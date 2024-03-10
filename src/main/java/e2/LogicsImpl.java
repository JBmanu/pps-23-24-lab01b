package e2;

import e1.piece.position.Position;

import java.util.List;

public class LogicsImpl implements Logics {
    final Position[][] grid;

    public LogicsImpl(final int size) {
        this.grid = new Position[size][size];
    }

    @Override
    public boolean hasLose(final Position position) {
        return false;
    }

    @Override
    public boolean hasWin() {
        return false;
    }

    @Override
    public boolean isMine(final Position buttonPosition) {
        return true;
    }

    @Override
    public int minesCount(final Position buttonPosition) {
        return 0;
    }

    @Override
    public void updateMinesCounter(final Position position) {

    }
}
