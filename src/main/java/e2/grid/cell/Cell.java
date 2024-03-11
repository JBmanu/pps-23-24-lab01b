package e2.grid.cell;

import e1.piece.position.Position;

public interface Cell {

    boolean isMine();
    void showCell();
    boolean isShowCell();

    Position position();
    boolean equalsPosition(final Position position);

}
