package e2.grid.factory;

import e1.piece.position.Position;
import e1.piece.position.SimplePosition;
import e2.grid.Grid;
import e2.grid.GridImpl;

public final class StaticFactoryGrid {

    private StaticFactoryGrid() { }

    public static Grid createOneMineInUpLeftCorner(final int size) {
        final Position position = new SimplePosition(0, 0);
        final Grid grid = new GridImpl(size);
        grid.setMineIn(position);
        return grid;
    }
}
