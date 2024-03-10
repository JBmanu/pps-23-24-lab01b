package e1;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class LogicsTest {
    public static final int GRID_SIZE = 5;
    public static final int ONE_STEP = 1;
    public static final int TWO_STEP = 2;

    public static final Position LEFT_UP_CORNER_POSITION = new SimplePosition(0, 0);
    public static final Position CENTER_POSITION = new SimplePosition(2, 2);
    public static final Position RIGHT_BOTTOM_CORNER_POSITION = new SimplePosition(4, 4);

    private final Function<Position, Position> moveKnightLeftUp =
            position -> new SimplePosition(position.x() - TWO_STEP, position.y() + ONE_STEP);
    private final Function<Position, Position> moveKnightUpLeft =
            position -> new SimplePosition(position.x() - ONE_STEP, position.y() + TWO_STEP);
    private final Function<Position, Position> moveKnightRightBottom =
            position -> new SimplePosition(position.x() + TWO_STEP, position.y() + ONE_STEP);
    private final Function<Position, Position> moveKnightBottomRight =
            position -> new SimplePosition(position.x() + ONE_STEP, position.y() + TWO_STEP);

    private Logics logics;

    @Test
    public void test() {
        assert (true);
        // TODO: Add your test logic here
        // You can generate random inputs and assert the expected output
        // For example:
        // int result = Logic.someMethod(5, 10);
        // assertEquals(expectedResult, result);
    }

    private boolean checkInGridIfPresentWithBiPredicate(final BiPredicate<Integer, Integer> biPredicate) {
        final int startForValue = 0;
        boolean isPresent = false;

        for (int row = startForValue; row < GRID_SIZE; row++) {
            for (int coloum = startForValue; coloum < GRID_SIZE; coloum++) {
                isPresent = isPresent || biPredicate.test(row, coloum);
            }
        }

        return isPresent;
    }

    private boolean checkInGridIfPresentKnight() {
        return this.checkInGridIfPresentWithBiPredicate(this.logics::hasKnight);
    }

    private boolean checkInGridIfPresentPawn() {
        return this.checkInGridIfPresentWithBiPredicate(this.logics::hasPawn);
    }

    @Test
    public void testArePresentKnightAndPawn() {
        this.logics = new LogicsImpl(GRID_SIZE);
        final boolean checkHasKnight = this.checkInGridIfPresentKnight();
        final boolean checkHasPawn = this.checkInGridIfPresentPawn();

        assertTrue(checkHasKnight);
        assertTrue(checkHasPawn);
    }

    private Optional<Pair<Integer, Integer>> calculatePositionFrom(final BiPredicate<Integer, Integer> biPredicate) {
        final int startForValue = 0;
        Optional<Pair<Integer, Integer>> position = Optional.empty();

        for (int row = startForValue; row < GRID_SIZE; row++) {
            for (int coloum = startForValue; coloum < GRID_SIZE; coloum++) {
                if (biPredicate.test(row, coloum))
                    position = Optional.of(new Pair<>(row, coloum));
            }
        }

        return position;
    }

    private Optional<Pair<Integer, Integer>> calculateKnightPosition() {
        return this.calculatePositionFrom(this.logics::hasKnight);
    }

    private Optional<Pair<Integer, Integer>> calculatePawnPosition() {
        return this.calculatePositionFrom(this.logics::hasPawn);
    }

    @Test
    public void testKnightOverlayPawn() {
        this.logics = new LogicsImpl(GRID_SIZE);
        final Optional<Pair<Integer, Integer>> knightPosition = this.calculateKnightPosition();
        final Optional<Pair<Integer, Integer>> pawnPosition = this.calculatePawnPosition();

        assertNotEquals(Optional.empty(), knightPosition);
        assertNotEquals(Optional.empty(), pawnPosition);
        assertNotEquals(knightPosition, pawnPosition);
    }

    @Test
    public void testCreateGridWithZeroSize() {
        final int sizeZero = 0;

        assertThrows(IllegalArgumentException.class,
                () -> this.logics = new LogicsImpl(sizeZero, LEFT_UP_CORNER_POSITION, CENTER_POSITION));
    }

    @Test
    public void testCreateGridWithMinSize() {
        final int sizeOverMin = GRID_SIZE - 1;

        assertThrows(IllegalArgumentException.class,
                () -> this.logics = new LogicsImpl(sizeOverMin, LEFT_UP_CORNER_POSITION, CENTER_POSITION));
    }

    @Test
    public void testCanKnightAndPawnSetPosition() {
        this.logics = new LogicsImpl(GRID_SIZE, LEFT_UP_CORNER_POSITION, CENTER_POSITION);
        final boolean checkKnightPosition = this.logics.hasKnight(LEFT_UP_CORNER_POSITION.x(), LEFT_UP_CORNER_POSITION.y());
        final boolean checkPawnPosition = this.logics.hasPawn(CENTER_POSITION.x(), CENTER_POSITION.y());

        assertTrue(checkKnightPosition);
        assertTrue(checkPawnPosition);
    }

    @Test
    public void testCreateKnightAndPawnInOverlayPosition() {
        assertThrows(IllegalArgumentException.class,
                () -> this.logics = new LogicsImpl(GRID_SIZE, LEFT_UP_CORNER_POSITION, LEFT_UP_CORNER_POSITION));
    }

    @Test
    public void testCreateKnightAndPawnWithNullPosition() {
        assertThrows(NullPointerException.class,
                () -> this.logics = new LogicsImpl(GRID_SIZE, null, LEFT_UP_CORNER_POSITION));
        assertThrows(NullPointerException.class,
                () -> this.logics = new LogicsImpl(GRID_SIZE, LEFT_UP_CORNER_POSITION, null));
        assertThrows(NullPointerException.class,
                () -> this.logics = new LogicsImpl(GRID_SIZE, null, null));
    }

    @Test
    public void testCreateKnightAndPawnOutSideGrid() {
        final Position outSidePosition = new SimplePosition(GRID_SIZE, GRID_SIZE);

        assertThrows(IndexOutOfBoundsException.class,
                () -> this.logics = new LogicsImpl(GRID_SIZE, outSidePosition, LEFT_UP_CORNER_POSITION));
        assertThrows(IndexOutOfBoundsException.class,
                () -> this.logics = new LogicsImpl(GRID_SIZE, LEFT_UP_CORNER_POSITION, outSidePosition));
    }

    @Test
    public void testKnightNotHit() {
        this.logics = new LogicsImpl(GRID_SIZE, LEFT_UP_CORNER_POSITION, CENTER_POSITION);

        final int xDifferentPawnPosition = CENTER_POSITION.x() - ONE_STEP;
        final int yDifferentPawnPosition = CENTER_POSITION.y() - ONE_STEP;
        final boolean checkKnightHit = this.logics.hit(xDifferentPawnPosition, yDifferentPawnPosition);

        assertFalse(checkKnightHit);
    }

    @Test
    public void testKnightHit() {
        final Position knightPositionForHit = new SimplePosition(0, 1);
        this.logics = new LogicsImpl(GRID_SIZE, knightPositionForHit, CENTER_POSITION);
        final boolean checkKnightHit = this.logics.hit(CENTER_POSITION.x(), CENTER_POSITION.y());

        assertTrue(checkKnightHit);
    }

    @Test
    public void testBoundWhenSetKnightUpLeftCornerAndMoveDirectionLeft() {
        this.logics = new LogicsImpl(GRID_SIZE, LEFT_UP_CORNER_POSITION, CENTER_POSITION);
        final Position moveLeftUp = this.moveKnightLeftUp.apply(LEFT_UP_CORNER_POSITION);

        assertThrows(IndexOutOfBoundsException.class,
                () -> this.logics.hit(moveLeftUp.x(), moveLeftUp.y()));
    }

    @Test
    public void testBoundWhenSetKnightUpLeftCornerAndMoveDirectionUp() {
        this.logics = new LogicsImpl(GRID_SIZE, LEFT_UP_CORNER_POSITION, CENTER_POSITION);
        final Position moveUpLeft = this.moveKnightUpLeft.apply(LEFT_UP_CORNER_POSITION);

        assertThrows(IndexOutOfBoundsException.class,
                () -> this.logics.hit(moveUpLeft.x(), moveUpLeft.y()));
    }

    @Test
    public void testBoundWhenSetKnightBottomRightCornerAndMoveDirectionRight() {
        this.logics = new LogicsImpl(GRID_SIZE, RIGHT_BOTTOM_CORNER_POSITION, CENTER_POSITION);
        final Position moveRightBottom = this.moveKnightRightBottom.apply(RIGHT_BOTTOM_CORNER_POSITION);

        assertThrows(IndexOutOfBoundsException.class,
                () -> this.logics.hit(moveRightBottom.x(), moveRightBottom.y()));
    }

    @Test
    public void testBoundWhenSetKnightBottomRightCornerAndMoveDirectionBottom() {
        this.logics = new LogicsImpl(GRID_SIZE, RIGHT_BOTTOM_CORNER_POSITION, CENTER_POSITION);
        final Position moveBottomRight = this.moveKnightBottomRight.apply(RIGHT_BOTTOM_CORNER_POSITION);

        assertThrows(IndexOutOfBoundsException.class,
                () -> this.logics.hit(moveBottomRight.x(), moveBottomRight.y()));
    }

}
