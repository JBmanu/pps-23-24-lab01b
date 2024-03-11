package e2.grid.cell;

import e1.piece.position.Position;

public class MineCell implements Cell {

    public MineCell(final Position position) {
    }

    @Override
    public boolean isMine() {
        return false;
    }

    @Override
    public void showCell() {

    }

    @Override
    public boolean isShowCell() {
        return false;
    }

    @Override
    public Position position() {
        return null;
    }

    @Override
    public boolean equalsPosition(final Position position) {
        return false;
    }
}
