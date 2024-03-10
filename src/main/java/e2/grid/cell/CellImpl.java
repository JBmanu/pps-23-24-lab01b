package e2.grid.cell;

import e1.piece.position.Position;

public class CellImpl implements Cell {
    private final Position position;

    public CellImpl(final Position position) {
        this.position = position;
    }


    @Override
    public boolean equalsPosition(final Position position) {
        return this.position.equals(position);
    }

    @Override
    public boolean isMine() {
        return false;
    }
}
