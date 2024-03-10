package e1.grid;

import e1.piece.StaticFactoryPiece;
import e1.piece.position.Position;

public final class StaticFactoryGridChess {

    private StaticFactoryGridChess() {
    }

    public static GridChess createGridWithKnightAndIdlePawn(final int gridSize) {
        final GridChess gridChess = new SimpleGridChess(gridSize);
        gridChess.addPiece(StaticFactoryPiece.createKnightInGridInEmptyPosition(gridChess));
        gridChess.addPiece(StaticFactoryPiece.createIdlePawnInGridInEmptyPosition(gridChess));
        return gridChess;
    }

    public static GridChess createGridWithKnightAndIdlePawnWithPositions(final int gridSize, final Position knightPosition, final Position pawnPosition) {
        final GridChess gridChess = new SimpleGridChess(gridSize);
        gridChess.checkBounds(knightPosition);
        gridChess.checkBounds(pawnPosition);
        gridChess.addPiece(StaticFactoryPiece.createKnight(knightPosition));
        gridChess.addPiece(StaticFactoryPiece.createIdlePawn(pawnPosition));
        return gridChess;
    }

    public static GridChess createSimpleGridChess(final int gridSize) {
        return new SimpleGridChess(gridSize);
    }
}
