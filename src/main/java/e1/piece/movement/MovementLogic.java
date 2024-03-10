package e1.piece.movement;

import e1.piece.position.Position;

import java.util.Objects;

public interface MovementLogic {

    default void checkPositionsAreNull(final Position from, final Position to) {
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);
    }

    default void checkPositionsAreEquals(final Position from, final Position to) {
        if (from.equals(to)) {
            throw new IllegalArgumentException("Parameters are equals");
        }
    }

    boolean isPossibleMove(final Position from, final Position to);

}
