package e2.grid.factory;

import e2.grid.Grid;
import e2.grid.GridImpl;

public class StaticFactoryGrid {
    public static Grid createGridOneMineInUpLeftCorner(int size) {
        return new GridImpl(null);
    }
}
