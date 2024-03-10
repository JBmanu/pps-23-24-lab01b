package e2;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicsTest {

    public static final int SIZE = 7;
    private Logics logics;

    @BeforeEach
    public void canCreateLogics() {
        this.logics = new LogicsImpl(SIZE);
    }

    @Test
    public void testPositionOfMine() {
        final Position position = new SimplePosition(0, 0);
        final boolean isMinePosition = this.logics.isMine(position);
        assertTrue(isMinePosition);
    }





}
