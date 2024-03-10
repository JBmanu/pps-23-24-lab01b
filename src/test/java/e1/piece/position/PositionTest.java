package e1.piece.position;

import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PositionTest {
    public static final int VALUE_X = 5;
    public static final int VALUE_Y = 3;
    public static final Position NEW_POSITION = new SimplePosition(0, 0);
    public static final Pair<Integer, Integer> PAIR_POSITION = new Pair<>(VALUE_X, VALUE_Y);
    private Position position;

    @BeforeEach
    public void canCreatePawn() {
        this.position = new SimplePosition(PAIR_POSITION);
    }

    @Test
    public void testCreateWithIntegerValues() {
        this.position = new SimplePosition(VALUE_X, VALUE_Y);
        assertEquals(VALUE_X, this.position.x());
        assertEquals(VALUE_Y, this.position.y());
    }

    @Test
    public void testCreateWithPosition() {
        this.position = new SimplePosition(NEW_POSITION);
        assertEquals(NEW_POSITION, this.position);
    }

    @Test
    public void testSetPositionAndRead() {
        this.position.setPosition(NEW_POSITION);
        assertEquals(NEW_POSITION, this.position);
    }

    @Test
    public void testSetXAndYInDifferentMethodAndRead() {
        final int newX = 8;
        final int newY = 9;
        this.position.setX(newX);
        this.position.setY(newY);

        assertEquals(newX, this.position.x());
        assertEquals(newY, this.position.y());
    }

    @Test
    public void testNotEqualsOtherPosition() {
        assertNotEquals(NEW_POSITION, this.position);
    }

    @Test
    public void testSetNewPositionAndChangeNewPosition() {
        final Position otherPosition = new SimplePosition(1, 1);
        this.position.setPosition(otherPosition);
        assertEquals(this.position, otherPosition);

        final int newX = 9;
        otherPosition.setX(newX);
        assertNotEquals(this.position, otherPosition);
    }
}
