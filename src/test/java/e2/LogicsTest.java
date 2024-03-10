package e2;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicsTest {

    public static final int SIZE = 5;
    private Logics logics;

    @BeforeEach
    public void canCreateLogics() {
        this.logics = new LogicsImpl(SIZE);
    }

    @Test
    public void testOnePositionOfMine() {
        final Position minePosition = new SimplePosition(0, 0);
        final Position freePosition = new SimplePosition(0, 1);
        final boolean isMinePosition = this.logics.isMine(minePosition);
        final boolean isFreePosition = this.logics.isMine(freePosition);
        assertTrue(isMinePosition);
        assertFalse(isFreePosition);
    }


}
