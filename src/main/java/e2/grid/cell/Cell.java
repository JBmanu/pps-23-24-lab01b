package e2.grid.cell;

import e1.piece.position.Position;

public interface Cell {

    void skillsLikeMine();
    boolean isMine();

    void setMinesAround(final int mines);
    int minesAround();

    void showCell();
    boolean isShowCell();

    boolean equalsPosition(final Position position);

}
