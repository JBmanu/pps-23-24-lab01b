package e1.piece.movement;

import e1.piece.position.Position;

public class PawnMovement implements MovementLogic {
    public static final int ONE_STEP = 1;

    private boolean isMovementOnAxisY(final Position from, final Position to) {
        return from.y() != to.y();
    }

    @Override
    public boolean isPossibleMove(final Position from, final Position to) {
        this.checkPositionsAreNull(from, to);
        this.checkPositionsAreEquals(from, to);
        if (this.isMovementOnAxisY(from, to)) {
            return false;
        }

        final int differenceOfMoveOnX = Math.abs(from.x() - to.x());
        return differenceOfMoveOnX <= ONE_STEP;
    }

}
