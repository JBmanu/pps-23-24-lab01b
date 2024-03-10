package e2.grid.cell;

import e1.piece.position.Position;

public class CellImpl implements Cell {
    private final Position position;
    boolean isMine;

    public CellImpl(final Position position) {
        this.position = position;
        this.isMine = false;
    }


    @Override
    public void setMine() {
        this.isMine = true;
    }

    @Override
    public boolean equalsPosition(final Position position) {
        return this.position.equals(position);
    }

    @Override
    public boolean isMine() {
        return this.isMine;
    }
}
