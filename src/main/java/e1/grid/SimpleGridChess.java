package e1.grid;

import e1.piece.IdPiece;
import e1.piece.Piece;
import e1.piece.position.Position;
import e1.piece.position.SimplePosition;

import java.util.*;

public class SimpleGridChess implements GridChess {
    private final int size;
    private final List<Piece> pieces;

    public SimpleGridChess(final int size) {
        this.checkMinSizeGrid(size);
        this.size = size;
        this.pieces = new ArrayList<>();
    }

    @Override
    public void checkBounds(final Position position) {
        final int x = position.x();
        final int y = position.y();
        if (x < ZERO || y < ZERO || x >= MIN_SIZE || y >= MIN_SIZE) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void addPiece(final Piece piece) {
        this.pieces.add(Objects.requireNonNull(piece));
    }

    @Override
    public int countPieces() {
        return this.pieces.size();
    }

    @Override
    public Optional<Piece> findFirstPiece(final IdPiece idPiece) {
        return this.pieces
                .stream()
                .filter(piece -> piece.equalId(idPiece))
                .findFirst();
    }

    @Override
    public List<Position> positionsPieces() {
        return this.pieces.stream().map(Piece::position).toList();
    }

    @Override
    public Position generateEmptyPosition() {
        final Random random = new Random();
        final int row = random.nextInt(this.size);
        final int colum = random.nextInt(this.size);
        final Position position = new SimplePosition(row, colum);

        return this.positionsPieces().contains(position) ? this.generateEmptyPosition() : position;
    }

    @Override
    public void updatePiecePositionFromId(final IdPiece idPiece, final Position newPosition) {
        this.checkBounds(newPosition);
        final Optional<Piece> optionalPiece = this.findFirstPiece(idPiece);
        optionalPiece
                .filter(piece -> piece.isPossibleMove(newPosition))
                .ifPresent(piece -> piece.setPosition(newPosition));
    }

    @Override
    public boolean checkPiecePositionFromId(final IdPiece idPiece, final Position position) {
        final Optional<Piece> optionalPiece = this.findFirstPiece(idPiece);
        return optionalPiece
                .map(piece -> piece.equalsPosition(position))
                .orElse(false);
    }

    @Override
    public boolean checkPiecesInOverlay(final List<IdPiece> idPieces) {
        final List<Piece> piecesMatch = idPieces.stream()
                .map(this::findFirstPiece)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        final Position position = piecesMatch.getFirst().position();
        return this.pieces.stream().allMatch(piece -> piece.equalsPosition(position));
    }


    @Override
    public int size() {
        return this.size;
    }
}
