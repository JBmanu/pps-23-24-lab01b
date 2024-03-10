package e1.piece.movement;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightMovementTest extends MovementTest {
    public static final Position UP_LEFT_L_POSITION =
            new SimplePosition(START_POSITION.x() - TWO_STEP, START_POSITION.y() - ONE_STEP);
    public static final Position UP_RIGHT_L_POSITION =
            new SimplePosition(START_POSITION.x() - TWO_STEP, START_POSITION.y() + ONE_STEP);
    public static final Position DOWN_LEFT_L_POSITION =
            new SimplePosition(START_POSITION.x() + TWO_STEP, START_POSITION.y() - ONE_STEP);
    private static final Position DOWN_RIGHT_L_POSITION =
            new SimplePosition(START_POSITION.x() + TWO_STEP, START_POSITION.y() + ONE_STEP);
    private static final Position LEFT_UP_L_POSITION =
            new SimplePosition(START_POSITION.x() - ONE_STEP, START_POSITION.y() - TWO_STEP);
    private static final Position LEFT_DOWN_L_POSITION =
            new SimplePosition(START_POSITION.x() + ONE_STEP, START_POSITION.y() - TWO_STEP);
    private static final Position RIGHT_UP_L_POSITION =
            new SimplePosition(START_POSITION.x() - ONE_STEP, START_POSITION.y() + TWO_STEP);
    private static final Position RIGHT_DOWN_L_POSITION =
            new SimplePosition(START_POSITION.x() + ONE_STEP, START_POSITION.y() + TWO_STEP);

    @Override
    protected MovementLogic createMovementForInitialization() {
        return new KnightMovement();
    }

    @Test
    public void testMovementLUpLeft() {
        final boolean isPossibleMove = this.movementLogic.isPossibleMove(START_POSITION, UP_LEFT_L_POSITION);
        assertTrue(isPossibleMove);
    }

    @Test
    public void testMovementLUpRight() {
        final boolean isPossibleMove = this.movementLogic.isPossibleMove(START_POSITION, UP_RIGHT_L_POSITION);
        assertTrue(isPossibleMove);
    }

    @Test
    public void testMovementLDownLeft() {
        final boolean isPossibleMove = this.movementLogic.isPossibleMove(START_POSITION, DOWN_LEFT_L_POSITION);
        assertTrue(isPossibleMove);
    }

    @Test
    public void testMovementLDownRight() {
        final boolean isPossibleMove = this.movementLogic.isPossibleMove(START_POSITION, DOWN_RIGHT_L_POSITION);
        assertTrue(isPossibleMove);
    }

    @Test
    public void testMovementLLeftUp() {
        final boolean isPossibleMove = this.movementLogic.isPossibleMove(START_POSITION, LEFT_UP_L_POSITION);
        assertTrue(isPossibleMove);
    }

    @Test
    public void testMovementLLeftDown() {
        final boolean isPossibleMove = this.movementLogic.isPossibleMove(START_POSITION, LEFT_DOWN_L_POSITION);
        assertTrue(isPossibleMove);
    }

    @Test
    public void testMovementLRightUp() {
        final boolean isPossibleMove = this.movementLogic.isPossibleMove(START_POSITION, RIGHT_UP_L_POSITION);
        assertTrue(isPossibleMove);
    }

    @Test
    public void testMovementLRightDown() {
        final boolean isPossibleMove = this.movementLogic.isPossibleMove(START_POSITION, RIGHT_DOWN_L_POSITION);
        assertTrue(isPossibleMove);
    }

    private final List<Position> gridPositionsOfCenterFromSize(final int size) {
        final int minSizeGrid = START_POSITION.x() - size;
        final int maxSizeGrid = START_POSITION.x() + size;
        final List<Position> positions = new ArrayList<>();

        for (int row = minSizeGrid; row <= maxSizeGrid; row++) {
            for (int coloum = minSizeGrid; coloum <= maxSizeGrid; coloum++) {
                positions.add(new SimplePosition(row, coloum));
            }
        }
        return positions;
    }

    @Test
    public void testGridPositionsOfOneStepFromCenter() {
        final List<Position> positions = this.gridPositionsOfCenterFromSize(ONE_STEP);
        positions.removeIf(START_POSITION::equals);

        positions.forEach(position ->
                assertFalse(this.movementLogic.isPossibleMove(START_POSITION, position)));
    }

    private void removeRightPositionsFromList(final List<Position> positions) {
        positions.removeIf(START_POSITION::equals);
        positions.removeIf(UP_LEFT_L_POSITION::equals);
        positions.removeIf(UP_RIGHT_L_POSITION::equals);
        positions.removeIf(DOWN_LEFT_L_POSITION::equals);
        positions.removeIf(DOWN_RIGHT_L_POSITION::equals);
        positions.removeIf(LEFT_UP_L_POSITION::equals);
        positions.removeIf(LEFT_DOWN_L_POSITION::equals);
        positions.removeIf(RIGHT_UP_L_POSITION::equals);
        positions.removeIf(RIGHT_DOWN_L_POSITION::equals);
    }

    @Test
    public void testGridPositionsOfTwoStepFromCenter() {
        final List<Position> positions = this.gridPositionsOfCenterFromSize(TWO_STEP);
        this.removeRightPositionsFromList(positions);

        positions.forEach(position ->
                assertFalse(this.movementLogic.isPossibleMove(START_POSITION, position)));
    }

    @Test
    public void testGridPositionsOfThreeStepFromCenter() {
        final List<Position> positions = this.gridPositionsOfCenterFromSize(THREE_STEP);
        this.removeRightPositionsFromList(positions);

        positions.forEach(position ->
                assertFalse(this.movementLogic.isPossibleMove(START_POSITION, position)));
    }


}
