package e1.piece.movement;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class MovementTest {
    protected static final int ONE_STEP = 1;
    protected static final int TWO_STEP = 2;
    protected static final int THREE_STEP = 3;
    protected static final Position START_POSITION = new SimplePosition(0, 0);

    protected MovementLogic movementLogic;

    protected abstract MovementLogic createMovementForInitialization();

    @BeforeEach
    public void initializationMovement() {
        this.movementLogic = this.createMovementForInitialization();
    }

    @Test
    public void testMovementWithNullValues() {
        assertThrows(NullPointerException.class,
                () -> this.movementLogic.isPossibleMove(null, null));
        assertThrows(NullPointerException.class,
                () -> this.movementLogic.isPossibleMove(START_POSITION, null));
        assertThrows(NullPointerException.class,
                () -> this.movementLogic.isPossibleMove(null, START_POSITION));
    }

    @Test
    public void testMovementToEqualPosition() {
        assertThrows(IllegalArgumentException.class,
                () -> this.movementLogic.isPossibleMove(START_POSITION, START_POSITION));
    }
}
