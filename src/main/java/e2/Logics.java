package e2;

import e1.piece.position.Position;

public interface Logics {

    boolean hasLose(final Position position);

    boolean hasWin();

    boolean isMine(final Position position);

    int minesCountOf(final Position position);

    void setMinesAroundOf(final Position position);

    boolean haveBeenComputeMinesOf(final Position position);
}
