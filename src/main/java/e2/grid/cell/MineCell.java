package e2.grid.cell;

import e1.piece.position.Position;

public class MineCell implements Cell {
    private final Position position;
    private boolean isShow;

    public MineCell(final Position position) {
        this.isShow = false;
        this.position = position;
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
        return this.position;
    }

    @Override
    public boolean equalsPosition(final Position position) {
        return this.position.equals(position);
    }
}
