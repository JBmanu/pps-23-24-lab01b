package e2.grid;

import e1.piece.position.Position;

public interface Grid {
    void skillsLikeMineOf(final Position position);

    boolean isMine(final Position position);

    int minesCountOf(final Position position);

    void setMineAroundOf(final Position position);

    boolean haveBeenComputeMinesOf(Position position);
}
