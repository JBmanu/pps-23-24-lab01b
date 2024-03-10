package e1.piece;

import e1.piece.movement.MovementLogic;
import e1.piece.position.Position;

import java.util.Objects;

public class SimplePiece implements Piece {
    private final IdPiece id;
    private MovementLogic movementLogic;
    private Position position;

    public SimplePiece(final IdPiece id, final Position position, final MovementLogic movementLogic) {
        this.id = Objects.requireNonNull(id);
        this.position = Objects.requireNonNull(position);
        this.movementLogic = Objects.requireNonNull(movementLogic);
    }

    @Override
    public IdPiece id() {
        return this.id;
    }

    @Override
    public Position position() {
        return this.position;
    }

    @Override
    public MovementLogic movementLogic() {
        return this.movementLogic;
    }

    @Override
    public void setPosition(final Position position) {
        this.position = Objects.requireNonNull(position);
    }

    @Override
    public void setMovement(final MovementLogic movementLogic) {
        this.movementLogic = Objects.requireNonNull(movementLogic);
    }

    @Override
    public boolean isPossibleMove(final Position destination) {
        return this.movementLogic.isPossibleMove(this.position, destination);
    }

    @Override
    public boolean equalId(final IdPiece id) {
        return this.id.equals(id);
    }

    @Override
    public boolean equalsPosition(final Position position) {
        return this.position.equals(position);
    }

    @Override
    public boolean equalsPosition(final Piece otherPiece) {
        return this.equalsPosition(otherPiece.position());
    }

}
