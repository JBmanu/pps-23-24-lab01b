package e1.piece.movement;

import e1.piece.position.Position;

public class KnightMovement implements MovementLogic {
    public static final int TOTAL_STEPS_TO_TAKE = 3;
    public static final int ZERO_DIFFERENCE = 0;

    @Override
    public boolean isPossibleMove(final Position from, final Position to) {
        this.checkPositionsAreNull(from, to);
        this.checkPositionsAreEquals(from, to);

        final int differenceOfX = to.x() - from.x();
        final int differenceOfY = to.y() - from.y();
        return (differenceOfX != ZERO_DIFFERENCE && differenceOfY != ZERO_DIFFERENCE &&
                Math.abs(differenceOfX) + Math.abs(differenceOfY) == TOTAL_STEPS_TO_TAKE);
    }
}
