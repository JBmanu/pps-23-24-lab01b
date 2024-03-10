package e2;

import e1.piece.position.Position;

public interface Logics {

    boolean hasLose(final Position position);

    boolean hasWin();

    boolean isMine(final Position position);

    int minesCount(final Position position);

    void updateMinesCounter(final Position position);
}
