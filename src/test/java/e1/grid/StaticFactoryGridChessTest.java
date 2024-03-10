package e1.grid;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class StaticFactoryGridChessTest {

    public static final int SIZE = 5;

    @Test
    public void canUseStaticFactoryGridChess() {
        StaticFactoryGridChess.createGridWithKnightAndIdlePawn(SIZE);
    }

    @Test
    public void testCanCreateGridWithKnightAndIdlePawn() {
        Objects.requireNonNull(StaticFactoryGridChess.createGridWithKnightAndIdlePawn(SIZE));
    }

    @Test
    public void testCanCreateGridWithKnightAndIdlePawnWithPositions() {
        final Position knightPosition = new SimplePosition(0, 0);
        final Position pawnPosition = new SimplePosition(1, 1);
        Objects.requireNonNull(StaticFactoryGridChess
                .createGridWithKnightAndIdlePawnWithPositions(SIZE, knightPosition, pawnPosition));
    }
}
