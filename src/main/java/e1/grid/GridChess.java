package e1.grid;

import e1.piece.IdPiece;
import e1.piece.Piece;
import e1.piece.position.Position;

import java.util.List;
import java.util.Optional;

public interface GridChess {
    int ZERO = 0;
    int MIN_SIZE = 5;

    default void checkMinSizeGrid(final int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException("Size too small, min 5");
        }
    }

    int size();
    void checkBounds(final Position position);
    void addPiece(final Piece piece);
    int countPieces();
    Optional<Piece> findFirstPiece(final IdPiece idPiece);
    List<Position> positionsPieces();
    Position generateEmptyPosition();

    void updatePiecePositionFromId(final IdPiece idPiece, final Position newPosition);

    boolean checkPiecePositionFromId(final IdPiece idPiece, final Position position);

    boolean checkPiecesInOverlay(final List<IdPiece> idPieces);
}
