package e2.grid.cell;

import e1.piece.position.Position;

public interface Cell {

    void setMine();
    boolean equalsPosition(final Position position);
    boolean isMine();


}
