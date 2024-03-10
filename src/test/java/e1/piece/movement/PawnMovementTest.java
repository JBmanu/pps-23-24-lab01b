package e1.piece.movement;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnMovementTest extends MovementTest {
    public static final SimplePosition RIGHT_POSITION =
            new SimplePosition(START_POSITION.x(), START_POSITION.y() + ONE_STEP);
    public static final SimplePosition LEFT_POSITION =
            new SimplePosition(START_POSITION.x(), START_POSITION.y() - ONE_STEP);
    public static final Position UP_POSITION =
            new SimplePosition(START_POSITION.x() - ONE_STEP, START_POSITION.y());
    public static final Position DOWN_POSITION =
            new SimplePosition(START_POSITION.x() + ONE_STEP, START_POSITION.y());
    public static final Position TWO_UP_STEP_POSITION =
            new SimplePosition(START_POSITION.x() - TWO_STEP, START_POSITION.y());

    @Override
    protected MovementLogic createMovementForInitialization() {
        return new PawnMovement();
    }

    @Test
    public void testMovementOneStepDirectionUp() {
        final boolean isPossibleMoveUp = this.movementLogic.isPossibleMove(START_POSITION, UP_POSITION);
        assertTrue(isPossibleMoveUp);
    }

    @Test
    public void testMovementOneStepDirectionDown() {
        final boolean isPossibleMoveDown = this.movementLogic.isPossibleMove(START_POSITION, DOWN_POSITION);
        assertTrue(isPossibleMoveDown);
    }

    @Test
    public void testMovementMoreOneStepDirectionUp() {
        final boolean isPossibleMoveUp = this.movementLogic.isPossibleMove(START_POSITION, TWO_UP_STEP_POSITION);
        assertFalse(isPossibleMoveUp);
    }

    @Test
    public void testMovementDirectionLeft() {
        final boolean isPossibleMoveLeft = this.movementLogic.isPossibleMove(START_POSITION, LEFT_POSITION);
        assertFalse(isPossibleMoveLeft);
    }

    @Test
    public void testMovementDirectionRight() {
        final boolean isPossibleMoveLeft = this.movementLogic.isPossibleMove(START_POSITION, RIGHT_POSITION);
        assertFalse(isPossibleMoveLeft);
    }
}
