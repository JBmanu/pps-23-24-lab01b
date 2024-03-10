package e2.grid.cell;

import e1.piece.position.Position;

public interface Cell {

    void skillsLikeMine();
    boolean isMine();

    int minesAround();
    void setMinesAround(final int count);
    boolean haveBeenComputeMines();

    boolean equalsPosition(final Position position);

}
