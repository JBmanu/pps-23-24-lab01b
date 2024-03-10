package e1.piece;

import e1.piece.movement.MovementLogic;
import e1.piece.position.Position;

public interface Piece {

    IdPiece id();

    Position position();
    MovementLogic movementLogic();

    void setPosition(final Position position);
    void setMovement(final MovementLogic movementLogic);

    boolean isPossibleMove(final Position destination);

    boolean equalId(final IdPiece id);

    boolean equalsPosition(final Position position);
    boolean equalsPosition(final Piece otherPiece);
}
