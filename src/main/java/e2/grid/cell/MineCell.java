package e2.grid.cell;

import e1.piece.position.Position;

public class MineCell implements Cell {
    private boolean isShow;

    public MineCell(final Position position) {
        this.isShow = false;
    }

    @Override
    public boolean isMine() {
        return true;
    }

    @Override
    public void showCell() {
        this.isShow = true;
    }

    @Override
    public boolean isShowCell() {
        return this.isShow;
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
