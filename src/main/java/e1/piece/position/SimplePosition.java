package e1.piece.position;

import e1.Pair;

import java.util.Objects;

public class SimplePosition implements Position {
    private Pair<Integer, Integer> position;

    public SimplePosition(final Pair<Integer, Integer> position) {
        this.position = Objects.requireNonNull(position);
    }

    public SimplePosition(final int x, final int y) {
        this(new Pair<>(x, y));
    }

    public SimplePosition(final Position position) {
        this(new Pair<>(position.x(), position.y()));
    }

    @Override
    public int x() {
        return this.position.getX();
    }

    @Override
    public int y() {
        return this.position.getY();
    }

    @Override
    public void setPosition(final Position newPosition) {
        this.position = new Pair<>(newPosition.x(), newPosition.y());
    }

    @Override
    public void setX(final int newX) {
        this.position = new Pair<>(newX, this.y());
    }

    @Override
    public void setY(final int newY) {
        this.position = new Pair<>(this.x(), newY);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final SimplePosition that = (SimplePosition) o;
        return Objects.equals(this.position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.position);
    }
}
