package e2.grid;

import org.junit.jupiter.api.Test;

public class GridTest {

    public static final int SIZE = 5;

    @Test
    public void canCreateGrid() {
        final Grid grid = new GridImpl(SIZE);
    }
}
