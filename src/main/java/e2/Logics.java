package e2;

import e1.piece.position.Position;

public interface Logics {

    boolean hasLose(final Position position);

    boolean hasWin(final Position position);

    boolean isMine(final Position position);

    int minesCountOf(final Position position);

    void showCell(final Position position);

    boolean isShowCell(final Position position);
}
