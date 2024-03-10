package e2.grid;

import e1.piece.position.Position;

public interface Grid {
    void setMine(final Position position);

    boolean isMine(final Position position);

    int minesCountFrom(final Position position);

    void pushMinesCount(final Position position);
}
