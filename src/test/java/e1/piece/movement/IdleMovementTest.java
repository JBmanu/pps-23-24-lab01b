package e1.piece.movement;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class IdleMovementTest extends MovementTest {

    @Override
    protected MovementLogic createMovementForInitialization() {
        return new IdleMovement();
    }

    @Test
    public void testIsPossibleMove() {
        final Position toPosition = new SimplePosition(1, 1);
        final boolean isPossibleMove = this.movementLogic.isPossibleMove(START_POSITION, toPosition);
        assertFalse(isPossibleMove);
    }


}
