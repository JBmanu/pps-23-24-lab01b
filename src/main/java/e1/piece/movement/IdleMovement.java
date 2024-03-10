package e1.piece.movement;

import e1.piece.position.Position;

public class IdleMovement implements MovementLogic {
    @Override
    public boolean isPossibleMove(final Position from, final Position to) {
        this.checkPositionsAreNull(from, to);
        this.checkPositionsAreEquals(from, to);
        return false;
    }
}
