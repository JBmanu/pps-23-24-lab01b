package e1.piece;

import e1.grid.GridChess;
import e1.grid.StaticFactoryGridChess;
import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StaticFactoryPieceTest {

    public static final Position POSITION = new SimplePosition(0, 0);
    public static final int SIZE_GRID = 5;
    public static final GridChess GRID = StaticFactoryGridChess.createSimpleGridChess(SIZE_GRID);

    @Test
    public void canCreateKnight() {
        assertNotNull(StaticFactoryPiece.createKnight(POSITION));
    }

    @Test
    public void canCreateIdlePawn() {
        assertNotNull(StaticFactoryPiece.createIdlePawn(POSITION));
    }

    @Test
    public void testFunctionsWithNullPosition() {
        final List<Method> methods = Arrays.stream(StaticFactoryPiece.class.getMethods())
                .filter(method -> method.getModifiers() == Method.PUBLIC).toList();

        methods.forEach(method -> assertThrows(NullPointerException.class,
                () -> method.invoke(null)));
    }

    @Test
    public void testCreateKnightInGridInEmptyPosition() {
        assertNotNull(StaticFactoryPiece.createKnightInGridInEmptyPosition(GRID));
    }

    @Test
    public void testCreateIdlePawnInGridInEmptyPosition() {
        assertNotNull(StaticFactoryPiece.createIdlePawnInGridInEmptyPosition(GRID));
    }
}
