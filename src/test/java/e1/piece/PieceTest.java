package e1.piece;

import e1.piece.movement.KnightMovement;
import e1.piece.movement.MovementLogic;
import e1.piece.movement.PawnMovement;
import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
    public static final MovementLogic KNIGHT_MOVEMENT = new KnightMovement();
    public static final Position POSITION = new SimplePosition(0, 0);
    private Piece piece;

    @BeforeEach
    public void initializationPiece() {
        this.piece = StaticFactoryPiece.createKnight(POSITION);
    }

    @Test
    public void testCreatePieceWithNullParameters() {
        assertThrows(NullPointerException.class,
                () -> StaticFactoryPiece.createPiece(null, POSITION, KNIGHT_MOVEMENT));
        assertThrows(NullPointerException.class,
                () -> StaticFactoryPiece.createPiece(IdPiece.KNIGHT, null, KNIGHT_MOVEMENT));
        assertThrows(NullPointerException.class,
                () -> StaticFactoryPiece.createPiece(IdPiece.KNIGHT, POSITION, null));
    }

    @Test
    public void testReadId() {
        assertEquals(IdPiece.KNIGHT, this.piece.id());
    }

    @Test
    public void testEqualId() {
        assertTrue(this.piece.equalId(IdPiece.KNIGHT));
    }

    @Test
    public void testReadPosition() {
        assertEquals(POSITION, this.piece.position());
    }

    @Test
    public void testReadMovementLogic() {
        final boolean checkType = this.piece.movementLogic() instanceof KnightMovement;
        assertTrue(checkType);
    }

    @Test
    public void testSetNewPosition() {
        final Position newPosition = new SimplePosition(1, 1);
        this.piece.setPosition(newPosition);
        assertEquals(newPosition, this.piece.position());
    }

    @Test
    public void testSetNullPosition() {
        assertThrows(NullPointerException.class,
                () -> this.piece.setPosition(null));
    }

    @Test
    public void testSetNewMovementLogic() {
        final MovementLogic newMovementLogic = new PawnMovement();
        this.piece.setMovement(newMovementLogic);
        assertEquals(newMovementLogic, this.piece.movementLogic());
    }

    @Test
    public void testEqualsPosition() {
        final Piece newPiece = StaticFactoryPiece.createKnight(POSITION);
        assertTrue(newPiece.equalsPosition(this.piece));
        assertTrue(newPiece.equalsPosition(this.piece.position()));
    }
}
