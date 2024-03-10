package e1.grid;

import e1.piece.IdPiece;
import e1.piece.Piece;
import e1.piece.StaticFactoryPiece;
import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class GridChessTest {
    public static final int ONE_PIECE = 1;
    public static final int ONE_OCCURRENCE = 1;
    public static final Position POSITION = new SimplePosition(0, 0);
    public static final Piece KNIGHT = StaticFactoryPiece.createKnight(POSITION);
    public static final Position OUT_GRID_LEFT_UP_CORNER_POSITION = new SimplePosition(-1, -1);
    private static final Position OUT_GRID_RIGHT_DOWN_CORNER_POSITION = new SimplePosition(GridChess.MIN_SIZE, GridChess.MIN_SIZE);

    private GridChess gridChess;

    @BeforeEach
    public void canCreateGrid() {
        this.gridChess = StaticFactoryGridChess.createSimpleGridChess(GridChess.MIN_SIZE);
    }

    @Test
    public void testCheckBoundsWithNullPosition() {
        assertThrows(NullPointerException.class,
                () -> this.gridChess.checkBounds(null));
    }

    @Test
    public void testCreateGridMinSize() {
        final int underMinSize = GridChess.MIN_SIZE - 1;
        assertThrows(IllegalArgumentException.class,
                () -> StaticFactoryGridChess.createSimpleGridChess(underMinSize));
    }

    @Test
    public void testReadSize() {
        assertEquals(GridChess.MIN_SIZE, this.gridChess.size());
    }

    @Test
    public void testPositionOverGrid() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> this.gridChess.checkBounds(OUT_GRID_LEFT_UP_CORNER_POSITION));
    }

    @Test
    public void testPositionOverGridForAllGridSide() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> this.gridChess.checkBounds(OUT_GRID_LEFT_UP_CORNER_POSITION));
        assertThrows(IndexOutOfBoundsException.class,
                () -> this.gridChess.checkBounds(OUT_GRID_RIGHT_DOWN_CORNER_POSITION));
    }

    @Test
    public void testAddPiece() {
        this.gridChess.addPiece(KNIGHT);
        assertEquals(ONE_PIECE, this.gridChess.countPieces());
    }

    @Test
    public void testAddNull() {
        assertThrows(NullPointerException.class, () -> this.gridChess.addPiece(null));
    }

    @Test
    public void testReadPositionsAfterAddPiece() {
        this.gridChess.addPiece(KNIGHT);
        final List<Position> positions = this.gridChess.positionsPieces();
        assertEquals(ONE_PIECE, positions.size());
    }

    @Test
    public void testGenerateEmptyPosition() {
        this.gridChess.addPiece(KNIGHT);
        final Position positionGenerate = this.gridChess.generateEmptyPosition();
        final Piece fixedPiece = StaticFactoryPiece.createIdlePawn(positionGenerate);
        assertFalse(KNIGHT.equalsPosition(fixedPiece));
    }

    @Test
    public void testGenerateMultipleEmptyPosition() {
        final int numberPiece = 5;

        Stream.generate(() -> StaticFactoryPiece.createIdlePawn(POSITION))
                .limit(numberPiece)
                .forEach(piece -> {
                    piece.setPosition(this.gridChess.generateEmptyPosition());
                    this.gridChess.addPiece(piece);
                });

        final List<Position> positionsPieces = this.gridChess.positionsPieces();

        for (final Position position : positionsPieces) {
            final long occurrence = positionsPieces.stream()
                    .filter(positionCheck -> positionCheck.equals(position))
                    .count();
            assertEquals(ONE_OCCURRENCE, occurrence);
        }
    }

    @Test
    public void testFindFirstPiece() {
        this.gridChess.addPiece(KNIGHT);
        final Optional<Piece> piece = this.gridChess.findFirstPiece(IdPiece.KNIGHT);
        assertEquals(Optional.of(KNIGHT), piece);
    }

    @Test
    public void testNotFindFirstPiece() {
        final Optional<Piece> piece = this.gridChess.findFirstPiece(IdPiece.KNIGHT);
        assertEquals(Optional.empty(), piece);
    }

    @Test
    public void testUpdatePiecePositionFromId() {
        this.gridChess.addPiece(KNIGHT);
        final Optional<Piece> piece = this.gridChess.findFirstPiece(IdPiece.KNIGHT);
        final Position newPosition = new SimplePosition(1, 2);
        this.gridChess.updatePiecePositionFromId(IdPiece.KNIGHT, newPosition);
        assertNotEquals(Optional.empty(), piece);
        assertEquals(newPosition, piece.get().position());
    }

    @Test
    public void testUpdatePiecePositionFromIdWithPositionOutGrid() {
        this.gridChess.addPiece(KNIGHT);
        final Position newPosition = new SimplePosition(-1, -2);

        assertThrows(IndexOutOfBoundsException.class,
                () -> this.gridChess.updatePiecePositionFromId(IdPiece.KNIGHT, newPosition));
    }

    @Test
    public void testPiecePositionFromId() {
        this.gridChess.addPiece(KNIGHT);
        assertTrue(this.gridChess.checkPiecePositionFromId(IdPiece.KNIGHT, POSITION));
    }

}
