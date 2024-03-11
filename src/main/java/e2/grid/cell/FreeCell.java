package e2.grid.cell;

import e1.piece.position.Position;

public class FreeCell implements Cell {
    private final Position position;
    private boolean isShowCell;

    public FreeCell(final Position position) {
        this.position = position;
        this.isShowCell = false;
    }

    @Override
    public boolean isMine() {
        return false;
    }

    @Override
    public void showCell() {
        this.isShowCell = true;
    }

    @Override
    public boolean isShowCell() {
        return this.isShowCell;
    }

    @Override
    public boolean equalsPosition(final Position position) {
        return this.position.equals(position);
    }

    @Override
    public Position position() {
        return this.position;
    }

}
