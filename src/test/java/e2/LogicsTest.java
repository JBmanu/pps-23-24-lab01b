package e2;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicsTest {

    public static final int SIZE = 5;
    public static final Position MINE_POSITION = new SimplePosition(0, 0);
    public static final Position FREE_POSITION = new SimplePosition(0, 1);
    private Logics logics;

    @BeforeEach
    public void canCreateLogics() {
        this.logics = new LogicsImpl(SIZE);
    }

    @Test
    public void testOnePositionOfMine() {
        final boolean isMinePosition = this.logics.isMine(MINE_POSITION);
        final boolean isFreePosition = this.logics.isMine(FREE_POSITION);
        assertTrue(isMinePosition);
        assertFalse(isFreePosition);
    }

    @Test
    public void loseGame() {
        final boolean hasLose = this.logics.hasLose(MINE_POSITION);
        assertTrue(hasLose);
    }

}
