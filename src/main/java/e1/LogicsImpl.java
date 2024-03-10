package e1;

import e1.grid.GridChess;
import e1.grid.StaticFactoryGridChess;
import e1.piece.IdPiece;
import e1.piece.position.Position;
import e1.piece.position.SimplePosition;

import java.util.List;

public class LogicsImpl implements Logics {
    private final GridChess gridChess;

    public LogicsImpl(final int size, final Position knightPosition, final Position pawnPosition) {
        if (knightPosition.equals(pawnPosition)) throw new IllegalArgumentException();
        this.gridChess = StaticFactoryGridChess.createGridWithKnightAndIdlePawnWithPositions(size, knightPosition, pawnPosition);
    }

    public LogicsImpl(final int size) {
        this.gridChess = StaticFactoryGridChess.createGridWithKnightAndIdlePawn(size);
    }

    @Override
    public boolean hit(final int row, final int col) {
        final Position newPosition = new SimplePosition(row, col);
        this.gridChess.updatePiecePositionFromId(IdPiece.KNIGHT, newPosition);
        return this.gridChess.checkPiecesInOverlay(List.of(IdPiece.KNIGHT, IdPiece.PAWN));
    }

    @Override
    public boolean hasKnight(final int row, final int col) {
        final SimplePosition position = new SimplePosition(row, col);
        return this.gridChess.checkPiecePositionFromId(IdPiece.KNIGHT, position);
    }

    @Override
    public boolean hasPawn(final int row, final int col) {
        final SimplePosition position = new SimplePosition(row, col);
        return this.gridChess.checkPiecePositionFromId(IdPiece.PAWN, position);
    }
}
