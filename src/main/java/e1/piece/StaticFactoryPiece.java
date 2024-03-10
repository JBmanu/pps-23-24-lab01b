package e1.piece;

import e1.grid.GridChess;
import e1.piece.movement.KnightMovement;
import e1.piece.movement.IdleMovement;
import e1.piece.movement.MovementLogic;
import e1.piece.position.Position;

public final class StaticFactoryPiece {

    private StaticFactoryPiece() {
    }

    public static Piece createKnight(final Position position) {
        return new SimplePiece(IdPiece.KNIGHT, position, new KnightMovement());
    }

    public static Piece createIdlePawn(final Position position) {
        return new SimplePiece(IdPiece.PAWN, position, new IdleMovement());
    }


    public static Piece createKnightInGridInEmptyPosition(final GridChess grid) {
        final Position emptyPosition = grid.generateEmptyPosition();
        return createKnight(emptyPosition);
    }

    public static Piece createIdlePawnInGridInEmptyPosition(final GridChess grid) {
        final Position emptyPosition = grid.generateEmptyPosition();
        return createIdlePawn(emptyPosition);
    }

    public static Piece createPiece(final IdPiece idPiece, final Position position, final MovementLogic movementLogic) {
        return new SimplePiece(idPiece, position, movementLogic);
    }
}
