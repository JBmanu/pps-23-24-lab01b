package e1.piece.position;

public interface Position {

    int x();

    int y();

    void setPosition(final Position newPosition);

    void setX(final int newX);

    void setY(final int newY);
}
