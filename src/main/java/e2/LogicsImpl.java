package e2;

import e1.piece.position.Position;

public class LogicsImpl implements Logics {

    public LogicsImpl(final int size) {

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
        return false;
    }

    @Override
    public int minesCount(final Position buttonPosition) {
        return 0;
    }

    @Override
    public void updateMinesCounter(final Position position) {

    }
}
